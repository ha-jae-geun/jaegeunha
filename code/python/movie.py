#Robot
# url= "https://www.google.com/search?ei=HzrpWsjKJuTYjwTe95jIBw&q=%EB%A1%AF%EB%8D%B0%EC%8B%9C%EB%84%A4%EB%A7%88+%EB%8F%99%EB%9E%98+%EC%96%B4%EB%B2%A4%EC%A0%B8%EC%8A%A4&oq=%EB%A1%AF%EB%8D%B0%EC%8B%9C%EB%84%A4%EB%A7%88+%EB%8F%99%EB%9E%98+%EC%96%B4%EB%B2%A4%EC%A0%B8%EC%8A%A4&gs_l=psy-ab.3..35i39k1l2.204194.204441.0.204700.3.3.0.0.0.0.167.374.0j3.3.0....0...1.1j4.64.psy-ab..1.1.166....0.EsxfJWRgXvI"
# headers = {'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36'}
# r = requests.get(url, headers=headers)
# soup= BeautifulSoup(r.text,'html.parser')
#-----------------------------------------------


from bs4 import BeautifulSoup
import urllib.request
import requests
from datetime import datetime,date
import ast



# CGV
# def cgv_par(url3):
# 	html3=requests.get(url3).text
# 	soup3=BeautifulSoup(html3,'html.parser')
# 	for div in soup3.find_all("div",{"class":"info-movie"}):
# 		li = div.find_all('strong')
# 		li2 = BeautifulSoup(str(li),'html.parser')
# 		li2 = li2.get_text().replace(" ", "").replace("\n","").replace("\r","").split("[")
# 		print(li2)
# 	for div in soup3.find_all("div",{"class":"info-timetable"}):
# 		li = div.find_all('em')
# 		li2 = BeautifulSoup(str(li),'html.parser')
# 		print(li2.get_text())


# #megabox
##url= Request("https://www.google.com/search?ei=HzrpWsjKJuTYjwTe95jIBw&q=%EB%A1%AF%EB%8D%B0%EC%8B%9C%EB%84%A4%EB%A7%88+%EB%8F%99%EB%9E%98+%EC%96%B4%EB%B2%A4%EC%A0%B8%EC%8A%A4&oq=%EB%A1%AF%EB%8D%B0%EC%8B%9C%EB%84%A4%EB%A7%88+%EB%8F%99%EB%9E%98+%EC%96%B4%EB%B2%A4%EC%A0%B8%EC%8A%A4&gs_l=psy-ab.3..35i39k1l2.204194.204441.0.204700.3.3.0.0.0.0.167.374.0j3.3.0....0...1.1j4.64.psy-ab..1.1.166....0.EsxfJWRgXvI", headers={'User-Agent' : 'Mozilla/5.0'})
# def megabox_par(url2):
# 	html2=requests.get(url2).text
# 	soup2=BeautifulSoup(html2,'html.parseZr')
# 	for div in soup2.find_all("div",{"class":"JLxn7"}):
# 		print(div.get_text())
# 	for div in soup2.find_all("div",{"class":"ovxuVd"}):
# 	 	print(div.get_text())
# 	 #딕셔너리명={'key':'value', }

# #lotte
# def lotte_par(url1):
# 	html=requests.get(url).text
# 	soup= BeautifulSoup(html,'html.parser')
# 	for div in soup.find_all("div",{"class":"JLxn7"}):
# 		print(div.get_text())
# 	for div in soup.find_all("div",{"class":"ovxuVd"}):
# 			print(div.get_text())

#cgv_par('http://www.cgv.co.kr/common/showtimes/iframeTheater.aspx?areacode=207&theatercode=0128&date=20180427&screencodes=&screenratingcode=&regioncode=')
#lotte_par('https://www.google.com/search?ei=fX_iWvSBJqHYjwSD3IG4CQ&q=%EB%8F%99%EB%9E%98+%EB%A1%AF%EB%8D%B0+%EC%8B%9C%EB%84%A4%EB%A7%88&oq=%EB%8F%99%EB%9E%98+%EB%A1%AF%EB%8D%B0+%EC%8B%9C%EB%84%A4%EB%A7%88&gs_l=psy-ab.3..0j0i20i263k1j0i30k1l6j0i8i30k1l2.71704.73887.0.73985.22.12.1.0.0.0.190.1114.0j8.9.0.foo%2Csueb%3D1%2Ccfro%3D1...0...1.1j4.64.psy-ab..14.8.952.6..35i39k1j0i10k1.101.4ZWrLg5W9uQ')
#megabox_par('https://www.google.com/search?ei=RMnnWo_GGILKjwSn7rrYAQ&q=%EA%B3%B5%EC%A3%BC+%EB%A9%94%EA%B0%80%EB%B0%95%EC%8A%A4+%EC%83%81%EC%98%81%EC%8B%9C%EA%B0%84%ED%91%9C&oq=%EA%B3%B5%EC%A3%BC+%EB%A9%94%EA%B0%80%EB%B0%95%EC%8A%A4+%EC%83%81%EC%98%81%EC%8B%9C%EA%B0%84%ED%91%9C&gs_l=psy-ab.3..35i39k1j0.18480.21203.0.21305.29.16.0.0.0.0.217.1710.0j11j1.12.0....0...1.1j4.64.psy-ab..23.6.888...0i20i263k1j0i5i30k1j0i8i30k1.0.2cObe4g06to')


date = datetime.date(datetime.now())
print(type(date))
#-----------------------------
# for div in li:
#    #title = div.next_element
#    print(div.next_sibling)
	#print(div.text)




