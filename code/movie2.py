#https://www.w3.org/TR/html4/sgml/dtd.html
#http://cossmos.tistory.com/37
#https://movie.naver.com/movie/point/af/list.nhn?st=mcode&sword=136315&target=after
#https://movie.naver.com/movie/bi/mi/photoView.nhn?code=142739&imageNid=6600089
#https://movie.naver.com/movie/bi/mi/basic.nhn?code=136315
#https://movie.naver.com/movie/bi/mi/basic.nhn?code=84 import BeautifulSoup
import urllib.request
import requests
from bs4 import BeautifulSoup


url= "https://www.google.com/search?source=hp&ei=L3HiWsGgJKqMjwS6_KnAAw&q=%EA%B3%B5%EC%A3%BC+%EB%A9%94%EA%B0%80%EB%B0%95%EC%8A%A4+%EC%83%81%EC%98%81%EC%8B%9C%EA%B0%84%ED%91%9C&oq=%EA%B3%B5%EC%A3%BC+%EB%A9%94%EA%B0%80%EB%B0%95%EC%8A%A4+%EC%83%81%EC%98%81%EC%8B%9C%EA%B0%84%ED%91%9C&gs_l=psy-ab.3..0.679.679.0.851.2.1.0.0.0.0.120.120.0j1.1.0.foo%2Csueb%3D1%2Ccfro%3D1...0...1.1.64.psy-ab..1.1.119.0...0.CWnlec-6AHs="
html=urllib.request.urlopen(url).read()
soup= BeautifulSoup(html,'html.parser')


for div in li.find_all('div'):
	print(div)
	#li2= BeautifulSoup(str(li),'html.parser')
	#li2 = BeautifulSoup(str(li), 'html.parser')
	 
	
#동래
#for div in soup.select('section > div > div'):
#	print(div.select(''))
    #span = div.select("ul > li > a > span")

