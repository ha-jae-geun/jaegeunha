```python
from tinydb import TinyDB
from selenium import webdriver
import time

url = "https://search.naver.com/search.naver?sm=tab_sug.top&where=nexearch&query=%EA%B0%95%EB%82%A8%EC%97%AD+%EB%A7%9B%EC%A7%91&oquery=%EA%B0%95%EB%82%A8%EC%97%AD&tqi=Un8gtdpVuECsstN44KwssssstKN-400626&acq=%EA%B0%95%EB%82%A8%EC%97%AD+&acr=1&qdt=0"
driver = webdriver.Chrome()
driver.get(url)
time.sleep(1)
total = driver .find_elements_by_css_selector('div.list_item_inner > div.info_area')
name = driver.find_elements_by_css_selector('div.tit > span > a > span')
button = driver.find_element_by_css_selector('#place_main_ct > div > div > div.sc_box.place_list > div.list_area > div > a.btn_direction.btn_next')
file = "restaurant.json"
db = TinyDB(file)
# db.purge_tables( )
table = db.table('foods')

for i in range (1,21):
    for name2 in total:
        name3 = name2.find_element_by_css_selector("a.name > span")
        review = name2.find_element_by_css_selector("div.etc_area.ellp > span.item")
        table.insert({'name': name3.text, 'review': review.text})
        print(name3.text)
        print(review.text)
    button.click()
    time.sleep(1)
print(table.all( ))

```

```SQL
# 강남 맛집 검색 및 리뷰 숫자 가져오기

from selenium import webdriver
from bs4 import  BeautifulSoup
import  time
from tinydb import TinyDB

# chromedriver 드라이버 추출하기
browser = webdriver.Chrome("D:\chromedriver.exe")

# 3초 대기하기
browser.implicitly_wait(3)

# 네이버 URL
b_url = "https://www.naver.com"
browser.get(b_url)

# 검색 단어 입력
search = browser.find_element_by_name("query")
search.clear()
search.send_keys("강남 맛집")
button = browser.find_element_by_id("search_btn")
button.submit()

time.sleep(1)

# 가게정보
title = []
# 페이지 수
page = 1

# 데이터 추출하기
while(True):
    html = browser.page_source

    # html 분석하기
    soup = BeautifulSoup(html, 'html.parser')

    # 6개 큰 부분 출력하기
    data = soup.find_all("div", {"class": "list_item_inner"})

    for i in data:
        # 데이터 추출하기
        datadict = {}
        name = i.select_one("div.tit > span > a > span ").string
        review_list = i.select("div.etc_area.ellp > span.item")
        review = review_list[0].text
        datadict[name] = review
        title.append(datadict)

    # 페이지 넘기는 버튼 클릭
    browser.find_element_by_xpath("//*[@id='place_main_ct']/div/div/div[2]/div[4]/div/a[2]").click()
    #3초 대기
    time.sleep(3)


    if page == 20:
        break
    else :
        # 페이지 증가
        page = page + 1


# DB에 데이터 저장
db = TinyDB("gangname.json")
table = db.table('gangnam')

for i in title:
   for name, view in i.items():
       table.insert({'title': name, 'review': view})


print(table.all())
```
