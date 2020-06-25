# Synonym
```java
데이터베이스 객체는 각자 고유한 이름이 있습니다. 이 객체들에 대한 동의어를 만드는것이 바로 시노님입니다. 
한마디로 객체에게 가명을 주는것이라고 생각하면 되며 ALIAS와 비슷합니다. 다만 ALIAS는 1회성인 반면 시노님(Synonym)은 영구적이라고
볼 수 있습니다. 보통 다른 유저의 객체를 참조할 때 많이 사용을 합니다. 실제로 시노님을 사용하는 목적은 다른 유저의 객체를 사용할때 
유저의 이름과 객체의  실제이름을 사용하는데 그 두개를 감춤으로써 데이터베이스의 보안을 개선하기위해 사용되어집니다.시노님에는 
PUBLIC과 PRIVATE타입이 있습니다. PUBLIC은 모든 사용자가 접근할 수 있고 PRIVATE는 특정사용자에게만 참조가 가능합니다. 



시노님(Synonym) 생성
--문법
CREATE OR REPLACE [PUBLIC / PRIVATE] SYNOYM [사노님명]
FOR [객체명]
--예제
CREATE OR REPLACE SYNONYM EX_SYNONYM
FOR CUSTOMERS;
시노님 생성

CUSTOMERS 이라는 테이블에 대한 시노님이 만들어졌습니다. public / private라는 명시를 해주지않으면 private으로 시노님이 생성됩니다. 
시노님 수정도 위의 쿼리문을 실행시켜주시면 됩니다. 만약 시노님 이름이 있다면 위에 덮어쓰는 개념으로 재 생성 됩니다.

SELECT * FROM EX_SYNONYM
시노님 조회

위와 같이 생성한 시노님 EX_SYNONYM을 조회하면 CUSTOMERS테이블이 조회되는것을 보실 수 있습니다.



현재 계정의 시노님(Synonym) 조회
SELECT * FROM USER_SYNONYMS
현재계정 시노님 조회

USER_SYNONYMS을 조회하면 현재 계정에서 사용할 수 있는 시노님 리스트를 볼 수 있습니다.



전체 시노님(Synonym) 조회
SELECT * FROM ALL_SYNONYMS
전체 시노님 조회

전체 시노님을 조회하고 싶다면 위와같이 하시면 됩니다. ALL_SYNONYMS을 조회하면 현재 생성되어있는 시노님 리스트를 볼 수 있습니다.



시노님(Synonym) 사용권한 부여
GRANT SELECT ON [시노님명] TO [계정명]
위에서 조회된 시노님을 조회했을 경우 "테이블 또는 뷰가 존재하지 않습니다." 라는 오류가 날 수 있습니다. 이 경우 권한이 없어서 난 오류이니 
위의 쿼리문을 실행하여 사용 계정에 SELECT권한을 주셔야합니다.



시노님(Synonym) 삭제
--문법
DROP [PUBLIC/PRIVATE] SYNONYM [시노님명]
--예제
DROP SYNONYM EX_SYNONYM;
시노님 삭제

시노님을 삭제할때는 위와 같이 해주시면 됩니다. PRIVATE 시노님을 제거할 때 DROP SYNONYM이나 DROP ANY SYNONYM 권한이 있어야하고 PUBLIC시노님을 
제거할때는 DROP PUBLIC SYNONYM권한이 있어야 합니다. 시노님 제거가 안될 경우에는 위 권한이 없는것이니 권한을 부여받아 사용하도록 합시다.
```
