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


url= "https://www.google.com/search?ei=fX_iWvSBJqHYjwSD3IG4CQ&q=%EB%8F%99%EB%9E%98+%EB%A1%AF%EB%8D%B0+%EC%8B%9C%EB%84%A4%EB%A7%88&oq=%EB%8F%99%EB%9E%98+%EB%A1%AF%EB%8D%B0+%EC%8B%9C%EB%84%A4%EB%A7%88&gs_l=psy-ab.3..0j0i20i263k1j0i30k1l6j0i8i30k1l2.71704.73887.0.73985.22.12.1.0.0.0.190.1114.0j8.9.0.foo%2Csueb%3D1%2Ccfro%3D1...0...1.1j4.64.psy-ab..14.8.952.6..35i39k1j0i10k1.101.4ZWrLg5W9uQ"
url2= "http://www.megabox.co.kr/?cinema=6001&menuId=theater-detail"
url3= "http://www.cgv.co.kr/common/showtimes/iframeTheater.aspx?areacode=207&theatercode=0128&date=20180427&screencodes=&screenratingcode=&regioncode="
html=requests.get(url).text
html2=requests.get(url2).text
html3=requests.get(url3).text
soup= BeautifulSoup(html,'html.parser')
soup2=BeautifulSoup(html2,'html.parser')
soup3=BeautifulSoup(html3,'html.parser')

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
