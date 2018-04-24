#https://www.w3.org/TR/html4/sgml/dtd.html
#http://cossmos.tistory.com/37

import bs4 as bs
import urllib.request

sauce = urllib.request.urlopen('http://sports.news.naver.com/wfootball/news/read.nhn?oid=477&aid=0000120030&m_view=1&sort=LIKE').read()
soup = bs.BeautifulSoup(sauce, 'lxml')



li = soup.findAll("div", {"class":{"wrap"}})


for name in li:
	print(name.get_text())


#for name in li:
#   div = name.find_all("li")
#   row = [i.text for i in div]
#   print(name.get_text())
#   print(row)
