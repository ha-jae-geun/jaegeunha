# 이제 스프링이 스캔 할수 있도록 root-context.xml파일에 코드를 추가해줍니다.
```java
    <!-- scan -->
    <context:component-scan base-package="kr.co.service"></context:component-scan>
    <context:component-scan base-package="kr.co.dao"></context:component-scan>
    <context:component-scan base-package="kr.co.vo"></context:component-scan>
```
