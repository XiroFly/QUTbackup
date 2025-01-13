import joblib
import pandas as pd
from sklearn.model_selection import GridSearchCV, train_test_split
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score, precision_score, classification_report, confusion_matrix, roc_auc_score, roc_curve
import seaborn as sns
import matplotlib.pyplot as plt

# 读取数据集
df1 = pd.read_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult_data_end.csv")
df2 = pd.read_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult_test_end.csv")

# 将数据集拆分为特征（X）和目标变量（y）
X_train = df1.drop('income', axis=1)
y_train = df1['income']
X_test = df2.drop('income', axis=1)
y_test = df2['income']

# 定义逻辑回归模型
logreg = LogisticRegression()

# 定义参数网格
param_grid = {'C': [0.001, 0.01, 0.1, 1, 10, 100], 'penalty': ['l1', 'l2']}

# 使用网格搜索进行超参数调优
grid_search = GridSearchCV(logreg, param_grid, cv=5, scoring='accuracy')
grid_search.fit(X_train, y_train)

# 输出最优参数
best_params = grid_search.best_params_
print("最优参数:", best_params)

# 使用最优参数的模型进行预测
best_logreg = grid_search.best_estimator_
y_pred = best_logreg.predict(X_test)

# 保存模型
joblib.dump(best_logreg, r'D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\best_logreg.joblib')

# 评估模型性能
accuracy = accuracy_score(y_test, y_pred)
precision = precision_score(y_test, y_pred)
print("准确率:", accuracy)
print("精确率:", precision)
print("分类报告:\n", classification_report(y_test, y_pred))

# 输出混淆矩阵
conf_matrix = confusion_matrix(y_test, y_pred)
# 使用Seaborn画混淆矩阵热图
plt.figure(figsize=(8, 6))
sns.heatmap(conf_matrix, annot=True, fmt='d', cmap='Blues', cbar=False)
plt.title('Confusion Matrix')
plt.xlabel('Predicted')
plt.ylabel('True')
plt.show()

# 用Seaborn画ROC曲线
y_probs = best_logreg.predict_proba(X_test)[:, 1]
fpr, tpr, thresholds = roc_curve(y_test, y_probs)
auc_score = roc_auc_score(y_test, y_probs)
# 绘制ROC曲线
plt.figure(figsize=(8, 6))
plt.plot(fpr, tpr, label=f'AUC = {auc_score:.2f}')
plt.plot([0, 1], [0, 1], linestyle='--', color='gray', label='LogisticRegression')
plt.xlabel('False Positive Rate')
plt.ylabel('True Positive Rate')
plt.title('ROC Curve')
plt.legend()
plt.show()




#ks曲线

# 模型解释性分析 - 特征重要性可视化
coef_importance = pd.Series(best_logreg.coef_[0], index=X_train.columns)
coef_importance = coef_importance.sort_values(ascending=False)
plt.figure(figsize=(12, 8))
sns.barplot(x=coef_importance, y=coef_importance.index)
plt.title('Feature Importance')
plt.xlabel('Coefficient Magnitude')
plt.ylabel('Features')
plt.show()
