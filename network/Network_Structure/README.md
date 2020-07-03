# 네트워크 전체적인 구조
```java
인터넷과 네트워크 구성

이 포스트는 그냥 잘 만든 프레임워크에서, 잘 만든 라이브러리를 이용하여 개발하는 필자와 같은 사람이 네트워크에 아주 작은 관심을

갖게되어 개발에 약간이나 도움이 될만한 기초적인 내용을 정리한 포스트다.

사실 명확하게 "개발에 도움이 된다!" 고 말할 수는 없겠지만 요즘 개발자들이 인프라도 만지고 그러니까, 그리고 인터넷/네트워크 통신

한다는 사람들이 이 정도의 기본은 알아야지 하는 마음으로 공부해봤다.

그리고 그 내용을 정리한 것이 아래와 같다.

인터넷 : 인터넷은 여러 작은 네트워크들을 묶은 것을 이야기한다. 우리가 LAN케이블로 PC에 연결해서 사용하는 네트워크 망 

전체를 인터넷이라고 한다고 보면 된다.

이더넷 : 이더넷은 다른 피씨와 통신하는 방법 중에 하나로 CSMA/CD라는 프로토콜(방법)을 사용하는 하나의 방법이다. 

(참고로 CSMA/CD 말고도 토큰링, FDDI, ATM, ... 등이 있는데 다 사장되고 없다고 보면 된다. 우리가 사용하는 인터넷이 다

이더넷 방식으로 한다!고 이해하고 끝내면 된다.)

CSMA/CD : Carrier Sence Multiple Access/Collision Detection의 준말. 뭐냐면 네트워크는 기본적으로 한 번에 한 PC만 

사용(통신)할 수 있다. 그래서 네트워크 망을 사용하는 방식을 정한 것으로 Multiple Access 즉, 동시 다발적으로 사용할 수 있지만 

누군가 이미 사용하고 있으면 그것을 충돌(Collision)로 보고 다시 한 번 시도하는 방식이다.

(누가 쓰고 있으면 조금 있다가 또 보내고, 그래도 쓰고 있으면 또 보내고, ... 무한히 하고 발생하는 문제는 다른 방식으로 푼다.

그냥 이런 방식이구나만 알고 이런 방식만 쓰고 있구나 하면 된다.)

MAC Address : 기본적으로 통신을 하기 위해서 각자의 컴퓨터를 구분해야만 원하는 PC와 통신을 할 수 있을 것이다. 그럴 때 

고유하게 사용하는 주소가 MAC 주소다. 네트워크에서는 MAC 주소로 통신할 대상을 정한다.

전 세계 PC들은 전부 MAC 주소를 갖고 전 세계에서 유일하다.

(참고로 IP도 공인IP주소는 유일하지만 공인IP주소의 개수가 부족해서 비공인IP를 사용해서 확장해서 사용한다.)

우리가 TCP/IP 이러면서 IP주소로 통신하는 것으로 알고 있는데 명확하게는 IP주소를 이용해서 MAC주소를 알아내는 식의 방법으로 

쓰기 때문에 결과적으로는 MAC 주소를 이용한 통신을 하는 것이다.

TCP/IP : 인터넷에서 통신을 하기 위해서는 기본적으로 프로토콜이라는 규약, 약속이 필요하다. "한국인들끼리 얘기할 때는 한국어를 

쓰자" 와 같이 인터넷을 쓸 때는 TCP/IP를 쓰자고 약속한 것이라고 이해하고 넘어가면 된다.



- 정리

인터넷은 LAN으로 연결된 네트워크들을 묶은 망이다.

인터넷은 이더넷이라는 방식으로 통신을 하는데 CSMA/CD라는 프로토콜을 사용한다.

CSMA/CD는 PC들이 같은 네트워크 망내에서 무조건 통신을 위해 네트워크를 사용하고, 제대로 갔나 확인해보는데 누가 이미 사용중이면 

다시 보내고 또 확인하고 제대로 안가면 또 다시 보내는 방식이다.

통신할 상대를 찾을 때는 유일한 주소인 MAC주소를 사용한다.

IP 주소를 이용해서 MAC주소를 알아낸다. (ARP라는 프로토콜을 들어봤다면 그 프로토콜이 변환해준다.)

인터넷에서 쓰는 통신규약인 프로토콜은 TCP/IP다. (TCP/IP의 특징이나 부가 정보는 나중에 공부한다.)

네트워크 장비와 역할

리피터 : 통신 케이블로 연결했을 때 전송할 수 있는 거리의 한계가 있는데 리피터가 중간에 다시 한 번 네트워크 신호를 보내주는

역할을 하는 장비. 근데 이 역할은 지금은 허브가 해서 별볼 일 없는 장비.

허브 : 네트워크 구성에 필요한 장비로 각각 피씨들을 직접 연결하는 것이 아니라 포트가 여러 개인 허브라는 장비를 이용해서 

여러 피씨를 한 허브에 연결해서 네트워크 만드는 역할을 한다.



[출처 : 후니의 시스코 네트워킹 4판 - 도서]

통신 방식을 간단히 설명하면 1번 PC가 2번 PC로 데이터를 보낼 때 허브는 2번이 어디에 있는지 모르기 때문에 허브와 연결된 모든 

피씨로 데이터를 보내게 된다.

그러면 3,4,5번의 경우는 자신에게 온 데이터가 아니기 때문에 버려버리고, 2번의 경우는 자신에게 온 데이터이기 때문에 받아 들이게 된다.

참고로 허브에 너무 많은게 PC가 연결되게 되면 네트워크 사용량도 많아져서 계속 충돌이 발생하게 될 것이고 허브가 모든 피씨에게

데이터를 보내게 되니 아주 힘들어진다. 따라서 PC를 무한정 붙이는 것은 올바르지 않고 해결 방법이 있다. (* 이렇게 허브에 묶여서 같은 충돌 네트워크를 갖는 영역을 콜리젼 도메인(collision domain)이라고 한다.)

또한 어느 한 PC가 미친듯이 데이터를 보내서 다른 PC들이 네트워크를 사용하기 어려운 경우가 발생할 수 있는데 이런 문제를 허브가

찾아서 미친듯이 보내는 PC의 연결을 끊어버리는 기능도 있다.

스위치/브릿지 : 허브를 사용해서 연결하다보면 CSMA/CD 방식을 쓰기 때문에 충돌이 많이 일어나게 되어있는데 이 문제를 해결해 

주는 장비다. 포트별로 충돌이 일어나지 않게 구역을 나눈다고 보면 된다. 하드웨어적으로 포트가 다르면 다른 네트워크에 연결된

것 처럼 나눠주는 역할을 한다. (콜리젼 도메인을 작게 해줌)



[출처 : 후니의 시스코 네트워킹 4판 - 도서]

그림에는 브릿지로 나오는데 브릿지는 사실 스위치가 그 역할을 대신하고 있는 장비다. 스위치로 봐도 무방하다.

스위치는 일단 처음 연결되면 어디에 어떤 PC들이 있는지를 모른다.

그래서 PC로 부터 요청이 오거나 응답이 와야 MAC 주소 테이블에 적어놓고 판단할 수 있게 된다.

1111 피씨가 2222에게 요청을 하면 스위치는 2222의 위치를 모르니 연결된 2222, 3333, 4444에게 데이터를 뿌린다.

그러면 2222가 응답을 해주고 스위치는 1111, 2222의 위치를 알게 되었으니 테이블에 적어놓는다.

이런식으로 3333과 4444도 알게되면 위 그림처럼 된다. 그랬을 때 만약 1111이 다시 2222에 통신을 하면 스위치는 E1 세그먼트로는 

알려줄 필요가 없으니까 3333, 4444가 연결된 E1 세그먼트는 사용할 필요가 없다.

따라서 만약 동시에 3333이 4444와 통신하려고 했을 때는 1111과 2222는 어차피 상관없는 건너편 세그먼트니까 동시에 이용이 

가능하게 되는 매커니즘이다.

이 그림은 다른 세그먼트의 PC가 하나의 스위치에 연결되었을 때인데 만약 두 개이상의 스위치에 연결되게 되면 해당 PC의 위치를

찾기 위해서 서로 반복해서 통신을 하기 때문에 영원한 굴레로 들어갈 수 있는 문제가 있다.

이 문제는 스패닝 트리 프로토콜(알고리즘)이라는 기술로 회피하는데 이 기술은 다른 포스트에서 설명한다. 

라우터 : 스위치로 부터 연결된 모든 PC로 데이터가 전파되는 것을 브로드 캐스트라고 하는데 이 브로드캐스트가 많아져도 네트워크 

사용률이 높아져서 문제가 발생한다.

스위치를 이용해서 콜리젼 도메인을 나눠서 네트워크 사용 경쟁을 줄였다면 라우터를 이용해서 브로드 캐스트가 연결된 다른 

네트워크로 넘어가는 것을 방지한다.

원래 라우터는 IP주소를 가지고 다른 네트워크에 있는 PC를 찾는게 주 목적이고 큰 특징으로 브로드캐스트를 막는다! 라고 

이해하고 넘어가면 된다.



[출처 : 후니의 시스코 네트워킹 4판 - 도서]

스위치가 콜리젼 도메인을 나눴고 라우터가 브로드캐스트 도메인을 나눈 것을 확인할 수 있다.

- 정리

이더넷 방식인 CSMA/CD로 인해 생기는 문제를 해결하고 원활하게 네트워크를 사용하기 위해서 장비들에 대해 알아봤다.

 자세하게 스패닝 트리 알고리즘이 뭔지는 몰라도 네트워크 장비들이 어떻게 구성되고 어떤 역할을 하는지 정도는 이해했다고 본다.

IP와 서브넷 마스크 

모든 IP 주소는 네트워크 부분과 호스트 부분으로 나뉜다. IP는 32비트다.

하나의 네트워크는 라우터 없이도 통신이 가능한 브로드 캐스트영역을 나타낸다고 할 때, 하나의 네트워크에서 IP의 호스트 부분은 

각 PC가 모두 달라야 한다.

네트워크를 A, B, C, D, E클래스로 크기별, 용도별로 나눴는데 우리가 봐야할 것은 A, B, C클래스다.

A 클래스 : 첫번째 비트가 0으로 시작하는 IP주소 대역, IP주소에서 앞에 8비트는 네트워크부분, 나머지 24비트는 호스트 부분이다.

(1.0.0.1~ 126.255.255.254)

B 클래스 : 첫번째 비트가 10으로 시작하는 IP주소 대역, IP주소에서 앞에 16비트는 네트워크부분, 나머지 16비트는 호스트 부분이다.

(128.0.0.1~ 192.255.255.254)

C 클래스 : 첫번째 비트가 110으로 시작하는 IP 주소 대역, IP주소에서 앞에 24비트는 네트워크부분, 나머지 8비트는 호스트 부분이다. 

(192.0.0.1~ 223.255.255.254)

위와 같이 구성된 아이피들은 하나의 네트워크로 묶이는게 기본인데 A클래스의 경우 한 네트워크 당 약 1670만개의 PC가 같은

네트워크를 사용하는 것이므로 문제가 발생한다.

이렇게 큰 네트워크를 나눠서 쓰는 것이 서브넷이라고 하고 서브넷 마스크가 나누는 기준이 된다.

일단 아이피를 보게되면 이 아이피가 어떤 클래스에 있는지 알게 된다.

예를 들어 210.100.100.1 이라는 아이피는 바로 범위를 보면 C클래스인것을 알 수 있다.

C클래스는 기본적으로 서브넷 마스크가 255.255.255.0이다.

이 서브넷 마스크를 기준으로 서브넷 즉, 네트워크를 나누면 210.100.100.0이 서브네트워크가 되는 것이다.

서브넷을 나누는 기준은 네트워크 엔지니어가 아니기 때문에 일단은 중요하지 않다.

여기서 알아야 할 것은 네트워크가 클래스별로 크게 묶일 수 있는데 이것을 서브넷 마스크를 통해서 서브넷으로 나누고 그 

서브넷이 하나의 라우터로 묶이는 네트워크의 단위라고 보면 되는 것이다.

그것만 알고 넘어가면 된다.

자세히 설명되지 않은 부분이 많은데 다듬을 필요가 있고 좀더 상세히 공부할 것도 보인다.

근데 첫 번째로 하는 공부겸 복습이라 이정도로 남겨둔다.

- 정리

인터넷이 이더넷 CSMA/CD 방식을 쓰고 각종 장비로부터 연결되어 원활하게 네트워크를 사용할 수 있게되었다는 것을 알수 있었다.

또한 IP는 서브넷을 이용해서 네트워크를 나눠서 각자가 잘 할당받아 쓴다는 것을 알게 되었다.

미비된 설명과 더 자세한 내용은 다음에 더 공부하고 다음 포스트에서 쓸 예정이다.
```