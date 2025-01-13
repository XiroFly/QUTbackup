from flask import Flask, render_template, request, jsonify
import joblib
import pandas as pd
from sklearn.preprocessing import StandardScaler
import pandas
app = Flask(__name__, template_folder='D:/Users/fly/Python/大数据/大数据课设/')

# Load the scaler and models
#r'D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\XGBoost.joblib'
scaler = joblib.load(r'D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\scaler.joblib')
selected_columns = joblib.load(r'D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\selected_columns.joblib')
logreg_model = joblib.load(r'D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\best_logreg.joblib')
knn_model = joblib.load(r'D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\knn_model.joblib')
svm_model = joblib.load(r'D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\svm_model.joblib')
xgb_model = joblib.load(r'D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\XGBoost.joblib')
rf_model = joblib.load(r'D:\Document\作业\python作业\大数据\第5章 Python数据处理工具--Pandas\rf_model.joblib')

@app.route('/')
def home():
    return render_template('index.html')

@app.route('/predict', methods=['GET'])
def predict():
    # 从请求中获取表单数据
    age = int(request.args.get('age'))
    education_num = int(request.args.get('educationNum'))
    sex = int(request.args.get('sex'))
    capital_gain = int(request.args.get('capitalGain'))
    capital_loss = int(request.args.get('capitalLoss'))
    hours_per_week = int(request.args.get('hoursPerWeek'))
    income = int(request.args.get('income'))
    workclass = request.args.get('workclass')
    marital_status = request.args.get('maritalStatus')
    occupation = request.args.get('occupation')
    relationship = request.args.get('relationship')
  
  
  
    #numeric_columns = ['age', 'fnlwgt', 'education-num', 'capital-gain', 'capital-loss', 'hours-per-week',"education"]
    arr={'age':age,'fnlwgt':0 ,'education-num':education_num,'capital-gain':capital_gain,'capital-loss':capital_loss,"hours-per-week":hours_per_week,"education":0}
    cols=['age','fnlwgt','education-num','capital-gain','capital-loss',"hours-per-week","education"]
    df=pandas.DataFrame(arr,index=[0])
    df=pandas.DataFrame(scaler.transform(df),columns=cols).drop(['fnlwgt','education'], axis=1)
    
# workclass(Self-emp-inc,other)	
# marital-status(Divorced,	Married-civ-spouse,	Never-married,other)	
# occupation(Exec-managerial,	Other-service	,Prof-specialty,other)
# relationship(Not-in-family	Own-child	Unmarried,other)
    columns=['workclass_Self-emp-inc',	'marital-status_Divorced',	'marital-status_Married-civ-spouse',	'marital-status_Never-married',	'occupation_Exec-managerial',	'occupation_Other-service'	,'occupation_Prof-specialty','relationship_Not-in-family'	,'relationship_Own-child'	,'relationship_Unmarried']
    vals=[False for i in range(len(columns))]
    lis=[workclass,marital_status,occupation,relationship]
    for i in range(len(columns)):
        if columns[i] in lis:
            vals[i]=True
    df1=pandas.DataFrame([vals],columns=columns,index=[0])        
    
    
    df2=pandas.concat([df,df1],axis=1)
    df2["sex"]=sex
    df2['income']=income    
    df2=df2[selected_columns].drop("income",axis=1)
    
    
    result = []
    result.append(logreg_model.predict(df2))
    result.append(knn_model.predict(df2))
    result.append(svm_model.predict(df2))
    result.append(xgb_model.predict(df2))
    result.append(rf_model.predict(df2))
    res=[i[0]==1 for i in result]
    f_dic=0
    for i in result:
        f_dic+=i[0]
    result=['logreg_model :','knn_model :','svm_model :','xgb_model :','rf_model :']
    dic=dict(zip(result,res))
    return render_template('result.html',income=(income==1),dic=dic,f_dic=(f_dic>2))



if __name__ == '__main__':
    app.run(debug=True)
