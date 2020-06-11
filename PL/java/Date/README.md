# Date의 단점
```java
아직도 Calendar, Date 사용하니?

자바에서 아직도 Calendar.getInstance해서 시간/날짜를 표현하는 프로그래머가 있을까?

처음 공부할 때나 단순하게 표현해야할 때는 사용할 수 있지만 단점이 극명한 클래스라 사용하지 않는게 좋다는 것을 미리 말한다.

어떤 문제점이 있는지는 네이버 D2의 글에서 잘 설명해준다.

Calendar, Date 클래스의 문제점 (출처 : https://d2.naver.com/helloworld/645609 )

1. 불변 객체가 아니다.

-> 즉 set으로 변경이 가능하다는 점은 누군가 악의적으로 변경할 수 있기 때문에 get/set 메서드에서 직접 Date클래스를 사용하는 것이 위험하다.

2. 상수 필드 남용

-> calendar.add(Calendar.SECOND, 2);

3. 헷갈리는 월 지정

-> 1월을 0으로 표현하는 문제 + Calendar.OCTOBER로 월을 지정하지만 실질적인 값은 9(!=10)인 문제

4. 일관성 없는 요일 상수

-> 어디서는 일요일이 0, 어디서는 일요일이 1

5. Date와 Calendar 객체의 역할 분담

-> 다소 치명적인데 년/월/일 계산은 Date 클래스만으로는 부족해서 왔다갔다 하는 문제가 있다. 또한 Calendar객체를 생성하고 Date 객체를 생성하는 프로세스를 거치기 때문에 번거롭고 생성비용이 비싸다.

6. 기타 java.util.Date 하위 클래스의 문제

위와 같은 문제들이 존재한다.

그렇기 때문에 기존의 개발자들도 자바에서 제공하는 API를 사용하지 않고 적절하게 만든 오픈 소스 라이브러리인 joda time을 주로 사용한다.

LocalDate, LocalTime, LocalDateTime

이러한 문제를 해결하기 위해서 java8부터는 LocalDate, LocalTime, LocalDateTime 이라는 클래스를 만들었다.

joda time의 영향을 받아 비슷하게 설계되었다고 한다. 

바로 사용법을 코드로 보여주는게 더 이해가 빠를 것 같아 아래 코드에서 확인한다.

- 사용법

LocalDate currentDate = LocalDate.now(); // 컴퓨터의 현재 날짜 정보 2018-07-26
LocalDate myDate = LocalDate.of(int year, int month, int datOfMonth); //년,월,일
 
getYear();
getMonth(); (Month 열거값나옴 JANUARY, FEBRUARY)
getMonthValue(); 월(1,2,3,...)
getDayOfYear(); 년의 몇 번째 일
getDayOfMonth(); 월의 몇번째 일
getDateOfWeek();요일(MONDAY, TUESDAY,...)
isLeapYear(); 윤년여부
 
LocalTime currentTime = LocalTime.now();    // 컴퓨터의 현재 시간 정보. 결과 : 16:24:02.408
LocalTime targetTime = LocalTime.of(int hour, int minute, int second, int nanoOfSecond);
 
int    getHour()    시간
int    getMinute()    분
int    getSecond()    초
int    getNano()    나노초
 
LocalDateTime 시간,날짜 동시에 필요할 때 사용.
LocalDateTime currentDateTime = LocalDateTime.now();    // 컴퓨터의 현재 날짜와 시간 정보. 결과 : 2018-07-26T16:34:24.757
LocalDateTime targetDateTime = LocalDateTime.of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond);
ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
ZonedDateTime seoulDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
Colored by Color Scripter
cs


위의 사용법을 통해서 날짜/시간을 생성하는 방법을 배웠으면 입맛에 맞게 바꾸는 방법도 아래에서 알아본다.

참고로 날짜와 시간을 plusSeconds(), minusSeconds() 등으로 변환하는 메서드도 있고, 날짜간의 전후관계라든지 이런 비교와 관련된 isBefore(), isAfter()등 다양한 메서드들이 준비되어 있으니 확인하고 사용한다.

날짜/시간 변환


LocalDate -> String
LocalDate.of(2020, 12, 12).format(DateTimeFormatter.BASIC_ISO_DATE); // 20201212
 
LocalDateTime -> String
LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // 2018-07-26 00:42:24
 
LocalDateTime -> java.util.Date
Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()); //Thu Jul 26 01:00:30 KST 2018
 
LocalDate -> java.sql.Date
Date.valueOf(LocalDate.of(2015, 5, 5)); // 2018-07-26
 
LocalDateTime -> java.sql.Timestamp
Timestamp.valueOf(LocalDateTime.now()); // 2018-07-26 01:06:55.323
 
String -> LocalDate
LocalDate.parse("2002-05-09"); // 2002-05-09
LocalDate.parse("20081004", DateTimeFormatter.BASIC_ISO_DATE); // 2008-10-04
 
String -> LocalDateTime
LocalDateTime.parse("2007-12-03T10:15:30"); // 2007-12-03T10:15:30
LocalDateTime.parse("2010-11-25 12:30:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // 2010-11-25T12:30
 
java.util.Date -> LocalDateTime
LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()); // 2018-07-26T01:16:46.755
 
java.sql.Date -> LocalDate
new Date(System.currentTimeMillis()).toLocalDate(); // 2018-07-26
 
java.sql.Timestamp -> LocalDateTime
new Timestamp(System.currentTimeMillis()).toLocalDateTime(); // 2018-07-26T01:20:07.364
 
LocalDateTime -> LocalDate
LocalDate.from(LocalDateTime.now()); // 2018-07-26
 
LocalDate -> LocalDateTime
LocalDate.now().atTime(2, 30); // 2018-07-26T02:30
Colored by Color Scripter
cs
특히 TimeStamp와 format으로 바꾸는 것이 유용할 것 같다.

<출처 : http://jekalmin.tistory.com/entry/%EC%9E%90%EB%B0%94-18-%EB%82%A0%EC%A7%9C-%EC%A0%95%EB%A6%AC>

LocalDateTime 테스트! 겸 NTP 타임서버에서 시간 값 가져오기

일단 타임서버에 접근하려면 라이브러리가 필요하다.

maven repository에서 apache commons-net을 받아오도록한다.


<dependency>
    <groupId>commons-net</groupId>
    <artifactId>commons-net</artifactId>
    <version>3.6</version>
</dependency>
cs
아래에서는 스프링을 이용해서 다양한 테스트를 진행하다보니 전혀 관련없는 NTP코드도 아래처럼 나왔음을 이해하길 바라며, NTP의 경우 스프링에 대한 지식 없이도 코드 몇 줄만 보면 된다.

[TestController]


package com.apress.spring.controller;
 
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
 
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.apress.spring.dao.DateRepository;
import com.apress.spring.dto.DateObject;
 
@RestController
public class TestController {
    private static final String TIME_SERVER = "pool.ntp.org";
    
    @Autowired
    private DateRepository dateRepository;
    
    @GetMapping("/")
    public String test() {
        NTPUDPClient timeClient = new NTPUDPClient();
        timeClient.setDefaultTimeout(1000);
        try {
            timeClient.open();
            InetAddress address = InetAddress.getByName(TIME_SERVER);
            TimeInfo timeInfo = timeClient.getTime(address);
            long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime(); //서버로부터 시간 가져오는 코드
            Date date = new Date(returnTime);
            LocalDateTime localDateTime = 
                    date.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();//date to LocalDateTime
            
            System.out.println("TimeServer : " + localDateTime);//Naver 시계랑 동일!
            System.out.println("Local PC : " + LocalDateTime.now());
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "hello world";
    }
    
    @GetMapping("/test")
    public DateObject get(DateObject dateObject) {
        return new DateObject();
    }
    
    @GetMapping("/jpa")
    public String addDate() {
        DateObject dateObject = new DateObject();
        dateRepository.save(dateObject);
        return "saved";
    }
    @GetMapping("/jpa2")
    public Iterable<DateObject> getAllDate(){
        return dateRepository.findAll();
    }
}
 
Colored by Color Scripter
cs
GetMapping("/")을 보면 된다.

라이브러리를 import시켰기 때문에 NTPUDPClient를 사용할 수 있게 되었고 그것을 이용해서 TIME_SERVER "pool.ntp.org" 라는 
타임 서버에서 날짜를 가져올 수 있다.



결과를 보면 시스템에서 가져온 시간이 약 2초정도 빠르다... 나는 세상을 남들보다 2초정도 먼저 살고있었다. 응(?)

타임서버에서 가져온 시간은 네이버 시계를 틀어놓고 확인한 결과 일치한다.

[DateObject.java]

package com.apress.spring.dto;
 
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="newtable")
public class DateObject {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column
    private LocalDate date;
    @Column
    private LocalTime time;
    @Column(name="localdatetime")
    private LocalDateTime localDateTime;
    
    public DateObject() {
        date = LocalDate.now();
        time = LocalTime.now();
        localDateTime = LocalDateTime.now();
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
    @Override
    public String toString() {
        return "DateObject [id=" + id + ", date=" + date + ", time=" + time + ", localDateTime=" + localDateTime + "]";
    }
    
}
 
Colored by Color Scripter
cs
위의 코드는 그냥 DateObject라는 클래스를 만든 것이다.

객체 자체를 외부로 넘겼을 때 즉, json 형식으로 잘 표현되는지를 확인하기 위하여 테스트를 하기위한 클래스다.

다른 블로그에서는 jackson 라이브러리가 버전이 낮으면 LocalDate, LocalTime, LocalDateTime 클래스를 마샬링, 언마샬링 지원을 안해준다고 봤다.

내 프로젝트에서는 springboot 2.0.3이라 jackson이 2.9.x이다.

그래서 그런지 결과적으로 원활하게 되었다(?)



이제는 끝으로 JPA에서도 LocalXXXX가 잘 적용되는지 테스트해보려고 한다.


package com.apress.spring.dao;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
import com.apress.spring.dto.DateObject;
 
@Repository
public interface DateRepository extends CrudRepository<DateObject, Long> {
 
}
 
Colored by Color Scripter


이렇게 빈 Custom Repository를 만들어 주고 이용한다.

제일 위에 TestController 부분을 보면 "localhost:8080/jpa" 로 들어가면 새로운 DateObject가 데이터베이스에 insert되고 
"localhost:8080/jpa2"로 들어가면 데이터베이스에 존재하는 모든 컬럼을 select로 가져온다.

결과를 확인해보자



json viewer가 없어서 지금 일자로 쭉 나오는데 뷰어를 사용하면 아주 잘 들어가고 있음을 확인할 수 있다.

(mysql에서 테스트했고 데이터베이스에서 타입은 DATE, TIME, DATETIME을 사용했다.

잘 안되면 TimeStamp로 변환해서 사용해도 될 것 같다.)
```
