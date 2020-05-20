# SqlSession
* 마이바티스에서는 SqlSession를 생성하기 위해 SqlSessionFactory를 사용한다. 세션을 한번 생성하면 매핑구문을 실행하거나 커밋 또는 롤백을 하기 위해 세션을 사용할수 있다. 마지막으로 더 이상 필요하지 않은 상태가 되면 세션을 닫는다. 마이바티스 스프링 연동모듈을 사용하면 SqlSessionFactory를 직접 사용할 필요가 없다. 왜냐하면, 스프링 트랜잭션 설정에 따라 자동으로 커밋 혹은 롤백을 수행하고 닫혀지는, 쓰레드에 안전한 SqlSession 개체가 스프링 빈에 주입될 수 있기 때문이다.

```java
SqlSessionTemplate
SqlSessionTemplate은 마이바티스 스프링 연동모듈의 핵심이다. SqlSessionTemplate은 SqlSession을 
구현하고 코드에서 SqlSession를 대체하는 역할을 한다. SqlSessionTemplate 은 쓰레드에 안전하고 여러개의 DAO나 매퍼에서 공유할수 있다.

getMapper()에 의해 리턴된 매퍼가 가진 메서드를 포함해서 SQL을 처리하는 마이바티스 메서드를 호출할때
SqlSessionTemplate은 SqlSession이 현재의 스프링 트랜잭션에서 사용될수 있도록 보장한다. 추가적으로 
SqlSessionTemplate은 필요한 시점에 세션을 닫고, 커밋하거나 롤백하는 것을 포함한 세션의 생명주기를 관리한다. 
또한 마이바티스 예외를 스프링의 DataAccessException로 변환하는 작업또한 처리한다.

SqlSessionTemplate은 마이바티스의 디폴트 구현체인 DefaultSqlSession 대신 항상 사용된다. 왜냐하면 템플릿은 
스프링 트랜잭션의 일부처럼 사용될 수 있고 여러개 주입된 매퍼 클래스에 의해 사용되도록 쓰레드에 안전하다.
동일한 애플리케이션에서 두개의 클래스간의 전환은 데이터 무결성 이슈를 야기할수 있다.

SqlSessionTemplate은 생성자 인자로 SqlSessionFactory를 사용해서 생성될 수 있다.
```
