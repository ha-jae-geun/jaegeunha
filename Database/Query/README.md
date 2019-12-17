# outer join
```sql
from emp e right (outer) join dept d
using(deptno)  /  on e.deptno = d.deptno
```

# 쿼리 추출 개수 설정
```java
SELECT a.NAME, a.DATETIME

FROM ANIMAL_INS a left join ANIMAL_OUTS b on a.ANIMAL_ID = b.ANIMAL_ID

WHERE b.ANIMAL_ID is NULL

ORDER BY a.DATETIME
LIMIT 3
```
# INTACT 사이에 두지 않은 값 찾기
```java
SELECT a.ANIMAL_ID, a.ANIMAL_TYPE, a.NAME

FROM ANIMAL_INS a join ANIMAL_OUTS b on
a.ANIMAL_ID = b.ANIMAL_ID

WHERE a.SEX_UPON_INTAKE LIKE "%Intact%" and b.SEX_UPON_OUTCOME NOT LIKE "%Intact%"

ORDER BY a.ANIMAL_ID
```

```

```java
SELECT NAME, DATETIME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID DESC


SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION = 'Sick'
ORDER BY ANIMAL_ID




SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION != 'Aged'
ORDER BY ANIMAL_ID




SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NULL


 WHERE 절에서는 집계함수를 사용 할 수 없다.
- HAVING 절은 집계함수를 가지고 조건비교를 할 때 사용한다.
- HAVING절은 GROUP BY절과 함께 사용이 된다.
```

```java
SELECT A.ANIMAL_ID, A.NAME
FROM ANIMAL_OUTS A LEFT JOIN ANIMAL_INS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE B.ANIMAL_ID IS NULL

그냥 PK로 조인을 해버리면 INNER JOIN이 되어서 ANIMAL_INS와 ANIMAL_OUTS 둘 다 있는 값만 조인이 됩니다.
값이 사라진 것까지 불러와서 JOIN을 하려면 LEFT JOIN 또는 RIGHT JOIN을 해야 합니다.
```

```java
SELECT B.NAME, B.DATETIME
FROM ANIMAL_OUTS A RIGHT JOIN ANIMAL_INS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE A.ANIMAL_ID IS NULL
ORDER BY B.DATETIME
LIMIT 3;

이렇게 조인하고 ANIMAL_OUTS의 속성 값이 NULL인 조건식을 세우면 되겠죠.
가장 오래 있었어야 하니 DATETIME의 값이 가장 낮아야 합니다. DATETIME을 오름차순 정렬하면 처음 값들이 가장 오래된 값으로 정렬됩니다.
LIMIT은 출력되는 레코드 수를 제한할 수 있습니다.
```

```java
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
WHERE NAME IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
특정 이름을 가진 동물을 찾는 문제이므로 IN을 쓴 뒤 문제에서 요구하는 이름을 적으면 됩니다.

SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE ANIMAL_TYPE = 'DOG'
AND UPPER(NAME) LIKE '%EL%'
ORDER BY UPPER(NAME)
문제에서 중요한 건 이름이 EL이 들어가는 조건이랑 대소문자 구분 없이 정렬을 한다는 것입니다.
UPPER(NAME)을 통해 NAME을 대문자로 변환해서 el, eL, El, EL 을 모두 EL로 변환하여 검사하도록 하였고,
ORDER BY 절에서도 보시면 아시겠지만 NAME을 대문자로 변환하여 정렬하도록 하였습니다.

```

# SQL 순서
1. FROM clause
2. WHERE clause
3. GROUP BY clause
4. HAVING clause
5. SELECT clause
6. ORDER BY clause

# SQL GATE
* F6: SELECT 상황에서 수정
* 테이블 수정: 테이블 마우스 우측 -> 테이블 변경

# NVL
```sql
SELECT A.MEA_DATE,
       A.SIDO2,
       NVL(B.AVG_PRICE,
          (SELECT AVG_PRICE
          FROM    AGRICULTURE_SO
          WHERE   TRADE_DATE =
                  ( SELECT MAX(TRADE_DATE)
                  FROM    AGRICULTURE_SO
                  WHERE   TRADE_DATE          < A.MEA_DATE
                  AND     PLACE_NAME          = A.SIDO2
                  AND     AVG_PRICE IS NOT NULL
                  )
          )
          ) AVG_PRICE,
       A.AVG_CLOUD,
       A.TOT_SOLAR,
       A.TOT_DYL_TM,
       A.WND_DRCTN,
       A.AVG_WND_SPD,
       A.DAY_PRE,
       A.AVG_TMPRT,
       A.MIN_TMPRT,
       A.MAX_TMPRT,
       A.DAILY_TMPRT,
       A.AVG_HUMID,
       A.TOT_DYL_HR,
       A.AVG_GTMPRT,
       A.PM2,
       A.PM10,
       A.NTRGN_DXD,
       A.OZON,
       A.CRBN_MNXD,
       A.SLFR_DXD
FROM   (SELECT  MEA_DATE,
                SIDO2,
                ROUND(AVG(AVG_TMPRT), 1) AVG_TMPRT,
                ROUND(SUM(DAY_PRE), 1) DAY_PRE,
                ROUND(AVG(AVG_WND_SPD), 1) AVG_WND_SPD,
                ROUND(AVG(WND_DRCTN), 1) WND_DRCTN,
                ROUND(SUM(TOT_DYL_TM), 1) TOT_DYL_TM,
                ROUND(SUM(TOT_SOLAR), 1) TOT_SOLAR,
                ROUND(SUM(AVG_CLOUD), 1) AVG_CLOUD,
                ROUND(AVG(MIN_TMPRT), 1) MIN_TMPRT,
                ROUND(AVG(MAX_TMPRT), 1) MAX_TMPRT,
                ROUND(AVG(DAILY_TMPRT), 1) DAILY_TMPRT,
                ROUND(AVG(AVG_HUMID), 1) AVG_HUMID,
                ROUND(SUM(TOT_DYL_HR), 1) TOT_DYL_HR,
                ROUND(AVG(AVG_GTMPRT), 1) AVG_GTMPRT,
                ROUND(AVG(SLFR_DXD), 3) SLFR_DXD,
                ROUND(AVG(CRBN_MNXD), 1) CRBN_MNXD,
                ROUND(AVG(OZON), 3) OZON,
                ROUND(AVG(NTRGN_DXD), 3) NTRGN_DXD,
                ROUND(AVG(PARTICLE_MATTER_10), 0) PM10,
                ROUND(AVG(PARTICLE_MATTER_2), 0) PM2
       FROM     ( SELECT A.MEA_DATE,
                        A.SIDO2,
                        B.AVG_TMPRT,
                        B.DAY_PRE,
                        B.AVG_WND_SPD,
                        B.WND_DRCTN,
                        B.TOT_DYL_TM,
                        B.TOT_SOLAR,
                        B.AVG_CLOUD,
                        B.MIN_TMPRT,
                        B.MAX_TMPRT,
                        B.DAILY_TMPRT,
                        B.AVG_HUMID,
                        B.TOT_DYL_HR,
                        B.AVG_GTMPRT,
                        B.SLFR_DXD,
                        B.CRBN_MNXD,
                        B.OZON,
                        B.NTRGN_DXD,
                        B.PARTICLE_MATTER_10,
                        B.PARTICLE_MATTER_2
                FROM    (SELECT MEA_DATE,
                                (TO_DATE(MEA_DATE, 'YYYY-MM-DD') - 30) PREV_MONTH,
                                (TO_DATE(MEA_DATE, 'YYYY-MM-DD') - 5) PREV_DAY,
                                AREA SIDO2
                        FROM    WEATHER_DATA
                        WHERE   AREA        = '부산'
                        AND     MEA_DATE LIKE '2010%'
                        )
                        A,
                        (SELECT A.AREA,
                                A.MEA_DATE,
                                A.AVG_TMPRT,
                                A.DAY_PRE,
                                A.AVG_WND_SPD,
                                A.WND_DRCTN,
                                A.TOT_DYL_TM,
                                A.TOT_SOLAR,
                                A.AVG_CLOUD,
                                A.MIN_TMPRT,
                                A.MAX_TMPRT,
                                A.DAILY_TMPRT,
                                A.AVG_HUMID,
                                A.TOT_DYL_HR,
                                A.AVG_GTMPRT,
                                B.SLFR_DXD,
                                B.CRBN_MNXD,
                                B.OZON,
                                B.NTRGN_DXD,
                                B.PARTICLE_MATTER_10,
                                B.PARTICLE_MATTER_2
                        FROM    WEATHER_DATA A,
                                FINE_DUST B
                        WHERE   A.AREA     = B.SIDO
                        AND     A.MEA_DATE = B.MEASURE_DATE
                        )
                        B
                WHERE   A.SIDO2 = B.AREA
                AND     TO_DATE(B.MEA_DATE, 'YYYY-MM-DD') BETWEEN A.PREV_MONTH AND     A.PREV_DAY
                )
       GROUP BY MEA_DATE,
                SIDO2
       ORDER BY MEA_DATE
       ) A,
			 AGRICULTURE_SO B
       
WHERE  A.MEA_DATE  = B.TRADE_DATE(+)
AND    A.SIDO2  = B.PLACE_NAME(+)



```

# UPDATE
```SQL
UPDATE WEATHER_2014 A
SET    MIN_TMPRT =
       (SELECT DATA1
       FROM    TEMP b
       WHERE   A.AREA        = B.SIDO
       AND     A.MEA_DATE    =B.REG_DATE
       )
       ,
       MAX_TMPRT =
       (SELECT DATA2
       FROM    TEMP b
       WHERE   A.AREA        = B.SIDO
       AND     A.MEA_DATE    =B.REG_DATE
       )
       ,
       AVG_HUMID =
       (SELECT DATA3
       FROM    TEMP b
       WHERE   A.AREA        = B.SIDO
       AND     A.MEA_DATE    =B.REG_DATE
       )
       ,
       TOT_DYL_HR =
       (SELECT DATA4
       FROM    TEMP b
       WHERE   A.AREA        = B.SIDO
       AND     A.MEA_DATE    =B.REG_DATE
       )
       ,
       AVG_GTMPRT =
       (SELECT DATA5
       FROM    TEMP b
       WHERE   A.AREA        = B.SIDO
       AND     A.MEA_DATE    =B.REG_DATE
       )
