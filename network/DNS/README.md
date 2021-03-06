# DNS
## DNS 서버의 역할
```java
인터넷에서는 컴퓨터를 식별하기 위해 IP 주소를 사용

하지만 이 숫자만으로는 무엇에 사용되고 있는지 알 수 없다.

그래서 인터넷에서는 IP 주소에 도메인명이라는 이름을 붙혀 알기 쉽게 한다.

IP 주소와 도메인명을 서로 교환하는 장치를 DNS(Domain Name System)이라 한다.

도메인명은 트리 구조로 되어 있다.
도메인명은 ‘www.examaple.co.kr’과 같이 점으로 구분된 문자열로 구성되어 있다.

이 하나하나의 문자열을 라벨이라고 하며,
오른쪽부터 순서대로 ‘탑레벨 도메인’, ‘제 2레벨 도메인’, ‘제 3레벨 도메인’과 같이 부른다.

즉 트리 모양의 계층 구조로 되어 있다.
```

## DNS 종류
```java
DNS 서버는 2종류
DNS 서버는 캐시 서버와 콘텐츠 서버로 크게 나눈다.

캐시 서버는 LAN 안에 있는 클라이언트로부터 조회를 받아 클라이언트를 대신하여 인터넷에 조회해 주는 DNS 서버
클라이언트가 인터넷에 Access할 때 사용
콘텐츠 서버는 외부 호스트로부터 자신이 관리하는 도메인에 관한 조회를 받는 DNS 서버
자신의 도메인 내의 호스트명은 zone 파일이라는 DB에서 관리

 
클라이언트로부터 조회를 받은 캐시 서버는 받은 도메인명을
오른쪽부터 순서대로 검색하여 해당 도메인명을 관리하는 콘텐츠 서버를 찾는다.
거기까지 도달하면 해당 콘텐츠 서버에 대해 호스트명+도메인명에 대응하는 IP주소를 가르쳐 준다.
이러한 동작을 이름 해결이라 한다.
```

## DNS 서버의 이중화
* DNS 서버는 인터넷을 보이지 않는 곳에서 지지해 주는 중요한 서버이다.
* DNS 서버에서 도메인명을 이름 해결할 수 없으면 목적하는 웹 서버에 Access할 수 없다.
* 그래서 DNS 서버는 단독 구성이 아니라 프라이머리 DNS 서버와 세컨더리 DNS 서버와 같이 이중 구성으로 구축하는 것이 기본이다.

## 캐시 서버의 이중화
* LAN에 배치하는 캐시 서버는 클라이언트가 조회한 이름 해결 정보를 캐시할 뿐이다.
* 따라서 프라이머리 DNS 서버와 세컨더리 DNS 서버에서 특별한 이중화 설정을 할 필요가 없다.
* 프라이머리 DNS 서버로부터 Response가 오지 않으면 세컨더리 DNS에게 다시 조회한다.

## 콘텐츠 서버의 이중화
* 콘텐츠 서버는 도메인명에 관한(zone 파일)을 저장하는 중요한 서버이다.
* 만일 프라이머리 DNS 서버가 다운되어도 세컨더리 DNS 서버가 동일한 정보를 반환할 수 있도록
* 동일한 zone 파일을 저장해 둘 필요가 있다.
* 이것은 프라이머리 DNS 서버에서 세컨더리 DNS 서버로 zone 전송을 하여 zone 파일을 동기화한다.
* 정기적 or 임의의 타이밍에 zone 파일을 동기화한다.

# DNS 라운드 로빈
```java

DNS round robin 방식
DNS Round Robin 방식의 문제점
서버의 수 만큼 공인 IP 주소가 필요함 부하 분산을 위해 서버의 대수를 늘리기 위해서는 그 만큼의 공인 IP 가 필요하다.

균등하게 분산되지 않음 모바일 사이트 등에서 문제가 될 수 있는데, 스마트폰의 접속은 캐리어 게이트웨이 
라고 하는 프록시 서버를 경유 한다. 프록시 서버에서는 이름변환 결과가 일정 시간 동안 캐싱되므로 같은 
프록시 서버를 경유 하는 접속은 항상 같은 서버로 접속된다. 또한 PC 용 웹 브라우저도 DNS 질의 결과를 캐싱하기 
때문에 균등하게 부하분산 되지 않는다. DNS 레코드의 TTL 값을 짧게 설정함으로써 어느 정도 해소가 되지만, 
TTL 에 따라 캐시를 해제하는 것은 아니므로 반드시 주의가 필요하다.

서버가 다운되도 확인 불가 DNS 서버는 웹 서버의 부하나 접속 수 등의 상황에 따라 질의결과를 제어할 수 없다. 
웹 서버의 부하가 높아서 응답이 느려지거나 접속수가 꽉 차서 접속을 처리할 수 없는 상황인 지를 전혀 감지할 수가 없기
때문에 어떤 원인으로 다운되더라도 이를 검출하지 못하고 유저들에게 제공한다. 이때문에 유저들은 간혹 다운된 서버로 
연결이 되기도 한다. DNS 라운드 로빈은 어디까지나 부하분산 을 위한 방법이지 다중화 방법은 아니므로 다른 S/W 와 
조합해서 관리할 필요가 있다.

Round Robin 방식을 기반으로 단점을 해소하는 DNS 스케줄링 알고리즘이 존재한다. (일부만 소개)

Weighted round robin (WRR)
각각의 웹 서버에 가중치를 가미해서 분산 비율을 변경한다. 물론 가중치가 큰 서버일수록 빈번하게 선택되므로 처리능력이
높은 서버는 가중치를 높게 설정하는 것이 좋다.

Least connection
접속 클라이언트 수가 가장 적은 서버를 선택한다. 로드밸런서에서 실시간으로 connection 수를 관리하거나 각 서버에서 
주기적으로 알려주는 것이 필요하다.
```
