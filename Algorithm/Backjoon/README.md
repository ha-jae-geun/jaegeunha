# 완전탐색
## 1, 2, 3 더하기(9095)
```java
import java.util.Scanner;
 
public class Baekjoon9095 {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        int n;
        
        int[] output = new int[11]; //동적으로 생성시키니 메모리 초과가 되서 정적으로 선언
        output[1] = 1; // 1을 넣을 경우 경우의 수 1가지(1)
        output[2] = 2; // 2를 넣을 경우 경우의 수 2가지(1+1, 2)
        output[3] = 4; // 3을 넣을 경우 경우의 수 3가지 (1+1+1, 1+2, 2+1, 3)
        
        for(int i=0; i<t; i++){
            n = scanner.nextInt();
            
            for(int j=4; j<=n; j++){
                output[j] = output[j-1] + output[j-2] + output[j-3];
            }
            System.out.println(output[n]);
        }
        
 
    }
 
}

```



## 날짜계산(1476)
```java
import java.util.Scanner;
 
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        final int E = sc.nextInt();
        final int S = sc.nextInt();
        final int M = sc.nextInt();
        int e = 1;
        int s = 1;
        int m = 1;
        for (int i=1 ; ; i++) {
            if (e == E && s == S && m == M) {
                System.out.println(i);
                break;
            }
            e++;
            s++;
            m++;
            if (e == 16) {
                e = 1;
            }
            if (s == 29) {
                s = 1;
            }
            if (m == 20) {
                m = 1;
            }
        }
    }
}

[출처](https://appree.tistory.com/6)
```



## 리모컨(1107)



## 외판원순회
* 10971

