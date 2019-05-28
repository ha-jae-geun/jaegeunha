# 자바


## 배열 동적 선언
- public static void main(String[ ] args) {
- int[ ][ ] num = new int[3][ ];
- num[0] = new int[3];
- num[1] = new int[2];
- num[2] = new int[1];


## 동적 2차원 배열 값 반환
- String[ ][ ] name = {{"홍길동", "전우치", "임꺽정"}, {"장길산", "일지매"}, {"조세형"}};
- // 배열의 주소값을 반복한다.
- for (String[ ] strings : name) {
- // 배열의 실제값을 반복한다.
- for (String string : strings) {
- System.out.println(string);
- }
- }


## BufferedReader로 입력 받기
- InputStreamReader inputStreamReader = new InputStreamReader(System.in);
- BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
- int[ ] num = new int[3];
- int tot = 0;
- int ave;
- System.out.println("점수를 입력하세요.");
- for (int i = 0; i < num.length; i++) {
- System.out.print((i + 1) + "번째 점수: ");
- num[i] = Integer.parseInt(bufferedReader.readLine( ));
- // 배열의 크기만큼 총점을 누적한다.
- tot = tot + num[i];
- }


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
# 큐
```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
 
public class Main {
 
 
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Queue queue = new LinkedList();
        ArrayList<Integer> list = new ArrayList<Integer>();
        String s = scanner.nextLine();
        String[] str = s.split(" ");
        int k = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);
        int cnt = 1;
        String ans ="";
        
        for (int i = 0; i < k; i++) {
            queue.offer(i+1);
        }
        
        while(true) {
            if (cnt%n == 0) {
                list.add((Integer) queue.poll());
                cnt = 1;
            } else {
                queue.offer(queue.poll());
                cnt++;
            }
            
            if (queue.isEmpty()) {
                break;
            }
        }
        for (int i = 1; i <= list.size(); i++) {
            if(i == list.size()) {
                ans = ans + Integer.toString(list.get(i-1));
            }else {
                ans = ans + Integer.toString(list.get(i-1)) + ", ";
            }
        }
        System.out.println("<" + ans + ">");
    }
}
```
