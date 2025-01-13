from sklearn.cluster import KMeans
from sklearn.model_selection import train_test_split, cross_val_score
from sklearn.neighbors import KNeighborsClassifier
from sklearn.naive_bayes import GaussianNB
from sklearn.metrics import confusion_matrix
import seaborn as sns
import matplotlib.pyplot as plt
from sklearn.datasets import load_iris
iris = load_iris()
X_train, X_test, y_train, y_test = train_test_split(iris.data, iris.target, test_size=0.2, random_state=42)
# 加载iris数据集


# 假设k未知，使用肘部法则确认k值
inertia_values = []
for k in range(1, 11):
    kmeans = KMeans(n_clusters=k, random_state=42)
    kmeans.fit(X_train)
    inertia_values.append(kmeans.inertia_)

# 可视化肘部法则
plt.plot(range(1, 11), inertia_values, marker='o')
plt.xlabel('K:')
plt.ylabel('簇内平方和')
plt.show()

# 假设肘部法则中的K值为最优K值
optimal_k_means = 3

# 在测试集上进行KMeans聚类
kmeans_model = KMeans(n_clusters=optimal_k_means, random_state=42)
y_pred_kmeans = kmeans_model.fit_predict(X_test)

# 输出混淆矩阵
conf_matrix_kmeans = confusion_matrix(y_test, y_pred_kmeans)
print("conf_matrix_kmeans")
print(conf_matrix_kmeans)

# 可视化混淆矩阵
plt.figure(figsize=(8, 6))
sns.heatmap(conf_matrix_kmeans, annot=True, fmt="d", cmap="Reds", xticklabels=iris.target_names, yticklabels=iris.target_names)
plt.title("conf_matrix_kmeans")
plt.show()
