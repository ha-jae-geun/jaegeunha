# 큐(BFS)
* push할 때 방문 처리
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

## 기본형태
```java
void bfs(int start, vector<int> graph[], bool check[]){
	queue<int> q;

	q.push(start);
	check[start] = true;

	while(!q.empty()){
		int tmp = q.front();
		q.pop();
		printf("%d ",tmp);
		for(int i=0; i<graph[tmp].size(); i++){

			// 방문하지 않았다면
			if(check[graph[tmp][i]] == false){
				// 큐에 넣어주고 방문했음을 표시한다.
				q.push(graph[tmp][i]);
				check[graph[tmp][i]] = true;
			}
		}
	}

}
```

# 종이의 개수
```JAVA
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
class Pairs {
    int x;
    int y;
 
    Pairs(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
 
public class Main {
    static int[][] arr;
    static int[][] check;
    static int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };
    static int[] dy = { -1, 1, 0, 0, -1, 1, 1, -1 };
 
 
    private static void bfs(int x, int y, int count, int w, int h) {
        Queue<Pairs> queue = new LinkedList<Pairs>();
        queue.add(new Pairs(x, y));
        check[x][y] = count;
        while (!queue.isEmpty()) {
            Pairs p = queue.remove();
            x = p.x;
            y = p.y;
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                    if (arr[nx][ny] == 1 && check[nx][ny] == 0)
                        bfs(nx, ny, count, w, h);
                }
            }
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();
 
            if (w == 0 && h == 0)
                break;
 
            arr = new int[h][w];
 
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
 
            int count = 0;
            check = new int[h][w];
 
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && check[i][j] == 0)
                        // dfs(i, j, ++count, w, h);
                        bfs(i, j, ++count, w, h);
                }
            }
            System.out.println(count);
        }
 
        sc.close();
    }
}
```

# 영역 구하기
```JAVA
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
class rect {
    int y;
    int x;
    
    rect(int y, int x){
        this.y = y;
        this.x = x;
     }
}
 
public class Main {
    
    static int[][] map;
    static boolean[][] visited;
    static int M,N,K;
    static int count;
    static int[] sum;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M];
        sum = new int[N*M];
        
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[x][y] = 1;
                }
            }
        }
        
        
        int c = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0 && !visited[i][j]){
                    bfs(i,j, c);
                    c++;
                }
            }
        }
        
        System.out.println(c);
        Arrays.sort(sum, 0, c);
        for (int i = 0; i < c; i++) {
            System.out.print(sum[i] + " ");
        }
    }
    
    static public void bfs(int y, int x, int c) {
        Queue<rect> q = new LinkedList<>();
        
        rect r1 = new rect(y, x);
        
        q.add(r1);
        
        while(!q.isEmpty()){
            rect r2 = q.poll();
            visited[r2.y][r2.x] = true;
            sum[c] += 1;
            
            for (int i = 0; i < 4; i++) {
                int ny = r2.y + dy[i];
                int nx = r2.x + dx[i];
                
                if(ny >=0 && nx >= 0 && ny < N && nx < M){
                    if(map[ny][nx] == 0 && !visited[ny][nx]){
                        bfs(ny, nx, c);
                    }
                }
            }
        }
        
    }
}
```

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


# 메모리 초과 전
```java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
class Pairs {
    int x;
    int y;
 
    Pairs(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
 
public class Main {
    static int[][] arr;
    static int[][] check;
    static int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };
    static int[] dy = { -1, 1, 0, 0, -1, 1, 1, -1 };
 
 
    private static void bfs(int x, int y, int count, int w, int h) {
        Queue<Pairs> queue = new LinkedList<Pairs>();
        queue.add(new Pairs(x, y));
        
        while (!queue.isEmpty()) {
            check[x][y] = count;
            Pairs p = queue.remove();
            x = p.x;
            y = p.y;
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                    if (arr[nx][ny] == 1 && check[nx][ny] == 0)
                        queue.add(new Pairs(nx, ny));
                        check[x][y] = count;
                        //bfs(nx, ny, count, w, h);
                }
            }
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();
 
            if (w == 0 && h == 0)
                break;
 
            arr = new int[h][w];
 
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
 
            int count = 0;
            check = new int[h][w];
 
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && check[i][j] == 0)
                        // dfs(i, j, ++count, w, h);
                        bfs(i, j, ++count, w, h);
                }
            }
            System.out.println(count);
        }
 
        sc.close();
    }
}

```

## 초과 수정
```java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
class Pairs {
    int x;
    int y;
 
    Pairs(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
 
public class Main {
    static int[][] arr;
    static int[][] check;
    static int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };
    static int[] dy = { -1, 1, 0, 0, -1, 1, 1, -1 };
 
 
    private static void bfs(int x, int y, int count, int w, int h) {
        Queue<Pairs> queue = new LinkedList<Pairs>();
        queue.add(new Pairs(x, y));
        check[x][y] = count;
        while (!queue.isEmpty()) {
            Pairs p = queue.remove();
            x = p.x;
            y = p.y;
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                    if (arr[nx][ny] == 1 && check[nx][ny] == 0)
                        bfs(nx, ny, count, w, h);
                }
            }
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();
 
            if (w == 0 && h == 0)
                break;
 
            arr = new int[h][w];
 
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
 
            int count = 0;
            check = new int[h][w];
 
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && check[i][j] == 0)
                        // dfs(i, j, ++count, w, h);
                        bfs(i, j, ++count, w, h);
                }
            }
            System.out.println(count);
        }
 
        sc.close();
    }
}
```
