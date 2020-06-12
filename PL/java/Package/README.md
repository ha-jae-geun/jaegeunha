# 패키지
```java
패키지를 쓰는 이유

패키지는 주로 클래스 이름의 유일성을 보장하려고 사용한다. 서로 다른 패키지에 같은 이름의 클래스를 넣어도 충돌이 일어나지 않는다.

*자바에서는 패키지는 중첩되지 않는다 java.util과 java.util.regex 패키지는 서로 관련이 없다.

클래스 임포트하기

import 문이 있으면 전체 이름 없이도 클래스를 사용할 수 있다.

import java.util.Random; 그러면 코드에서 java.util.Random을 Random으로 사용할 수 있다.

*여러 패키지를 임포트하다 보면 클래스가 충돌이 일어날 수 있다.

예를들면

import java.util.*;

import java.sql.*;

두 패키지의 클래스들을 임포트하면 둘다 Date클래스가 있기때문에 충돌을 일으킨다. (컴파일오류)

이럴 때는 특정 클래스를 임포트하면 된다.

import java.util.*;

import java.sql.*;

import java.sql.Date;

* import 와 c/c++의 #include는 상당히 다르다. #include에는 컴파일용 헤더파일이 포함되지만 
import는 파일을 다시 컴파일 하지 않는다. c++의 using 문처럼 이름을 줄여줄 뿐이다.
```
