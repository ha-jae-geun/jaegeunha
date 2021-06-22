# onmousemove
```java

Despite what the MSDN docs say, onmousemove doesn't work when applied to the window object. 
It should work in all browsers if you apply it to the document object instead:

document.onmousemove = function(e) {
    e = e || window.event;
    var copyLabel = document.getElementById("<%= lblCopyEnabled.ClientID %>");
    if (e.shiftKey) {
        copyLabel.style.display = "inline";
        ob_copyOnNodeDrop = true;
    }
    else {
        copyLabel.style.display = "none";
        ob_copyOnNodeDrop = false;
    }
}
```


# [document 객체](https://www.zerocho.com/category/JavaScript/post/573b3235a54b5e8427432947)


# document load 이벤트와 document DOMContentLoaded 차이
```javascript
document load 이벤트와 document DOMContentLoaded 이벤트의 차이점은 무엇인가요?
DOMContentLoaded 이벤트는 스타일시트, 이미지, 서브프레임 로딩을 기다리지 않고, 초기 HTML 문서가 완전히 로드되고 파싱되면 발생합니다.

window의 load 이벤트는 DOM과 모든 종속 리소스와 에셋들이 로드된 후에 ​​발생합니다
```
