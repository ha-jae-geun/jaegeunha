# Collection과 Collections의 차이
```java
Collection은 인터페이스입니다.

 
Collection Framework라고 하는 계층(hierarchy)의 최상위 인터페이스입니다. Collection Framework는 기본적으로 
여러 요소들을 담기 위해서 만들어졌습니다. 그래서 컨테이너 객체라고도 불립니다.

 

그리고 이 Collection 인터페이스를 Set, List, Queue 인터페이스가 구현을 하고 있습니다. 우리가 많이 사용하는 ArrayList 클래스도 
Collection 인터페이스 -> List 인터페이스 -> ArrayList 클래스 순서로 구현을 하고 있습니다. Map은 단순히 값을 배열로 저장하는 
List, Set과 다르게 키, 값으로 저장을 하기 때문에 Collection 인터페이스를 구현하고 있지 않고, 프레임워크에 같이 정의되어만 있습니다. 

 
Collections는 클래스입니다. 

하지만 이름에서 볼 수 있듯이 Collection Framework와 매우 가깝게 일을 한다고 할 수 있습니다. 

 

Collections 클래스에는 EMPTY_LIST, EMPTY_SET, EMPTY_MAP이라는 필드를 가지고 있습니다. 제어자는 각각 List, Set, Map입니다. 
배열을 정렬할 때 Collections.sort()를 사용하는데요, 이것을 할 수 있는 이유도 sort()가 List 인터페이스를 사용한 객체를 
매개변수로 받고 있습니다. 이것만 보더라도 Collections 클래스를 Collection 인터페이스와 완전 떼어놓고 생각할 수 없습니다.
List 인터페이스는 Collection 인터페이스를 구현했으니까요. 

 

```
