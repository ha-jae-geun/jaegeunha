# Local_Storage 사용 불가
```java
Are you testing this on a local HTML file? i.e. a file:/// URL?

localStorage is only available on HTTP websites. That hasn't changed in IE9 Dev Preview.
```


# local storage false
## ie
* 인터넷 옵션 -> Dom 사용 불가
* window.localstorage = null

## 크롬
* 쿠키 및 기타 사이트 차단
* window.localstorage; //에러


## edge
* window.localstorage; //에러


## firefox
* window.localstorage; //에러


## [Unavailable](https://wiki.almworks.com/display/strcloud/Local+Storage+Unavailable)
