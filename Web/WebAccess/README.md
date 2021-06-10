# [리베하얀](https://www.youtube.com/watch?v=QQXvASCMp-g)

# 기본
* input 요소, a 요소, button 요소 등이 키보드 탭 키로 이동이 가능한 대상


# 테스트 툴
* pc : 센스리더
* aos : 보이스어시스턴스
* ios ; 보이스오버 

## [센스리더 다운로드](http://www.xvtech.com/)

## [센스리더](https://nuli.navercorp.com/community/article/1081603?email=true)

## [센스리더 설정](https://consumer.kiwoom.com/nkw.templateFrameSet.do?m=m1504010000)

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

```java
label 이 시각적으로 표시되는 경우, title 을 사용하지 않는다.
label 이 시각적으로 표시되지 않지만, 인접한 시각적 보충텍스트가 존재하는 경우 title 을 사용하지 않는다.
label 이 시각적으로 표시되지 않고, 인접한 시각적 보충텍스트가 존재하지 않는 경우 title 을 중복 사용한다.
label 이 시각적으로 표시되지 않고, 인접한 시각적 보충텍스트가 존재하지 않으면서 동시에 해당 서식이 다른 서식의 기능을 보조하며, 
실제 서버로 값을 전송하지 않는 경우 title 을 중복 사용한다.
문맥과 정황을 고려하여 input 의 기능을 쉽사리 유추할 수 있는 경우 title 은 label 보다 간략하게 작성하거나 생략한다. 
예를 들어, '회원님들에 대한 안내문 메일' 이라는 label 이 있을 경우, title 은 '메일' 정도로 간략하게 작성하거나 생략한다.
모바일 디바이스 접속 시 placeholder 를 우선적으로 사용하고, radio, checkbox, select, textarea 인 경우 label 만 사용한다. 
(placeholder 로 label 을 대체할 수 없다고 html 스펙에 명시되어 있음을 fb 에서 황규연님이 알려주셨습니다. 참고해주세요.)

```


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

# [모바일 접근성 체크사항](https://developer.mozilla.org/ko/docs/Web/Accessibility/Mobile_accessibility_checklist)

# [모바일 접근성](http://www.websoul.co.kr/accessibility/MA_guide.asp)

## [모바일 접근성 테스트 조건](http://www.wa.or.kr/m3/sub3.asp)

## [모바일 모달 포커스](https://d0gf00t.tistory.com/13)

## [모바일 title 대신 aria-label](https://www.tpgi.com/using-the-html-title-attribute-updated/)

## [Aria 바르게 사용하기](https://nuli.navercorp.com/community/article/1132937)
* aria-hidden: 센스 리더 안읽어주기
    * $("#yettie_iframe").siblings().attr("aria-hidden", "true")
* aria-modal: 센스리더에 따른 모달에 머무르기
