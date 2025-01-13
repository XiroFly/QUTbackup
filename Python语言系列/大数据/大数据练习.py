import numpy as np
import numpy.linalg
import pandas as pd
import sklearn.model_selection
import sklearn.datasets
import sklearn.neighbors
# iris=sklearn.datasets.load_iris()
# data=iris.data
# target=iris.target
# da=pd.DataFrame(np.column_stack((data,target)),columns=["sepal length",'sepal width','petal lenght','petal width','species'])
# da.iloc[:50,4]='setoca'
# da.iloc[50:100,4]="versecolor"
# da.iloc[100:,4]="virginica"
# x= da['species']=='virginica'
# # print(da.loc[x])
# data_train,data_test,result_train,result_test=sklearn.model_selection.train_test_split(data,target,test_size=0.2,random_state=10)
# model=sklearn.neighbors.KNeighborsClassifier()
# model.fit(data_train,result_train)
# pre_result= model.predict(data_test)
# print(pre_result)
# print(model.score(data_test,result_test))

# 两个随机矩阵的点积
# a=np.random.rand(4,3)
# b=np.random.rand(3,5)
# #求解二元一次方程组
# # 2x+y=10
# # x+3y=15
# x=np.array([[2,1],[1,3]])
# y=np.array([10,15])
# print(np.linalg.solve(x,y))
# import os
# import shutil
# pset=["jpg",'jpeg','png']
# path=r"D:/Download"
# dest=r"D:/picture"
# # files=os.listdir(path)
# for  dirpath,dirnames,filenames in os.walk(path):
#     for file in filenames:
#         if file.split(".")[-1].lower() in pset:
#             shutil.move( os.path.join(dirpath,file),os.path.join(dest,file))
# from ucimlrepo import fetch_ucirepo 
  
# # fetch dataset 
# adult = fetch_ucirepo(id=2) 
  
# # data (as pandas dataframes) 
# X = adult.data.features 
# y = adult.data.targets 
  
# # metadata 
# print(X) 
import pandas
import sklearn.datasets
iris= sklearn.datasets.load_iris()
print(type(iris.data))
# variable information 



            