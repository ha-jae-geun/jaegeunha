# Try Catch 나누기
```java
Try/Catch 블록 뽑아내기
Try/Catch 블록을

별도 함수로 뽑아내면

코드가 깔끔해진다.

Before

public void delete(Page page) {
    try {
        deletePage(page);
        registry.deleteReference(page.name);
        configKyes.deleteKey(page.name.makeKey());
    } catch (Exception e) {
        logger.log(e.getMessage());
    }
}
After

public void delete(Page page) {
    try {
        deletePageAndAllReferences(page);
    } catch (Exception e) {
        logError(e);
    }
}
private void deletePageAndAllReferences(Page page) throws Exception {
    deletePage(page);
    registry.deleteReference(page.name);
    configKyes.deleteKey(page.name.makeKey());
}

private void logError(Exception e) {
    logger.log(e.getMessage());
}

 
실제로 페이지를 제거하는 함수는 deletePageAndAllReferences이다.

deletePageAndAllReferences 함수는 예외를 처리하지 않는다.

예외 처리는 logError 함수가 담당한다.



이렇게 정상 동작과 오류 처리 동작을 분리하면

코드를 이해하고 수정하기 쉬워진다.
```
