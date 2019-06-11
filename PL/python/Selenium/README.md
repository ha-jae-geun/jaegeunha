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
