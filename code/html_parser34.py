#https://www.w3.org/TR/html4/sgml/dtd.html
#http://cossmos.tistory.com/37

import bs4 as bs
import urllib.request

sauce = urllib.request.urlopen('http://www.cgv.co.kr/movies/?ft=0').read()
#sauce = urllib.request.urlopen('http://sports.news.naver.com/wfootball/news/read.nhn?oid=477&aid=0000120030&m_view=1&sort=LIKE').read()
soup = bs.BeautifulSoup(sauce, 'lxml')



#li2 =soup.select("#contents > div.wrap-movie-chart > div.sect-movie-chart > ol:nth-child(2) > li:nth-child(1) > div.box-contents > a > strong")

#print(li2[])




li = soup.findAll("div")

for name in li:
	print(name.get_text())


#for name in li:
#   div = name.find_all("li")
#   row = [i.text for i in div]
#   print(name.get_text())
#   print(row)
