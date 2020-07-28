# [SqlInjection이란?](https://www.youtube.com/watch?v=qzas_-u4Nxk&list=PLgXGHBqgT2TvpJ_p9L_yZKPifgdBOzdVH&index=21)
* 데이터 베이스와 연동된 웹 애플리케이션에서 공격자가 입력이 가능한 폼에 조작된 질의문을 삽입하여 웹 서비스의 데이터 베이스 정보를 열람 또는 조작할 수 있는 취약점


# 방어하는 법
* Query String을 절대 사용하지 말아라!
* Parameter Binding

# Statement와 PreparedStatement
* Parameter Binding 방식을 사용하지 않는 Statement 객체
* Parameter Binding 방식을 지원 하는 PreparedStatement 객체

## PreparedStatement
* PrepareStatement의 SetString 메서드 내부에 isExcapeNeedForString에서 Parameter Binding 제공
  * 입력값을 하나씩 돌면서 Escape 해야 할 문자열이 있다면 적절한 문자열을 추가해준다.
  
  
## PHP의 $mysqli_real_escape_string
* escape_String 

## JPA
* JPA 레파지토리의 save() 메소드 같은 API를 사용한다면 내부적으로 Parameter Binding 을 해주기 때문에 안전하다.
* 하지만 Query String을 사용하다면 절대 안전하지 않다.
