# [테코톡_DTO](https://www.youtube.com/watch?v=EeJnNaiMy3U&list=PLgXGHBqgT2TvpJ_p9L_yZKPifgdBOzdVH&index=55)
# [테코톡 DTO/VO2](https://www.youtube.com/watch?v=J_Dr6R0Ov8E&list=PLgXGHBqgT2TvpJ_p9L_yZKPifgdBOzdVH&index=10)

# DTO(Data Transfer Object)
* 레이어 간 데이터를 전달하는 객체

## 특징
* 데이터 접근 메서드 외에 기능을 가지지 않는다.
    * 정렬, 직렬화 등 데이터 표현을 위한 기능을 가질수는 있음
* 데이터의 캡슐화를 통해 유연한 대응이 가능하다.
    * 데이터 요청 수 감소 효과

# VO(Value Object)
* 값을 가지는 객체

## 특징
* 값 자체로 의미를 가지는 객체
* 변하지 않는 값을 가지는 객체
    * 값이 변하지 않음을 보장하며 코드의 안정성과 생산성을 높임
 * 값이 같다면 동일한 객체
    * 각 객체를 비교하는 데 사용되는 ID가 없음
    * 같은 객체인지 판단하기 위해 각 속성들의 값을 비교함
         * equals()와 hashCode()의 오버라이드가 필요
 
 # Entity를 DTO 대신
 * 사용할 수 있ㄴ지만 View에서 표현하는 속성 값들이 요청에 따라 계속 달라질 수 있는데, 그때마다 
   entity 속성값을 변경하면 영속성 모델을 표현한 entity의 순수성이 모호해지기 때문에 controller에서 쓸 DTO와 Entity클래스는 분리하는 것이 좋다.
    
 # 공통점
 * 레이어 간 데이터를 전달할 때 사용 가능
    * VO는 불변을 보장하기 때문에 데이터 전달 용도로 사용 가능
    
 # 차이점
 * DTO는 레이어 간의 데이터 전송 <> VO는 의미 있는 값을 표현 <> entity는 DB테이블과 매핑되는 클래스
 * DTO는 값이 변할수 있음 <> 변할 수 없음
 * DTO는 레이어와 레이어 사이에서 사용 <> 모든 레이어에서 사용 가능
 * DTO dto1(1) != DTO dto2(1)    <>  Vo vo(1) = Vo vo2(1)
 * 데이터 접근 이외의 기능을 가지지 않는다. <> 특정한 비즈니스 로직을 가질 수 있음 <> entity도 로직을 포함할 수 있다.
 * DTO는 가변객체(생성 후 상태를 변경할 수 있다 <> VO는 불변 객체 <> entity는 가변객체
  
