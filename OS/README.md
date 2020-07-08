# 문제
```java
46. 운영체제의 운용 기법 중 중앙 처리 장치의 시간을 각 사용 자에게 균등하게 분할하여 사용하는 체제로서 
모든 컴퓨터사용자에게 똑같은 서비스를 제공하는 것을 목표로 삼고 있 으며, 라운드 로빈 스케줄링을 사용하는 것은?  2번
① Real-Time Processing System
② Time Sharing System
③ Batch Processing System
④ Distributed Processing System

 
58. 운영체제의 발달 과정을 순서대로 옳게 나열한 것은?  1번
가. 일괄 처리 시스템
나. 분산 처리 시스템
다. 다중 모드(Mode) 시스템
라. 시분할 시스템
① 가 - 라 - 다 - 나
② 다 - 나 - 라 - 가
③ 가 - 다 - 라 - 나
④ 다 - 라 - 나 - 가

```

# 운영체제
* 하드웨어를 효율적으로 관리해서 응용 프로그램/사용자에게 효율적으로 서비스 제공

# 운영체제의 역할
1. User Interface(편리성)
	* CUI, GUI, EUCI
2. 효율성
	* HW resource
		* 프로세서, 메모리, IO 장치들
	* SW resource
		* 파일, 어플리케이션, 메세지, 시그널
3. Process and Thread management
4. 시스템 보호

# 운영체제의 구분
1. 동시 사용자수
	* Single User
	* Multi-user
		* 서버, 클러스터 장비 등에 사용(유닉스, 리눅스, 윈도우 서버)
2. 동시 실행 프로세스 수
	* 단일작업
		* 시스템 내에 하나의 작업(프로세스)만 존재
	* 다중작업
3. 작업 수행 방식



# 운영체제
* 하드웨어 <> 운영체제 <> 응용 프로그램 <> 사용자
	* 하드웨어: 하드웨어 장치, 마이크로 프로그래밍, 기계어
	* 시스템 프로그램: 운영체제, 컴파일러, 편집기, 명령어 해석기
		* 컴퓨터 기종에 따라 다르다.
	* 응용 프로그램: 은행 시스템, 항공 예약, 명령어 해석기, 프리스타일
		* 기종에 관계 없이 작성될 수 있는 것.



# 운영체제 개념
## 윈도우 특징

## 리눅스 특징

## CLI와 GUI 차이

## 윈도우 부팅 시 시작프로그램 핸들링 하는 명령어: msconfig




## Log
* 이벤트 뷰어  
  ^Window: Event viewer(systemlog > application program)
* 파일 형식으로 되어 있음  
  Linux: 1. /var/log  2. History
* 소프트웨어 측면에서는 시스템 로그에 로그를 남길 수 있지만 시스템과 관련이없는 경우 파일에 로그를 남깁니다.  
  ^In terms of software, they can leave log on system log but if they are not related to system, they leave logs on files

## Linux, WIndow

### Regestry(regedit)
* 과거에 INI 파일은 각 프로그램의 구성을 저장하는 데 사용됐찌만 여기저기 퍼져 있었기 때문에 찾기가 어려워 레지스트리가 나왔다.  
    ^Back in the day, INI file is used to contain each programs' configuration. But it's hard to find because they are spread. That's why the registry came out.
* [1]('https://www.youtube.com/watch?v=_U78iAem3uo')
* [2]('http://editorizer.tistory.com/239')
* [3]('http://pastime0.tistory.com/66')
* File location
  - C:\Windows\System32\config
  - System Reserved\Boot\BCD
  - C:\Users\User_Account\NTUSER.DAT
* Registry <> Linux file
* 레지스트리는 하드웨어, 소프트웨어, 환경 설정 및 사용자에 대한 설정 및 옵션을 저장하는 데이터베이스입니다.  
    ^Registry is the database that stores settings and options for Hardware, Software, preferences and users
* 클래스 객체 : 그것이 나타내는 객체로 할 수있는 것을 정의하는 명명 된 함수 그룹  
    ^class object: a named group of functions that defines what you can do with the object it represents 
* Registry keys(similar to folders) and Registry values(files) are components
* HKey_LOCAL_MACHINE
  - SAM: security accounts manager
* HKEY_CURRENT_CONFIG
  - Current Hardware information
  - 런타임에 수집 된 정보가 포함되어 있습니다. 정보를 여기에 저장하면이 키는 영구적으로 디스크에 저장되지 않습니다.  
      ^It contains information gathered at runtime; information stored here, this key is not permantently stored on disk
* HKEY_CLASSES_ROOT
  - 파일 연결과 같은 등록 된 응용 프로그램에 대한 정보가 들어 있습니다.  
      ^contains information about registered applicatoins, such as file associations
* HKEY_CURRENT_USER
  - 현재 로그인 한 사용자에게 특정한 설정을 저장합니다.  
      ^stores settings that are specific to the currently logged-in user
* Type of registry
  - Binary data, String values, unsigned integers, symbolic links, multi-string values, resource list, resource descriptor, 64-bit integers
