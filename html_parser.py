#https://www.w3.org/TR/html4/sgml/dtd.html
import bs4 as bs
import urllib.request

sauce = urllib.request.urlopen('https://google.com').read()
soup = bs.BeautifulSoup(sauce, 'lxml')

print(soup.title.text)

#for paragraph in soup.find_all('p'):
    #print(paragraph.)


#url get
for url in soup.find_all('a'):
    print(url.get('href'))

print("--------")

#div
for div in soup.find_all('div'):
    print(div.text)

print("--------")

for div in soup.find_all('div', class_='body'):
    print(div.text)
    print("--------")
