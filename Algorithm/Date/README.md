# 날짜 차이
```java
package Hyundai;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Purchase {
	
    static int bronze = 0;
    static int silver = 0;
    static int gold = 0;
    static int pla = 0;
    static int dia = 0;
    static String lastDay = "2019/12/31";
    static int [] yearRev = new int [365];
    
    public static int[] solution(String[] purchase) {
        int[] answer = new int [5];
        
        for(int i=0; i<purchase.length; i++) {
        	DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        	String nextDay = "";


        	
        	String [] a = purchase[i].split(" ");
        	
        	try {
				Date date = format.parse(a[0]);
				Date date2 = format.parse(lastDay);
				//두날짜 사이의 시간 차이(ms)를 하루 동안의 ms(24시*60분*60초*1000밀리초) 로 나눈다.
				long diffDay = ((date2.getTime() -date.getTime()) / (24*60*60*1000))+1;
				fillPrice(diffDay, Integer.parseInt(a[1]));
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
        
        for(int i=0; i<365; i++) {
        	if(yearRev[i] >= 0 && yearRev[i] < 10000)
        		bronze = bronze + 1;
        	if(yearRev[i] >= 10000 && yearRev[i] < 20000)
        		silver = silver+ 1;
        	if(yearRev[i] >= 20000 && yearRev[i] < 50000)
        		gold = gold+ 1;
        	if(yearRev[i] >= 50000 && yearRev[i] < 100000)
        		pla = pla + 1;
        	if(yearRev[i] >= 100000)
        		dia = dia + 1;
        }
        answer[0] = bronze;
        answer[1] = silver;
        answer[2] = gold;
        answer[3] = pla;
        answer[4] = dia;
        System.out.println();

       
        return answer;
    }
    
    public static void fillPrice(long diffDay, int price) {
    	long day = 365 - diffDay;
    	for(int i=0; i<30; i++) {
    		if(day < 0)
        		continue;
    		yearRev[(int) (day+i)] = yearRev[(int) (day+i)] + price;
    	}
    }
    
    public static void main(String[] args) {
    	String [] a  = {"2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"};
		System.out.println(solution(a));
	}
}


```
