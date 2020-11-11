# [스트림 종류](https://postitforhooney.tistory.com/entry/Java-Java-Stream%EC%9D%98-%EA%B0%9C%EB%85%90%EA%B3%BC-%EC%A2%85%EB%A5%98-%EA%B7%B8%EB%A6%AC%EA%B3%A0-%EC%98%88%EC%A0%9C%EB%A5%BC-%ED%86%B5%ED%95%9C-%EC%B0%A8%EC%9D%B4%EC%A0%90-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0)

# [Byte Stream](https://story.stevenlab.io/96)
```java
Byte Stream 

Byte Stream부터 알아보자. Byte Stream은 데이터를 Byte 단위로 주고받는 것을 말한다. 
대표적인 Byte Stream은 InputStream과 OutputStream이라고 배웠다. 
그렇다면 InputStream과 OutputStream을 통과하는 단위는 당연히 Byte이다. 
8bit의 이진 비트를 묶으면 Byte가 되는 바로 그 Byte이다. 원래 데이터는 모두 Byte이다. 
알고 보면 그림도 Byte들로 이루어져 있고, 텍스트도 Byte로 이루어져 있다. 
그리고 zip이나 jar같은 압축 파일도 일단은 Byte로 되어 있다. 
이 Byte들이 적절하게 변환되면 의미 있는 데이터가 되는 것이다. 
Byte Stream의 경우에는 원시 Byte를 그대로 주고 받겠다는 의미를 담고 있다.

 

그런데 Character Stream은 이러한 Byte들을 2Byte씩 묶어서 사용할 수도 있고, 
1Byte 단위로도 사용할 수 있다. 그것은 문자 인코딩에 따라서 다르게 사용된다. 
자바에서 사용하는 문자방식은 유니코드(Unicode) 방식이다. 그래서 Byte로 전송되어지는 것을 
Stream에서 재해석한 후 유니코드 문자로 변환하게 된다. 결과적으로 Byte를 Character로 가공을 
하는 것이며, 문자의 인코딩은 Character Stream에서 자동으로 해석하게 된다. 
PPT의 그림은 Stream이 문자를 인코딩하는 것을 보여주고 있다.



Byte Stream은 InputStream과 OutputStream 클래스를 상속하고 있으며, 
대부분 InputStream과 OutputStream이라는 단어로 끝난다. 이러한 Byte Stream의 종류는 다음과 같다.

 

Byte Stream들

- PrintStream

- InputStream, OutputStream

- ByteArrayInputStream, ByteArrayOutputStream

- FileInputStream, FileOutputStream

- FilterInputStream, FilterOutputStream

- ObjectInputStream, ObjectOutputStream

- PipedInputStream, PipedOutputStream

- BufferedInputStream, BufferedOutputStream

- DataInputStream, DataOutputStream


정말 많다. 그런데 한결같이 InputStream과 OutputStream이라는 단어를 달고 있다. 
이러한 Stream을 Byte Stream이라고 한다. 내부적으로 Byte 단위로 Stream 처리를 하는 것이다.

 

PrintStream에 OutputStream이란 단어가 붙지 않은 이유

PrintStream은 OutputStream밖에 없기 때문에 OutputStream이란 단어를 사용하지 않고 
단순히 Print 다음에 Stream을 붙여서 PrintStream이라고 한다.

```

# Character Stream  

```java
Character Stream은 Reader와 Writer를 달고 있다. 
모두 문자단위로 인코딩 처리를 하는 Stream들이다. Character Stream들은 다음과 같다.


Character Stream들

- PrintWriter

- Reader, Writer

- BufferedReader, BufferedWriter

- CharArrayReader, CharArrayWriter

- FilterReader, FilterWriter

- InputStreamReader, OutputStreamWriter

- FileReader, FileWriter

- PipedReader, PipedWriter

- StringReader, StringWriter

- ... 기타 등등

 
그 냥 한번 확인해보는 것이지 특별한 의미는 없다. 
위의 Stream들은 Character Stream이든 Byte Stream이든, 둘 다 모두 처음엔 Byte로 받아들이는 것은 마찬가지이다. 
그리고 해당 Stream이 알아서 처리를 해주는 것이다. 각각의 Stream의 역할은 가공하는 방법과 
장치가 다를 뿐 자료의 입출력을 도와주는 중간 매개체로서의 역할은 동일하다. 
각 장치에 맞는 Stream을 이용하는 것이 프로그래머가 하는 일이다. 
결론적으로 Stream은 원시 데이터를 프로그래머가 사용할 수 있는 데이터로 바꾸어 주는 역할을 한다.
```



