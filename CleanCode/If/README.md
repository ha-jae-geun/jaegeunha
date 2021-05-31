# [CPU에 최악인 조건문](https://youtu.be/1Qg-dIh2qGQ)

# If Else문
```JAVA
가독성을 높이는 if문 쓰는 방법 


void initialize() {
    if (isInitialized()) {
        return;
    }
    //...
    //초기화 
}


초기화 코드를 예로들면 메소드 앞에 if문에서 예외 처리해야할 부분을 잡아서 분기해주는 것이 좋다.

무슨 얘기냐하면 if문을 중첩으로 쓰지 않게 잘못된 로직을 먼저 if문으로 잡아주어 제거한 후에 아래 코드를 쓰는 것이 
가독성이 높다. 아래 예제를 본다.

 

void compute() {
    Server server = getServer();
    if (server != null) {
        Client client = server.getClient();
        if (client != null) {
            Request current = client.getRequest();
            if (current != null) {
                // 실제 처리할 로직
            }
        }
    }
}
Colored by Color Scripter


[if문이 중첩되는 코드]


void compute() {
    Server server = getServer();
    if (server == null)
        return;
    Client client = server.getClient();
    if (client == null)
        return;
    Request current = client.getRequest();
    if (current == null)
        return;
    // 실제 처리할 로직    
}
Colored by Color Scripter


[if문 개선한 코드]

실제로도 이렇게 보는 것이 편리해진다.

이렇게 작성하는 요령은 부정적인 상황을 if문에 넣는다. 라고 생각하고 코딩하면 된다.

if/else문이 있을 때는 조금 다른데 if/else문일 때는 if문에 간단하고 긍정적인 코드를 작성하는 것이 가독성이 높아진다.

물론 if/else문에서도 if문이 더 길어진다면 앞서 사용한 것처럼 부정적인 상황을 넣는 것이 나을 수 있다.


// 가능하면 긍정적인 조건 ex:hasAccount
if (...) {
    // 간단하고 긍정적인 내용
} else {
    /*
     * 상대적으로 복잡함
     * ...
     * ...
     */
}
cs
이와 같이 사용하면 다른 사람이 코드 분석을 할 때도 가독성이 좋아진다.

이런식으로 코드를 적어가는 연습을 하다보면 내 것으로 만들고 누가봐도 좋은 코드를 만들 수 있게 될 것이다.
```


# else 키워드
```java
 else 키워드를 쓰지 않는다.
 조건문은 복제의 원인이 되기도 함 / 가독성도 좋지 않음

 디자인 패턴의 Strategy 패턴 - 상태 인라인(status inline)의 분기를 막기 위한 다형성(polymorphism) 예제가 있음

- 상태에 대한 분기가 몇 군데 걸쳐 중복돼 있을 때 Strategy 패턴은 특히 유용

 간단한 경우엔 guard clause(보호 구문) 사용 : if에 return을 쓸 것(early return) - 단, 많이 쓰면 간결함을 해칠 수 있음
```
