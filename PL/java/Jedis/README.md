# Jedis
```java
Jedis - Redis 자바 라이브러리

Jedis는 Redis를 자바에서 쉽게 사용할 수 있게 도와주는 라이브러리다.

jedis말고도 Redis 자바 라이브러리가 다양하게 존재하지만 Jedis가 사용이 가장 간단하다고 한다. 따라서 가벼운 마음으로 실습해본다.

Maven repository 가보니까 2.9.0 버전(최신버전)의 라이브러리가 제일 많이 사용되고 있기 때문에 이번 실습환경도 똑같이 jedis 2.9.0 버전을 쓴다.

Redis가 뭔지 모르면 지난 포스트 http://jeong-pro.tistory.com/139 를 참고하면 좋을 것 같다.

[maven dependency]


<!-- https://mvnrepository.com/artifact/redis.clients/jedis -->
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>2.9.0</version>
</dependency>
Colored by Color Scripter


메이븐을 빌드툴로 사용하고 있다면 위 내용을 pom.xml 파일에 추가하면 라이브러리를 쓸 수 있을 것이다.

(라이브러리를 직접 다운로드해서 사용해도 좋다)

그리고 무조건 위 버전을 쓰지 말고 https://mvnrepository.com/artifact/redis.clients/jedis 여기서 버전을 확인해서 

최신 버전을 사용하도록 하는 것이 좋다.

Redis-server Settings

테스트를 가상머신(Virtual Box)의 ubuntu 16.04 리눅스로 띄워서 할 것이다.

지난 포스트에서 참고할 수 있듯이 일단 디폴트로 로컬로 띄울 수 있게 되어있는 부분을 바꾼다.

"~/redis-stable/redis.conf" 파일을 열어서 바꿀 부분 3가지

1. bind 192.168.0.56

 - 127.0.0.1 로 되어있을텐데 원격에서 접속해서 쓸 거라 변경했다. 테스트니까 주석처리해서 어디서든 접근하도록 해도 좋다.

2. protected-mode no

- protected-mode yes 로 되어있을텐데 이것을 no로 바꿔준다.

3. requirepass jeongpro

- #requirepass foobared 로 되어있을텐데 이것을 원하는 비밀번호로 바꾸고 앞에 주석을 제거한다. 비밀번호 없이 사용할 것이라면 

그냥 주석된 처리로 써도 된다.

* 참고로 requirepass 부분이 잘 적용이 안되는 듯하다. redis.conf파일에서 분명히 bind는 적용이되서 해당 ip아니면 접근이 

안되니까 redis.conf가 잘 되는것 같은데 희한하게 requirepass 부분은 적용이 안되서 몇 시간을 날렸다.

=> [redis 설정 바꾸기] redis-server로 일단 키고 redis-cli로 접속해서 아래 명령어를 사용해서 비밀번호를 적용한다.



단순하게 redis-server가 띄워진 상태에서 redis-cli를 실행한 후 "config set requirepass [비밀번호]"를 입력하면 된다.

그림을 잘보면 redis.conf파일에서 requirepass 부분의 주석을 풀고 비밀번호도 적용해서 실행시켰는데 확인해보면 "requirepass"와 

"" 만 보인다. (사용할 수 없는 비밀번호)

(어떻게해야 redis 설정을 잘 할 수 있는지 댓글로 도움을 주시면 감사하겠습니다.)

(설치가 문젠지, redis-stable/src 밑에 redis-server install도 해보고 /etc/init.d/redis 밑에 conf파일로도 

해봤는데 일단은 원인을 못 찾았습니다.)

Jedis example

Redis 서버를 온전하게 띄웠다는 전제하에 자바 코드로 redis에 접속해서 데이터를 저장하고 불러와보겠습니다.


package jeongpro;
 
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
 
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
 
public class jedistest {
    public static void main(String[] args) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        
        JedisPool pool = new JedisPool(jedisPoolConfig, "183.99.32.228", 6379, 1000, "jeongpro");
        //Jedis풀 생성(JedisPoolConfig, host, port, timeout, password)
        Jedis jedis = pool.getResource();//thread, db pool처럼 필요할 때마다 getResource()로 받아서 쓰고 다 쓰면 close로 닫아야 한다.
        //데이터 입력
        jedis.set("jeong", "pro");
        //데이터 출력
        System.out.println(jedis.get("jeong"));//pro
        //데이터 삭제
        jedis.del("jeong");
        System.out.println(jedis.get("jeong"));//null
        
        try {
            jedis.set("key", "value");
            //데이터 만료시간 지정
            jedis.expire("key", 5);//5초 동안만 "key"를 key로 갖는 데이터 유지
            Thread.sleep(4000);//쓰레드를 4초간 재우고
            System.out.println(jedis.get("key"));//value
            Thread.sleep(2000);//1초했더니 운좋으면 살아있어서 2초로 지정
            System.out.println(jedis.get("key"));//null
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        /* Lists 형태 입출력 */
        jedis.lpush("/home/jdk", "firstTask");
        jedis.lpush("/home/jdk", "secondTask");
        System.out.println(jedis.rpop("/home/jdk"));//firstTask
        System.out.println(jedis.rpop("/home/jdk"));//secondTask
        
        /* Sets 형태 입출력 */
        jedis.sadd("nicknames", "jeongpro");
        jedis.sadd("nicknames", "jdk");
        jedis.sadd("nicknames", "jeongpro");
        Set<String> nickname = jedis.smembers("nicknames");
        Iterator iter = nickname.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        
        /* Hashes 형태 입출력 */
        jedis.hset("user", "name", "jeongpro");
        jedis.hset("user", "job", "software engineer");
        jedis.hset("user", "hobby", "coding");
        
        System.out.println(jedis.hget("user","name"));//jeongpro
        Map<String, String> fields = jedis.hgetAll("user");
        System.out.println(fields.get("job"));//software engineer
        
        /* Sorted Sets 형태 입출력 */
        //Map을 미리 만들어서 넣을 수도 있음 zadd확인할 것
        jedis.zadd("scores", 6379.0, "PlayerOne");
        jedis.zadd("scores", 8000.0, "PlayerTwo");
        jedis.zadd("scores", 1200.5, "PlayerThree");
        
        System.out.println(jedis.zrangeByScore("scores", 0, 10000));
        //[PlayerThree, PlayerOne, PlayerTwo]
        //Sorted Sets는 잘모르겠으니 더 공부할 것.
        
        
        if(jedis != null) {
            jedis.close();
        }
        pool.close();
    }
}
 
Colored by Color Scripter
cs
주석을 잘 달아놓았으니 코드를 보면서 간단하게 사용해보는 것이 좋을 것이다.

* 참고로 위 처럼 Jedis 객체를 계속 사용하는 것은 위험한 코드다.

보통 하나의 동작을 하고 close()해주고 필요하면 다시 JedisPool에서 getResource()로 받아 사용한다.

이 뿐만 아니라 영속성을 위해서 redis 데이터를 디스크에 쓰는 작업도 있고 다양한 기능이 더 있지만 일단은 

튜토리얼에서 사용해보는 것으로 마친다.
```
