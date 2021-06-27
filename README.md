# 깃 
* tortoisegit

# [it blog](https://brunch.co.kr/@sicle-official/35)

# [깃 이그노어](https://www.toptal.com/developers/gitignore)

# [깃 rm](https://gmlwjd9405.github.io/2018/05/17/git-delete-incorrect-files.html)

# git add/commit 취소
```java
// [방법 1] commit을 취소하고 해당 파일들은 staged 상태로 워킹 디렉터리에 보존
$ git reset --soft HEAD^
// [방법 2] commit을 취소하고 해당 파일들은 unstaged 상태로 워킹 디렉터리에 보존
$ git reset --mixed HEAD^ // 기본 옵션
$ git reset HEAD^ // 위와 동일
$ git reset HEAD~2 // 마지막 2개의 commit을 취소
// [방법 3] commit을 취소하고 해당 파일들은 unstaged 상태로 워킹 디렉터리에서 삭제
$ git reset --hard HEAD^
https://gmlwjd9405.github.io/2018/05/25/git-add-cancle.html
```
## git commit 수정
* commit message를 잘못 적은 경우, git commit –amend 명령어를 통해 git commit message를 변경할 수 있다.
* $ git commit --amend


# git reset
* git reset --hard 리비전
	* git log
	* git push -f origin branch

## git add .
```java
이 말은 .gitignore 에 현재 staged로 변경할 파일의 이름이 있다는 것이다

.gitignore로 git에 안올린다고 했는데 git add *로 다 올린다고 하니 

다시 확인 하라는 말이다. 
```

# git branch
1. 생성 :
	* git branch [브랜치명]
1-2. 생성 후 이동 :
	* git checkout -b feature-01
2. Git remote branch 생성
	* git push origin feature-01
3. branch local remote 연동
	* git branch --set-upstream-to origin/feature-01
4. branch 삭제
	* git granch -d 브랜치명
5. 원격 branch 삭제
	* git push origin :feature-01

# [git tag](https://git-scm.com/book/ko/v2/Git%EC%9D%98-%EA%B8%B0%EC%B4%88-%ED%83%9C%EA%B7%B8)
* 테그 원격에 넣기
	1. tag 없는지 확인
	2. git tag tag번호
	3. git push origin v1.5
	4. 한번에 여러 태그 넣기: git push origin --tags
* 태그 지우기
	1. git tag -d 3.2.14
	2. git push origin :3.2.14


# [저장소 파일 삭제하기](https://gmlwjd9405.github.io/2018/05/17/git-delete-incorrect-files.html)

# 커밋 리비전
* git show 리비전

# SCM
```java
소프트웨어 공학에서 소프트웨어 구성 관리(software configuration management, SCM, S/W CM)[1]는 더 범위가 큰 구성 관리의 학문간 분야의 일부인, 
소프트웨어의 변경사항을 추적하고 통제하는 작업이다.[2] SCM 행위에는 버전 관리, 베이스라인 확립이 포함된다. 무언가 잘못되는 경우 SCM은 변경사항과 
변경한 사람을 특정할 수 있다. 구성이 잘 된 경우 SCM은 수많은 호스트에 걸쳐 이를 복제(replicate)하는 방법을 결정한다.
```
* working copy ->(add) index/staging area ->(commit) repositories
* [깃 구역](https://www.youtube.com/watch?v=5_WUgstXTyU&list=PLuHgQVnccGMCejd1l8C8oyZSYQDtkMRAg&index=7)


# [커밋명](https://blog.ull.im/engineering/2019/03/10/logs-on-git.html)


# Jira
* git commit -m "CHER-33 #comment Create Client"

# 새 프로젝트 만들기
1. repository 만들기(name, description, readme file, 이니셜라이즈)*
2. git remote add origin 주소
3. git pull origin master
4. git add 
5. git commit -m "initial"
6. git push origin master


# clone
* 폴더 마우스 우측 -> 깃 베시 -> git clone 레파지토리

# 깃 초기 설정
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


# branch
* git branch issue1
	* git branch
* git checkout <branch>
	* git checkout -b <branch> checkout 명령에 -b 옵션을 넣으면 브랜치 작성과 체크아웃을 한꺼번에 실행할 수 있습니다.
	* git checkout -b 커밋명 태그명
* git branch -f master HEAD~4
	* 브랜치 이동
* git checkout master
	* git merge develop

## 깃 기능
* git rm --cached: 커밋
* git diff: 최신 커밋 된 파일과 변경된 부분 비교
* git reset: 이전 커밋 내용 수정을 위해 사용 (push하지 않은 경우 유용)
	* git reset --hard HEAD~1
* Git revert: 이전 커밋에서 변경한 내용을 취소해서 새로운 커밋 추가 (push한 경우 유용)
	* git revert C4
* git rebase -i 
* git chery-pick COMMIT1 / COMMIT2


# git rebase
* git rebase -i
	* 커밋명 변경

# [윈도우 깃 권한](https://techstock.biz/Git-Github/Git-push-denied/)
1. 제어판 - 사용자 계정
2. Windows 자격 증명 관리
3. github.com 삭제
	

# 마크다운
* 수평선: <hr/>
* 블럭인용문자: >
* 강조: *, -, +, _;  **강조**
* 링크: [링크할 이름](링크주소)
* 그림: ![링크할 이름](그림주소)

# archive
* git archive --format=zip master -o Master.zip

# tag
* git tag 테그명
* git checkout -b bugfix1 테그명

# 소스트리
* rebase
	1. git rebase master
	2. git rebase bugFix
* reset
	* hard reset: 전 과정 다 지우고 돌아가기
* revert
	* reset과 달리 커밋을 보존하면서 내용만 되돌리는 것
	* 전 과정을 1개씩 돌아가야 한다.
		* 충돌이 일어날 수 있다. 
		* reverse 하는 단계에서의 변화만 취소 
* 더블 클릭
	* 전 과정을 더블클릭하여 돌아간다.
	* 원래대로 돌아가려면 'master' 더블 클릭
* 비교하기
	* 옵션에서 dif 파일 설치 -> action dif
* 시간여행
	* 과거 상태 보기: 더블클릭
	* 현재로 돌아오기: 마스터 더블클릭


# [깃독서](https://learngitbranching.js.org/?locale=ko)
* 데블로그: https://awesome-devblog.netlify.com/
* 정아마추어 코딩블로그: https://jeong-pro.tistory.com/
* goodgid: https://goodgid.github.io/category/
* 하나씩 점을 찍어가며: https://dailyheumsi.tistory.com/
* 에반문: https://evan-moon.github.io/
------
* homebody: https://hombody.tistory.com/
* 백기선 https://www.whiteship.me
* 히스 블로그: https://gmlwjd9405.github.io
* 카카오 블로그: https://tech.kakao.com/blog/
* 우아한 형제들: https://woowabros.github.io/
* 개발자 스럽다 https://blog.gaerae.com/
* 스프링 공식 블로그: https://spring.io/blog
* 자바 레딧: https://www.reddit.com/r/java/
