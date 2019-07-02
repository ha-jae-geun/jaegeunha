# SVM 정의
* 서포트 벡터 머신(Support Vector Machine)은 약칭으로 SVM이라고 부른다.
* SVM은 데이터 마이닝과 머신러닝에 쓰이는 대표적인 분류 알고리즘 중에 하나로 분류률이 좋은 알고리즘이다.
* SVM은 분류나 회귀에서 사용이 가능하지만 주로 분류에서 사용한다.
* SVM은 의사결정나무, 인공신경망 등의 분류 알고리즘보다 이진 데이터를 분류하는데 더 나은 성능을 보이고 있다.
* SVM은 기본적으로 초평면(Hyperplane)을 이용해서 분류한다.
* 초평면은 어떤 공간이 있을 때에 이 공간의 한 점을 통과하는 해집합이다.
  * 초평면을 좀 더 쉽게 생각하면은 전체 공간보다 차원이 하나 낮은 공간을 의미한다.

## SVM의 장점
* 범주나 수치 예측 문제에 사용하며 오류 데이터에 영향이 없다.
* 과적합이 되는 경우가 적다.
* SVM 알고리즘이 신경망보다 사용하기 쉽도록 구성된 것이 많다.

## SVM의 단점
* 최적의 모델을 찾기 위해서는 여러 개의 조합 테스트가 필요하다.
* 커널과 모델에서 다양한 테스트가 필요하다.
* 입력 데이터 세트에서 개수와 속성수가 많을 경우에는 학습 속도가 느려질 수 있다.
* 해석이 불가능한 것은 아니지만 해석이 어렵고 복잡한 블랙박스 형태로 되어 있다.

```PYTHON
from sklearn import svm, metrics
from sklearn.model_selection import train_test_split
import matplotlib.pyplot as plt
import pandas as pd

data = pd.read_excel('강원_대구북부도매_2010_2018_30.xlsx', sheet_name='Sheet1')
# print(data)

# 경남_부산반여_2010_2018_30
dfx = pd.DataFrame(data, columns=["AVG_TMPRT", "TOT_SOLAR", "AVG_WND_SPD", "AVG_HUMID", 'PM10'])
# dfx = pd.DataFrame(data, columns=['G_PM10', "PM2", "VOLUME", 'AVG_TMPRT', 'AVG_WND_SPD']).dropna()
dfy = pd.DataFrame(data, columns=["LOG"])

# 학습 전용과 테스트 전용 데이터로 나누기
data_train, data_test, label_train, label_test = train_test_split(dfx, dfy)


# 데이터 학습하기 --- (※4)
clf = svm.SVC()
clf.fit(data_train, label_train)
# 데이터 예측하기 --- (※5)
predict = clf.predict(data_test)
# 결과 테스트하기 --- (※6)
ac_score = metrics.accuracy_score(label_test, predict)
cl_report = metrics.classification_report(label_test, predict)
print("정답률 =", ac_score)
print("리포트 =\n", cl_report)
```
