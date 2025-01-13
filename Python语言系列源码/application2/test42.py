import requests
from bs4 import BeautifulSoup
url="https://news.sina.com.cn/"
#<ul class="uni-blk-list02 list-a list-0427" style="padding-top: 7px;">
response=requests.get(url)#ISO-8859-1
response.encoding="utf-8"
print(response.headers.get('Content-Type'),response.encoding)#要设置编码否则python默认推测为ISO-8859-1，实际为utf-8
soup=BeautifulSoup(response.text,"html.parser")
hot_news=soup.find_all("ul",attrs={"class":"uni-blk-list02 list-a list-0427","style":"padding-top: 7px;"})
for ul in hot_news:
    for i in ul.descendants:
        if i.name=="a":
          print("标题：",i.text)
          print("链接：",i["href"],end="\n\n")
    