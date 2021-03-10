# Classpath 확인 코드
```java
java.net.URL test = this.getClass().getClassLoader().getResource("com/yettiesoft/test/external/VSConfig.class");
String testLoadResult;
if (test == null){
    System.out.println("test Library is not loaded");
    testLoadResult = "test Libray is not loaded<br>";
}
else{
    System.out.println("test path = [" + test.toString() + "]");
    testLoadResult = "test path = [" + vestsign.toString() + "]<br>";
}
```
