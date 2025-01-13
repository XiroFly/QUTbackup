from selenium import webdriver
from selenium.webdriver.common.keys import Keys

driver = webdriver.Chrome()

# 打开百度首页
driver.get('https://www.baidu.com')

# 定位百度搜索框，并输入文字
search_box = driver.find_element('id', 'kw')
search_box.send_keys('Selenium 中文')

# 模拟回车键提交搜索
search_box.send_keys(Keys.RETURN)

# 获取页面标题
print(driver.title)

# 关闭浏览器
driver.quit()
