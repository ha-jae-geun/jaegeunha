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


# 오류코드보다 예외를 사용하라
```java
오류 코드보다 예외를 사용하라 !
명령 함수에서 오류 코드를 반환하는 방식은

명령 / 조회 분리 규칙을

미묘하게 위반한다.

ref : [Clean Code] 함수 (Function) : 명령과 조회를 분리하라 !



if 문에서 명령을 표현식으로 사용하기 쉽기 때문이다.
if (deletePage(page) == OK)
위 코드는 여러 단계로 중첩되는 코드를 야기한다.

오류 코드를 반환하면

호출자는 오류 코드를 곧바로 처리해야한다는 문제에 부딪힌다.

if (deletePage(page) == OK) {
    if (registry.deleteReference(page.name) == OK) {
        if (configKeys.deleteKey(page.name.makeKey()) == OK) {
            logger.log("page deleted");
        } else {
            logger.log("configKey nott deleted");
        }
    } else {
        logger.log("deleteReference from registry failed");
    }
} else {
    logger.log("delete failed");
    return E_ERROR;
}
오류 코드 대신

예외를 사용하면

오류 처리 코드가

원래 코드에서 분리되어 코드가 깔끔해진다.

try {
    deletePage(page);
    registry.deleteReference(page.name);
    configKyes.deleteKey(page.name.makeKey());
} catch (Exception e) {
    logger.log(e.getMessage());
}

```
