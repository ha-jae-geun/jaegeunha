#https://www.w3.org/TR/html4/sgml/dtd.html
#http://cossmos.tistory.com/37
#https://movie.naver.com/movie/point/af/list.nhn?st=mcode&sword=136315&target=after
#https://movie.naver.com/movie/bi/mi/photoView.nhn?code=142739&imageNid=6600089
#https://movie.naver.com/movie/bi/mi/basic.nhn?code=136315
#https://movie.naver.com/movie/bi/mi/basic.nhn?code=89329


from bs4 import BeautifulSoup
import urllib.request
import requests


url= "https://www.google.com/search?ei=jhbhWv6EFdCAtgWvs4O4Bw&q=%EB%8F%99%EB%9E%98%EB%A1%AF%EB%8D%B0%EC%8B%9C%EB%84%A4%EB%A7%88&oq=%EB%8F%99%EB%9E%98&gs_l=psy-ab.3.1.35i39k1l2j0l8.1833.2495.0.4082.5.5.0.0.0.0.141.619.0j5.5.0.foo%2Csueb%3D1%2Ccfro%3D1...0...1.1j4.64.psy-ab..0.5.617....0.WSR_5tQm4GU"
html=requests.get(url).text
soup= BeautifulSoup(html,'html.parser')

#동래
for div in soup.find_all("div",{"class":"ovxuVd"}):
	print(div.get_text())

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
