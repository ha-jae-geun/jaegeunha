## Java-C
* C 서버에서 java client 로 데이터를 전송 할 때에는 반드시 데이터 끝에 "\r\n" 문자를 추가해줘야지 자바에서 데이터 끝임을 인식한다. 

## Socket
* port는 구멍, 통로
* 소켓 -> 바인드 -> 어셉트(블록); 클라이언트의 접속을 기다리다가  클라이언트에서 connect되면 socket의 IP, 포트 번호 전달해줌(socket 객체) 전달 ->
클라이언트에서 receive(블록)상태로 기다리고 있음
Socket server: socket() > bind > listen > accept > send > recv
  - Socket client: socket() >                connect > recv > send > close
* Rdp, Spice, UXP protocol
* 세션이 동작하면 서로 인증서를 교환함  
    ^when session is running, they communicate authentication to each other
* http도 소켓의 종류 중 하나이다.
  ^http is kind of socket  
  - https도 암호화 하는데 시간이 걸리지만 현재는 거의 차이가 없는걸로 결론이 남. 

### Socket_Chatting
* DB 테이블의 charset이 latin1으로 되어 있을 경우, 한글로 된 정보를 테이블에 그대로 저장할 수 없다. 그대로 저장할 경우 정보가 손실된다. -> getBytes
* 배열, List<list>, Hashmap
  - List<list>는 시스템이 허락해 주는 만큼 할당 해 줄 수 있는데 만약 10000<2>로 방이 10000개면 10000번 돌아야함
  - Hashmap(key, socket); key는 random으로 값을 전달해 주는