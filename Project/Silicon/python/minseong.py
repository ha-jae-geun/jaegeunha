import urllib.request
from datetime import datetime,date
import requests
import os
import sys
from bs4 import BeautifulSoup
import ast
from selenium import webdriver


client_id = "xu3aIzNFPuwE_QatTZdn"
client_secret = "lvGNtv3RtR"

def naver_parsing(string) :
   naver_html = naver_search_base + 'string'
   print(naver_html)
   naver_soup = BeautifulSoup(naver_html,"html.parser")
   return naver_soup


naver_search_base= "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query="
url = "http://www.cgv.co.kr/movies/?ft=0"
html = urllib.request.urlopen(url).read() #url 불러들여 html 변수에 저장
soup = BeautifulSoup(html,"html.parser") # html.parser 로 파싱 , xml 형식으로도 가능

 
li = soup.find_all("strong", {"class" : "title"})  # strong 에 class:title인 모든 태그를 긁어온다.
count = 1

print("\n")

print("< 오늘은 몇일 ?! >" + " : " + str(datetime.date(datetime.now()))) #오늘 일자를 알려줌. 

print("\n")

print("----------현재상영작-------------\t")
print("\t\t\t\t |")
for name in li:
   print(str(count) + "위", name.get_text())
   print("\t\t\t\t |")
   count = count +1
print("---------------------------------\t") 

print("\n어떤 영화를 보고싶으세요 ?===> (그만두려면 '0'을 누르세요) ")
choice=input("\n숫자를 입력하세요 :" + "("+ "1~" + str((len(li)))+ '중에 고르세요!'+")")
if choice == '0' :
   exit()


naver_link =naver_search_base + li[int(choice)-1].get_text()
input_choice=li[int(choice)-1].get_text()

print(naver_link)

encText = urllib.parse.quote_plus(input_choice)
open_url = "https://openapi.naver.com/v1/search/movie?query=" + encText

request = urllib.request.Request(open_url)
request.add_header("X-Naver-Client-Id",client_id)
request.add_header("X-Naver-Client-Secret",client_secret)
response = urllib.request.urlopen(request)
rescode = response.getcode()

#symbolslist = soup_response.find('table').tr.next_siblings
if(rescode==200):
   response_body=response.read()
   soup_response = BeautifulSoup(response_body,'html.parser')
   info = str(soup_response) #bs4 양식을 str 형태로 바꿔준다
   s_index = str(info).find('[') # items 는 []로 묶여있으므로 []의 좌표를 찾는다 
   e_index = str(info).find(']')
   movies = ast.literal_eval(info[s_index:e_index+1]) # 그부분을 리스트로 변환시켜준다.
   
   create_type = '<b>' + input_choice + '</b>'
   if create_type == movies[0]["title"]:
      print("\t감독: "+movies[0]["director"])
      print("\t개봉: "+movies[0]["pubDate"])
      print("\t평점: "+movies[0]["userRating"])
   else:
      print("\n\n")
      print("!!!!!!!현재 개봉순위에서 사용자님께서 요청한 자료를 찾을수없습니다. 혹시 이중에 있습니까?!!!!!\n")
      print(info)      
else :
    print("Error Code:" + rescode)


# gps 
address=input("영화관을 선택하세요! :")
enc_txt = urllib.parse.quote_plus(address) # encoding 하여 enc_txt 라는 변수에 넣어둔다.
gps_address = naver_search_base + enc_txt # 미리 정해둔 naver_search_base 에 encoding된 chg_txt를 더한다
gps_html = urllib.request.urlopen(gps_address).read().decode('utf8') #
gps_soup = BeautifulSoup(gps_html,"html.parser") # html 형식으로 파싱
gps_if = gps_soup.find("div",class_="dti_box") # div 태그 안에 class 가 dti_box 인 것을 끌어온다.
gps_if1 = gps_if.find("dd") # 그안에서 필요한것은 주소뿐이므로 dd 태그를 끌어온다.
gpsFinal=gps_if1.get_text() # 태그를 빼고 안에 contents 만 출력한다.

print("\n")

choice_add=input("당신은 어디에 계신가요? :")

print("\n")

url= "http://map.daum.net/"
driver = webdriver.Chrome("C:\\Users\\jaegeun\\Downloads\\chromedriver.exe")
driver.implicitly_wait(3)
driver.get(url)
username=driver.find_element_by_id("search.tab2")
username.click()
driver.implicitly_wait(300)
username=driver.find_element_by_id("info.route.waypointSuggest.input0")
username.send_keys(choice_add)
username=driver.find_element_by_id("info.route.waypointSuggest.input1")
username.send_keys(gpsFinal)
username=driver.find_element_by_css_selector("#info\2e route\2e searchBox > div:nth-child(3) > span.waypointWindow > input")
username.click()