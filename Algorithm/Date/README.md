# 날짜 차이
```java
package Hyundai;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Purchase {
	
    static int bronze = 365;
    static int silver = 0;
    static int gold = 0;
    static int pla = 0;
    static int dia = 0;
    static String lastDay = "2019/12/31";
    
    public static int[] solution(String[] purchase) {
        int[] answer = {};
        
        for(int i=0; i<purchase.length; i++) {
        	DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        	String nextDay = "";

        	if(i != purchase.length-1) {
        		String [] b = purchase[i+1].split(" ");
        		nextDay = b[0];
			} else
				nextDay = lastDay;
        	
        	String [] a = purchase[i].split(" ");
        	
        	try {
				Date date = format.parse(a[0]);
				Date date2 = format.parse(nextDay);
				//두날짜 사이의 시간 차이(ms)를 하루 동안의 ms(24시*60분*60초*1000밀리초) 로 나눈다.
				long diffDay = ((date2.getTime() -date.getTime()) / (24*60*60*1000));
				System.out.println(diffDay);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }

        
        
        return answer;
    }
    
    public static void main(String[] args) {
    	String [] a  = {"2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"};
		System.out.println(solution(a));
	}
}

```
