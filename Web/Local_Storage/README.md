# [브라우저별 로컬스토리지 삭제](https://doc.arcgis.com/ko/power-bi/get-started/clear-browser-storage.htm)


# 로컬 스토리지 코드
```javascript
        try {
            if(localStorage.getItem(favoritesKey) === certificateName) {
                callback("즐겨찾기를 삭제했습니다.")
            } else {
                localStorage.setItem(favoritesKey, certificateName);
            }
        } catch (e) {
            var msg = "브라우저의 '개인정보 보호 브라우징'을 해제 하여 주세요.\n[해제 방법]\n(우측 하단) 탭 전환 버튼 -> 개인 정보 보호 탭";

            errorcallback(new error());
        }
```

# 브라우저별 local storage false
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


# Local_Storage 사용 불가
```java
Are you testing this on a local HTML file? i.e. a file:/// URL?

localStorage is only available on HTTP websites. That hasn't changed in IE9 Dev Preview.
```
