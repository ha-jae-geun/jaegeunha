# JDBC의 특징
* sql문
* connection 관리
* connection 객체가 db와 app의 연결을 관리하고 preparedstatement가 sql을 전달하며 resulteset 객체를 통해 결과값을 전달한다.

# JPA 장점
1. SQL문을 직접 JAVA APPLICATION 내에서 적을 경우가 적어진다.
2. SQL 구조를 JAVA APPLICCATION 내에서 적용하지 않아도 된다.


## JPA 
* JPA 레파지토리의 save() 메소드 같은 API를 사용한다면 내부적으로 Parameter Binding 을 해주기 때문에 안전하다.
* 하지만 Query String을 사용하다면 절대 안전하지 않다.