## 로또
* [로또](https://www.acmicpc.net/problem/6603)

```java
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
class Main {
    static int N;
    static int[] arr;
    static int[] result;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        while (true) {
            String[] str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            arr = new int[N];
            result = new int[N];
 
            if (N == 0) {
                break;
            }
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(str[i + 1]);
            }
            DFS(0,0);
            System.out.println();
        }
 
 
    }
    public static void DFS(int start, int depth){
        if(depth==6){
            print();
        }
        for(int i=start; i<N; i++){
        result[i] = 1;
        DFS(i+1,depth+1);
        result[i] = 0;
        }
        
    }
    public static void print(){
        for(int i=0; i<N; i++){
            if(result[i]==1)
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
}
```


<hr/>

# 순열
## 차이를 최대로(10819)
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 순열구하기
	static int max =0; 
	public static void perm(int[] a, int depth, int n){
		if(depth==n){
			sum(a, n);
			return;
		}
		for(int i=depth; i<n; i++){
			swap(a, i, depth);
			perm(a, depth+1, n);
			swap(a, i, depth);
		}
	}
	
	
	static void swap(int[] a, int depth, int n) {
		int temp = a[depth];
		a[depth] = a[n]; 
		a[n] = temp;
		
	}


	static void sum(int[] a, int k) {
		int sum =0;
		for (int i = 2; i <= k; i++) { 
			sum += Math.abs(a[i-2]-a[i-1]);
		}
		if(max<sum){
			max = sum;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num[] = new int [n];
		String number = br.readLine();
		StringTokenizer st = new StringTokenizer(number, " ");
		for(int i =0; i<n; i++){
			num[i] = Integer.parseInt(st.nextToken());
		}
		perm(num, 0, n);
		System.out.println(max);

		
		
		
	}
}

순열을 구하는 문제는 그냥 perm()함수와 swap()함수 이 두개를 동시에 가져가면 좋습니다. 이 알고리즘은 자리를 perm는 말그대로 순열을 만드는 문제고, swap은 그 배열안의 모든 원소들을 자리 이동하는 함수이므로, 그것을 잘 섞어서 연결해주면 됩니다.

출처: https://sundries-in-myidea.tistory.com/5 [DesiProm]
```

## 함수 설명
```java
perm(int[] arr, int depth, int n, int k)

배열 arr 은 계속해서 데이터를 들고다니면서 교환되고 있는 배열이다.

depth 는 현재 트리구조에서 어떤 깊이에서 교환작업을 하고있는지에 대한 변수이다. 즉, 맨처음 깊이라면 0의 위치에서 작업하고 있을것이며 이는

첫번째와 첫번째 인자를 교환하거나(1,2,3,4) 

첫번째와 두번째 인자를 교환(2,1,3,4)하거나,

첫번째와 세번째(3,2,1,4) 인자를 교환하거나

첫번째와 네번째(4,2,3,1) 인자를 교환하는 중이다.

아래로 죽 내려서 최종결과를 참고해보고 이와같은 순서로 컴퓨터가 교환하고 있는지 확인해보면 아항 그렇구나라고 느끼게 된다. 물론 프로그램은 재귀적으로 계속 깊이 탐색되므로, depth는 0에대한 것을 다끝마치고 1로 넘어가는 것이 아니라 0,1,2,3,2,3,1,2,3 과 같은 형태로 내부적으로 변하고 있다. 물론 프로그램의 시작점에서는 0으로 넣어주어야 한다.  

n은 총 배열안에 들어있는 숫자를 뜻하며 고정값이다. 샘플은 1,2,3,4 네개이므로 4로 고정된다.

k는 몇개를 뽑아내서 순열을 만들것인지를 뜻하며 고정값이다. 샘플은 1,2,3,4 모두를 사용해 순열을 만드므로 4로 고정된다.
```

## Swap함수
```java
swap()함수가 내부적으로 외부의 값들을 막 바꾸고 있다. perm()의 depth가 4가되어 한번 돌때마다 arr가 내부적으로 가지고있는 배열의 순서는 바뀌어져있다.

두번째 swap()은 전단계의 분기점에서의 배열의 순서를 기억하고 이를 초기화하는 작업에 지나지 않는다. 트리구조에서 depth는 0,1,2,3,2,3,1,2,3 뭐 이런식으로 한칸 두칸 뒤로 돌아가면서 다시 계산을 하는데 그 지점에서의 배열 안의 숫자 순서를 기억하고 있어야 한다. swap()없이 바로 사용하고자 한다면, 분기로 돌아가서 다시 교환을 하는게 아니라 이미 다른 분기에서 망가뜨려버린 배열의 순서를 그대로 이용하게 된다. 결론적으로 황당한 순열들이 마구 튀어나오게 된다.
출처: https://gorakgarak.tistory.com/522 [먹거리 만드는 열정맨 고락가락]
```


<hr/>

## 순열2
```java
import java.util.*;

class Solution {
    //중복 없애기 위해 HashSet 사용
	static HashSet<Integer> primeNum = new HashSet<>();

	public static int solution(String numbers) {
		int answer = 0;
		boolean isPrime = false;
		perm(numbers.toCharArray(), 0, numbers.length());
        //HashSet 반복 위함
		Iterator it1 = primeNum.iterator();

		while (it1.hasNext()) {
			isPrime = false;
			int next = (int) it1.next();
			
			if(next == 1 || next == 0)
				continue;
			for (int i = 2; i < next; i++) {
				// 1과 num 자신 외에 나누어지는 수가 있는지 검사할 조건문
				if (next % i == 0) {
					// 나누어지는 수가 있을 경우 isPrime의 값을 true로 바꾼다.
					isPrime = true;
					// 한 번이라도 이 조건문이 실행될 경우 num은 소수가 아니므로 반복문을 빠져나온다.
					break;
				}
			}
			if (!isPrime)
				answer = answer + 1;

		}
		return answer;
	}

	public static void perm(char[] arr, int depth, int n) {
		int a = 0;
		if (depth == n) {
			for (int i = 0; i < arr.length; i++) {
                //1자리수 일 때 고려
				primeNum.add((int) ((int) (arr[i] - '0') * Math.pow(10, i)));
                //2자리 수 이상일 때 고려
				a = a + (int) ((arr[i] - '0') * Math.pow(10, i));
				primeNum.add(a);
			}
			
		}
		for (int i = depth; i < n; i++) {
            //swap 메소드
			swap(arr, i, depth);
            //순열 메소드 다시 실행
			perm(arr, depth + 1, n);
            //원래대로 다시 swap
			swap(arr, i, depth);
		}
	}

	public static void swap(char[] arr, int n1, int n2) {
		char temp = arr[n1];
		arr[n1] = arr[n2];
		arr[n2] = temp;
	}
}
```
# 조합
```java
package Combination;
 
import java.util.Arrays;
 
public class Combination {
    public static void main(String[] ar){
        Combination ex = new Combination();
        int[] arr = { 1, 2, 3 };
        int n = arr.length;
        int r = 2;
        int[] combArr = new int[n];
 
        ex.doCombination(combArr, n, r, 0, 0, arr);
    }
 
    public void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr){
        System.out.println("=> "+n+" "+r+" "+index+" "+target);
         
        // r ==0 이란 것은 뽑을 원소를 다 뽑았다는 뜻.
        if(r == 0){
            System.out.println(Arrays.toString(combArr));
            for(int i=0; i<index; i++)System.out.print(arr[combArr[i]] + " ");
           
            System.out.println();
         
        //끝까지 다 검사한 경우..1개를 뽑은 상태여도 실패한 경우임 무조건 return 으로 종료
        }else if(target == n){ 
             
            return;
         
        }else{
            combArr[index] = target;
            // (i) 뽑는 경우 
            // 뽑으니까, r-1
            // 뽑았으니 다음 index + 1 해줘야 함
            doCombination(combArr, n, r-1, index+1, target+1, arr);
             
            //(ii) 안 뽑는경우
            // 안뽑으니까 그대로 r
            // 안뽑았으니, index는 그대로!
            // index를 그대로하면, 예를 들어 현재 1번 구슬을 comArr에 넣엇어도 다음 재귀에 다시 엎어쳐서 결국 1구슬을 뽑지 않게 된다.
            doCombination(combArr, n, r, index, target+1, arr); 
        }
    }
}
```

## 조합2
```java
    public static void combination(String[] arr, int index, int n, int r, int target, String arr2) {
		StringBuilder sb = new StringBuilder();
    	if(r == 0) {
    		if(!arr2.equals(""))
    			primeString.add(arr2);
    	}
		else if (target == n) {
			if(!arr2.equals(""))
				primeString.add(arr2);
		}
		else {
			combination(arr, index + 1, n, r - 1, target + 1, arr2 + arr[index]);
			combination(arr, index+1, n, r, target + 1, arr2);
		}
	}//end combination()
