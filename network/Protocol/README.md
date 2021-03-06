# 프로토콜 문제
```JAVA
통신 프로토콜에 대한 설명으로 옳은 것은? 3번
① MIME(Multipurpose Internet Mail Extensions)는 인터넷 상에서 
  디지털 오디오 및 비디오 신호를 실시간으로 전달하기 위한 전송 계층 프로토콜이다.
② TFTP(Trivial File Transfer Protocol)는 안전한 파일 전송을 위해 인증과 TCP를 필수 구성 요소로 한다.
③ TELNET는 가상 터미널 연결을 위한 응용 계층 프로토콜로 텍스트 기반 양방향 통신 기능을 제공한다.
④ DHCP(Dynamic Host Configuration Protocol)는 호스트의 인터넷 도메인 명을 IP 주소로 변환시켜 주는 것이다.


① MIME(Multipurpose Internet Mail Extensions)
∙ 전자우편은 7비트 ASCII 문자를 사용하여 전송되기 때문에, 8비트 이상의 코드를 사용하는 문자나
  바이너리 파일들은 MIME 포맷으로 변환되어 SMTP로 전송됨
∙ 실질적으로 SMTP로 전송되는 대부분의 전자우편은 MIME 형식
② TFTP (Trivial File Transfer Protocol)
∙ FTP와 마찬가지로 파일을 전송하기 위한 프로토콜이지만, FTP보다 더 단순한 방식으로 전송데이터 
  파일을 전송하는 과정에서 데이터가 손실될 수 있는 등 불안정하다는 단점을 가지고 있지만 FTP처럼 
  복잡한 프로토콜을 사용하지 않기 때문에 구현이 간단
∙ 전송계층으로 UDP를 사용
③ telnet(Telecommunications Network)
∙ 특정 지역의 사용자가 지역적으로 떨어진 다른 곳에 위치한 컴퓨터를 온라인으로 연결하여 사용할 수 있도록 지원하는 프로토콜
∙ 사용자가 원격에 있는 서버에 로그인하도록 TCP 연결을 설정하며, 단말기가 원격 컴퓨터 바로 옆에 있는 것처럼 직접 조작할 수 있게 해줌
④ DHCP(Dynamic Host Configuration Protocol, 동적 호스트 설정 프로토콜)
∙ TCP/IP 통신을 실행하기 위해 필요한 설정 정보를 자동적으로 할당, 관리하기 위한 통신규약
∙ 각각의 네트워크 호스트를 수작업으로 설정하는 것과는 반대로, 서버에서 자동으로 호스트 컴퓨터에 
  설정값을 지정할 수 있도록 해주는 네트워크 서비스
④번 설명은 DNS에 해당

```

## protocol
* 고성능, 분산 시스템

# json
- 그럼 JSON 은 어떤 형태로 데이터를 주고 받는것일까? JSON(JavaScript Object Notation) 은 약자에서도 나와있듯이 자바스크립트 표준인 ECMA-262 3판 객체문법에 기초를 해
작성되었으며 유니코드를 기본 인코더로 사용한다. 주고 받을수 있는 자료형은 숫자, 문자열
boolean, 배열, 객체 이다. 기본 데이터 배열은 이름/값 쌍의 집합으로 구성되어있으며 중괄호로 싼다. key 값이 문자열이기 때문에 반드시 따옴표를 하고 값은 기본자료형이나 배열, 객체를 넣으면 된다. 각 쌍의 순서는 의미가 없다. {"name2": 50, "name3": "값3", "name1": true}  기본 표현 형태이며 아래는 배열까지 포함된
한사람의 구체적인 인적 정보를 나타낸 예제이다.
 
- {
 *     "이름": "테스트",
 *     "나이": 30,
 *     "성별": "남",
 *     "기혼": true,
 *     "주소": "서울특별시 양천구 목동",
 * "가족관계": {"#": 2, "동생": "홍길동", "어머니": "뺑덕"}
 *     "회사": "부산시 북구 구포동"
 *  }


