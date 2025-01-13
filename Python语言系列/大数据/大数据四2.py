# 导入必要的库
# 导入必要的库
from sklearn.model_selection import train_test_split, cross_val_score
from sklearn.neighbors import KNeighborsClassifier
from sklearn.naive_bayes import GaussianNB
from sklearn.metrics import confusion_matrix
import seaborn as sns
import matplotlib.pyplot as plt
from sklearn.datasets import load_iris

# 加载iris数据集
iris = load_iris()

# 划分数据集为训练集和测试集
X_train, X_test, y_train, y_test = train_test_split(iris.data, iris.target, test_size=0.2, random_state=42)

# 初始化KNN模型
knn_model = KNeighborsClassifier()

# 使用交叉验证寻找最优的k值
k_values = list(range(1, 20))
cv_scores = []

for k in k_values:
    knn_model.n_neighbors = k
    scores = cross_val_score(knn_model, X_train, y_train, cv=5, scoring='accuracy')
    cv_scores.append(scores.mean())

# 选择交叉验证分数最高的k值
optimal_k = k_values[cv_scores.index(max(cv_scores))]
print(f"best k:{optimal_k}")

# 在测试集上进行KNN模型测试
knn_model.n_neighbors = optimal_k
knn_model.fit(X_train, y_train)
y_pred_knn = knn_model.predict(X_test)

# 输出混淆矩阵
conf_matrix_knn = confusion_matrix(y_test, y_pred_knn)
print("KNNmodel motrix:")
print(conf_matrix_knn)

# 可视化混淆矩阵
plt.figure(figsize=(8, 6))
sns.heatmap(conf_matrix_knn, annot=True, fmt="d", cmap="Blues", xticklabels=iris.target_names, yticklabels=iris.target_names)
plt.title("KNNmodel motrix")
plt.show()

# 初始化贝叶斯模型
nb_model = GaussianNB()

# 在测试集上进行贝叶斯模型测试
nb_model.fit(X_train, y_train)
y_pred_nb = nb_model.predict(X_test)

# 输出混淆矩阵
conf_matrix_nb = confusion_matrix(y_test, y_pred_nb)
print("conf matrix nb")
print(conf_matrix_nb)

# 可视化混淆矩阵
plt.figure(figsize=(8, 6))
sns.heatmap(conf_matrix_nb, annot=True, fmt="d", cmap="Greens", xticklabels=iris.target_names, yticklabels=iris.target_names)
plt.title("conf_matrix_nb")
plt.show()
