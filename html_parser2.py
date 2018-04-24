#https://www.w3.org/TR/html4/sgml/dtd.html
import bs4 as bs
import urllib.request

sauce = urllib.request.urlopen('http://sports.news.naver.com/wfootball/news/read.nhn?oid=477&aid=0000120030&m_view=1&sort=LIKE')
soup = bs.BeautifulSoup(sauce, 'html')

print(soup.li)
