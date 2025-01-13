import os
import openai
import json
# openai.organization = "org-ewNalv04Srz2atNGo43VFIvK"
# openai.api_key = os.getenv("OPENAI_API_KEY")
# openai.Model.list()
openai.api_key=""
os.environ["https_proxy"]="http://localhost:33210"
os.environ["http_proxy"]="http://localhost:33210"
message=[
        {"role": "user", "content": """假定你是一名小学乘法数学应用题教材答案的编写者，要按照下面的格式编写答案，你回答时不需要输出题目
给出三个例子：
果园里每棵树有23个果子，果园里一共有168课树，问果园里一共有多少个果子？
答案：

被乘数是：23

乘数是：168

算式：23 * 168 = 3864 (个）
德县路小学的同学坐车去郊游，每辆汽车可以乘坐65人，一共25辆汽车，问德县路小学的学生一共多少人？
答案：

被乘数是：65

乘数是：25

算式：65 * 25 = 1625 (人）

青岛理工大学软件工程专业一共有12个班级，每个班级35人，软件工程专业一共有多少人？
答案：

被乘数是：12

乘数是：35

算式：12 * 35 = 420 (人）


接下来我输入问题，你按上面的答案格式回答。"""},
        {"role": "assistant", "content": "当然，我会尽力帮助您解决数学问题。请提出您的问题。"}
    ]
new_message={
     "role": "user",
    "content": "Mary喜欢吃鸡蛋，她每天吃11只鸡蛋，当前月有31天，Mary这个月一共吃了多少只鸡蛋？"
}
message.append(new_message)
response = openai.ChatCompletion.create(
    model="gpt-3.5-turbo",
    messages=message
)
a= response.choices[0].message["content"]
print(a)
assistant_message={
    "role":"assistant",'content':a
}
message.append(a)