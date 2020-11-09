# PrintWriter
```java
저는 아직까지 PrintWirter의 형제 격인, 
BufferedWriter과의 차이를 자세히는 모르겠으나, PrintWriter의 메서드들이BufferedWriter를 포함하고 있으며, 

생성자 역시 PrintWriter가 훨씬 다양하기 때문에, 굳이 데코레이터 패턴을 사용하지 않더라도, 
File클래스 객체나, OutputStream객체 등을 바로 인수로 입력받을 수 있는 장점이 있어, PrintWriter가 더 자주 쓰이는것 같습니다.


상당히 많은 생성자 오버로딩이 보입니다. 앞서 소개했던 PrintWriter의 장점 중 하나이구요. 

BufferedWriter는, 생성자의 인수로 Writer만을 갖는 반면,

PrintWriter는 File(String), OutputStream, Writer 등의 객체를 인수로 받아 더 간편하게 스트림을 연결할 수 있습니다.
```

# InputStream
- InputStreamReader에서 한 문자씩 읽어서 출력한다.
- InputStream/OutputStream은 1바이트씩 입력하고 출력하여 2바이트 이상인 한글의 경우 정상적으로 입출력이 일어나지 않았다.
- InputStreamReader 와 OutputStreamWriter는 문자(Character) 단위로 입출력을 하기 때문에 한글 처리도 문제가 없다.

```java
InputStreamReader는 바이트 단위로 읽어 들이는 InputStream을 통해 데이터를 
읽어 들여 문자 단위로 읽어 들이는 방식으로 변형한다는 의미이며,
OutputStreamWriter는 바이트 단위로 쓰는 OutputStream을 이용해서 문자 단위로 쓰는 것을 
바이트 단위로 쓰도록 변형한다는 것을 의미합니다.



읽어야 할 대상 -> InputStream -> InputStreamReader -> 메소드1, 메소드2, 메소드3 ...



위 흐름을 보면 InputStreamReader와 InputStream과의 관계를 쉽게 이해할 수 있을 것입니다.
읽어 들여야 할 대상을 InputStream에게 지정함으로써 바이트 단위로 읽어 들이게 하고,
InputStream을 다시 InputStreamReader에게 지정함으로써 문자 단위로 읽어 들일 수 있게 변경하는 것입니다.
이 경우 InputStreamReader에 있는 메소드를 이용해서 읽어 들이게 됩니다.


써야 할 대상 <- OutputStream <- OutputStreamWriter <- 메소드1, 메소드2, 메소드3 ...



위 흐름을 보면 OutputStreamWriter와 OutputStream과의 관계를 쉽게 이해할 수 있을 것입니다.
OutputStreamWriter에 있는 메소드를 이용해서 문자를 출력하게 되면,
OutputStreamWriter는 OutputStream을 내부적으로 이용해서 써야 할 대상에 바이트 단위로 출력하게 되는 것입니다.
```



# Scanner와 BufferedReader 차이
```java
1. Scanner의 버퍼 크기는 1024 chars, 반면 BufferReader의 버퍼 크기는 8192 chars이다.

2. BufferReader는 문자열을 단순히 읽고 저장, Scanner는 문자열을 구분하여 분석할 수 있다.

3. BufferReader는 동기화 된다. 반면 Scanner는 동기화가 되지 않는다.

4. BufferReader는 즉시 IOException 처리를 던지지만, Scanner는 숨긴다.


1번의 경우로 인해 큰 파일을 읽을 때는 BufferReader이 좋다.



2번의 경우는 Scanner는 지원하는 메소드를 이용할 수 있다.

아래 소스를 보자.

public static void main(String[] args) {

    // Initialize Scanner object
    Scanner scan = new Scanner("Anna Mills/Female/18");
    // initialize the string delimiter
    scan.useDelimiter("/");
    // Printing the tokenized Strings
    while(scan.hasNext()){
        System.out.println(scan.next());
    }
    // closing the scanner stream
    scan.close();
}



Anna Mills
Female
18

위처럼 Scanner는 구문 기호를 이용할 수 있다.



"BufferReader는 멀티 쓰레드에 안전하고, Scanner는 안전하지 않다" 라는 말을 본 적이 있는가?

그것이 3번의 경우이다.

동기화에 대해 살짝 언급하겠다.



멀티쓰레드의 경우 여러 쓰레드가 같은 프로세스 내의 자원을 공유하기 때문에 서로의 작업에 영향을 줄 수 있다.

예를 들어 A 쓰레드가 작업중이다.

그러던 중 B 쓰레드에게 넘긴다.

B 쓰레드에서 공유 데이터를 변경하고 A 쓰레드에 다시 제어권을 넘긴다면 예기치 않은 결과가 나올 수 있다. 

제대로 된 처리를 위해선 A 쓰레드가 작업이 끝날 때까지 다른 쓰레드가 영향을 주지 않아야한다.



그리하여 멀티 쓰레드를 활용하는 소켓 예제에서는 대부분 BufferReader를 많이 사용하는 걸 봤을 것이다.



4번의 경우는 Scanner 경우에는 그냥 손이 덜 가는 것이 장점이다.



차이를 잘 알고 가길 바란다.

본인이 잘못 알고 있거나 빼먹은 것들이 있다면 알려주면 감사하겠다.



출처: https://mygumi.tistory.com/43 [마이구미의 HelloWorld]

```

