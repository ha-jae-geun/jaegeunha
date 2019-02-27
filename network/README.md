# 네트워크
*   네트워크는 미리 정의된 규약인 프로토콜로 정보를 주고받는 하드웨어와 소프트웨어 기반의 시스템을 의미한다.


# 토렌트
* 장점
  1. 인기많은 파일도 안정적인 성능 보장
  2. 먹튀 현상 방지 알고리즘

* 일반 서버-클라이언트 방식과 달리 P2P 방식은 중앙 서버가 없고 트래커, 시드자가 서버 역할
* 시드(트래커; 최초 유포자) - 시드 - 리치(leech; 두번째 뜻: 거머리; 다운로드 하고 시드 안하고 도망)
  * 트래커는 리치에게 다른 시드자의 주소도 줌; 주소가 가까우면 다운로드 속도가 빠르니 
* 먹튀 스코어 계산: Choke Algorithm; 한 시드자는 4명의 리치에게 다운로드하게 할 수 있는데 업로드 비율이 낮은 사용자에게는 우선순위에서 제한이 될 확률이 높다.
* 단점
  * SSD는 P/E Cycle(쓰기 횟수 제한)이 있는데 장기적으로 저장장치에 무리를 줄 수 있다.
* 불법 콘텐츠에 대해 업로드/다운로드 모두 처벌


# 외부에서 내부 라우터로 접근
* 1. 포트 포워드 - VPN으로 테스트(프록시 자동)
* 2. TeamViewer


# DNS
* DNS 값을 IP로 변환 -> Socket(IP, Port) -> IP가 맥주소로 변환 


## NAT
* 자신의 네트워크를 만듭니다. Nat는 내부 및 외부와 통신하는 도구입니다.  
    ^it makes it own network. Nat is a tool to make communicate with inside and outside 

## Bridge
* 개인 IP 주소를 제공합니다. 그래서 많은 IP 주소가 필요하다.  
    ^it gives personal IP address. So i need a lot of ip addresses

## TCP/IP
[TCP]('https://www.youtube.com/watch?v=8Ql1l048MD8&list=PLVsNizTWUw7GZy4UA9pntGRC9IIXIYiHm&index=3')
*  TCP is on IP
* physical -> internet -> transport -> application
* Ethernet Protocol <> IP Protocol <> TCp Protocol <> HTTP Protocol
* 소켓은 전송 레이어에 있음  
  ^Socket is on the transport  
  - Kernel - driver - network card - network card - kernel
  - BSD socket 
  - 소프트웨어 연결
  - Create socket -> give port > connect ip/port
  - Socket server: socket() > bind > listen > accept > send > recv
  - Socket client: socket() >                connect > recv > send > close
* ethernet ->     ip   ->    TCP    ->    Web server
* 프로세스 사이에서 소통을 도와줌  
    ^It provides communication function between processes
* 3웨이 핸드쉐이크 사용  
  ^Threeway handshake, based on flow
* 장점: 신뢰성
* 단점: 낮은 성능, 데이터 연속성 유지 힘듬  
    ^cons: low performance, hard to stay data continuity -> reliability is more important
* segment




## UDP
* 연속성이 신뢰성보다 중요함; 스타크래프트 UDP 서버  
  ^continuity is more important than reliability -> fast(ex: starcraft)
  - 손실에 신경쓰지 않는다.  
    ^don't care about loss
* 높은 성능  
    ^High performance
* socket() -> connect() -> sentto()/recvfrom () -> close()
 

## router
* DHCP, DNS

## wifi
* DHCP, DNS, switch

## UNC Route
* [Network](http://miniyo78.tistory.com/entry/UNC-%EA%B2%BD%EB%A1%9C)

## Netbios
* 컴퓨터 속성 -> 이름 변경 -> 자세히에서 확인 가능  
    ^Computer properties -> change name -> detail
* 윈도우에서만 해당  
    ^Only in Window OS



# IP
* ㆍIP 는 에 대한 주소를 가진다 IP  주소는 네트워크에서 장치들이 서로를 인식하고 통신을 하기 위해서 사용하는 특수한 번호이다 IP . 네트워크에 연결된 장치는 모든 기계는 를 가지고 있어야 한다 
* 네트워크 구조를 유지시키는 역할  
    ^to stay the network structure
* IP 부여 -> 내가 원하는 곳으로 루트 선정  
    * Give ip address > set route to node that i want
    * 1988년 IANA; Internet Assigned Numbers Authority; 현재 ICANN(미국 LA)이 요청에 따라 APNIC에게 나눠줌 ->  한국의 국가기관(KRNIC)에서 발급 -> SK/KT/LG -> 가정집에 1개 부여 -> 공유기에 따라 분배(외부에서 안보이는 나만 보이는; 192.168.0. 가상 IP; 밖에서 봤을 땐 하나의 IP)
      * 대륙마다 기관이 다름: APNIC(호주에 위치; 한국 포함), RIPE(NCC), AFRINIC(아프리카), LACNIC(남미), ARIN(북미)
      * 홈페이지: KRNIC 홈페이지에서 확인 가능

## IP 형태
* 고정 IP: 고정 는 컴퓨터에 고정적으로 부여된 로 한번 부여되면 를 반납하기 전까지는 다른 장비에 IP IP IP 부여할 수 없다. 고정 는 일반 전화기라고 생각하면 된다 IP . 
* 유동 IP: 유동 는 장비에 고정적으로 를 부여하지 않고 컴퓨터를 사용할 때 남아 있는 중에서 IP IP IP 돌아가면서 부여한다. 유동 는 공중 전화기라고 생가하면 된다 IP . 
* 사설 IP:  사설 는 사용자가 임의로 부여한다 IP . 사설 는 내부적으로 인터넷 환경처럼 사용할 수 있지만 인터넷 상에서 서로 연결되지 않도록 IP 되어 있다. 사설 는 내부 전화기라고 생각하면 된다 IP .

## 내 IP 확인 방법
* 구글에서 MY IP 검색

## IP Tracker
* 추적 가능: 도시, 동 + 대략적 위치 좌표, 인터넷 가입 회사, 인터넷 속도, 인터넷 브라우저, 시간


## 프록시
* 처음: 속도를 위해 나왔다. 이미 빨라진지금 보안을 위해서 사용. (프록시에 사용자마다의 캐쉬가 등록)
* 사용자 - 프록시(프록시만의 IP; ex)2.2.2.2) - 인터넷

## VPN
* 사용자 - AES(보안) - VPN - 인터넷
* 암호화 기능 보유; VPN에서 복호화/암호해독 시전


