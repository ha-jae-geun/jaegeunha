# [IS-A, HAS-A](https://m.blog.naver.com/PostView.nhn?blogId=lunatic918&logNo=156290730&proxyReferer=https:%2F%2Fwww.google.com%2F)
* [HAS-A](https://funylife.tistory.com/entry/8-2-HAS-A%EC%86%8C%EC%9C%A0-%EA%B4%80%EA%B3%84%EC%97%90-%EC%9D%98%ED%95%9C-%EC%83%81%EC%86%8D-%E2%98%85)
```java
◈ is a 관계의 객체화 (상속관계의 객체화) 

 

 - 부모클래스로 데이터형을 선언하고 자식클래스를 생성해서 할당 하는 것이다.

 - 부모클래스의 변수와 메소드만 호출 할 수 있다.

 - 원칙적으로 자식클래스의 변수와 메소드는 호출 할 수 없다.

 - 자식클래스에 부모클래스에게서 Override한 메소드가 있다면 그 메소드는 호출이 가능하다.

 - class 뿐만 아니라 interface 등도 부모로 받을 수 있다.

 
 부모클래스 객체명 = new 자식클래스();

 
 

◈ has a 관계(포함관계)

 ﻿- 다른 객체를 받아들여서 그 객체의 기능을 사용하는 것이다. (사람이 핸드폰을 사서 그 핸드폰의 기능을 사용하는 것)
 - 받아들인 객체의 자원(메소드/변수)을 사용할 수 있다.

 - 어떤 클래스 A가 또 다른 클래스인 B가 가진 기능을 사용하고 싶을때 B 클래스를 포함하면 B 클래스의 기능을 사용할 수 있다.  

 

A has a B (A는 B를 가지고 있다.)

 
```
