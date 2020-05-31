# HTTP(TCP) 소프트웨어 개발 시 고려사항
1. TCP handshake 설정
2. 인터넷 혼잡을 제어하기 위한 TCP Slow Start
3. 데이터를 한데 모아 한번에 전송하기 위한 네이글 알고리즘
4. TCp 전송 확인 응답을 위한 확인 응답 지연 알고리즘
5 Time_WAIT 지연과 포트 고갈

# TCP SLOW START
* 급작스러운 부하와 혼잡을 막기 위한 목적
* TCP의 전송할 수 있는 패킷 수는 TCP 커넥션이 만들어진지 얼마나 지났는지에 영향을 받는다
* 데이터가 성공적으로 전송됨에 따라 패킷 수 늘려감

# TIME_WAIT
* CLOSE 한 쪽에서 TIME_WAIT이 발생한다
* IP 주소와 포트 번호를 메모리에 저장한다
    * 같은 IP주소와 포트 번호를 사용하는 TCP Connection을 일정 시간동안 생성하지 않기 위해서 잘못된 패킷을 받아 오동작을 할 수 있음


# Connection Pool

## DB Connection Pool
* DB에 접근하는 서비스 요청 처리 과정
    1. 매번의 요청 마다 connection이  필요하다
    2. 매번의 요청 마다 connection을 생성한다
    3. connection을 통해 요청을 처리한다
    4. connection을 닫는다
    0. 이로 인해 애플리케이션이 느려지고
        * 사용자 수가 많아져 커넥션 수가 너무 많아지면 서버가 죽을 수 있다.

## connection pool 고려사항
* 너무 작다면 대기하는 요청이 많아진다
* 너무 크다면 메모리 낭비가 심해진다
* 접속자수, 서버 부하 등을 고려해 적절한 크기로 조정한다


# 병렬 커넥션
* 장점
     * Http 클라이언트가 여러개의 커넥션을 맺음으로써 여러개의 트랜잭션을 병렬로 처리
     * 페이지를 더 빠르게 내려받는 효과
     * 최신 브라우저는 6-8개의 병렬 커넥션
* 단점
    * 다수의 커넥션은 메모리를 많이 소모하고 자체적인 성능 문제 발생
    * TCP_Slow Start가 여러개의 커넥션에 적용
    * 각 트랜젝션 마다 handshake

# 지속 커넥션
* 장점
     * 커넥션 맺음 최소화(handshake)
     * TCP Slow Start 최소화(재사용)
     * 연결이 최소화 되어서 TIME_WAIT의 숫자가 줄어듬
* 단점
  * 잘못 관리할 경우 연결되어있는 커넥션이 쌓이면 불필요한 리소스가 발생


## HTTP1.0 + Keep-Alive 커넥션

### Keep-Alive handshake
1. 클라이언트는 커넥션을 유지하기 위해 'Connection: Keep-Alive' 헤더를 포함시킨다
2. 이 요청을 받은 서버는 다음 요청도 이 커넥션을 통해 받고자 한다면 응답 메세지에 같은 헤더를 포함시켜 응답한다
3. 응답에 'Connection: Keep-Alive'가 없으면 클라이언트는 서버가 keep-alive를 지원하지 않으며 서버가 커넥션을 끊을 것으로 추정한다.


###  Keep-Alive 커넥션 제한과 규칙
1. 정확한 Content-Length 값과 함께 멀티파트 미디어 형식을 가지거나 청크 전송 인코딩으로 인코드 되어야 하나
2. 프락시와 게이트웨이는 메시지를 전달하거나 캐시에 넣기 전에 Connection 헤더를 제거해야 한다
3. Keep-alive는 사용하지 않기로 되어 HTTP/1.1 명세에서 빠졌지만, 아직도 브라우저와 서버간에 널리 사용되고 있기 때문에 keep-alive를 처리할 수 있는 http 어플리케이션을 개발해야 한다


# Dump-Proxy
 * 클라이언트와 서버가 keep-alive 커넥션을 맺었지만 Dump-proxy는 커넥션 헤더를 모르고 있기 때문에 기다리는 문제가 생김
 
# Proxy-Connection
* 비표준 헤더; Dump-Proxy를 개선
# 병렬 커넥션 + 지속 커넥션 = http connection pool


## HTTP1.1 + 지속 커넥션
* Http/1.1의 지속 커넥션은 기본으로 활성화 되어있다
* 끊으려면 'Connection:close' 헤더를 명시해야 한다
* 클라이언트와 서버는 언제든지 헤더 없이 클라이언트를 끊을 수 있다.