COMMIT
```

# 테이블
## 날짜
* 현재 날짜 기본 
```sql
create table memo {
	post_date date default sysdate/  post_date라는 이름으로 date 타입으로 
};
```

1.
```
SELECT SIDO, AVG(OZON)   FROM MICRO_DUST_2017
WHERE MEASURE_DATE LIKE '2017%' 
AND SIDO IN ('경기')
AND SUBSTR(MEASURE_DATE, 0, 8) lIKE '%20170201%'
GROUP BY SIDO,
         SUBSTR(MEASURE_DATE, 0, 8)
```
         
2.
```SQL
SELECT   SIDO,
         SUBSTR(MEASURE_DATE, 0, 8) mea_date,
         ROUND(AVG(SLFR_DXD), 6),
         ROUND(AVG(CRBN_MNXD), 6),
         ROUND(AVG(NVL(OZON,0)), 6),
         ROUND(AVG(NTRGN_DXD), 6),
         ROUND(AVG(PARTICLE_MATTER_10), 6),
         ROUND(AVG(PARTICLE_MATTER_2), 6)
FROM     MICRO_DUST_2017
WHERE    SIDO = '경기'
GROUP BY SIDO,
         SUBSTR(MEASURE_DATE, 0, 8)
```

3.
```SQL
SELECT   SIDO,
         SUBSTR(MEASURE_DATE, 0, 8) mea_date,
         ROUND(AVG(SLFR_DXD), 6),
         ROUND(AVG(CRBN_MNXD), 6),
         ROUND(AVG(OZON), 6),
         ROUND(AVG(NTRGN_DXD), 6),
         ROUND(AVG(PARTICLE_MATTER_10), 6),
         ROUND(AVG(PARTICLE_MATTER_2), 6)
FROM     MICRO_DUST_2017
WHERE    SIDO = '경기'
AND OZON IS NOT NULL
GROUP BY SIDO,
         SUBSTR(MEASURE_DATE, 0, 8)
```

4.
```SQL
SELECT SUBSTR(B.BASE_NAME,0,2),
       REPLACE(A.MEA_DATE, '-', ''),
       A.AVG_TMPRT,
       A.DAY_PRE,
       A.AVG_WND_SPD,
       A.WND_DRCTN,
       A.TOT_DYL_TM,
       A.TOT_SOLAR
       
FROM   WEATHER_2015 A,
       TB_BASE_CODE B
WHERE  B.KIND_CODE    = 1
AND    A.AREA (+)     = B.BASE_CODE
AND    B.BASE_NAME LIKE '서울%'
```

5.
```SQL
SELECT SIDO, AVG(OZON)   FROM MICRO_DUST_2017
WHERE MEASURE_DATE LIKE '2017%' 
AND SIDO IN ('경기')
AND OZON IS NOT NULL
AND SUBSTR(MEASURE_DATE, 0, 8) lIKE '%20170201%'
GROUP BY SIDO,
         SUBSTR(MEASURE_DATE, 0, 8)
```

6.
```SQL;
SELECT SUBSTR(B.BASE_NAME,0,4) 시도,
       REPLACE(A.MEA_DATE, '-', '') 일자,
       ROUND(AVG(A.AVG_TMPRT), 6) 평균기온,
       ROUND(AVG(A.DAY_PRE), 6) 일강수량,
       ROUND(AVG(A.AVG_WND_SPD), 6) 평균풍량,
       ROUND(AVG(A.WND_DRCTN), 6) 최다풍향,
       ROUND(AVG(A.TOT_DYL_TM), 6) 합계일조시간 ,
       ROUND(AVG(A.TOT_SOLAR), 6) 합계일사  
FROM   COPY_WEATHER_2015 A,
       TB_BASE_CODE B
WHERE  B.KIND_CODE    = 1
AND    A.AREA = B.BASE_CODE
GROUP BY SUBSTR(B.BASE_NAME,0,4), REPLACE(A.MEA_DATE, '-', '')
ORDER BY 시도, 일자
```

```SQL
SELECT A.*,
       B.DATA1
FROM   WEATHER_2015 A,
       TEMP B
WHERE  A.AREA     = B.SIDO
AND    A.MEA_DATE = B.REG_DATE



UPDATE WEATHER_2015 A
SET    AVG_CLOUD =
       (SELECT DATA1
       FROM    TEMP B
       WHERE   A.AREA     = B.SIDO
       AND     A.MEA_DATE = B.REG_DATE
       )
```

```SQL
SELECT CASE WHEN SIDO = '경상남도' THEN '경남'
						WHEN SIDO = '경상북도' THEN '경북'
            WHEN SIDO = '충청남도' THEN '충남'
            WHEN SIDO = '충청북도' THEN '충북'
            WHEN SIDO = '전라남도' THEN '전남'
            WHEN SIDO = '전라북도' THEN '전북'
            ELSE ''
			 END SIDO,
       MEA_DATE,
       AVG_CLOUD
 FROM(
SELECT SUBSTR(B.BASE_NAME,0,4)SIDO,
       REPLACE(A.MEA_DATE, '-', '') MEA_DATE,
       ROUND(AVG(A.AVG_CLOUD), 6) AVG_CLOUD  
FROM   WEATHER_2018 A,
       TB_BASE_CODE B
WHERE  B.KIND_CODE    = 1
AND    A.AREA = B.BASE_CODE
GROUP BY SUBSTR(B.BASE_NAME,0,4), REPLACE(A.MEA_DATE, '-', '')
ORDER BY SIDO, MEA_DATE)
WHERE SIDO IN ('경상남도', '경상북도', '충청남도', '충청북도', '전라남도', '전라북도')
```

```SQL
SELECT   SIDO,
         SUBSTR(MEASURE_DATE, 0, 8) mea_date,
         ROUND(AVG(SLFR_DXD), 6),
         ROUND(AVG(CRBN_MNXD), 6),
         ROUND(AVG(NVL(OZON,0)), 6),
         ROUND(AVG(NTRGN_DXD), 6),
         ROUND(AVG(PARTICLE_MATTER_10), 6),
         ROUND(AVG(PARTICLE_MATTER_2), 6)
FROM     MICRO_DUST_2015
WHERE    AREA_CODE NOT IN(111122,
                          111124,
                          111125,
                          111143,
                          111154,
                          111162,
                          111202,
                          111213,
                          111232,
                          111242,
                          111263,
                          111264,
                          111275,
                          111282,
                          111312,
                          131116,
                          131120,
                          131125,
                          131198,
                          131383,
                          131414,
                          221131,
                          221162,
                          221901,
                          221902,
                          238126,
                          238145,
                          324123,
                          324134,
                          422133,
                          422202,
                          525151,
                          525173,
                          533116,
                          534114,
                          823633,
                          823634,
                          823703,
                          831155 )
GROUP BY SIDO,
         SUBSTR(MEASURE_DATE, 0, 8)

```

```SQL
SELECT CASE
               WHEN SUBSTR(SIDO,0,3) = '경기도' THEN '경기'
               WHEN SUBSTR(SIDO,0,3) = '강원도' THEN '강원'
               WHEN SUBSTR(SIDO,0,3) = '제주도' THEN '제주'
               ELSE SUBSTR(SIDO,0,3)
			 END SIDO,
       MEA_DATE,
       AVG_CLOUD
 FROM(
SELECT SUBSTR(B.BASE_NAME,0,4)SIDO,
       REPLACE(A.MEA_DATE, '-', '') MEA_DATE,
       ROUND(AVG(A.AVG_CLOUD), 6) AVG_CLOUD  
FROM   WEATHER_2016 A,
       TB_BASE_CODE B
WHERE  B.KIND_CODE    = 1
AND SUBSTR(B.BASE_NAME,0,3) IN ('경기도', '강원도', '제주도')
AND    A.AREA = B.BASE_CODE
GROUP BY SUBSTR(B.BASE_NAME,0,4), REPLACE(A.MEA_DATE, '-', '')
ORDER BY SIDO, MEA_DATE)
```

## Union
```SQL
SELECT *
FROM  ( SELECT  TRADE_DATE,
                MARKET_NAME,
                CASE
                         WHEN SUBSTR(PLACE_NAME,0,4) = '경상남도'
                         THEN '경남'
                         WHEN SUBSTR(PLACE_NAME,0,4) = '경상북도'
                         THEN '경북'
                         WHEN SUBSTR(PLACE_NAME,0,4) = '전라남도'
                         THEN '전남'
                         WHEN SUBSTR(PLACE_NAME,0,4) = '전라북도'
                         THEN '전북'
                         WHEN SUBSTR(PLACE_NAME,0,4) = '충청남도'
                         THEN '충남'
                         WHEN SUBSTR(PLACE_NAME,0,4) = '충청북도'
                         THEN '충북'
                         ELSE SUBSTR(PLACE_NAME,0,4)
                END PLACE_NAME,
                MAX(ITEM),
                MAX(SUBSTR(UNIT,0,2)),
                ROUND(AVG(AVG_PRICE/CONTAINER),0),
                ROUND(AVG(MAX_PRICE/CONTAINER),0),
                ROUND(AVG(MIN_PRICE/CONTAINER),0)
       FROM     FARM_PRODUCE_2018
       WHERE    SUBSTR(PLACE_NAME,0,4) IN ('경상남도',
                                           '경상북도',
                                           '전라남도',
                                           '전라북도',
                                           '충청남도',
                                           '충청북도')
       GROUP BY TRADE_DATE,
                SUBSTR(PLACE_NAME,0,4),
                MARKET_NAME
       
       UNION ALL
       
       SELECT   TRADE_DATE,
                MARKET_NAME,
                CASE
                         WHEN SUBSTR(PLACE_NAME,0,3) = '경기도'
                         THEN '경기'
                         WHEN SUBSTR(PLACE_NAME,0,3) = '강원도'
                         THEN '강원'
                         WHEN SUBSTR(PLACE_NAME,0,3) = '제주도'
                         THEN '제주'
                         ELSE SUBSTR(PLACE_NAME,0,3)
                END PLACE_NAME,
                MAX(ITEM),
                MAX(SUBSTR(UNIT,0,2)),
                ROUND(AVG(AVG_PRICE/CONTAINER),0),
                ROUND(AVG(MAX_PRICE/CONTAINER),0),
                ROUND(AVG(MIN_PRICE/CONTAINER),0)
       FROM     FARM_PRODUCE_2018
       WHERE    SUBSTR(PLACE_NAME,0,3) IN ('경기도',
                                           '강원도',
                                           '제주도')
       GROUP BY TRADE_DATE,
                SUBSTR(PLACE_NAME,0,3),
                MARKET_NAME
       
       UNION ALL
       
       SELECT   TRADE_DATE,
                MARKET_NAME,
                SUBSTR(PLACE_NAME,0,2) PLACE_NAME,
                MAX(ITEM),
                MAX(SUBSTR(UNIT,0,2)),
                ROUND(AVG(AVG_PRICE/CONTAINER),0),
                ROUND(AVG(MAX_PRICE/CONTAINER),0),
                ROUND(AVG(MIN_PRICE/CONTAINER),0)
       FROM     FARM_PRODUCE_2018
       WHERE    SUBSTR(PLACE_NAME,0,2) IN ('서울',
                                           '인천',
                                           '세종',
                                           '대전',
                                           '대구',
                                           '광주',
                                           '울산',
                                           '부산')
       GROUP BY TRADE_DATE,
                SUBSTR(PLACE_NAME,0,2),
                MARKET_NAME
       )
