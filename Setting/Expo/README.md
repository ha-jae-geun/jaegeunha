# 순서
0. 안드로이드 스튜디오
1.  [expo](https://expo.io/learn)
2. nodeJS [expo](https://expo.io/learn)
3. [지니모션](https://park0422.tistory.com/5)
4. Virtual Box
5. npm install expo-cli --global
6. 프로젝트
```java
expo init myNewProject
cd myNewProject
expo start
```
7. cmd 에서 프로젝트로 이동해서 expo start
8. 지니모션 단말기 켜기
9. 리액트  [리액트](https://react-native-elements.github.io/react-native-elements/)

# expo
*  [expo](https://expo.io/learn)
* [윈도우 expo](https://www.youtube.com/watch?v=WnS7dcY5Hys)

## expo 장점
1. 폰으로 코드를 스캔해서 모방리 환경에서 접근 가능
2. 컴퓨터에서 변경사항이 있으면 모바일에서도 자동으로 새로고침이 되서 적용이 됨
3. 앱을 베포했을 때, 업데이트 하고 있을 때 유저에게 업데이트를 하게끔 유도하는 등 프로세스가 많다.
  * 전체앱을 앱스토어에 올리는 것이 아니라 expo client에게 push한다.
  
  
# 안드로이드 스튜디오
1. 안드로이드 스튜디오 다운로드(Open JDK 사용)
2. Android SDK 폴더 만들기
 * 기본으로 하면 숨김파일 APPDATA에 저장됨
 * C:\Android_SDK에 설치
3. 환경변수 폴더 만들기
 * C:\ANDROID_Avd_Gradle
4. ANDROID_SDK_HOME 환경변수 추가
5. 안드로이드 스튜디오 설치하기
6. Install Type custom
7. ANDROID SDK 경로 설정하기  
 * Configure - Sytem Settings - Android SDK
8. 빌드 설정
 * Build - Build Tools - Gradle - C:\ANDROID_Avd_Gradle\gradle
8. vmoptions 수정하기(직접 수정하면 안된다) 
 1. Android - Android Studoi - bin - studio64.exe vmoptions 복사
 2. configure - edit custom vm options에 붙여넣기
9. 메모리 세팅
 1. configure - Appearance - System Settings - Memory Settings - 메모리 최대
10. Properties 복사
 1. idea.properties 복사
 2. configure - custome properties에 붙여넣기
11. 인코딩 설정
 * Editor - File encodings에 UTF-8로 통일

## 플러그인
* 지니
 1. settings - plugins - genymotion - install로 설치
 2. view - toolbar에서 띄우기



# Node JS
* [expo](https://expo.io/learn)
1. Download Node JS


# 지니 모션
[지니모션](https://park0422.tistory.com/5)
```java
지니모션이란 VirtualBox의 가상화 기술을 이용한 에뮬레이터입니다. 
안드로이드 스튜디오에서도 기본 에뮬레이터를 제공해주지만,
속도가 너무 느려서 사용하기 불편해, 지니모션을 많이 사용합니다.  
```
* Settings - SDK 설정



# 리액트
* [react](https://react-native-elements.github.io/react-native-elements/)
* cmd 내 프로젝트 리엑트 깔기(반드시 내 프로젝트)
 * npm install react-native-elements