## json을 사용하는 이유
- JSON 을 많이 쓰게 되는 이유느느 프로그래밍 언어와 플랫폼에 독립적으로 구현이 가능하며 서로 다른 시스템간에 객체를 교환하기 좋기 때문이다. 그리고 자바스크립트 문법을 채용했기 때문에 웹환경에서 개발이 유리하다.
 - 이제 구현이 남았다. 구현을 할려면 json 으로 인코더 할수 있도록 라이브러리가 필요한데
- 언어별로 그런 라이브러리 클래스와 샘플을 제공하는곳이 있다. http://json.org/  이 그곳이다. 리스트에 보면 C#, Java, ASP 등등 흔히 접하는 언어들이 있다.


# 프로토콜 버퍼
- 프로토토콜 버퍼는 구글에서 개발하고 오픈소스로 공개한, 직렬화 데이타 구조 (Serialized Data Structure)이다. C++,C#, Go, Java, Python, Object C, Javascript, Ruby 등 다양한 언어를 지원하며 특히 직렬화 속도가 빠르고 직렬화된 파일의 크기도 작아서 Apache Avro 파일 포맷과 함께 많이 사용된다.
- (직렬화란 데이타를 파일로 저장하거나 또는 네트워크로 전송하기 위하여 바이너리 스트림 형태로 저장하는 행위이다.)
- 특히 GRPC 라는 네트워크 프로토콜의 경우 HTTP 2.0 을 기반으로 하면서, 메세지를 이 프로토콜 버퍼를 이용하여 직렬화하기 때문에, 프로토콜 버퍼를 이해해놓으면 GRPC를 습득하는 것이 상대적으로 쉽다.
- 프로토콜 버퍼는 하나의 파일에 최대 64M까지 지원할 수 있으며, 재미있는 기능중 하나는 JSON 파일을 프로토콜 버퍼 파일 포맷으로 전환이 가능하고, 반대로 프로토콜 버퍼 파일도 JSON으로 전환이 가능하다.
- 프로토콜 버퍼는 XML 과 같은 구조화된 데이터를 직렬화하기 위한 유연하고 효율적이면서 자동화된 메커니즘이다 그러면서도 더 작고 더 빠르며 더 단순하다. 



## xml과 비교해서 장점
1. 프로토콜 버퍼들은 더 단순하다.
2. 3 ~10 배 더 작다.
3. 20 ~ 100 배 더 빠르다.
4. 모호함이 적다. 
5. 프로그램에서 사용하기 더 쉬운 데이터 접근 클래스들을 생성한다.

## 프로토콜 버퍼 단점
- 그럼에도 불구하고 프로토콜 버퍼가 항상 XML 보다 나은 솔루션인 것은 아니다. 예를들어 프토토콜버퍼는 마크업(예를들어 HTML)을 이용하여 텍스트기반 문서를 설계하기에는 좋지 않다. 구조화된 부분에 텍스트를 쉽게 끼워 넣을 수 없기 때문이다. 
- 게다가 XML 은 사람이 읽고 수정할 수 도 있다. 최소한 네이티브 포맷인 프로토콜버퍼는 그렇게 할 수 없다. 또한 XML 은 self-describing 적이다. 
- 프로토콜버퍼는 메시지 정의를(.proto 파일) 가지고 있을 경우에만 의미적이다. 


# 인코딩
- String 클래스를 사용하면 인코딩에도 도움이 됨, 사용하지 않으면 받는 입장에서 이 속성을 알지 못하여 인코딩을 할 때 문제가 있음.
- 컴퓨터에서 인코딩은 동영상이나 문자 인코딩 외에도 사람이 인지할 수 있는 형태의 데이터를 약속된 규칙에 의해 컴퓨터가 사용하는 0과 1로 변환하는 과정을 통틀어 일컫는다. 디코딩은 그 반대.