```

```SQL
SELECT A.SIDO,
       A.MEASURE_DATE,
       ROUND(A.PARTICLE_MATTER_10, 3) PM10,
       ROUND(A.PARTICLE_MATTER_2, 3) PM2,
       ROUND(B.TOT_SOLAR, 3) SOLAR
FROM   FINE_DUST_2015 A,
       WEATHER_DATA_2015 B
WHERE  A.SIDO = B.AREA
AND A.MEASURE_DATE = B.MEA_DATE
AND A.SIDO != '울산'
AND B.TOT_SOLAR IS NOT NULL
AND A.PARTICLE_MATTER_10 IS NOT NULL
AND A.PARTICLE_MATTER_2 IS NOT NULL

```

```SQL
SELECT 
       CASE
              WHEN ROUND(A.PARTICLE_MATTER_10, 3)   >= 0
              AND    ROUND(A.PARTICLE_MATTER_10, 3) <= 30
              THEN 1
              WHEN ROUND(A.PARTICLE_MATTER_10, 3)   >= 31
              AND    ROUND(A.PARTICLE_MATTER_10, 3) <= 80
              THEN 2
              WHEN ROUND(A.PARTICLE_MATTER_10, 3)   >= 81
              AND    ROUND(A.PARTICLE_MATTER_10, 3) <= 150
              THEN 3
              ELSE 4
       END PM10,
       CASE
              WHEN ROUND(A.PARTICLE_MATTER_2, 3)   >= 0
              AND    ROUND(A.PARTICLE_MATTER_2, 3) <= 15
              THEN 1
              WHEN ROUND(A.PARTICLE_MATTER_2, 3)   >= 16
              AND    ROUND(A.PARTICLE_MATTER_2, 3) <= 35
              THEN 2
              WHEN ROUND(A.PARTICLE_MATTER_2, 3)   >= 36
              AND    ROUND(A.PARTICLE_MATTER_2, 3) <= 75
              THEN 3
              ELSE 4
       END PM2,
       ROUND(B.TOT_SOLAR, 1) SOLAR
FROM   FINE_DUST_2017 A,
       WEATHER_DATA_2017 B
WHERE  A.SIDO                         = B.AREA
AND    A.MEASURE_DATE                 = B.MEA_DATE
AND    A.SIDO = '서울'
AND    B.AVG_CLOUD BETWEEN 0 AND 5
--AND    A.SIDO                        != '울산'
AND    B.TOT_SOLAR          IS NOT NULL
AND    A.PARTICLE_MATTER_10 IS NOT NULL
AND    A.PARTICLE_MATTER_2  IS NOT NULL

```

```SQL
SELECT
       CASE
              WHEN SIDO = '경상남도'
              THEN '경남'
              WHEN SIDO = '경상북도'
              THEN '경북'
              WHEN SIDO = '충청남도'
              THEN '충남'
              WHEN SIDO = '충청북도'
              THEN '충북'
              WHEN SIDO = '전라남도'
              THEN '전남'
              WHEN SIDO = '전라북도'
              THEN '전북'
              ELSE ''
       END SIDO,
       MEA_DATE,
       AVG_TMPRT,
       DAY_PRE,
       WND_SPD,
       WND_DRCTN,
       TOT_DYL_TM,
       TOT_SOLAR,
       AVG_CLOUD
FROM   ( SELECT  SUBSTR(B.BASE_NAME,0,4)SIDO,
                REPLACE(A.MEA_DATE, '-', '') MEA_DATE,
                ROUND(AVG(A.AVG_TMPRT), 6) AVG_TMPRT,
                ROUND(AVG(A.DAY_PRE), 6)DAY_PRE,
                ROUND(AVG(A.AVG_WND_SPD), 6)WND_SPD,
                ROUND(AVG(A.WND_DRCTN), 6)WND_DRCTN,
                ROUND(AVG(A.TOT_DYL_TM), 6)TOT_DYL_TM,
                ROUND(AVG(A.TOT_SOLAR), 6)TOT_SOLAR,
                ROUND(AVG(A.AVG_CLOUD), 6)AVG_CLOUD
       FROM     WEATHER_2018 A,
                TB_BASE_CODE B
       WHERE    B.KIND_CODE = 1
       AND      A.AREA      = B.BASE_CODE
       GROUP BY SUBSTR(B.BASE_NAME,0,4),
                REPLACE(A.MEA_DATE, '-', '')
       ORDER BY SIDO,
                MEA_DATE
       )
WHERE  SIDO IN ('경상남도',
                '경상북도',
                '충청남도',
                '충청북도',
                '전라남도',
                '전라북도')

UNION ALL

SELECT
       CASE
              WHEN SUBSTR(SIDO,0,3) = '경기도'
              THEN '경기'
              WHEN SUBSTR(SIDO,0,3) = '강원도'
              THEN '강원'
              WHEN SUBSTR(SIDO,0,3) = '제주도'
              THEN '제주'
              ELSE SUBSTR(SIDO,0,3)
       END SIDO,
       MEA_DATE,
       AVG_TMPRT,
       DAY_PRE,
       WND_SPD,
       WND_DRCTN,
       TOT_DYL_TM,
       TOT_SOLAR,
       AVG_CLOUD
FROM   ( SELECT  SUBSTR(B.BASE_NAME,0,3)SIDO,
                REPLACE(A.MEA_DATE, '-', '') MEA_DATE,
                ROUND(AVG(A.AVG_TMPRT), 6) AVG_TMPRT,
                ROUND(AVG(A.DAY_PRE), 6)DAY_PRE,
                ROUND(AVG(A.AVG_WND_SPD), 6)WND_SPD,
                ROUND(AVG(A.WND_DRCTN), 6)WND_DRCTN,
                ROUND(AVG(A.TOT_DYL_TM), 6)TOT_DYL_TM,
                ROUND(AVG(A.TOT_SOLAR), 6)TOT_SOLAR,
                ROUND(AVG(A.AVG_CLOUD), 6)AVG_CLOUD
       FROM     WEATHER_2018 A,
                TB_BASE_CODE B
       WHERE    B.KIND_CODE = 1
       AND      A.AREA      = B.BASE_CODE
       GROUP BY SUBSTR(B.BASE_NAME,0,3),
                REPLACE(A.MEA_DATE, '-', '')
       ORDER BY SIDO,
                MEA_DATE
       )
WHERE  SIDO IN ('경기도',
                '강원도',
                '제주도')
```
- GROUP BY에 별명 

```SQL
SELECT
       CASE
              WHEN SIDO = '경상남도'
              THEN '경남'
              WHEN SIDO = '경상북도'
              THEN '경북'
              WHEN SIDO = '충청남도'
              THEN '충남'
              WHEN SIDO = '충청북도'
              THEN '충북'
              WHEN SIDO = '전라남도'
              THEN '전남'
              WHEN SIDO = '전라북도'
              THEN '전북'
              ELSE ''
       END SIDO,
       MEA_DATE,
       AVG_TMPRT,
       DAY_PRE,
       WND_SPD,
       WND_DRCTN,
       TOT_DYL_TM,
       TOT_SOLAR,
       AVG_CLOUD
FROM   ( SELECT  SUBSTR(B.BASE_NAME,0,4)SIDO,
                REPLACE(A.MEA_DATE, '-', '') MEA_DATE,
                ROUND(AVG(A.AVG_TMPRT), 6) AVG_TMPRT,
                ROUND(AVG(A.DAY_PRE), 6)DAY_PRE,
                ROUND(AVG(A.AVG_WND_SPD), 6)WND_SPD,
                ROUND(AVG(A.WND_DRCTN), 6)WND_DRCTN,
                ROUND(AVG(A.TOT_DYL_TM), 6)TOT_DYL_TM,
                ROUND(AVG(A.TOT_SOLAR), 6)TOT_SOLAR,
                ROUND(AVG(A.AVG_CLOUD), 6)AVG_CLOUD
       FROM     WEATHER_2018 A,
                TB_BASE_CODE B
       WHERE    B.KIND_CODE = 1
       AND      A.AREA      = B.BASE_CODE
       GROUP BY SUBSTR(B.BASE_NAME,0,4),
                REPLACE(A.MEA_DATE, '-', '')
       ORDER BY SIDO,
                MEA_DATE
       )
