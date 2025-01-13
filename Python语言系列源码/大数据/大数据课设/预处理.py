import pandas as pd
from sklearn.preprocessing import OrdinalEncoder, StandardScaler, LabelEncoder, OneHotEncoder
import joblib
import os
def preprocess_adult_data(file_path):
    # 读取数据集
    column_names=['age','workclass','fnlwgt','education','education-num','marital-status','occupation','relationship','race','sex','capital-gain','capital-loss','hours-per-week','native-country','income']
    data = pd.read_csv(file_path, names=column_names, skipinitialspace=True)

    #预处理
    # 独热编码
    categorical_columns = ['workclass', 'marital-status', 'occupation', 'relationship', 'race', 'native-country']
    data = pd.get_dummies(data, columns=categorical_columns)

    # 二元编码
    data['sex'] = data['sex'].apply(lambda x: 1 if x == 'Male' else 0)
    data['income'] = data['income'].apply(lambda x: 1 if x == '>50K'or x=='>50K.' else 0)

    # 标签编码
    # 定义教育水平的顺序
    education_order = [
    'Preschool', '1st-4th', '5th-6th', '7th-8th', '9th', '10th', '11th', '12th',
    'HS-grad', 'Some-college', 'Assoc-acdm', 'Assoc-voc', 'Bachelors', 'Masters', 'Doctorate', 'Prof-school'
    ]

    ordinal_encoder = OrdinalEncoder(categories=[education_order]) # 创建有序编码器并进行转换
    data['education'] = ordinal_encoder.fit_transform(data[['education']])


    numeric_columns = ['age', 'fnlwgt', 'education-num', 'capital-gain', 'capital-loss', 'hours-per-week',"education"]
    scaler_file_path = r'D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\scaler.joblib'
    # 检查文件路径是否存在
    if os.path.exists(scaler_file_path):
        # 如果文件存在，加载已有的标准化器
        scaler = joblib.load(scaler_file_path)
    else:
        # 如果文件不存在，创建新的标准化器并保存
        scaler = StandardScaler()
        scaler.fit(data[numeric_columns])  # 假设 data 是你的数据框
        joblib.dump(scaler, scaler_file_path)
    
    # 使用标准化器进行标准化
    data[numeric_columns] = scaler.transform(data[numeric_columns])



    return data

# 处理训练集
train_data = preprocess_adult_data(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult.data")
train_data.to_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult_data.csv", index=False)

# 处理测试集
test_data = preprocess_adult_data(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult.test")
test_data.to_csv(r"D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\adult_test.csv", index=False)
