# RequestBody
```java
@RequestBody

●     요청 본문(body)에 들어있는 데이터를 HttpMessageConveter를 통해 변환한 객체로 받아올 수 있다.

●     @Valid 또는 @Validated를 사용해서 값을 검증 할 수 있다.

●     BindingResult 아규먼트를 사용해 코드로 바인딩 또는 검증 에러를 확인할 수 있다.

 

HttpMessageConverter

●     스프링 MVC 설정 (WebMvcConfigurer)에서 설정할 수 있다.

        스프링부트에선 기본적으로 jackson Library가 잡혀있다.

●     configureMessageConverters: 기본 메시지 컨버터 대체

●     extendMessageConverters: 메시지 컨버터에 추가

●     기본 컨버터

              WebMvcConfigurationSupport.addDefaultHttpMessageConverters

 

HttpEntity

●     @RequestBody와 비슷하지만 추가적으로 요청 헤더 정보를 사용할 수 있다.

 

package com.example.demo;

import javax.validation.Valid;

import org.springframework.http.HttpEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventApi {
	
	
	 @PostMapping
	 public Event createEvent(@RequestBody @Valid Event event ,BindingResult bindingResult) {
		
		 if(bindingResult.hasErrors()) {
			 bindingResult.getAllErrors().forEach(error->{
				 System.out.println(error);
			 });
		 }
		 
		 return event; 
     }
	
	
	@PostMapping
	public Event createEvent(@RequestBody HttpEntity<Event> request ) {
		request.getHeaders();
		return request.getBody();
	}

}
 

주로 컨트롤러에서 데이터들을 받을때 json 형태로 받게 되는데

json으로 형식을 특정 객체로 변환하게 하려면 @RequestBody를 사용하면 됩니다.

{"name":"hello","limit":"10"} 을 보내게 되면

event.setName("hello") , event.setLimit("10") 을 자동으로 해주는것이다.

 

HttpEntity는 @RequestBody와 비슷하지만 추가적으로 요청 헤더 정보를 사용할 수 있다.

@RequestBody는 생략가능

 

<Test Code>

 

package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventApiTest {

	@Autowired
	ObjectMapper objectMapper;
    	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void createEvent() throws Exception{
		
		Event event = new Event();
		event.setName("sungwon");
		event.setLimit(20);
		
		String json = objectMapper.writeValueAsString(event);
		
		mockMvc.perform(post("/api/events")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(json))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("name").value("sungwon"));
	}
	
}


출처: https://yoonemong.tistory.com/239 [Sw.Dev]
```

# ResponseBody
```java
 @RequestBody, @ResponseBody 어노테이션을 사용하면 컨트롤러에서 JSON 데이터를 주고받을 수 있습니다.

 

 

@RequestBody로 JSON 정보 받기
JSON 형태의 정보를 Map과 커맨드 객체로 변환하기 위해 jackson 라이브러리를 pom.xml에 입력합니다.

 

pom.xml

<!--JSON-->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.9.3</version>
</dependency>

<dependency>
    <groupId>org.codehaus.jackson</groupId>
    <artifactId>jackson-mapper-asl</artifactId>
    <version>1.9.13</version>
</dependency>
 

Ajax(home.jsp)

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<button onclick="test()" type="button">Ajax</button>

<script>
var obj = {"name": "kim", "age": 30};

function test() {
    $.ajax({
        url: "<c:url value="/test" />",
        type: "post",
        data: JSON.stringify(obj),
        dataType: "json",
        contentType: "application/json",
        success: function(data) {
            alert("성공");
        },
        error: function(errorThrown) {
            alert(errorThrown.statusText);
        }
    });
}
</script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>
 컨트롤러로 요청을 보낼 ajax 함수입니다. 여기서 중요한 점 두 가지는 JSON.stringify 함수를 이용하여 데이터를 
 보내야 된다는 것과 contentType을 "application/json"으로 설정해주어야 한다는 것입니다. 그렇지 않으면 @RequestBody로 
 정보를 받을 수 없습니다. home.jsp를 화면에 띄우고 Ajax 버튼을 눌러 요청을 보내줍니다.

 

JSON을 Map 형태로 변환

@Controller
public class MainController {

    // home.jsp
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
	
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public void init(@RequestBody HashMap<String, Object> map) {
    	System.out.println(map);
    	// {name=kim, age=30} 출력
    }
}
 JSON 정보를 받을 변수를 Map 형태로 선언하고 @RequestBody를 붙여주면 컨트롤러로 전송된 JSON 정보가 자동으로 
 Map으로 변환되어 해당 변수에 저장됩니다. (변수명은 아무렇게나 지어도 상관없습니다.)

 

 

JSON을 객체 형태로 변환

@Controller
public class MainController {

    // home.jsp
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
	
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public void init(@RequestBody UserVO userVO) {
        
    	userVO.getName(); // "kim"
        userVO.getAge(); // 30
    }
}
 이 떄 UserVO 클래스의 프로퍼티는 전송된 JSON 객체와 프로퍼티명이 일치해야 하고 getter, setter 가 있어야 합니다.

@ResponseBody로 JSON 정보 전달하기
 

Map 정보를 전송하기

@Controller
public class MainController {

    // home.jsp
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
	
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public HashMap<String, Object> init(@RequestBody HashMap<String, Object> map) {
    	
        map.put("phone", "0000-0000");
    	return map;
        // {"name": "kim", "age": 30, "phone": "0000-0000"}가 data로 바인딩
    }
}
 @ResponseBody가 붙은 메서드에서 Map을 반환하면 자동으로 Map 정보가 JSON 객체로 변환되어 전송됩니다.

 

객체 정보를 전송하기 

@Controller
public class MainController {

    // home.jsp
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
	
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public HashMap<String, Object> init(@RequestBody UserVO userVO) {
        
    	HashMap<String, Object> map = HashMap<String, Object>();
        map.put("userVO", userVO);
        
        return map;
        // {"userVO": {name: "kim", age: 30}}가 data로 바인딩
    }
}
 객체 정보는 그대로 전송하면 복잡하기 때문에 map 형태로 만들어준 다음 반환하여 전송합니다.
```


