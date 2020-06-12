# Stream
```java
자바 공부를 하면서 Stream이 무엇인지, 어떻게 사용되고 있는지 인지는 하고 있었으나 실제 코드로 타이핑해보지 않았다.

그러던 중 이번에 가볍게 API 훑어보는 식으로 공부를 하면서 코드를 쳐보면서 조금 더 익히게 되었다.

Stream은 자바 8부터 추가된 기능으로 "컬렉션, 배열등의 저장 요소를 하나씩 참조하며 함수형 인터페이스(람다식)를 적용하며 반복적으로 처리할 수 있도록 해주는 기능"이다. 

(InputStream, OutputStream같은 I/O Stream이 아니다.)


List<String> names = Arrays.asList("jeong", "pro", "jdk", "java");
// 기존의 코딩 방식
long count = 0;
for (String name : names) {
    if (name.contains("o")) {
        count++;
    }
}
System.out.println("Count : " + count); // 2
 
// 스트림 이용한 방식
count = 0;
count = names.stream().filter(x -> x.contains("o")).count();
System.out.println("Count : " + count); // 2


다짜고짜 코드를 가지고 설명하면 위와 같다.

어떠한 컬렉션(names)이 존재하고 그 컬렉션의 요소를 순회하면서 "o"가 포함된 요소의 개수를 구한다고 가정했을 때, 기존의 코드 방식은 반복 순회를 위한 for문, 필터링을 위한 분기 if문이 사용되야 비로소 구할 수 있었던 반면,

스트림을 이용하면 한 줄의 코딩만으로 count값을 구할 수 있다. (count 선언, 출력을 제외하면.)

즉, 불필요한 코딩(for, if 문법)을 걷어낼 수 있고 직관적이기 때문에 가독성이 좋아진다.

이 점이 Stream의 장점이자 목적이다.

Stream은 어떤 것들에 적용할 수 있을까?

Stream은 주로 Collection, Arrays에서 쓰인다.

물론 두 개 뿐만 아니라 I/O resources(ex. File), Generators, Stream ranges, Pattern 등에서도 사용할 수 있다.

해당 객체들로 부터 Stream을 생성하는 법은 스스로 찾아보도록 하고 기본적으로 자주 쓰이는 것들만 간단히 소개한다.


List<String> names = Arrays.asList("jeong", "pro", "jdk", "java");
names.stream(); //Collection에서 스트림 생성
 
Double[] dArray = {3.1, 3.2, 3.3};
Arrays.stream(dArray);//배열로 스트림 생성
 
Stream<Integer> str = Stream.of(1,2); // 스트림 직접 생성


스트림 사용법과 주의사항 

스트림의 구조는 크게 3가지로 나뉜다.

1. 스트림생성

2. 중개 연산

3. 최종 연산

-> 실제 사용법으로 표기하면 "Collections같은 객체 집합.스트림생성().중개연산().최종연산();" 이런식이다.

* 계속해서 . 으로 연계할 수 있게 하는 방법을 파이프라인이라고도 한다.

위에서 어떻게 스트림을 생성하는지는 알았으니 이제부터는 중개 연산에 쓰이는 함수는 어떤 것들이 있고 어떻게 사용하는지를 알아보고, 최종 연산에 쓰이는 함수는 어떤 것들이 있고 어떻게 사용하는지 API를 훑어보는 느낌으로 알아보면 될 것이다.

- 중개 연산

Filter


List<String> names = Arrays.asList("jeong", "pro", "jdk", "java");
Stream<String> a = names.stream().filter(x -> x.contains("o"));
cs
filter는 말 그대로 필터링, 즉 조건에 맞는 것만 거른다는 것이다.

위의 코드에서는 람다식을 이용해서 x 로 스트림의 요소를 받고 각 요소에 "o"라는 알파벳이 있는 것들만 거른다.

즉, "jeong" 과 "pro" 만 가지고 있는 스트림을 반환한다.

Map


List<String> names = Arrays.asList("jeong", "pro", "jdk", "java");
names.parallelStream().map((x) ->{return x.concat("s");}).forEach(x -> System.out.println(x));
//jeongs, pros, jdks, javas
Colored by Color Scripter
cs
앞서 filter나 map은 자바스크립트에서도 다뤄서 어떤 기능을 하는지는 알 수 있다.

map은 스트림의 각 요소를 연산하는데 쓰인다. 위와 같은 경우에는 각 문자열(요소)마다 뒤에 "s"를 붙였다.

숫자일 경우 * 2 로 두 배를 만든다든지 등의 다양한 조작이 가능하다.

Peek

peek()도 Map과 유사하게 각 요소에 어떤 연산을 적용할 때 사용한다.

Sorted

말 그대로 스트림의 요소들을 정렬해준다.

Limit


List<Integer> ages = Arrays.asList(1,2,3,4,5,6,7,8,9);
ages.stream().filter(x -> x>3)).limit(3);
//4,5,6
Colored by Color Scripter


스트림의 개수를 .limit(3) 으로 지정하면 3개로 제한한다. (물론 중개연산이라 스트림 반환)

Distinct

스트림의 요소가 예를 들어 1,2,1,2,1,2,1,2 일 때 .distinct()를 적용하면 1,2로 중복을 제거한다.

Skip

.skip(3) 이라고하면 처음 3개의 요소는 제외하고 나머지 요소들로 새로운 stream을 만든다.

mapToInt, mapToLong, mapToDouble

mapXXX 함수들은 해당 타입의 스트림으로 바꿔준다. 예를들어 "1","2","3" 을 가진 스트림이 있었으면 mapToInt를 적용하면 1,2,3 을 가진 스트림으로 변환 해준다.

- 최종 연산

count(), min(), max(), sum(), average()

최종 연산이기 때문에 앞서 함수를 적용했던 스트림에 있는 요소들에 대해 count를 세거나 최소값, 최대값, 합계, 평균 값을 얻을 수 있는 함수다.

* 참고로 average()는 연산에 안보인다... 사라진 건 아닐텐데 확인이 필요하다.

reduce

List<Integer> ages = new ArrayList<Integer>();
ages.add(1);ages.add(2);ages.add(3);//1,2,3
System.out.println(ages.stream().reduce((b,c) -> b+c).get());//1+2+3=6
cs
reduce는 누적된 값을 계산하는 함수다.

여기서 b, c로 지정한 파라미터를 가지고 리턴한 결과(b+c)가 다시 b가 되고 다음 스트림의 요소가 c가 되어 계속 누적된다. 따라서 1+2+3인 6이 결과로 찍힌다.

forEach


List<Integer> ages = new ArrayList<Integer>();
ages.add(1);ages.add(2);ages.add(3);//1,2,3
Set<Integer> set = ages.stream().collect(Collectors.toSet());
set.forEach(x-> System.out.println(x));//1,2,3
cs
forEach는 map이나 peek의 최종연산 버전이다. 각 요소를 돌면서 처리할 수 있도록 되어있다.

collect

collect는 스트림의 값들을 모아주는 기능을 한다. toMap, toSet, toList로 해당 스트림을 다시 컬렉션으로 바꿔준다.

iterator


List<String> names = Arrays.asList("jeong", "pro", "jdk", "java");
Iterator<String> iter = names.stream().iterator();
while(iter.hasNext()) {
    System.out.println(iter.next());//jeong, pro, jdk, java
}
Colored by Color Scripter
cs
iterator는 Iterator<T>를 반환한다.

noneMatch, anyMatch, allMatch

List<Integer> ages = new ArrayList<Integer>();
ages.add(1);ages.add(2);ages.add(3);//1,2,3
System.out.println(ages.stream().filter(x -> x>1).noneMatch(x->x>2));//false
cs
noneMatch는 최종적으로 얻은 스트림의 "모든" 요소들이 조건을 만족하지 "않는"지를 판단해서 boolean값을 리턴한다.

anyMatch는 스트림의 요소들 중에 하나라도 조건을 만족하는지 판단해서 boolean값을 리턴하고,

allMatch는 스트림의 "모든" 요소들이 조건을 만족하는지를 판단해서 boolean값을 리턴한다.



기타로 그룹핑하고 통계를 얻는 것도 있는데 생략한다.

* 알아 둘 것

- Stream은 재사용이 불가능하다.


// Stream 재사용 불가 stream has already been operated upon or closed.
Stream<String> a = names.stream().filter(x -> x.contains("o"));
count = a.count();
        
List<String> lists = a.collect(Collectors.toList());


위 코드에서 보듯 한 번 사용한 스트림 a에 대해서 다시 사용하려고 하면 에러가 난다.



- 병렬 스트림은 여러 쓰레드가 작업한다.

1
names.parallelStream().filter(x -> x.contains("o")).count();


stream()으로 스트림을 생성하지 않고 위 처럼 parallelStream()으로 병렬 스트림을 만들 수 있다.

이렇게하면 여러 쓰레드가 스트림에서 요소를 필터링하고 나온 요소 수를 계산하고 쓰레드끼리 다시 한 번 각자 계산한 
count 값들을 더해서 리턴해준다.

단순하게 생각하면 여러쓰레드가 처리해주니 병렬스트림이 항상 성능면에서 유리해보일 수 있지만 애플리케이션에서 사용하는
쓰레드가 많거나 스트림의 요소 수가 많지 않다면 오히려 쓰레드를 사용하는데 드는 오버헤드가 더 클 수도 있다.

 - 중개 연산은 미리하지 않는다 지연 연산을 한다.


Stream<String> a = names.stream().filter(x -> x.contains("o")).map(x-> x.concat("s"));
a.forEach(x -> System.out.println(x));
Colored by Color Scripter
cs
위와 같은 코드가 있으면 위에 filter와 map 함수는 미리 계산하고 있지 않고 있다가 forEach와 같은 최종연산이 
적용될 때 중개 연산도 실행된다.

이로써 얻는 장점은 미리 계산하면서 두 번 순회하는 짓을 안할 수 있게 된다는 점이다.
```
