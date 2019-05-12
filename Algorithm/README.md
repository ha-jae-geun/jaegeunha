# 순서도
## 증감문
* 증감문이 위면 < 아래면 <=

# for문
- for( 식1 ; 조건1 ; 식2)
{
   코드 1
}

## 정답
- 식1 수행 --> 조건1 검사 --> 코드1 수행 --> 식2 수행 --> 조건1 검사 --> 코드1 수행 --> 식2 수행 --> 조건1 검사 …

## 오답
- 식1 수행 --> 조건1 검사 --> 코드1 수행 --> 조건1 검사 --> 식2 수행 --> 코드1 수행 --> 조건1 검사 --> 식2 수행 .



-- 
# 정렬
## 버블 정렬
 * N * (N + 1) / 2  여서 O(N2) 이지만 가운데 스왑을 계속 해주어야 해서 삽입정렬보다도 실질적으로 안좋은 제일 안좋은 정렬


## 삽입 정렬
 * 자신보다 앞의 원소가 큰지 작은지 비교를 하여서 자신의 위치를 찾아서 '삽입' 하는 정렬입니다.
 * 앞의 원소를 비교해야 하기 때문에 arr[1]~arr[n] 까지 진행합니다. (두번째 원소인 arr[1] 부터 시작.)
 * 삽입을 하면 데이터가 하나씩 밀려야 하기 때문에 배열이 길어질수록 효율이 떨어집니다.


## 퀵 정렬
 - 장점
 * 속도가 빠르다.
 * 시간 복잡도가 O(nlog₂n)를 가지는 다른 정렬 알고리즘과 비교했을 때도 가장 빠르다.
 * 추가 메모리 공간을 필요로 하지 않는다.
 * 퀵 정렬은 O(log n)만큼의 메모리를 필요로 한다.
 - 단점
 * 정렬된 리스트에 대해서는 퀵 정렬의 불균형 분할에 의해 오히려 수행시간이 더 많이 걸린다.
 * 퀵 정렬의 불균형 분할을 방지하기 위하여 피벗을 선택할 때 더욱 리스트를 균등하게 분할할 수 있는 데이터를 선택한다.
 * EX) 리스트 내의 몇 개의 데이터 중에서 크기순으로 중간 값(medium)을 피벗으로 선택한다.


## 힙 정렬
 * - 사실 선택 정렬과 거의 같은 알고리즘으로. 단지 가장 큰 원소를 뒤로 보내는 데에 단순히 매번 쭉 돌면서 알아내느냐 힙을 사용하여 알아내느냐가 유일한 차이점이다.
 * 힙정렬은 추가적인 메모리를 전혀 필요로 하지 않는다는 점과, 최악의 경우에 O(n2)의 성능을 내는 퀵정렬과 달리 항상 O(nlgn) 정렬의 성능을 발휘하는 장점이 있다. 하지만 실제 코드를 짜서 비교를 해 보면 퀵정렬이 힙정렬보다 일반적인 경우에 빠르게 동작한다.
 * 그러나 아래 퀵정렬의 경우 피벗을 잡는 전략에 어느 정도의 휴리스틱이 들어가야 최악의 경우를 회피할 수 있으나 힙정렬은 휴리스틱이 필요없이 항상 일정한 성능을 보이는 장점이 있다. 즉 알고리즘에 꼼수를 쓰지 않고, 각종 하드웨어 가속도 전혀 고려하지 않고 알고리즘이 정의하는 최소한만 구현할 경우 힙정렬이 가장 안정적인 성능을 보인다.
 
 
## 리트코드 Longest Substring
### 10ms
-  int i = 0, j = 0, max = 0;
        
- Set<Character> set = new HashSet<>();

- while (j < s.length()) {
- if (!set.contains(s.charAt(j))) {
- set.add(s.charAt(j++));
- max = Math.max(max, set.size());
- } else {
- set.remove(s.charAt(i++));
- }
- }
- return max;
 

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

# 빠른 출력
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

<<<<<<< HEAD
```JAVA
=======
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
<<<<<<< HEAD
=======

>>>>>>> 9d36695573700a84269e824e296ddf461851e04c
