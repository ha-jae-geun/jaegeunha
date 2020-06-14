# Constructor
```java
자바 IO를 이해하기 전 "상속"을 명확히 이해하자.

자바에서 입출력(IO)을 이해하려면 "상속"을 명확하게 이해하고 있어야 한다.

상속? 객체 지향 프로그래밍에서 클래스의 재사용을 위해서 자식클래스가 부모클래스의 메소드등을 물려받는 것 아닌가?

오버라이딩, 오버로딩을 떠나서 단순하게는 맞지만 여기서 중요한 점은 생성자, 메소드의 파라미터를 보는 시각이 명확해야하는 

점과 IO클래스들이 상속을 통해 클래스를 조립해서 입출력하는 방법을 다르게 하는 점이다.

1
public static void print(String str){...}


이 메소드를 어떻게 해석해야 할까?

"print라는 메소드가 String클래스의 파라미터를 받는다."

정확한 답은 아니다.

"print라는 메소드가 String클래스와 String클래스의 자손을 받아들인다."

이렇게 말해야 정확하게 말한 것일 것이다.

1
public static void print(Object obj){...}


위 처럼 예시를 주었다면 파라미터가 Object니까 아무 객체나 넣어도 되는구나? 했을 것이다.

모든 객체는 Object를 상속받는 것을 알고 있으니까.

그런데 String이라고 적었단 이유로 당연하게 문자열을 넣어야지 맞겠다고 생각해버리는 것이다.

자바 IO를 이해하려면 파라미터에 있는 클래스뿐만 아니라 클래스의 자손도 와도 되는구나를 알아야 한다.

이렇게 상속을 고려해서 파라미터를 보는 시각을 명확히하고 IO클래스들의 생성자를 보면 조립한다는 것이 어떤 이야기인지 알 수 있다.

바이트 단위 IO 클래스, 바이트 스트림

java.io 패키지에서 다양한 클래스가 제공된다. 그 중에서 가장 기본이 되는 것이 바이트 단위의 입출력 클래스다.

영어는 1바이트만으로도 모든 글자를 표현할 수 있지만 중국, 한국, 일본등은 모든 글자를 표현하려면 2바이트가 필요하다.

따라서 자바는 바이트 단위스트림(영어)이 기본이고 문자스트림(2바이트 언어권)이 추가적으로 생기게 된 것이다.

* 컴퓨터에 존재하는 모든 데이터는 바이트 단위로 구성되어 있다.

바이트 스트림으로 입출력(네트워크든 파일이든)을 할때는 InputStream과 OutputStream의 자식 클래스다.

(InputStream과 OutputStream은 추상클래스로 직접 생성할 수 없다. => 상속 눈여겨 봐야함.)

예를 들어서 "FileInputStream은 InputStream인데 파일로부터 바이트 단위로 입력 받기 위한 스트림이다." 로 정의할 수 있다.


import java.io.FileInputStream;
import java.io.IOException;
 
//file의 내용을 읽어 화면에 출력하는 프로그램
public class FileView {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("사용법 : java FileView 파일명");
        }
        //항상 null로 먼저 정의하고
        FileInputStream fis = null;
        try {
            //try구문에서 입출력스트림 생성
            fis = new FileInputStream(args[0]);
            int i = 0;
            while((i = fis.read()) != -1) {
                System.out.write(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                //finally구문에서 스트림 close하기
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
 
Colored by Color Scripter


파일의 내용을 읽어 들여 화면에 출력하는 프로그램이다.

FileInputStream은 InputStream을 상속받는다. 바이트 단위로 파일을 읽는다.

약간 논점을 흐릴 수 있는데 이 프로그램의 단점은 자바프로그램에서는 바이트 하나씩 읽어드리고 있지만 실제로 운영체제는 

512 또는 1024바이트씩 읽어오는 것이다. 따라서 실제로는 굉장히 많은 입출력이 일어나고 있어 효율적이지 않다.

이 문제를 해결하기 위해서는 버퍼를 두어 한번에 읽는 것이 적절하다.

이 예제에서 중요하게 볼 내용은 I/O에서 일반적인 코딩룰과 바이트 스트림을 이용한다는 것이다.

I/O에서 이용하는 룰은

1. Stream클래스를 null로 선언하고

2. try블럭에서 생성하고 사용한 후

3. finally블럭에서 IO스트림을 닫아주는 것이다.

바이트 스트림을 이용하는 클래스는 ByteArray[Input/Output]Stream, Data[Input/Output]Stream, Piped[Input/Output]Stream 등이 있다.

결국 중요한 포인트는 바이트 스트림을 받아준다는 것을 생성자를 보면 알 수 있다는 것이다.

(뒤에 접미사가 Stream으로 되어있으면 보통 바이트 스트림이다.)

문자 단위 IO클래스, 문자스트림 

뒤에 접미사가 Reader, Writer가 주로 붙는다.

Reader와 Writer는 문자 단위 입출력 스트림에서 가장 기본이 되는 클래스다.

InputSteam, OutputStream과 마찬가지로 추상클래스로 직접 객체화가 될 수 없다.

생성자가 중요한 이유는 생성자에 전달한 인자가 무엇이냐에 따라서 읽어 들여야할 대상과 써야 할 대상이 달리지기 때문이다.

Reader과 Writer도 InputStream, OutputStream을 생성자에서 받아들인다.

즉 바이트로 읽어들이는 InputStream을 통해 데이터를 읽어들여 문자단위로 읽어들이는 방식으로 변형한다는 것이며, 바이트로 쓰는

OutputStream을 통해 데이터를 쓰긴 하지만 문자 단위로 쓰는 것처럼 변형한다는 것이다.

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class StreamReaderTeste {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("사용법 : java StreamReaderTest 파일명");
            System.exit(0);
        }
        FileInputStream fis = null;
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            fis = new FileInputStream(args[0]);
            isr = new InputStreamReader(fis);
            osw = new OutputStreamWriter(System.out);
            char[] buffer = new char[512];
            int readcount = 0;
            while((readcount = isr.read(buffer)) != -1) {
                osw.write(buffer,0,readcount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                isr.close();
                osw.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
 
Colored by Color Scripter


문자 단위로 파일 내용을 읽어 들여 화면에 출력하는 프로그램이다.

바이트스트림을 이용한 IO와 거의 같다. 마찬가지로 바이트스트림을 이용하는 IO와 문자 스트림을 이용하는 IO에는 어떤 클래스들이 

있는지만 확인하고 한 두개를 코딩해보면 될 것 같다.

객체 스트림 

객체 스트림은 우리가 어떤 객체 그대로 통신하고 싶을 때 사용하는 방법이다.

객체를 통신할 때는 요구 조건이 있다. 바로 객체가 직렬화가 가능해야 한다.

객체를 직렬화하는 방법은 Serializable 인터페이스를 implements 하는 방법으로 가능하다.

Serializable 인터페이스는 오버라이드하는 메소드가 없는 마크 인터페이스로 그냥 implements하면 된다.



- 마샬링 : 데이터를 바이트스트림으로 만들어 TCP와 같은 통신 채널을 통해 전송하거나 스트림으로 써줄 수 있는 형태로 바꾸는 과정

마샬링 될 수 있는 데이터는 기본자료형(boolean, byte, char, short, int, long, float, double)과 Serializable 인터페이스를 

구현하고 있는 객체만 가능하다.

- 언마샬링 : 마샬링과 반대로 전송받은 데이터를 원래의 형태로 변환하는 과정을 뜻한다.

package nio;
 
public class Book implements Serializable{
    private String isbn;
    private String title;
    private String author;
    private int price;
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public Book(String isbn, String title, String author, int price) {
        super();
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", price=" + price + "]";
    }
    
    
}
Colored by Color Scripter
cs
[Book 클래스]

Serializable 인터페이스를 확장한 것을 확인한다.


package nio;
 
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
 
public class BookObjectOutputTest {
    public static void main(String[] args) {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        ArrayList<Book> list = new ArrayList<>();
        Book b1 = new Book("a0001","자바완성","정프로",10000);
        Book b2 = new Book("a0002","IO완성","정아마추어",20000);
        Book b3 = new Book("a0003","NIO완성","정코딩",30000);
        list.add(b1);
        list.add(b2);
        list.add(b3);
        
        try {
            fout = new FileOutputStream("booklist.dat");
            oos = new ObjectOutputStream(fout);
            
            oos.writeObject(list);
            oos.reset();
            System.out.println("저장완료");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                oos.close();
                fout.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
 
Colored by Color Scripter


[.dat파일에 객체를 보내는 코드]

객체통신에서는 writeObject()를 할 때 하나의 객체만을 보낼 수 있다. 따라서 여러 Book을 보낼 때 ArrayList를 사용해서 list 객체에 묶어서 보냈다.

만약 파일이 아닌 네트워크에 보냈다면 수신자도 똑같이 Book클래스가 어떻게 구성되어있는지 알아야 파싱이 가능하다.

(JSON이 왜 좋은지 알 것 같다.)

미리 서두에 말을 안했는데 객체스트림의 기본 클래스는 ObjectInputStream과 ObjectOutputStream이다.
```
