# BCrypt
```java
암호화를 이용하여 원문을 해시화하는 간단한 방법을 찾던 중 Devglan 사이트에서 괜찮은 칼럼을 찾았다.

https://www.devglan.com/spring-mvc/storing-hashed-password-database-java

다음 내용은 위 칼럼을 번역한 내용이다.

 

단순 텍스트에 비밀번호를 저장하는 것은 보안상 매우 취약하다. 이 글에서는 자바를 이용하여 데이터베이스에 해시된 패스워드를 저장하는 
방법을 다룬다. 이렇게 한다면 BDA들 조차도 실제 패스워드를 빼내기 불가능하다. 기존의 MD5, SHA-1, SHA-2로 패스워드를 해싱할 수도 
있지만 솔트를 치는것은 추가적인 보안을 만들 수 있다. (여기서 솔트를 친다는 말은 원문에 추가적인 문자열을 넣어서 해시를 강화한다고 
이해하면 된다) 이 글에서는 jBCrypt를 사용할 건데 그것은 패스워드를 인코딩할 때 내부적으로 랜덤 솔트를 생성하여 단순 텍스트를 
인코딩하고 데이터베이스에 저장하게 된다. (솔트를 치게 되면 같은 문자열로 부터 다른 해시 값이 생성된다 - 옮긴이)

 

그리고 Spring MVC와 Hibernate를 이용하여 데이터베이스 연결의 설정들을 제거할 것이다. 주된 관심사는 jBCrypt를 이용하여 단순 
텍스트를 인코딩하고 데이터베이스에 넣고 어떻게 해시된 비밀번호를 단순텍스트와 비교할 수 있는지 알아본다. 여기서는 아주 간단한 
앱을 만들어 비밀번호를 해시화하고 유저정보를 데이터베이스에 넣어본다.

Bcrypt 인코딩은 무엇인가
위키에 따르면 bcrypt는 비밀번호 해시함수로 Niels Provos와 David Mazieres에 의해 만들어졌으며 Blowfish라는 암호에 기반하였다.
Bcrypt는 조정할 수 있는 해시알고리즘을 써서 패스워드를 저장한다. Bcrypt는 패스워드를 해싱할 때 내부적으로 랜덤한 솔트를 생성하기 
때문에 같은 문자열에 대해서 다른 인코드된 결과를 반환한다. 하지만 공통된 점은 매번 길이가 60인 String을 만든다.

의존성 추가
<dependency> 
  <groupId>org.mindrot</groupId> 
  <artifactId>jbcrypt</artifactId> 
  <version>0.3m</version> 
</dependency> // maven

implementation group: 'org.mindrot', name: 'jbcrypt', version: '0.3m' // gradle
Bcrypt 구현을 통한 패스워드 암호화
Bcrypt 라이브러리는 단순 텍스트 패스워드를 해시하기위한 이미 완성된 구현체를 쓰게 해준다. hashpw() 메서드는 단순 텍스트와 랜덤한 
솔트를 인자로받는다. 다음은 그 예이다.

private String hashPassword(String plainTextPassword) {
	return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
}
암호화된 것과 원문의 매칭
다음 구현은 원문과 암호화된 패스워드를 매칭하는 부분이다.

private void checkPass(String plainPassword, String hasedPassword) {
	if (BCrypt.checkpw(plainPassword, hasedPassword)) {
		// doSomething();
	}
}
여기까지가 기술 칼럼의 내용이다. 매우 짧은 글이었지만 사실 더 설명할 것도 없긴하다. 이제 적용해볼 차례다.

실제 프로젝트에 적용해보기
암호화와 해시된 비밀번호를 검증한다. 이 두 가지 기능에 집중해보면 쉽게 인터페이스를 정의할 수 있다.

 


interface 정의
이름은 EncryptHelper라고 정의하였다. 암호화와 비밀번호를 매칭해주는 두 가지 기능을 추상화하여 만들었다. 실제 구현체를 만들어보자.

그전에 미리 테스트를 만들어본다면 이렇게 할 수 있겠다.

 


Wrapping 할 클래스의 테스트
 

다음은 인터페이스를 구현한 커스텀 클래스를 만들어 보았다.


BCrypt 암호화를 사용하는 구현체 정의
 

애초에 BCrypt가 매우 간단하기 때문에 Wrapping을 해도 매우 간단하다. 내가 생각한 Wrapping을 한 이유는 다음과 같다.

BCrypt 클래스의 이름과 내부 메서드 철자의 어려움
프로젝트의 특성에 맞게 새로 클래스를 구현할 수 있음 (인터페이스로 분리하여 다른 암호화를 쉽게 Bean을 통해 주입받아 변경 가능 
→ 유연한 구조를 만들어볼 수 있을 것 같았음)
사용할 클래스는 정의 했으니 이제 빈으로 등록할 차례이다. 기존의 WebConfig 파일은 WebMvcConfigurer를 구현하는 클래스였다. 
비밀번호도 Web 설정과 관련있다고 생각해서 일단 그 구조를 탈피한 후 Web 과 관련된 설정을 모아놓는 클래스로 바꾸기로 했다. 
그러면 다음과 같이 변경 가능했다.

 


WebConfig에서 Bean으로 등록하는 과정
 

두 번째 @Bean에 new로 내가 만든 커스텀 클래스를 주입시켜주었다.

 


암호화 인터페이스 구현체의 주입
그리고 다음과 같이 기존의 서비스에 인터페이스 타입으로 구현체를 주입시킨다. 롬복은 일부러 쓰지 않았다. 자동설정이 학습에 
있어서 매우 좋지 않다고 생각하기 때문에. 그리고 유저를 저장/조회하는 부분에 만든 함수를 적용만 시켜주면 된다.

결과적으로는 기존의 모든 테스트가 통과하였고 실제 환경에서도 데이터베이스에 다음과 같이 솔트로 인해 해시가 진행된 상태로 
들어가는 것을 볼 수 있다.

 


실제 데이터베이스 모습
참고로 id 3,4번은 동일한 비밀번호로 회원가입을 하였다. 일반 해시는 해시 값이 동일할 테지만 salt를 치는 행위가 추가되어 
해시 값이 다르게 나온다. 

 

추가) 클래스뒤에 Impl이라고 명명하는 것은 매우 안좋은 습관이다!

https://octoperf.com/blog/2016/10/27/impl-classes-are-evil/

 
Impl Classes Are Evil

Why you should never name your class with Impl suffix.

octoperf.com
우리가 인터페이스를 정의할 때 뒤에 실제로 Interface라고 붙이지 않는 것과 같다. 그래서 내가 작성한 위의 예제도 BCryptImpl이라는
이름은 상당히 좋지 않은 이름이다. 그렇기 때문에 SaltEncrpyt라고 바꾸었다. 그리고 사진은 일부러 수정하지 않았다. 그냥 내가 
잘못했던 것들을 남겨두기 위함이며, 그리고 뭐좀 틀리면 어떤가. 누군가 잡아주겠지.



출처: https://pjh3749.tistory.com/258 [JayTech의 기술 블로그]
```
