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

## 문제2
```java
다음의 C프로그램을 실행한 결과로 옳은 것은?  3번
#include <stdio.h>
void main() {
 int num[4] = {1, 2, 3, 4 };
  int *pt = num;
  pt++;
  *pt++ = 5;
  *pt ++= 10;
  pt--;
  *pt +++= 20;
 printf("%d %d %d %d", num[0], num[1], num[2], num[3]);
}
①	1 5 10 20	 	②	1 5 20 4
③	1 5 30 4		④	에러 발생


∙ int *pt = num; ⇒ 포인터 변수 pt에 num 배열의 시작 주소를 저장
∙ pt++; ⇒ pt 변수 값이 1증가되므로 num 배열의 1번지 주소를 기억하게 됨
∙ *pt++ = 5; ⇒ num 배열 1번지에 5를 저장하고 포인터 변수 pt는 1증가되어 num배열의 2번지 주소를 기억하게 됨
∙ *pt ++= 10; ⇒ num 배열 2번지에 10을 저장하고 포인터 변수 pt는 1증가되어 num배열의 3번지 주소를 기억하게 됨
∙ pt--; ⇒ 포인터 변수 pt의 값이 1 감소되므로 num배열의 2번지 주소를 기억하게 됨
∙ *pt +++= 20; ⇒ (*pt++) += 20 이 되므로 2번지의 값 10에 20을 더해서 30을 저장하고 포인터 변수 pt는 1 증가하여 3번지 주소를 기억하게 됨

```
