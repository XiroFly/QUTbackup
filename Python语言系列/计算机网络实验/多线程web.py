## 套接字编程作业4： 多线程Web代理服务器

# 在本实验中，您将了解Web代理服务器的工作原理及其基本功能之一 —— 缓存。

# 您的任务是开发一个能够缓存网页的小型Web代理服务器。
# 这是一个很简单的代理服务器，它只能理解简单的GET请求，但能够处理各种对象 —— 不仅仅是HTML页面，还包括图片。

# 通常，当客户端发出一个请求时，请求将被直接发送到Web服务器。
# 然后Web服务器处理该请求并将响应消息发送客户端。
# 为了提高性能，我们在客户端和Web服务器之间建立一个代理服务器。
# 现在，客户端发送的请求消息和Web服务器返回的响应消息都要经过代理服务器。
# 换句话说，客户端通过代理服务器请求对象。代理服务器将客户端的请求转发到Web服务器。
# 然后，Web服务器将生成响应消息并将其传递给代理服务器，代理服务器又将其发送给客户端。

# ![](image/ProxyServerDemo.png)

### 代码

# 您将在下面找到客户端的代码框架。 您需要完成代码框架。
# 需要您填写代码的地方标有`#Fill in start`和`#Fill in end`。 每个地方都需要填写至少一行代码。

### 运行代理服务器

# 使用命令行模式运行您的代理服务器程序，然后从您的浏览器发送一个网页请求，将IP地址和端口号指向代理服务器。
# 例如：http://localhost:8888/www.google.com
# 为了在独立的计算机上使用浏览器和代理服务器， 因此，时在运行代理服务器，
# 您需要将“localhost”更换为代理服务器的所在机器的IP地址。您还需要将“8888”替换您在代理服务程序中使用的端口号。

### 配置浏览器

# 您还可以直接配置您的Web浏览器以使用您的代理服务。 
# 具体取决于您的浏览器。在Internet Explorer中，
# 您可以在 工具 > Internet选项 > 连接选项卡 > LAN设置 中设置代理。 
# 在Netscape（包括衍生浏览器，如Mozilla）中，
# 您可以在 工具 > 选项 > 高级选项 > 网络选项 > 连接设置 中设置代理。 
# 在这两种情况下你都需要给出代理服务器的地址和端口号。
# 你首先要毫无问题地在同一台计算机上运行代理服务器和浏览器。这种方式下，使用代理服务器获取网页就只需提供页面的URL。
# 例如 http://www.google.com

### 要提交的内容

# 您需要提交提交完整的代理服务器代码和一张客户端屏幕截图，用于验证您是否
# 确实通过代理服务器获取了网页。

### 代理服务器的Python代码框架
from socket import *
import sys


# 创建服务器套接字，绑定到一个端口并开始监听
tcpSerSock = socket(AF_INET, SOCK_STREAM)

tcpSerSock.bind(("10.100.6.207", 8888))
tcpSerSock.listen(5)
# 填写结束.

while True:
    # 开始从客户端接收数据
    print('准备就绪...')
    tcpCliSock, addr = tcpSerSock.accept()
    print('收到来自客户端的连接:', addr)
    message = tcpCliSock.recv(1024).decode()  # 从客户端接收消息
    print(message)
    # 从消息中提取文件名
    filename = message.split()[1].split('/')[1]  # 修改这里以提取正确的文件名
    print(filename)
    fileExist = "false"
    filetouse = "/" + filename
    print(filetouse)

    try:
        # 检查缓存中是否存在文件
        f = open(filetouse[1:], "r")
        outputdata = f.readlines()
        fileExist = "true"
        # 代理服务器找到了缓存，生成响应消息
        tcpCliSock.send("HTTP/1.0 200 OK\r\n".encode())
        tcpCliSock.send("Content-Type:text/html\r\n".encode())
        # 填写开始.
        for i in range(len(outputdata)):
            tcpCliSock.send(outputdata[i].encode())
        # 填写结束.
        print('从缓存中读取')

    # 处理缓存中未找到文件的情况
    except IOError:
        if fileExist == "false":
            # 在代理服务器上创建一个套接字
            c = socket(AF_INET, SOCK_STREAM)
            hostn = '10.100.6.207'  # 修改这里以设置正确的目标主机IP
            print(hostn)
            try:
                # 连接到端口80上的套接字
                # 填写开始.
                c.connect((hostn, 6789))  # 修改这里以设置正确的目标主机端口
                # 填写结束.
                # 在此套接字上创建临时文件，并向端口6789请求客户端请求的文件
                fileobj = c.makefile('r', 0)
                fileobj.write("GET "+"http://" + filename + " HTTP/1.0\n\n")
                # 从缓冲区中读取响应
                # 填写开始.
                response = ""
                while True:
                    data = fileobj.readline()
                    if not data:
                        break
                    response += data
                # 填写结束.
                # 在缓存中为请求的文件创建一个新文件。
                # 同时将缓冲区中的响应发送到客户端套接字和缓存中的相应文件
                tmpFile = open("./" + filename, "wb")
                # 填写开始.
                tcpCliSock.send(response.encode())
                tmpFile.write(response.encode())
                # 填写结束.
            except Exception as e:
                print("错误:", e)
                print("非法请求")
        else:
            # 文件未在缓存中找到的HTTP响应消息
            # 填写开始.
            tcpCliSock.send("HTTP/1.0 404 Not Found\r\n".encode())
            tcpCliSock.send("Content-Type:text/html\r\n\r\n".encode())
            tcpCliSock.send("<html><body>Error 404: File not found</body></html>\r\n".encode())
            # 填写结束.

    # 关闭客户端和服务器套接字
    tcpCliSock.close()

# 关闭服务器套接字
tcpSerSock.close()
