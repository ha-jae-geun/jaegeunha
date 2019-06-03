# SQL 순서
1. FROM clause
2. WHERE clause
3. GROUP BY clause
4. HAVING clause
5. SELECT clause
6. ORDER BY clause

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

- GROUP BY에 별명 
