```python
from sklearn.linear_model import Lasso
import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn import metrics

data = pd.read_excel('경남_부산반여_2010_2018_30.xlsx', sheet_name='Sheet1')
# print(data)

log_price = []
log_tmprt = []
for i in data['AVG_PRICE']:
    log_price.append(10*round(np.log10(i),1))

# 로그 가격으로 변경
data['AVG_PRICE'] = log_price

for i in data['PM10']:
    log_tmprt.append(10*round(np.log10(i),1))

# 로그 가격으로 변경
data['PM10'] = log_tmprt



dfx = pd.DataFrame(data, columns=["AVG_TMPRT", "TOT_SOLAR",   "DAY_PRE",  'PM10', 'DAILY_TMPRT'])
dfy = pd.DataFrame(data, columns=["AVG_PRICE"])

# data['AVG_PRICE'].to_excel('aaa.xlsx')


data_train, data_test, label_train, label_test = train_test_split(dfx, dfy)

clf = Lasso()
clf.fit(data_train, label_train)

pre = clf.predict(data_test)

# pre.to_excel('aaa.xlsx')

print(pre)

list_pre =[]
for i in pre:
    list_pre.append([round(i, 0)])

# print(list_pre)

# 결과 테스트하기
ac_score = metrics.accuracy_score(label_test, list_pre)
cl_report = metrics.classification_report(label_test, list_pre)
print("정답률 =", ac_score)
print("리포트 =\n", cl_report)
#

```
