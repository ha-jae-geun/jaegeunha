#https://www.w3.org/TR/html4/sgml/dtd.html
#http://cossmos.tistory.com/37

from bs4 import BeautifulSoup
import urllib.request
import requests


url= "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EC%96%B4%EB%B2%A4%EC%A0%80%EC%8A%A4"
html=requests.get(url).text
soup= BeautifulSoup(html,'html.parser')


for div in soup.find_all("div"):
	li=div.find_all("a")
	for div2 in li.find_all("a") 

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
