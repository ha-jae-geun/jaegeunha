
---
[TOC]
---

#Development Environment
* window: python, MacㆍUbuntu: python3
* install python -> PC properties -> System settings -> system variable -> edit path -> ;path -> C:\Python34\ -> cmd -> python path
---

#python, Ruby

##Grammar

##파이썬 ##문자열 ##string
```python
 print(‘Hello ‘ +  :world’)
 print(‘Hello ‘ *3)
 print(‘Hello ‘ [0])
 print(‘Hello ‘.capitalize())
 print( len(‘hello world’))
replace
upcase
\”문자열”\
print(“\\”)
*str(number) // when you convert the number to string
```

```ruby
루비 문자열
 ^^ ‘’는; //doesn’t work escape

 puts(‘Hello ‘ +  :world’)
 puts(‘Hello ‘ *3)
 print(‘Hello ‘.capitalize())
 print(‘Hello ‘.length()): 문자열의 개수
 sub
 upcase
\”문자열”\
print(“\\”)
*number.to_s()  // when you convert the number to string
```

---

##파이썬 #Variable
```python
*print(x+y)
*title=”python & ruby” // string variable
*print(“안녕하세요” +name+“님”)
```

##루비 #Variable
```ruby
*print(x+y)
*title=”python & ruby” // string variable
*print(“안녕하세요” +name+“님”)

##boolean
```

###파이썬 #boolean
```python
*print(True) // first letter end capital
```

###루비 #boolean
```ruby
*print(true) // small letter, lower case
```

##파이썬 #조건문 ##statement
```python
*if condition: / else:  // python doesn’t need end operation. Indent will  distinguish the group
*if condition:  / elif condition: / else: / end
```

##루비 #조건문  ##statement
```ruby
*if  condition  end  // if the conditon is true, setence until end will be executed
*if condition  / elsif condition / else / end
```

##파이썬 #input
```python
*variable = input(“asdf.”) // input is command, it’s string
*variable = input(variable.upper() + “asdf.”) // input is command
```


##루비 #input
```ruby
*in_str = gets.chomp() | puts(in_str + “World!”)
```

##파이썬 #logical operation // and, or, not
```python
if and/or/not
```

##루비 #logical operation // and, or, not
```ruby
*if and/or/not
```


##파이썬 #Cheat Sheet  https://opentutorials.org/course/1750/9689
##루비 #Cheat Sheet
---------------------

##파이썬 annotation
```
*’’’ ‘’’  // Until next ‘’’, it is string type. But if we don’t store values, we can use it as annotation
```

##루비 #annotation
```
*#
*=begin =end // It’s not formal annotation. 2. Toggle Comments in atom
```

##파이썬 #container
```python
* [‘egoing’, ‘leezche’] // Those strings belong to a list
*variable = [‘‘egoing’, ‘leezche’] -> print(variable) / print(variable[number]
*egoing[1]= ‘busan’ // we can change the value
*// we call element that belongs to container and they have their own index
*’A’ in names
*variable.append
*del(al[0])
```

##루비 #Array


##파이썬 #type
print(type(variable))

##루비 #class
*put(variable.class)


##파이썬 #documentation
```python
*python homepage -> documentation: Tutorial / Library Rreference / Language Reference
```

##루비 #documentation
```ruby
*ruby homepage ->
*puts(arr[1..4])
 ```


##파이썬 #iteration
```python
*while condition:
*break
*while i < len(members):  // you can use this statement in most languages
*for   in list  // more convenient than while
*for item in [0, 1, 2, 3, 4]: // This statement makes program iterate 5 times
*for item in range(5): // range is function
*for item in range (5, 9): // 5 to 9
```

##루비 #iteration
```ruby
*while <condition> do   end
*break
*while i < members.length
*for  in list do
*for item in (0..10) do  <statement>  end
```

##파이썬 #function = function
```python
*def <function name>():
*def <function name>(): return; // after return function, function is over immediately
*def <function name>(parameter):  print(parameter)
```

##루비 #function
```ruby
*def <function name>()  end
```


##파이썬 #package manager; #pypi.python.org

---

##루비 #pacakge manager;  #rubygems.org
* type gem in cmd

---

##모듈- python -> documentation -> Library Reference
```python
  $Grouping functions linked to each other
python
*math; import math
*from egoing import a as z-> print(z())  // In this case, you don’t have to write egoing
```

##Ruby module
```ruby
*// you don’t have to declare import, because it contains it
```
---

##Mixin
###python


####Ruby
* It doesn’t offer #multi inheritance, but ruby supports mixin
* include module // you can’t include class, just module

---
##OOP
* string class
  - name1 = String.new('jaegeun')
  - Correspondence: function-logic, variable-data


---

##memory
  python
* Tips for memory
  + avoid string concatenation -> use map function
  + use a little scope as possible -> using with
* python's variable has memory address
  + id function is similar to pointer funcion in C
*  is vs == //
  1. == is faster than --
  2. is operation can't use override function


**copy**
copy.copy()
* same function as [:], .copy()
copy.deepcopy()
* allocate new object
Singleton
* share the same memory address in every instance
String interning
* store string once in memory


**Empty memory**
* del_keyword
  + remove the variables  
* Reference count
* Garbage Collection
* module 'weakref'
* Monkey patch
