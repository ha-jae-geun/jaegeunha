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






import java.util.*;
import java.lang.*;
import java.io.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;


class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		ArrayList<Character> arrayList = new ArrayList<Character>();
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
		String result = "";
		// ArrayList<HashMap<Integer, Character>> arrayList2 = new ArrayList<HashMap<Integer, Character>>();
		// HashMap<Integer, Character> hashmap = HashMap<Integer, Character>();
		
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String input = bufferedReader.readLine();
		
		for(int i = 0; i<input.length(); i++) {
			arrayList.add(input.charAt(i));
		}
		
		for(int i = 0; i<arrayList.size() ; i++) {
			if(arrayList.get(i).equals('(')) {
				if(i<arrayList.size()-1 && arrayList.get(i+1).equals(')')) {
					if(i<arrayList.size()-3 && arrayList.get(i+2).equals('(') && arrayList.get(i+3).equals(')'))
						arrayList2.add(1);  // 1번 케이스 2 +
					else if(i<arrayList.size() && arrayList.get(i+2).equals('[') && arrayList.get(i+3).equals(']'))
						arrayList2.add(1);  // 1번 케이스 2 +
					else 
						arrayList2.add(6);  // 6번 케이스 2
				}
				if(i<arrayList.size()-1 && !arrayList.get(i+1).equals(')'))
					arrayList2.add(2); // 2번 케이스 2 *
			}
			if(arrayList.get(i).equals(')')) {
				if(i<arrayList.size()-1 && !(arrayList.get(i-1).equals('(')))
					arrayList2.add(3); // 3번 케이스 )
				if(i==arrayList.size()-1 && !(arrayList.get(i-1).equals('(')))
					arrayList2.add(3); // 3번 케이스 )
			}
			
			if(arrayList.get(i).equals('[')) {
				if(i<arrayList.size()-1 && arrayList.get(i+1).equals(']')) {
					if(i<arrayList.size() && arrayList.get(i+2).equals('(') && arrayList.get(i+3).equals(')'))
						arrayList2.add(4);  // 1번 케이스 2 +
					else if(i<arrayList.size() && arrayList.get(i+2).equals('[') && arrayList.get(i+3).equals(']'))
						arrayList2.add(4);  // 1번 케이스 2 +
					else 
						arrayList2.add(7);  // 6번 케이스 2
				}
				if(i<arrayList.size()-1 && !(arrayList.get(i+1).equals(']')))
					arrayList2.add(5); // 5번 케이스 3 *
			}
			if(arrayList.get(i).equals(']')) {
				if(i<arrayList.size()-1 && !(arrayList.get(i-1).equals('[')))
					arrayList2.add(3); // 3번 케이스 )
				if(i==arrayList.size()-1  && !(arrayList.get(i-1).equals('[')))
					arrayList2.add(3); // 3번 케이스 )
					
			}
			
		}

		for(int i = 0; i<arrayList2.size() ; i++) {
			if(arrayList2.get(i)  == 3)
				result = result + ")";
			if(arrayList2.get(i)  == 1)
				result = result + "2 +";
			if(arrayList2.get(i)  == 2)
				result = result + "2 *(";
			if(arrayList2.get(i)  == 4)
				result = result + "3 +";
			if(arrayList2.get(i)  == 5)
				result = result + "3 *(";
			if(arrayList2.get(i)  == 6)
				result = result + "2";
			if(arrayList2.get(i)  == 7)
				result = result + "3";
		}
		String result2 = result.substring(0, result.length());
		System.out.println(result2);
		
		
		// ScriptEngineManager mgr= new ScriptEngineManager();
  //  	ScriptEngine engine = mgr.getEngineByName("JavaScript");
  //  	System.out.println(engine.eval(result2));
		
	}
}







```


```
