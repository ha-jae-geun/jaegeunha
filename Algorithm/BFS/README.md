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
