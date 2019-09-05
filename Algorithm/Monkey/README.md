# 문자 역으로
* reverseStr 메소드는 String형 변수 str을 매개변수로 입력받습니다. str에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 String을 리턴해주세요. str는 영문 대소문자로만 구성되어 있으며,  
대문자는 소문자보다 작은 것으로 간주합니다. 예를들어 str이 “Zbcdefg”면 “gfedcbZ”을 리턴하면 됩니다.

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
}
```

## String.join
```java
join("추가할 문자", "대상 list")

join("추가할 문자", "대상 Array")

```
[투덜이의 리얼 블로그](https://tourspace.tistory.com/8)
