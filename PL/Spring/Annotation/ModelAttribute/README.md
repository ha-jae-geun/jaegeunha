# [RequestParam](https://www.youtube.com/watch?v=g4pTP69HrNw&list=PLPvokKzUkaLeiLUDKpqRdP8jtLU8lLKgR&index=13)

# [ModelAttribute](https://www.youtube.com/watch?v=dlqoM31YPJ8&list=PLPvokKzUkaLeiLUDKpqRdP8jtLU8lLKgR&index=14)
```java
@ModelAttribute와 @RequestParam의 다른 점은 RequestParam은 파라미터를 1:1로 받는 반면, ModelAttribute는 
도메인 모델이나 DTO 같은 모델을 받는 타입이다.

@RestController
public class SampleController{
    @GetMapping("/sample")
    public String hello(@ModelAttribute Post post){
        return "hello";
    }
}
ModelAttribute는 메서드에 작성할 수도 있고 파라미터에 작성할 수 있다. 두 가지 동작 방식이 조금 다르다.

메소드의 매개변수로 선언
파라미터가 Command객체에 맵핑되어 넘어오게 된다.
=> 스프링 컨테이너가 생성하는 Command 객체의 이름은 클래스 이름의 첫 글자를 소문자로 변경한 이름이 자동으로 설정된다.
따라서 Command 객체의 이름을 변경하고 싶다면 @ModelAttribute("이름")으로 사용한다.
메소드에 선언
View에서 사용할 데이터를 설정하는 용도로 사용
@ModelAttribute가 설정된 메소드는 @RequestMapping 어노테이션이 적용된 메소드보다 먼저 호출
@ModelAttribute 메소드 실행 결과로 리턴되는 객체는 자동으로 Model에 저장
@ModelAttribute 메소드 실행 결과로 리턴된 객체를 View 페이지에서 사용 가능
메소드에 선언되었을 경우 작동 방식

@RequestMapping(value = "getBoardList.do")
public String getBoardList(Model model){
    model.addAttribute("post", new Post());
    return "boardList";
}

@ModelAttribute("commonCodeMap")
public Map<String, String> commonCodeMap(){
    Map<String, String> commonCodeMap = new HashMap<>();
    commonCodeMap.put("code1", "codeValue1");
    commonCodeMap.put("code2", "codeValue2");
    return commonCodeMap;
}
클라이언트 getBoardList.do 요청
@ModelAttribute가 설정된 commonCodeMap 실행, return된 값 Model객체에 저장
이 후 getBoardList() 메소드 실행
boardList 뷰가 띄어지면 뷰에서는 post와, commonCodeMap attribute를 사용할 수 있게 된다. (즉, Model 객체에 두 개의 attribute가 저장됨)
만약에 프로젝트에서 사용하는 모든 뷰에 특정 code를 갖고있어야 한다라고 하면 @ModelAttribute가 붙은 메소드에 code를 
리턴하는 클래스를 만든 후, 모든 Controller에서 이 클래스를 상속받으면 반복적인 코딩을 하지않고도, view에서 code를 꺼내쓸 수 있게된다.

@RequestAttribute
@RequestAttribute는 request객체의 attribute를 갖고올 수 있는 어노테이션이다.

@GetMapping("/sample")
public String sample(@RequestAttribute String id){
    System.out.println(id);
}
이런식으로 reuqest객체의 attribute를 손쉽게 사용할 수 있다.
```

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

