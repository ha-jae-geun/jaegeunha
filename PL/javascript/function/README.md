# 익명함수
```javascript
  1. 선언적 함수 : 함수에 이름이 있는 함수로 호이스팅의 대상이 된다.(호이스팅은 별도로 정리)

      function circle(radius){

        ~~

        return something;

      }

    2. 익명 함수 : 함수에 이름이 없어 주로 변수에 대입해서 사용하는 함수(호이스팅의 대상이 되지 않음)

                    -> 따라서 순차적으로 수행되기 때문에 요즘은 익명함수로 선언하는 것이 추천됨.

      var anonymousFunc = function(raidus){

        ~~

        return something;

      }

    3. 람다 함수 : 일회성으로 사용하기 위한 목적으로 사용되는 함수

      (function(radius){

        ~~

        return something;

      })(25)

```
