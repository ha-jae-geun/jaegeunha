# ArrayList

## ArrayList 값 가져오기 
```java
divArray.get(i).intValue();
```

## ArrayList 순서 뒤집기
```java
1. Collections.sort(temp, Collections.reverseOrder());
2. Collections.reverse(리스트)
```


## ArrayList의 숫자 + 문자
### 김서방 찾기
```java
public class FindKim {
	public String findKim(String[] seoul){
		//x에 김서방의 위치를 저장하세요.
		int x = 0;
    for(int i=0; i<seoul.length; i++){
      if(seoul[i] == "Kim"){
      	x = i;
      }
    }

		return "김서방은 "+ x + "에 있다";
	}

	// 실행을 위한 테스트코드입니다.
	public static void main(String[] args) {
		FindKim kim = new FindKim();
		String[] names = {"Queen", "Tod","Kim"};
		System.out.println(kim.findKim(names));
	}
}
```

<hr/>


# Array
## ArrayList vs. Linked List
* ArrayList와 LinkedList의 차이를 모를 때 종종 그냥 더 익숙해 보이는 ArrayList를 사용하곤 한다. 하지만, 이 선택은 아주 큰 성능 차이를 불러온다. 간단히 말해서, LinkedList는 임의 접근(Random Access)이 별로 없고 값의 추가/삭제가 많을 때 사용하는 것이 적당하다. 

## ArrayList만들기
```java
* 틀린 답
List<String> list = Arrays.asList(arr);

Arrays.asList()는 Arrays의 private 정적 클래스인 ArrayList를 리턴한다. 
java.util.ArrayList 클래스와는 다른 클래스이다. java.util.Arrays.ArrayList 클래스는 
set(), get(), contains() 매서드를 가지고 있지만 원소를 추가하는 매서드는 가지고 있지 않기 때문에 사이즈를 바꿀 수 없다. 
진짜 ArrayList를 받기 위해서는 다음과 같이 변환하면 된다:

* 맞는 답
ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arr));
ArrayList의 생성자는 java.util.Arrays.ArrayList의 상위(super) 클래스인 Collection type도 받아들일 수 있다.
```

## contain 확인하기
```java
* 틀린답
Set<String> set = new HashSet<String>(Arrays.asList(arr));
return set.contains(targetValue);

이 코드는 동작하지만 list를 set으로 변환하는 것은 시간도 더 걸릴뿐더러 사실 할 필요가 없다. 대신에 다음과 같이 처리할 수 있다:

* 맞는 답
Arrays.asList(arr).contains(targetValue);

// OR

for(String s: arr){
	if(s.equals(targetValue))
		return true;
}
return false;
```

## remove
```java
* 틀린 답
ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
for (int i = 0; i < list.size(); i++) {
	list.remove(i);
}
System.out.println(list);

위의 코드에는 아주 심각한 문제가 있다. 원소가 삭제될 때, list의 사이즈가 줄어들면서 다른 원소들의 index도 바뀌어 버린다. 
그래서 만약 loop 내에서 다수의 원소를 index를 사용해 삭제한다면 생각한대로 동작하지 않을 것이다.

아마 반복자(iterator)를 사용하는 것이 바른 방법이고, foreach loop가 내부적으로 반복자를 사용한다는 것을 
알고 있을지도 모른다. 하지만 사실 다음의 foreach loop에서도 올바르게 동작하지 않는다:

* 틀린 답
ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
 
for (String s : list) {
	if (s.equals("a"))
		list.remove(s);
}

위의 코드는 ConcurrentModificationException을 발생시킬 것이다.

* 맞는 답
ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
Iterator<String> iter = list.iterator();
while (iter.hasNext()) {
	String s = iter.next();
 
	if (s.equals("a")) {
		iter.remove();
	}
}

반드시 .remove()전에 .next()가 호출되어야 한다. 만약 foreach loop안에서 원소가 삭제된 뒤에 
.next()가 호출된다면 컴파일러는 ConcurrentModificationException을 발생시킬 것이다.
ArrayList.iterator()의 코드가 깊이 이해하는 데 도움이 될 것이다.
```

## String을 char 배열로 변환
```java
public boolean isValid(String s) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}
```

## copyOf
```java
Arrays.copyOf(원본배열, 복사할 길이);

Arrays.copyOfRange(원본 배열, 복사할 시작인덱스, 복사할 끝인덱스) 인덱스는 0부터 시작하는것 기준
```
