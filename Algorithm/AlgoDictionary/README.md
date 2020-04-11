# Test



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

