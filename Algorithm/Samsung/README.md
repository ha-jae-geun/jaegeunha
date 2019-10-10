# 원자소멸
* https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRFInKex8DFAUo
* 답: https://developer-pi.tistory.com/27?category=824991

# 무선충전
```java
import java.util.Scanner;
 
class BC{
    int x, y, c, p;
    BC(int x, int y, int c, int p){
        this.x=x; this.y=y; this.c=c; this.p=p;
    }
}
 
public class Solution { 
    static int[][] map;
    static int[] dx= {0, 0, 1, 0, -1};
    static int[] dy= {0, -1, 0, 1, 0};
    static BC[] bc;
    static int A;
 
    public static int solve(int ax, int ay, int bx, int by) {
        int ans=0;
        int[] onA=new int[A]; int[] onB=new int[A];
         
        for(int i=0; i<A; i++) {
            if(Math.abs(ax-bc[i].x)+Math.abs(ay-bc[i].y)<=bc[i].c)
                onA[i]=1;
            if(Math.abs(bx-bc[i].x)+Math.abs(by-bc[i].y)<=bc[i].c)
                onB[i]=1;
        }
 
        for(int i=0; i<A; i++) {
            for(int j=0; j<A; j++) {
                int tmp=0;
                if(i==j) {
                    if(onA[i]==1||onB[j]==1) tmp=bc[i].p;
                } else {
                    if(onA[i]==1) tmp+=bc[i].p;
                    if(onB[j]==1) tmp+=bc[j].p;
                }
                ans= ans > tmp ? ans : tmp;
            }
        }
        return ans;
    }
 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int M=sc.nextInt(); A=sc.nextInt();
            int[] a=new int[M]; int[] b=new int[M];
            bc=new BC[A];
            for(int i=0; i<M; i++) a[i]=sc.nextInt();
            for(int i=0; i<M; i++) b[i]=sc.nextInt();
            for(int i=0; i<A; i++) 
                bc[i]=new BC(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
 
            int ax=1; int ay=1;
            int bx=10; int by=10;
            int ans=solve(ax, ay, bx, by);
            for(int i=0; i<M; i++) {
                ax+=dx[a[i]]; ay+=dy[a[i]];
                bx+=dx[b[i]]; by+=dy[b[i]];
                ans += solve(ax, ay, bx ,by);
            }
            System.out.println("#"+tc+" "+ans);
        }
    }
}
```

# 탈주범 잡기
```java
import java.util.*;
 
public class Solution{
    static int[][] Pipe = {
            {0,0,0,0},
            {1,1,1,1},
            {1,0,1,0},
            {0,1,0,1},
            {1,1,0,0},
            {0,1,1,0},
            {0,0,1,1},
            {1,0,0,1}
    };
    static int T,N,M,R,C,L,ans;
    static int[][] A;
    static boolean[][] V;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            ans=0;
            N = sc.nextInt();
            M = sc.nextInt();
            R = sc.nextInt()+1;
            C = sc.nextInt()+1;
            L = sc.nextInt();
            A = new int[N+1][M+1];
            V = new boolean[N+1][M+1];
            for (int i = 1; i <=N; i++) {
                for (int j = 1; j <= M; j++) {
                    A[i][j] = sc.nextInt();
                }
            }
            V[R][C] = true;
            dfs(1,R,C,0);
             
            for (int i = 1; i <=N; i++) {
                for (int j = 1; j <= M; j++) {
                    if(V[i][j]) ans++;
                }
            }
             
            System.out.println("#"+tc+" "+ans);
        }
         
    }
     
    static void dfs(int dpt, int r, int c, int dir) {
        //깊이 : 시간
        int nr=0,nc=0;
        if(dpt >= L) {
            //갈수있는 곳 최대개수구하기 (V가 true인거)
         
            return;
        }else {
            for (int i = 0; i < 4; i++) {
                nr = r+dr[i]; nc = c+dc[i];
                if(nr<1||nr>N||nc<1||nc>M ) continue; //범위,V 체크
                if((i+2)%4 == dir && dpt !=1) continue;
                if(Pipe[A[r][c]][i] == 1 && Pipe[A[nr][nc]][(i+2)%4]==1) {
                     
                    V[nr][nc] = true;
                     
                    dfs(dpt+1, nr,nc, i);
                    //V[nr][nc] = false;
                     
                }
                 
                 
            }
        }
         
         
         
    }
     
     

```

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