## UTF-8
- UTF-8과 UTF-16의 기본 차이는 문자 하나를 표현할 때 사용할 최소 byte를 의미한다고 볼 수 있다. UTF-8로 문자를 표현할 때 1-4bytes만큼 필요하다. UTF-16은 2bytes(16bit), 4bytes 만큼 필요하다. 두 Encoding 방식의 큰 차이는 최소 8bit가 필요하다 16bit가 필요하냐에 따라 다른 것이다. 최적의 상황(저쟝, 통신 용량을 아껴야할 때)이 필요하다면, 어떤 CodePoint를 주로 사용하냐에 따라 UTF-8 또는 UTF-16을 선택하는 기준이 달라질 것이다


### UTF 장단점
- 대세는 UTF-8이다. Web Encoding 의 대부분은 UTF-8이 차지하고 있다. 7bit ASCII 영역은 UTF-8에서 동일하게 Encoding되어 있다. 저장, 통신 용량을 고려하지 않는다면 대세인 UTF-8이다. 하지만 용량이 민감하다면 UTF-8, UTF-16중에서 고민해야한다. 
- 문서에서 많이 사용된 CodePoint들이 몇 Byte로 표현될지 고민 후 결정하면 저장, 통신 용량을 아낄 수 있다. 예를 들어 영문자들로 가득찬 문서의 경우 UTF-8로 표현하면 대부분 1byte로 표현되고 UTF-16으로 표현하면 2byte로 표현되니 UTF-8이 유리하고, 한글의 경우 UTF-8은 3byte, UTF-16은 2byte로 표현되니 UTF-16이 유리하다. 
- UTF-16에서 중요한 것은, 16-bit 기반으로 문자를 저장함으로써 한글 또한 2 바이트로 저장할 수 있다는 것입니다. 이를 통해 한글 문서의 용량을 줄일 수 있습니다. 그 외에 영어+한글 처리 시 크기가 모두 2 바이트이므로 UTF-8보다 편리한 경우도 있습니다. 그러나 ANSI와 호환이 안될 뿐더러, 2 바이트이기 때문에 리틀엔디안, 빅엔디안이 필요하다는 단점이 생깁니다. 윈도우즈 메모장, notepad에서 텍스트 파일 저장 시, 유니코드, 유니코드(big endian)이 바로 UTF-16에 해당합니다.

## ANSI code(=ASCII)
- ASCII(American Standard Code for Information Interchange)
- ANSI로 표현가능한 문자들은 asciitable.com에서 확인가능합니다. 유니코드 중 0x00~0x7f에 해당합니다.
- 그런데, ASCII table에는 한글이 없는데 메모장에서 ANSI 인코딩은 어떻게 한글을 저장할까?
- '가'는 B0 A1 로 저장되던데 이에 대한 답은 다음 인코딩에 있습니다.
- 한글 Windows의 메모장에서 이야기하는 ANSI 인코딩이란, EUC-KR을 말합니다. EUC-KR이란 ANSI를 한국에서 확장한 것입니다. EUC-KR 코드표를 확인해보면 B0 A1에 '가'가 매핑되어있는 것을 확인할 수 있습니다
 
## EUC-KR
- EUC-KR 인코딩은 다음과 같이 구성된다.
- 128보다 작은 바이트에 KS X 1003을 배당한다.
- 128보다 크거나 같은 바이트에 KS X 1001을 배당한다. 각 글자는 행과 열에 128을 더한 코드값을 사용하여 2바이트로 표현된다.
 