WHERE  SIDO IN ('경상남도',
                '경상북도',
                '충청남도',
                '충청북도',
                '전라남도',
                '전라북도')

UNION ALL

SELECT
       CASE
              WHEN SUBSTR(SIDO,0,3) = '경기도'
              THEN '경기'
              WHEN SUBSTR(SIDO,0,3) = '강원도'
              THEN '강원'
              WHEN SUBSTR(SIDO,0,3) = '제주도'
              THEN '제주'
              ELSE SUBSTR(SIDO,0,3)
       END SIDO,
       MEA_DATE,
       AVG_TMPRT,
       DAY_PRE,
       WND_SPD,
       WND_DRCTN,
       TOT_DYL_TM,
       TOT_SOLAR,
       AVG_CLOUD
FROM   ( SELECT  SUBSTR(B.BASE_NAME,0,3)SIDO,
                REPLACE(A.MEA_DATE, '-', '') MEA_DATE,
                ROUND(AVG(A.AVG_TMPRT), 6) AVG_TMPRT,
                ROUND(AVG(A.DAY_PRE), 6)DAY_PRE,
                ROUND(AVG(A.AVG_WND_SPD), 6)WND_SPD,
                ROUND(AVG(A.WND_DRCTN), 6)WND_DRCTN,
                ROUND(AVG(A.TOT_DYL_TM), 6)TOT_DYL_TM,
                ROUND(AVG(A.TOT_SOLAR), 6)TOT_SOLAR,
                ROUND(AVG(A.AVG_CLOUD), 6)AVG_CLOUD
       FROM     WEATHER_2018 A,
                TB_BASE_CODE B
       WHERE    B.KIND_CODE = 1
       AND      A.AREA      = B.BASE_CODE
       GROUP BY SUBSTR(B.BASE_NAME,0,3),
                REPLACE(A.MEA_DATE, '-', '')
       ORDER BY SIDO,
                MEA_DATE
       )
WHERE  SIDO IN ('경기도',
                '강원도',
                '제주도')

UNION ALL

SELECT   SUBSTR(B.BASE_NAME,0,2)SIDO,
         REPLACE(A.MEA_DATE, '-', '') MEA_DATE,
         ROUND(AVG(A.AVG_TMPRT), 6) AVG_TMPRT,
         ROUND(AVG(A.DAY_PRE), 6)DAY_PRE,
         ROUND(AVG(A.AVG_WND_SPD), 6)WND_SPD,
         ROUND(AVG(A.WND_DRCTN), 6)WND_DRCTN,
         ROUND(AVG(A.TOT_DYL_TM), 6)TOT_DYL_TM,
         ROUND(AVG(A.TOT_SOLAR), 6)TOT_SOLAR,
         ROUND(AVG(A.AVG_CLOUD), 6)AVG_CLOUD
FROM     WEATHER_2018 A,
         TB_BASE_CODE B
WHERE    B.KIND_CODE = 1
AND      A.AREA      = B.BASE_CODE
AND      SUBSTR(B.BASE_NAME,0,2) IN ('서울',
                                     '인천',
                                     '세종',
                                     '대전',
                                     '대구',
                                     '광주',
                                     '울산',
                                     '부산')
GROUP BY SUBSTR(B.BASE_NAME,0,2),
         REPLACE(A.MEA_DATE, '-', '')
ORDER BY SIDO,
         MEA_DATE
```

# 한번에 

```SQL
INSERT INTO WEATHER_DATA_2010

SELECT
       CASE
              WHEN SIDO = '경상남도'
              THEN '경남'
              WHEN SIDO = '경상북도'
              THEN '경북'
              WHEN SIDO = '충청남도'
              THEN '충남'
              WHEN SIDO = '충청북도'
              THEN '충북'
              WHEN SIDO = '전라남도'
              THEN '전남'
              WHEN SIDO = '전라북도'
              THEN '전북'
              ELSE ''
       END SIDO,
       MEA_DATE,
       AVG_TMPRT,
       DAY_PRE,
       WND_SPD,
       WND_DRCTN,
       TOT_DYL_TM,
       TOT_SOLAR,
       AVG_CLOUD
FROM   ( SELECT  SUBSTR(B.BASE_NAME,0,4)SIDO,
                REPLACE(A.MEA_DATE, '-', '') MEA_DATE,
                ROUND(AVG(A.AVG_TMPRT), 6) AVG_TMPRT,
                ROUND(AVG(A.DAY_PRE), 6)DAY_PRE,
                ROUND(AVG(A.AVG_WND_SPD), 6)WND_SPD,
                ROUND(AVG(A.WND_DRCTN), 6)WND_DRCTN,
                ROUND(AVG(A.TOT_DYL_TM), 6)TOT_DYL_TM,
                ROUND(AVG(A.TOT_SOLAR), 6)TOT_SOLAR,
                ROUND(AVG(A.AVG_CLOUD), 6)AVG_CLOUD
       FROM     WEATHER_2010 A,
                TB_BASE_CODE B
       WHERE    B.KIND_CODE = 1
       AND      A.AREA      = B.BASE_CODE
       GROUP BY SUBSTR(B.BASE_NAME,0,4),
                REPLACE(A.MEA_DATE, '-', '')
       ORDER BY SIDO,
                MEA_DATE
       )
WHERE  SIDO IN ('경상남도',
                '경상북도',
                '충청남도',
                '충청북도',
                '전라남도',
                '전라북도')

UNION ALL

SELECT
       CASE
              WHEN SUBSTR(SIDO,0,3) = '경기도'
              THEN '경기'
              WHEN SUBSTR(SIDO,0,3) = '강원도'
              THEN '강원'
              WHEN SUBSTR(SIDO,0,3) = '제주도'
              THEN '제주'
              ELSE SUBSTR(SIDO,0,3)
       END SIDO,
       MEA_DATE,
       AVG_TMPRT,
       DAY_PRE,
       WND_SPD,
       WND_DRCTN,
       TOT_DYL_TM,
       TOT_SOLAR,
       AVG_CLOUD
FROM   ( SELECT  SUBSTR(B.BASE_NAME,0,3)SIDO,
                REPLACE(A.MEA_DATE, '-', '') MEA_DATE,
                ROUND(AVG(A.AVG_TMPRT), 6) AVG_TMPRT,
                ROUND(AVG(A.DAY_PRE), 6)DAY_PRE,
                ROUND(AVG(A.AVG_WND_SPD), 6)WND_SPD,
                ROUND(AVG(A.WND_DRCTN), 6)WND_DRCTN,
                ROUND(AVG(A.TOT_DYL_TM), 6)TOT_DYL_TM,
                ROUND(AVG(A.TOT_SOLAR), 6)TOT_SOLAR,
                ROUND(AVG(A.AVG_CLOUD), 6)AVG_CLOUD
       FROM     WEATHER_2010 A,
                TB_BASE_CODE B
       WHERE    B.KIND_CODE = 1
       AND      A.AREA      = B.BASE_CODE
       GROUP BY SUBSTR(B.BASE_NAME,0,3),
                REPLACE(A.MEA_DATE, '-', '')
       ORDER BY SIDO,
                MEA_DATE
       )
WHERE  SIDO IN ('경기도',
                '강원도',
                '제주도')

UNION ALL

SELECT   SUBSTR(B.BASE_NAME,0,2)SIDO,
         REPLACE(A.MEA_DATE, '-', '') MEA_DATE,
         ROUND(AVG(A.AVG_TMPRT), 6) AVG_TMPRT,
         ROUND(AVG(A.DAY_PRE), 6)DAY_PRE,
         ROUND(AVG(A.AVG_WND_SPD), 6)WND_SPD,
         ROUND(AVG(A.WND_DRCTN), 6)WND_DRCTN,
         ROUND(AVG(A.TOT_DYL_TM), 6)TOT_DYL_TM,
         ROUND(AVG(A.TOT_SOLAR), 6)TOT_SOLAR,
         ROUND(AVG(A.AVG_CLOUD), 6)AVG_CLOUD
FROM     WEATHER_2010 A,
         TB_BASE_CODE B
WHERE    B.KIND_CODE = 1
AND      A.AREA      = B.BASE_CODE
AND      SUBSTR(B.BASE_NAME,0,2) IN ('서울',
                                     '인천',
                                     '세종',
                                     '대전',
                                     '대구',
                                     '광주',
                                     '울산',
                                     '부산')
GROUP BY SUBSTR(B.BASE_NAME,0,2),
         REPLACE(A.MEA_DATE, '-', '')
ORDER BY SIDO,
         MEA_DATE
```

# 미세먼지 최종
```SQL
INSERT INTO FINE_DUST_2010

SELECT   SIDO,
         SUBSTR(MEASURE_DATE, 0, 8) MEASURE_DATE,
         ROUND(AVG(SLFR_DXD), 6) SLFR_DXD,
         ROUND(AVG(CRBN_MNXD), 6) CRBN_MNXD,
         ROUND(AVG(NVL(OZON,0)), 6) OZON,
         ROUND(AVG(NTRGN_DXD), 6) NTRGN_DXD,
         ROUND(AVG(PARTICLE_MATTER_10), 6) PARTICLE_MATTER_10,
         ROUND(AVG(PARTICLE_MATTER_2), 6) PARTICLE_MATTER_2,
         MAX(NETWORK) NETWORK
FROM     MICRO_DUST_2010
WHERE    AREA_CODE NOT IN(111122,
                          111124,
                          111125,
                          111143,
                          111154,
                          111162,
                          111202,
                          111213,
                          111232,
                          111242,
                          111263,
                          111264,
                          111275,
                          111282,
                          111312,
                          131116,
                          131120,
                          131125,
                          131198,
                          131383,
                          131414,
                          221131,
                          221162,
                          221901,
                          221902,
                          238126,
                          238145,
                          324123,
                          324134,
                          422133,
                          422202,
                          525151,
                          525173,
                          533116,
                          534114,
                          823633,
                          823634,
                          823703,
                          831155 )
