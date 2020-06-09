# ModelAttribute
```java
| @ModelAttribute



@ModelAttribute는 스프링에서 JSP파일에 반환되는 Model 객체에 속성값을 주입하거나 바인딩할 때 사용되는 어노테이션이다. 
컨트롤러(Controller) 객체에서 2가지 방법으로 사용된다.



@ModelAttribute("serverTime")
public String getServerTime(Locale locale) {
    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
    return dateFormat.format(date);
}
먼저 메서드에 @ModelAttribute를 붙이는 경우다. 이 때 serverTime 속성을 Model 객체에 아래와 같은 코드를 실행함으로서 
반환되는 dateFormat.format(date) 값을 바인딩한다. 이 값은 JSP 파일에서 사용할 수 있다.



@RequestMapping(value="/memJoin", method=RequestMethod.POST)
public String memJoin(@ModelAttribute("mem") Member member) {
    service.memberRegister(member);
    return "memJoinOk";
}
다음은 컨트롤러 메서드의 인수에 어노테이션을 부착하는 경우다. @ModelAttribute을 써서 HTTP 요청에 들어있는 속성값들을 
Member 커맨드 객체에 자동적으로 바인딩 하게 된다. 만일 @ModelAttribute([NAME]) 형태로 붙일경우 JSP파일에서 ${[NAME].property} 
형태로 Model 객체의 값을 사용할 수 있게 된다.



@Controller
@RequestMapping("/member")
public class MemberController {

    @Resource(name="memService")
    MemberService service;

    @ModelAttribute("serverTime")
    public String getServerTime(Locale locale) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        return dateFormat.format(date);
    }

    @RequestMapping(value="/memJoin", method=RequestMethod.POST)
    public String memJoin(@ModelAttribute("mem") Member member) {
        service.memberRegister(member);
        return "memJoinOk";
    }
}
위 두 가지 방식을 동시에 써서 @ModelAttribute를 써서 JSP파일에 전달하는 Model 객체에 serverTime 속성과 mem으로 
표현되는 Member 객체의 데이터를 넘겨줄 수 있다. 



<%@ page language="java" contentType="text/html; charset=EUC-KR"
pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>memJoinOk</title>
</head>
<body>
<h1> memJoinOk</h1>

ID : ${mem.memId} <br/>
PW : ${mem.memPw} <br/>
Mail : ${mem.memMail} <br/>
Phone : ${mem.memPhone.memPhone1} - ${mem.memPhone.memPhone2} - ${mem.memPhone.memPhone3} <br/>
<P>  The time on the server is ${serverTime}. </P>
<a href="/mvc/resources/html/memJoin.html"> Go MemberJoin</a>
</body>
</html>


출처: https://engkimbs.tistory.com/694 [새로비]
```
