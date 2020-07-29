# [옵저버 패턴](https://victorydntmd.tistory.com/296?category=719467)


# 동작 패턴
```java
동작 패턴: 클래스나 객체들이 상호작용하는 방법과 책임을 분산하는 방법을 정의하는 패턴입니다.
한 객체가 혼자 수행할 수 없는 작업을 여러 개의 객체로 어떻게 분배하는지, 또 그렇게 하면서도 객체 사이의 결합도를 최소화하는 것에 중점을 둔다.
하나의 객체들이 모든 것을 처리하는 것이 아니라 관련된 객체들이 같이 처리하는 패턴
```

# 옵저버 패턴
```java
옵저버 패턴은 어떤 객체에 이벤트가 발생했을 때, 이 객체와 관련된 객체들( 옵저버들 )에게 통지하도록 하는 디자인 패턴을 말합니다.
즉, 객체의 상태가 변경되었을 때, 특정 객체에 의존하지 않으면서 상태의 변경을 관련된 객체들에게 통지하는 것이 가능해집니다.
이 패턴은 Pub/Sub( 발행/구독 ) 모델으로 불리기도 합니다.
```

## 예시
```java
예를 들어, 유튜브를 생각해보겠습니다.

Pub/Sub 모델에 따르면, 유튜브 채널은 발행자가 되고 구독자들은 구독자( 옵저버 )가 되는 구조입니다.

즉, 유튜버가 영상을 올리면 구독자들은 영상이 올라왔다는 알림을 받을 수 있습니다.

이렇게 각각의 유저들을 유튜브 채널을 구독하고 있는 옵저버가 됩니다.
```