# 두 수 입력받고 더하기
```python
a,b = input().split()
a = int(a)
b = int(b)
print(a+b)
cs
```
* Python의 경우 입력받을 때 디폴트로 문자로 인식하여 받게 되기에 이 과정을 거쳐 a와 b가 정수형임을 알려줘야 합니다.

# 두 수 나누기
```python
a,b = input().split()
a = int(a)
b = int(b)
print(a+b)
print(a-b)
print(a*b)
print(int(a/b))
#print(a//b)
print(a%b)
```
*  파이썬의 경우 정수 둘을 나누고 떨어지지 않을 때 자동으로 float형으로 출력하여 줍니다. 하지만 예제 출력을 보면 둘을 나눴을 때도 int 형으로 출력하여야 하기에 7번 라인과 8번 라인처럼 출력하여주면 됩니다.

# 빠른 출력
```python
import sys

for i in range(int(sys.stdin.readline())):
    numA, numB = map(int, sys.stdin.readline().split(' '))
    print(numA + numB)
```
* Python을 사용하고 있다면, input 대신 sys.stdin.readline을 사용할 수 있다. 단, 이때는 맨 끝의 개행문자까지 같이 입력받기 때문에 문자열을 저장하고 싶을 경우 .rstrip()을 추가로 해 주는 것이 좋다.
* 또한 입력과 출력 스트림은 별개이므로, 테스트케이스를 전부 입력받아서 저장한 뒤 전부 출력할 필요는 없다. 테스트케이스를 하나 받은 뒤 하나 출력해도 된다.
* str 형태로 리스트에 저장하려면 input().split()을, int 형태로 리스트에 저장하려면 list(map(int, input().split()))을 하면 됩니다.