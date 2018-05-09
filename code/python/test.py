import urllib.request
from datetime import datetime,date
import requests
import os
import sys
from bs4 import BeautifulSoup
import ast
from selenium import webdriver


# -*- coding: utf-8 -*-
a=0
client_id = "xu3aIzNFPuwE_QatTZdn"
client_secret = "lvGNtv3RtR"

def naver_parsing(string) :
   naver_html = naver_search_base + 'string'
   print(naver_html)
   naver_soup = BeautifulSoup(naver_html,"html.parser")
   return naver_soup


def change_xy(XY) :
   client_id = "ZBZRW93imkdPj8rZj96k"
   client_secret = "VH70zeukOD"
   encText = urllib.parse.quote(XY)
   url = "https://openapi.naver.com/v1/map/geocode?query=" + encText # json 결과
   # url = "https://openapi.naver.com/v1/map/geocode.xml?query=" + encText # xml 결과
   request = urllib.request.Request(url)
   request.add_header("X-Naver-Client-Id",client_id)
   request.add_header("X-Naver-Client-Secret",client_secret)
   response = urllib.request.urlopen(request)
   rescode = response.getcode()
   response_body = response.read()
   soup_response = BeautifulSoup(response_body,'html.parser')
   source=str(soup_response)
   s_index=str(source).find('"x"')
   e_index=str(source).find('"y"')
   final_xy=str(source)[s_index : e_index+ 20].replace(" ","").replace('"','').replace("\n","")
   return final_xy

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
choice=input("\n숫자를 입력하세요 " + "("+"1~" + str((len(li)))+")"+ '중에 고르세요!======> ')
if choice == '0' :
   exit()


naver_link =naver_search_base + li[int(choice)-1].get_text()
input_choice=li[int(choice)-1].get_text()

#print(naver_link)
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
      print("\t이름: "+movies[0]["title"].replace('<b>','').replace('</b>',''))
      print("\t감독: "+movies[0]["director"].replace('|',''))
      print("\t개봉: "+movies[0]["pubDate"])
      print("\t평점: "+movies[0]["userRating"])
   else:
      print("!!!!!!!현재 개봉순위에서 사용자님께서 요청한 자료를 찾을수없습니다. 혹시 이중에 있습니까?!!!!!\n")
      print(info.replace('[','').replace('{','').replace('}','').replace(']','').replace('\n\n\n\n','\n'))
else :
    print("Error Code:" + rescode)


print("=================================================================")
theater=input("영화관을 선택하세요 (롯데시네마 ,cgv ,메가박스 중에 고르세요 !)   ||=====>")
print("=================================================================")
enc_txt_theater = urllib.parse.quote_plus(theater) #urllib 라이브러리에 자동으로 utf-8 로 인코딩해주는 명령어 quote_plus를 써서 theater를 받는다.

area_address=input("어느 "+ theater + "가 가고싶으신가요 ?"+" ex)동래, 수원 .. "+"=====>")
print("=================================================================\n")
enc_txt_area = urllib.parse.quote_plus(area_address)  #urllib 라이브러리에 자동으로 utf-8 로 인코딩해주는 명령어 quote_plus를 써서 지역를 받는다.


if theater == '롯데시네마' or theater == '메가박스' :
   count = 0;
   google_base ="https://www.google.com/search?ei=I8LrWqrgMsS3jwSv2pPwDQ&q="
   google_url=  google_base + enc_txt_theater + enc_txt_area 
   #print(google_url)
   headers = {'User-Agent' : 'test'}
   google_request = requests.get(google_url, headers=headers)
   google_soup= BeautifulSoup(google_request.text,'html.parser')
   #print(google_soup)
   google_li1 = google_soup.find_all("a",{"class":"fl X4s2nb"}) #영화 제목 리스트 생성
   google_li2 = google_soup.find_all("div",{"class":"e3wEkd"}) #영화 상영 시간표 리스트 생성
   for i in google_li1 :
      google_find = i.get_text().find(input_choice)
      if google_find == -1 :
         count = count + 1      #i 가 google_li1 리스트를 차례로 열면서 요청한 영화가 있는지 검색 없으면 count를 1 올린다.
      else : break
   if count == len(google_li1) :
      print(area_address +' '+ theater +" 에서는" + "요청하신" + input_choice +"를 상영하지 않습니다 ㅠㅠ") #카운트로 있는지 없는지 체크할수있다.
      sys.exit()
   else :
      print(area_address+ ' '+ theater +'에서의'+' '+input_choice+' 상영예정시간은 다음과 같습니다.\n\n'+google_li2[count].get_text().replace('am','am\t').replace('pm','pm\t'))
elif theater == 'cgv' :
   date= datetime.date(datetime.now())
   cgv_date=str(date).replace("-","")
   naver_cgv = naver_search_base + enc_txt_theater + enc_txt_area
   print(naver_cgv)
   search_cgv = urllib.request.urlopen(naver_cgv).read() #url 불러들여 html 변수에 저장
   parser_cgv = BeautifulSoup(search_cgv,"html.parser") # html.parser 로 파싱 , xml 형식으로도 가능
   li_cgv0=parser_cgv.find("div",class_="sp_website section")
   li_cgv1=li_cgv0.get_text()
   li_cgv2=li_cgv1.find("theaterCode=")
   cgv_theaternum=li_cgv1[li_cgv2+12:li_cgv2+16]
   cgv_base ="http://www.cgv.co.kr/common/showtimes/iframeTheater.aspx?&theatercode="
   cgv_url = cgv_base+str(cgv_theaternum)+"&date="+str(cgv_date)+"&screencodes=&screenratingcode=&regioncode="
   #print(cgv_url)
   cgv_html = urllib.request.urlopen(cgv_url).read() #url 불러들여 html 변수에 저장
   cgv_soup = BeautifulSoup(cgv_html,"html.parser")
   cgv_li=cgv_soup.find_all("div",{"class":"col-times"})
   for i in cgv_li :
      time_table = i.get_text()
      if time_table.find(input_choice) != -1 : 
         print(time_table.replace(" ","").replace("\n\n\n\n","").replace("\n\n\n","\n--------------").replace("\n\n","\n----------------"))
         a=a+1
   if len(cgv_li)-a == len(cgv_li):
      print(address + "에는 요청하신 영화를 상영하지 않습니다 ㅠㅠ")
      sys.exit()

else : 
   print("잘못 입력하셨습니다! 다시 시도해주세요 ㅎ_ㅎ")

mapping_choice=input("\ngoogle map에서 거리를 검색하시겠습니까? (y / n) ==>")
where_are_u = input("\n지금 어디에 계십니까? ==>")
if mapping_choice == 'y' or mapping_choice == 'Y' :
   url_maps= "https://www.google.com/maps/dir///@37.5575956,-122.289169,15z"
   chrome_path=os.path.join(os.path.dirname(os.path.realpath(__file__)),'chromedriver')
   driver = webdriver.Chrome(chrome_path)
   driver.implicitly_wait(3)
   driver.get(url_maps)
   username=driver.find_element_by_css_selector("#sb_ifc50 > input")
   username.send_keys(where_are_u)
   username=driver.find_element_by_css_selector("#sb_ifc51 > input")
   username.send_keys(area_address+theater)
   username=driver.find_element_by_css_selector("#directions-searchbox-1 > button.searchbox-searchbutton")
   username.click()


else : print("프로그램을 종료합니다 !") 