# 오라클 구조
* 내부적을 메모리 영역(System Global Area)이랑 데이터베이스 영역이 있다.

# SGA 구조
* SGA > Shared Pool > Library Cache

# Library Cache
* 우리가 날리는 SQL이랑 최적화된 실행 계획이 Library Cache 영역에 저장이 되어있다.
* 오라클이 Library Cache에 정보를 저장할 때 SQL을 Hash 함수를 써서 저장을 하게 된다
  * SQL 문장 그 자체가 키값이 된다; 그래서 같은 SQL이라도 공백, 줄바꿈이 들어갔거나 대소문자가 다르거나 하면 다른 SQL로 간주해서 Cache를 탈 수 없다
  
# 오라클 내부 과정
1. SQL을 날린다.
2. 오라클이 내부적으로 SQL 파싱을 먼저 한다 
    * Syntax 에러 체크
    * Semantic(권한, 존재 여부) 체크
    * Library Cache 영역에서 저장되어 있는 정보가 있는지 확인
            * 예전에 같은 SQL을 실행한 적 있고 거기에 최적화된 실행 계획이 Library Cache에 저장이 되어 있다면 Cache 영역에서 바로 꺼내서 실행하고 끝낸다
            * 만약 저장되어있는 정보가 없다면 옵티마이저가 수많은 실행계획들을 도출해 낸 다음에 어떤 실행계획이 가장 비용이 적게 드는지 최적화를 거치게 된다. 최적화 이후 SQL 엔진이 해석할 수 있는 언어로 변환을 하는 Row-source generation 과정을 거친다음에이 실행이 되게 된다.

# Hard Parsing
* 옵티마이저에 의해서 최적화하고 Raw-source generation까지 하고 그 다음 실행되는게 Hard Parsing

# Soft Parsing
* Library Cache에서 바로 꺼내서 쓰는 것 
* 동적인 커리에서 Soft Parsing을 사용하려면 바인드 변수를 사용하면 된다
  * 바인드 변수를 제외한 나머지 쿼리를 파싱한 다음에 마지막에 방니드 변수 적용하는 방식

