# [엘리 코딩](https://www.youtube.com/watch?v=OCCpGh4ujb8&list=PLv2d7VI9OotTVOL4QmPfvJWPJvkmv6h-2&index=3)


# 'user strict';
* 선언되지 않은 변수 사용 금지

# let
(read/write) 가능
* var 단점 때문에 let 사용

# var
1. hoisting(move declaration from bottom to top)
  * 선언이 나중에 가능
2. no block scope
  * 지역변수 사용 불가능
  
# const
* read만 가능
1. 보안
  * 외부에서 변수 변경 불가능

2. thread safety

3. reduce human mistakes



# type
## primitive type
* number
  * 정수, 실수 구분 필요 없음
  * 범위(-2**53) ~ 2*53
    * bigInt(최근에 생김, 크롬이랑 파이어폭스에서만 지원)
  * infinity: 1/0
  * negativeInfinity: -1 / 0
  * nAn: 숫자 아닌 값 / 숫자
* string
  * char, string 구분 없음
  * 'hello' + 변수
* boolean
* null
  * 비어있는 값을 내가 설정한 경우
* undefined
  * 선언 되었지만 비어있는 값
* symbol
  * 고유한 식별자
  * const symbol1 = Symbol('id')
  * const symbol2 = Symbol('id))
    * 둘이 다른값
  * console.log('value: ${symbol1.description}')

## object
* object
 * 변수명은 reference를 가지고 그게 object 내용을 가르킴
* function


# dynamically typed language
* typescript의 필요성