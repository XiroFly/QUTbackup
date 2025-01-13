from email.utils import formataddr
import smtplib
from email.mime.text import MIMEText
#加密，email 写文件形式，smtplib负责发送
from email.header import Header
import socket
from time import sleep
mail_host="smtp.qq.com"#邮箱地址
mail_user="2758726643@qq.com"#发件人
mail_pass="kgwvbasjwxukdfec"##
receivers=["2758726643@qq.com"]
sleep(10)
IP_ipv4=socket.gethostbyname(socket.gethostname())
message=MIMEText(IP_ipv4,"plain","utf-8")#text为主内容
message['From']=formataddr(["Xiro","2758726643@qq.com"])  # 括号里的对应发件人邮箱昵称、发件人邮箱账号
message['To']=formataddr(["Xiro","2758726643@qq.com"])    # 括号里的对应收件人邮箱昵称、收件人邮箱账号
#message["from"]=Header("Xiro <2758726643@qq.com>","utf-8") #注意格式
message["Subject"]=Header("message[Subject]"+IP_ipv4,"utf-8")#subject为主题
smptObj=smtplib.SMTP_SSL(mail_host,465)
smptObj.login(mail_user,mail_pass)
smptObj.sendmail(mail_user,receivers,message.as_string())
exit(0)
    
    
