#性别
def judjeSex():
    string =input()
    num= int(string[-2])# 获取倒数第二位的数字
    if(num%2==0): # 判断性别
        return "female"
    else: return "male"
#构造一个自定义函数，用于计算等比数列a_n=3×2^(n-1)的前n项和。
#a1=3,formula=3(1-2**n)/-1

def S(n):
    return 3*(2**n-1)
import pandas as pd
def stu_txt(path):
#5.利用stu_socre.txt数据集，计算每一列的平均值 delimiter
    print(pd.read_csv(path).mean())
#6创建一个5×3的随机矩阵A和一个3×2的随机矩阵B，计算两个矩阵的点积
import numpy as np
def dot():
   A= np.random.randint(10,25,size=15).reshape((5,3))
   B= np.random.randint(10,25,size=6).reshape((3,2))
   print(A@B)
def read():
    txt=pd.read_table(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\data_test01.txt")
    csv=pd.read_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\diamonds.csv")
    xlsx=pd.read_excel(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\HuRun.xlsx")
    print(txt)
    print(csv)
    print(xlsx)
#csv 默认分隔符为，txt默认为\t
import re
def read_work_2():
    data= pd.read_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\作业二.txt",delimiter="\t")    
    #print(data[['Order_amt','Pay_amt']].aggregate([sum,max,'mean',min]))
    # print(data[['Order_amt','Pay_amt']].max())
    # print(data[['Order_amt','Pay_amt']].min())
    # print(data[['Order_amt','Pay_amt']].sum())
    #print(data['Send_time'].apply(lambda x:60*int(re.findall(r"\d+",x)[0])+int(re.findall(r"\d+",x)[1])).describe())
    # a=data['Order_amt']-data['Pay_amt']
    # for i in range(len(data)):
    #     if (a.loc[i]>=8):
    #         print(f"{data.loc[i,'Uid']} {a.loc[i]}")
    data["tel"]=data["tel"].apply(lambda x :f"{x//100000000}{'*'*4}{str(x)[-4:]}")
    print(data["tel"])
# read_work_2()
# 某销售小组共有4名销售人员，其中张三的销售额为300万，
# 李四的销售额为120万，王二的销售额为470万，赵五的销售额为200万。
# 请分别使用饼图、条形图展现4名销售人员的销售业绩信息。
import matplotlib.pyplot as plot
plot.figure(figsize=[10,5])
plot.subplot(1,2,1)
plot.pie([300,120,470,200],labels=["张三",'李四','王二','赵五'],autopct="%1.1f%%")
plot.subplot(1,2,2)
plot.bar(["张三",'李四','王二','赵五'],[300,120,470,200])
plot.tight_layout()
plot.show()
