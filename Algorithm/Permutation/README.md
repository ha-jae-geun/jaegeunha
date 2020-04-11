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