# SerializeArray로 받기
```java
	// 패스워드 체크
	@ResponseBody
	@RequestMapping(value="/passChk", method = RequestMethod.POST)
	public int passChk(MemberVO vo) throws Exception {
		int result = service.passChk(vo);
		return result;
	}

회원탈퇴 버튼을 눌렀을때 ajax는 Controller에서 /member/passChk로 요청합니다.

요청을 하면서 $("#delForm").serializeArray()의 값들을 보내줍니다. (Form에 있는 데이터 userId, userPass, userName)

데이터가 보내지고 성공했으면 Controller에서 return한 값 즉 1이 반환이됩니다.

반환한 값은 fucntion의 파라미터 data로 들어가게되며 data가 0이면 패스워드가 틀리고 0이 아니면 회원탈퇴하시겠습니까? 라는 알러트문이 뜨게 됩니다.


memberDeleteView.jsp는 약간의 수정사항이 있으니 이전 포스팅에서 작성한것과 비교하여 진행해주세요.


	$("#submit").on("click", function(){
				if($("#userPass").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#userPass").focus();
					return false;
				}
				$.ajax({
					url : "/member/passChk",
					type : "POST",
					dataType : "json",
					data : $("#delForm").serializeArray(),
					success: function(data){
						
						if(data==0){
							alert("패스워드가 틀렸습니다.");
							return;
						}else{
							if(confirm("회원탈퇴하시겠습니까?")){
								$("#delForm").submit();
							}
							
						}
					}
				})
				
			});
```

# Serialize
```java
Ajax를 사용해서 서버에 데이터를 보낼 때는 Ajax 요청으로 전송할 수 있고 서버가 이해할 수 있는 방식으로 형식을 바꿔야 한다. 
이때 사용하는 방법이 객체 직렬화 이다. 데이터를 직렬화 하면 하나의 객체로 모을 수 잇고 Ajax 요청에서 데이터를 한 덩어리로 보낼 수 있다.
Jquery에서 제공하는 직렬화 메서드는 serialize와 serializeArray 두가지가 있다. serialize는 폼에 있는 모든 필드를 문자열 
하나로 합치는데 문자열을 키/값 쌍을 &문자로 구분한 형태이다. serializeArray 메서드는 키/값 쌍으로 구성된 연고나 배열을 만드는데 
이 배열은 단 하나의 객체일 뿐이지만 serialize 메서드에서 만드는 단순한 문자열보다는 훨씬 잘 구조화 되어있다.

serialize 예>

<form id="exform">
      <input type="text" name="a" value="1"/>
      <input type="text" name="b" value="2"/>
      <input type="hidden" name="c" value="3"/>
</form>

$("#exform").serialize();

결과 : a=1&b=2&c=3

serializeArray 예>

<form id="exform">
      <input type="text" name="a" value="1"/>
      <input type="text" name="b" value="2"/>
      <input type="hidden" name="c" value="3"/>
</form>

$("#exform").serializeArray();

결과 : [{name: "a",value:"1"},{name:"b",value:"2"},{name:"c",value:"}]
```

# RestController
```java
@Controller
public class BBsController {
    // HTTP 요청의 내용을 Bbs 객체에 매핑하기위해 @RequestBody 애너테이션을 설정한다.
  @RequestMapping(value="/bbs/insert", method = RequestMethod.POST)
 @ResponseBody
    public ApiResult bbsInsert(@RequestBody BBsVo bbsVo) {
    ApiResult result = bbsService.insert(bbsVo);
    return result;
    }
}
- @RestController로 컨트롤러로 생성시 @RestController는 리턴값에 자동으로
  @ResponseBody를 붙게되어 HTTP 응답데이터(body)에 자바 객체가 매핑되어 전달되기 때문에 @ResponseBody이 생략가능

※ @Controller인 경우에는 @ResponseBody 한다.)

※ RestApi 설계시 @RequestMapping > @PutMapping로 사용가능하다.

BbsVo.java
@Data 
public class BbsVo {
  private String title; 
  private String contents; 
  private List<Item> items; 
}
 
 

json 서브밋 부분
var params = { 
                title: "제목",
                 contents: "내용",
                 itmes: [
                    {id: "1", code: "11"},
                   {id: "2", code: "22"},
                   {id: "3", code: "33"}
                ] 
            }; 
 
$.ajax({ 
    url: "http://localhost:8080/bbs/insert", 
    method: "post",  //put 가능
    type: "json", 
    data: params, 
    success: function(data) { 
    console.log(data); 
    } 
});


출처: https://devmg.tistory.com/107 [Dev. MG]
```
