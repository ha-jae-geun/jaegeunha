```R
library("readxl")
mpg <- read_excel("0618.xlsx")
str(mpg)
with(mpg, cor(x=PM10, y=PM2, use="complete.obs", method=c("pearson")))
```
