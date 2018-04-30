#https://www.w3.org/TR/html4/sgml/dtd.html
#http://cossmos.tistory.com/37
#https://movie.naver.com/movie/point/af/list.nhn?st=mcode&sword=136315&target=after
#https://movie.naver.com/movie/bi/mi/photoView.nhn?code=142739&imageNid=6600089
#https://movie.naver.com/movie/bi/mi/basic.nhn?code=136315
#https://movie.naver.com/movie/bi/mi/basic.nhn?code=89329


from bs4 import BeautifulSoup
import urllib.request
import requests
import datetime
from selenium import webdriver


url= "http://www.megabox.co.kr/?cinema=6001&menuId=theater-detail"
driver = webdriver.Chrome('/Users/beomi/Downloads/chromedriver')
driver.implicitly_wait(3)
driver.get(url)
# html = driver.page_source
# soup= BeautifulSoup(html,'html.parser')

li = soup.find_all("div")
print(li)

# for div in soup3.find_all("div"):
	# print(div)

# #CGV
# for div in soup3.find_all("div",{"class":"info-timetable"}):
# 	li = div.find_all('em')
# 	li2= BeautifulSoup(str(li),'html.parser')
# 	li3=li2.select('em')
# 	print(li3[0].text)

#동래 롯데 시네마
# for div in soup.find_all("div",{"class":"ovxuVd"}):
	# print(div.get_text())

#공주 메가박스
for div in soup2.find_all("html"):
	print(div)

#li = soup.find_all("body > div > div.sect-showtimes > ul > li:nth-child(1) > div > div:nth-child(2) > div.info-timetable > ul > li:nth-child(1) > a")
#li = soup.find_all(".item -> li > div > a")
#print(li)


#div=soup.find_all("div",{"class":"info-timetable"})
#li=soup.select("body > div > div.sect-showtimes")
#li=soup.select("body > div > div.sect-showtimes > ul > li:nth-child(1) > div > div:nth-child(2) > div.info-timetable > ul")
#print(li)

#li = soup.findAll("div")

#for name in li:
#   div = name.find_all("li")
#   row = [i.text for i in div]
#   print(name.get_text())


#----------
#sauce = urllib.request.urlopen(url).read()
#soup = bs.BeautifulSoup(sauce, 'lxml')

#li2 =soup.select("#contents > div.wrap-movie-chart > div.sect-movie-chart > ol:nth-child(2) > li:nth-child(1) > div.box-contents > a > strong")
#print(li2)


#for name in li:
#	name2 = name.get_text()
#	print(name2.decode('UTF-8'))
#----------
