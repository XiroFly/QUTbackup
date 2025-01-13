import seaborn as sns
import matplotlib.pyplot as plt
iris = sns.load_dataset("iris")
#      sepal_length  sepal_width  petal_length  petal_width    species
# 0             5.1          3.5           1.4          0.2     setosa
# 1             4.9          3.0           1.4          0.2     setosa
# 2             4.7          3.2           1.3          0.2     setosa
# 3             4.6          3.1           1.5          0.2     setosa
# 4             5.0          3.6           1.4          0.2     setosa
# 基于iris数据集，绘制下列各图：
# -利用数据集中的离散型数据绘制饼图、水平条形图、垂直条形图、堆叠条形图、水平交错条形图，并描述、分析观察到的图形特点；
plt.figure(figsize=(10, 6))
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

# -利用数据集中的数值型数据绘制直方图、箱线图、折线图，并描述、分析观察到的图形特点；
# -利用数据集中不同属性关系，绘制散点图、气泡图、热力图，并描述、分析观察到的图形特点；
# -选取上述部分图形作为子图，对子图进行合并。
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
correlation_matrix =iris.select_dtypes(include=[float]).corr()
sns.heatmap(correlation_matrix, annot=True)
plt.title('Correlation Heatmap')
plt.figure(figsize=(12, 8))
plt.subplot(2, 2, 1)
sns.scatterplot(x='sepal_length', y='sepal_width', hue='species', data=iris)
plt.title('Scatter Plot of Sepal Length vs Sepal Width')

plt.subplot(2, 2, 2)
sns.scatterplot(x='petal_length', y='petal_width', hue='species', data=iris)
plt.title('Scatter Plot of Petal Length vs Petal Width')

plt.subplot(2, 2, 3)
sns.histplot(iris['sepal_length'], kde=True)
plt.title('Histogram of Sepal Length')

plt.subplot(2, 2, 4)
sns.boxplot(x='species', y='sepal_length', data=iris)   
plt.title('Box Plot of Sepal Length by Species')

plt.tight_layout()
plt.show()