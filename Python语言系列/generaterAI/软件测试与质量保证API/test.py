import requests

# 目标 URL
url = "http://localhost:8/SpringShoppingMaven_war_exploded/addToCart"

# 请求参数
params = {"goodsId": 2}

# 发送 GET 请求
response = requests.get(url, params=params)

# 输出服务器响应结果
print("Status Code:", response.status_code)
print("Response Content:", response.text)
