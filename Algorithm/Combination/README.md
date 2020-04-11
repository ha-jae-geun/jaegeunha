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

# 부분수열의 합
```java
import java.util.*;
import java.io.*;
 
// https://www.acmicpc.net/problem/1182
 
class Main {
    static int count = 0;
    static int s;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
 
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
 
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
 
        powerSet(arr, n, 0, 0);        
        // s가 0 일때는 부분집합 중에 공집합인 경우도 카운트 될 수 있음
        if(s == 0)
            count--;
        System.out.println(count);
    }
 
    static void powerSet(int[] arr, int n, int idx, int sum) {
        if(idx == n) {
            if(sum == s)
                count++;
            return;
        }
 
        powerSet(arr, n, idx + 1, sum);
        powerSet(arr, n, idx + 1, sum + arr[idx]);
    }
}
```
