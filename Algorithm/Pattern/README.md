# 숫자, 파일 패턴
```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    private static Pattern p = null;
    private static Matcher m = null;
    private static final String ONLY_NUM_PATTERN = "^[0-9]+$";
    private static final String FILE_PATTERN = "^\\S+.(?i)(txt|pdf|hwp|xls)$";

    public static boolean numCheck(String str) {
        p = Pattern.compile(ONLY_NUM_PATTERN);
        m = p.matcher(str);
        
        return m.find();
    }
    
    public static boolean fileCheck(String str) {
        p = Pattern.compile(FILE_PATTERN);
        m = p.matcher(str);
        
        return m.find();
    }
    
    public static void main(String[] args) {
        System.out.println(numCheck("123123123"));      //true
        System.out.println(numCheck("1231--23123"));    //false     
        System.out.println(numCheck("a23123"));         //false
        
        System.out.println(fileCheck("a23123"));        //false
        System.out.println(fileCheck("ktko.txt"));      //true
        System.out.println(fileCheck("ktko.pdf"));      //true
        System.out.println(fileCheck("ktko.xls"));      //true
        System.out.println(fileCheck("ktko.jpeg"));     //false
    }
}


출처: https://ktko.tistory.com/entry/JAVA-자바의-정규표현식-Pattern-Matcher [KTKO 개발 블로그와 여행 일기]
```
