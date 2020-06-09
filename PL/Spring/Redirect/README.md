# RedirectAttributes
```java
RedirectAttributes

폼 형식의 문서를 작성 후, 서버로 보내면(POST 방식) 곧이어 다른 페이지로 리다이렉트 한다. 문제는 이러한 리다이렉트 방식이 
GET 방식​ 이라 데이터 전송에는 적절하지 않다.

리다이렉트의 특징은 다음 그림과 같다. spitter객체를 보내려고 한다.

리다이렉트가 발생하면 원래 요청은 끊어지고, 새로운 HTTP GET 요청이 시작된다.(브라우저에게 이 URL로 리다이렉트해!)  
때문에 리다이렉트 실행 이전에 수행된 모델 데이터는 소멸한다. 따라서 리다이렉트로 모델을 전달하는 것은 의미 없다.

그러나 리다이렉트 방법으로도 데이터를 전달하는 방법이 있다. GET의 특징을 사용하는 것이다.

리다이렉트는 HTTP GET 메소드 방식이라고 앞서 말했다. GET방식은 아래 그림처럼 header에 ? 뒤에 파라미터를 붙여서 전달한다. 
때문에 URL에 노출되는 단점이 있다.

그래서 스프링은 RedirectAttributes 클래스를 제공한다. 이 클래스는 모델의 기능을 그대로 확장(extends)했으며, 
몇개의 도움 메소드가 추가됐다. 여담으로 클래스 내부 소스를 보려고 했지만 캡슐화되서 볼 수 없었다..ㅠㅠ

공부하기 위해서 검색으로 이에 대해 설명한 국내 여러 블로그를 보니 대부분이 RedirectAttributes가 POST 방식으로 
전달한다고 설명했다. 아무래도 URL 뒤에 파라미터가 안 붙어서 POST 방식으로 전달하나 생각했나 보다. 하지만 POST 방식은 아니다. 
겉으로만 그렇게 보일 뿐인데 POST와 연관 짓는 건 이건 좀 아닌 듯 싶다. 애초에 return redirect가 GET으로 가는데 말이 안되지. 
리다이렉트 자체가 POST/Redirect/GET 패턴인데....

RedirectAttributes는 아래 그림처럼 리다이렉트가 발생하기 전에 모든 플래시 속성을 세션에 복사한다. 
리다이렉션 이후에는 저장된 플래시 속성을 세션에서 모델로 이동시킨다. 헤더에 파라미터를 붙이지 않기 때문에 URL에 노출되지 않는다.


RedirectAttributes가 제공하는 메소드 addFlashAttribute()

addFlashAttribute() 는 리다이렉트 직전 플래시에 저장하는 메소드다. 리다이렉트 이후에는 소멸한다.


이러한 문제를 Spring 3.1 버전에 추가된 RedirectAttributes 클래스를 통해 해결할 수 있다. 
RedirectAttributes 인터페이스는 기존의 Model 인터페이스를 확장한 것이다.


1
public interface RedirectAttributes extends Model {}
cs

리다이렉트시 파라미터도 넘겨진다.

@RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registPOST(BoardVO board, Model model) throws Exception{
        
        service.regist(board);
        model.addAttribute("result","success");
        
        return "redirect:/board/listAll";
    }
Colored by Color Scripter
cs
 

URL에 노출되는 파라미터. ? 뒤가 지저분하다. 그리고 보안에도 취약하다.
 

addFlashAttribute() 메소드 사용


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception{
        
        service.regist(board);
        
        rttr.addFlashAttribute("msg","success");
        return "redirect:/board/listAll";
    }
Colored by Color Scripter
cs

header가 아닌 세션을 통해 전달하므로 ? 뒤에 파라미터가 안 보인다. 
```
