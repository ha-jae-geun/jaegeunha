# ModelAttribute
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
