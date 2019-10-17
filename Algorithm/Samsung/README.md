# 원자소멸
* https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRFInKex8DFAUo
* 답: https://developer-pi.tistory.com/27?category=824991


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

# 벽돌깨기
```java
import java.util.*;
public class Solution{
    static int[][]nmap;
    static int N,W,H,ans;
    static int[]dx={-1,1,0,0};
    static int[]dy={0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            N=sc.nextInt();
            W=sc.nextInt();
            H=sc.nextInt();
            ans=H*W;
            int[][]map=new int[H][W];
             
            for(int h=0;h<H;h++){
                for(int w=0;w<W;w++){
                    map[h][w]=sc.nextInt();
                }
            }
            
            dfs(0,map);
            System.out.println("#"+t+" "+ans);
        }
    }
    static void dfs(int cnt,int[][]map){
        if(cnt==N){
            int block=0;
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    if(map[i][j]>0){
                        block++;
                    }
                }
            }
            ans=Math.min(ans, block);
            return;
        }
        for(int w=0;w<W;w++){
            int flag=0;
            for(int h=0;h<H;h++){
                if(map[h][w]>0){
                    flag=1;
                    nmap=new int[H][W];
                    copy(map);
                    boom(h,w,nmap[h][w]);
                    trans();
                    dfs(cnt+1,nmap);
                    break;
                }
            }
            if(flag==0)dfs(cnt+1,map);
        }
    }
    static void trans(){
        for(int w=0;w<W;w++){
            LinkedList<Integer>l=new LinkedList<>();
            for(int h=0;h<H;h++){
                if(nmap[h][w]>0){
                    l.add(nmap[h][w]);
                    nmap[h][w]=0;
                }
            }
            for(int h=0;h<l.size();h++){
                nmap[H-h-1][w]=l.get(l.size()-1-h);
            }
        }
    }
    static void boom(int x,int y,int dis){
        nmap[x][y]=0;
        for(int d=0;d<4;d++){
            int nx=x;
            int ny=y;
            for(int c=0;c<dis-1;c++){
                nx+=dx[d];
                ny+=dy[d];
                if(0<=nx&&nx<H && 0<=ny&&ny<W){
                    if(nmap[nx][ny]>=2){
                        boom(nx,ny,nmap[nx][ny]);
                    }
                    nmap[nx][ny]=0;
                }
            }
        }
    }
    static void copy(int[][]map){
        for(int h=0;h<H;h++){
            for(int w=0;w<W;w++){
                nmap[h][w]=map[h][w];
            }
        }
    }
}
```

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
    //12시부터 열렸는지 
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
    //dy 거꾸로
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
* 테스트 케이스 for문 안에서 static ans -1 초기화
 * ans 최대값 구하기
* int[] visit 생성; 위치 상관 없음: O
* 메인 
 * dfs: O
* dfs 메소드
 * 값 변환 전 visit true: O
 * perm: O
 * 값 변환 후 visit false: O


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
* 테스트 케이스 for문 안에서 static ans -1 초기화
 * ans 최대값 구하기
* int[] visit 생성; 위치 상관 없음: O
* 메인 
 * dfs: O
* dfs 메소드
 * 값 변환 전 visit true: O
 * perm: O
 * 값 변환 후 visit false: O



# 디저트 카페
* 답: https://developer-pi.tistory.com/35?category=824991

