# 이름짓기
```java
클래스 이름
클래스 이름과 객체 이름은

명사나 명사구가 적합하다.

동사는 사용하지 않는다.



좋은 예

ex) Customer, WikiPage, Account, AddressParser

나쁜 예

ex) Manager, Processor, Data, Info

메소드 이름
메소드 이름은

동사나 동사구가 적합하다.



좋은 예

ex) postPayment, deletePage, save



접근자, 변경자, 조건자는 javabean 표준에 따라

값 앞에 get, set, is를 붙힌다.

string name = employee.getName();
customer.setName("goodGid");
if (paycheck.isPosted) 
```

# 의미있는 이름
```java
의도를 분명히 밝혀라
주석이 필요하다면 의도를 분명히 드러내지 못했다는 말이다.
public List<int[]> getThem() {
    List<int[]> list1 = new ArrayList<int[]>();

    for (int[] x : theList) {
        if (x == 4) {
            list1.add(x);
        }
    }
    return list1;
}
위 코드를 보면

코드의 목적을 짐작하기 어렵다.



Why?

각 변수의 역할이

명시적으로 드러나지 않기 때문에

(= 함축성을 갖고 있기 때문에)

코드 맥락을 이해하는게 어렵다.



만약 다음과 같은 정보를 아는 상황이였다면

위 코드가 쉽게 이해됐을 것이다.

theList가 갖고있는 값의 의미

값 4의 의미

함수가 반환하는 리스트 list1의 사용 용도



위의 코드는 지뢰찾기 게임을 만들기 위한 코드였다고 가정해보자.

그리고 다음과 같은 정보들이 제공되었다.

1xN의 게임판이 있다.

게임판의 각 칸은 단순 배열로 표현한다.

해당 위치에 값이 4일 경우엔 깃발(= Flag)이 꽂혀있다.

해당 위치에 값이 4가 아닐 경우엔 지뢰가 있다.



위 정보를 토대로

다시 코드를 보면

처음보다 이해가 잘 될 것이다.

public List<int[]> getThem() {
    List<int[]> list1 = new ArrayList<int[]>();

    for (int[] x : theList) {
        if (x == 4) {
            list1.add(x);
        }
    }
    return list1;
}


조금만 더 Refactoring을 해보자.

변수명을 명시적으로 수정해주면

코드를 보다 명확하게 이해할 수 있다.


 
public List<int[]> getFlaggedCells() {
    List<int[]> flaggedCells = new ArrayList<int[]>();

    for (int[] cell : gameBoard) {
        if (cell == FLAGGED) {
            flaggedCells.add(cell);
        }
    }
    return flaggedCells;
}

 


또한 int 배열을 사용하는 대신

칸을 간단한 클래스로 만들어서 (= Cell)

FLAGGED라는 상수를 사용하지 않고

isFlagged라는 명시적인 함수를 사용하면

코드가 더 명확해진다.

public List<Cell> getFlaggedCells() {
    List<Cell> flaggedCells = new ArrayList<Cell>();

    for (Cell cell : gameBoard) {
        if (cell.isFlagged()) {
            flaggedCells.add(cell);
        }
    }
    return flaggedCells;
}
```

# 접두어 추가하기
```java
의미 있는 맥락 추가
대다수의 이름은 분명하지 못하다.

그럴 경우엔 접두어를 붙혀보자.

Example
예를 들어보자.
firstName, lastName, street, houseNumber, city, state, zipcode
위와 같은 변수가 선언이 되어 있다면

위 변수들의 사용처는

주소와 관계 되어 있음을 쉽게 파악할 수 있다.

But

state 변수 1개만 본다면

해당 변수가

주소를 의미하는 변수들 중 하나라는 것을

파악하는건 쉽지 않다.

Refactoring
주소를 나타내는 addr라는 접두어를 추가해보자.

state -> addrState로 변경하면

맥락이 좀 더 분명해진다.



One More Step

접두어를 사용하는 방법도 좋지만

가능하다면 Address라는 클래스를 생성하면

보다 맥락이 분명해진다.
```

# 동사와 키워드
```java
동사와 키워드
함수의 의도나

인수의 순서와 의도를 제대로 표현하려면

함수 이름을 좋게 Naming할 필요가 있다.

단항 함수
단항 함수는 함수와 인수가

동사/명사 쌍을 이뤄야 한다.



예를 들어

write(name)은 누구나 바로 이해한다.

==> name을 write한다.



좀 더 명확하게 수정도 가능하다.

write(name) -> writeField(name)

==> Field에 name을 write한다.

이항 함수
함수 이름에 키워드를 추가한다.


예를 들어

함수에서 인수의 순서가 중요하다면

함수 이름에 인수 이름을 넣는다.



assertEquals(expected, actual) 보다

assertExpectedEqualsActual(expected, actual)이 더 좋다.



함수명으로 인해

인수의 순서를 기억할 필요는가 없어진다.
```
