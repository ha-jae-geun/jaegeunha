## java 
* appliance -> support all OS
* oop + 
* JVM
* 다중 상속을 지원하지 않는다.  
  ^don't support multi inheritance
* no pointer


### class member, instance member
* 인스턴스 맴버는 힙에 저장되고 클래스 맴버는 컴파일러에 저장된다.  
  ^instance member is stored in heap, and class member is stored at compiler


## 스트림
* ArrayList<Socket> roomNumber = new ArrayList<Socket>();
* 입력 스트림 : 키보드/ 파일/ 프로그램으로 입력받고 프로그램을 도착지로 향하는 것이 입력 스트림입니다.
* 출력 스트림 : 프로그램을 출발지로 모니터/ 파일/ 프로그램으로 향하는 것이 출력 스트림입니다. 
* 스트림 클래스는 그림,멀티미디어,문자등 모든 종류의 데이터를 주고 받는 바이트 기반 스트림과 문자만 주고받을 수 있도록 특화된 문자 기반 스트림 2종류로 나눌 수 있습니다. 
* Inputstream, Outputstream | Reader, Writer
* DataInputStream과 DataOutputStream 은 FilterInputStream과 FilterOutputStream을 상속하고 있어, 객체 생성시에 InputStream과 OutputStream을 매개변수 인자로 가진다.
* FileInputStream / FileOutputStream 과의 차이점은 자바 기본 자료형 데이터를 입/출력 할 수 있다는 것이다.
  FileInputStream / FileOutputStream 은 byte[] 단위의 데이터만 입/출력을 할 수 있었다. 
  하지만 DataStream Filter를 적용함으로써, 자바 기본 자료형(char, int, long, ...) 으로 데이터를 입력하고 출력할 수 있다.
* 생성자: DataInputStream(InputStream in),  DataOutputStream(OutputStream out)
* ArrayList<Socket> roomNumber = new ArrayList<Socket>();

## 클래스

### 내부 클래스
* Outer 클래스에서 Inner 클래스 멤버 사용 불가능
* Inner in = new Inner(); // 원형 : Exam03.Inner in = this.new Inner();
*  내부클래스 역시 외부클래스 입장에서 보면 멤버. 내부클래스도 나름의 속성과 기능을 가지고 있기 때문에 외부클래스를 new로 생성후 내부클래스도 다시 new로 생성해줘야한다.
  - 인스턴스 클래스
  	지역 변수와 같이 선언됨
  - 스태틱 클래스  
  	지역 변수와 같이 선언됨
  - 지역 클래스  
    지역 클래스: 메인 메소드 안에 들어있는 클래스.지역클래스는 컴파일러가 읽고나면 바로 변수가 사라지는 (지역변수의 특성) 특성을 가지고 있기 때문에 새로 생성되어 메인 내에서 사용되어야한다.
  - 익명 클래스 / 무명클래스 / Anonymous
    익명클래스(무명클래스, Anonymous) - 지역클래스의 일부 : 한방에 만들면서 쓴다.
    클래스명 정의를 안하는데 클래스인지 어떻게 식별하나? 메소드를 담는건 클래스밖에 없으니 메소드가 내부에 있는것을 보고안다. 







