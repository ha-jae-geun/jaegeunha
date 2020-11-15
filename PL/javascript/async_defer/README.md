# [async_defer](https://webclub.tistory.com/630)
# [asyncc defer 엘리](https://www.youtube.com/watch?v=tJieVCgGzhs&list=PLv2d7VI9OotTVOL4QmPfvJWPJvkmv6h-2&index=20)

# async
* fetching이 parsing과 병렬로 수행
* fetching 이후 바로 parsing이 block되면서 자바스크립트 실행
* 자바 스크립트 execute가 랜덤

# defer
* fetching이 parsing과 병렬로 수행
* parsing이 끝나고 execute 실행
  * 자바 스크립트 execute 순서가 일정
