# [Router](https://m.blog.naver.com/PostView.nhn?blogId=seungj1031&logNo=221012340470&proxyReferer=https:%2F%2Fwww.google.com%2F)

# 라우팅 알고리즘
```java
IGP(Interior Gateway Protocol)
∙ AS(Autonomous System) 내부 라우터 간
∙ RIP, OSPF, IGRP, IS-IS

EGP(Exterior Gateway Protocol)
∙ AS(Autonomous System) 외부 라우터 상호간
∙ EGP, BGP
```

# 홉
* 홉(hop)은 컴퓨터 네트워크에서 출발지와 목적지 사이에 위치한 경로의 한 부분이다. 데이터 패킷은 브리지, 라우터, 게이트웨이를 거치면서 출발지에서 목적지로 경유한다. 패킷이 다음 네트워크 장비로 이동할 때마다 홉이 하나 발생한다.
*  홉 카운트(hop count)는 데이터가 출발지와 목적지 사이에서 통과해야 하는 중간 장치들의 개수를 가리킨다. 저장 전달과 기타 레이턴시가 각 홉을 통하여 발생되므로 출발지와 목적지 사이에서 홉의 수가 많아지면 실시간 성능이 저하될 수 있다.
