# 데이터 세트
* 데이터의 체계적인 집합
* 관계형 데이터베이스 -> 표준 SQL/ 플레이스홀더
* NoSQL -> Json -> tdb/몽고디비/카산드라

# 텍스트 데이터
* 텍스트 데이터는 특수하게 줄바꿈과 탭 등의 제어 문자도 포함되어 있다.
* 코드영역: 텍스트

## 바이너리 데이터
* 0과 1중 하나
* 텍스트 데이터 제외한 데이터
* 데이터 영역: 바이너리

# 메모리
* 코드영역: 텍스트
* 데이터 영역: 바이너리
* 힙영역
* 스택 영역


# openpyxl
## 엑셀 시트 변경, 컬럼 
```python
from openpyxl import load_workbook
file = 'grade_xlsx.xlsx'
wb = load_workbook(filename=file)
sheet = wb.active

ss_sheet = wb.get_sheet_by_name('Fruit')

ss_sheet.title = 'English'
ss_sheet.cell(row=1, column=6).value = 'practice'
wb.save("grade_xlsx.xlsx")
```


# csv
* CSV 파일은 JSON 파일처럼 데이터 저장을 위해 구조화된 형식을 가진 파일이다.
* CSV 파일로 저장된 파일은 엑셀에서 읽어올 수 있다.
* CSV 파일이 유니코드를 지원하지 않을 경우에는 기존의 CSV 파일을 엑셀에서 다시 호출하여 다른 이름으로 재저장하면 된다.
* CSV 파일로 저장된 파일은 소프트웨어 간에 데이터 교환을 할 때 유용하게 사용된다.
* ,(콤마)로 데이터를 구분하기 때문에 엑셀 파일을 사용하는 것보다 CSV 파일을 더 많이 사용한다.