```java
import java.util.Scanner;
 
public class Solution {
    static int N, ans;
    static int[][] map;
     
    public static void calc(int x, int y, int a, int b) {
        int cnt=0;
        //a,b마다 visit 달리 체크
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
* 테스트 케이스 for문 안에서 static ans -1 초기화
 * ans 최대값 구하기
* int[] visit 생성; 위치 상관 없음: O
* 메인 
 * dfs: O
* dfs 메소드
 * 값 변환 전 visit true: O
 * perm: O
 * 값 변환 후 visit false: O


# 등산로 조성
* https://seungahyoo.tistory.com/64
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    private static int[][] map;
    private static boolean[][] visit;
    private static int N;
    private static int K;
    private static ArrayList<pair> top;
    private static int bottom;
    static int[] dy = {-1,0,1,0 };
    //dy 거꾸로
    static int[] dx = { 0,1,0,-1 };
    static int ans;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            ans=-1;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken()); // 최대 K만큼 한 번 지형을 깎는다
 
            map = new int[N][N];
            top = new ArrayList<>();
            int max = -1;
            bottom = 21;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (max < map[i][j]) {
                        max = map[i][j];
                        top.clear();
                        top.add(new pair(i, j));
                    } else if (max == map[i][j]) {
                        top.add(new pair(i, j));
                    }
                    bottom = bottom > map[i][j] ? map[i][j] : bottom;
                }
            } ////// input
 			//DFS(0,0)에서 depth 역할; 0으로 계속 초기화 해줘야 함
  			
                
            for (pair p : top) {
              //top마다 visit 달리 체크
                visit = new boolean[N][N];
                dfs(p.y, p.x, 1, false);
 
            }
 
            System.out.println("#" + tc + " " + ans);
        } // end of tc
    }// end of main
 

 
    private static void dfs(int y, int x, int len, boolean cut) {
        // cut이 true 면 공사를 했다.
 
        
        
        //swap 혹은 visit 관리; swap은 2개
        visit[y][x] = true;
        
        //depth 처리; perm; 위치 다양
        ans = ans < len ? len : ans;
 
        
 
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            //
            if (ny < 0 || ny > N - 1 || nx < 0 || nx > N - 1 || visit[ny][nx])
                continue;
            if (map[ny][nx] < map[y][x]) {
                dfs(ny, nx, len + 1, cut);
            } else { // 같거나 높으면
                if (!cut) { // cut이 false면 아직 공사를 안한 상태
                    for (int k = 1; k <= K; k++) {
                        int tmp = map[ny][nx];
                        map[ny][nx] -= k;
                        if (map[ny][nx] < map[y][x])
                            dfs(ny, nx, len + 1, true);
                        map[ny][nx] = tmp;
                    }
                }
            }
            //swap 혹은 visit 관리
            visit[ny][nx] = false;
        }
 
    }
 
    static class pair {
        int y;
        int x;
 
        public pair(int y, int x) {
            super();
            this.y = y;
            this.x = x;
        }
 
    }
}

```
* 테스트 케이스 for문 안에서 static ans -1 초기화
 * ans 최대값 구하기
* int[] visit 생성; 위치 상관 없음: O
* 메인 
 * dfs: O
* dfs 메소드
 * 값 변환 전 visit true: O
 * perm: O
 * 값 변환 후 visit false: O





# 시험감독 수
```java

```
* "LONG"으로 만드는 것이 중요합니다. int가 가진 수의 범위를 초과할 수 있으므로, 조심해야합니다. 두번째 요인은 밑에 정답코드를 보고 확인 해보시죠.

* [출처](https://sundries-in-myidea.tistory.com/6 [DesiProm])


# 보물상자
* 문제: https://swexpertacademy.com/main/userpage/code/userProblemBoxDetail.do?probBoxId=AV5Po0AqAPwDFAUq&leftPage=1&curPage=userpage&userId=SWEAC#
* 답: https://developer-pi.tistory.com/49

```java
package swea_p;
 
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class Swea5658_R {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for(int tc=1; tc<=TC; tc++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            StringBuilder sb= new StringBuilder();
            String s= sc.next();
            int M = N/4;
            sb.append(s);
            sb.append(s.substring(0,M));
            Set<String> set = new HashSet<>();
            for(int i=0; i<s.length(); i++) {
                set.add(sb.substring(i,i+M));
            }
            int[] numSet= new int[set.size()];
            int index=0;
            for(String temp : set) {
                for(int i=0; i<temp.length(); i++) {
                    char c = temp.charAt(i);
                    if(c>='A') {
                        numSet[index]=numSet[index]*16+(c-'A'+10);    
                    }else {
                        numSet[index]=numSet[index]*16+(c-'0');
                    }
                }
                index++;
            }
            Arrays.sort(numSet);
            System.out.println("#"+tc+" "+numSet[numSet.length-K]);
        }
    }
}

```


