```python
from sklearn.covariance import
from sklearn.model_selection import train_test_split
from sklearn import metrics
import pandas as pd
import numpy as np

data = pd.read_excel('경남_부산반여_2010_2018_30.xlsx', sheet_name='Sheet1')
# print(data)

log_price = []
for i in data['AVG_PRICE']:
    log_price.append(10 * round(np.log10(i),1))

# 로그 가격으로 변경
data['AVG_PRICE'] = log_price

dfx = pd.DataFrame(data, columns=["AVG_TMPRT", "TOT_SOLAR", "DAY_PRE",  'PM10', 'DAILY_TMPRT'])
dfy = pd.DataFrame(data, columns=["AVG_PRICE"])

data_train, data_test, label_train, label_test = train_test_split(dfx, dfy)

clf = LinearRegression()
clf.fit(data_train, label_train)

pre = clf.predict(data_test)

list_pre =[]
for i in pre:
    list_pre.append([round(i[0], 0)])

# print(list_pre)

print(metrics.accuracy_score(label_test, list_pre))
# print(score)


# model = smf.ols(formula = 'AVG_PRICE ~ AVG_TMPRT + TOT_SOLAR + PM10 + DAILY_TMPRT', data = data)
# result = model.fit()
# print(result.summary())





```
