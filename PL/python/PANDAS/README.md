# Series 자료형
⎼ 1차원의 동일한 자료형을 가지는 배열이다.
⎼ DataFrame 자료형에서는 열이 된다.

# DataFrame 자료형
⎼ 2차원으로 크기의 변경이 가능한 테이블 구조이다.
⎼ 하나의 DataFrame 자료형는 다양한 자료형의 입력이 가능하다.
- DataFrame은 Series와 다르게 각 열에서는 다른 자료형을 가질 수 있으므로 서로 다른 종류의 값을
가질 수 있다.
- DataFrame은 Series 인스턴스들이 DataFrame의 열로 들어가는 구조이다.

## DataFrame 옵션
- DataFrame는 다음과 같은 옵션을 가지고 있다.
- ① data 옵션 : 실제 데이터의 값
- ② index 옵션 : 실제 데이터에 접근할 행의 이름
- ③ dtype 옵션 : 자료형
- ④ columns 옵션 : 실제 데이터에 접근할 열의 이름

```python

```


# Merge
```java
outer join 방식은 키 값이 한쪽에만 있어도 데이터를 보여준다.
pd.merge(df1, df2, how='outer')

* left, right 방식은 각각 첫번째, 혹은 두번째 데이터프레임의 키 값을 모두 보여준다.
pd.merge(df1, df2, how='left')

일반 데이터 열이 아닌 인덱스를 기준열로 사용하려면 left_index 또는 right_index 인수를 True 로 설정한다.

```

# loc
```java
loc 속성은 인덱스를 통해 행 데이터를 가져옵니다. 

가져오는 방법은 아래와 같습니다.

 

데이터프레임명.loc[인덱스]
```

# iloc
```java
iloc 속성은 행번호를 통해 행 데이터를 가져옵니다. 

가져오는 방법은 아래와 같습니다.

데이터프레임명.iloc[행번호]


그럼 df 데이터 프레임에서 0번째 행 데이터를 가져와보죠.
```

# split
```java
1,2,3'.split(',')


 x, y, z = 'a,b,c'.split(',')
```
