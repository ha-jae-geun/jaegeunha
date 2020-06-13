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

```java
InputStream in = Files.newInputStream(path);

OutputStream out = Files.newOutputStream(path);

path는 Path클래스의 인스턴스다. // File System에서 경로를 나타낸다.

URL이 있을 때는 입력 스트림에서 해당 URL의 콘텐츠를 읽을 수 있다.

URL url = new URL("http://jeong-pro.com/index.html");

InputStream in = url.openStream();

바이트 배열 읽기

byte[] bytes = ...;

InputStream in = new ByteArrayInputStream(bytes);

바이트 배열 출력

ByteArrayOutputStream out = new ByteArrayOutputStream();

byte[] bytes = out.toByteArray();

경로 (Path)

Path absolute = Paths.get("/", "home", "cay"); // 첫번째인자가 루트구성요소면 절대경로

Path relative = Paths.get("myapp","conf","user.properties"); // 아니면 상대경로

자동으로 유닉스파일시스템은 / , 윈도우는 \를 이용해 결합한다.

파일과 디렉터리 생성하기

Files.createDirectory(path); //새 디렉토리 생성

Files.createDirectories(path);

Files.createFile(path); // 빈 디렉토리 생성

파일 복사, 이동, 삭제

Files.copy(fromPath, toPath); //파일을 다른위치로 복사

Files.move(fromPath, toPath); //파일 이동 (원본을 복사한 후 삭제)

기존에 대상 덮어쓰기 는 인자로 옵션 추가 StandardCopyOption.REPLACE_EXISTING

자식 방문하기

try(Stream<Path> entries = Files.walk(pathToRoot)){...}

//자손 노드를 모두 담고 있으며, 각각을 깊이 우선 순서로 방문한다.
```
