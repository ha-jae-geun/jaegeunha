
#username=driver.find_element_by_id("#search\2e tab2")
#	title = urllib.parse.quote_plus(title)

from bs4 import BeautifulSoup 
import urllib.request
import requests
import datetime
from selenium import webdriver




#예고편
def trailer(title):
	title = urllib.parse.quote_plus(title)
	url= "https://www.youtube.com/results?search_query=" + title
	driver = webdriver.Chrome("C:\\Users\\jaegeun\\Downloads\\chromedriver.exe")
	driver.set_page_load_timeout(30)
	driver.get(url)
	username = driver.find_element_by_css_selector('#thumbnail')
	username.click()



# #영화
# title = '타클라마칸 예고편'
# title = urllib.parse.quote_plus(title)
# url= "https://www.youtube.com/results?search_query=" + title
# driver = webdriver.Chrome("C:\\Users\\jaegeun\\Downloads\\chromedriver.exe")
# driver.set_page_load_timeout(30)
# driver.get(url)
# username = driver.find_element_by_css_selector('#thumbnail')
# username.click()




## 구글 지도
url= "https://www.google.com/maps/dir///@37.5575956,-122.289169,15z"
driver = webdriver.Chrome("C:\\Users\\jaegeun\\Downloads\\chromedriver.exe")
driver.implicitly_wait(3)
driver.get(url)
username=driver.find_element_by_css_selector("#sb_ifc50 > input")
username.send_keys("경상대")
username=driver.find_element_by_css_selector("#sb_ifc51 > input")
username.send_keys("수원역 CGV")
username=driver.find_element_by_css_selector("#directions-searchbox-1 > button.searchbox-searchbutton")
username.click()
