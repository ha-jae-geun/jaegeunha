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
* 6603



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

<hr/>


# 큐(BFS)
## 숨박꼭질(1697)

## 소수경로(1963) 

## DSLR(9019)

## 퍼즐(1525) 

## 물통(2251)


# 재귀호출, 비트마스크

## 암호만들기(1759)

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
