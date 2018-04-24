
---
[TOC]
---

#Development Environment
* window: python, Mac��Ubuntu: python3
* install python -> PC properties -> System settings -> system variable -> edit path -> ;path -> C:\Python34\ -> cmd -> python path
---

#python, Ruby

##Grammar

##���̽� ##���ڿ� ##string
```python
 print(��Hello �� +  :world��)
 print(��Hello �� *3)
 print(��Hello �� [0])
 print(��Hello ��.capitalize())
 print( len(��hello world��))
replace
upcase
\�����ڿ���\
print(��\\��)
*str(number) // when you convert the number to string
```

```ruby
��� ���ڿ�
 ^^ ������; //doesn��t work escape

 puts(��Hello �� +  :world��)
 puts(��Hello �� *3)
 print(��Hello ��.capitalize())
 print(��Hello ��.length()): ���ڿ��� ����
 sub
 upcase
\�����ڿ���\
print(��\\��)
*number.to_s()  // when you convert the number to string
```

---

##���̽� #Variable
```python
*print(x+y)
*title=��python & ruby�� // string variable
*print(���ȳ��ϼ��䡱 +name+���ԡ�)
```

##��� #Variable
```ruby
*print(x+y)
*title=��python & ruby�� // string variable
*print(���ȳ��ϼ��䡱 +name+���ԡ�)

##boolean
```

###���̽� #boolean
```python
*print(True) // first letter end capital
```

###��� #boolean
```ruby
*print(true) // small letter, lower case
```

##���̽� #���ǹ� ##statement
```python
*if condition: / else:  // python doesn��t need end operation. Indent will  distinguish the group
*if condition:  / elif condition: / else: / end
```

##��� #���ǹ�  ##statement
```ruby
*if  condition  end  // if the conditon is true, setence until end will be executed
*if condition  / elsif condition / else / end
```

##���̽� #input
```python
*variable = input(��asdf.��) // input is command, it��s string
*variable = input(variable.upper() + ��asdf.��) // input is command
```


##��� #input
```ruby
*in_str = gets.chomp() | puts(in_str + ��World!��)
```

##���̽� #logical operation // and, or, not
```python
if and/or/not
```

##��� #logical operation // and, or, not
```ruby
*if and/or/not
```


##���̽� #Cheat Sheet  https://opentutorials.org/course/1750/9689
##��� #Cheat Sheet
---------------------

##���̽� annotation
```
*������ ������  // Until next ������, it is string type. But if we don��t store values, we can use it as annotation
```

##��� #annotation
```
*#
*=begin =end // It��s not formal annotation. 2. Toggle Comments in atom
```

##���̽� #container
```python
* [��egoing��, ��leezche��] // Those strings belong to a list
*variable = [����egoing��, ��leezche��] -> print(variable) / print(variable[number]
*egoing[1]= ��busan�� // we can change the value
*// we call element that belongs to container and they have their own index
*��A�� in names
*variable.append
*del(al[0])
```

##��� #Array


##���̽� #type
print(type(variable))

##��� #class
*put(variable.class)


##���̽� #documentation
```python
*python homepage -> documentation: Tutorial / Library Rreference / Language Reference
```

##��� #documentation
```ruby
*ruby homepage ->
*puts(arr[1..4])
 ```


##���̽� #iteration
```python
*while condition:
*break
*while i < len(members):  // you can use this statement in most languages
*for   in list  // more convenient than while
*for item in [0, 1, 2, 3, 4]: // This statement makes program iterate 5 times
*for item in range(5): // range is function
*for item in range (5, 9): // 5 to 9
```

##��� #iteration
```ruby
*while <condition> do   end
*break
*while i < members.length
*for  in list do
*for item in (0..10) do  <statement>  end
```

##���̽� #function = function
```python
*def <function name>():
*def <function name>(): return; // after return function, function is over immediately
*def <function name>(parameter):  print(parameter)
```

##��� #function
```ruby
*def <function name>()  end
```


##���̽� #package manager; #pypi.python.org

---

##��� #pacakge manager;  #rubygems.org
* type gem in cmd

---

##���- python -> documentation -> Library Reference
```python
  $Grouping functions linked to each other
python
*math; import math
*from egoing import a as z-> print(z())  // In this case, you don��t have to write egoing
```

##Ruby module
```ruby
*// you don��t have to declare import, because it contains it
```
---

##Mixin
###python


####Ruby
* It doesn��t offer #multi inheritance, but ruby supports mixin
* include module // you can��t include class, just module

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