```

# 큐(BFS)
## 숨박꼭질(1697)
```java
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] Min = new int[100005];
        Arrays.fill(Min, -1);    //초기값을 다 -1로 설정
        System.out.println(BFS(N, K, Min));
 
    }
 
    public static int BFS(int N, int K, int[] Min) {
        int nextN = N;
        int[] status = new int[3];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(nextN);
        Min[nextN] = 0;
 
        while (!q.isEmpty() && nextN != K) {
 
            nextN = q.poll();
            //다음에 이동할 좌표들
            status[0] = nextN - 1;     //뒤로 한칸
            status[1] = nextN + 1;    //앞으로 한칸
            status[2] = nextN * 2;    //순간이동
 
            for (int i = 0; i < 3; i++) {
                //배열을 벗어나지 않았는지 확인
                if (status[i] >= 0 && status[i] <= 100000) {
                    //이전에 방문했는지 확인
                    if (Min[status[i]] == -1) {
                        //처음 간 곳이라면 큐에 넣고 상태를 전 위치값 +1 을 해준다.
                        q.add(status[i]);
                        Min[status[i]] = Min[nextN] + 1;
 
                    }
                }
            }
        }
        return Min[K];
    }
}

```


## 소수경로(1963) 

## DSLR(9019)

## 퍼즐(1525) 

## 물통(2251)


# 재귀호출, 비트마스크

## 암호만들기(1759)
* [1759]('https://www.acmicpc.net/problem/1759')
```java
import java.util.Arrays;
import java.util.Scanner;
 
public class Q1759 {
    public static boolean check(String password) {
        int ja = 0;
        int mo = 0;
        for (char x : password.toCharArray()) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo += 1;
            } else {
                ja += 1;
            }
        }
        return ja >= 2 && mo >= 1;
    }
    
    public static void go(int n, String [] alpha, String password, int i) {
        if(password.length() == n) { 
            if(check(password)) { //모음 자음 개수 검사
                System.out.println(password);
            }
            return;
        }
        if(alpha.length <= i) 
            return;
        
        go(n, alpha, password+alpha[i], i+1); //사용하는 경우
        go(n, alpha, password, i+1); //사용하지 않는 경우
    }
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int c = scan.nextInt();
        scan.nextLine();
        String [] alpha = scan.nextLine().split(" ");
        
        Arrays.sort(alpha);
        go(n, alpha, "", 0);
    }
}

```

## N-Queen(9663)

## 스도쿠(2580)

## 알파벳(1987)

## 부분집합의 합(1182)

## 수들의 합 2
* (2003), 소수의 연속합(1644)



<hr/>



# 덱사용 
## 알고스팟(1261)

## 알고스팟 중간에서 만나기(1208)

## 합이 0인 네정수(7453)




<hr/>



# DP
* O(높이 제곱) 을 O(n)으로 낮춰줌
* 큰 문제를 작은 문제로 나눳 푸는 알고리즘
* 피보나치수, Optimal Substructure

## DP를 푸는 방법
* 둘 중에 하나만 잘하면 됨
1. Top- down
2. Bottom-up

## 1로 만들기
* 1463

## 2Xn 타일링
* 11726

## 1, 2, 3 더하기
* 9095

## 붕어빵 판매하기
* 11052

## 이친수
* 2193

## 쉬운 계단 수
* 10844

## 오르막 수
* 11057

## 스티커
* 9465

## 포도주 시식
* 2156

## 가장 긴 증가하는 부분 수열
* 11053

## 가장 긴 감소하는 부분 수열
* 11054

## 연속합
* 1912

## 계단 오르기
* 2579

## 제곱수의 합
* 1699

## 타일 채우기
* 2133

## 합분해
* 2225

## 암호코드
* 2011

## 이동하기
* 11048

## 점프
* 1890

## 팰린드롬
* 10942

## 동전1
* 2293

## 내리막길
* 1520

## 파일 합치기
* 11066

## 구간 나누기
* 2228

## 자두나무
* 2240

## 고층빌딩
* 1328

## 기타리스트
* 1495

## 1학년
* 5557

## 올바른 괄호 문자열
* 3012

## 같은 탑
* 1126
