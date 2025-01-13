#age	education-num	sex	capital-gain	capital-loss	hours-per-week	
# income	workclass_Self-emp-inc	marital-status_Divorced	
# marital-status_Married-civ-spouse	marital-status_Never-married	occupation_Exec-managerial
# occupation_Other-service	occupation_Prof-specialty	relationship_Not-in-family	
# relationship_Own-child	relationship_Unmarried
#0.030670557	1.134738764	1	0.148452895	-0.216659527	
# -0.035429447	0	FALSE	FALSE	FALSE	TRUE	
# FALSE	FALSE	FALSE	TRUE	FALSE	FALSE
import joblib
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import accuracy_score, classification_report, precision_score, confusion_matrix
import seaborn as sns
import matplotlib.pyplot as plt

# 读取数据集和测试集
df1 = pd.read_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult_data_end.csv")
df2 = pd.read_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult_test_end.csv")
# 划分数据集和测试集
X_train = df1.drop('income', axis=1)
y_train = df1['income']
X_test = df2.drop('income', axis=1)
y_test = df2['income']



#交叉验证选择最佳的K值
from sklearn.model_selection import GridSearchCV
# 定义K值的范围
k_values = list(range(10,15))
# 创建KNN模型
knn_model = KNeighborsClassifier()
# 设置参数范围
param_grid = {'n_neighbors': k_values}
# 创建GridSearchCV对象
grid_search = GridSearchCV(knn_model, param_grid, cv=5, scoring='accuracy')
# 在训练集上进行交叉验证
grid_search.fit(X_train, y_train)
# 输出最佳K值
best_k = grid_search.best_params_['n_neighbors']
print(f'Best K value: {best_k}')
#(1-10)中是10
#(10-14)中是10


# 模型训练
knn_model = KNeighborsClassifier(10)
knn_model.fit(X_train, y_train)

# 保存模型
joblib.dump(knn_model, r'D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\knn_model.joblib')

# 模型预测
y_pred = knn_model.predict(X_test)



# 模型评估
accuracy = accuracy_score(y_test, y_pred)
precision = precision_score(y_test, y_pred)

print(f'Accuracy: {accuracy:.4f}')
print(f'Precision: {precision:.4f}')
print("分类报告:\n", classification_report(y_test, y_pred))
# 混淆矩阵可视化
cm = confusion_matrix(y_test, y_pred)
sns.heatmap(cm, annot=True, fmt='g', cmap='Blues', cbar=False)
plt.xlabel('Predicted labels')
plt.ylabel('True labels')
plt.title('Confusion Matrix')
plt.show()






import shap

# # 创建SHAP解释器
# 使用shap.sample方法对背景数据进行摘要
background_summary = shap.sample(X_train, 100)  # 从训练集中随机抽取100个样本作为摘要

test_subset_indices = shap.sample(X_test, 10)  # 从测试集中随机选择100个样本作为测试子集

# 创建SHAP解释器并指定摘要数据
explainer = shap.KernelExplainer(knn_model.predict, background_summary)

# 计算SHAP值
shap_values = explainer.shap_values(test_subset_indices)

# 可视化SHAP摘要图
shap.summary_plot(shap_values, test_subset_indices)