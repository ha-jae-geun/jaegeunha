#https://www.w3.org/TR/html4/sgml/dtd.html
#http://cossmos.tistory.com/37
#https://movie.naver.com/movie/point/af/list.nhn?st=mcode&sword=136315&target=after
#https://movie.naver.com/movie/bi/mi/photoView.nhn?code=142739&imageNid=6600089
#https://movie.naver.com/movie/bi/mi/basic.nhn?code=136315
#https://movie.naver.com/movie/bi/mi/basic.nhn?code=84 import BeautifulSoup
import urllib.request
import requests
from bs4 import BeautifulSoup


url= "https://www.google.com/search?ei=HzrpWsjKJuTYjwTe95jIBw&q=%EB%A1%AF%EB%8D%B0%EC%8B%9C%EB%84%A4%EB%A7%88+%EB%8F%99%EB%9E%98+%EC%96%B4%EB%B2%A4%EC%A0%B8%EC%8A%A4&oq=%EB%A1%AF%EB%8D%B0%EC%8B%9C%EB%84%A4%EB%A7%88+%EB%8F%99%EB%9E%98+%EC%96%B4%EB%B2%A4%EC%A0%B8%EC%8A%A4&gs_l=psy-ab.3..35i39k1l2.204194.204441.0.204700.3.3.0.0.0.0.167.374.0j3.3.0....0...1.1j4.64.psy-ab..1.1.166....0.EsxfJWRgXvI"
headers = {'User-Agent' : 'test'}
r = requests.get(url, headers=headers)
soup= BeautifulSoup(r.text,'html.parser')


showtime_kind = soup.find_all("div",{"class":"DOGJyf"})
showtime_19 = 
print(showtime_kind)
# print(showtime_kind.find('14'))


# showtime_kind = soup.select('div.search')
# showtime_kind = soup.select('td:nth-of-type(1) > div.e3wEkd:nth-of-type(1) > div.ovxuVd')
# #showtime_kind = soup.select('td > div:nth-of-type(1) > div.ovxuVd')
# #showtime_kind = soup.select('div.e3wEkd:nth-type(0) > div.ovxuVd')
# print(showtime_kind)
# # li1 = soup.get_text()

# li2 = li1.find("div")
# print(li2)


# for div in soup.find_all("div"):
# 	print(soup.find("div",{"class":"SW9Xgc"}))
# 	print(soup.find('div',{"class":"ovxuVd"}))
# for div in soup.find_all("div",{"class":"JLxn7"}):
# 	print(div.get_text())
# # showtime_kind = soup.find_all('div',{"class":"ovxuVd"})
# showtime_time = soup.find_all("div",{"class":"SW9Xgc"})
# print(showtime_time[1])

# print(soup.find_all("div",{"class":"SW9Xgc"})) 	
# # print(soup.find_next("div",class_='SW9Xgc')) 	
# # print(soup.find("div",class_='SW9Xgc').prettify) 	

#lr_c_tc > div.tb_c.tb_stc > div > div > div:nth-child(2) > div.lr_c_vn
# showtime_kind = soup.find('div',{"class":"ovxuVd"})
#showtime_kind = soup.select_one('div.ovxuVd')
# showtime_kind = soup.find('div',{"class":"SW9Xgc"})
# print(showtime_kind.next_sibling)
