from sklearn.cluster import KMeans
from sklearn.model_selection import train_test_split
from sklearn.metrics import confusion_matrix
import seaborn as sns
import matplotlib.pyplot as plt
from sklearn.datasets import load_iris
from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import GridSearchCV

iris = load_iris()
X_train, X_test, y_train, y_test = train_test_split(iris.data, iris.target, test_size=0.2, random_state=42)
# 加载iris数据集


# 初始化随机森林模型
rf_model = RandomForestClassifier(random_state=42)

# 使用网格搜索进行参数寻优
param_grid = {
    'n_estimators': [50, 100, 200],
    'max_depth': [None, 10, 20],
    'min_samples_split': [2, 5, 10],
    'min_samples_leaf': [1, 2, 4]
}

grid_search = GridSearchCV(estimator=rf_model, param_grid=param_grid, cv=5, scoring='accuracy')
grid_search.fit(X_train, y_train)

# 输出最优参数
print("best param", grid_search.best_params_)

# 在测试集上进行随机森林模型测试
y_pred_rf = grid_search.predict(X_test)

# 输出混淆矩阵
conf_matrix_rf = confusion_matrix(y_test, y_pred_rf)
print("conf_matrix_rf")
print(conf_matrix_rf)

# 可视化混淆矩阵
plt.figure(figsize=(8, 6))
sns.heatmap(conf_matrix_rf, annot=True, fmt="d", cmap="Purples", xticklabels=iris.target_names, yticklabels=iris.target_names)
plt.title("conf_matrix_rf")
plt.show()
