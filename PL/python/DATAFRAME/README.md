# 엑셀 데이터 프레임 요소 빼기
```PYTOHN
avg_data2 = pd.DataFrame(avg_data, columns=["AVG_TMPRT",  "AVG_CLOUD", "DAILY_TMPRT", 'DAY_PRE', 'PM10']).dropna()

for i in range(0, avg_data2['AVG_CLOUD'].count()):
    avg_cloud = avg_data2.iloc[i]['AVG_CLOUD']
    daily_tmprt = avg_data2.iloc[i]['DAILY_TMPRT']
    # day_pre = avg_data2.iloc[i]['DAY_PRE']
    pm10 = avg_data2.iloc[i]['PM10']
    avg_tmprt = avg_data2.iloc[i]['AVG_TMPRT']

   price_result.append(dict[0])
   df_price = pd.DataFrame(price_result)
   df_price.to_excel("test.xlsx")
```
