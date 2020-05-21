# 문자열 분리의 Stringtokenizer와 split
```java
StringTokenizer
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());

st.nextToken(); // A
st.nextToken(); // B
st.nextToken(); // C
st.nextToken(); // D
문자열을 잘라 쓰는건 똑같은 맥락이나, split은 정규식을 기반으로 자르는 로직이므로 내부가 복잡하다.
그에 반면 StringTokenizer의 경우 단순히 공백을 땡기는 것이므로
정규식 처리가 딱히 필요한게 아닌 경우 StringTokenizer가 효율적이다.
```

```java
문자열을 원하는 구분자(delimiter)를 사용하여 분리하고 싶을 때

StringTokenizer 와 String 메소드 split() 를 사용할 수 있습니다.

 

같지만 다른 두 가지 방법에 대해서 알아보도록 하겠습니다.

(예제에서는 구분자로 콤마(,) 를 사용하였습니다.)


public class StringDivideTest {
    public static void stringTokenizerTest(String str) {
        System.out.println("====== stringTokenizerTest() result ======");
        StringTokenizer tokenizer = new StringTokenizer(str, ",");
        for (int i = 0; tokenizer.hasMoreTokens(); i++) {
            System.out.println(i + "번째 : " + tokenizer.nextToken());
        }
    }
 
    public static void splitTest(String str) {
        System.out.println("====== splitTest() result ======");
        String split[] = str.split(",");
        for (int i = 0; i < split.lenght; i++) {
            System.out.println(i + "번째 : " + split[i]);
        }
    }
 
    public static void main(String[] args) {
        String str = "apple,banana,kiwi";
        stringTokenizerTest(str);
        System.out.println();
        splitTest(str);
    }
}
Colored by Color Scripter
cs
 

 

(1) 일반적인 상황 (데이터+구분자+데이터) 

=> 동일하게 동작합니다.

String str = "apple,banana,kiwi";

  

<결과>

======= stringTokenizerTest() result =======
0번째  : apple
1번째  : banana
2번째  : kiwi

 

======= splitTest() result =======
0번째  : apple
1번째  : banana
2번째  : kiwi 

 

 

(2) 구분자 사이에 데이터가 없는 경우(데이터+구분자+구분자+데이터) 

=> split 만 공백의 데이터를 반환합니다.

String str = "apple,banana,,kiwi";

 

<결과>

======= stringTokenizerTest() result =======
0번째  : apple
1번째  : banana
2번째  : kiwi

 

======= splitTest() result =======
0번째  : apple
1번째  : banana
2번째  :
3번째  : kiwi

 

 

(3) 문자열이 구분자로 끝나는 경우 (데이터+구분자)

=> 동일하게 마지막 데이터를 무시하는 방식으로 동작합니다.

마지막 데이터도 표현하고 싶은 경우 split 를 통해서(오버로딩된 다른 메소드) 가능합니다. 
String str = "apple,banana,kiwi,";

 

<결과>

======= stringTokenizerTest() result =======
0번째  : apple
1번째  : banana
2번째  : kiwi

 

======= splitTest() result =======
0번째  : apple
1번째  : banana
2번째  : kiwi

 

 

(4) 문자열이 구분자로 끝나는 경우 (데이터+구분자) - 마지막 데이터를 표현하고 싶을 경우

String str = "apple,banana,kiwi,";

String split[] = str.split(",", -1);

 

<결과>

======= stringTokenizerTest() result =======
0번째 : apple
1번째 : banana
2번째 : kiwi

 

======= splitTest() result =======
0번째  : apple
1번째  : banana
2번째  : kiwi
3번째  :

 

 

split 메소드는 인자로 regex(정규표현식) 사용하기 때문에

속도적인 측면에서는 StringTokenizer 가 더 성능을 좋다고 볼 수 있습니다.

하지만 예제와 같이 가변적인 요소가 많은 문자열이나 정확한 분리가 필요할 때에는 split 메소드를 사용하는 것이 유용합니다.

 

 
```
