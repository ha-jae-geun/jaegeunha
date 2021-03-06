# 자료구조
* 자료구조: 자료를 저장하는 구조
* 알고리즘: 탐색

# [스택, 큐, 링크드리스트 기술 인터뷰 자료](https://www.notion.so/d3ceaae500eb4164ae46b87c18aea257)
# [트리 기술 인터뷰 자료](https://www.notion.so/Tree-b5cdac1f2aa04b42be58b1d221f60006)
# [Heap, Sort, Hash Table 기술인터뷰 자료](https://www.notion.so/Heap-Sort-Hash-Table-333efb4921544a73a27efcdb2a7788d3)

# 함수형 프로그램
1. 인풋과 아웃풋이 있다.
2. 외부 환경으로부터 철저히 독립적이다.
3. 가튼 인풋에 있어서 언제나 동일한 아웃풋을 생산한다.

## 특징
1. 함수형 프로그래밍은 선언형이다.
2. 함수도 값이다; 
   * 자바 스크립트에서 함수값을 변수에 넣음
3. 고계함수
4. 커링
5. 함수 

# 순서도
## 증감문
* 증감문이 위면 < 아래면 <=

# for문
- for( 식1 ; 조건1 ; 식2)
{
   코드 1
}

## 정답
- 식1 수행 --> 조건1 검사 --> 코드1 수행 --> 식2 수행 --> 조건1 검사 --> 코드1 수행 --> 식2 수행 --> 조건1 검사 …

## 오답
- 식1 수행 --> 조건1 검사 --> 코드1 수행 --> 조건1 검사 --> 식2 수행 --> 코드1 수행 --> 조건1 검사 --> 식2 수행 .




 
# 해싱
* 데이터 -> 해싱함수 -> 해시 테이블(인덱스, 값으로 이루어져 있음)
* 같은 값이 해싱되면 같은 값으로 
 
# 재귀함수
```C
#include <stdio.h>
#include<math.h>
int recursive(int n) {
   int i;
   if (n < 1) { return 2; }
   else
   {
      i = (2 * recursive(n - 1)) + 1;
      printf("%d\n", i);
      return i;
   }
}




void main() {
   int i;
   printf("숫자를 입력하시오");
   scanf_s("%d", &i);
   recursive(i);


}
//5 11 23 47 95
``` 


