# 데이터 베이스 테스트
```java
src/test/java -> kr.co.controller에 Test.java파일을 만들어줍니다

package kr.co.study;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class Test {

    @Inject
    private DataSource ds;
       
    @Inject
    private SqlSessionFactory sqlFactory;
 
    @org.junit.Test
    public void test() throws Exception{

        try(Connection conn = ds.getConnection()){
            System.out.println(conn);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
   
  
    @org.junit.Test
    public void factoryTest() {
        System.out.println(sqlFactory);
      
    }
  
    @org.junit.Test
    public void sessionTest() throws Exception{
      
        try(SqlSession session = sqlFactory.openSession()) {
            System.out.println(session);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}

public class Test{ 안에 마우스 우클릭후 Run As > JUnit Test클릭

이렇게 Junit가 녹색으로 나온다면 성공했다는것입니다.

이상으로 Mybatis + 오라클 연동포스팅을 마치고

```
