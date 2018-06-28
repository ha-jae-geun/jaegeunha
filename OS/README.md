* [Linux](./Linux/README.md)
* [Android](./Android/README.md)


## Time Sharing

## Context Switching

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
