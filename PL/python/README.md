Reference: [Life Coding](https://opentutorials.org/course/1750/9689)
  [Pycharm](https://www.jetbrains.com/pycharm/)
  [Ruby](https://www.jetbrains.com/ruby)
  [python common mistake](http://hamait.tistory.com/851?category=79136)

 
[목차]
* 1. [Development](##Development)
* 2. [Grammar](##Grammar)


# strength(Guido van Rossum)
* simple syntax
* have a lot of libraries
* dynamic typing = type 
* can access to object's member whenever i want
* slower than c, c++(make native binary file)
* git can operate fast
* have garbage collector and support unicode


---

---

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
