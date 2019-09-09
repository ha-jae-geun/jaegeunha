# Array
## copyOf
```java
Arrays.copyOf(원본배열, 복사할 길이);

Arrays.copyOfRange(원본 배열, 복사할 시작인덱스, 복사할 끝인덱스) 인덱스는 0부터 시작하는것 기준
```

# Collections
## reverse
```java
1. Collections.sort(temp, Collections.reverseOrder());
2. Collections.reverse(리스트)
```

## 배열 순서 뒤집기
```java
Collections.reverse(Arrays.asList(array));
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
```java
1. 문자열 + 숫자: 문자열
String result = arrayInt[0] + " " + arrayInt[arrayInt.length - 1];
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


# String
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
## charat
```java
Set<Character> set = new HashSet<>();
if (!set.contains(s.charAt(j))) {
      set.add(s.charAt(j++));
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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Ex15552 {
 
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++) {
                String[] temp = br.readLine().split(" ");
                bw.write(Integer.parseInt(temp[0])+Integer.parseInt(temp[1])+"\n");
            }
            bw.flush();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
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

