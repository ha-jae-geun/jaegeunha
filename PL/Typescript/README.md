# [타입스크립트 블로그](https://velog.io/tags/typescript)

# 블룸버그가 TypeScript를 대규모로 도입하며 배운 것들 
1. TypeScript 는 JavaScript + Types 일수 있다.
2. TS는 빠르게 발전하므로, 최신 컴파일러를 따라가는게 좋다.
3. 일관된 tsconfig 설정은 가치가 있다.
4. 어떤 위치에 종속성을 명시하느냐가 중요하다.
ㅤ→ Ambient Modules 사용
5. Type의 중복 제거는 중요하다.
6. 암시적인 타입 종속성은 피해야 한다.
7. 선언 파일엔 세가지 Export 모드가 있다 : global, module, implicit exports
ㅤ→ 가능하면 module로
8. 패키지의 캡슐화는 위반 가능하다.
9. 자동 생성된 선언들은 디펜던시로부터 타입 인라인 가능
10. 생성된 선언들은 필수가 아닌 종속성들을 포함 가능
