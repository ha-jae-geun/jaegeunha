# [JPA와 프록시](https://jeong-pro.tistory.com/197?category=886199)
```java
"도서 (자바 ORM 표준 JPA 프로그래밍 - 김영한 지음)"를 공부하고 정리한 내용임을 사전에 알려드립니다.

프록시와 연관관계 정리
- 프록시

JPA는 객체지향언어와 관계형 데이터베이스의 패러다임 불일치를 해결하는 기술이다.

프록시가 이 문제에 도움을 주는데 어떤 부분에서 도움을 주는지 정리한다.

객체는 team1.getMembers().get(0); 이런식으로 연관된 객체들을 탐색할 수 있는 반면 RDB의 경우 참조하는 외래키를 이용해서 테이블간의 

조인 쿼리를 작성해서 탐색해야한다.

그러다보니 연관된 객체를 쓰일지 안 쓰일지도 모르는 체 전부다 가져와야하는 문제가 있다.

이 문제를 프록시라는 기술로 해결한다.

프록시는 실제 연관된 객체를 즉시 join을 통해 DB로부터 가져오는 것이 아니라 앞서 프록시 객체를 두어서 실제 사용되는 시점에 DB를 

조회해서 가져오는 기술이다.

위에서 설명한 프록시 기술을 사용해서 연관된 객체를 가져오는 시점을 지연시키는 방법은 지연로딩(Lazy loading)이라하고 프록시 기술없이 

연관된 객체를 즉시 가져오면 즉시 로딩(Eager loading)이라고 한다.

기본적으로 객체를 찾을 때, EntityManager.find() 메소드를 이용하면 즉시 로딩되고 EntityManager.getReference() 메소드를 이용하면 

지연 로딩이 된다.

프록시 객체는 실제 객체에 대한 참조를 보관하고 있다가 실제 사용될 때 프록시 객체가 실제 객체의 메소드를 호출하는 식으로 사용된다.

프록시 객체가 실제 객체에 대한 참조가 없을 때도 있는데 그 때는 영속성 컨텍스트에 실제 객체를 조회하고 영속성 컨텍스트에서 

없으면 DB조회를 해서 실제 객체를 생성해준다.

그러면 프록시 객체는 참조를 얻고 메서드를 호출한다.

- 프록시 객체의 초기화 : 프록시객체가 실제 엔티티 객체를 생성하는 작업을 프록시 객체의 초기화라고 한다.

- 프록시의 특징

처음 사용할 때 한 번만 초기화 된다. (초기화된다고해서 프록시 객체가 실제 객체로 전환되는 건 아니고 접근이 가능해진 것일 뿐이다.)
프록시 객체는 원본 엔티티를 상속받는 객체이므로 타입 체크를 잘해야한다.
영속성 컨텍스트에 찾는 객체가 있으면 DB를 조회할 필요가 없기 때문에 getReference()로 프록시를 가져오려고 해도 실제 엔티티가 조회된다.
초기화는 영속성 컨텍스트의 도움을 받아야한다. 만약 준영속상태의 프록시를 초기화하면 예외가 발생한다. 

(EntityManager.getReference(Member.class, "id1")으로 가져온 후, 트랜잭션을 커밋하고 entityManager.close()를 통해 

영속성 컨텍스트를 종료한 다음에 사전에 가져온 객체로 사용하려고 하면 객체가 준영속상태이므로 예외가 발생한다.)
프록시로 조회할 때 PrimaryKey를 값으로 전달하는데 프록시 객체는 이 기본키 값을 가지고 있는다.

Team team = entityManager.getReference(Team.class, "team1");
team.getId(); //이렇게 호출하더라도 프록시 초기화가 되지 않음 Id는 알고 있기 때문.
단, @Access(AccessType.PROPERTY)로 설정한 경우에만 초기화되지 않음.

프록시가 유용하게 사용되는 곳은 연관관계를 설정할 때다.

Member member = entityManager.find(Member.class, "member1");

Team team = entityManager.getReference(Team.class, "team1");//쿼리를 날리지 않음

member.setTeam(team);

이러면 member에게는 팀을 설정하기 위해서 필요한 정보인 팀의 key값이 있기 때문에 굳이 조회쿼리가 필요가 없다.

- 프록시 확인하기

PersistenceUnitUtil.isLoaded(object entitry) 메소드로 프록시 객체의 초기화 여부를 알 수 있다.

- EagerLoading vs LazyLoading

member1이 team1에 소속되어있다고치고, member1.getTeam(); 으로 팀을 조회할 수 있다고 할 때, 멤버엔티티를 조회할 때 팀 

엔티티도 같이하는게 좋을까 아니면 팀 엔티티를 사용할 때 팀은 따로 조회하는게 나을까?

즉시로딩

@ManyToOne(fetch=FetchType.EAGER)이렇게 속성을 정의하면 된다.

(Entity Model에 애노테이션을 적용하여 fetchType을 Eager로 결정하면 entityManager.find()를 쓰는 것과 같은?)

→ 이렇게하면 member 테이블에서 조회따로 team테이블에서 따로 2회 조회쿼리가 실행될거같지만 JPA구현체에 의해서 join되어 쿼리가 1번만 요청된다.

참고로 이 join은 teamId 즉, member가 참조하는 외래키가 null일 수 있기 때문에 outerjoin을 사용한다.

outerjoin은 쿼리 최적화에 불리하므로 inner join이 좋은데, inner join을 하고 싶으면 외래키를 nullable = false로 지정해서 

null이 아님을 보장해준다고 JPA에 알려줘야한다.

그러면 JPA구현체가 외래키가 null인게 없으므로 최적에 좋게 inner join을 사용할 수 있게 된다.

@ManyToOne(fetch = FetchType.EAGER)
@JoinColum(name = "TEAM_ID", nullable = false)
private Team team;
지연로딩

@ManyToOne(fetch = FetchType.LAZY) 이렇게 속성을 정의하면 된다.

이렇게하면 member만 필요할 때는 member만 조회하고 team은 프록시객체로 가지고 있다가 추후에 member.getTeam()으로 팀이 요구될 

때 실제 객체를 영속성컨텍스트에서 찾아온다.

만약 영속성컨텍스트에 이미 team객체가 있으면 프록시객체가 아닌 실제 객체를 사용한다.

- 프록시로 지연로딩하는 것이 무조건 좋은것인가

아니다. 위의 예시로 봤을 때 거의 대부분을 team과 member 정보를 함께이용한다면 join으로 가져오는 것이 오히려 최적화관점에서 이득이다.

따라서 상황에 맞게 사용하는 것이 좋다.

추천하는 방법은 개발단계에서 모든 연관관계에 지연로딩을 사용하고, 출시버전배포 이전에 필요한 부분에 즉시로딩을 적용하면 최적화된다.

- 컬렉션 래퍼

Member member = entityManager.find(Member.class, "member1");
List orders = member.getOrders();
System.out.println(orders.getClass().getName());
//org.hibernate.collection.internal.PersistentBag
member라는 엔티티에 컬렉션(여기서는 List)이 있으면 프록시로 처리한다고 할 때 persistentBag이라는 자체 컬렉션 래퍼로 처리해준다.

이 컬렉션 래퍼도 결국은 프록시다.

member.getOrders() 했을 때는 초기화되지 않고, member.getOrders().get(0) 이렇게 조회될 때 초기화된다.

- JPA 기본 패치 전략

@ManyToOne, @OneToOne : FetchType.EAGER

@OneToMany, @ManyToMany : FetchType.LAZY

외우지 말고 단일 엔티티면 EAGER, List등의 컬렉션 엔티티면 LAZY가 기본 전략이다는게 이해되야 한다.

컬렉션에 EAGER를 쓴다면, 연관된 테이블에 있는 수많은 데이터를 가져와야하므로 성능이 떨어질 수 있기 때문이다.

특히 컬렉션에 EAGER를 사용할 때 주의해야할 것은 조회하려는 엔티티에 컬렉션인 변수가 하나만 있어야하는 것이다.

2개 이상있을 때를 상상해보면 서로 다른 테이블 2개를 join해야하는데 그러면 N개 * M개의 데이터가 조회되므로 성능이 크게 저하되기

때문에 EAGER를 사용할 때 주의해야한다.

또한 컬렉션에 EAGER를 쓰면 "무조건" OUTER JOIN을 한다는 것을 주의해야한다.

만약 team 테이블에서 member 컬렉션을 조회할 때 회원이 한명도 없는 팀이 있다면, 그 팀을 INNER JOIN해버리면 팀이 있음에도 

조회되지 않는 현상이 발생한다.

그것을 방지하기위에서는 DB에 제약조건을 걸어야하는데 방법이 없다. 따라서 OUTER JOIN을 사용한다.

- 영속성 전이 CASCADE

만약 Team 엔티티 객체를 만들고, member 11개를 만들고 이 엔티티들을 저장한다고 하면 어떻게 해야할까?

원칙적으로 영속성 컨텍스트에 앞서 만든 12개의 엔티티가 영속상태로 있어야하므로 12번을 entityManager.persist(...)해야한다.

그런데 영속성 전이를 활성화하는 cascade 속성을 정의하면 부모객체 즉 team 엔티티를 등록할 때 그 팀에 소속된 member들을 

자동적으로 영속성 컨텍스트에 영속상태로 등록시킬 수 있다.

@OneToMany(mappedBy = "team", cascade = CascadeType.PESIST)
private List<Member> members = new ArrayList<Member>();

Team team1 = new Team("TEAM1");
Member member1 = new Member("1");
Member member2 = new Member("2");
Member member3 = new Member("3");
//...
//...
Member member11 = new Member("11");
member1.setTeam(team1); // 연관관계 추가
member2.setTeam(team1);
//...
member11.setTeam(team1);

entityManager.persist(team); //팀만 영속성컨텍스트에 넣었지만 member까지 등록된다.
이런 영속성 전이 기능을 PERSIST만이 아니라 REMOVE도 가능하다.

CascadeType.REMOVE로 설정하고 team을 삭제하면 소속된 member들도 삭제된다.

delete SQL이 12번이 실행되고 외래키 제약조건에 의해서 member들이 전부 삭제된 후에 team객체를 삭제한다.

CascadeType.REMOVE없이 team객체를 삭제하면 team만 삭제하려고 할텐데 이러면

CascadeType의 종류는 [ALL, PERSIST, MERGE, REMOVE, REFRESH, DETACH]가 있고, 여러 속성을 정의할 때는 

cascade = {CascadeType.PERSIST, CascadeType.REMOVE} 이렇게 지정한다.

PERSIST와 REMOVE의 경우 메서드 호출시 바로 영속성전이가 일어나서 다 저장하거나 삭제하지않고 실제로 플러시가 호출될 때 쿼리가 수행된다.

- 고아 객체

JPA는 부모 엔티티와 연관관계가 끊어진 자식 엔티티를 자동으로 삭제하는 기능이 있다.

부모엔티티의 컬렉션에서 자식엔티티의 참조만 제거하면 자식 엔티티가 자동으로 삭제되도록 하는 것이다.

특정 엔티티가 다른 엔티티를 개인 소유할 때만 사용해야한다.
```
