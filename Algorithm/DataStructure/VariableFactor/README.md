# 가변인자
```java
가변인자

메서드를 호출하는 쪽에서 인자 개수를 정하지 않고 사용할 수 있는 메서드가 몇 가지 있다.

public static double average(double... values){}

이런식으로 ... 을 쓰면 다음과 같이 호출할 수 있다.

double avg = average(3, 4.5, 8, 0);

4개의 인자가 들어오면 자동적으로 뒤에 적은 values라는 변수안에 배열로 들어가 있다.

* values 라고 적어야 하는것은 아니고 자유롭게 변수 이름 지정이 가능하다.

 자바 API

자바에서는 엄청나게 많은 API들이 준비되어있다.

미리 제공하는 API를 이용하여 효율적인 코딩을 하면 된다.

뭐 교수님들이 자바 API문서를 보면서 필요한 것을 찾아보고 공부하라고는 하는데 맞는 말이긴하나 정작 교수님들이 

직접 사용하는 것을 보여준 적은 없다.

API문서를 찾아보라는 것에 대해 부정하지는 않지만 내 생각은 일단 구글 검색을 이용해서 찾아보고 ~~ example , ~~ 

tutorial 이런식으로 사용법을 보고 더 궁금하면 찾아보는게 맞는 것 같다.

* 특히 단어가 떠오르지 않을 경우 API로 찾아보기가 너무 어렵다....

Math.NextUp

API를 하나 찾아봤다. 우리는 실수 두 개 사이의 값의 개수를 셀 수 없다.

그러나 컴퓨터는 셀 수 있다. 실제로 셀 수 있다는 말이 아니라 컴퓨터는 정해져 있다는 말이다.

따라서 Math.NextUp은 말 그대로 다음에 오는 수 중에 가장 가까운 것을 찾아주는 함수다.

// get two float numbers
      float x = 98759.765f;
      float y = 154.28764f;
   
      // print the next floating numbers towards positive infinity
      System.out.println("Math.nextUp(" + x + ")=" + Math.nextUp(x));
      System.out.println("Math.nextUp(" + y + ")=" + Math.nextUp(y));

결과

Math.nextUp(98759.765f)=98759.77
Math.nextUp(154.28764f)=154.28766
왜 차이가 다를까? 라고 생각을 할 수 있지만 그것은 컴퓨터가 지정해 놓은것이다.

숫자가 커질 수록 그 간격이 커진다.



● 이것으로 자바 기본프로그래밍을 마치고 객체지향 프로그래밍부터 자바를 공부해볼 예정이다.
```
