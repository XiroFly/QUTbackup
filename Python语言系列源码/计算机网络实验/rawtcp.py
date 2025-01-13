import socket

# 创建TCP套接字
tcp_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# 绑定到特定端口
tcp_socket.bind(('127.0.0.1', 12345))  # 在本地主机的12345端口监听

# 开始监听
tcp_socket.listen(1)

try:
    while True:
        # 接受连接
        conn, addr = tcp_socket.accept()
        
        # 接收数据
        data = conn.recv(1024)
        
        # 打印数据
        print("Received data:", data)
        
        # 关闭连接
        conn.close()

except KeyboardInterrupt:
    print("Exiting...")
finally:
    tcp_socket.close()