GROUP BY SIDO,
         SUBSTR(MEASURE_DATE, 0, 8)
```

# SELECT DELETE 전환
```SQL
DELETE FROM MICRO_DUST_2013
WHERE MEASURE_DATE LIKE '201303%'

SELECT * FROM MICRO_DUST_2013
WHERE MEASURE_DATE LIKE '201303%'
```

# 쿼리문 
``` SQL
SELECT A.PLACE_NAME, A.MARKET_NAME, A.TRADE_DATE, A.AVG_PRICE, B.PARTICLE_MATTER_10, B.PARTICLE_MATTER_2, C.TOT_SOLAR
FROM   AGRICULTURE_2015 A, FINE_DUST_2015 B, WEATHER_DATA_2015 C
WHERE A.TRADE_DATE = B.MEASURE_DATE
AND A.PLACE_NAME = B.SIDO
AND A.TRADE_DATE = C.MEA_DATE
AND A.PLACE_NAME = C.AREA
ORDER BY TRADE_DATE
```

# 20190613
```SQL
SELECT   A.PLACE_NAME,
         A.MARKET_NAME,
         SUBSTR(A.TRADE_DATE,0,4) || '-' || SUBSTR(A.TRADE_DATE,5,2) || '-' || SUBSTR(A.TRADE_DATE,7,2) TRADE_DATE,
         A.AVG_PRICE,
         A.MAX_PRICE,
         A.MIN_PRICE,
         A.VOLUME,
         B.SLFR_DXD SO2,
         B.CRBN_MNXD CO,
         B.OZON O3,
         B.NTRGN_DXD NO2,
         B.PARTICLE_MATTER_10 PM10,
         B.PARTICLE_MATTER_2 PM2,
         C.AVG_TMPRT,
         C.DAY_PRE,
         C.AVG_WND_SPD,
         C.WND_DRCTN,
         C.TOT_DYL_TM,
         C.AVG_CLOUD,
         C.TOT_SOLAR
FROM     AGRICULTURE_2010 A,
         FINE_DUST_2010 B,
         WEATHER_DATA_2010 C
WHERE    A.TRADE_DATE = B.MEASURE_DATE
AND      A.PLACE_NAME = B.SIDO
AND      A.TRADE_DATE = C.MEA_DATE
AND      A.PLACE_NAME = C.AREA
ORDER BY TRADE_DATE
```

```SQL
SELECT   A.PLACE_NAME,
         A.MARKET_NAME,
         SUBSTR(A.TRADE_DATE,0,4)
                  || '-'
                  || SUBSTR(A.TRADE_DATE,5,2)
                  || '-'
                  || SUBSTR(A.TRADE_DATE,7,2) TRADE_DATE,
         A.AVG_PRICE,
         A.MAX_PRICE,
         A.MIN_PRICE,
         A.VOLUME,
         B.SLFR_DXD SO2,
         B.CRBN_MNXD CO,
         B.OZON O3,
         B.NTRGN_DXD NO2,
         B.PARTICLE_MATTER_10 PM10,
         B.PARTICLE_MATTER_2 PM2,
         C.AVG_TMPRT,
         C.DAY_PRE,
         C.AVG_WND_SPD,
         C.WND_DRCTN,
         C.TOT_DYL_TM,
         C.AVG_CLOUD,
         C.TOT_SOLAR
FROM     AGRICULTURE A,
         FINE_DUST B,
         WEATHER_DATA C
WHERE    TO_DATE(A.TRADE_DATE, 'YYYY-MM-DD') - 15 = TO_DATE(B.MEASURE_DATE, 'YYYY-MM-DD')
AND      A.PLACE_NAME                             = B.SIDO
AND      TO_DATE(A.TRADE_DATE, 'YYYY-MM-DD') - 15 = TO_DATE(C.MEA_DATE, 'YYYY-MM-DD')
AND      A.PLACE_NAME                             = C.AREA
ORDER BY TRADE_DATE
```

```SQL
SELECT TRADE_DATE, COUNT(*) FROM AGRICULTURE_2013
GROUP BY TRADE_DATE
ORDER BY TRADE_DATE
```

# OUTER JOIN
```SQL
SELECT   A.PLACE_NAME,
         A.MARKET_NAME,
         SUBSTR(A.TRADE_DATE,0,4)
                  || '-'
                  || SUBSTR(A.TRADE_DATE,5,2)
                  || '-'
                  || SUBSTR(A.TRADE_DATE,7,2) TRADE_DATE,
         A.AVG_PRICE,
         A.MAX_PRICE,
         A.MIN_PRICE,
         A.VOLUME,
         B.SLFR_DXD SO2,
         B.CRBN_MNXD CO,
         B.OZON O3,
         B.NTRGN_DXD NO2,
         B.PARTICLE_MATTER_10 PM10,
         B.PARTICLE_MATTER_2 PM2,
         C.AVG_TMPRT,
         C.DAY_PRE,
         C.AVG_WND_SPD,
         C.WND_DRCTN,
         C.TOT_DYL_TM,
         C.AVG_CLOUD,
         C.TOT_SOLAR
FROM     AGRICULTURE A,
         FINE_DUST B,
         WEATHER_DATA C
WHERE    (TO_DATE(A.TRADE_DATE, 'YYYY-MM-DD') - 15) = TO_DATE(B.MEASURE_DATE(+), 'YYYY-MM-DD')
AND      A.PLACE_NAME                              = B.SIDO(+)
AND      (TO_DATE(A.TRADE_DATE, 'YYYY-MM-DD') - 15) = TO_DATE(C.MEA_DATE(+), 'YYYY-MM-DD')
AND      A.PLACE_NAME                             = C.AREA(+)
ORDER BY TRADE_DATE
```
* 4개 다 걸어주어야 

# 0619 
```SQL
SELECT   A.PLACE_NAME,
         A.MARKET_NAME,
         SUBSTR(A.TRADE_DATE,0,4)
                  || '-'
                  || SUBSTR(A.TRADE_DATE,5,2)
                  || '-'
                  || SUBSTR(A.TRADE_DATE,7,2) TRADE_DATE,
         A.AVG_PRICE,
         CASE
                  WHEN ROUND(A.PARTICLE_MATTER_10, 3)     >= 0
                  AND      ROUND(A.PARTICLE_MATTER_10, 3) <= 30
                  THEN 1
                  WHEN ROUND(A.PARTICLE_MATTER_10, 3)     >= 31
                  AND      ROUND(A.PARTICLE_MATTER_10, 3) <= 80
                  THEN 2
                  WHEN ROUND(A.PARTICLE_MATTER_10, 3)     >= 81
                  AND      ROUND(A.PARTICLE_MATTER_10, 3) <= 150
                  THEN 3
                  ELSE 4
         END G_PM10,
         CASE
                  WHEN ROUND(A.PARTICLE_MATTER_2, 3)     >= 0
                  AND      ROUND(A.PARTICLE_MATTER_2, 3) <= 15
                  THEN 1
                  WHEN ROUND(A.PARTICLE_MATTER_2, 3)     >= 16
                  AND      ROUND(A.PARTICLE_MATTER_2, 3) <= 35
                  THEN 2
                  WHEN ROUND(A.PARTICLE_MATTER_2, 3)     >= 36
                  AND      ROUND(A.PARTICLE_MATTER_2, 3) <= 75
                  THEN 3
                  ELSE 4
         END G_PM2,
         CASE
                  WHEN ROUND(A.AVG_PRICE, 0)     >= 0
                  AND      ROUND(A.AVG_PRICE, 0) <= 676
                  THEN 1
                  WHEN ROUND(A.AVG_PRICE, 0)     >= 677
                  AND      ROUND(A.AVG_PRICE, 0) <= 889
                  THEN 2
                  WHEN ROUND(A.AVG_PRICE, 0)     >= 890
                  AND      ROUND(A.AVG_PRICE, 0) <= 1353
                  THEN 3
                  ELSE 4
         END G_PRICE,
         A.MAX_PRICE,
         A.MIN_PRICE,
         A.VOLUME,
         B.SLFR_DXD SO2,
         B.CRBN_MNXD CO,
         B.OZON O3,
         B.NTRGN_DXD NO2,
         B.PARTICLE_MATTER_10 PM10,
         B.PARTICLE_MATTER_2 PM2,
         C.AVG_TMPRT,
         C.DAY_PRE,
         C.AVG_WND_SPD,
         C.WND_DRCTN,
         C.TOT_DYL_TM,
         C.AVG_CLOUD,
         C.TOT_SOLAR
FROM     AGRICULTURE A,
         FINE_DUST B,
         WEATHER_DATA C
WHERE    (
                  TO_DATE(A.TRADE_DATE, 'YYYY-MM-DD') - 15
         )
                      = TO_DATE(B.MEASURE_DATE(+), 'YYYY-MM-DD')
AND      A.PLACE_NAME = B.SIDO(+)
AND
         (
                  TO_DATE(A.TRADE_DATE, 'YYYY-MM-DD') - 15
         )
                         = TO_DATE(C.MEA_DATE(+), 'YYYY-MM-DD')
