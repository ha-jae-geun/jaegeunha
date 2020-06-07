# 이클립스
 * https://www.eclipse.org/downloads/
 * 자바 버전에 맞게 다운 받기
 * 자바는 힙 크기 조절해 주어야 함(new 사용이 많음)
 * OpenPerspective 자바 변경

## - UTF-8 일괄 설정 
- vmargs 밑에
- -Dfile.encoding=UTF-8
	* (ex. Windows에서 개발한 소스를, Linux에서 -Dfile.encoding을 명시하지 않고 실행)

 
# 최적화
```java
1. Window메뉴에 Preferences > Java > Editor > Folding > Enable folding 체크 해제

 

2. Window메뉴에 Preferences > Java > Editor > Content Assist > Auto Activation 체크 해제

 

3. Window메뉴에 Preferences > JavaScript > Editor > Folding > Enable folding 체크 해제

 

4. Window메뉴에 Preferences > JavaScript > Editor > Content Assist > Auto Activation 체크 해제

 

5. Window메뉴에 Preferences > HTML Files > Editor > Content Assist > Auto Activation 체크 해제

 

6. Window메뉴에 Preferences > XML > Editor > Content Assist > Auto Activation 체크 해제

 

7. Window메뉴에 Preferences > General > Editors > Text Editors > Spelling > Enable spell checking 체크 해제

 

8. Window메뉴에 Preferences > General > Show heap status 체크

- 이클립스 하단에 휴지통 모양이 생기며 클릭하면 정리해줌.


 
 

9. 이클립스 ini파일


-Xverify:none 
-XX:-UseConcMarkSweepGC 
-XX:+AggressiveOpts 
-XX:PermSize=256M 
-XX:MaxPermSize=256M 
-XX:MaxNewSize=256M 
-XX:NewSize=256M 
-XX:MaxGCPauseMillis=10 
-XX:+UnlockExperimentalVMOptions 
-XX:+CMSIncrementalPacing
```

## delete
- 쓰지 않는 프로젝트 delete(완전삭제 안하기)  

## import
- 이클립스 import - General - Existing projects into workspace
- 버전 안맞으면 Build path - Configure Path

## export
- export -> java -> JAR file



## 이클립스 설정
 * eclipse 설정 클릭
 * -Dfile.encoding=UTF-8

## 이클립스 단축키
 * Ctrl + I : 들여쓰기 자동 수정
 * Ctrl + Shift + O : 자동 import 
 * Ctrl + Shift + L    단축키 표시
 * Ctrl + Shift + F 줄정렬
 * Ctrl + / 주석처리

# Window Preference
- General -  font/Syntax/Save
