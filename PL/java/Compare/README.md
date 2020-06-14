# Compare
```java
Java Comparable, Comparator

Comparable, Comparator 가 무엇인지 알아보기 전에 확실히 해야할 것이 있다.

Comparable, Comparator하면 '정렬'을 떠올려야하는 것이다.

Compare 하면 "비교"고 Comparable하면 "비교 가능한" 이렇게 해석할 수 있기 때문에 "비교"가 먼저 떠오를텐데 이것을 가지고 같다 

혹은 크다, 작다를 구분하는 단순 비교를 할 수 있는 것은 아니다.

명확하게는 "정렬할 때 비교가 가능하다.", "정렬할 때 기준을 정할 수 있다." 가 맞다.

단어적인 측면에서 보았을 때 오해할 수 있는 것을 알아봤다면, Comparable과 Comparator가 언제 어떻게 쓰는지 알아보면 좋을 것이다.

우선 자바에서 객체를 정렬할 때 일정한 기준이 필요하다.

Comparable : 객체 간의 일반적인 정렬이 필요할 때, Comparable 인터페이스를 확장해서 정렬의 기준을 정의하는 compareTo() 메서드를 구현한다.

Comparator : 객체 간의 특정한 정렬이 필요할 때, Comparator 인터페이스를 확장해서 특정 기준을 정의하는 compare() 메서드를 구현한다.

공통점은 정렬의 기준을 정의한다는 것이고,

차이점은 정렬 기준이 일반적이냐 일반적이지 않냐와 compareTo(Object o) 메서드를 구현하느냐 compare(Object o1, Object o2) 

메서드를 구현하느냐가 전부다.

예제를 보고 언제 어떻게 사용하는지 확인해보도록 한다.

Comparable example

Comparable은 객체 간의 정렬에 있어서 오름차순, 내림차순등의 일반적인 순서를 잡는 기준이 필요할 때 객체 클래스에 확장해서 사용한다.


import java.math.BigInteger;
 
public class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private String department;
    private String position;
    private BigInteger sales;
    
    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
        //return this.id - o.id;
        //return this.department.compareTo(o.department);
    }
    
    //...
    //getter, setter, 생성자, toString() 생략
    
}
 
Colored by Color Scripter


편의상 getter, setter등은 생략했다.

주요하게 볼 것은 일반적인 기준이 되기 때문에 클래스에 implements로 Comparable을 확장했다는 것이고,

compareTo() 메서드를 알아보면 되는 것이다.

compareTo()는 int 타입을 반환하며, 파라미터로 비교 대상이 되는 객체가 들어오게 된다.

return하는 int 값은 기준이 있다.

A.compareTo(B) 일 때 A<B 인 경우는 음수를 리턴하고, A=B일 때는 0을 리턴하고, A>B일 때 양수를 리턴한다.

즉, 정렬에 있어서 앞에 오고 싶을 때 음수를 내보내면 된다.

* 주의해야할 점은 아무 음수, 아무 양수를 내보내면 되는것이 아니다. 마찬가지로 -1, 0 ,1만 사용하는 것이 아니다.

a.compareTo(b) == -(b.compareTo(a)) 조건을 만족하게 구성해주면 된다.

위의 예시 클래스 파일에서는 Emplyoee들간에 정렬할 때 기본적으로 이름순으로 정했다.

물론 String 클래스가 compareTo를 구현하고 있어서 마찬가지로 사용했지만 만약 사번순으로 기준을 잡는다면 아래 주석처리한 

것 처럼 this.id - o.id 로 하면 된다.

그렇게 한다면 사번이 작은 순서대로 나올 것이다. 각설하고 위의 클래스를 사용한 결과를 보도록 하자.


public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "jdk", "솔루션개발1", "연구원", new BigInteger("2800"));
        Employee employee2 = new Employee(2, "jeong", "솔루션개발1", "선임연구원", new BigInteger("3200"));
        Employee employee3 = new Employee(3, "amateur", "솔루션개발2", "연구원", new BigInteger("2800"));
        Employee employee4 = new Employee(4, "pro", "솔루션개발2", "수석연구원", new BigInteger("7000"));
        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        System.out.println(list);//넣은 순서대로
        Collections.sort(list);
        System.out.println("##########");
        System.out.println(list);//이름 순서대로
    }
}
Colored by Color Scripter
cs


그냥 출력했을 때는 넣은 순서대로 1,2,3,4 들어가 있지만, 정렬한 후에는 이름 순서대로 "amateur", "jdk", "jeong", "pro" 

로 된 것을 확인할 수 있다.

Comparator example

Comparator는 일반적이지 않은 문자열의 길이 순으로 보고 싶다든지, Comparable로 구현한 것 말고 기준으로 정렬하고 싶다든지 할 때 사용한다.

예를 들어서 위의 예시에서 Comparable로 이름순으로 해놨다고 치자. 그런데 나는 연봉순으로 보고싶다든지 부서명으로 보고싶다든지할 수가 있다.

이럴때마다 compareTo를 수정할 수 없고 런타임중에는 심지어 불가능한 일이다.

대신 이럴 때 Comparator를 사용하면 정렬이 필요할 때 특수한 기준을 줄 수 있다.

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "jdk", "솔루션개발1", "연구원", new BigInteger("2800"));
        Employee employee2 = new Employee(2, "jeong", "솔루션개발1", "선임연구원", new BigInteger("3200"));
        Employee employee3 = new Employee(3, "amateur", "솔루션개발2", "연구원", new BigInteger("2800"));
        Employee employee4 = new Employee(4, "pro", "솔루션개발2", "수석연구원", new BigInteger("7000"));
        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        System.out.println(list);//원본
        Collections.sort(list);
        System.out.println("##########sort#########");
        System.out.println(list);//Comparable sort
        //익명의 Comparator를 만듦
        Comparator<Employee> salesComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getSales().intValue() - o1.getSales().intValue();
            }
        };
        Collections.sort(list,salesComparator);
        System.out.println("##########sort#########");
        System.out.println(list);//Comparator sort
    }
}
 
Colored by Color Scripter
cs
* 일반적으로 Comparator를 만들 때 위의 예제처럼 익명 클래스를 만들어서 사용한다.

왜냐하면 Comparator를 사용하는것 자체가 그 때 그 때마다 정렬 기준이 바뀔 수 있는 것이기 때문이다.

결과는 아래와 같다.



원본은 객체를 넣은 순서대로 존재하고, comparable을 이용한 정렬은 이름순대로 나오게 했으니 이름순으로 나오고, 

Comparator로 정렬기준을 변경해서 받아보았을 때는 적용한대로 연봉(sales)순으로 나오게 됐다.

연봉 협상 시즌(?)인데 연봉 기준으로 받아보니까 기분이 묘하다.

머릿속에 정리하면 Comparable은 일반적인 정렬, Comparator는 커스터마이즈(customize) 정렬에 사용되고 "비교"가 아니다. 끝.


```
