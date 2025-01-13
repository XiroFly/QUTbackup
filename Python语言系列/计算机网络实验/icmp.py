# 在这个作业中，您将更好地理解因特网控制报文协议（ICMP）。
# 您会学习使用ICMP请求和响应消息实现Ping程序。
# Ping是一个网络应用程序，用于测试某个主机在IP网络中是否可访问。
# 它也用于测试计算机的网卡或测试网络延迟。
# 它通过向目标主机发送ICMP“回显”包并监听ICMP“回显”应答来工作
# 。“回显”有时称为"pong"。ping程序测量往返时间，记录数据包丢失，
# 并输出接收到的回显包的统计摘要（往返时间的最小值、最大值和平均值，以及在某些版本中的平均值的标准差）。
# 您的任务是用python开发自己的Ping程序。您的程序将使用ICMP，
# 但为了保持简单，将不完全遵循RFC 1739中的正式规范。请注意，
# 您只需要编写程序的客户端，因为服务器端所需的功能几乎内置于所有操作系统中。
# 您的Ping程序能将ping请求发送到指定的主机，间隔大约一秒钟。
# 每个消息包含一个带有时间戳的数据包。每个数据包发送完后，
# 程序最多等待一秒，用于接收响应。如果一秒后服务器没有响应，
# 那么客户端应假设ping数据包或pong数据包在网络中丢失（或者服务器已关闭）。

### 代码

# 1. 在“receiveOnePing”方法中，你需要获得ICMP_ECHO_REPLY结构并取出您需要的信息，
# 如校验和、序列号、生存时间（TTL）等。在尝试完成“receiveOnePing”方法之前先研究“sendOnePing”方法。
# 2. 您不必关心校验和，因为它已经在代码中给出了。
# 3. 这个作业要求使用原始的sockets。在某些操作系统中，您可能需要管理员/root权限才能运行你的Ping程序。
# 4. 有关ICMP的更多信息，请参见此编程练习的结尾部分。

### 测试Ping程序
# 首先，通过发送数据包到本地主机来测试你的客户端，主机地址：127.0.0.1。

# 然后，你应该看看你的Ping程序如何通过在不同大洲的pinging服务器在网络中工作。



### 代理服务器的Python代码框架

import socket
import os
import struct
import time
import select

ICMP_ECHO_REQUEST = 8

def checksum(data):
    # 计算校验和
    sum = 0
    countTo = (len(data) // 2) * 2

    count = 0
    while count < countTo:
        thisVal = data[count + 1] * 256 + data[count]
        sum = sum + thisVal
        sum = sum & 0xffffffff
        count = count + 2

    if countTo < len(data):
        sum = sum + data[len(data) - 1]
        sum = sum & 0xffffffff

    sum = (sum >> 16) + (sum & 0xffff)
    sum = sum + (sum >> 16)
    answer = ~sum
    answer = answer & 0xffff
    answer = answer >> 8 | (answer << 8 & 0xff00)
    return answer

def receive_one_ping(my_socket, ID, timeout, dest_addr):
    time_left = timeout
    while True:
        started_select = time.time()
        what_ready = select.select([my_socket], [], [], time_left)
        how_long_in_select = time.time() - started_select
        if what_ready[0] == []:
            return "Request timed out."
        
        time_received = time.time()
        rec_packet, addr = my_socket.recvfrom(1024)

        # 解析ICMP头
        icmp_header = rec_packet[20:28]
        type, code, checksum, packet_ID, sequence = struct.unpack("bbHHh", icmp_header)
        
        if packet_ID == ID:
            return time_received - time_sent

        time_left -= how_long_in_select
        if time_left <= 0:
            return "Request timed out."

def send_one_ping(my_socket, dest_addr, ID):
    # 构建 ICMP Echo Request 报文
    checksum_val = 0
    header = struct.pack("bbHHh", ICMP_ECHO_REQUEST, 0, checksum_val, ID, 1)
    data = struct.pack("d", time.time())
    checksum_val = checksum(header + data)
    if sys.platform == 'darwin':
        checksum_val = socket.htons(checksum_val) & 0xffff
    else:
        checksum_val = socket.htons(checksum_val)

    header = struct.pack("bbHHh", ICMP_ECHO_REQUEST, 0, checksum_val, ID, 1)
    packet = header + data

    my_socket.sendto(packet, (dest_addr, 1))

def ping(host, timeout=1):
    dest_addr = socket.gethostbyname(host)
    icmp = socket.getprotobyname("icmp")

    my_socket = socket.socket(socket.AF_INET, socket.SOCK_RAW, icmp)
    my_ID = os.getpid() & 0xFFFF

    send_one_ping(my_socket, dest_addr, my_ID)
    delay = receive_one_ping(my_socket, my_ID, timeout, dest_addr)

    my_socket.close()
    return delay

def main():
    host = "127.0.0.1"  # 测试本地主机
    timeout = 1
    print("Pinging " + host + " using Python:")
    print("")
    while True:
        delay = ping(host, timeout)
        if isinstance(delay, str):
            print(delay)
        else:
            print("Ping Response Time: %.6f seconds" % delay)
        time.sleep(1)

if __name__ == "__main__":
    main()


### 因特网控制报文协议（ICMP）

# ***ICMP Header***

# ICMP报头从IP报头的第160位开始（使用IP选项除外）。

# ![](image/ICMP.png)

# * Type - ICMP 类型。
# * Code - 给定ICMP类型的子类型。
# * Checksum - 用ICMP头和ICMP数据计算出来的错误校验和，计算时将本字段值作为0输入。
# * ID - ID值，应在回显的情况下返回。
# * Sequence - 序列值，应在回显的情况下返回。

# ***Echo Request***

# 回显请求是一个ICMP消息，其数据将在回显（"pong"）中接收回来。主机必须响应所有回显请求，并在回显响应中包含从请求消息中接收到的所有数据。

# * Type必须置为8。
# * Code必须置为0。
# * 客户机可以使用ID值和Sequence值来匹配响应和请求。实际上，大多数Linux系统都为每一个ping进程使用唯一ID值，Sequence值在该进程中是不断递增的。Windows使用一个固定ID值，该标识符在Windows版本之间变化，并且只在启动时重置Sequence值。
# * 接收到的回显响应必须完全包含回显请求中的数据。

# ***Echo Reply***
# 回显响应是用于响应回显请求而生成的ICMP消息，所有主机和路由器都必须实现该功能。

# * Type和Code必须置为0。
# * ID值和Sequence值用于让客户端匹配回显请求和回显响应。
# * 回显响应必须完全包含接收到的回显请求中的数据。