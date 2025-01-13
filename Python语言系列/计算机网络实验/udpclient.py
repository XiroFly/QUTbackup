import socket
import time

# 服务器地址和端口号
server_address = ('localhost', 12000)

# 创建UDP套接字
client_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# 设置超时时间为1秒
client_socket.settimeout(1)

# 发送10次ping消息
for sequence_number in range(1, 11):
    # 获取当前时间
    send_time = time.time()
    
    # 构造消息
    message = f'Ping {sequence_number} {send_time}'
    
    try:
        # 发送消息到服务器
        client_socket.sendto(message.encode(), server_address)
        
        # 接收服务器响应
        response, server = client_socket.recvfrom(1024)
        print(response)
        # 计算往返时延
        rtt = time.time() - send_time
        
        # 输出响应和往返时延
        print(f'Response from server: {response.decode()}, RTT: {rtt:.6f} seconds')
        
    except socket.timeout:
        # 如果超时则输出“请求超时”
        print('Request timed out')

# 关闭套接字
client_socket.close()