AND      A.PLACE_NAME    = C.AREA(+)
AND      A.TRADE_DATE LIKE '2017%'
AND      A.PLACE_NAME    = '부산'
AND      A.MARKET_NAME   = '부산엄궁도매'
ORDER BY TRADE_DATE
```

# in, orderby
```sql
SELECT * FROM WEATHER_DATA_2018 A, FINE_DUST_2018 B
WHERE A.MEA_DATE = B.MEASURE_DATE
AND A.AREA = B.SIDO
AND MEA_DATE BETWEEN '20180611' AND '20180811'
AND AREA IN ('충북')
ORDER BY MEA_DATE, AREA
```

# 30일 전 날씨, 농산물 
```SQL
SELECT   A.PLACE_NAME,
         A.MARKET_NAME,
         SUBSTR(A.TRADE_DATE,0,4)
                  || '-'
                  || SUBSTR(A.TRADE_DATE,5,2)
                  || '-'
                  || SUBSTR(A.TRADE_DATE,7,2) TRADE_DATE,
         A.AVG_PRICE,
         CASE
                  WHEN ROUND(B.PARTICLE_MATTER_10, 1)     >= 0
                  AND      ROUND(B.PARTICLE_MATTER_10, 1) <= 30
                  THEN 1
                  WHEN ROUND(B.PARTICLE_MATTER_10, 1)     >= 31
                  AND      ROUND(B.PARTICLE_MATTER_10, 1) <= 80
                  THEN 2
                  WHEN ROUND(B.PARTICLE_MATTER_10, 1)     >= 81
                  AND      ROUND(B.PARTICLE_MATTER_10, 1) <= 150
                  THEN 3
                  ELSE 4
         END G_PM10,
         CASE
                  WHEN ROUND(B.PARTICLE_MATTER_2, 1)     >= 0
                  AND      ROUND(B.PARTICLE_MATTER_2, 1) <= 15
                  THEN 1
                  WHEN ROUND(B.PARTICLE_MATTER_2, 1)     >= 16
                  AND      ROUND(B.PARTICLE_MATTER_2, 1) <= 35
                  THEN 2
                  WHEN ROUND(B.PARTICLE_MATTER_2, 1)     >= 36
                  AND      ROUND(B.PARTICLE_MATTER_2, 1) <= 75
                  THEN 3
                  ELSE 4
         END G_PM2,
         CASE
                  WHEN ROUND(A.AVG_PRICE, 0)     >= 0
                  AND      ROUND(A.AVG_PRICE, 0) <= 642
                  THEN 1
                  WHEN ROUND(A.AVG_PRICE, 0)     >= 643
                  AND      ROUND(A.AVG_PRICE, 0) <= 847
                  THEN 2
                  WHEN ROUND(A.AVG_PRICE, 0)     >= 848
                  AND      ROUND(A.AVG_PRICE, 0) <= 1203
                  THEN 3
                  ELSE 4
         END G_PRICE,
         CASE
                  WHEN ROUND(C.AVG_CLOUD, 1)     >= 0
                  AND      ROUND(C.AVG_CLOUD, 1) <= 2
                  THEN 1
                  WHEN ROUND(C.AVG_CLOUD, 1)     >= 3
                  AND      ROUND(C.AVG_CLOUD, 1) <= 5
                  THEN 2
                  WHEN ROUND(C.AVG_CLOUD, 1)     >= 6
                  AND      ROUND(C.AVG_CLOUD, 1) <= 8
                  THEN 3
                  ELSE 4
         END G_CLOUD,
         A.MAX_PRICE,
         A.MIN_PRICE,
         A.VOLUME,
         B.SLFR_DXD SO2,
         B.CRBN_MNXD CO,
         B.OZON O3,
         B.NTRGN_DXD NO2,
         B.PARTICLE_MATTER_10 PM10,
         B.PARTICLE_MATTER_2 PM2,
         C.AVG_TMPRT,
         C.DAY_PRE,
         C.AVG_WND_SPD,
         C.WND_DRCTN,
         C.TOT_DYL_TM,
         C.AVG_CLOUD,
         C.TOT_SOLAR
FROM     AGRICULTURE A,
         FINE_DUST B,
         WEATHER_DATA C
WHERE    (
                  TO_DATE(A.TRADE_DATE, 'YYYY-MM-DD') - 30
         )
                      = TO_DATE(B.MEASURE_DATE(+), 'YYYY-MM-DD')
AND      A.PLACE_NAME = B.SIDO(+)
AND
         (
                  TO_DATE(A.TRADE_DATE, 'YYYY-MM-DD') - 30
         )
                         = TO_DATE(C.MEA_DATE(+), 'YYYY-MM-DD')
AND      A.PLACE_NAME    = C.AREA(+)
AND A.TRADE_DATE BETWEEN '20180523' AND '20180623'
AND      A.PLACE_NAME    = '충북'
AND      A.MARKET_NAME   = '대구북부도매'
ORDER BY TRADE_DATE
```


# 30일전 날짜 
```SQL
SELECT   TRADE_DATE,
         SIDO2,
         ROUND(AVG(AVG_TMPRT), 1),
         ROUND(AVG(DAY_PRE), 1),
         ROUND(AVG(AVG_WND_SPD), 1),
         ROUND(AVG(WND_DRCTN), 1),
         ROUND(AVG(TOT_DYL_TM), 1),
         ROUND(AVG(TOT_SOLAR), 1),
         ROUND(AVG(AVG_CLOUD), 1),
         ROUND(AVG(SLFR_DXD), 3),
         ROUND(AVG(CRBN_MNXD), 1),
         ROUND(AVG(OZON), 3),
         ROUND(AVG(NTRGN_DXD), 3),
         ROUND(AVG(PARTICLE_MATTER_10), 0),
         ROUND(AVG(PARTICLE_MATTER_2), 0)
FROM     ( SELECT *
         FROM    (SELECT MEA_DATE TRADE_DATE,
                         (TO_DATE(MEA_DATE, 'YYYY-MM-DD') - 30) PREV_MONTH,
                         (TO_DATE(MEA_DATE, 'YYYY-MM-DD') - 1) PREV_DAY,
                         AREA SIDO2
                 FROM    WEATHER_DATA
                 WHERE   AREA        = '강원'
                 AND     MEA_DATE LIKE '2018%'
                 )
                 A,
                 (SELECT *
                 FROM    WEATHER_DATA
                 )
                 B,
                 (SELECT *
                 FROM    FINE_DUST
                 )
                 C
         WHERE   A.SIDO2 = B.AREA
         AND     A.SIDO2 = C.SIDO
         AND     TO_DATE(B.MEA_DATE, 'YYYY-MM-DD') BETWEEN A.PREV_MONTH AND     A.PREV_DAY
         AND     TO_DATE(C.MEASURE_DATE, 'YYYY-MM-DD') BETWEEN A.PREV_MONTH AND     A.PREV_DAY
         )
GROUP BY TRADE_DATE,
         SIDO2
ORDER BY TRADE_DATE
```


# 30일전 날짜 PART 2
```SQL
SELECT A.TRADE_DATE,
       A.MARKET_NAME,
       A.PLACE_NAME,
       A.AVG_PRICE,
       B.AVG_CLOUD,
       B.TOT_SOLAR,
       B.TOT_DYL_TM,
       B.WND_DRCTN,
       B.AVG_WND_SPD,
       B.DAY_PRE,
       B.AVG_TMPRT,
       B.PM2,
       B.PM10,
       B.NTRGN_DXD,
       B.OZON,
       B.CRBN_MNXD,
       B.SLFR_DXD
FROM   AGRICULTURE A,
       (SELECT  MEA_DATE,
                SIDO2,
                ROUND(AVG(AVG_TMPRT), 1) AVG_TMPRT,
                ROUND(AVG(DAY_PRE), 1) DAY_PRE,
                ROUND(AVG(AVG_WND_SPD), 1) AVG_WND_SPD,
                ROUND(AVG(WND_DRCTN), 1) WND_DRCTN,
                ROUND(AVG(TOT_DYL_TM), 1) TOT_DYL_TM,
                ROUND(AVG(TOT_SOLAR), 1) TOT_SOLAR,
                ROUND(AVG(AVG_CLOUD), 1) AVG_CLOUD,
                ROUND(AVG(SLFR_DXD), 3) SLFR_DXD,
                ROUND(AVG(CRBN_MNXD), 1) CRBN_MNXD,
                ROUND(AVG(OZON), 3) OZON,
                ROUND(AVG(NTRGN_DXD), 3) NTRGN_DXD,
                ROUND(AVG(PARTICLE_MATTER_10), 0) PM10,
                ROUND(AVG(PARTICLE_MATTER_2), 0) PM2
       FROM     ( SELECT A.MEA_DATE,
                        A.SIDO2,
                        B.AVG_TMPRT,
                        B.DAY_PRE,
                        B.AVG_WND_SPD,
                        B.WND_DRCTN,
                        B.TOT_DYL_TM,
                        B.TOT_SOLAR,
                        B.AVG_CLOUD,
                        C.SLFR_DXD,
                        C.CRBN_MNXD,
                        C.OZON,
                        C.NTRGN_DXD,
                        C.PARTICLE_MATTER_10,
                        C.PARTICLE_MATTER_2
                FROM    (SELECT MEA_DATE,
                                (TO_DATE(MEA_DATE, 'YYYY-MM-DD') - 30) PREV_MONTH,
                                (TO_DATE(MEA_DATE, 'YYYY-MM-DD') - 1) PREV_DAY,
                                AREA SIDO2
                        FROM    WEATHER_DATA
                        WHERE   AREA        = '충북'
                        AND     MEA_DATE LIKE '2018%'
                        )
                        A,
                        (SELECT AREA,
                                MEA_DATE,
                                AVG_TMPRT,
                                DAY_PRE,
                                AVG_WND_SPD,
                                WND_DRCTN,
                                TOT_DYL_TM,
                                TOT_SOLAR,
                                AVG_CLOUD
                        FROM    WEATHER_DATA
                        )
                        B,
                        (SELECT SIDO,
                                MEASURE_DATE,
                                SLFR_DXD,
                                CRBN_MNXD,
                                OZON,
                                NTRGN_DXD,
                                PARTICLE_MATTER_10,
                                PARTICLE_MATTER_2
                        FROM    FINE_DUST
                        )
                        C
                WHERE   A.SIDO2 = B.AREA
                AND     A.SIDO2 = C.SIDO
                AND     TO_DATE(B.MEA_DATE, 'YYYY-MM-DD') BETWEEN A.PREV_MONTH AND     A.PREV_DAY
                AND     TO_DATE(C.MEASURE_DATE, 'YYYY-MM-DD') BETWEEN A.PREV_MONTH AND     A.PREV_DAY
                )
       GROUP BY MEA_DATE,
                SIDO2
       ORDER BY MEA_DATE
       )
       B
