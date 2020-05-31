# Multiplexing
 ```java
하나의 통신 채널을 통해서 둘 이상의 데이터를 전송하는데 사용되는 기술이다.

기본적으로 멀티플렉싱이란 여러 개를 하나로 묶어 다중화 시킨다는 뜻이다. 
코드에서 볼 것은 여러 개의 channel을 하나로 묶어서 사용하는 것인데, 이 방법을 입출력에 적용한다.
여기서 입출력 버퍼를 사용하게 된다. 

Blocking mode로 동작하는 것들과는 달리 멀티플렉싱은 Non-Blocking Mode로 동작하게 된다.

I/O blocking : I/O의 효율을 높이기 위해 디스크에서 읽어오는 data를 운영체제의 kernel 버퍼 에 저장한 후, 
버퍼가 꽉 차면 프로세스의 버퍼로 옮기는데, data가 kernel 버퍼로 저장되는 동안 프로세스의(정확하게는 I/O를 
요청한 thread가) blocking이 된다. 이렇게 blocking이 되면 프로 그램의 성능 저하로 이어진다. 예를 들면 ServerSocket의 
accept() 메소드의 경우, client로부터 의 연결 요청이 들어올 때까지 blocking된다. 

Non-blocking : blocking의 반대인데, 차이점은 accept() 메소드는 연결의 없는 경우 곧바로 null을 return 한다는 점이다. 
SocketChannel class에서 지원하는 read() 메소드의 경우에도 client로부터의 입력이 없는 경우 곧 바로 null을 return 한다. 
이는 configureBlocking() 메소 드를 이용해 설정이 가능하지만, 문제점이 있다. 일반적으로 ServerSocket에서는 무한 루프를 통 해서 지속적으로 client의 연결 요청은 받아들인다. 이때, blocking 모드로 설정되어있는 serverSocket은 client 연결 요청이 없는 경우 accept()에서 blocking 된다. 하지만 nonblocking으로 설정되어있다면 accept()에서 곧바로 null을 return 하고, 루프를 반복하게 되는데, 이 과정이 반복된다면, 큰 틀에서 봤을 때, CPU는 아무 일도 하지 않고 시간을 보내고 있는 셈이 되다. 즉, non-blocking의 단점은 CPU 시간을 낭비하게 될 수 있다는 점이다. JAVA에서는 이를 방지하기 위한 수단을 제공하고 있다. 그것이 Selector class이다. 이를 이용해 연결 요청이 들어 왔거나 또는 data를 읽어올 수 있는 경우에만 코드를 수행하도록 지정할 수 있다. 


Selector클래스

일종의 이벤트 리스너이다. 기존의 multi-threading 방식에서는 client 수가 증가하게 되면, 
프 로그램의 성능이 급격히 낮아진다. 이를 막기 위해 Selector를 사용하여, 하나의 thread에서 다수의 동시 
사용자를 처리할 수 있도록 했다. Non-blocking 모드로 설정된 channel에 Selector를 등록해 놓으면 channel은 연결 
요청이 들어오거나 data가 도착한 경우에 Selector에 알리게 된다. 메시지를 받은 Selector는 어떤 기능을 사용할 수 
있는지 return하게 된다. 옵션으로 사용할 수 있는 기능은 다음과 같다. 


SelectionKey.OP_READ : Channel로부터 data를 읽어올 수 있는 경우.(Value : 1) 
SelectionKey.OP._WRITE : Channel에 data를 쓸 수 있는 경우.(Value : 4) 
SelectionKey.OP_CONNECT : 연결 요청이 이뤄진 경우.(Value : 8) 
SelectionKey.OP_ACCEPT : 연결 요청이 들어온 경우.(Value : 16) 


SocketChannel/ServerSocketChannel : multiplexing을 지원하기 위한 class. 
기존의 Socket class와 ServerSocket class에 대응한다고 볼 수 있다. 약간의 차이는 있지만, 
기본적으로 사용 방법도 비슷하다. 이 class들은 AbstractSelectableChannel class로부터 상속되었고,
non-blocking NIO를 지원하기 위해 configureBlocking() 메소드를 이용할 수 있다. 그 밖에도 AbstractSelectableChannel
을 상속한 class로는 DatagramChannel, Pipe.SinkChannel, Pipe.SourceChannel이 있다.

소켓의 멀티플렉싱을 하는 이유는 하나의 소켓으로 여러 클라이언트와의 입출력을 가능하게 하기 위함이다. 
이를 위해서는 입출력에 대해 어떤 클라이언트와 통신 할 것인지 구분해야 하는데 이것이 Selector 클래스가 하는 역할이다. 



출처: https://pjh3749.tistory.com/170 [JayTech의 기술 블로그]
```
