import os
import requests
from bs4 import BeautifulSoup
from urllib.parse import urlparse
import re
def download_images(url, folder):#软件213白鹏飞202111050676
    # 发起网络请求
    response = requests.get(url)
    # 解析HTML内容
    soup = BeautifulSoup(response.content, 'html.parser')
    # 获取所有的图片标签
    img_tags = soup.find_all('img', class_='BDE_Image')
    
    # 创建保存图片的文件夹
    if not os.path.exists(folder):
        os.makedirs(folder)
    
    # 下载并保存图片
    for img_tag in img_tags:
        img_url = img_tag['src']
        prased_path= urlparse( img_url)
        img_name = prased_path.path.split('/')[-1]
        
        img_path = os.path.join(folder, img_name)
        
        print(f'Downloading: {img_url}')
        
        try:
            img_data = requests.get(img_url).content
            with open(img_path, 'wb') as f:
                f.write(img_data)
            print(f'Saved: {img_path}')
        except Exception as e:
            print(f'Error occurred while downloading {img_url}: {str(e)}')
        
def crawl_images(url):
    # 发起网络请求
    response = requests.get(url)
    # 解析HTML内容
    soup = BeautifulSoup(response.content, 'html.parser')
    # 获取所有的页码链接
    pattern=re.compile(r"[1-9]") #匹配
    page_links = set(soup.find_all('a',string=pattern))
    for page_link in page_links:
        page_url = page_link['href']
        
        full_page_url = 'https://tieba.baidu.com' + page_url
        download_images(full_page_url, 'images')

# 主函数
if __name__ == '__main__':
    # 贴子的URL
    post_url = "https://tieba.baidu.com/p/8481726282"
    # download_images(post_url,'images' )   
    # 爬取图片
    crawl_images(post_url)
