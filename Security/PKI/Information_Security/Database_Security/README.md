# 문제
```java
문 7. SQL 삽입 공격에 대한 설명으로 옳지 않은 것은? 4
1 사용자 요청이 웹 서버의 애플리케이션을 거쳐 데이터베이스에
전달되고 그 결과가 반환되는 구조에서 주로 발생한다.
2 공격이 성공하면 데이터베이스에 무단 접근하여 자료를
유출하거나 변조시키는 결과가 초래될 수 있다.
3 사용자의 입력값으로 웹 사이트의 SQL 질의가 완성되는
약점을 이용한 것이다.
4 자바스크립트와 같은 CSS(Client Side Script) 기반 언어로
사용자 입력을 필터링하는 방법으로 공격에 대응하는 것이
바람직하다.


2020년도 지방공무원 9급 등 공개경쟁임용 필기시험 손경희 교수 B 책형 2 쪽
[해설]
- 자바스크립트와 같은 CSS(Client Side Script) 기반 언어로 사용자 입
력을 필터링하는 것은 변조의 위험이 있기 때문에 SSS(Server Side
Script) 기반 언어로 필터링하는 방법으로 공격에 대응하는 것이 바람직
하다.
- SQL 삽입 공격은 웹에서 사용자가 입력하는 값이 DB 질의어와 연동
이 되는 경우에는 클라이언트 측과 서버 측에서도 입력값을 검증해야 한
다.


문 13. 해시함수의 충돌저항성을 위협하는 공격 방법은? 1
1 생일 공격
2 사전 공격
3 레인보우 테이블 공격
4 선택 평문 공격
[해설]
- 충돌 저항성(Collision Resistance) : 같은 출력(h(x) = h(x′))을 갖는 임의
의 서로 다른 입력 x와 x′를 찾는 것이 계산상 어려워야 한다.

- 해시 길이가 n비트인 해시 함수가 역상 저항성과 제2 역상 저항성을
갖추기 위해서는 2n보다 효과적인 공격 기법이 없어야 한다. 즉, 역상 저
항성과 제2 역상 저항성의 안전성은 n비트이다. 이에 반해, 충돌 저항성
에 대한 안전성은 생일 공격에 의해 n/2비트이다. 따라서 우리가 일반적
으로 고려하는 해시 함수는 충돌 저항성 공격에 안전한 해시 함수(충돌
저항 해시 함수)이다. 이에 대한 안전성은 n/2 비트이다.
- 생일 패러독스(birthday paradox) : 생일 문제(生日問題)란 확률론에서 유
명한 문제로, 몇 명 이상 모이면 그 중에 생일이 같은 사람이 둘 이상 있
을 확률이 충분히 높아지는지를 묻는 문제이다. 얼핏 생각하기에는 생일
이 365~366가지이므로 임의의 두 사람의 생일이 같을 확률은 1/365~
1/366이고, 따라서 365명쯤은 모여야 생일이 같은 사람이 있을 것이라고
생각하기 쉽다. 그러나 실제로는 23명만 모여도 생일이 같은 두 사람이
있을 확률이 50%를 넘고, 57명이 모이면 99%를 넘어간다. 이 사실은 일
반인의 직관과 배치되기 때문에 생일 역설이나 생일 패러독스라고도 한
다.
```