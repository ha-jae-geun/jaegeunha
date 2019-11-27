# Test
```
## sort 조건
1. 
```java
import java.util.Arrays;
class Solution {
    public static String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            arr[i] = String.valueOf(numbers[i]);
 
                Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
 
 
        if(arr[0].equals("0")) return "0";
         
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++)
            sb.append(arr[i]);
 
        return sb.toString();
    }
}
```

2. 
```java
Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s2 + s1).compareTo(s1 + s2);
			}
		});
```



<hr/>

# 큐
```java
Java
//큐 사용 예
import java.util.Queue;
import java.util.LinkedList;
public class Program {
	public static void main(String[] args){
		Queue<String> q = new LinkedList<String>();
		q.offer("강감찬"); //"강감찬"
		q.offer("홍길동"); //"강감찬","홍길동"
		System.out.println(q.peek());//"강감찬" 참조
		//여전히 "강감찬","홍길동"
		
		System.out.println(q.poll());//"강감찬" 꺼냄, 현재 "홍길동"
		q.offer("이순신"); //"홍길동", "이순신"
		q.offer("김구"); //"홍길동", "이순신", "김구"
		while(q.isEmpty()==false){
			System.out.println(q.poll());
			//"홍길동", "이순신", "김구" 순으로 꺼냄
```

# 비트
## xor
* 리트코드 Hamming distance
```java
class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        int cnt = 0;
        
        for(int i=0; i<32; i++){
            int b = xor>>i & 1;
            cnt = cnt+b;
        }
        return cnt;
        
    }
}
```

# 자료형
## long
* int로 하면 속도 느려짐
```java
class Solution {
    public long solution(int N) {
        long [] len = new long[N];
        len[0] = 4;
        len[1] = 6;
        
        if(N == 1)
            return 4;    
            
        if(N == 2)
            return 6;
        
        for(int i=2;i<N; i++ ){
            len[i] = len[i-2] + len[i-1];
        }
        
        return len[N-1]; 
        
    
        
    }
}
```

## 아스키코드
### 크기 비교
```java
str2[j] >= 'a'&&str2[j] <= 'z'
```

## char형을 int형으로
```java
number.charAt(i) - '0';
```

## int형을 String형으로
```java
String.valueOf(c);
```

## pow
* pow하면 double형 됨
```java
 int형 변환: c = c + (b[i]*(int)Math.pow(10, i));
```




# BackTracking
## Queen N
* [Queen](https://thd0011.tistory.com/19)
```java
import java.util.Scanner;

public class test {

    static int col[];
    static int n;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            // 첫번째 퀸의 시작점은 행을 기준. (i = 1) => (1, 1), (i = 2) => (1, 2), (i = 3) => (1, 3)
            col = new int[16];
            col[1] = i;

            // 1. DFS 수행 (다음 열인 2열 이동)
            dfs(2);
        }

        // 정답 출력
        System.out.println(ans);
    }

    static void dfs(int row) {
        // 현재 열이 체스판을 넘어 섰으면
        if (row > n) {
            ++ans;
        } else {
            for (int i = 1; i <= n; i++) {
                // 현재 위치하고 있는 노드의 좌표를 저장 (row: 열, i: 행)
                col[row] = i;

                // 2. 유망한 노드 검토
                if (isPossible(row)) {
                    // 3. 서브 트리 이동 (해당 노드의 하위 노드)
                    dfs(row + 1);
                } else {
                    // 4. 백트래킹 수행, 해당노드는 가지치기 되어진다.
                    col[row] = 0;
                }
            }
        }
    }

    static boolean isPossible(int c) {
        // 이전 열들을 탐색하면서 유망한 노드인지 확인
        for (int i = 1; i < c; i++) {
            // 상위 노드에서 같은 행에 퀸이 있는지 여부
            if (col[i] == col[c]) {
                return false;
            }
            // 대각선 검사, 상위 노드의 퀸과 현재 노드의 퀸의 가로 세로 거리가 같은지 검사
            if (Math.abs(col[i] - col[c]) == Math.abs(i - c)) {
                return false;
            }
        }
        return true;
    }
}
```

# Generic
# VALUE
```java
System.out.println(Integer.MIN_VALUE);
    // -2147483648

    System.out.println(Integer.MAX_VALUE);
    // 2147483647
    // 이십일억사천칠백사십팔만삼천육백사십칠

