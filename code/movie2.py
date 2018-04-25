import urllib.request
import datetime
import time
import requests
from bs4 import BeautifulSoup

url = "http://www.cgv.co.kr/movies/?ft=0"
html = urllib.request.urlopen(url).read() #url 불러들여 html 변수에 저장
soup = BeautifulSoup(html,"html.parser")


#li2= soup.select("#body > div > div.sect-showtimes > ul > li:nth-child(1) > div > div:nth-child(2) > div.info-timetable > ul > li:nth-child(2) > a > em")
li=soup.find_all("div",{"class":"info-timetable"})
print(li)
print(soup)

for name in li:
   print(name.get_text())


   #div = soup.find_all("div")

#li = soup.find_all("strong",{"class:":"title"})

#body > div > div.sect-showtimes > ul > li:nth-child(1) > div > div:nth-child(2) > div.info-timetable > ul > li:nth-child(2) > a > em

#li = soup.find_all("em")