```java
그러나 스캐너의 경우 사용하기 편리하지만 속도가 느리다는 치명적인 단점이 있다.

숫자 100만개를 입력받는데 걸리는 시간은 다음과 같다.
대충 2.5초 (2441ms)가 소요되었다. 100만개 입력에 2.5초라고 놓고 보면 빠른것 같지만 알고리즘 사이트의 경우 
최대 입력받는 데이터가 천만~1억에 이르는 경우도 종종 있고, 무엇보다 다른 연산시간까지 고려하면 좀 결코 뛰어난 성능이라고 할 수는 없다.

이제 BufferedReader를 이용해 입력을 받아보자. 버퍼리더는 한줄을 통째로 입력받는 방법으로 
이것저것 선언해야할 것이 많아 번거롭지만 비교적 빠를 수 있다는 장점이 있다.
대략적인 사용 설명을 하자면 이렇다.

import java.io.BufferedReader;
import java.io.InputStreamReader; //이 2개 import필수(java.io.*; 로 전부 받을수도 있다.)

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine(); //입력받을값이 String일때
        int a = br.read(); //입력받을값이 int일때
        int b = Integer.parseInt(br.readLine()); //int값+엔터 까지 입력받을때
    }
}
이런식으로 입력받을 수 있는데 알고리즘 사이트에서 데이터들은 대부분
1
2
3
이런식으로 한줄씩 띄워진 상태로 입력이 들어온다.
따라서 int b를 입력받은 방법처럼 일단 스트링으로 개행문자(엔터)까지 포함해 통째로 받아온다음 형변환을 통해 저장한다.
또한 new BufferedReader(new InputStreamReader(System.in), 1024)); 이렇게 버퍼 사이즈를 
직접 지정할 수도 있는데 아무것도 지정하지 않을시 디폴트 사이즈 버퍼를 갖는다. 어지간한건 디폴트 사이즈로도 충분했다.

아무튼 버퍼리더를 이용해 100만개의 값을 입력받는 코드와 결과는 아래와 같다.

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in.readLine();
		int t;
		long st2 = System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			t = Integer.parseInt(in.readLine());
		}
		System.out.println("소요시간 "+(System.currentTimeMillis() - st2)+"ms");
	}
}

소요시간은 스캐너의 1/6수준인 약 0.4초(452ms)밖에 걸리지 않았다. 사실 위에서 얘기했다시피 
버퍼리더는 한줄을 통째로 받는 방식이기 때문에
1 2 3 4 5 6 7 8 9 10 11 ...
과 같이 한줄로 입력이 들어올때 스캐너에 비해 훨씬 성능이 더 높아진다.

따라서 문제 제출시 알고리즘상에 문제가 없는데도 불구하고 시간초과가 난다면 Scanner에서 BufferedReader로 바꿔 제출해보도록 하자.

물론 스캐너와 버퍼리더가 처음부터 동일한 목적으로 만들어진건 아니지만 채점상 시간을 줄일 수 있는 방법이므로 
적절히 활용하면 큰 효과를 볼 수 있을 것이다.
```


# 입출력
```java
입력과 출력

system.out.println : 표준 출력 스트림으로 전달되어 터미널에 표시

system.in 객체는 바이트 하나만 읽어오는 메서드밖에 없기 때문에 System.in에 연결된 Scanner를 생성해야한다.

Scanner in = new Scanner(System.in); // java.util.Scanner

다음 한줄을 읽는 메서드 nextLine() / 공백마다 나눠 읽는 메서드 next() / 정수 읽는 메서드 nextInt() / 부동소수점 읽는 메서드 nextDouble()

다른 줄, 단어, 정수, 부동소수점이 있는지 검사하려면 haNextLine, hasNext, hasNextInt, hasNextDouble 사용

터미널에서 비밀번호 안보이게 하기

Scanner로는 비밀번호 입력시 보이기 때문에 Console 클래스를 이용한다.

Console terminal = System.console();

String username = terminal.readLine("User Name : ");

char[] passwd = terminal.readPassword("Password : ");

배열과 배열 리스트

배열 초기화에 new 연산자 필요하다.

배열이름.length로 배열의 길이를 얻을 수 있다.

기본타입이 아닌 객체배열을 생성했을 때는 초기화도 따로 해야한다.

배열리스트 = 제네릭클래스 ArrayList

기본 타입의 래퍼클래스 ArrayList<Integer> numbers = new ArrayList<>();

* 기본타입과 래퍼 타입 사이의 변환에서 유의할 것은 단 하나다. if( numbers.get(i) == numbers.get(j) ) 에서 처럼 ==을 

이용하면 안되고 equals를 이용해야 비교,검사가 된다는 것이다.

배열에서 복사

얕은 복사

int[] numbers = primes;

numbers[5] = 42; 하면 primes도 같은 배열을 참조하게 된다. 따라서 primes[5]도 같이 바뀐다.

이런 공유를 원하지 않는다면 정적메서드 Arrays.copyOf 를 사용한다.

깊은 복사

int[] copiedPrimes = Arrays.copyOf(primes,primes.length);

배열리스트에서 복사

얕은 복사

ArrayList<String> people = friends;

people.set(0,"Mary"); // friends.get(0)도 "Mary"다.

깊은 복사

Arraylist<String> copiedFriends = new ArrayList<>(friends);

복사하려면 기존 배열리스트에서 새로운 배열리스트를 생성해야 한다.

* 만약 배열을 배열리스트로 복사할 때는 ArrayList생성자를 이용하면된다.

단 , Arrays.asList로 배열을 리스트로 감싸야한다.

ArrayList<String> friends = new ArrayList<>(Arrays.asList(names)); // names는 배열

배열 알고리즘

Arrays와 Collections 클래스는 알고리즘 구현을 제공한다.

Arrays.fill(numbers, 0); // int[]

Collections.fill(friends, ""); // ArrayList<String>

Arrays.sort(names);

Collections.sort(friends);


```