# 엔디안
- 빅 엔디안(big endian)은 데이터의 상위 바이트가 번지수가 작은곳에 저장되므로 위의 예시처럼 저장됩니다. 하지만 리틀 엔디안(little endian)은 이와 반대 입니다.
- 엔디언(Endianness)은 컴퓨터의 메모리와 같은 1차원의 공간에 여러 개의 연속된 대상을 배열하는 방법을 뜻하며, 바이트를 배열하는 방법을 특히 바이트 순서(Byte order)라 한다.
- 엔디언은 보통 큰 단위가 앞에 나오는 빅 엔디언(Big-endian)과 작은 단위가 앞에 나오는 리틀 엔디언(Little-endian)으로 나눌 수 있으며, 두 경우에 속하지 않거나 둘을 모두 지원하는 것을 미들 엔디언(Middle-endian)이라 부르기도 한다.
- 빅 엔디안은 최상위 바이트(MSB - Most Signficant Byte)부터 차례로 저장하는 방식이며,
- 리틀 엔디안은 최 하위 바이트(LSB - Least Significant Byte) 부터 차례로 저장하는 방식이다.
- 참고로 우리가 주로 사용하는 인텔 계열은 리틀 엔디안(little endian)방식으로 데이터를 저장하고 있습니다. 이와 같은 CPU가 빅 엔디안(big endian)방식의 CPU와 데이터를 주고 받을때는 서로 데이터를 저장하는 방식에서의 차이가 있어 문제가 발생할 수 있습니다.
- 따라서 CPU간의 호환 문제를 해결하기 위해 통일된 네트워크 바이트 순서를 정의 했고 이는 빅 엔디안(big endian) 방식입니다.
- 즉, 네트워크상으로 데이터를 전송할 때는 데이터의 배열을 빅 엔디안(big endian)으로 변경해서 송신해야 합니다. 수신하는 입장에서도 네트워크에서 전달되는 데이터가 빅 엔디안(big endian)방식임을 인지하고 있어야 올바른 데이터 처리가 가능합니다.
 
 
## CISC
- 인텔의 8086은 16비트 프로세서로, 명령어의 길이가 1바이트에서 8바이트까지 가변적으로 구성되어 있다. 명령어가 가변적이고 복잡하므로 CISC 방식이라고 하는 것이다. 이 구조는 가능한 한 명령어의 길이를 줄여서 명령어의 디코딩(decoding, 해석) 속도를 높이고 최소의 메모리 구조를 갖도록 하기 위해서 정해진 것으로, 하나의 프로세서가 일련의 명령어를 순차적으로 처리하기에는 무척 유용한 방법이며, CPU의 동작 속도가 높아짐에 따라 성능이 비례로 증가한다. CISC 방식은 32비트 프로세서인 80386까지도 아무런 문제없이 적용된 기술이므로 완벽한 하위 호환성을 유지할 수 있었다. 
- 명령어가 복잡하다는 의미는 하나의 명령어가 할 수 있는 일의 량이 RISC 대비해서 많다는 의미이다 명령어 마다 길이가 다 다르고 실행에 필요한 사이클 수도 다르기 때문에 파이프라인 설계가 어렵다. 하나의 프로세서가 일련의 명령어를 순차적으로 처리하기에 좋다. 산술 연산 명령어에 사용되는 operand가 메모리에 직접 사용될 수 있다.
- 리틀엔디안(Little-Endian) - 인텔 프로세스 계열(CISC)에서 사용 - 메모리 시작 주소가 하위 바이트부터 기록 - “오른쪽→ …

## Risc 장점
-  단순하다는 것은 프로세서 설계에 드는 비용이 줄어든다는 것을 의미한다. 칩 제작에 드는 R&D 비용이 감소하게 되고, 버그의 존재 가능성이 줄어들게 되어 설계가 쉬워지게 된다.
       - 설계가 쉽기 때문에 프로세서가 개발에서 제품 출시까지의 단축된다.
       - 마이크로프로세서의 명령어를 사용하는 운영체계 및 응용프로그램 작성자들이 적은 수의 명령어 셋을 이용하므로 보다 쉽게 프로그램을 개발할 수 있다
       - RISC의 단순성이 마이크로프로세서의 공간을 사용하는 방법을 선택하는데 보다 자유롭게 해준다
       - 고급언어 컴파일러들이 RISC 컴퓨터 내에 있는 소수의 명령어만을 사용하게 되므로 이전에 비해, 보다 효율적인 코드를 생산할 수 있다
       
