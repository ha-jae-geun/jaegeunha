# 암호 회사 종류
* SI
* 솔루션
  * 백신
  * 방화벽
    * Native
    * WEB
  * PKI/인증
* 서비스

```java
12. 인터넷 환경에서 다른 사용자들이 송수신하는 네트워크 상의 데이터를 도청하여 패스워
드나 중요한 정보를 알아내는 형태의 공격은?
1 서비스 거부(DoS : denial of service) 공격
2 ICMP 스머프(smurf) 공격

3 스니핑(sniffing)
4 트로이 목마(Trojan horse)
DoS는 주로 시스템에 과도한 부하를 일으켜 정보 시스템의 사용을 방해하는 공격 방식
으로 가용성을 해칩니다. 스머프는 스머핑이라는 프로그램을 사용하여 네트워크를 공격하는데, IP 브로드캐스트
주소로 많은 양의 ICMP 핑(ping) 메시지를 보내고 그에 대응한 에코 메시지로 인해 네
트워크는 실시간 트래픽을 처리할 수 없는 상태를 만듭니다. 트로이 목마는 정상적인 프로그램으로 보이지만 악의적인 기능을 하는 바이러스 프로그
램입니다.


문 11. 시스템의 보안 취약점을 활용한 공격방법에 대한
설명으로 옳지 않은 것은?
1 Sniffing 공격은 네트워크 상에서 자신이 아닌 다른
상대방의 패킷을 엿보는 공격이다.
2 Exploit 공격은 공격자가 패킷을 전송할 때 출발지와
목적지의 IP 주소를 같게 하여 공격대상 시스템에
전송하는 공격이다.
3 SQL Injection 공격은 웹 서비스가 예외적인 문자열
을 적절히 필터링하지 못하도록 SQL문을 변경하거
나 조작하는 공격이다.
4 XSS(Cross Site Scripting) 공격은 공격자에 의해 작
성된 악의적인 스크립트가 게시물을 열람하는 다른
사용자에게 전달되어 실행되는 취약점을 이용한 공
격이다.

답 2
2 Land Attack에 대한 설명이다.
Exploit(익스플로잇, 취약점 공격)은 소프트웨어, 하드웨어 및 전
자제품들의 버그 혹은 제조, 프로그래밍 과정에서 발생한 취약한
부분을 이용하여, 공격자가 의도한 동작이나 명령을 실행하도록
만든 명령어 또는 그러한 공격이다.
<오답 체크> 1 스니핑(sniffing)
다른 상대방들의 패킷 교환을 엿듣는 것으로, 소극적 공격에 해
당한다.
3 SQL 삽입(SQL 인젝션, SQL injection)
클라이언트의 입력값을 조작하여 관리자가 예상하지 못한 명령을
실행하거나, 정당한 권한을 획득하지 않고 부정한 방법으로 데이
터베이스에 접근하는 공격이다.
4 XSS(Cross-site Scripting, 크로스 사이트 스크립팅)
웹 사이트에 악성 스크립트를 삽입한 뒤 다른 사용자의 접근을
유도하여, 사용자의 클라이언트에서 악성 프로그램이 실행되도록
하여 개인정보를 유출시키는 공격이다.


문 6. 서비스 거부 공격에 해당하는 것을 <보기>에서 고
른 것은?

<보기>
ᄀ. Ping of Death 공격
ᄂ. SYN Flooding 공격
ᄃ. Session Hijacking 공격
ᄅ. ARP Redirect 공격
1 ᄀ, ᄂ 2 ᄂ, ᄃ
3 ᄃ, ᄅ 4 ᄀ, ᄅ


답 1
▷ DoS(Denial of Service, 서비스 거부 공격)
해당 시스템의 자원을 고갈시켜 제대로 사용하지 못하도록 만드
는 공격
서비스 거부 공격에는 Land Attack, Targa, NewTear, Nestea,
Ping of Death, Inconsistent, Fragmentation, SYN Flooding,
Smurf, UDP Flooding 등이 있다.
ᄀ. Ping of Death
icmp 패킷을 정상보다 매우 크게 만들어 공격하는 DoS 공격이
다.
크게 조작된 icmp 패킷은 라우터를 통과하는 동안 매우 작은 패
킷으로 조각화(fragment)되어 공격 대상에 도달하는데, 공격 대
상은 조각화된 패킷을 모두 처리하느라 과부하가 걸리게 된다.
ᄂ. SYN flooding (SYN 플러딩)
TCP 3-way hancshaking을 이용한 DoS공격
공격 대상 서버에 존재하지 않는 IP 주소로 위조한 무수히 많은
SYN패킷을 보낸 뒤 서버로부터 오는 SYN+ACK패킷을 무시하여,
서버가 SYN Received 상태로 끊임없이 기다리게 만드는 공격방
법이다.
<오답 체크> ᄃ. Session Hijacking(세션 하이재킹) 공격
시스템에 접근할 적법한 사용자 아이디와 패스워드를 모를 때,
이미 시스템에 접속되어 세션이 연결되어 있는 사용자의 세션을
가로채기 하는 공격이다.
공격 대상을 마비시키는 서비스 거부 공격은 아니다.
ᄅ. ARP Redirect(ARP 리다이렉트)
공격 대상이 접속하는 라우터의 MAC 주소를 알아내어, 공격자
는 공격 대상에게 자신이 라우터라고 속여, 공격 대상과 라우터
사이의 정보들을 스니핑하는 것이다.
공격 대상을 마비시키는 것은 아니다.


악성코드에 대한 설명으로 옳지 않은 것은? 2번
① 파일 감염 바이러스는 대부분 메모리에 상주하며 프로그램 파일을 감염시킨다.
② 웜(worm)은 자신의 명령어를 다른 프로그램 파일의 일부분에 복사하여 컴퓨터를 오동작하게 하는 종속형 컴퓨터 악성코드이다.
③ 트로이 목마는 겉으로 보기에 정상적인 프로그램인 것 같으나 악성코드를 숨겨두어 시스템을 공격한다.
④ 매크로 바이러스는 프로그램에서 어떤 작업을 자동화하기 위해 정의한 내부 프로그래밍 언어를 사용하여 데이터 파일을 감염시킨다.

∙ 웜(Worm)은 네트워크를 통해 연속적으로 자신을 복제하여 시스템의 부하를 높임으로써 시스템을 다운시키는 바이러 스의 일종으로, 복제만 가능하고, 감염 능력이 없다는 것이 가장 큰 특징입니다.
∙ 보기 ②의 '자신의 명령어를 다른 프로그램 파일의 일부분에 복사한다'는 것은 감염시킨다는 것을 의미하므로, 틀린 내용입니다.
```
