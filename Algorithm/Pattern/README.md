# 불량 사용자
```java
		// 재귀를 통해 pattern에 맞는 문자들을 선택해 나간다.
		for(int i=0; i<user_id.length; i++) {
			String s = banned_id[idx].replace("*", ".");
			Pattern pattern = Pattern.compile(s);
			Matcher matcher = pattern.matcher(user_id[i]);
			
			// 정규 표힌식에 매칭 되고, 길이가 같은 경우
			if(matcher.find() && user_id[i].length() == banned_id[idx].length()) {
				// 제제 아이디로 체크하지 않은 경우 check
				if(!visited[i]) {
					visited[i] = true;				
					dfs(banned_id, user_id, idx+1, n+1, visited);	// 다음 banned_id와 매칭되는 제재 아이디 찾기
					visited[i] = false;					
				}
			}
		}
```

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
