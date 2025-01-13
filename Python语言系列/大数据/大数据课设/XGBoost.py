# 导入所需的库
import pandas as pd
from sklearn.model_selection import GridSearchCV, StratifiedKFold
from xgboost import XGBClassifier
from sklearn.metrics import accuracy_score, classification_report, precision_score
from sklearn.metrics import confusion_matrix
import shap
from sklearn.metrics import roc_curve, auc
import matplotlib.pyplot as plt
import seaborn as sns
import joblib
# 读取数据集和测试集
df1 = pd.read_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult_data_end.csv")
df2 = pd.read_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult_test_end.csv")


# 划分数据集和测试集
X_train = df1.drop('income', axis=1)
y_train = df1['income']
X_test = df2.drop('income', axis=1)
y_test = df2['income']



# 初始化XGBoost模型
model = XGBClassifier()

# 定义参数网格
param_grid = {
    'n_estimators': [50, 100, 200],
    'learning_rate': [0.01, 0.1, 0.2],
    'max_depth': [ 4, 5,6],
    'subsample': [0.8, 0.9, 1.0],
    'colsample_bytree': [0.8, 0.9, 1.0],
}

# 使用StratifiedKFold进行交叉验证
cv = StratifiedKFold(n_splits=5, shuffle=True, random_state=42)

# 使用GridSearchCV进行参数搜索
grid_search = GridSearchCV(model, param_grid, scoring='accuracy', cv=cv, n_jobs=-1)
grid_search.fit(X_train, y_train)

# 输出最佳参数组合
print("Best Parameters:", grid_search.best_params_)

# 输出最佳模型的性能
print("Best Accuracy:", grid_search.best_score_)







model =XGBClassifier(colsample_bytree=0.8,learning_rate=0.01,max_depth=6,subsample=0.8,n_estimators=100)

# 训练模型
model.fit(X_train, y_train)

# 保存模型
joblib.dump(model, r'D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\XGBoost.joblib')

# 预测测试集
y_pred = model.predict(X_test)

# 评估模型性能
accuracy = accuracy_score(y_test, y_pred)
precision = precision_score(y_test, y_pred)

print(f"Accuracy: {accuracy:.4f}")
print(f"Precision: {precision:.4f}")
print("分类报告:\n", classification_report(y_test, y_pred))




# 混淆矩阵可视化
cm = confusion_matrix(y_test, y_pred)
sns.heatmap(cm, annot=True, fmt='g', cmap='Blues', cbar=False)
plt.xlabel('Predicted labels')
plt.ylabel('True labels')
plt.title('Confusion Matrix')
plt.show()




# 预测测试集概率
y_prob = model.predict_proba(X_test)[:, 1]
# 计算ROC曲线的参数
fpr, tpr, thresholds = roc_curve(y_test, y_prob)
roc_auc = auc(fpr, tpr)

# 绘制ROC曲线
plt.figure(figsize=(8, 8))
plt.plot(fpr, tpr, color='darkorange', lw=2, label=f'ROC curve (AUC = {roc_auc:.2f})')
plt.plot([0, 1], [0, 1], color='navy', lw=2, linestyle='--')
plt.xlabel('False Positive Rate')
plt.ylabel('True Positive Rate')
plt.title('Receiver Operating Characteristic (ROC) Curve')
plt.legend(loc="lower right")
plt.show()




# 模型解释性分析
explainer = shap.TreeExplainer(model)

# 获取SHAP值
shap_values = explainer.shap_values(X_test)

# 汇总特征的SHAP值
shap.summary_plot(shap_values, X_test, plot_type="bar", show=True)



