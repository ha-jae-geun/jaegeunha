- http://connoyaro.synology.me:5000/

# Programming
* git bash 설치
* git config --global user.name "이름"  // 아이디가 아닌 계정 이름
* git config --global user.email "깃허브 메일주소" // 매번 물어보는 귀찮음을 피하기 위해 설정. 
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




---
# Link
 * [Network](./network/README.md)
 * [Programing Language](./PL/README.md)
 * [Software](./SW/README.md)
 * [Virtual](./virtual/README.md)
 * [Computer Architecture](./ComputerArchitecture/README.md)
 * [Algorithm](./Algorithm/README.md)
 * [OS](./OS/README.md)
   + [Linux](./OS/Linux/README.md)
   + [Android](./OS/Android/README.md)
* [English](./English/README.md)

---
* 애플 wwdc, 마이크로소프트, 구글 io, 네이버

### Alan Turing
* 최초의 컴퓨터 기반
* virtual machine

### Bjarne Stroustrup
* c++

### John von Neumann

### Grady Booch 

### Gordon Earle Moore
* [1](https://ko.wikipedia.org/wiki/%EA%B3%A0%EB%93%A0_%EB%AC%B4%EC%96%B4)

### Guido van Rossum
* python

### Ivar Jacobson
  

### James Gosling
* [java](https://namu.wiki/w/Java?from=JAVA)
* [2]https://ko.wikipedia.org/wiki/%EC%9E%90%EB%B0%94_(%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D_%EC%96%B8%EC%96%B4)

### James Rumbaugh  

### Linus Benedict Torvalds
* [profile]https://ko.wikipedia.org/wiki/%EB%A6%AC%EB%88%84%EC%8A%A4_%ED%86%A0%EB%A5%B4%EB%B0%9C%EC%8A%A4
* [git]https://ko.wikipedia.org/wiki/%EA%B9%83_(%EC%86%8C%ED%94%84%ED%8A%B8%EC%9B%A8%EC%96%B4)

### Robert Norton Noyce



-----------
```java
import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws java.lang.Exception {
    	int bag = 0;
	    int fiveWeight = 0;
	    int threeWeight = 0;
	    int result = 0;
    	
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        
        
        
        if( num % 5 == 0)
			result = num/5;
	    else if(num % 5 == 3) {
	        fiveWeight = num/5;
	        threeWeight = (num - (num*fiveWeight)) / 3;
	        result = fiveWeight + threeWeight;
	    }
	    else {
	    	int num2 = num - 5*(num/5);
	    	while(num2 >= 3) {
	    		num2 = num2 - 5;
	    		fiveWeight = fiveWeight + 1;
	    		 if( num2 % 3 == 0) {
	    			threeWeight = (num - (num*fiveWeight)) / 3;
					result = fiveWeight + threeWeight;
	    		 }
	    	}
	    }
	    
	    System.out.println(result);

    }
}
```
