import joblib
import pandas as pd
from sklearn.model_selection import GridSearchCV, train_test_split
from sklearn.svm import SVC
from sklearn.metrics import accuracy_score, confusion_matrix, precision_score, classification_report
from sklearn.inspection import permutation_importance
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.metrics import roc_curve, auc
# 读取数据集
df1 = pd.read_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult_data_end.csv")
df2 = pd.read_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult_test_end.csv")

# 将数据集拆分为特征（X）和目标变量（y）
X_train = df1.drop('income', axis=1)
y_train = df1['income']
X_test = df2.drop('income', axis=1)
y_test = df2['income']

# # 定义支持向量机模型
# svm_model = SVC()

# # 定义网格搜索的超参数
# #param_grid = {'C': [0.1, 1, 10, 100], 'kernel': ['linear', 'rbf', 'poly'], 'gamma': ['scale', 'auto']}
# #最佳超参数: {'C': 100, 'gamma': 'scale', 'kernel': 'rbf'}
# param_grid = {'C': [100], 'kernel': ['rbf'], 'gamma': ['scale',"auto"]}
# # 使用网格搜索进行超参数调优
# grid_search = GridSearchCV(svm_model, param_grid, cv=5, scoring='accuracy', n_jobs=-1)
# grid_search.fit(X_train, y_train)

# # 输出最佳参数
# best_params = grid_search.best_params_
# print("最佳超参数:", best_params)

# # 使用最佳超参数的模型进行训练
# best_svm_model = grid_search.best_estimator_
# best_svm_model.fit(X_train, y_train)
#模型性能评估
svm_model = SVC(C=100,kernel='rbf',gamma='scale',probability=True).fit(X_train,y_train)

#保存模型
joblib.dump(svm_model, r'D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\svm_model.joblib')

y_pred = svm_model.predict(X_test)
accuracy = accuracy_score(y_test, y_pred)
precision = precision_score(y_test, y_pred)

print("准确率:", accuracy)
print("精确率:", precision)
print("分类报告:\n", classification_report(y_test, y_pred))


# Calculate the confusion matrix
conf_matrix = confusion_matrix(y_test, y_pred)

# Create a heatmap using seaborn
sns.heatmap(conf_matrix, annot=True, fmt='d', cmap='Blues', xticklabels=['<=50K', '>50K'], yticklabels=['<=50K', '>50K'])
plt.xlabel('Predicted Label')
plt.ylabel('True Label')
plt.title('Confusion Matrix')
plt.show()




# 计算决策函数的分数
y_score = svm_model.decision_function(X_test)
# 计算 ROC 曲线的真正例率和假正例率
fpr, tpr, thresholds = roc_curve(y_test, y_score)
# 计算 AUC
roc_auc = auc(fpr, tpr)
# 绘制 ROC 曲线
plt.figure(figsize=(8, 6))
plt.plot(fpr, tpr, color='darkorange', lw=2, label=f'AUC = {roc_auc:.2f}')
plt.plot([0, 1], [0, 1], color='navy', lw=2, linestyle='--')
plt.xlim([0.0, 1.0])
plt.ylim([0.0, 1.05])
plt.xlabel('False Positive Rate')
plt.ylabel('True Positive Rate')
plt.title('ROC Curve')
plt.legend(loc='lower right')
plt.show()





