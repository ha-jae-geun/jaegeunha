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


package jaegeun;

import java.util.Scanner;

public class Stack2 {

	static {

	}

	public static String[][] copyStar(String[][] star, String[][] result, int k, int l) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				if (star[i][j] != null) {
					result[i + k][j + l - 3] = star[i][j];
				}
			}
		}
		return result;

	}

	public static void main(String[] args) throws java.lang.Exception {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();

		String[][] isResult = new String[input][(input * 2) + 10];
		String[][] isStar = new String[3][6];
		int count = 1;
		int repeat = 0;
		int[] countArray = new int[] { 2, 1, 1, 1 };

		for (int i = 0; i < 3; i++) {
			int l = 0;
			for (int j = 1; j < 3 - i; j++) {
				l = l + 1;
				isStar[i][l] = " ";
			}
			isStar[1][3] = " ";

			for (int k = 0; k < i * 2 + 1; k++) {
				l = l + 1;
				isStar[i][l] = "*";
			}
		}

		isResult = copyStar(isStar, isResult, 0, input - 1);

//		
		for (int i = 3; i < input; i = i + 3) {
			int a = 0;

			if (count % 4 == 0) {
				for (int k = 0; k < countArray[0]; k++) {
					isResult = copyStar(isStar, isResult, i, input + i - a - 1);
					a = a + 24;

				}
				countArray[0] = countArray[0] + 1;
			}
			if (count % 4 == 1) {
				for (int k = 0; k <= countArray[1] - 1; k++) {
					isResult = copyStar(isStar, isResult, i, input + i - a - 1);
					isResult = copyStar(isStar, isResult, i, input - i + a - 1);
					if(k%2 == 0)
						a = a + 6;
					else
						a = a + 18;

				}
				countArray[1] = countArray[1] + 1;
			}
			if (count % 4 == 2) {
				for (int k = 0; k <= countArray[2] - 1; k++) {
					a = a + 6;
					isResult = copyStar(isStar, isResult, i, input - a - 1);
					isResult = copyStar(isStar, isResult, i, input + a - 1);
					a = a + 6;

				}
				countArray[2] = countArray[2] + 1;
			}
			if (count % 4 == 3) {
				for (int k = 0; k <= countArray[3]; k++) {

					isResult = copyStar(isStar, isResult, i, input + i - a - 1);
					isResult = copyStar(isStar, isResult, i, input - i + a - 1);

//					isResult = copyStar(isStar, isResult, i, input + i - a -1);
//					isResult = copyStar(isStar, isResult, i, input - i + a -1);
					a = a + 6;

//					isResult = copyStar(isStar, isResult, i, input + a -1);
//					isResult = copyStar(isStar, isResult, i, input - a -1);
//					isResult = copyStar(isStar, isResult, i, input + a + 6 -1);
//					isResult = copyStar(isStar, isResult, i, input - a - 6 -1);

				}
				countArray[3] = countArray[3] + 2;
			}
			count = count + 1;

		}

		for (int i = 0; i < input; i = i + 1) {
			for (int j = 0; j < (input * 2) - 1; j++) {

				if (isResult[i][j] != "*")
					isResult[i][j] = " ";
				System.out.print(isResult[i][j]);

			}
			System.out.println();
		}

	}
}










```


```
