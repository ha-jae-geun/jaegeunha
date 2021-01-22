# 주파수
```java
2. 다음 <조건>을 가장 만족하는 초당 표본추출(sampling)
횟수는?

< 조 건 >

◦ 디지털 신호로 변환하기 위한 아날로그 음성 신호의
최대 주파수는 4 KHz이다.
◦ 표본추출된 디지털 신호를 아날로그 신호로 다시 변
환할 경우 원래의 아날로그 음성 신호로 복원되어
야 한다.
1 1000 2 2000
3 4000 4 8000

답 4

아날로그 주파수 하나는 위 그림처럼 최댓값과 최솟값을 오르락내
리락한다.
이 주파수를 디지털로 표기하기 위해서는 최소한 최댓값 1개과
최솟값 1개, 총 2번의 표본추출이 필요하다.
문제에서 아날로그 주파수가 4KHz인데, 이는 1초에 4000번 오
르락내리락하는 변동을 한다는 의미이다. (K는 10^3을 의미)
따라서 디지털로 변환하기 위해 최소 4000 × 2 = 8000 번을 표
본추출해야 한다.
```