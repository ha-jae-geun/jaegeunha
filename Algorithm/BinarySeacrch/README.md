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
