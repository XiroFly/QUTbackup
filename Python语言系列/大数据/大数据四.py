# 导入必要的库
import numpy as np
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error
from sklearn.datasets import load_iris

# 加载iris数据集
iris = load_iris()
data = pd.DataFrame(data=np.c_[iris['data'], iris['target']], columns=iris['feature_names'] + ['target'])
# 选择特定的特征作为预测目标（例如，选择第一个特征，即sepal length）
feature_to_predict = 'sepal length (cm)'

# 提取特征和目标变量
X = data.drop('target', axis=1)
y = data[feature_to_predict]

# 划分数据集为训练集和测试集
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# 初始化线性回归模型
model = LinearRegression()

# 训练模型
model.fit(X_train, y_train)

# 在测试集上进行预测
y_pred = model.predict(X_test)
import matplotlib.pyplot as plt

# 可视化预测结果
plt.scatter(X_test[feature_to_predict], y_test, color='black', label='real')
plt.scatter(X_test[feature_to_predict], y_pred, color='blue', label='predict')
plt.title('compare')
plt.xlabel(feature_to_predict)
plt.ylabel('predict')
plt.legend()
plt.show()

# 计算均方误差
mse = mean_squared_error(y_test, y_pred)

# 输出均方误差
print(f"均方误差：{mse}")

# 描述、分析测试结果的特点
# 这里可以根据实际情况进行结果分析，例如，通过比较均方误差的大小，评估模型的预测性能。
# 如果均方误差较小，说明模型在测试集上的预测较为准确；反之，则需要进一步优化模型或考虑其他算法。
