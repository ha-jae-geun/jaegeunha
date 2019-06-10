
# 
```python
import cx_Oracle as xe
import csv

dsn = xe.makedsn("192.168.0.6", 1521, "xe")
conn = xe.connect("scott", "tiger", dsn)
with conn:
    cur = conn.cursor( )
    csv_file = open("123.csv", encoding='UTF-8')
    csv_reader = csv.reader(csv_file)
    book_list = list(csv_reader)
    book_list = book_list[1:]
    sql = "insert into weather values (:id1, :id2, :id3, :id14, :id5, :id6, :id7, :id8, :id9)"
    cur.executemany(sql, book_list)
    cur.execute('select * from weather')
    print(cur.fetchall())
```
