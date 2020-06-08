# 생성자 중복정의
```java
생성자 중복 정의
생서자를 중복정의할 때는

정적 팩토리 메소드를 사용한다.

메소드는 인수를 설명하는 이름을 사용한다.



좋은 예
Complex fulcrumPoint = Complex.FromRealNumber(23.0);
나쁜 예
Complex fulcrumPoint = new Complex(23.0);
```
