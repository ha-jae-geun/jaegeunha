# 경로 설정
```java
@RequestMapping("/board/view") // 요청경로(path)
그리고, return 값도 똑같이 board/view로 설정 한다.

return "board/view";  // 뷰페이지 이름


```

# 모델 사용
```java
Model 객체를 파라미터로 받아서 데이터를 뷰로 넘길 수 있다.

@RequestMapping("/board/view")
public String view(Model model) {
    
    // 데이터만 설정이 가능
    model.addAttribute("id", "hongku");
    
    return "board/view";
}
 
Model 객체를 파라미터로 받는다.

model.addAttribute("변수이름", "변수에 넣을 데이터값");
 

model.addAttribute를 이용해서, 넘길 데이터의 이름과 값을 넣는다.

그러면, 스프링은 그 값을 뷰쪽으로 넘겨준다.

 

${변수이름}
 

뷰(.jsp 파일)에서는 ${}를 이용해서 값을 가져온다.

 

예를들어,

당신의 ID는 ${id} 입니다.


출처: https://hongku.tistory.com/116 [IT에 취.하.개.]
```


# ModelAndView
```java
Model 객체와 크게 다르지 않다.

@RequestMapping("/board/content")
public ModelAndView content() {

    // 데이터와 뷰를 동시에 설정이 가능
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/board/content"); // 뷰의 이름
    mv.addObject("data", "12341234"); // 뷰로 보낼 데이터 값
    
    return mv;
}
 

반환값으로 ModelAndView 객체를 반환한다.

 

ModelAndView 객체를 선언 및 생성한다.

 

뷰의 이름을 설정해줘야 하는데,

setViewName() 메소드를 이용한다.

mv.setViewName("뷰의 경로");
 

데이터를 보낼때는

addObject() 메소드를 이용한다.

mv.addObject("변수 이름", "데이터 값");
 

그리고,

return mv;
 

ModelAndView 객체를 반환한다.

 

jsp도 똑같이 ${}를 이용한다.

Data : ${data}

```
