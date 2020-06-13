# Ini 파일
```java
.ini 파일 입출력하기

애플리케이션을 실행시키기 전에 필요한 설정들을 따로 파일(.ini 파일 또는 .conf, .properties파일 등)에서 

가져와 실행하는 방법을 많이 쓴다.

초기 설정 파일의 포맷은 다양한데 그 중 .ini파일에 대해 알아보고 입출력 해보겠다.

.ini파일은 일반적인 .properties파일과는 다르다.

.properties 파일같은 경우에는 보통 단순하게 "key = value" 식으로 작성해서 입출력하는 방식이다.


ip = 192.168.0.11
port = 5000
rootpath = C:\Users\jeongpro
id = jeongpro


구성도 간단하고 입출력하는 방법도 간단하다.

반면에 .ini파일은 조금 더 추가되어 Section, Key, Value로 구성되어 있다.


[section1]
ip = 192.168.0.11
port = 5000
 
[section2]
ip = 192.168.0.55
port = 8080
cs
대괄호로 Section을 나누고 section마다 키와 값이 들어가 있어서 파싱해서 사용하면 된다.

java.util.Properties 를 이용한 방법

java.util.Properties를 이용해서 .ini파일 혹은 .properties 파일을 읽고 쓸 수 있다.


package inifile;
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
 
public class IniFileTest {
    public static final String filePath = "C:\\Users\\jeongpro\\Desktop\\";
    
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        
        prop.load(new FileInputStream(filePath+"server.ini"));
        System.out.println(prop.getProperty("ip"));
        System.out.println(prop.getProperty("port"));
        System.out.println(prop.getProperty("hello"));
        
        prop.setProperty("id", "jeongpro");
        prop.store(new FileOutputStream(filePath+"server.ini"), null);
    }
}
 
Colored by Color Scripter
cs


간단하게 설명하면,

Properties 객체를 만들고, load() 메소드를 통해서 읽어와 파싱한 후 getProperty() 메소드를 통해 값을 가져와 사용하면 된다.

또한 쓰려면 setProperty()를 이용하면 된다고는 한다.

* 그런데 읽기는 아주 잘되는데 쓰기만 하면 ini파일 내용이 깨진다. 뒤죽박죽..

왜 그런지는 잘 모르겠다. 인코딩문제는 아닌 것 같은데 신기한건 뒤죽박죽된 ini파일을 다시 getProperty로 읽으면 또 읽어진다... 결론은 모르겠다.

* 그리고 참고로 java.util.properties를 사용하면 어느 세션이든 key값이 중복되면 안된다.

만약 key가 겹치면 가장 뒤에적은 key를 가져온다.

ini4j 라이브러리를 이용한 ini 파일 입출력

Properties를 이용했을 때는 온전하지 못했다.

section을 구분 못하는 단점도 있고. 따라서 java.util.Properties클래스는 그냥 단순하고 몇개 설정할 게 없을 때 

.properties파일로 사용하면 될 것 같고 .ini파일이나 .conf파일을 불러올 때는 ini4j를 사용하는 것이 좋겠다.

ini4j 라이브러리는 http://ini4j.sourceforge.net/download.html 에서 다운로드하면 된다. (maven으로도 지원)

* 외부 라이브러리 적용하는 방법

이클립스기준으로 프로젝트 우클릭 > properties > Java Build Path > add External JARS에 .jar파일 두개를 추가한다.



이제 원하는 경로에 server.ini파일을 만든다.


[server]
ip = 192.168.0.1
port = 1234
 
[client]
ip = 192.168.0.22
port = 5678


먼저 파일읽기를 간단히 한다.

package inifile;
 
import java.io.File;
import java.io.IOException;
 
import org.ini4j.Ini;
 
public class IniFileTest {
    public static final String filePath = "C:\\Users\\jeongpro\\Desktop\\";
    
    public static void main(String[] args) throws IOException {
        File iniFile = new File(filePath+"server.ini");
        Ini ini = new Ini(iniFile);
        System.out.println(ini.get("server", "ip"));
        System.out.println(ini.get("server", "port"));
        System.out.println(ini.get("client", "ip"));
        System.out.println(ini.get("client", "port"));
    }
}
 
Colored by Color Scripter


아주 훌륭하다. Ini 생성자에서 열고자하는 .ini 파일을 파라미터로 넣어주고 get()메소드에서 section이름과 

key값을 각각 넣어주면 value를 얻을 수 있다.


package inifile;
 
import java.io.File;
import java.io.IOException;
 
import org.ini4j.Wini;
 
public class IniFileTest {
    public static final String filePath = "C:\\Users\\jeongpro\\Desktop\\";
    
    public static void main(String[] args) throws IOException {
        File iniFile = new File(filePath+"server.ini");
        
        Wini wini = new Wini(iniFile);
        wini.put("admin", "id", "jeongpro");
        wini.put("admin", "pw", 1234);
        //신규생성
        
        wini.put("server", "ip", "192.168.0.45");
        //수정
        wini.store();
        //저장
    }
}
 
Colored by Color Scripter
cs
쓰기는 Wini 클래스에서 생성하면 된다.

마찬가지로 put() 메소드에서 section이름, key, value를 차례대로 넣어준 후에 wini.store()메소드를 호출해야 적용이 된다.

수정하는 것도 section이름과 key가 일치하면 put()메소드로 값을 변경시켜준다.

제거는 따로 코드로 적진 않았지만 .remove() 메소드가 있다.
```
