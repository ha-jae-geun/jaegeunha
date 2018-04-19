#https://www.w3.org/TR/html4/sgml/dtd.html
import bs4 as bs
import urllib.request

sauce = urllib.request.urlopen('https://google.com')
soup = bs.BeautifulSoup(html_content)

print(soup.title)
