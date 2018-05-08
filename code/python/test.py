import urllib.request
from datetime import datetime,date
import requests
import os
import sys
from bs4 import BeautifulSoup
import ast
from selenium import webdriver

title = urllib.parse.quote_plus('롯데시네마 동래')
google_base ="https://www.google.com/search?ei=I8LrWqrgMsS3jwSv2pPwDQ&q="
google_url=  google_base + title
headers = {'User-Agent' : 'test'}
google_request = requests.get(google_url, headers=headers)
google_soup= BeautifulSoup(google_request.text,'html.parser')

google_li0=google_soup.find_all("div",{"class":"DOGJyf"})





for i in google_li0:
   google_li1=i.get_text()

google_index = google_li1.find('어벤져스')
print(google_index)
google_index = google_li1.find('Standard',100)
print(google_index)
google_index1 = google_li1.find('Standard',google_index)
print(google_li1[73:245])
google_index1 = google_li1.rfind('pm',73,248)
print(google_index1)

# soup= BeautifulSoup(str(google_li1[73:100]),'html.parser')
# print(soup)
# google_index = google_li1.find('Standard')
# print(google_index)
# google_li10 = soup.find_all("div",{"class":"DOGJyf"})
# for i in google_li10 :
#    google_li11=i.get_text()
#    print(i)