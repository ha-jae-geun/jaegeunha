# 명령과 조회를 분리
```java
명령과 조회를 분리하라 !
함수는 뭔가를 수행하거나

뭔가에 답하거나

둘 중에 하나만 해야한다.

public boolean set(String attribute, String value);
이 함수는 이름이 attribute인 속성을 찾아

값을 value로 설정한 후

성공하면 true를 반환

실패하면 flase를 반환한다.



그래서 다음과 같은 괴상한 코드가 나온다.
if (set("userName", "goodGid"))
위 코드는 다양한 해석이 가능하다.
userName이 goodGid으로 설정되어 있는지 확인하는 코드인가?

userName을 goodGid로 설정하는 코드인가?

함수를 호출하는 코드만 봐서는 의미가 모호하다.
Refactoring
if (attributeExists("userName")){
    setAttribute("userName", "goodGid");
}
명령과 조회를 분리한다.
```
