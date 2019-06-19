# PEARSON 상관관계
## use = (결측값 처리)
* "everything" (default): 값이 있을 경우 NA로 계산 결과 제시
* "all.obs": 결측값이 있을 경우 오류 발생 ("Error in cor(x = a, y = b, use = "all.obs", method = c("pearson")) : cov/cor에 결측치들이 있습니다 " error message)
* "complete.obs": 결측값이 있는 case는 모두 제거된 상태에서 상관계수 계산
*  "pairwise.complete.obs": 상관계수가 계산되는 변수들만을 대상으로 결측값이 있는 case 제거한  상관계수 계산

## method = (상관계수 통계량)
 * "pearson" (default): Peraon correlation coefficient 지정, 가장 일반적으로 사용
 * "kendall": Kendall의 순위상관계수 혹은 Kendall의 τ (tau) 지정, 비모수 상관계수 계산 (정규성 불충족 시)
 * "spearman": Spearman의 순위상관계수 혹은 Spearman이 ρ(rho) 지정, 비모수 상관계수 계산 (정규성 불충족 시)

## PM10과 PM2의 PEARSON 상관관계
```R
library("readxl")
mpg <- read_excel("0618.xlsx")
str(mpg)
with(mpg, cor(x=PM10, y=PM2, use="complete.obs", method=c("pearson")))
```
