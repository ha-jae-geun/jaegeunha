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


## 리모컨(1107)


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

```
[출처](https://appree.tistory.com/6)


## 차이를 최대로
* 10819

## 외판원순회
* 10971

## 로또
* 6603



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
