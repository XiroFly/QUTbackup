from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# 创建一个浏览器对象（这里使用Chrome，你也可以选择其他浏览器）
driver = webdriver.Chrome()

# 打开网页
url = "https://bilibili.com"  # 请替换为你要访问的网页地址
driver.get(url)

# 等待一定时间，让页面加载完毕（你也可以使用其他等待条件）
wait = WebDriverWait(driver, 10)
# wait.until(EC.presence_of_element_located((By.ID, "example_element_id")))

# 获取页面内容
page_source = driver.page_source
print(page_source)
# 在这里你可以对page_source进行解析，提取需要的信息
# 例如，使用BeautifulSoup等库进行解析

# 关闭浏览器
driver.quit()