WHERE  A.TRADE_DATE = B.MEA_DATE
AND    A.PLACE_NAME = B.SIDO2
```

# 3개년도 SUM
'''SQL
SELECT A.TRADE_DATE,
       A.MARKET_NAME,
       A.PLACE_NAME,
       CASE
              WHEN ROUND(A.AVG_PRICE, 0)   >= 0
              AND    ROUND(A.AVG_PRICE, 0) <= 710
              THEN 1
              WHEN ROUND(A.AVG_PRICE, 0)   >= 711
              AND    ROUND(A.AVG_PRICE, 0) <= 1044
              THEN 2
              WHEN ROUND(A.AVG_PRICE, 0)   >= 1045
              AND    ROUND(A.AVG_PRICE, 0) <= 1362
              THEN 3
              ELSE 4
       END G_PRICE,
       CASE
                  WHEN ROUND(B.PM10, 1)     >= 0
                  AND      ROUND(B.PM10, 1) <= 30
                  THEN 1
                  WHEN ROUND(B.PM10, 1)     >= 31
                  AND      ROUND(B.PM10, 1) <= 80
                  THEN 2
                  WHEN ROUND(B.PM10, 1)     >= 81
                  AND      ROUND(B.PM10, 1) <= 150
                  THEN 3
                  ELSE 4
         END G_PM10,
         CASE
                  WHEN ROUND(B.PM2, 1)     >= 0
                  AND      ROUND(B.PM2, 1) <= 15
                  THEN 1
                  WHEN ROUND(B.PM2, 1)     >= 16
                  AND      ROUND(B.PM2, 1) <= 35
                  THEN 2
                  WHEN ROUND(B.PM2, 1)     >= 36
                  AND      ROUND(B.PM2, 1) <= 75
                  THEN 3
                  ELSE 4
         END G_PM2,
         CASE
                  WHEN ROUND(B.AVG_CLOUD, 1)     >= 0
                  AND      ROUND(B.AVG_CLOUD, 1) <= 2
                  THEN 1
                  WHEN ROUND(B.AVG_CLOUD, 1)     >= 3
                  AND      ROUND(B.AVG_CLOUD, 1) <= 5
                  THEN 2
                  WHEN ROUND(B.AVG_CLOUD, 1)     >= 6
                  AND      ROUND(B.AVG_CLOUD, 1) <= 8
                  THEN 3
                  ELSE 4
         END G_CLOUD,
       A.AVG_PRICE,
       B.AVG_CLOUD,
       B.TOT_SOLAR,
       B.TOT_DYL_TM,
       B.WND_DRCTN,
       B.AVG_WND_SPD,
       B.DAY_PRE,
       B.AVG_TMPRT,
       B.PM2,
       B.PM10,
       B.NTRGN_DXD,
       B.OZON,
       B.CRBN_MNXD,
       B.SLFR_DXD
FROM   AGRICULTURE A,
       (SELECT  MEA_DATE,
                SIDO2,
                ROUND(AVG(AVG_TMPRT), 1) AVG_TMPRT,
                ROUND(SUM(DAY_PRE), 1) DAY_PRE,
                ROUND(AVG(AVG_WND_SPD), 1) AVG_WND_SPD,
                ROUND(AVG(WND_DRCTN), 1) WND_DRCTN,
                ROUND(SUM(TOT_DYL_TM), 1) TOT_DYL_TM,
                ROUND(SUM(TOT_SOLAR), 1) TOT_SOLAR,
                ROUND(SUM(AVG_CLOUD), 1) AVG_CLOUD,
                ROUND(AVG(SLFR_DXD), 3) SLFR_DXD,
                ROUND(AVG(CRBN_MNXD), 1) CRBN_MNXD,
                ROUND(AVG(OZON), 3) OZON,
                ROUND(AVG(NTRGN_DXD), 3) NTRGN_DXD,
                ROUND(AVG(PARTICLE_MATTER_10), 0) PM10,
                ROUND(AVG(PARTICLE_MATTER_2), 0) PM2
       FROM     ( SELECT A.MEA_DATE,
                        A.SIDO2,
                        B.AVG_TMPRT,
                        B.DAY_PRE,
                        B.AVG_WND_SPD,
                        B.WND_DRCTN,
                        B.TOT_DYL_TM,
                        B.TOT_SOLAR,
                        B.AVG_CLOUD,
                        C.SLFR_DXD,
                        C.CRBN_MNXD,
                        C.OZON,
                        C.NTRGN_DXD,
                        C.PARTICLE_MATTER_10,
                        C.PARTICLE_MATTER_2
                FROM    (SELECT MEA_DATE,
                                (TO_DATE(MEA_DATE, 'YYYY-MM-DD') - 48) PREV_MONTH,
                                (TO_DATE(MEA_DATE, 'YYYY-MM-DD') - 1) PREV_DAY,
                                AREA SIDO2
                        FROM    WEATHER_DATA
                        WHERE AREA = '충북' 
                        AND SUBSTR(MEA_DATE,0,4) BETWEEN '2015' AND '2018'
                        )
                        A,
                        (SELECT AREA,
                                MEA_DATE,
                                AVG_TMPRT,
                                DAY_PRE,
                                AVG_WND_SPD,
                                WND_DRCTN,
                                TOT_DYL_TM,
                                TOT_SOLAR,
                                AVG_CLOUD
                        FROM    WEATHER_DATA
                        )
                        B,
                        (SELECT SIDO,
                                MEASURE_DATE,
                                SLFR_DXD,
                                CRBN_MNXD,
                                OZON,
                                NTRGN_DXD,
                                PARTICLE_MATTER_10,
                                PARTICLE_MATTER_2
                        FROM    FINE_DUST
                        )
                        C
                WHERE   A.SIDO2 = B.AREA
                AND     A.SIDO2 = C.SIDO
                AND     TO_DATE(B.MEA_DATE, 'YYYY-MM-DD') BETWEEN A.PREV_MONTH AND     A.PREV_DAY
                AND     TO_DATE(C.MEASURE_DATE, 'YYYY-MM-DD') BETWEEN A.PREV_MONTH AND     A.PREV_DAY
                )
       GROUP BY MEA_DATE,
                SIDO2
       ORDER BY MEA_DATE
       )
       B
WHERE  A.TRADE_DATE = B.MEA_DATE
AND    A.PLACE_NAME = B.SIDO2
AND A.PLACE_NAME = '충북'
AND A.MARKET_NAME = '대구북부도매'
```

```SQL
SELECT A.TRADE_DATE,
       A.MARKET_NAME,
       A.PLACE_NAME,
       CASE
              WHEN ROUND(A.AVG_PRICE, 0)   >= 0
              AND    ROUND(A.AVG_PRICE, 0) <= 710
              THEN 1
              WHEN ROUND(A.AVG_PRICE, 0)   >= 711
              AND    ROUND(A.AVG_PRICE, 0) <= 1044
              THEN 2
              WHEN ROUND(A.AVG_PRICE, 0)   >= 1045
              AND    ROUND(A.AVG_PRICE, 0) <= 1362
              THEN 3
              ELSE 4
       END G_PRICE,
       CASE
                  WHEN ROUND(B.PM10, 1)     >= 0
                  AND      ROUND(B.PM10, 1) <= 30
                  THEN 1
                  WHEN ROUND(B.PM10, 1)     >= 31
                  AND      ROUND(B.PM10, 1) <= 80
                  THEN 2
                  WHEN ROUND(B.PM10, 1)     >= 81
                  AND      ROUND(B.PM10, 1) <= 150
                  THEN 3
                  ELSE 4
         END G_PM10,
         CASE
                  WHEN ROUND(B.PM2, 1)     >= 0
                  AND      ROUND(B.PM2, 1) <= 15
                  THEN 1
                  WHEN ROUND(B.PM2, 1)     >= 16
                  AND      ROUND(B.PM2, 1) <= 35
                  THEN 2
                  WHEN ROUND(B.PM2, 1)     >= 36
                  AND      ROUND(B.PM2, 1) <= 75
                  THEN 3
                  ELSE 4
         END G_PM2,
         CASE
                  WHEN ROUND(B.AVG_CLOUD, 1)     >= 0
                  AND      ROUND(B.AVG_CLOUD, 1) <= 2
                  THEN 1
                  WHEN ROUND(B.AVG_CLOUD, 1)     >= 3
                  AND      ROUND(B.AVG_CLOUD, 1) <= 5
                  THEN 2
                  WHEN ROUND(B.AVG_CLOUD, 1)     >= 6
                  AND      ROUND(B.AVG_CLOUD, 1) <= 8
                  THEN 3
                  ELSE 4
         END G_CLOUD,
       A.AVG_PRICE,
       B.AVG_CLOUD,
       B.TOT_SOLAR,
       B.TOT_DYL_TM,
       B.WND_DRCTN,
       B.AVG_WND_SPD,
       B.DAY_PRE,
       B.AVG_TMPRT,
       B.PM2,
       B.PM10,
       B.NTRGN_DXD,
       B.OZON,
       B.CRBN_MNXD,
       B.SLFR_DXD
FROM   AGRICULTURE A,
       (SELECT  MEA_DATE,
                SIDO2,
                ROUND(AVG(AVG_TMPRT), 1) AVG_TMPRT,
                ROUND(SUM(DAY_PRE), 1) DAY_PRE,
                ROUND(AVG(AVG_WND_SPD), 1) AVG_WND_SPD,
                ROUND(AVG(WND_DRCTN), 1) WND_DRCTN,
                ROUND(SUM(TOT_DYL_TM), 1) TOT_DYL_TM,
                ROUND(SUM(TOT_SOLAR), 1) TOT_SOLAR,
                ROUND(SUM(AVG_CLOUD), 1) AVG_CLOUD,
                ROUND(AVG(SLFR_DXD), 3) SLFR_DXD,
                ROUND(AVG(CRBN_MNXD), 1) CRBN_MNXD,
                ROUND(AVG(OZON), 3) OZON,
                ROUND(AVG(NTRGN_DXD), 3) NTRGN_DXD,
                ROUND(AVG(PARTICLE_MATTER_10), 0) PM10,
                ROUND(AVG(PARTICLE_MATTER_2), 0) PM2
       FROM     ( SELECT A.MEA_DATE,
                        A.SIDO2,
                        B.AVG_TMPRT,
                        B.DAY_PRE,
                        B.AVG_WND_SPD,
                        B.WND_DRCTN,
                        B.TOT_DYL_TM,
                        B.TOT_SOLAR,
                        B.AVG_CLOUD,
                        B.SLFR_DXD,
                        B.CRBN_MNXD,
                        B.OZON,
                        B.NTRGN_DXD,
                        B.PARTICLE_MATTER_10,
                        B.PARTICLE_MATTER_2
                FROM    (SELECT MEA_DATE,
                                (TO_DATE(MEA_DATE, 'YYYY-MM-DD') - 48) PREV_MONTH,
                                (TO_DATE(MEA_DATE, 'YYYY-MM-DD') - 1) PREV_DAY,
                                AREA SIDO2
                        FROM    WEATHER_DATA
                        WHERE AREA = '경남' 
                        AND MEA_DATE LIKE '2010%'
                        )
                        A,
                        (SELECT A.AREA,
                                A.MEA_DATE,
                                A.AVG_TMPRT,
                                A.DAY_PRE,
                                A.AVG_WND_SPD,
                                A.WND_DRCTN,
                                A.TOT_DYL_TM,
                                A.TOT_SOLAR,
                                A.AVG_CLOUD,
                                B.SLFR_DXD,
                                B.CRBN_MNXD,
                                B.OZON,
                                B.NTRGN_DXD,
                                B.PARTICLE_MATTER_10,
                                B.PARTICLE_MATTER_2
                        FROM    WEATHER_DATA A, FINE_DUST B
                        WHERE A.AREA = B.SIDO
                        AND A.MEA_DATE = B.MEASURE_DATE
                        )
                        B
                      
                WHERE   A.SIDO2 = B.AREA
                AND     TO_DATE(B.MEA_DATE, 'YYYY-MM-DD') BETWEEN A.PREV_MONTH AND     A.PREV_DAY
                )
       GROUP BY MEA_DATE,
                SIDO2
       ORDER BY MEA_DATE
       )
       B
WHERE  A.TRADE_DATE = B.MEA_DATE
AND    A.PLACE_NAME = B.SIDO2
AND A.PLACE_NAME = '경남'
AND A.MARKET_NAME = '부산반여도매'
AND SUBSTR(A.TRADE_DATE,5,2) IN ('06', '07', '08', '09', '10') 
```

