import joblib
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

# 读取预处理后的数据
train_data = pd.read_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult_data.csv")

# 计算相关系数矩阵
correlation_matrix = train_data.corr()

# 打印目标变量（income）与其他特征的相关系数
target_correlation = correlation_matrix['income'].sort_values(ascending=True)
print("Correlation with target variable (income):\n", target_correlation)

# 打印弱相关的特征
weak_correlation_threshold = 0.1  # 你可以根据需求调整阈值
weak_correlation_columns = target_correlation[abs(target_correlation) < weak_correlation_threshold].index
print("\nColumns with weak correlation (|correlation| < {}):\n{}".format(weak_correlation_threshold, weak_correlation_columns))


# 打印除了 'income' 之外，其他列之间的强相关关系
strong_correlation_columns = []
for col1 in train_data.columns:
    for col2 in train_data.columns:
        if col1 != 'income' and col2 != 'income' and col1 != col2:
            correlation_between_cols = correlation_matrix[col1][col2]
            if abs(correlation_between_cols) > 0.8:  # 根据需求调整高度相关的阈值
                print(f"\nHigh correlation between columns: {col1} and {col2} - Correlation: {correlation_between_cols}")
                # 舍弃其中一个高度相关的列
                if col1  not in strong_correlation_columns and col2 not in strong_correlation_columns :
                    strong_correlation_columns.append(col1)
strong_correlation_columns.append     
# 检查是否包含 "marital-status_Married-civ-spouse"
if "marital-status_Married-civ-spouse"  in strong_correlation_columns:
    strong_correlation_columns.remove("marital-status_Married-civ-spouse")
# 检查是否包含 "relationship_Wife" 或 "relationship_Husband"，如果有则删除
if "relationship_Wife" not in strong_correlation_columns:
    strong_correlation_columns.append("relationship_Wife")
if "relationship_Husband" not in strong_correlation_columns:
    strong_correlation_columns.append("relationship_Husband")




# 使用可视化工具观察相关性
plt.figure(figsize=(12, 12))
sns.heatmap(correlation_matrix, cmap='coolwarm')
plt.title('Correlation Matrix')
plt.show()



#重新生成csv文件
# 选择不在weak_correlation_columns中的列
selected_columns = [col for col in train_data.columns if col not in weak_correlation_columns and col not in  strong_correlation_columns]
joblib.dump(selected_columns, r'D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\selected_columns.joblib')
selected_train_data = train_data[selected_columns]
selected_train_data.to_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult_data_end.csv", index=False)


# 读取预处理后的测试数据
test_data = pd.read_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult_test.csv")
selected_test_data = test_data[selected_columns]
# 保存选择后的测试数据为新的CSV文件
selected_test_data.to_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult_test_end.csv", index=False)
