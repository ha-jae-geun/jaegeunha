# 깃독서
* goodgid: https://goodgid.github.io/
* 에반문: https://evan-moon.github.io/
* 정아마추어 코딩블로그: https://jeong-pro.tistory.com/
* homebody: https://hombody.tistory.com/
* 개발자 스럽다 https://blog.gaerae.com/
* 정보처리기사 https://www.gunsys.com/q/index.php?midCode=1010
* OKKY https://okky.kr/

# SCM
```java
소프트웨어 공학에서 소프트웨어 구성 관리(software configuration management, SCM, S/W CM)[1]는 더 범위가 큰 구성 관리의 학문간 분야의 일부인, 
소프트웨어의 변경사항을 추적하고 통제하는 작업이다.[2] SCM 행위에는 버전 관리, 베이스라인 확립이 포함된다. 무언가 잘못되는 경우 SCM은 변경사항과 
변경한 사람을 특정할 수 있다. 구성이 잘 된 경우 SCM은 수많은 호스트에 걸쳐 이를 복제(replicate)하는 방법을 결정한다.
```
* working copy ->(add) index/staging area ->(commit) repositories

# 새 프로젝트 만들기
1. repository 만들기(name, description, readme file, 이니셜라이즈)*
2. git remote add origin 주소
3. git pull origin master
4. git add 
5. git commit -m "initial"
6. git push origin master

# 깃 처음 설정
* git bash 설치
* git config --global user.name "이름"  // 아이디가 아닌 계정 이름
	* - git config --global --unset-all user.name // 로그아웃
	* git config user.name // 확인
* git config --global user.email "깃허브 메일주소" // 매번 물어보는 귀찮음을 피하기 위해 설정. 
	*  git config --global --unset-all user.email // 로그아웃
	* git config user.email 확인
* - git config --system --unset-all credential.helper
* mkdir ~/MyProject   // 로컬 디렉토리 만들고
* cd ~/myproject      // 디렉토리로 들어가서
* git init            // 깃 명령어를 사용할 수 있는 디렉토리로 만든다.
* git remote add origin https://github.com/username/myproject.git // 로컬과 원격 저장소를 연결한다.
* git remote -v // 연결상태를 확인한다.
* git status          // 현재 상태를 훑어보고
* git add 화일명.확장자  // 깃 주목 리스트에 화일을 추가하고 or
* git add .           // 이 명령은 현재 디렉토리의 모든 화일을 추가할 수 있다.
* git commit -m “현재형으로 설명” // 커밋해서 스냅샷을 찍는다.
* git pull origin master
git push origin master // 깃허브로 푸시한다.
* git rm -f filename add origin <원격주소>  -> * git remote -v 로 확인 -> git pull origin master로 받아오기
* git branch [branch](https://wayhome25.github.io/git/2017/07/08/git-first-pull-request-story/)

## 브랜치
* $ git branch issue1
	* $ git branch
* $ git checkout <branch>
	* $ git checkout -b <branch> checkout 명령에 -b 옵션을 넣으면 브랜치 작성과 체크아웃을 한꺼번에 실행할 수 있습니다.
* $ git merge <commit>
* $ git checkout master


# 마크다운
* 수평선: <hr/>
* 블럭인용문자: >
* 강조: *, -, +, _;  **강조**
* 링크: [링크할 이름](링크주소)
* 그림: ![링크할 이름](그림주소)


# 소스트리
* reset
	* hard reset: 전 과정 다 지우고 돌아가기
* revert
	* 전 과정을 1개씩 돌아가야 한다.
* 더블 클릭
	* 전 과정을 더블클릭하여 돌아간다.
	* 원래대로 돌아가려면 'master' 더블 클릭
* 비교하기
	* 옵션에서 dif 파일 설치 -> action dif

