# 설치
1. 홈페이지에서 window용 다운 
  * [홈페이지](https://code.visualstudio.com/)
2. yarn 설치

# 특징
* 비주얼 스튜디오 코드는 폴더 단위로 하나의 프로젝트, 웹앱, 웹사이트로 인식

## 세팅
1. 폴더 설정
 * 파일 - Open Folder - 폴더 설정
 
 # 한글 깨짐
 * 저장할 때 UTF 8 With BOM
 
 
 ## Extensions
 * HTML PREVIEW
   + html의 preview를 보여줌
 * Live Server
   + 도메인 영역에서 실행해줌(URL, URI 단위)
   + 사용법: 마우스 우측 - Open with Live Server
* FTP SIMEPLE
```JAVA
[
	{
		"name": "project",
		"host": "49.50.166.21", // 주소
		"port": 10021, //포트
		"type": "ftp",
		"username": "user", // 이름
		"password": "dbwjdbwj1",  //한글 안됨
		"path": "/",
		"autosave": true,
		"confirm": true
	}
]
```
  * FTP REMOTE

# yarn
* npm install -g yarn
