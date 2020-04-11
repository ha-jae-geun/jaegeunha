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