# PGA
* SMJ의 Sort Area나 Hash 영역은 PGA에 위치한다, 그래서 처리 속도가 매우 빠르다
```java
데이터베이스에 접속하기 위해서는 많은 프로그램을 사용하게 된다. 데이터베이스에 접속하기 위해 해당 프로그램을 실행하게 되면 

내부적으로 유저 프로세스가 생성되며 해당 유저 프로세스는 데이터베이스에 접속하는 순간 모든 정보를 서버 프로세스에게 전달하게 된다.

해당 유저 프로세스에서 특정 SQL을 수행했다고 하면 유저 프로세스는 해당 SQL과 기타 정보를 서버 프로세스에게 전달해 주고 답변을 

대기하는 역할을 하게 된다. 유저 프로세스로부터 요청받은 내용을 수행하기 위해서 서버 프로세스가 필요한 모든 작업을  수행하게 된다. 

이때 요청받은 내용 및 기타 정보를 저장하기 위해 서버 프로세스는 자신만의 메모리 공간인 PGA를 이용하게 된다. 결국 PGA란 다음과 같이 정의할 수 있다.


* PGA - 데이터베이스에 접속하는 모든 유저에게 할당되는 각각의 서버 프로세스가 독자적으로 사용하는 오라클 메모리 영역 



    

[그림 3.3]은 PGA의 구체적인 구조이다.



Sort Area(정렬 공간) - Order By 또는 Group By 등의 정렬을 수행하기 위한 공간이며 해당 공간에서만 정렬이 완료된다면 이를 

메모리 정렬이라 한다. 해당 정렬 메모리 공간이 부족하다면 디스크를 이용하게 된다.

Session Information(세션 정보) - 서버 프로세스에 의해 추출된 결과 값을 전달하기 위해 필요한 유저 프로세스의 세션 정보를 저장한다.

Cursor State(커서 상태 정보) - 해당 SQL의 Parsing(파싱) 정보가 저장되어 있는 주소를 저장한다.

Stack Space(변수 저장 공간) - SQL 문장에 Bind Variable(바인드 변수)를 사용했을경우 해당 Bind Variable를 저장하는 공간이다.





이와 같이 PGA는 유저 프로세스가 요청한 작업을 수행하기 위해서 필요한 영역으로 구성된다. [그림 3.4]와 같이 하나의 유저 프로세스에 

하나의 서버 프로세스가 할당되며, 또한 하나의 서버 프로세스는 하나의 PGA를 생성하게 된다.



PGA(Program Global Area)의 관리

오라클에서는 다음과 같은 파라메터에 의해 PGA 크기를 관리할 수 있다.

WORKAREA_SIZE_POLICY - MANUAL과 AUTO로 설정할 수 있으며 AUTO로 설정했을 경우에는 PGA_AGGREGATE_TARGET 파라메터를 이용하여 

PGA의 크기를 설정하겠다는 뜻이다. MANUAL로 설정할 경우는 SORT_AREA_SIZE 파라메터를 이용하여 정렬 공간을 설정하게 된다. 오라클 

10g부터는 기본 값이 AUTO로 설정된다.

SORT_AREA_SIZE - 정렬 공간에 대한 크기를  설정하는 파라메터이다.

PGA_AGGREGATE_TARGET - 모든 세션의 PGA 크기의 합을 설정하는 파라메터이며, PGA_AGGREGATE_TARGET 파라메터에서 지정한 크기까지 

오라클이 PGA를 자동으로 관리한다.

이전 오라클 버전에서는 SORT_AREA_SIZE를 설정하여 세션별로 정해진 크기의 PGA를 할당하여 작업을 수행하였다. 그러나 오라클 9i 및 

오라클 10g에서는 세션별로 정해진 PGA 크기가 아닌 PGA_AGGREGATE_TARGET 파라메터에 정해진 크기 범위에서 세션별로 자동으로 할당하여

메모리를 사용할 수 있게 되었다.


정렬 작업의 양이 많아 더 큰 PGA를 요구한다며 PGA_AGGREGATE_TARGET 파라메터에 정해진 크기 내에서 원하는 만큼 할당 가능


예를 들어, 데이터베이스에 하나의 유저만 접속해 있으며 SORT_AREA_SIZE가 5MB로 설정되어 있다고 가정하자. 해당 유저가 40MB의 

데이터 정렬이 필요한 작업을 실행하였을 경우 5MB가 초과하면 임시 테이블스페이스에 정렬할 데이터를 저장하게 되어 8번의 디스크

I/0가 발생하게 된다. 그러나 WORKAREA_SIZE_POLICY 파라메터를 AUTO로 설정하고 PGA_AGGREGATE_TARGET 파라메터를 50MB로 

지정한 경우에는 전체 PGA 크기의 합이 50MB 이하가 될 때까지는 PGA를 확장할 수 있으므로 디스크 I/O 없이 정렬 작업을 완료할 

수 있게 된다. 이를 자동 PGA 조정이라 한다.


자동 PGA 조정 파라메터를 사용할 경우 주의해야 할 점은 다음과 같다.



PGA_AGGREGATE_TARGET 파라메터의 값을 충분히 크게 설정


만약 앞의 예에서 첫 번째 프로세스가 50MB의 PGA 공간을 사용하고 있다고 가정하자. 이 경우에 다른 유저가 접속해 두 번째 

서버 프로세스를 생성하려 한다면 이 세션은 PGA로 사용할 메모리를 할당받지 못하므로 에러가 발생하며 접속할 수 없게 된다. 

그러므로 자동 PGA 조정 기능을 사용할 경우에는 유저가 접속하지 못하는 경우를 방지하기 위해 평소 접속하는 세션 수와 각 

세션이 사용하는 PGA의 크기를 정확히 파악하여 PGA_AGGREGATE_TARGET 파라메터를 설정해야 한다.

평소 사용되는 PGA의 크기는 V$PROCESS 데이터 딕셔너리 뷰에서 다음을 조회하여 확인할 수 있다.


PGA_USED_MEM - 프로세스가 현재 사용하는 PGA의 크기

PGA_ALLOC_MEM - 프로세스에 할당된 PGA의 크기(사용 완료 후 시스템 메모리에 반환하지 않는 메모리 포함)

PGA_MAX_MEM - 프로세스가 사용한 최대 PGA의 크기


```

