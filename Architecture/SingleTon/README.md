# 생성패턴
1. 생성 패턴: 생성패턴(Creation Pattern) : 객체의 생성과정에 관여하는 패턴입니다.
* 추상 팩토리, 빌더, 팩토리 메소드, 프로토타입, 싱글턴


# [싱글톤 패턴](https://jeong-pro.tistory.com/86)
* 애플리케이션이 시작될 때 어떤 클래스가 최초 한번만 메모리를 할당하고(Static) 그 메모리에 인스턴스를 만들어 사용하는 디자인패턴.
* 생성자가 여러 차례 호출되더라도 실제로 생성되는 객체는 하나고 최초 생성 이후에 호출된 생성자는 최초에 생성한 객체를 반환한다. (자바에선 생성자를 private로 선언해서 생성 불가하게 하고 getInstance()로 받아쓰기도 함)
* => 싱글톤 패턴은 단 하나의 인스턴스를 생성해 사용하는 디자인 패턴이다.
* (인스턴스가 필요 할 때 똑같은 인스턴스를 만들어 내는 것이 아니라, 동일(기존) 인스턴스를 사용하게함)


## 싱글톤 패턴을 쓰는 이유
* 고정된 메모리 영역을 얻으면서 한번의 new로 인스턴스를 사용하기 때문에 메모리 낭비를 방지할 수 있음
* 또한 싱글톤으로 만들어진 클래스의 인스턴스는 전역 인스턴스이기 때문에 다른 클래스의 인스턴스들이 데이터를 공유하기 쉽다.
* DBCP(DataBase Connection Pool)처럼 공통된 객체를 여러개 생성해서 사용해야하는 상황에서 많이 사용.
* (쓰레드풀, 캐시, 대화상자, 사용자 설정, 레지스트리 설정, 로그 기록 객체등)
* 안드로이드 앱 같은 경우 각 액티비티나 클래스별로 주요 클래스들을 일일이 전달하기가 번거롭기 때문에 싱글톤 클래스를 만들어 어디서나 접근하도록 설계하는 것이 편하기 때문...
+ 인스턴스가 절대적으로 한개만 존재하는 것을 보증하고 싶을 경우 사용.
+ 두 번째 이용시부터는 객체 로딩 시간이 현저하게 줄어 성능이 좋아지는 장점!


## 싱글톤 패턴의 문제점
* 싱글톤 인스턴스가 너무 많은 일을 하거나 많은 데이터를 공유시킬 경우 다른 클래스의 인스턴스들 간에 결합도가 높아져 "개방-폐쇄 원칙" 을 위배하게 된다. (=객체 지향 설계 원칙에 어긋남)
* 따라서 수정이 어려워지고 테스트하기 어려워진다.
* 또한 멀티쓰레드환경에서 동기화처리를 안하면 인스턴스가 두개가 생성된다든지 하는 경우가 발생할 수 있음
* 개발을 할때 항상 들어온 goto는 쓰면 안돼! 전역 객체는 안 좋은거야! 라는 말 처럼 꼭 필요한 경우아니면 지양해야함. // 적절히 잘 쓰면 아주 좋음, (그게 어렵지)


## 게으른 초기화
* 지연된 초기화, 게으른 초기화(lazy initialization)은 컴퓨터 프로그래밍에서 객체 생성, 값 계산, 또는 일부 기타 비용이 많이 드는 과정을 처음 필요한 시점까지 지연시키는 기법이다.