```
* 다 대



<hr/>




# Math
## pow
* pow하면 double형 됨
```java
 int형 변환: c = c + (b[i]*(int)Math.pow(10, i));
```




# Stack
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

# Collections
## fill
```java
1. 기본 채우기
import java.util.Arrays;
public class MyClass {
    public static void main(String args[]) {
        int[] arr = new int[] {1, 2, 3, 4, 5};
        Arrays.fill(arr, 100);
        System.out.println( Arrays.toString(arr) );
        // [100, 100, 100, 100, 100]
    }
}

2. 구간 지정하여 채우기
import java.util.Arrays;
public class MyClass {
    public static void main(String args[]) {
        int[] arr = new int[] {1, 2, 3, 4, 5};
        Arrays.fill(arr, 2, 4, 100);
        System.out.println( Arrays.toString(arr) );
        // [1, 2, 100, 100, 5]
    }
}

3. 2차원 배열 채우기
import java.util.Arrays;
public class MyClass {
    public static void main(String args[]) {
        int[][] arr = new int[3][5];
        for(int[] row: arr) {
            Arrays.fill(row, 10);
        }
        for(int[] row: arr) {
            System.out.println( Arrays.toString(row) );
        }
        // [10, 10, 10, 10, 10]
        // [10, 10, 10, 10, 10]
        // [10, 10, 10, 10, 10]
    }
}
```
## sort 조건
1. 
```java
import java.util.Arrays;
class Solution {
    public static String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            arr[i] = String.valueOf(numbers[i]);
 
                Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
 
 
        if(arr[0].equals("0")) return "0";
         
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++)
            sb.append(arr[i]);
 
        return sb.toString();
    }
}
```

2. 
```java
Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s2 + s1).compareTo(s1 + s2);
			}
		});
```

## reverse
```java
1. Collections.sort(temp, Collections.reverseOrder());
2. Collections.reverse(리스트)
```

## 배열 순서 뒤집기
```java
Collections.reverse(Arrays.asList(array));
```


## 배열을 리스트로 바꿔서 인덱스 찾기
```java
import java.util.Arrays;

public class FindKim {
    public String findKim(String[] seoul){
        //x에 김서방의 위치를 저장하세요.
        int x = Arrays.asList(seoul).indexOf("Kim");

        return "김서방은 "+ x + "에 있다";
    }

