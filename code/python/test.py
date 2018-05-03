import urllib.request
import requests
from bs4 import BeautifulSoup


url= "https://www.google.com/search?ei=HzrpWsjKJuTYjwTe95jIBw&q=%EB%A1%AF%EB%8D%B0%EC%8B%9C%EB%84%A4%EB%A7%88+%EB%8F%99%EB%9E%98+%EC%96%B4%EB%B2%A4%EC%A0%B8%EC%8A%A4&oq=%EB%A1%AF%EB%8D%B0%EC%8B%9C%EB%84%A4%EB%A7%88+%EB%8F%99%EB%9E%98+%EC%96%B4%EB%B2%A4%EC%A0%B8%EC%8A%A4&gs_l=psy-ab.3..35i39k1l2.204194.204441.0.204700.3.3.0.0.0.0.167.374.0j3.3.0....0...1.1j4.64.psy-ab..1.1.166....0.EsxfJWRgXvI"
headers = {'User-Agent' : 'test'}
r = requests.get(url, headers=headers)
soup= BeautifulSoup(r.text,'html.parser')


li3=soup.find_all("div",{"class":"DOGJyf"})
#print(li3)
for i in li3 :
   li4=i.get_text()
li5 = li4.find("Standard")
#print(li5)
title="어벤져스: 인피니티 워"
li6=li4.find(title)
li10=li4[li6+len(title):len(li4)]