# 0627 습도 추가
```SQL
SELECT A.TRADE_DATE,
       A.MARKET_NAME,
       A.PLACE_NAME,
       CASE
              WHEN ROUND(A.AVG_PRICE, 0)   >= 0
              AND    ROUND(A.AVG_PRICE, 0) <= 710
              THEN 1
              WHEN ROUND(A.AVG_PRICE, 0)   >= 711
              AND    ROUND(A.AVG_PRICE, 0) <= 1044
              THEN 2
              WHEN ROUND(A.AVG_PRICE, 0)   >= 1045
              AND    ROUND(A.AVG_PRICE, 0) <= 1362
              THEN 3
              ELSE 4
       END G_PRICE,
       CASE
              WHEN ROUND(B.PM10, 1)   >= 0
              AND    ROUND(B.PM10, 1) <= 30
              THEN 1
              WHEN ROUND(B.PM10, 1)   >= 31
              AND    ROUND(B.PM10, 1) <= 80
              THEN 2
              WHEN ROUND(B.PM10, 1)   >= 81
              AND    ROUND(B.PM10, 1) <= 150
              THEN 3
              ELSE 4
       END G_PM10,
       CASE
              WHEN ROUND(B.PM2, 1)   >= 0
              AND    ROUND(B.PM2, 1) <= 15
              THEN 1
              WHEN ROUND(B.PM2, 1)   >= 16
              AND    ROUND(B.PM2, 1) <= 35
              THEN 2
              WHEN ROUND(B.PM2, 1)   >= 36
              AND    ROUND(B.PM2, 1) <= 75
              THEN 3
              ELSE 4
       END G_PM2,
       CASE
              WHEN ROUND(B.AVG_CLOUD, 1)   >= 0
              AND    ROUND(B.AVG_CLOUD, 1) <= 2
              THEN 1
              WHEN ROUND(B.AVG_CLOUD, 1)   >= 3
              AND    ROUND(B.AVG_CLOUD, 1) <= 5
              THEN 2
              WHEN ROUND(B.AVG_CLOUD, 1)   >= 6
              AND    ROUND(B.AVG_CLOUD, 1) <= 8
              THEN 3
              ELSE 4
       END G_CLOUD,
       A.AVG_PRICE,
       B.AVG_CLOUD,
       B.TOT_SOLAR,
       B.TOT_DYL_TM,
       B.WND_DRCTN,
       B.AVG_WND_SPD,
       B.DAY_PRE,
       B.AVG_TMPRT,
       B.MIN_TMPRT,
       B.MAX_TMPRT,
       B.DAILY_TMPRT,
       B.AVG_HUMID,
       B.TOT_DYL_HR,
       B.AVG_GTMPRT,
       B.PM2,
       B.PM10,
       B.NTRGN_DXD,
       B.OZON,
       B.CRBN_MNXD,
       B.SLFR_DXD
FROM   AGRICULTURE A,
       (SELECT  MEA_DATE,
                SIDO2,
                ROUND(AVG(AVG_TMPRT), 1) AVG_TMPRT,
                ROUND(SUM(DAY_PRE), 1) DAY_PRE,
                ROUND(AVG(AVG_WND_SPD), 1) AVG_WND_SPD,
                ROUND(AVG(WND_DRCTN), 1) WND_DRCTN,
                ROUND(SUM(TOT_DYL_TM), 1) TOT_DYL_TM,
                ROUND(SUM(TOT_SOLAR), 1) TOT_SOLAR,
                ROUND(SUM(AVG_CLOUD), 1) AVG_CLOUD,
                ROUND(AVG(MIN_TMPRT), 1) MIN_TMPRT,
                ROUND(AVG(MAX_TMPRT), 1) MAX_TMPRT,
                ROUND(AVG(DAILY_TMPRT), 1) DAILY_TMPRT,
                ROUND(AVG(AVG_HUMID), 1) AVG_HUMID,
                ROUND(SUM(TOT_DYL_HR), 1) TOT_DYL_HR,
                ROUND(AVG(AVG_GTMPRT), 1) AVG_GTMPRT,
                ROUND(AVG(SLFR_DXD), 3) SLFR_DXD,
                ROUND(AVG(CRBN_MNXD), 1) CRBN_MNXD,
                ROUND(AVG(OZON), 3) OZON,
                ROUND(AVG(NTRGN_DXD), 3) NTRGN_DXD,
                ROUND(AVG(PARTICLE_MATTER_10), 0) PM10,
                ROUND(AVG(PARTICLE_MATTER_2), 0) PM2
       FROM     ( SELECT A.MEA_DATE,
                        A.SIDO2,
                        B.AVG_TMPRT,
                        B.DAY_PRE,
                        B.AVG_WND_SPD,
                        B.WND_DRCTN,
                        B.TOT_DYL_TM,
                        B.TOT_SOLAR,
                        B.AVG_CLOUD,
                        B.MIN_TMPRT,
                        B.MAX_TMPRT,
                        B.DAILY_TMPRT,
                        B.AVG_HUMID,
                        B.TOT_DYL_HR,
                        B.AVG_GTMPRT,
                        B.SLFR_DXD,
                        B.CRBN_MNXD,
                        B.OZON,
                        B.NTRGN_DXD,
                        B.PARTICLE_MATTER_10,
                        B.PARTICLE_MATTER_2
                FROM    (SELECT MEA_DATE,
                                (TO_DATE(MEA_DATE, 'YYYY-MM-DD') - 50) PREV_MONTH,
                                (TO_DATE(MEA_DATE, 'YYYY-MM-DD') - 5) PREV_DAY,
                                AREA SIDO2
                        FROM    WEATHER_DATA
                        WHERE   AREA        = '경남'
                        AND     MEA_DATE LIKE '2010%'
                        )
                        A,
                        (SELECT A.AREA,
                                A.MEA_DATE,
                                A.AVG_TMPRT,
                                A.DAY_PRE,
                                A.AVG_WND_SPD,
                                A.WND_DRCTN,
                                A.TOT_DYL_TM,
                                A.TOT_SOLAR,
                                A.AVG_CLOUD,
                                A.MIN_TMPRT,
                                A.MAX_TMPRT,
                                A.DAILY_TMPRT,
                                A.AVG_HUMID,
                                A.TOT_DYL_HR,
                                A.AVG_GTMPRT,
                                B.SLFR_DXD,
                                B.CRBN_MNXD,
                                B.OZON,
                                B.NTRGN_DXD,
                                B.PARTICLE_MATTER_10,
                                B.PARTICLE_MATTER_2
                        FROM    WEATHER_DATA A,
                                FINE_DUST B
                        WHERE   A.AREA     = B.SIDO
                        AND     A.MEA_DATE = B.MEASURE_DATE
                        )
                        B
                WHERE   A.SIDO2 = B.AREA
                AND     TO_DATE(B.MEA_DATE, 'YYYY-MM-DD') BETWEEN A.PREV_MONTH AND     A.PREV_DAY
                )
       GROUP BY MEA_DATE,
                SIDO2
       ORDER BY MEA_DATE
       )
       B
WHERE  A.TRADE_DATE  = B.MEA_DATE
AND    A.PLACE_NAME  = B.SIDO2
AND    A.PLACE_NAME  = '경남'
AND    A.MARKET_NAME = '부산반여도매'
AND    SUBSTR(A.TRADE_DATE,5,2) IN ('06',
                                    '07',
                                    '08',
                                    '09',
                                    '10')
```
