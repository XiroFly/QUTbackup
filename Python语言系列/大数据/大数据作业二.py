import sklearn.model_selection
import pandas as pd
import sklearn.linear_model
import matplotlib.pyplot as plt
column_names=['age','workclass','fnlwgt','education','education-num','marital-status','occupation','relationship','race','sex','capital-gain','capital-loss','hours-per-week','native-country','income']
#data=pd.read_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult.test")
data=pd.read_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult.data",names=column_names)
#39, State-gov, 77516, Bachelors, 13, Never-married, Adm-clerical, Not-in-family, White, Male, 2174, 0, 40, United-States, <=50K
X=data.drop(columns='hours-per-week')
X = pd.get_dummies(X, columns=['workclass','education','marital-status','occupation','relationship','race','sex','native-country','income'])
y=data['hours-per-week']
train_x,test_x,train_y,test_y=sklearn.model_selection.train_test_split(X,y,test_size=0.2,random_state=15 )
# model=sklearn.linear_model.LinearRegression()
# model.fit(train_x,train_y)
# predicted_y= model.predict(test_x)
# print(f'得分{model.score(test_x,test_y)}')
# plt.plot(test_x, predicted_y, color='red', linewidth=2)
# plt.xlabel('X-axis Label')
# plt.ylabel('Y-axis Label')
# plt.title('Linear Regression: Actual vs. Predicted')
# plt.legend()
# plt.show()
import sklearn.neighbors
from sklearn.metrics import confusion_matrix
import seaborn as sns
# model=sklearn.neighbors.KNeighborsClassifier()
# model.fit(train_x,train_y)
# pred_y= model.predict(test_x)
# from sklearn.cluster import KMeans
# model=KMeans()
# model.fit(train_x,train_y)
# pred_y=model.predict(test_x)
# cm=confusion_matrix(test_y,pred_y)
# print(cm)
# sns.heatmap(cm, annot=True, fmt='d', cmap='Blues')
# plt.show()
import numpy as np
print(np.linspace(10,20,10)[0])
