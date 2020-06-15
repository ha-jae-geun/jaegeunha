# Entity
```java
위의 그림은 JPA에서 사용하는 타입을 정리한 것이다. JPA를 배울 때 다짜고짜 Entity라는 개념을 배우고 그 객체안에

String 타입의 name, int 타입의 age등의 속성들을 정의하여 사용했다.

그런데 Entity는 객체로 잘 다뤘으면서 내부의 변수(속성)는 객체로 다루지 않고 나열식으로 사용했었다.

그래서 그 것들이 Entity는 아니지만 엔티티 객체 내부에서 값이지만 객체로 사용되게 하는 방법으로 값 타입이 있다.

그것에 대해 알아본다.

JPA에서 사용하는 타입은 엔티티 타입(@Entity), 값 타입(int, String, Integer)으로 나뉜다.

값 타입은 다시 3개의 타입으로 나뉜다.

기본 값 타입(int, Integer, String)
임베디드 타입(새로 정의한 복합 타입)
컬렉션 값 타입
기본 값 타입은 자바에서 제공하는 하나의 클래스나 primitive 타입이고, 임베디드 타입은 내가 새롭게 정의한 복합 타입이다.

예를들어 int x, int y 를 내부 값으로 같은 Point 클래스를 생각해보면 되겠다. 내부에 x,y 좌표 값을 같는 Point 타입은 

임베디드 타입으로 쓰일 수 있다.

컬렉션 값 타입은 말 그대로 컬렉션인 값 타입이다.

항상 하나의 클래스만 멤버 변수로 갖는 것이 아니라 List나 Set등의 컬렉션으로 타입을 가질 수 있지 않은가 그 컬렉션 값 타입을 얘기하는 것이다.

단순한 값 타입을 사용 방법은 다음과 같다.

@Embeddable을 새로 정의한 타입 클래스에 쓰고, 실제 엔티티의 변수에는 @Embedded 애노테이션을 붙여서 적용한다. (둘 중에 하나만 써도 된다.)

* 특징으로는 임베디드 타입은 반드시 기본생성자가 있어야한다.

@Entity
public class Member{
    @Embedded private Address address;//embedded 타입
    @Embedded private PhoneNumber phoneNumber;//embedded 타입
    //...
}
@Embeddedable
public class Address{
    private String street;
    private String city;
    private String state;
    @Embedded Zipcode zipcode;//embedded 타입안에 embedded 타입 가능
    //기본 생성자...
}
@Embeddedable
public class Zipcode{
    private String zip;
    private String plusFour;
    //기본 생성자...    
}
@Embeddedable
public class PhoneNumber{
    private String areaCode;
    @ManyToOne phoneServiceProvider provider; //entity 참조
    //기본 생성자...
}
@Entity
public class PhoneServiceProvider{
    @Id private String name;
    //...
}
위 코드에서 Member 엔티티는 내부에 값 타입을 2개(Address, PhoneNumber)를 가지고 있다.

Member 테이블을 기준으로 했을 때는 컬럼이 여러 개가 생기기 때문에 객체로 표현하나 그냥 속성값으로 쭉 나열하나 똑같지만 

프로그래밍 측면에서 객체로 다루는 것이 훨씬 자연스럽고 가독성이 좋아진다.

그리고 Address를 보면 Address는 값 타입인데도 내부에 Zipcode 라는 또 다른 값타입을 객체 참조로 가지고 있는 것을 볼 수 있다.

또한 PhoneNumber도 값 타입인데 내부에 Entity(PhoneServiceProvider)를 참조로 가지고 있는 것을 볼 수 있다.

즉, 내부에서 뭘 참조해도 상관 없다는 얘기다.

→ 아래와 엔티티에 같은 임베디드 타입이 있을 때는 어떻게 해야할까?

@Entity
public class Member{
    //...
    @Embedded Address homeAddress;
    @Embedded Address companyAddress;
    //...
}
위와 같은 상황에서 문제는 DB테이블내의 컬럼명이 중복된다는 것이다.

DB테이블내에서 사용할 컬럼명을 재정의 해줘야하는데 이 때 사용하는 것이 @AttributeOverride 속성이다.

이 속성은 반드시 @Entity 클래스안에서 써야한다. (@Embeddedable 아님.)

@Entity
public class Member{
    //...
    @Embedded Address homeAddress;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="city", column=@Column(name="COMPANY_CITY")),
        @AttributeOverride(name="street", column=@Column(name="COMPANY_STREET")),
        @AttributeOverride(name="zipcode", column=@Column(name="COMPANY_ZIPCODE"))
    })
    Address companyAddress;
    //...
}
위와 같이 재정의해주면 companyAddress에 해당하는 컬럼 COMPANY_CITY, COMPANY_STREET, COMPANY_ZIPCODE로 컬럼명이 바뀐다.

@AttributeOverride를 사용하면 어노테이션을 너무 많이 사용해서 코드가 지저분해지는 단점이 있다.

그러나 같은 임베디드 타입을 중복해서 사용하는 경우는 많지 않기 때문에 방법만 알아둔다.

* 임베디드 타입이 null이면 매핑한 컬럼 값도 null이다.

member.setAddress(null);
entityManager.persist(member);// city, street, zipcode는 테이블에서 null

값 타입을 공유했을 때의 문제점
객체는 얼마든지 참조로 공유될 수 있다.

값 타입 객체를 참조로 공유하게되면 공유하는 객체의 속성을 바꿨을 때, 공유하는 모든 엔티티의 값타입의 속성이 바뀐 것으로,

영속성 컨텍스트에서 그 값 타입을 참조하는 모든 객체의 속성이 변경된 것으로 판단하고 UPDATE 쿼리를 수행한다.

객체를 복사해서 사용하는 대안도 있겠으나, 원천 차단하는 방법은 불변 객체 타입을 써버리는 것이다. 수정이 불가능하도록.

값 타입 컬렉션
값 타입을 컬렉션으로 갖는 엔티티를 생성할 수 있다.

@Entity
public class Member{
    @Id @GenerateValue
    private Long id;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOODS", joinColumns = @JoinColumn(name="MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name="MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private List<Address> addressHistory = new ArrayList<>();
    //...
}

@Embeddedable
public class Address{
    @Column
    private String city;
    private String street;
    private String zipcode;
    //...
}
테이블로 봤을 때 컬렉션을 테이블의 하나의 컬럼에 저장할 수 없으므로, 새로운 테이블에 컬렉션을 저장해야 한다.

위의 예제로보면, FAVORITE_FOODS 테이블에 MEMBER_ID(PK,FK), FOOD_NAME(PK) 로 저장하고,

ADDRESS테이블에 MEMBER_ID(PK,FK), CITY(PK), STREET(PK), ZIPCODE(PK) 로 저장한다.

* 컬렉션 값 타입을 저장할 때는 어떻게 할까?

값 타입 컬렉션은 영속성 전이(Cascade)와 고아 객체 제거(Orphan remove)기능이 필수로 적용됐다고 보면 된다.

(persist(), remove()등을 수행할 때 그냥 원본 엔티티만 사용해도 값 타입 컬렉션도 같이 저장됨 단, 컬렉션 값 타입이 많을 

수록 SQL쿼리 수가 많아짐)

값 타입 컬렉션의 제약사항
엔티티는 ID로 DB에서 찾을 수 있기 때문에 찾아서 쉽게 수정, 삭제등을 할 수 있다.

반면 값 타입은 식별자라는 개념이 없기에 원본 데이터를 찾기 어렵다.

물론 그냥 값 타입은 식별자의 값 타입이기 때문에 해당 엔티티를 찾고 그 엔티티의 값 타입을 수정, 삭제하면 된다.

문제는 값 타입 컬렉션이다. 값 타입 컬렉션은 별도의 테이블에 저장되는데 이 테이블 안에 있는 값타입의 값이 변경되면 DB에 

있는 원본 데이터를 찾기 어렵다는 문제가 있다.

따라서 변경이 일어나면 기존 값 타입 컬렉션 전체를 테이블에서 삭제하고 수정된 컬렉션 전체를 저장하는 방식으로 이뤄진다.

그렇기 때문에 컬렉션의 양이 많아지면 쿼리 수가 많아지기 때문에 컬렉션 데이터가 많으면 값 타입 컬렉션 대신 일대다 

관계 엔티티로 수정하는 것을 고려해야한다.

추가로 값 타입 컬렉션에 있는 모든 컬럼을 묶어서 기본키로 설정해서 엔티티를 만들어야한다.
```
