# BER
```java
BER : ASN.1 의 대표적인 인코딩 규칙.

BER 로 정의되는 모든 데이터는 TLV (Tag part + Length part + Value part) 형태로 이루어진다. 

T (Tag) : 사전 정의된 기본데이터 타입. 시간, 문자열, 숫자등의 표기가 정의 되어 있으며 

어플리케이션에서 정의한 다른 타입들은 기본데이터 타입으로 나타내어질 수 있다.

L (Length) : Value 의 길이. BER 의 특정 규칙을 따른다.

V (Value) : 실제 표현하고자 하는 값. Tag 에 따라 표현되는 규칙이 정해진다.

```

## TAG
* TLV 형태에서 가장 먼저 나오는 데이터 타입, 대부분 1 바이트(Octet) 로 표기됨

## Length
* 가장 중요한 필드로서 인코딩 방법을 정확이 알아야 함
* Length part  는 The short form, The long form, The indefinite form 등 세 가지 form 을 가진다.


