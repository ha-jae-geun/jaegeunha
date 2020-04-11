# sort
* Comparable : 객체 간의 일반적인 정렬이 필요할 때, Comparable 인터페이스를 확장해서 정렬의 기준을 정의하는 compareTo() 메서드를 구현한다.
* Comparator : 객체 간의 특정한 정렬이 필요할 때, Comparator 인터페이스를 확장해서 특정 기준을 정의하는 compare() 메서드를 구현한다.공통점은 정렬의 기준을 정의한다는 것이고,
* 차이점은 정렬 기준이 일반적이냐 일반적이지 않냐와 compareTo(Object o) 메서드를 구현하느냐 compare(Object o1, Object o2) 메서드를 구현하느냐가 전부다.
* 머릿속에 정리하면 Comparable은 일반적인 정렬, Comparator는 커스터마이즈(customize) 정렬에 사용되고 "비교"가 아니다

## Comparable
* Comparable은 객체 간의 정렬에 있어서 오름차순, 내림차순등의 일반적인 순서를 잡는 기준이 필요할 때 객체 클래스에 확장해서 사용한다.
* A.compareTo(B) 일 때 A<B 인 경우는 음수를 리턴하고, A=B일 때는 0을 리턴하고, A>B일 때 양수를 리턴한다.
* 즉, 정렬에 있어서 앞에 오고 싶을 때 음수를 내보내면 된다.
* 주의해야할 점은 아무 음수, 아무 양수를 내보내면 되는것이 아니다. 마찬가지로 -1, 0 ,1만 사용하는 것이 아니다.
* a.compareTo(b) == -(b.compareTo(a)) 조건을 만족하게 구성해주면 된다.
```java
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
 
```

## comparator
* Comparator는 일반적이지 않은 문자열의 길이 순으로 보고 싶다든지, Comparable로 구현한 것 말고 기준으로 정렬하고 싶다든지 할 때 사용한다.
예를 들어서 위의 예시에서 Comparable로 이름순으로 해놨다고 치자. 그런데 나는 연봉순으로 보고싶다든지 부서명으로 보고싶다든지할 수가 있다. 이럴때마다 compareTo를 수정할 수 없고 런타임중에는 심지어 불가능한 일이다. 대신 이럴 때 Comparator를 사용하면 정렬이 필요할 때 특수한 기준을 줄 수 있다.
* 일반적으로 Comparator를 만들 때 위의 예제처럼 익명 클래스를 만들어서 사용한다. 왜냐하면 Comparator를 사용하는것 자체가 그 때 그 때마다 정렬 기준이 바뀔 수 있는 것이기 때문이다. 결과는 아래와 같다.

```java
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
내림차순 : return (o2+o1).compareTo(o1+o2);
오름차순 : return (o1+o2).compareTo(o1+o2);
}


출처: https://jeong-pro.tistory.com/173 [기본기를 쌓는 정아마추어 코딩블로그]
```

1. 
```java
public String solution(int[] numbers) {
	String answer = new String();
	/** 1 **/
	String str_numbers[] = new String[numbers.length];
	
	/** 2 **/
	for(int i=0; i<str_numbers.length; i++) {
		str_numbers[i] = String.valueOf(numbers[i]);
	}
	
	/** 3 **/
	Arrays.sort(str_numbers, new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			return (o2+o1).compareTo(o1+o2);
		}
	});
	
	/** 4 **/
	if(str_numbers[0].startsWith("0")) { 
		answer += "0";
	} else {
		for(int j=0; j<str_numbers.length; j++) {
			answer += str_numbers[j];
		}
	}
	
	return answer;
}
```

2. 
```java
 Collections.sort(wordList, new Comparator<DividedWord>(){
          @Override
          public int compare(DividedWord d1, DividedWord d2){
              String d1Head = d1.head.toLowerCase();
              String d2Head = d2.head.toLowerCase();

              int d1Number = Integer.parseInt(d1.number);
              int d2Number = Integer.parseInt(d2.number);

              // System.out.println(d1Head+ " " + d2Head +" "+ d1Head.compareTo(d2Head));
              if(d1Head.compareTo(d2Head)<0) return -1;
              else if(d1Head.compareTo(d2Head)==0) {
                  if(d1Number<d2Number) return -1;
                  else if(d1Number==d2Number) return 0;
                  else return 1;
              }
              else return 1;
          }

      });
      
  class DividedWord{
        String head;
        String number;
        String tail;

        public DividedWord(String head, String number, String tail){
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        public String toString(){
            return this.head+"/"+this.number+"/"+this.tail;
        }
    }x      
```


<hr/>
