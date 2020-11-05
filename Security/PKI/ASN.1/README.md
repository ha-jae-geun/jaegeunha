# [ASN](http://sakak76.egloos.com/v/4129580)
* ASN.1은 ITU-T에서 정의한 네트워크상의 데이터 교환을 정의한 프로토콜이다.
* 이 기종 시스템 간 (Little Endian, Big Endian, 32bit, 16bit 시스템…)의 데이터 전송 시 표준이 되는 포맷을 정의해서 System 1 > 2,3,4 로 보낼 때 ASN.1로 변환해서 보내고 받을 때도 ASN.1로 받으면 시스템 별로 변환해야 할 복잡함 없이 모든 시스템이 데이터를 교환할 수 있음


```java
ASN.1 Encoding 규칙 (Encoding Rules)
앞에서 소개한 바와 같이 ASN.1은 추상적인 데이터 정의언어이기 때문에, 물리적 전송계층에 그대로 반영할 수는 없습니다. 
이렇게 정의된 언어를 물리적 데이터로 변환하는 방법이 Encoding 규칙 입니다. 다음과 같은 Encoding 규칙이 존재합니다. 
개별적인 상세 내용들은 앞에 언급된 참조 문헌을 살펴보시기 바랍니다. 간단하게 특징을 정리하였습니다.


* BER(Basic Encoding Rules)
→가장 오래된 구성 방식으로, Tag-Length-Value의 순으로 데이터를 Encoding 합니다.
이 전송방식은 기본적인 형태이며 실제로는 DER,CER로 구현됩니다.
* DER(Distinguished Encoding Rules)
→ BER의 Subset입니다. 각 Element마다 TLV 형태의 값이 반복됩니다. DER은 X.509 인증서에 사용됩니다.
데이터가 많아지면 메타 데이터가 커집니다.
* CER(Canonical Encoding Rules)
→ BER의 Subset 입니다. 길이를 알려주는 대신 데이터의 끝을 알려줍니다.
* OER(Octet Encoding Rules)
→ 가장 빠른 Encoding 규칙입니다. 8Bit 단위로 각 데이터의 엘리먼트를 처리하기 때문에 계산의 복잡도가 높지 않아 속도가 빠름니다.
* PER(Packed Encoding Rules)
→가장 간단한 Encoding 규칙입니다. 고정된 값인 경우 TLV를 제거하여 전송량이 적습니다.
실제로 LTE등에 사용됩니다.
* XER(XML Encoding Rules), E-XER(Extended-XER)
→ XML형식의 Encoding 규칙 입니다. E-XER는 XSD를 적용하기 쉽다는 차이점이 있습니다.
* JER(JSON Encoding Rules)
→ JSON 형식의 Encoding 방식입니다. XER이나 E-XER에 비해 더 사용하기 쉽습니다.
Debug를 하거나 문제점을 파악하기에 용이합니다.
```

# BER
```java
네트워크 상에서 교환되는 메시지는 ASN.1형태로 구성되어 교환된다고 하였지만, 
ASN.1은 그 자체로는 추상적인 데이터 형식이기 때문에 그것을 그대로 전송할 수 없다. 
따라서 ASN.1 형태 의 추상 데이터 형식을 네트워크상에서 전송할 수 있는 형식으로 변환시켜야 할 필요성이 있다. 
• 이때 사용되는 것이 BER(Basic Encoding Rule)과 DER(Distinguished Encoding Rule)이다
```

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


