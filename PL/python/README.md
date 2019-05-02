Reference: [Life Coding](https://opentutorials.org/course/1750/9689)
  [Pycharm](https://www.jetbrains.com/pycharm/)
  [Ruby](https://www.jetbrains.com/ruby)
  [python common mistake](http://hamait.tistory.com/851?category=79136)

# 파이썬 설치
 * 아직까지 3.6버전까지 머신러닝 지원
 * Windows x86-64 web-based installer // 나중에 웹에서 다운받아야 함
 * Windows x86-64 executable installer
 * Windows x86-64 embeddable zip file // 나중에 환경변수 지정 필요
- Add Python 3.6 to Path: 환경 변수 자동 설정해줌
- Advanced Options: 전부 체크

# 정확도와 속도 차이
## 논리 연산자
- 자바에서는 속도 때문에 &&   ||  등 2개 짜리를 권장한다.
- &&는 앞이 거짓이면 뒤 검증 안함, || 도 앞이 참이면 뒤 검증 안함.

## switch 문
* 비순차적 문장
 * 머신러닝 같이 데이터 검출을 목표로 할 때는 if 문을 쓰는 것이 맞다. 순차적으로 모두 확인해야 한다.
 * :(영역 변경) 뒤에 {} 생략 가능; 파이썬 방식

# 파이썬과 자바
## void
- -자바와 다르게 파이썬은 함수를 제외하고 모든 메소드는 기본적으로 void 형이다. return을 쓰는 함수, void를 쓰는 메소드 2가지 사용한다.

# 주석
- #
- """ """

# _
## _식별자
- 선행 싱글 언더스코어는 한 모듈 내부에서만 사용하는 private 접근 제한자를 선언할 때 사용하는 규약이다. 파이썬에서는 실질적인 private 접근 제한자을 지원하고 있지는 않기 때문에 private 접근 제한자를 완전히 강제할 수는 없지만 직접 가져다 쓰거나 호출을 할 경우엔 사용이 가능하다. from 모듈 import * 절로 임포트를 하면은 싱글 언더스코어로 시작하는 것들은 모두 임포트에서 무시된다.

# 식별자
- 후행 싱글 언더스코어는 파이썬의 키워드와의 충돌을 피하기 위해 사용하는 규약이다. 

# __식별자
- 선행 더블 언더스코어는 규약이라기보다는 하나의 문법적인 요소이다. 선행 더블 언더스코어는 클래스 속성명을 맹글링하여 클래스 간 속성명의 충돌을 방지하기 위한 용도로 사용된다. 맹글링은 컴파일러나 인터프리터가 객체와 함수명을 그대로 사용하지 않고 일정한 규칙에 의해 변형시키는 것을 말한다. 선행 더블 언더스코어로 지정된 속성명은 맹글링이 되기 때문에 일반적인 접근 방식으로는 접근이 되지 않으므로 선행 더블 언더스코어를 사용해 private 접근 제한자처럼 강제하는 경우가 있는데 이런 방식으로 사용하는 것을 권장하지 않는다.  ④ 

# __식별자__
- 선행후행 더블 언더스코어는 특별한 객체나 특별한 메소드에 사용되는 규약이다. 선행후행 더블 언더스코어로 선언된 ˍˍinitˍˍ 메소드와 같은 특별 메소드는 특정한 문법적 기능을 제공하거나 특정한 일을 수행한다. 

# 파이썬 논리연산자
- (a==10) & (b==5)  // ()는 강제 형변환; 잘 사용 안함
- and, or, not 을 논리 연산자로 쓰고  &는 보통 비트 연산자로 사용한다.


# strength(Guido van Rossum)
* simple syntax
* have a lot of libraries
* dynamic typing = type 
* can access to object's member whenever i want
* slower than c, c++(make native binary file)
* git can operate fast
* have garbage collector and support unicode


# 파이썬 자료형
 * 원시 자료형: 직접 접근
 * 수치 타입
 * 정수타입: byte, short, int, long, char(자판기; 쓰면 아스키코드로 바뀜)
 * 기본형은 int 형
 * 부동 소수점: float, double
 * 기본이 double이라 float형은 f 붙여 주어야 함.
 * 불리언 타입
 * 원시 자료형은 크기가 작고 고정적이기 때문에 메모리의 스택에 저장이 된다.
 * 자바에서는 원시 타입을 제외하고는 다 참조다. 하지만 파이썬, R은 다 참조다.(원시타입이 존재하지 않는다.)
 * 2진수, 8진수, 10진수(올림형), 16진수로 표현 가능하고, 정수형 중 음수는 보수를 사용한다.
 *   -  3.6버전에 신경망 알고리즘 등 대다수 존재, 3.7부터는 _ 공백 문자 등이 등장했지만 알고리즘 지원 안함


# Development Environment
* window: python, Mac¤ýUbuntu: python3
* install python -> PC properties -> System settings -> system variable -> edit path -> ;path -> C:\Python34\ -> cmd -> python path
---

# python, Ruby

## Grammar

## string
```python
 print(¡®Hello ¡® +  :world¡¯)
 print(¡®Hello ¡® *3)
 print(¡®Hello ¡® [0])
 print(¡®Hello ¡®.capitalize())
 print( len(¡®hello world¡¯))
replace
upcase

*str(number) // when you convert the number to string
```

```ruby
·python 
   //doesn¡¯t work escape

 puts(¡®Hello ¡® +  :world¡¯)
 puts(¡®Hello ¡® *3)
 print(¡®Hello ¡®.capitalize())
 print(¡®Hello ¡®.length()): 
 sub
 upcase
print()
*number.to_s()  // when you convert the number to string
```

---

## #Variable
```python
*print(x+y)
*title=¡±python & ruby¡± // string variable
*print()
```

## python #Variable
```ruby
*print(x+y)
*title=¡±python & ruby¡± // string variable

## boolean
```

###  #boolean
```python
*print(True) // first letter end capital
```

### python #boolean
```ruby
*print(true) // small letter, lower case
```

## ##statement
```python
*if condition: / else:  // python doesn¡¯t need end operation. Indent will  distinguish the group
*if condition:  / elif condition: / else: / end
```

## python  ##statement
```ruby
*if  condition  end  // if the conditon is true, setence until end will be executed
*if condition  / elsif condition / else / end
```

## #input
```python
*variable = input() // input is command, it¡¯s string
*variable = input(variable.upper() + ¡°asdf.¡±) // input is command
```


## python #input
```ruby
*in_str = gets.chomp() | puts(in_str + ¡°World!¡±)
```

## #logical operation // and, or, not
```python
if and/or/not
```

## python #logical operation // and, or, not
```ruby
*if and/or/not
```


### Cheat Sheet  https://opentutorials.org/course/1750/9689
## python #Cheat Sheet
---------------------

## annotation
```
*¡¯¡¯¡¯ ¡®¡¯¡¯  // Until next ¡®¡¯¡¯, it is string type. But if we don¡¯t store values, we can use it as annotation
```

## python #annotation
```
*#
*=begin =end // It 8=is not formal annotation. 2. Toggle Comments in atom
```

### container
```python
* [¡®egoing¡¯, ¡®leezche¡¯] // Those strings belong to a list
*variable = [¡®¡®egoing¡¯, ¡®leezche¡¯] -> print(variable) / print(variable[number]
*egoing[1]= ¡®busan¡¯ // we can change the value
*// we call element that belongs to container and they have their own index
*variable.append
*del(al[0])
```




## def

```python
  *def__init__(self, variable): // variable is local bariable
    #self.v1 = v1 // self means instance
```

* In python, we can approach instance directly
* Reason why we use object

### getValue(self)
    *return self.value

### Array
* push
* join

### type
  print(type(variable))

### class
* put(variable.class)
* isinstance  // check out if its internal class
    #if isinstance(v1, int):
  
## object
* add
* subtract

### documentation
```python
*python homepage -> documentation: Tutorial / Library Rreference / Language Reference
```

## python #documentation
```ruby
*ruby homepage ->
*puts(arr[1..4])
 ```


### iteration
```python
*while condition:
*break
*while i < len(members):  // you can use this statement in most languages
*for   in list  // more convenient than while
*for item in [0, 1, 2, 3, 4]: // This statement makes program iterate 5 times
*for item in range(5): // range is function
*for item in range (5, 9): // 5 to 9
```

## python #iteration
```ruby
*while <condition> do   end
*break
*while i < members.length
*for  in list do
*for item in (0..10) do  <statement>  end
```

## #function = function
```python
*def <function name>():
*def <function name>(): return; // after return function, function is over immediately
*def <function name>(parameter):  print(parameter)
```

## python #function
```ruby
*def <function name>()  end
```


## #package manager; #pypi.python.org

---

## python #pacakge manager;  #rubygems.org
* type gem in cmd

---

## python -> documentation -> Library Reference
```python
  $Grouping functions linked to each other
python
*math; import math
*from egoing import a as z-> print(z())  // In this case, you don¡¯t have to write egoing
```

## Ruby module
```ruby
*// you don¡¯t have to declare import, because it contains it
```
  ---

## Mixin
### python


### Ruby
* It doesn¡¯t offer #multi inheritance, but ruby supports mixin
* include module // you can¡¯t include class, just module

---
## OOP
* string class
  - name1 = String.new('jaegeun')
  - Correspondence: function-logic, variable-data


---

## memory
  python
* Tips for memory
  + avoid string concatenation -> use map function
  + use a little scope as possible -> using with
* python's variable has memory address
  + id function is similar to pointer funcion in C
*  is vs == //
  1. == is faster than --
  2. is operation can't use override function


## copy
copy.copy()
* same function as [:], .copy()
copy.deepcopy()
* allocate new object
Singleton
* share the same memory address in every instance
String interning
* store string once in memory


  ##Empty memory
* del_keyword
  + remove the variables  
* Reference count
* Garbage Collection
* module 'weakref'
* Monkey patch