    // 실행을 위한 테스트코드입니다.
    public static void main(String[] args) {
        FindKim kim = new FindKim();
        String[] names = {"Queen", "Tod","Kim"};
        System.out.println(kim.findKim(names));
    }
```


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


# 배열
## 배열 순서 뒤집기
```java
Collections.reverse(Arrays.asList(array));
```

## 스트링 배열을 스트링으로
```java
String.join("", array);
```

## 배열 동적 선언
```java
- public static void main(String[ ] args) {
- int[ ][ ] num = new int[3][ ];
- num[0] = new int[3];
- num[1] = new int[2];
- num[2] = new int[1];
```

## 동적 2차원 배열 값 반환
```java
- String[ ][ ] name = {{"홍길동", "전우치", "임꺽정"}, {"장길산", "일지매"}, {"조세형"}};
- // 배열의 주소값을 반복한다.
- for (String[ ] strings : name) {
- // 배열의 실제값을 반복한다.
- for (String string : strings) {
- System.out.println(string);
- }
- }
```


<hr/>




# char
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


<hr/>

# 문자열
# String
## 문자열 배열 생성 방법
```java
String [][] ticket =  {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
```
1. "" 를 써줘야 함
2. {} 안에 써줌


## compareTo
```java
String1.compareTo(String2)
> String1 과 String2 가 같으면 (결과 == 0)

> String1 이 String2 보다 크면 (결과 > 0)

> String1 이 String2 보다 작으면 (결과 < 0)

 
예제)
> ("2015-05-02").compareTo("2015-05-02") == 0 은 true

> ("2015-05-04").compareTo("2015-05-02") > 0 은 true

> ("2015-04-02").compareTo("2015-05-02") < 0 은 true

> ("abcdef").compareTo("accdef") < 0 은 true

```

## contains 메소드
* contains 메소드는 문자열 안에 특정한 문자열이 포함 되어있는지 확인 할때, 사용한다.
```java
String s = "I have a book";  

s.contains("book");
//이라고 할때, 위 코드는 true를 반환한다.
```

## startWith 메소드
* startWith 메소드는 문자열이 특정 문자열로 시작하는지 확인할때, 사용한다.

```java
String s = "abcde";

이라고 할때, 위 코드는 true를 반환 한다.
s.startWith("abc");
```


## 슬라이싱
```java
StringBuilder sb= new StringBuilder();
            String s= sc.next();
            int M = N/4;
            sb.append(s);
            sb.append(s.substring(0,M));
            Set<String> set = new HashSet<>();
            for(int i=0; i<s.length(); i++) {
                set.add(sb.substring(i,i+M));
            }
```

### 배열 슬라이싱
```java
```java
Arrays.copyOf(원본배열, 복사할 길이);

Arrays.copyOfRange(원본 배열, 복사할 시작인덱스, 복사할 끝인덱스) 인덱스는 0부터 시작하는것 기준
```
```

## charAt
```java
public static int getStrike(String chk, String num) {
		int cnt = 0;
		for(int i = 0; i < 3; i++)
			cnt += chk.charAt(i) == num.charAt(i) ? 1 : 0;
		
		return cnt;
	}
```

## valueOf
```java
for(int i = 0; i < baseball.length && cnt < baseball.length; i++) {
            	int strike = getStrike(chNum, String.valueOf(baseball[i][0]));
            	int ball = getBall(chNum, String.valueOf(baseball[i][0])); 
        		
            	if(strike == baseball[i][1] && ball == baseball[i][2])
            		cnt++;
            }
```

## valueOf
```java
 String.valueOf()

    - 파라미터가 null 이면 문자열 null을 만들어서 담는다.

- Casting

    - 대상이 null 이면 NullPointerException 발생.

    - Object 값이 String 이 아니면  ClassCastException 발생.
    
- "".toString()

    - 당연하게 .  으로 사용하는 만큼 대상 값이 null 이면 NullPointerException 발생.

    - Object 에 담긴 값이 String 이 아니라도 출력.

차이점은 null값이 따른 NullPointException의 발생 유무.

 
- 예제
	String str = null;

	System.out.println((String) str);           // 'null' text return

	System.out.println(String.valueOf(str));    // 'null' text return

	System.out.println(str.toString());         // NullPointException
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

## String형 뒤집기
```java
 public static String reverseString(String s){
        return (new StringBuffer(s)).reverse().toString();
    }
```

## 스트링 배열을 스트링으로
```java
String.join("", array);
```

## substring
```java
1. substring(앞, 뒤) 는 뒤에 있는 숫자의 위치를 포함하지 않는다.
```

## ArrayList의 숫자 + 문자
```java
1. 문자열 + 숫자: 문자열
String result = arrayInt[0] + " " + arrayInt[arrayInt.length - 1];
```

## charat
```java
Set<Character> set = new HashSet<>();
if (!set.contains(s.charAt(j))) {
      set.add(s.charAt(j++));
```

## StringBuffer
### String
```java
 public static String reverseString(String s){
        return (new StringBuffer(s)).reverse().toString();
    }
```


### 수박 생성
```java
public class WaterMelon {
    public String watermelon(int n){
        StringBuffer sf = new StringBuffer();
        for (int i=1; i<=n; ++i) {
            sf.append(i%2==1?"수":"박");
        }
        return sf.toString();
    }

    // 실행을 위한 테스트코드입니다.
    public static void  main(String[] args){
        WaterMelon wm = new WaterMelon();
        System.out.println("n이 3인 경우: " + wm.watermelon(3));
        System.out.println("n이 4인 경우: " + wm.watermelon(4));
    }
}
1. 3항연산자
2. .toString()

```


<hr/>


# Hashset
## replace
```java
        for (int i = 0; i < clothes.length; i++) {
            if (hm.containsKey(clothes[i][1]))
                hm.replace(clothes[i][1], hm.get(clothes[i][1])+1);
            else
                hm.put(clothes[i][1], 1);
        }
```

## key값 반복
```java
		for (String s : hashMap.keySet()) {
			for (String s2 : hashMap.keySet()) {
				if (!s.equals(s2) && hashMap.get(s) > hashMap.get(s2)) {
					hashMap2.replace(s, hashMap2.get(s), hashMap2.get(s)+1);
				}
			}
		}
```

## value 반복
* values라는 것이 있음
```java
        for(int value : map.values()){
            //이 문제의 공식은 (n+1)* (k+1) ... -1
            answer = answer * (value+1);
        }
```

## charat
```java
Set<Character> set = new HashSet<>();
if (!set.contains(s.charAt(j))) {
      set.add(s.charAt(j++));
```



<hr/>



# HashMap
```java
ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();


이렇게 하면 ArrayList안에 String(key), String(value) 쌍인 HashMap을 집어 넣을 수 있다
이제 HashMap을 두개 생성하고 데이터를 넣어보자.


HashMap<String, String> personMap1 = new HashMap<String, String>();
map.put("이름", "김경태");
map.put("나이", "28");
map.put("직업","게이머");

HashMap<String, String> personMap2 = new HashMap<String, String>();
map.put("이름", "이아영");
map.put("나이", "28");
map.put("직업","디자이너");

//이렇게 두개의 HashMap객체를 먼저 만들어 놓았던 ArrayList에 넣어보자.

list.add(personMap1);
list.add(personMap2);

이렇게 하면 ArrayList의 객체 list에 두개의 HashMap이 들어가 있게 된다.
이제 빼서 사용해보자..

HashMap<String, String> takeMap1 = (HashMap<String,String>)list.get(0);
String name1 = takeMap1.get("이름");
String age1 = takeMap1.get("나이");
String job1 = takeMap1.get("직업"); 


```




<hr/>



# StringTokenizer
## 함수
* countTokens()                            토큰의 갯수를 리턴한다.
* nextToken()                                다음 토큰을 리턴한다. 이전 토큰은 제거한다.
* nextToken(String delim)                구획문자(delimiter)를 delim으로 바꾼 후 바뀐 다음 토큰을 리턴한다. 예를들어 this$1is$1string 이라고 하면 생성자에서 구획문자를$1로 설정했다가 nextToken으로 this를 받고 2번째 nextToken은 delim을 $로 받으면(nextToken("$")) 1is를 리턴한다.
* hasMoreTokens()                        리턴할 다음 토큰이 있으면 true를 다음 토큰이 없으면 false를 리턴한다.




```java
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =  Integer.parseInt(br.readLine());
        int[] val = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; ++i){
        val[i] = Integer.parseInt(st.nextToken());
        }
```

```java
import java.util.StringTokenizer; 
public class JavaTestMain { 
	public static void main(String[] args) { 
		String str = "this is my string"; 
		StringTokenizer st = new StringTokenizer(str); 
		System.out.println(st.countTokens()); 
		while(st1.hasMoreTokens()) { 
			System.out.println(st.nextToken()); 
		} 
		System.out.println(st.countTokens()); 
	} 
}
```


# Split 예제
```java
 import java.util.*;
 import java.lang.*;
 import java.io.*;

 class Main {
    
     public static void main(String[] args) throws java.lang.Exception {
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         // int A = Integer.parseInt(in.readLine());
        // int B = Integer.parseInt(in.readLine());
        
         String input =in.readLine();
         String[] words = input.split(" ");
         int A = Integer.parseInt(words[0]);
         int B = Integer.parseInt(words[1]);
        
        
         System.out.println(A+B);
     }
 }
```

# Buffer
## 빠른 출력
``` JAVA
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       int testCase = Integer.parseInt(br.readLine());
       int a, b;

 

for (int i=0; i<testCase; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      bw.write(a + b + "\n"); 
}
bw.flush();

}

}
```

# float
```java
>>>>>>> 9d36695573700a84269e824e296ddf461851e04c
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int n, total, count;
        double avg;
        int scores[] = new int[1000];
         
        for (int i = 0; i < c; ++i) {
            n = sc.nextInt();
            total = 0;
            count = 0;
            for (int j = 0; j < n; ++j) {
                scores[j] = sc.nextInt();
                total += scores[j];
            }
            avg = (double)total / n;
             
            for (int j = 0; j < n; ++j) {
                if (scores[j] > avg) {
                    count++;
                }
            }
            System.out.printf("%.3f", 100.0 * count / n);
            System.out.println("%");
        }
        sc.close();
    }
}
```

