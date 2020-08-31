# toBinaryString
```java
class Solution {
  
  
  public String[] solution(int n, int[] arr1, int[] arr2) {
      
      String [] answer = new String[n];
      
      for(int i=0; i<n; i++) {          
            String temp = Integer.toBinaryString(arr1[i] | arr2[i]);  
            temp = String.format("%" + n + "s", temp);
            temp = temp.replaceAll("1", "#");
            temp = temp.replaceAll("0", " ");
            answer[i] = temp;
        }
      
      return answer;
      
  }
  
}
```


<hr/>

# 문자열
# String
## 문자열 배열 생성 방법
```java
String [][] ticket =  {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
```
1. "" 를 써줘야 함
2. {} 안에 써줌


## compareTo
```java
String1.compareTo(String2)
> String1 과 String2 가 같으면 (결과 == 0)

> String1 이 String2 보다 크면 (결과 > 0)

> String1 이 String2 보다 작으면 (결과 < 0)

 
예제)
> ("2015-05-02").compareTo("2015-05-02") == 0 은 true

> ("2015-05-04").compareTo("2015-05-02") > 0 은 true

> ("2015-04-02").compareTo("2015-05-02") < 0 은 true

> ("abcdef").compareTo("accdef") < 0 은 true

```

## contains 메소드
* contains 메소드는 문자열 안에 특정한 문자열이 포함 되어있는지 확인 할때, 사용한다.
```java
String s = "I have a book";  

s.contains("book");
//이라고 할때, 위 코드는 true를 반환한다.
```

## startWith 메소드
* startWith 메소드는 문자열이 특정 문자열로 시작하는지 확인할때, 사용한다.

```java
String s = "abcde";

이라고 할때, 위 코드는 true를 반환 한다.
s.startWith("abc");
```


## 슬라이싱
```java
StringBuilder sb= new StringBuilder();
            String s= sc.next();
            int M = N/4;
            sb.append(s);
            sb.append(s.substring(0,M));
            Set<String> set = new HashSet<>();
            for(int i=0; i<s.length(); i++) {
                set.add(sb.substring(i,i+M));
            }
```

### 배열 슬라이싱
```java
```java
Arrays.copyOf(원본배열, 복사할 길이);

Arrays.copyOfRange(원본 배열, 복사할 시작인덱스, 복사할 끝인덱스) 인덱스는 0부터 시작하는것 기준
```
```

## charAt
```java
public static int getStrike(String chk, String num) {
		int cnt = 0;
		for(int i = 0; i < 3; i++)
			cnt += chk.charAt(i) == num.charAt(i) ? 1 : 0;
		
		return cnt;
	}
```

## valueOf
```java
for(int i = 0; i < baseball.length && cnt < baseball.length; i++) {
            	int strike = getStrike(chNum, String.valueOf(baseball[i][0]));
            	int ball = getBall(chNum, String.valueOf(baseball[i][0])); 
        		
            	if(strike == baseball[i][1] && ball == baseball[i][2])
            		cnt++;
            }
```

## valueOf
```java
 String.valueOf()

    - 파라미터가 null 이면 문자열 null을 만들어서 담는다.

- Casting

    - 대상이 null 이면 NullPointerException 발생.

    - Object 값이 String 이 아니면  ClassCastException 발생.
    
- "".toString()

    - 당연하게 .  으로 사용하는 만큼 대상 값이 null 이면 NullPointerException 발생.

    - Object 에 담긴 값이 String 이 아니라도 출력.

차이점은 null값이 따른 NullPointException의 발생 유무.

 
- 예제
	String str = null;

	System.out.println((String) str);           // 'null' text return

	System.out.println(String.valueOf(str));    // 'null' text return

	System.out.println(str.toString());         // NullPointException
```

## String을 char 배열로 변환
```java
public boolean isValid(String s) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}
```

## String형 뒤집기
```java
 public static String reverseString(String s){
        return (new StringBuffer(s)).reverse().toString();
    }
```

## 스트링 배열을 스트링으로
```java
String.join("", array);
```

## substring
```java
1. substring(앞, 뒤) 는 뒤에 있는 숫자의 위치를 포함하지 않는다.
```

## ArrayList의 숫자 + 문자
```java
1. 문자열 + 숫자: 문자열
String result = arrayInt[0] + " " + arrayInt[arrayInt.length - 1];
```

## charat
```java
Set<Character> set = new HashSet<>();
if (!set.contains(s.charAt(j))) {
      set.add(s.charAt(j++));
```

## StringBuffer
### String
```java
 public static String reverseString(String s){
        return (new StringBuffer(s)).reverse().toString();
    }
```


### 수박 생성
```java
public class WaterMelon {
    public String watermelon(int n){
        StringBuffer sf = new StringBuffer();
        for (int i=1; i<=n; ++i) {
            sf.append(i%2==1?"수":"박");
        }
        return sf.toString();
    }

    // 실행을 위한 테스트코드입니다.
    public static void  main(String[] args){
        WaterMelon wm = new WaterMelon();
        System.out.println("n이 3인 경우: " + wm.watermelon(3));
        System.out.println("n이 4인 경우: " + wm.watermelon(4));
    }
}
1. 3항연산자
2. .toString()

```


<hr/>
