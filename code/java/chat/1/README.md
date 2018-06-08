*   
	- Collections.synchronizedMap(clientMap); //해쉬맵 동기화 설정.
    - //HashTable은 데이터 변경 메서드가 모두 동기화(Synchronized) 메서드로 선언되어 있습니다. 좀 더 설명을 하자면 메서드 호출 전에 쓰레드간 동기화 락(Lock)을 걸기 때문에 멀티 쓰레드(Multi-Thread) 환경에서도 데이터의 무결성을 보장합니다.
    - //HashTable은 속도가 느립니다. 그 이유가 데이터 무결성을 지키기 위한 동기화 때문입니다. 동기화 락 작업은 매우 느린 동작입니다. 즉 상대적으로 동기화 처리를 하지 않는 HashMap은 HashTable에 비해 매우 빠른 처리 속도를 가집니다.

*
    // 클라이언트가 멀티채팅서버에 접속하면 HashMap에 저장되고 접속을 해제하면 hashMap에서 제거한다.
    // 클라이언트가 데이터를 입력하면, 멀티채팅서버는 HashMap에 저장된 모든 클라이언트에게 데이터를 전송한다.
    //KeySet() 는 key 를 다 가져옵니다.
    //enterySet() 은 map에 정의된 key값과 value값을 다 가져옵니다.
    // iterator란 모든 컬렉션클래스에 데이터를 읽을때 사용됩니다, hasnext(), next(), remove()
    //hasNext() 메소드는 읽어 올 요소가 남아있는지 확인하는 메소드이다. 있으면 true, 없으면 false를 반환한다.
    
* import java.io.DataOutputStream;
  - FileInputStream / FileOutputStream 은 byte[] 단위의 데이터만 입/출력을 할 수 있었다.
  - 하지만 DataStream Filter를 적용함으로써, 자바 기본 자료형(char, int, long, ...) 으로 데이터를 입력하고 출력할 수 있다.


* clientMap = new HashMap(); //클라이언트의 출력스트림을 저장할 해쉬맵 생성.
    - Collections.synchronizedMap(clientMap); //해쉬맵 동기화 설정.
    - //HashTable은 데이터 변경 메서드가 모두 동기화(Synchronized) 메서드로 선언되어 있습니다. 좀 더 설명을 하자면 메서드 호출 전에 쓰레드간 동기화 락(Lock)을 걸기 때문에 멀티 쓰레드(Multi-Thread) 환경에서도 데이터의 무결성을 보장합니다.
    - //HashTable은 속도가 느립니다. 그 이유가 데이터 무결성을 지키기 위한 동기화 때문입니다. 동기화 락 작업은 매우 느린 동작입니다. 즉 상대적으로 동기화 처리를 하지 않는 HashMap은 HashTable에 비해 매우 빠른 처리 속도를 가집니다.