import seaborn as sns
import matplotlib.pyplot as plt

# 加载Iris数据集
iris = sns.load_dataset("iris")

# 利用数据集中的离散型数据
# 饼图
plt.figure(figsize=(10, 5))
plt.subplot(2, 3, 1)
iris['species'].value_counts().plot.pie(autopct='%1.1f%%')
plt.title('Pie Chart ')

# 水平条形图
plt.subplot(2, 3, 2)
sns.countplot(y='species', data=iris)#绘制species计数器
plt.title('Horizontal Bar')

# 垂直条形图
plt.subplot(2, 3, 3)
sns.countplot(x='species', data=iris)
plt.title('Vertical Bar ')

# 堆叠条形图
plt.subplot(2, 3, 4)
sns.countplot(x='species', hue='sepal_length', data=iris)
plt.title('Stacked Bar')

# 水平交错条形图
plt.subplot(2, 3, 5)
sns.barplot(x='species', y='sepal_length', data=iris)
plt.title('Horizontal Stacked Bar')

# 利用数据集中的数值型数据
# 直方图
plt.figure(figsize=(10, 5))
plt.subplot(2, 3, 1)
sns.histplot(iris['sepal_length'], kde=True)
plt.title('Histogram ')

# 箱线图
plt.subplot(2, 3, 2)
sns.boxplot(x='species', y='sepal_length', data=iris)
plt.title('Box Plot')

# 折线图
plt.subplot(2, 3, 3)
sns.lineplot(x='sepal_length', y='sepal_width', data=iris)
plt.title('Line Plot ')

# 利用数据集中不同属性关系
# 散点图
plt.figure(figsize=(12, 4))
plt.subplot(1, 3, 1)
sns.scatterplot(x='sepal_length', y='sepal_width', hue='species', data=iris)
plt.title('Scatter Plot ')

# 气泡图
plt.subplot(1, 3, 2)
sns.scatterplot(x='sepal_length', y='sepal_width', size='petal_length', data=iris)
plt.title('Bubble Plot')

# 热力图
plt.subplot(1, 3, 3)
correlation_matrix =iris.select_dtypes(include=[float]).corr()#排除非浮点数
sns.heatmap(correlation_matrix, annot=True)

plt.title('Correlation Heatmap')
plt.tight_layout()
plt.show()
