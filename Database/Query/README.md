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
