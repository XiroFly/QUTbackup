import pandas as pd

# 读取日志文件到DataFrame
table = pd.read_table(r"process1.log", delimiter="\t", names=['pid', 'status', 'jiffies'])
# 筛选进程7-16的行
selected_processes = table[(table['pid'] >= 7) & (table['pid'] <= 16)]
print(selected_processes)
# 为每个进程计算周转时间和等待时间
lis=[0 for i in range(10)]
lis1=[0 for i in range(10)]
lis2=[0 for i in range(10)]
ma=mi=0
for index, row in selected_processes.iterrows():
    pid = row['pid']
    id=pid-7
    status = row['status']
    jiffies = row['jiffies']

    if status == 'N':
        lis[id] = jiffies
    elif status == 'E':
        lis[id]=jiffies-lis[id]
    elif status == 'J':
        lis1[id]=jiffies
    elif status == 'R' and lis1[id]!=0:
        lis2[id]+=jiffies-lis1[id]
        lis1[id]=0
    
    ma=max(ma,jiffies)
    mi=min(mi,jiffies)
print(f"平均周转时间{sum(lis)/10}\n")
print(f"平均等待时间{sum(lis2)/10}\n")
print(f"吞吐率{10/(ma-mi)}每jiffy")


