# DFS
```java
1. 깊이 우선 탐색(DFS, Depth-First Search)
루트 노드(혹은 다른 임의의 노드)에서 시작해서 다음 분기(branch)로 넘어가기 전에 해당 분기를 완벽하게 탐색하는 방법

즉, 넓게(wide) 탐색하기 전에 깊게(deep) 탐색하는 것이다.
사용하는 경우: 모든 노드를 방문 하고자 하는 경우에 이 방법을 선택한다.
깊이 우선 탐색이 너비 우선 탐색보다 좀 더 간단하다.

2. 너비 우선 탐색(BFS, Breadth-First Search)
루트 노드(혹은 다른 임의의 노드)에서 시작해서 인접한 노드를 먼저 탐색하는 방법

즉, 깊게(deep) 탐색하기 전에 넓게(wide) 탐색하는 것이다.
사용하는 경우: 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 이 방법을 선택한다.
Ex) 지구상에 존재하는 모든 친구 관계를 그래프로 표현한 후 Ash와 Vanessa 사이에 존재하는 경로를 찾는 경우
깊이 우선 탐색의 경우 - 모든 친구 관계를 다 살펴봐야 할지도 모른다.
너비 우선 탐색의 경우 - Ash와 가까운 관계부터 탐색
```


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

# 유기농 배추
```JAVA
import java.util.*;





public class Main {

	static int T;

	static int M;

	static int N;

	static int K;

	static int[][] map;

	static boolean[][] visit;

	static int[] dx = {0,1,0,-1};

	static int[] dy = {1,0,-1,0};





	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		

		T = sc.nextInt();

		for(int i=0;i<T;i++){

			int cnt =0;

			M = sc.nextInt();

			N = sc.nextInt();

			K = sc.nextInt();

			map = new int[N][M];

			visit = new boolean[N][M];

			

			for(int j=0;j<K;j++){

				int x = sc.nextInt();

				int y = sc.nextInt();

				map[y][x] = 1;

			}

			for(int j=0;j<N;j++){

				for(int k=0;k<M;k++){

					if(map[j][k]==1 && visit[j][k]==false){

						

						dfs(j,k);

						cnt++;	

					}

				}

			}

			

			System.out.println(cnt);

			

			

		}

}

		

		

	

	public static void dfs(int yy, int xx){

		

		visit[yy][xx]=true;

			for(int i=0;i<4;i++){

				

				int new_y = yy + dy[i];

				int new_x = xx + dx[i];

				if(new_y>=0 && new_x>=0 && new_y<N && new_x<M){

				if(map[new_y][new_x]==1 && visit[new_y][new_x]==false){

					dfs(new_y,new_x);

				}

				

				

			}

		}

	}



	

}
```

# 영역 구하기
```JAVA
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    
    static char map[][];
    static boolean visited[][];
    static int n;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    
    static int count = 0;
    static int count2 = 0;
    
    public static void dfs(int x, int y){
        visited[x][y] = true;
        
        char c = map[x][y];
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx>=0 && nx < n && ny>=0 && ny<n ){
                if(map[nx][ny] == c && !visited[nx][ny]){
                    dfs(nx,ny);
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        map = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        
        visited = new boolean[n][n];
        
        //정상
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j] == false){
                    count++;
                    dfs(i,j);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 'G')
                    map[i][j] = 'R';
            }
        }
        
        visited = new boolean[n][n];
        
        //적록 색약
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j] == false){
                    count2++;
                    dfs(i,j);
                }
            }
        }
        
        System.out.println(count + " " + count2);
    }
}
``
