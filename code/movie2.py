#https://www.w3.org/TR/html4/sgml/dtd.html
#http://cossmos.tistory.com/37
#https://movie.naver.com/movie/point/af/list.nhn?st=mcode&sword=136315&target=after
#https://movie.naver.com/movie/bi/mi/photoView.nhn?code=142739&imageNid=6600089
#https://movie.naver.com/movie/bi/mi/basic.nhn?code=136315
#https://movie.naver.com/movie/bi/mi/basic.nhn?code=84 import BeautifulSoup
import urllib.request
import requests
from bs4 import BeautifulSoup


url= "http://m.cgv.co.kr/Schedule/?tc=0001&t=T&ymd=20180426&src="
html=urllib.request.urlopen(url).read()
soup= BeautifulSoup(html,'html.parser')


for div in soup:
	li = soup.select('div','class')
	print(li)
	#li2= BeautifulSoup(str(li),'html.parser')
	#li2 = BeautifulSoup(str(li), 'html.parser')
	 
	
#동래
#for div in soup.select('section > div > div'):
#	print(div.select(''))
    #span = div.select("ul > li > a > span")

