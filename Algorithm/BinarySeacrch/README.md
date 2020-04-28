# 입국심사
* [입국심사]('https://webfirewood.tistory.com/m/108')
```java
   public long solution(int n, int[] times) {
    	long answer = 0;
        long start = 0;
        long end = Long.MAX_VALUE / 2;
        
        while (start <= end) {
        	long mid = (start + end) / 2;
        	long people = n;
        	for (int time : times) {
    			people -= (long) mid / time;
                if (people < 0) break;
    		}
        	if (people > 0) {
        		start = mid + 1;
        	} else {
        		end = mid - 1;
        		answer = mid;
        	}
        }
        return answer;
    }
```

# 징검다리 건너기
```java
package Test;

public class Rock {
	public static int solution(int[] stones, int k) {

		return binerySearch(stones, k);
	}

	static int binerySearch(int[] stones, int n) {
		long left = 1, 
		right = 200000001;

		while (left <= right) {
			int mid = (int) ((left + right) / 2);
			if (calc(mid, stones, n))
				left = mid + 1;
			else
				right = mid - 1;
		}
		return (int) left;
	}

	static boolean calc(int n, int[] stones, int k) {
		int now = 0;
		for (int i = 0; i < stones.length; i++) {
			if (stones[i] - n <= 0)
				now++;
			else
				now = 0;
			if (now >= k)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int k = 3;
		System.out.println(solution(stones, k));
	}

}

```
