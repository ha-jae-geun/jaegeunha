# [리베하얀](https://www.youtube.com/watch?v=QQXvASCMp-g)

# 기본
* input 요소, a 요소, button 요소 등이 키보드 탭 키로 이동이 가능한 대상


# 테스트 툴
* pc : 센스리더
* aos : 보이스어시스턴스
* ios ; 보이스오버 


# iframe
* iframe에 title 삽입


# Select
```javascript
(안1) 레이블을 제거해 주세요.

<select id="bb" name="bb" title="옵션 선택(제목,내용)">
<option value="title" selected=selected>제목</option>
<option value="desc" >내용</option>
</select>
<input type="text" name="cc" title="검색내용을 입력해주세요" onkeydown="ddd()" value=""/>
<a href="#a" onclickXXX="eee()"><img src="/imag/img.gif" alt="검색" /></a>



(안2) 명시적인 레이블을 주시고, 필요에 따라 레이블을 숨겨 주세요.

<label for="bb">옵션 선택(제목, 내용)</label>
<select id="bb" name="bb">
<option value="title" selected=selected>제목</option>
<option value="desc" >내용</option>
</select>
<label for="cc">검색어</label>
<input type="text" id="cc" onkeydown="ddd()" value=""/>
<a href="#a" onclickXXX="eee()"><img src="/imag/img.gif" alt="검색" /></a>
```

# input
* Input에 label/title 삽입
* 기본적으로  키보드 탭 키로 이동이 가능한 대상


## [input 에서 label](https://mygumi.tistory.com/359)
* label이 제공되기 어려운 경우에 한하여 title 값으로 대체제공하는 것이 바람직하며, label과 title을 중복하여 제공해 주실 필요는 없습니다. (권장하지 않음)
* 묵시적이 label 역시 스크린리더 사용에 문제가 발생하고 있어, 명시적인 label을 사용하는 것을 권장합니다.


# img
* img 파일에 alt 삽입

# a tag
* a tag에 title 삽입
* 기본적으로  키보드 탭 키로 이동이 가능한 대상


## [a 태그에서 href 없애는 이유](https://ooz.co.kr/382)
1. 마우스 화살표
2. tab키 사라짐

```java
div 하위 영역들은 tabindex="-1" 설정으로 탭을 통해 포커스가 잡히지 않게 된다.

이렇게 한 이유는 무엇일까?

a 태그들에게 tabindex="-1"을 설정해주지 않는다면 탭 키를 통해 a태그 각각 포커스가 잡히게 된다.

즉, 내 서재 목록 영역 -> 1000$ 게놈 -> 100권의 금서 ..... -> 2030 에너지 전쟁 -> 남이야 뭐라 하건! -> .....

이런 식으로 탭을 눌렀을 때 포커스가 맞춰지게 된다.

그렇다는 건, 일일이 탭을 통해 a태그 전부를 거쳐야만 다음 주제 영역에 포커스가 맞춰질 수 있다.

이러한 경우에는 탭이 아닌 방향키를 통해 포커스를 설정하는 것이 흐름 상으로도 그렇고, 스크린 리더 사용자에게도 효율적이다.

그리하여 tabindex="-1" 을 통해 방향키를 통해서만 포커스가 맞춰지게 하도록 설정한 것이다.

```

# alert
* 비밀번호 입력/빈값 alert 창


# tabindex
* 프로그램 밖으로 tab 벗어나지 않게 적용


# tab, shiftTab
```javascript
jquery 안에서 this 바뀌는것 조심

document.getElementById("confirm").addEventListener('keydown', function (key) {
    if (key.shiftKey && key.keyCode == 9) {
        elepwd.focus();
        key.preventDefault();
    }
        
    if (!(key.shiftKey) && key.keyCode == 9) {
        header_bar.focus();
        key.preventDefault();
    }
});

document.getElementById("ly_header0").addEventListener('keydown', function (key) {
    if (key.shiftKey && key.keyCode == 9) {
        confirmButton.focus();
        key.preventDefault();
    }
});
```


