# [TCP/IP 4계층](https://hahahoho5915.tistory.com/15)
```java
 * OSI 모델과 TCP/IP 모델 비교

- TCP/IP 프로토콜은 OSI 모델보다 먼저 개발되었다. 그러므로 TCP/IP 프로토콜의 계층은 OSI 모델의 계층과 정확하게 일치하지 않는다.

- 두 계층을 비교할 때 , 세션(Session)과 표현(presentation) 2개의 계층이 TCP/IP프로토콜 그룹에 없다는 것을 알 수 있다.

- 두 모델 모두 계층형 이라는 공통점을 가지고 있으며 TCP/IP는 인터넷 개발 이후 계속 표준화되어 신뢰성이 우수인 반면, 

OSI 7 Layer는 표준이 되기는 하지만 실제적으로 구현되는 예가 거의 없어 신뢰성이 저하되어있다.

- OSI 7 Layer는 장비 개발과 통신 자체를 어떻게 표준으로 잡을지 사용되는 반면에 실 질적인 통신 자체는 TCP/IP 프로토콜을 사용한다.
```


* TCP/IP (Transmission Control Protocol / Internet Protocol)
* 현재 수많은 프로그램들이 인터넷으로 통신하는데 있어 가장 기반이 되는 프로토콜로 실제 대다수 프로그램은 TCP와 IP로 통신하고 있다. 

```java
1계층 네트워크 액세스 계층(Network Access Layer or Network Interface Layer)

OSI 7계층의 물리계층과 데이터 링크 계층에 해당한다.

물리적인 주소로 MAC을 사용한다.

LAN, 패킷망, 등에 사용된다.

 

2계층 인터넷 계층(Internet Layer)

OSI 7계층의 네트워크 계층에 해당한다. 

통신 노드 간의 IP패킷을 전송하는 기능과 라우팅 기능을 담당한다.

프로토콜 – IP, ARP, RARP



3계층 전송 계층(Transport Layer)

OSI 7계층의 전송 계층에 해당한다.

통신 노드 간의 연결을 제어하고, 신뢰성 있는 데이터 전송을 담당한다.

프로토콜 – TCP, UDP

 

4계층 응용 계층(Application Layer)

OSI 7계층의 세션 계층, 표현 계층, 응용 계층에 해당한다.

TCP/UDP 기반의 응용 프로그램을 구현할 때 사용한다.

프로토콜 – FTP, HTTP, SSH



출처: https://hahahoho5915.tistory.com/15 [넌 잘하고 있어]
```
