# [poeimaWeb Prototype](https://poiemaweb.com/js-function)

# [Evan moon 상속](https://evan-moon.github.io/2019/10/27/inheritance-with-prototype/)

# [에반문](https://evan-moon.github.io/2019/10/23/js-prototype/)

# [테코톡](https://youtu.be/RYxgNZW3wl0)

# 프로토타입이란?
* 자바스크립트는 프로토타입을 기반으로 상속을 구현하여 불필요한 중복을 제거한다(기존의 코드를 재사용한다.)
* 즉, 생성자 함수가 생성할 모든 인스턴스가 공통적으로 사용할 프로퍼티나 메소드를 프로토타입에 미리 구현해 놓음으로써, 상위(부모) 객체인 프로토타입의 자산을 공유하여 사용할 수 있다.

## __proto__ 접근자 프로퍼티
* 자신의 프로토타입, 즉 Prototype 내부슬롯에 접근 할 수 있다.

## 프로토타입체인?
* 객체의 프로퍼티에 접근하려고 할 때 객체에 접근하려는 프로퍼티가 없으면,__proto__ 접근자 프로퍼티가  가리키는 링크를 따라 자신의 부모역할을 하는 프로토타입의 프로퍼티를 순차적으로 검색한다.
* 프로토타입체인의 최상위 객체는 Object.prototype이다.
* 이 객체의 프로퍼티와 메소드는 모든 객체에게 상속된다.
