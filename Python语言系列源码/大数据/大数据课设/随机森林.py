import joblib
import pandas as pd
from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import GridSearchCV, cross_val_score
from sklearn.metrics import accuracy_score, classification_report, precision_score, recall_score, confusion_matrix, roc_curve, roc_auc_score
import matplotlib.pyplot as plt
import numpy as np
import seaborn as sns
# 读取数据集和测试集
df1 = pd.read_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult_data_end.csv")
df2 = pd.read_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult_test_end.csv")

# 划分数据集和测试集
X_train = df1.drop('income', axis=1)
y_train = df1['income']
X_test = df2.drop('income', axis=1)
y_test = df2['income']




# 创建随机森林模型
rf_model = RandomForestClassifier(random_state=42)

# 定义参数网格
param_grid = {
    'max_depth': [None, 10, 20, 30],
    'min_samples_split': [2, 5, 10],
    'min_samples_leaf': [1, 2, 4]
}

# 使用10重交叉验证进行网格搜索
grid_search = GridSearchCV(rf_model, param_grid, cv=10, scoring='accuracy')
grid_search.fit(X_train, y_train)

# 输出最佳参数
best_params = grid_search.best_params_
print("最佳参数：", best_params)

# 使用最佳参数训练模型
best_rf_model = RandomForestClassifier(
    max_depth=best_params['max_depth'],
    min_samples_split=best_params['min_samples_split'],
    min_samples_leaf=best_params['min_samples_leaf'],
    random_state=42
)



# 定义不同的 n_estimators 值
n_estimators_values = [200,250,300]
# 存储交叉验证得分
cv_scores = []
# 通过交叉验证评估模型性能
for n_estimators in n_estimators_values:
    rf_model = RandomForestClassifier(n_estimators=n_estimators, random_state=42)
    scores = cross_val_score(rf_model, X_train, y_train, cv=5, scoring='accuracy')
    cv_scores.append(np.mean(scores))
print(cv_scores)
# 绘制学习曲线
plt.plot(n_estimators_values, cv_scores, marker='o')
plt.xlabel('n_estimators')
plt.ylabel('Cross-validated Accuracy')
plt.title('Random Forest Learning Curve')
plt.show()


rf_model = RandomForestClassifier(n_estimators=200, random_state=41,max_depth=20,min_samples_leaf=2,min_samples_split=5)
# 训练模型
rf_model.fit(X_train, y_train)

# 保存模型
joblib.dump(rf_model, r'D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\rf_model.joblib')

# 在测试集上进行预测
y_pred = rf_model.predict(X_test)
 
# 输出模型评估结果
print("准确率：", accuracy_score(y_test, y_pred))
print("精确率：", precision_score(y_test, y_pred))
print("分类报告:\n", classification_report(y_test, y_pred))


# 绘制混淆矩阵的热力图
plt.figure(figsize=(8, 6))
cm = confusion_matrix(y_test, y_pred)
sns.heatmap(cm, annot=True, fmt='g', cmap='Blues', cbar=False)
plt.title('Confusion Matrix')
plt.xlabel('Predicted Label')
plt.ylabel('True Label')
plt.show()

# 计算ROC曲线和AUC值
y_probs = rf_model.predict_proba(X_test)[:, 1]
fpr, tpr, thresholds = roc_curve(y_test, y_probs)
auc_score = roc_auc_score(y_test, y_probs)

# 绘制ROC曲线
plt.figure(figsize=(8, 6))
plt.plot(fpr, tpr, label=f'AUC = {auc_score:.2f}')
plt.plot([0, 1], [0, 1], linestyle='--', color='gray', label='Random')
plt.xlabel('False Positive Rate')
plt.ylabel('True Positive Rate')
plt.title('ROC Curve')
plt.legend()
plt.show()

# 输出变量重要性排序的条形图
feature_importances = rf_model.feature_importances_
feature_names = X_train.columns
importance_dict = dict(zip(feature_names, feature_importances))
sorted_importance = sorted(importance_dict.items(), key=lambda x: x[1], reverse=True)

plt.figure(figsize=(10, 6))
plt.barh(range(len(sorted_importance)), [importance for feature, importance in sorted_importance], align='center')
plt.yticks(range(len(sorted_importance)), [feature for feature, importance in sorted_importance])
plt.xlabel('Feature Importance')
plt.ylabel('Features')
plt.title('Variable Importance')
plt.show()
