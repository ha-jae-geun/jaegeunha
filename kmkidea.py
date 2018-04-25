# -*- coding: utf-8 -*-
import requests
import urllib2
import re
from bs4 import BeautifulSoup 
def single_line(raw_str):
    return " ".join(raw_str.split())
 
def uni_to_utf8(unicode_str):
    return str(unicode_str.encode('utf-8'))
 
def printError(err_message):
    print(err_message)
 
def crawling(year, target_link):
    url = target_link
    r = requests.get(url)
    data = r.text
    soup = BeautifulSoup(data, 'html.parser')
    info = soup.find('div', class_='mv_info')
    if not info:
        return None
 
    content = soup.find('div',class_='story_area')
    if not content:
        return None
     
    uni_movie_name = info.find('h3', class_='h_movie')
    if not uni_movie_name:
        return None
     
    uni_movie_name = uni_movie_name.find('a')
    if not uni_movie_name:
        return None
 
    movie_name = uni_to_utf8(uni_movie_name.get_text())
    
    netizen_count = info.find('div',id=re.compile("pointNetizen"))
    if not netizen_count:
        return None
         
    netizen_count = netizen_count.find('em')
    if not netizen_count:
        return None
         
    netizen_count = netizen_count.get_text().replace(',',"")
    if int(netizen_count) < 50:
        return None
             
    score = info.find('a', id=re.compile("pointNetizen"))
    if not score:
        return None
     
    score = score.find('span',class_='st_on')['style']
    if not score:
        return None
 
    score = float(score.split(':')[1].split('%')[0])
 
    genres = info.find_all('a', href=re.compile("/movie/sdb/browsing/bmovie.nhn\?genre"))
     
    genre_array = []
    for genre in genres:
        genre_array.append(uni_to_utf8(genre.get_text()))
    grade_list = ['전체 관람가', '12세 관람가', '15세 관람가', '청소년 관람불가', '제한상영가', '등급보류']
    grade = info.find('a', href=re.compile("/movie/sdb/browsing/bmovie.nhn\?grade"))
    if not grade:
        return None
         
    grade = uni_to_utf8(grade.get_text())
    if grade in grade_list:
        grade = grade_list.index(grade)
    raw_main_story = content.find('p',class_='con_tx')
     
    if not raw_main_story:
        return None
     
    raw_main_story = raw_main_story.prettify(formatter="html")
    raw_main_story = (re.sub(r'<.*>',"",raw_main_story))
    uni_main_story = single_line((re.sub(r'&.*;',"",raw_main_story)))
    main_story = uni_to_utf8(uni_main_story)
     
    print ('[' + target_link + '] : get data')
    movie = {"year": year,
             "movie_name": movie_name,
             "score": score,
             "grade" : grade} #create movie
    print( movie)
    print("---------------------------------")    
     
def get_link(target_page):
    url = target_page
    r = requests.get(url)
    data = r.text
    soup = BeautifulSoup(data, 'html.parser')
     
    ul = soup.find('ul', class_='directory_list')
    return ul.find_all('a',href=re.compile("/movie/bi/mi/"))
      
def call_crawler():
    year = 2000
     
    for page in range(1,999):
        print(str(year) + 'year - [' + str(page) + '] page')
        target_page = 'http://movie.naver.com/movie/sdb/browsing/bmovie.nhn?year=' + str(year)  + '&page=' + str(page)
        r = requests.get(target_page)
        data = r.text
        soup = BeautifulSoup(data, 'html.parser')
     
        cur_page = soup.find('span', style='color:#FF7632').get_text()
     
        if page > int(cur_page):
            page = 1
            year = year + 1
         
        if year > 2017:
            break
     
        target_links = get_link(target_page)
        for target_link in target_links:
            crawling(year,'http://movie.naver.com'+target_link['href'])
 
call_crawler()