# SGA
```java

SGA의 개념

오라클 메모리 구조 중 가장 중요한 SGA의 개념을 그림을 통해 확인해 보자.



[그림 3.5]를 통해 오라클이 사용하는 메모리 공간인 SGA(System Global Area)에 대해 확인해 보자.


오라클은 필요한 데이터를 디스크에서 읽어 메모리에 저장한 후 메모리에 저장된 데이터를 읽거나 변경을 수행한다. 이러한 일련의 

작업에서 사용되는 공용 메모리 영역을 SGA(System Global Area)라고 하며 그 구조는 [그림 3.5]와 같다.

Shared Pool(공유 풀)

Data Buffer Cache(데이터 버퍼 캐쉬)

Redo Log Buffer(리두 로그 버퍼)

Large Pool(대형 풀)

위와 같이 SGA(System Global Area)는 Shared Pool(공유 풀), Data Buffer Cache(데이터 버퍼 캐쉬), Redo Log Buffer(리두 로그 버퍼),

Large Pool(대형 풀) 및 Java Pool(자바 풀)로 구분 할 수 있다.

SGA는 공용 메모리 영역이므로 동일 데이터베이스에 접속하는 모든 사용자는 동일 SGA를 사용하게 된다. 예를 들어, ORCL 

데이터베이스에 접속하는 유저1, 유저2 및 유저n은 [그림 3.6]과 같이 동일 SGA를 사용하게 된다.



결국 SGA는 다음과 같이 정의할 수 있을 것이다.


SGA - 오라클이 데이터를 읽거나 변경하기 위해 사용하는 공용 메모리 영역


SGA는 인스턴스가 시작될 때 시스템 메모리에서 할당받으며 종료될 때 다시 시스템 메모리 영역으로 반환된다.



SGA의 관리

SGA를 관리하기 위해 필요한 변경과 확인 절차를 알아보자.

 
     SGA 변경

     SQL> ALTER SYSTEM SET parameter_name = 변경 값;



SGA 확인

SQL> SHOW SGA

SQL> SELECT * FROM V$SGA;

SQL> SELECT * FROM V$SGASTAT;

SQL> SELECT * FROM V$SGA_DYNAMIC-COMPONENTS;


위와 같이 SGA 관리는 변경 및 확인으로 구성된다.

첫 번째로 SGA 변경을 확인해 보자.

SGA의 설정 값을 변경하고자 할 경우 전체 SGA를 합한 것이 SGA_MAX_SIZE 파라메터에서 정한 값 이하까지 ALTER SYSTEM SET 

명령을 이용하여 동적으로 할당받을 수 있다. 예를 들어 확인해 보자.

SGA_MAX_SIZE - 64MB
DATA BUFFER CACHE - 24MB
SHARED POOL - 24MB
이와 같은 경우에 다음과 같은 명령으로 SGA의 크기를 변경할 수 있다.


예제)

    SQL> ALTER SYSTEM SET DB_cache_size = 20M;
    SQL> ALTER SYSTEM SET shared_pool_size - 28M;


예제에서는 데이터 버퍼 캐쉬에서 축소한 4M 만큼을 공유 풀에 할당하였다. 만약 이 경우에 공유 풀을 64MB로 변경하려 한다면 SGA의 

전체 합이 SGA_MAX_SIZE 파라메터의 값을 초과하므로 'ORA-00384 Insufficient memory to grow cache' 에러가 발생한다. 위와 같이 

SGA 구조를 변경하는 작업은 사용하는 파라메터 파일의 종류에 따라 차이점이 존재한다.

정적 파라메터 파일 - 데이터베이스가 재시작하게 되면 파라메터 파일(PFILE, initSID.ora)에 설정된 값을 재적용하게 된다. 따라서 

변경된 값을 유지하기 위해서는 파라메터파일(initSID.ora)에 해당 변경 내용을 수정해야 한다.

동적 파라메터 파일 - 동적 환경 파일(SPFILE, spfileSID.ora)을 사용하는 경우 ALTER SYSTEM SET 명령어 뒤에 scope=BOTH 옵션을 

추가하게 되면 변경된 값이 메모리와 동적 파라메터 파일에 동시에 적용되므로 데이터베이스 재시작 후에도 변경된 값이 적용된다. 


SGA와 Granule(그래뉼)

SGA는 Granule(그래뉼) 단위에 따라 증가된다. Granule은 SGA_MAX_SIZE 파라메터가 128MB를 넘지 않을 경우 4MB로 설정된다. 

그 이상일 경우에는 16MB로 그래뉼이 설정된다. 예를 들어, SGA_MAX_SIZE 파라메터가 120MB인 경우 DATA BUFFER CACHE의 크기를 증가시키기 위해 DATA BUFFER CACHE 크기를 32MB에서 34MB로 변경하여도 DATA BUFFER CACHE는 36MB로 변경된다. 그 이유는 Granule 단위가 4MB이므로 4MB의 배수인 36MB로 설정되는 것이다.



두 번째로 SGA를 확인하는 방법

설정된 SGA의 크기 확인은 다음과 같은 데이터 딕셔너리 뷰 조회 또는 SQLPLUS 명령어로 확인할 수 있다.

V$SGA
V$PARAMETER
V$SPPARAMETER
V$SGA_DYNAMIC_COMPONENTS
show parapmeter 명령어
SQLPLUS에 접속하여 show sga라는 명령을 수행한 경우 다음과 같은 결과 값을 확인할 수 있으며 V$SGA를 검색했을 

경우에도 동일한 결과를 추출할 수 있다. 

예제)

      SQL> show sga

Total System Global Area    127889704 bytes
Fixed Size                        737576 bytes
Variable Size                    92274688 bytes
Database Buffers               33554432 bytes
Redo Buffers                    1323008 bytes


앞의 예제에서 SHARED POOL의 일부, LARGE POOL 및 JAVA POOL은 Variable Size로 통합되어 보여진다. 

V$SPPARRAMETER 또는 V$PARAMETER를 검색하면 SGA의 구성요소에 설정된 정확한 값을 확인할 수 있다. 

V$SGA_DYNAMIC_COMPONENTS 동적 성능 뷰에 대한 설명은 공유 메모리 자동 관리에서 언급하기로 하겠다.



출처: https://1duffy.tistory.com/18 [밀림속의 동물원]
```
