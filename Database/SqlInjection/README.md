# SqlInjection이란?
* 데이터 베이스와 연동된 웹 애플리케이션에서 공격자가 입력이 가능한 폼에 조작된 질의문을 삽입하여 웹 서비스의 데이터 베이스 정보를 열람 또는 조작할 수 있는 취약점


# 방어하는 법
* Parameter Binding

# Statement와 PreparedStatement
* Parameter Binding 방식을 사용하지 않는 Statement 객체
* Parameter Binding 방식을 지원 하는 PreparedStatement 객체

## PreparedStatement
* PrepareStatement의 SetString 메서드 내부에 isExcapeNeedForString에서 Parameter Binding 제공
  * 입력값을 하나씩 돌면서 Escape 해야 할 문자열이 있다면 적절한 문자열을 추가해준다.
  
  
## PHP의 $mysqli_real_escape_string
* escape_String 
