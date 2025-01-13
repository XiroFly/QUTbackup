import requests
from bs4 import BeautifulSoup
from urllib.parse import urlparse, urljoin

def fun(url):
    rep = requests.get(url) 
    soup = BeautifulSoup(rep.text, "html.parser")
    img_tag = soup.find("img")
    if img_tag is not None:
        img_url = img_tag.get("src")
        if img_url is not None:
            parsed_url = urlparse(url)
            base_url = f"{parsed_url.scheme}://{parsed_url.netloc}"#要拼接
            img_url = urljoin(base_url, img_url)
            img_resp = requests.get(img_url)
            with open("作业32.jpg", "bw") as fp:
                fp.write(img_resp.content)
            print("Downloaded")
        else:
            print("Image URL not found")
    else:
        print("Image tag not found")

fun("https://www.baidu.com/")