```python
from sklearn.tree import DecisionTreeClassifier, export_graphviz
from sklearn.datasets import load_breast_cancer
from sklearn.cross_validation import train_test_split
from sklearn.ensemble import  RandomForestClassifier
from sklearn import metrics
import pandas as pd
#Dot to png
import pydot

data = pd.read_excel('강원_대구북부도매_2010_2018_30.xlsx', sheet_name='Sheet1')
# print(data)

# 경남_부산반여_2010_2018_30 52%
# dfx = pd.DataFrame(data, columns=["AVG_TMPRT", "TOT_SOLAR", "AVG_WND_SPD", "AVG_HUMID", 'PM10'])


# 강원 대구북부도매_2010_2018_30; 66%
dfx = pd.DataFrame(data, columns=["AVG_TMPRT", "TOT_SOLAR", "AVG_WND_SPD", "AVG_HUMID", 'PM10'])
# dfx = pd.DataFrame(data, columns=['G_PM10', "PM2", "VOLUME", 'AVG_TMPRT', 'AVG_WND_SPD']).dropna()
dfy = pd.DataFrame(data, columns=["LOG2"])


# 학습 전용과 테스트 전용 데이터로 나누기
data_train, data_test, label_train, label_test = train_test_split(dfx, dfy)


# 데이터 학습시키기
clf = RandomForestClassifier(criterion='entropy')
clf.fit(data_train, label_train.values.ravel())
#
# 데이터 예측하기
predict = clf.predict(data_test)

# 결과 테스트하기
ac_score = metrics.accuracy_score(label_test, predict)
cl_report = metrics.classification_report(label_test, predict)
print("정답률 =", ac_score)
print("리포트 =\n", cl_report)

```