## CISC RISC 비교
-  하드웨어가 강조됨 <> 소프트웨어가 강조됨
- 여러 클럭의 복합 명령어를 포함 - 오직 단일 클럭의 축약명령어만 포함
- Memory to Memory : “LOAD”, “STORE” 가 각 명령들 안에서 수행됨. <> Register to Register : “LOAD”, “STORE” 를 독립적인 명령으로 사용함
- 작은 코드 크기, 단위시간동안 높은 사이클 <> 단위시간동안 낮은 사이클수, 큰 코드 크기
- 축약명령어를 저장을 위해 트랜지스터가 사용됨. <> 메모리 레지스터에 보다 많은 트랜지스터가 사용됨.
- 그러나 RISC는 몇몇 아주 중요한 장점을 가져다 준다. 왜냐하면 각각의 명령은 실행하기 위해 단지 한 클럭 사이클만 필요로 한다. 전체 프로그램은 여러 사이클의 “MULT" 명령 만큼의 총 수행 시간에 근접하게 실행될 것이다. 이런 RISC의 “축약 명령어(Reduced Instruction)"는 복합 명령어에 비해 적은 수의 트랜지스터를 요구하면서 범용 레지스터들을 위한 좀 더 많은 공간을 남겨둔다. 결국 모든 명령어들은 단일 형태로 실행되기 때문에 파이프라이닝(Pipelining)이 가능하게 된다. 나누어진 “LOAD" 와 “STORE" 명령어는 실제로 컴퓨터가 수행하야 하는 작업의 총량을 감소시켜준다. CISC 스타일의"MULT" 명령이 실행된 이후 프로세서는 자동적으로 레지스터들을 지운다. 만약 피연산자 값 중에 하나가 다른 계산에서 사용되고자 한다면. 프로세서는 메모리 뱅크에서 레지스터로 그 데이터를 다시 읽어와야만 한다. RISC에서는 다른 새로운 값이 저장되기 전까지 데이터가 레지스터에 그대로 남아 있게 된다.
 
## 최근 동향
- 80년대 초반 RISC 칩이 소개된 이후로 프로세서 기술은 두드러진 발전을 보여왔다. 여러 가지 향상된 기술들이 RISC와 CISC프로세서에 도입됨으로써 둘 간의 경계는 흐려지고 있다. 사실은 두 아키텍처들은 거의 서로의 장점들을 수용하고 있는 듯해 보인다. 프로세서의 성능이 향상됨에 따라 CISC 칩들은 이제 하나의 클럭 안에 1개 이상의 명령어를 실행할 수 있다. 이것은 또한 CISC 칩이 파이프라이닝을 이용하는 것을 허락한다.  또한 다른 기술적인 향상과 함께 칩 안에 보다 많은 트랜지스터를 넣을 수 있게 되었다. 이것은 RISC프로세서가 CISC와 같은 복잡한 명령들을 제공할 수 있는 여유를 제공한다. 또한 “수퍼스칼라 실행(Superscalar Execution)”과 같은 여분의 실행 단위를 이용할 수 있는 복잡한 하드웨어를 사용할 수 있다.
 
## EPIC
- CISC와 RISC의 가장 큰 위협적인 상대는 서로가 아니라 EPIC이라 일컬어지는 새로운 기술일 것이다. EPIC은Explicitly Parallel Instruction Computing을 나타낸다. Parallel 단어가 상징하는 것처럼 EPIC은 여러 명령어를 병렬로 실행할 수 있다.
- EPIC은 인텔에 의해 개발되었고, CISC와 RISC가 조합된 방법으로 제작되었다. 이론적으로 하나의 CPU가 유닉스 기반 뿐 아니라 윈도 기반의 프로세싱을 제공한다.
- 인텔은 초기 머시드(Merced)라는 코드네임으로 작업해오다가 현재는 아이태니엄(Itanium, IA-64)이라는 64비트 마이크로프로세서로 시판중에 있다. (인텔의 경쟁사 AMD는 아이태니엄에 대응하여 확장된 형태의 64비트 CISC – 해머(Hammer) – 를 내놓을 준비를 하고 있다. 과거 CPU 들과 서로 호환되는 것이 큰 장점이다.)
- 인텔의 EPIC 아키텍처가 성공한다는 이것은 RISC에 가장 큰 위협이 될 것이다. Sun이나 모토롤라과 같은 주요 CPU제조업체들은 현재 x86기반의 제품들을 판매하고 있다. 몇몇은 아이태니움을 판매하고 있지만 CISC나 RISC가 사라질 것으로 예상하진 않는다.
 
