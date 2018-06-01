
## NAT
* 자신의 네트워크를 만듭니다. Nat는 내부 및 외부와 통신하는 도구입니다.
  it makes it own network. Nat is a tool to make communicate with inside and outside 

## Bridge
* 개인 IP 주소를 제공합니다. 그래서 많은 IP 주소가 필요하다.
  it gives personal IP address. So i need a lot of ip addresses



## router
* DHCP, DNS

## wifi
* DHCP, DNS, switch

## UNC Route
* [Network](http://miniyo78.tistory.com/entry/UNC-%EA%B2%BD%EB%A1%9C)

## Netbios
* 컴퓨터 속성 -> 이름 변경 -> 자세히에서 확인 가능
  Computer properties -> change name -> detail
* 윈도우에서만 해당
  Only in Window OS

## Socket
* Rdp, Spice, UXP protocol
* 세션이 동작하면 서로 인증서를 교환함
  when session is running, they communicate authentication to each other
* http도 소켓의 종류 중 하나이다.
  http is kind of socket
  - https도 암호화 하는데 시간이 걸리지만 현재는 거의 차이가 없는걸로 결론이 남. 

### Socket_Chatting
* DB 테이블의 charset이 latin1으로 되어 있을 경우, 한글로 된 정보를 테이블에 그대로 저장할 수 없다. 그대로 저장할 경우 정보가 손실된다. -> getBytes


## IP
* 네트워크 구조를 유지시키는 역할
  to stay the network structure
* IP 부여 -> 내가 원하는 곳으로 루트 선정
  Give ip address > set route to node that i want



## TCP/IP
[TCP]('https://www.youtube.com/watch?v=8Ql1l048MD8&list=PLVsNizTWUw7GZy4UA9pntGRC9IIXIYiHm&index=3')
*  TCP is on IP
* physical -> internet -> transport -> application
* Ethernet Protocol <> IP Protocol <> TCp Protocol <> HTTP Protocol
* Socket is on the transport
  소켓은 전송 레이어에 있음
  - Kernel - driver - network card - network card - kernel
  - BSD socket 
  - 소프트웨어 연결
  - Create socket -> give port > connect ip/port
  - Socket server: socket() > bind > listen > accept > send > recv
  - Socket client: socket() >                connect > recv > send > close
* ethernet ->     ip   ->    TCP    ->    Web server
* 프로세스 사이에서 소통을 도와줌
  It provides communication function between processes
* 3웨이 핸드쉐이크 사용
  Threeway handshake, based on flow
* 장점: 신뢰성
* 단점: 낮은 성능, 데이터 연속성 유지 힘듬 
  cons: low performance, hard to stay data continuity -> reliability is more important
* segment




## UDP
* 연속성이 신뢰성보다 중요함; 스타크래프트 UDP 서버
  continuity is more important than reliability -> fast(ex: starcraft)
  - don't care about loss
* 높은 성능
  High performance
* socket() -> connect() -> sentto()/recvfrom () -> close()
 