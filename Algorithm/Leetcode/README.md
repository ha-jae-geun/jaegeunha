# 문자열 내림차순으로 배치하기 (java)
```java
reverseStr 메소드는 String형 변수 str을 매개변수로 입력받습니다. 
str에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 String을 리턴해주세요. 
str는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다. 
예를들어 str이 “Zbcdefg”면 “gfedcbZ”을 리턴하면 됩니다.
```

```java
import java.util.Arrays;
import java.util.Collections;

public class ReverseStr {
    public String reverseStr(String str){
        String[] array = str.split("");
        Arrays.sort(array,  Collections.reverseOrder());

        return String.join("", array);
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        ReverseStr rs = new ReverseStr();
        System.out.println( rs.reverseStr("Zbcdefg") );
    }
}
```

```java
import java.util.Arrays;
import java.util.Collections;

public class ReverseStr {
  public String reverseStr(String str){
    String[] array = str.split("");
    Arrays.sort(array);
    Collections.reverse(Arrays.asList(array));
    return  String.join("",array);
  }

// 아래는 테스트로 출력해 보기 위한 코드입니다.
  public static void main(String[] args) {
    ReverseStr rs = new ReverseStr();
    System.out.println( rs.reverseStr("Zbcdefg") );
  }
```

```java
1. Collections.sort(temp, Collections.reverseOrder());
2. 스트링 배열을 스트링으로: String.join("", array);
3. Collections.reverse(Arrays.asList(array));
```

## String형 뒤집기
```java
 public static String reverseString(String s){
        return (new StringBuffer(s)).reverse().toString();
    }
```


# 나누어 떨어지는 숫자 배열
```java
divisible 메소드는 int형 배열 array와 int divisor를 매개변수로 받습니다. 
array의 각 element 중 divisor로 나누어 떨어지는 값만 포함하는 새로운 배열을 만들어서 반환하도록 divisible에 코드를 작성해 보세요.
예를들어 array가 {5, 9, 7, 10}이고 divisor가 5이면 {5, 10}을 리턴해야 합니다.
```

```java
import java.util.Arrays;
import java.util.ArrayList;

class Divisible {
    public int[] divisible(int[] array, int divisor) {
      ArrayList<Integer> divArray = new ArrayList<Integer>();
      for(int i : array){
          if(i % divisor == 0){
          divArray.add(i);
        }
      }

      int[] ret = new int[divArray.size()];
      for(int i=0; i<ret.length; i++){
        ret[i] = divArray.get(i).intValue();      
      }

      return ret;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
      Divisible div = new Divisible();
      int[] array = {5, 9, 7, 10};
      System.out.println( Arrays.toString( div.divisible(array, 5) ));
    }
}
```

```java
1. ArrayList 값 가져오기 divArray.get(i).intValue();
```

# 가운데 글자 가져오기
```java
getMiddle메소드는 하나의 단어를 입력 받습니다.
단어를 입력 받아서 가운데 글자를 반환하도록 getMiddle메소드를 만들어 보세요. 단어의 길이가 짝수일경우 가운데 두글자를 반환하면 됩니다.
예를들어 입력받은 단어가 power이라면 w를 반환하면 되고, 입력받은 단어가 test라면 es를 반환하면 됩니다.

```java
class StringExercise{
    String getMiddle(String word){
      int length = word.length();
      int index = length / 2;
      return (length%2==0) ? word.substring(index-1, index+1) : word.substring(index, index+1);
    }
    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void  main(String[] args){
      StringExercise se = new StringExercise();
      System.out.println(se.getMiddle("power"));
  }
}
```
## 팁
```java
1. substring(앞, 뒤) 는 뒤에 있는 숫자의 위치를 포함하지 않는다.
```

# 최대값과 최소값
```java
getMinMaxString 메소드는 String형 변수 str을 매개변수로 입력받습니다. 
str에는 공백으로 구분된 숫자들이 저장되어 있습니다. 
str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 “(최소값) (최대값)”형태의 String을 반환하는 메소드를 완성하세요. 
예를들어 str이 “1 2 3 4”라면 “1 4”를 리턴하고, “-1 -2 -3 -4”라면 “-4 -1”을 리턴하면 됩니다.
```

```java
import java.util.Arrays;

public class GetMinMaxString2 {
	public String getMinMaxString(String str) {
		String[] array = str.split(" ");
		int[] arrayInt = new int[array.length];

		for (int i = 0; i < arrayInt.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]); // 배열의 각 요소를 정수로 변경
		}

		Arrays.sort(arrayInt); // 최소 O(N LogN)의 시간복잡도
		String result = arrayInt[0] + " " + arrayInt[arrayInt.length - 1];

		return result;

	}

	public static void main(String[] args) {
		String str = "1 2 3 4";
		GetMinMaxString2 minMax = new GetMinMaxString2();
		System.out.println("최소값과 최대값은?" + minMax.getMinMaxString(str));
	}
}
```

## 팁
```java
1. 문자열 + 숫자: 문자열
String result = arrayInt[0] + " " + arrayInt[arrayInt.length - 1];
```


# Longest Substring
```java
"abcabcbb" 의 부분 문자열은 "abc" 이며, 그 길이는 3이다.
"bbbbb" 의 부분 문자열은 "b" 이며, 그 길이는 1이다.
"pwwkew" 의 부분 문자열은 "wke" 이며, 그 길이는 3이다. "pwke” 는 부분문자열이 아니다.
```

```java
public int lengthOfLongestSubstring(String s) {
    int i = 0, j = 0, max = 0;
    Set<Character> set = new HashSet<>();
    
    while (j < s.length()) {
        if (!set.contains(s.charAt(j))) {
            set.add(s.charAt(j++));
            max = Math.max(max, set.size());
        } else {
            set.remove(s.charAt(i++));
        }
    }
    
    return max;
}
```
