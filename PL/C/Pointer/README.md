# 포인터 문제
```java
다음 C 프로그램의 실행 결과는?
#include<stdio.h>
int main()
{
  char* array1[2]= {"Good morning", "C language" };
  printf("%s ￦n", array1[0]+5);
  printf("%c ￦n", *(array1[1]+6));
  return 0;
}
① Good mornin    C-language
② morning      a
③ morning      g
④ morning      u



C언어는 문자열을 처리하지 못하므로 문자열 배열을 활용
array1[0]는 첫 번째 요소인 “Good morning”의 ‘G’를 가리킴
array1[1]는 두 번째 요소인 “C language”의 시작 지점인 ‘C’를 가리킴
 
printf("%s ￦n", array1[0] + 5);
⇒ array1[0] + 5는 array1배열의 첫 번째 요소의 첫 번째 글자인 G에서 5개 떨어진 공간이므로 m을 가리킴
%s로 문자열 출력을 지정하였으므로 m부터 해당 문자열 끝까지 출력하므로, morning 출력

printf("%c ￦n", *(array1[1] + 6));
⇒ *(array1[1] + 6)은 array1배열의 두 번째 요소의 첫 번째 글자인 C에서 6개 떨어진 공간이므로 u를 가리킴
%c는 문자 출력지정으로 한 글자만 출력하므로 u를 출력
```
