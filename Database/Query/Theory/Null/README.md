# 모르면 상사한테 혼나는 NULL 관련 함수, NVL, NULLIF, COALESCE

# NVL
* 데이터가 null이면 다른 값 출력
  * nvl(real_name, MEMBER_NAME) NAME1)

# NULLIF
* 왼쪽에 값과 오른쪽의 값이 다르면 NULL을 출력
  * NULLIF(MEMBER_NAME, '수진') NAME2

# COLAESCE
* 인자값 중에서 NULL이 아닌 최초의 값을 출력
  * COLASCE(NULL, REAL_NAME, MEMBER_NAME) NAME3
    * NULL 스킵, REAL_NAME이 NULL이면 스킵
