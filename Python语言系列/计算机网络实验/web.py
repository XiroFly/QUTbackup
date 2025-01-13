# 套接字编程作业1：Web服务器

# 在本实验中，您将学习Python中TCP连接的套接字编程的基础知识：如何创建套接字，将其绑定到特定的地址和端口，
# 以及发送和接收HTTP数据包。您还将学习一些HTTP首部格式的基础知识。

# 您将开发一个处理一个HTTP请求的Web服务器。您的Web服务器应该接受并解析HTTP请求，
# 然后从服务器的文件系统获取所请求的文件，创建一个由响应文件组成的HTTP响应消息，前面是首部行，
# 然后将响应直接发送给客户端。如果请求的文件不存在于服务器中，则服务器应该向客户端发送“404 Not Found”差错报文。

### 代码

#在文件下面你会找到Web服务器的代码框架。您需要填写这个代码。而且需要在标有
#Fill in start 和 # Fill in end的地方填写代码。另外，每个地方都可能需要不止一行代码。

### 运行服务器

# 将HTML文件（例如HelloWorld.html）放在服务器所在的目录中。运行服务器程序。
# 确认运行服务器的主机的IP地址（例如128.238.251.26）。从另一个主机，打开浏览器并提供相应的URL。例如：

# http://128.238.251.26:6789/HelloWorld.html

# “HelloWorld.html”是您放在服务器目录中的文件。还要注意使用冒号后的端口号。
# 您需要使用服务器代码中使用的端口号来替换此端口号。在上面的例子中，我们使用了端口号6789. 
# 浏览器应该显示HelloWorld.html的内容。如果省略“:6789”，浏览器将使用默认端口80，
# 只有当您的服务器正在端口80监听时，才会从服务器获取网页。
# 然后用客户端尝试获取服务器上不存在的文件。你应该会得到一个“404 Not Found”消息。
### Web服务器的Python代码框架
# 导入套接字模块
from socket import *

# 创建服务器套接字
serverSocket = socket(AF_INET, SOCK_STREAM) 

# 设置服务器地址和端口
serverPort = 6789
serverAddress = ('', serverPort)  # 使用空字符串表示可以接受任意地址的连接
serverSocket.bind(serverAddress)

# 开始监听连接请求
serverSocket.listen(1)

while True:     
    # 等待客户端连接
    print('Ready to serve...')     
    connectionSocket, addr = serverSocket.accept()  # 接受客户端连接
    
    try:         
        # 接收客户端发送的HTTP请求消息
        message = connectionSocket.recv(1024).decode()
        
        # 解析HTTP请求消息，获取请求的文件名
        # ['GET', '/index.html', 'HTTP/1.1']。然后 [1] 就表示取第二部分，
        filename = message.split()[1]                         
        print(filename)
        # 打开请求的文件
        f = open(filename[1:])
        
        # 读取文件内容
        outputdata = f.read()
        f.close()
        
        # 构造HTTP响应消息的首部行
        response_header = "HTTP/1.1 200 OK\r\n\r\n"
        
        # 发送HTTP响应消息的首部行到客户端
        connectionSocket.send(response_header.encode())
        
        # 发送请求的文件内容到客户端
        connectionSocket.sendall(outputdata.encode())
        
        # 关闭客户端连接
        connectionSocket.close()
    except IOError:
        # 请求的文件不存在，发送404 Not Found响应消息
        not_found_response = "HTTP/1.1 404 Not Found\r\n\r\n"
        
        connectionSocket.send(not_found_response.encode())
        
        # 关闭客户端连接
        connectionSocket.close()             
        
# 关闭服务器套接字
serverSocket.close()


### 可选练习

# 1. 目前，这个Web服务器一次只处理一个HTTP请求。请实现一个能够同时处理多个请求的多线程服务器。
# 使用线程，首先创建一个主线程，在固定端口监听客户端请求。当从客户端收到TCP连接请求时，它将通过另一个端口建立TCP连接，
# 并在另外的单独线程中为客户端请求提供服务。这样在每个请求/响应对的独立线程中将有一个独立的TCP连接。

# 2. 不使用浏览器，编写自己的HTTP客户端来测试你的服务器。您的客户端将使用一个TCP连接用于连接到服务器，
# 向服务器发送HTTP请求，并将服务器响应显示出来。您可以假定发送的HTTP请求将使用GET方法。
#    客户端应使用命令行参数指定服务器IP地址或主机名，服务器正在监听的端口，以及被请求对象在服务器上的路径。
# 以下是运行客户端的输入命令格式。 
#    > client.py server_host server_port filename