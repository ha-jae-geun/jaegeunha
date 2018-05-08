#https://www.w3.org/TR/html4/sgml/dtd.html
#http://cossmos.tistory.com/37
#https://movie.naver.com/movie/point/af/list.nhn?st=mcode&sword=136315&target=after
#https://movie.naver.com/movie/bi/mi/photoView.nhn?code=142739&imageNid=6600089
#https://movie.naver.com/movie/bi/mi/basic.nhn?code=136315
#https://movie.naver.com/movie/bi/mi/basic.nhn?code=84 import BeautifulSoup
import urllib.request
import requests
from bs4 import BeautifulSoup


url= "https://www.google.com/search?source=hp&ei=QBPxWrHyKMukjwTX67m4BA&q=%EB%A9%94%EA%B0%80%EB%B0%95%EC%8A%A4+%EA%B3%B5%EC%A3%BC&oq=&gs_l=psy-ab.1.0.35i39k1l6.0.0.0.3535.3.1.0.0.0.0.0.0..1.0....0...1..64.psy-ab..2.1.106.6...106.nDwSMUe9d5Q"
headers = {'User-Agent' : 'test'}
r = requests.get(url, headers=headers)
soup= BeautifulSoup(r.text,'html.parser')





# #롯데시네마
# for div in soup.find_all("div",{"class":"ovxuVd"}):
# 	show_time = div.get_text()
# 	print(show_time)
# show_start = show_time.find('어벤져스')
# print(show_time)


#메가박스
# for div in soup.find_all("div",{"class":"JLxn7"}):
# 	print(div.get_text())
# for div in soup.find_all("div",{"class":"ovxuVd"}):
# 	print(div)




#메가박스
# for div in soup.find_all("div",{"class":"SW9Xgc"}):
# 	show_time = div.get_text()
# show_start = show_time.find('어벤져스')
# show_end = show_time.find('어벤져스')
# print(show_time[47:])



# # show_kind = BeautifulSoup(str(show_time), 'html.parser')
# show_time = soup.find_all("div",{"class":"DOGJyf"})
# for div in soup.find_all("div",{"class":"DOGJyf"}):
# 	show_time = div.get_text()
# show_start = show_time.find('어벤져스')
# show_end = show_time.find('어벤져스')
# print(show_time[47:])
# show_kind = BeautifulSoup(str(show_time), 'html.parser')



showtime_kind = soup.select('div.e3wEkd:nth-of-type > div.ovxuVd')
showtime_kind = soup.select('*:nth-of-type(1) > div > div.ovxuVd')
showtime_kind = soup.select('span')
showtime_kind = soup.select('td > div. > div.ovxuVd')
print(showtime_kind)



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
