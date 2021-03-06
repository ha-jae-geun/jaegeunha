# 백준

# BFS
* 큐를 이용해서 메모리를 힙에 넣고 빼고 크기 조정 없기 때문에 유리
* 어떤 대상을 조건에 맞게 동작하도록 코드 구현

# DFS
* 스택 이용해서 사용; 크기 조정 필요하기 때문에 BFS에 비해 복잡
* 모든 경우를 만들어 보는 경우

# 백준
## 완전 탐색(Brute-force Search)  [bruːt]  
1. brute force; for문과 if문을 이용하여 처음부터 끝까지 탐색하는 방법
2. 비트마스크
  * 더 빠른 수행 시간
* 더 간결한 코드
* 더 작은 메모리 사용량
  * 연관 배열을 배열로 대체 : map <vector<bool>, int>를 비트마스크를 써서 int[]로 나타낼 수 있다. 큰 시간과 메모리 차이를 불러온다.
3. 순열: - n개의 원소를 가지는 배열에서 r개의 원소를 선택하여 나열하는 문제. 여기서는 n == r 로 가정하겠다.
4. 백트래킹: 해를 찾는 도중에 막히면(해가 아니면) 되돌아가서 다시 해를 찾아가는 기법이다. 이를 이용하여 최적화(Optimization) 문제와 결정(Desision)문제3를 해결할 수 있다.
5. BFS

## 예제
* 9095, 1107, 1476


## 차이를 최대로
* 10819

## 외판원순회
* 10971

## 로또
* 6603

## 큐(BFS)
* 1697, 1963(소수경로), 9019(DSLR), 1525(퍼즐), 물통(2251)

## 재귀호출, 비트마스크
* 9095, 암호만들기(1759), N-Queen(9663), 스도쿠(2580), 알파벳(1987), 부분집합의 합(1182)

## 수들의 합 2
* (2003), 소수의 연속합(1644)

## 덱사용 
* 알고스팟 ( 1261), 알고스팟 중간에서 만나기(1208), 합이 0인 네정수(7453)


# DP
* O(높이 제곱) 을 O(n)으로 낮춰줌
* 큰 문제를 작은 문제로 나눳 푸는 알고리즘
* 피보나치수, Optimal Substructure

## DP를 푸는 방법
* 둘 중에 하나만 잘하면 됨
1. Top- down
2. Bottom-up

## 1로 만들기
* 1463

## 2Xn 타일링
* 11726

## 1, 2, 3 더하기
* 9095

## 붕어빵 판매하기
* 11052

## 이친수
* 2193

## 쉬운 계단 수
* 10844

## 오르막 수
* 11057

## 스티커
* 9465

## 포도주 시식
* 2156

## 가장 긴 증가하는 부분 수열
* 11053

## 가장 긴 감소하는 부분 수열
* 11054

## 연속합
* 1912

## 계단 오르기
* 2579

## 제곱수의 합
* 1699

## 타일 채우기
* 2133

## 합분해
* 2225

## 암호코드
* 2011

## 이동하기
* 11048

## 점프
* 1890

## 팰린드롬
* 10942

## 동전1
* 2293

## 내리막길
* 1520

## 파일 합치기
* 11066

## 구간 나누기
* 2228

## 자두나무
* 2240

## 고층빌딩
* 1328

## 기타리스트
* 1495

## 1학년
* 5557

## 올바른 괄호 문자열
* 3012

## 같은 탑
* 1126
