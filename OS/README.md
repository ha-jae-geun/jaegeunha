* [Linux](./Linux/README.md)
* [Android](./Android/README.md)

# 윈도우 7
1. 윈도우7 언제까지 사용할 수 있나
* 2020년 1월14일 이후에도 윈도우7 PC를 사용하는데 사실상 문제없다. 단, 운영체제 보안에 구멍이 생겨도 마이크로소프트는 이에 대한 패치 또는 소프트웨어 업데이트를 제공하지 않는다. 지원 종료 후 보안 구멍이 발견되면 해커의 공격에 노출될 수 있다.

2. 윈도우10 지원 종료 기간은
* 윈도우10은 직전 세대의 윈도우 운영체제와 달리 사실상 영구 라이선스다. 마이크로소프트는 최신 버전으로 업데이트에 기간 제한을 두지 않는다. 시작 메뉴에서 ‘설정→윈도우 업데이트→업데이트 확인’ 단계를 거쳐 새로운 업데이트를 받을 수 있는지 알 수 있다. 단, 특정 버전에 대한 지원 기간은 1년 6개월 정도이며 순차적으로 지원을 마감한다. 의도적으로 구형 버전을 사용하는 경우 주의가 요구된다.

# 윈도우 10
## 윈도우 디펜더
* 윈도우10에는 기본적으로 보안 소프트웨어가 탑재되어 있다. 타사 백신 소프트웨어를 설치하고 쓸 수 있지만 굳이 그럴 필요 없다. 윈도우 디펜더는 윈도우10에 내장된 무료 서비스이고 지금까지 돈을 내고 사용했던 안티 바이러스 소프트웨어만큼이나 우수하다


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
