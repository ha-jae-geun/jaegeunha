# 자료형
## long
* int로 하면 속도 느려짐
```java
class Solution {
    public long solution(int N) {
        long [] len = new long[N];
        len[0] = 4;
        len[1] = 6;
        
        if(N == 1)
            return 4;    
            
        if(N == 2)
            return 6;
        
        for(int i=2;i<N; i++ ){
            len[i] = len[i-2] + len[i-1];
        }
        
        return len[N-1]; 
        
    
        
    }
}
```

## 아스키코드
### 크기 비교
```java
str2[j] >= 'a'&&str2[j] <= 'z'
```

## char형을 string으로
```java
	static HashMap<String, Integer> hashMap = new HashMap<>();
	
	public static void main(String[] args) {
		makeDic();
		System.out.println(hashMap.get("A"));
	}
	
	public static void makeDic() {
		char a = 'A';
		
		for(int i=0; i<26; i++) {
			hashMap.put(Character.toString(a), i+1);
			a = (char) (a + 1);
		}
	}
```

## char형을 int형으로
```java
number.charAt(i) - '0';
```

## int형을 String형으로
```java
String.valueOf(c);
```

## pow
* pow하면 double형 됨
```java
 int형 변환: c = c + (b[i]*(int)Math.pow(10, i));
```
