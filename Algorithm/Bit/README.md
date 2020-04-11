# 비트
## xor
* 리트코드 Hamming distance
```java
class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        int cnt = 0;
        
        for(int i=0; i<32; i++){
            int b = xor>>i & 1;
            cnt = cnt+b;
        }
        return cnt;
        
    }
}
```
