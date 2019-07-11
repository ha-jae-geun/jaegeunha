# 텐서
- 텐서: 학습 데이터가 저장되는 타입을 가지는 다차원 배열

# 설치
1. ① 파이썬 버전 확인
⎼ tensorflow 라이브러리는 현재 파이썬 3.6 버전이하에서만 지원하고 있다.
- (base) C:\Windows\system32> python --version

2. ② 가상환경 생성
⎼ tensorflow라는 이름으로 파이썬 3.6 버전을 사용하는 가상환경을 생성한다.
- (base) C:\Windows\system32> conda create -n tensorflow python=3.6

3. ③ 가상환경 활성화
⎼ 생성된 tensorflow 가상환경을 활성화한다.
- (base) C:\Windows\system32> conda activate tensorflow

4. ④ tensorflow 설치
⎼ pip 패키지 관리도구를 설치한다.
- (base) C:\Windows\system32> pip install tensorflow
⎼ 기존에 설치가 되어있으면 pip install --ignore-installed --upgrade tensorflow 라고

```python
import tensorflow as tf
import numpy as np

from pandas.io.parsers import read_csv



model = tf.initialize_all_variables()


#
data = read_csv('Seoul_2010_2018_csv.csv', sep=',')


# data = read_csv('price data.csv', sep=',')

xy = np.array(data, dtype=np.float32)



# 4개의 변인을 입력을 받습니다.

x_data = xy[:, 1:]

# print(x_data)


# 가격 값을 입력 받습니다.

y_data = xy[:, [0]]
# print(y_data)


# 플레이스 홀더를 설정합니다.

X = tf.placeholder(tf.float32, shape=[None, 8])
# print(X)

Y = tf.placeholder(tf.float32, shape=[None, 1])
# print(Y)

W = tf.Variable(tf.random_normal([8, 1]), name="weight")
# print(W)

b = tf.Variable(tf.random_normal([1]), name="bias")
# print(b)


# 가설을 설정합니다.

hypothesis = tf.matmul(X, W) + b



# 비용 함수를 설정합니다.

cost = tf.reduce_mean(tf.square(hypothesis - Y))



# 최적화 함수를 설정합니다.

optimizer = tf.train.GradientDescentOptimizer(learning_rate=0.000005)

train = optimizer.minimize(cost)



# 세션을 생성합니다.

sess = tf.Session()



# 글로벌 변수를 초기화합니다.

sess.run(tf.global_variables_initializer())



# 학습을 수행합니다.

for step in range(50001):

    cost_, hypo_, _ = sess.run([cost, hypothesis, train], feed_dict={X: x_data, Y: y_data})

    if step % 500 == 0:

        print("#", step, " 손실 비용: ", cost_)

        print("- 배추 가격: ", hypo_[0])



# # 학습된 모델을 저장합니다.

saver = tf.train.Saver()

save_path = saver.save(sess, "./saved.cpkt")

print('학습된 모델을 저장했습니다.')



```

# 랜덤 가중치
```python
import tensorflow as tf

import numpy as np

from pandas.io.parsers import read_csv

import os

# os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

model = tf.global_variables_initializer()
#
data = read_csv('서울_서울소매_2010_2017(2)_03_2_강수.csv', sep=',', engine='python')


# data = read_csv('price data.csv', sep=',')

xy = np.array(data, dtype=np.float32)



# 4개의 변인을 입력을 받습니다.

x_data = xy[:, 0:-1]

# print(x_data)


# 가격 값을 입력 받습니다.

y_data = xy[:, [-1]]
# print(y_data)

# 가중치
# w_data = [-12.6495, 8.4675, -146.2447, -702.2301, -9.6260]
# print(w_data)

# 플레이스 홀더를 설정합니다.

X = tf.placeholder(tf.float32, shape=[None, 4])
# print(X)

Y = tf.placeholder(tf.float32, shape=[None, 1])
# print(Y)

W = tf.Variable(tf.random_normal([4, 1]), name="weight")

# W = tf.Variable(tf.random_normal([8, 1]), name="weight")
# print(W)

b = tf.Variable(tf.random_normal([1]), name="bias")
# b = tf.Variable(tf.random_normal([1]), name="bias")
# print(b)


# 가설을 설정합니다.

hypothesis = tf.matmul(X, W) + b



# 비용 함수를 설정합니다.

cost = tf.reduce_mean(tf.square(hypothesis - Y))



# 최적화 함수를 설정합니다.

optimizer = tf.train.GradientDescentOptimizer(learning_rate=0.00001)
# optimizer = tf.train.GradientDescentOptimizer(learning_rate=0.0000005)
# optimizer = tf.train.ProximalGradientDescentOptimizer(learning_rate=0.0000005)

train = optimizer.minimize(cost)



# 세션을 생성합니다.

sess = tf.Session()



# 글로벌 변수를 초기화합니다.

sess.run(tf.global_variables_initializer())



# 학습을 수행합니다.
for step in range(500000):

    cost_, hypo_, _ = sess.run([cost, hypothesis, train], feed_dict={X: x_data, Y: y_data})

    if step % 1000 == 0:

        print("#", step, " 손실 비용: ", cost_)

        print("- 배추 가격: ", hypo_[0])



# 학습된 모델을 저장합니다.

saver = tf.train.Saver()

save_path = saver.save(sess, "./saved.cpkt")

print('학습된 모델을 저장했습니다.')




```
