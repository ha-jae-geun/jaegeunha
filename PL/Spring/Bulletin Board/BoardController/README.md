# list

```java

이제 BoardController로 들어와서 URL은 /list로 정하고 

오라클 > 다오 > 서비스 > 컨트롤러로 가져온 데이터들을 jsp에 뿌려주는 작업을 해야 합니다.

model은 데이터를 담을 그릇이고 addAttribute("list", service.list())는 


 
service.list()에 담긴 데이터를 "list"라는 이름으로 담을것이다 라는 뜻으로 해석하시면됩니다. 

	// 게시판 목록 조회
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		logger.info("list");
		
		model.addAttribute("list",service.list());
		
		
		return "board/list";
		
	}
  ```
