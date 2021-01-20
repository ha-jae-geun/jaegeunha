# [Fylnn의 구조](https://m.blog.naver.com/PostView.nhn?blogId=looen&logNo=140151491206&proxyReferer=https:%2F%2Fwww.google.com%2F)
```java
Flynn의 병렬컴퓨터 분류방식에 대한 설명으로 옳지 않은 것은? 3번
① SISD-명령어와 데이터를 순서대로 처리하는 단일프로세서 시스템이다.
② SIMD-단일 명령어 스트림을 처리하고 배열프로세서라고도 한다.
③ MISD-여러 개의 프로세서를 갖는 구조로 밀결합 시스템 (tightly-coupled system)과 소결합 시스템(looselycoupled system)으로 분류한다.
④ MIMD-여러 개의 프로세서들이 서로 다른 명령어와 데이터를 처리하는 진정한 의미의 병렬프로세서이다.

MIMD
∙ 복수 인스트럭션 스트림 - 복수 데이터 스트림
∙ 여러 개의 프로세서들이 서로 다른 명령어와 데이터를 처리하는 방식
∙ 진정한 의미의 병렬 처리 구조로 대부분 약결합 형태의 구조적 특징을 가지나, 강결합 형태도 있음
∙ 한 시스템 내에 n개의 프로세서들이 서로 다른 명령어들과 데이터를 처리하는 방식
```