# ModelAttribute 과정
```java
Spring MVC의 @ModelAttribute 어노테이션에 대한 개념 정리



Spring MVC에서 @ModelAttribute을 메소드의 파라미터로 사용할 경우 프로그램이 어떤 식으로 돌아가는지를 정리하고자 한다.

다른 어노테이션에 비해 @ModelAttribute는 내부적으로 돌아가는 부분이 많은 것 같다. 즉 Spring framework이 내부에서 알아서 처리해 
주는 부분이 다른 어노테이션에 비해 더  많은 것 같다. 따라서 개발자의 손을 떠나 보이지 않는 가운데서 처리되는 부분에 대한 개념이 
없다면 어둠 속에서 더듬이가 될수 밖에 없는 것이다.



여기 다음과 같은 빈 클래스가 있다고 할때



public class MemberInfo 

{

	private int seq;

	private String name;

	private int age;



	//이하 getter, setter는 생략

}



http://localhost:8080/member/info?name=Gildong&age=25seq=327



와 같이 접속되어 들어올 때 Controller 클래스의 아래 메소드가 실행될 것이다.



@Controller

@RequestMapping("/member/*")

public class MemberController

{

  ... 중 략 ...

	@RequestMapping(value = "/info", method=RequestMethod.GET)

	public void show(@RequestParam("seq") int seq, @ModelAttribute("myMEM") MemberInfo info, Model model)

	{

		logger.info("####### info.getName() "+info.getName());

		logger.info("####### info.getAge() "+info.getAge());



		try {	

			//service.read(seq)가 MemberVO 객체를 반환한다고 할 경우

			model.addAttribute(service.read(seq));

		}catch(Exception e) {

			e.printStackTrace();

		}

	}

  ... 후 략 ...

}



이 메소드가 실행되면 info.jsp가 자동으로 실행되게 된다. 따라서 info.jsp가 만들어져 있어야 되고 없으면 404 Not found 에러가 발생할 것이다.

그리고 info.jsp의 아래 코드에서 결과가 나오게 될 것이다.



<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="EUC-KR">

<title>Insert title here</title>

</head>

<body>

	<h3>회원 이름(info.name) : ${info.name }</h3> <%-- 여기서는 아무것도 안 나옴 --%>

	<hr/>

	<h3>회원 이름(myMEM.getName()) : ${myMEM.getName() }</h3>   <%-- 회원 이름이 정상적으로 출력된다. --%>

	<h3>현재 페이지(myMEM.name) : ${myMEM.name }</h3>             <%-- 회원 이름이 정상적으로 출력된다 --%>

	<hr/>

	<h3>회원 번호 : ${memberVO.seq }</h3>    <%-- 회원 번호가 정상적으로 출력된다 --%>

</body>

</html>



JSP의 코드는 위의 내용이 전부이다. 무엇이 어떻게 돌아가기에 http url로 들어온 회원 이름과 회원 번호가 Controller에 저장이되고
Controller에서 JSP로 특별하게 보내는 코드도 없어 보이는데 JSP 코드에서 저렇게 값이 정상적으로 출력이 된단 말인가?

이것이 @ModelAttribute의 위력이고 편리함이면서 동시에 개발자를 더듬이로 만드는 측면이기도 하다.

단순한 @ModelAttribute가 무슨 역할을 했단 말인가?



@ModelAttribute 선언 후 자동으로 진행되는 작업들은 다음과 같다.

     ① 파라미터로 넘겨 준 타입의 오브젝트를 자동으로 생성한다. 

         위의 코드에서는 MemberInfo 클래스의 객체 info를 자동으로 생성한다. 

         이때 @ModelAttribute가 지정되는 클래스는 빈 클래스라야 한다. 

         즉 MemberInfo 클래스는 beans 클래스라야 한다.

         그리고 getter와 setter가 명명 규칙에 맞게 만들어져 있어야 한다.



   ② 생성된 오브젝트에(info) HTTP로 넘어 온 값들을 자동으로 바인딩한다. 

       위의 코드의 경우는 name=Gildong&age=25seq=327 이렇게 들어오는 

       name, age, seq의 값이 MemberInfo의 해당 변수의 setter를 통해서 

       해당 멤버 변수에로 binding된다.



   ③ @ModelAttribute 어노테이션이 붙은 객체가(여기서는 MemberInfo 객체) 자동으로 Model 객체에 추가되고 

       따라서 MemberInfo 객체가 .jsp 뷰단까지 전달이 된다.



이상의 작업이 개발자를 대신해서 Spring framework가 알아서 다 처리해 준다. 편리하긴하다. 

이때 @ModelAttribute() 괄호 안에 지정한 문자열(위의 경우에는 myMEM)의 의미를 알아야 한다. 이 문자열의 이름으로(이것이 객체이다)
Model 객체에 자동으로 추가가 되고 따라서 JSP 뷰단으로 안전하게 넘어가게 된다. 즉 MemberInfo 객체가 Model 객체에 추가될 때
@ModelAttribute()의 괄호 안에 지정한 문자열의 이름으로 추가된다는 점이다. 그리고 이 문자열 이름은 MemberInfo의 객체인 것이다. 


 
만일 @ModelAttribute()의 괄호 안에 아무런 문자열도 지정하지 않으면 JSP 페이지에서 MemberInfo 객체에 저장되어 있는 값을 사용할수가 없게된다.



보이지 않는 가운데서 내부적으로 Spring에 의해 처리되는 이상의 작업들로 인해 info.jsp에서 다음 코드가 유효하게 동작하는 것이다.



	<h3>회원 이름(myMEM.getName()) : ${myMEM.getName() }</h3>   <%-- 회원 이름이 정상적으로 출력된다. --%>

	<h3>현재 페이지(myMEM.name) : ${myMEM.name }</h3>             <%-- 회원 이름이 정상적으로 출력된다 --%>



여기서 ${myMEM.getName()}과 ${myMEM.name}의 차이가 무엇인고 하면 전자의 경우는 MemberInfo의 메소드를 직접 호출해서 
사용한 경우이고 후자의 경우는 MemberInfo의 멤버 변수 name을 JSTL에서 사용하면 자동으로 name의 getter인 getName()이 호출되게 되는 것이다.



출처: https://developer-joe.tistory.com/197 [코드 조각-Android, Java, Spring, JavaScript, C#, C, C++, PHP, HTML, CSS, Delphi]
```
