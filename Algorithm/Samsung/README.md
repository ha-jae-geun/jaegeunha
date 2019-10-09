# 원자소멸
* https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRFInKex8DFAUo
* 답: https://developer-pi.tistory.com/27?category=824991

# 디저트 카페
* 답: https://developer-pi.tistory.com/35?category=824991

```java
import java.util.Scanner;
 
public class Solution {
    static int N, ans;
    static int[][] map;
     
    public static void calc(int x, int y, int a, int b) {
        int cnt=0;
        int[] v=new int[101];
         
        for(int i=0; i<a*2+b*2; i++) {
            if(i<a) {x++; y++;}
            else if(i<a+b) {x++; y--;}
            else if(i<a*2+b) {x--; y--;}
            else {x--; y++;}
            if(x<0||y<0||x>=N||y>=N||v[map[x][y]]==1) return;
            v[map[x][y]]=1; cnt++;
        }
         
        ans=Math.max(ans, cnt);
    }
     
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            N=sc.nextInt(); ans=-1;
            map=new int[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) 
                    map[i][j]=sc.nextInt();
            }
             
            for(int k=N-1; k>=2; k--) {
                for(int a=1; a<N-1; a++) {
                    for(int i=0; i<N; i++) {
                        for(int j=0; j<N; j++) 
                            calc(i, j, a, k-a);
                    }
                }
            }
             
            System.out.println("#"+tc+" "+ans);
        }
    }
}
```

# 시험감독 수
```java

```
* "LONG"으로 만드는 것이 중요합니다. int가 가진 수의 범위를 초과할 수 있으므로, 조심해야합니다. 두번째 요인은 밑에 정답코드를 보고 확인 해보시죠.

* [출처](https://sundries-in-myidea.tistory.com/6 [DesiProm])


# 보물상자
* 문제: https://swexpertacademy.com/main/userpage/code/userProblemBoxDetail.do?probBoxId=AV5Po0AqAPwDFAUq&leftPage=1&curPage=userpage&userId=SWEAC#
* 답: https://developer-pi.tistory.com/49

# 등산로 조성
* https://seungahyoo.tistory.com/64
