import random
import numpy as np
import pandas
theList=[random.randint(1,100) for _ in range(10)]
thedict={i:random.randint(1,100) for i in range(10)}
arr=np.random.randint(1,100,10)
lp=pandas.Series(theList,name='list')
dp=pandas.Series(thedict,name='dict')
ap=pandas.Series(arr,name='ndarray')
print(lp,dp,ap)
theList=[[random.randint(1,100) for _ in range(10)] for _ in range(10)]
#thedict={i:{random.randint(1,100) for _ in range(10)} for i in range(10)} #这是一个字典，一个值对应一个集合，集合的项数可能小于10，不允许重复
thedict={i:{j: random.randint(1,100) for j in range(20,30)} for i in range(10,20)}
arr=np.random.randint(1,100,100).reshape(10,10)
print(pandas.DataFrame(theList))
print(pandas.DataFrame(thedict))
print(pandas.DataFrame(arr))

txt=pandas.read_table(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\data_test01.txt")
csv=pandas.read_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\diamonds.csv")
xlsx=pandas.read_excel(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\HuRun.xlsx")
print(txt)
print(csv)
print(xlsx)
print(f"行数：{len(csv.index)},列数：{len(csv.columns)},各列数据类型：\n{csv.dtypes},\n前十行：\n{csv.loc[range(10)]}")
# 5.判断是否存在重复观察值，并进行处理。
csvJudje=csv.duplicated()
for i ,v in csvJudje.items():
    if v==True: print(f"duplicated:{i}")
csv.drop_duplicates()
# 6.判断是否存在缺失值，并进行处理。
print(csv.isnull())
csv.dropna(inplace=True)
# 7.判断是否存在异常值，并进行处理。
for i in csv.index:
    if  csv.loc[i,"depth"]<55:
        print(f"depth<55:{i}")
        csv.drop(inplace=True,index=i)
# 8.获取diamonds数据集的一个子集，并输出。
print(csv[csv["cut"]=="Very Good"])
# 9.根据diamonds数据集建立一个透视表。
print(csv.pivot_table(values="price",aggfunc="mean",index="clarity"))
# 10.对diamonds数据集进行分组聚合操作。
print(csv.groupby("color").agg({"price":"mean"}))



