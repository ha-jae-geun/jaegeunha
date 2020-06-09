# RequestBody
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
