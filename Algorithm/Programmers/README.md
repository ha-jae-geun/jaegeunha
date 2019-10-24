# 해시
## 전화번호 목록
```java
class Solution {
    public boolean solution(String[] phoneBook) {
       for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return true;
    }
}
```

# 다리를 지나는 트럭
```java
import java.util.*;

class Solution {
    public class Truck{
        int weight;
        int distance;

        public Truck(int weight, int distance){
            this.weight=weight;
            this.distance=distance;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int weightLeft = weight;
        int time=0;

        Queue<Truck> outList = new LinkedList<Truck>();
        List<Truck> inList = new ArrayList<Truck>();

        for(int t : truck_weights){
            outList.add(new Truck(t,bridge_length));
        }

        while(! (outList.isEmpty() && inList.isEmpty())){
            time++;

            if(!inList.isEmpty() && inList.get(0).distance==0){
                weightLeft+=inList.get(0).weight;
                inList.remove(0);

            }

            if(!outList.isEmpty() && outList.peek().weight<=weightLeft){
                weightLeft-=outList.peek().weight;
                inList.add(outList.poll());
            }

            for(int i=0; i<inList.size();i++){
                inList.get(i).distance--;
            }
        }

        return time;
    }
```

```java
트럭 클래스 선언

다리가 버틸 수 있는 남아있는 무게, 시간을 저장할 변수 선언

아직 다리를 지나지 못한 트럭 리스트 = outList

다리를 지나고 있는 트럭 리스트 = inList

outList에 순서대로 트럭들을 저장해주고

outList와 inList가 모두 비어있을 때까지 반복문을 돌려줌

inList의 첫번째 성분(가장 먼저 다리에 들어간 트럭)의 distance가 0일 경우

가용무게를 그만큼 더해주고 요소를 제거해줌

그 다음 트럭이 들어올 수 있는지 체크한 후 가능하면 트럭을 들여보냄

time을 1초 더해줬기 때문에 전체트럭의 남은 거리를 discounting해줌
```

# 나누어 떨어지는 수
```java
array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

제한사항
arr은 자연수를 담은 배열입니다.
정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
divisor는 자연수입니다.
array는 길이 1 이상인 배열입니다.

class Solution {
  public int[] solution(int[] arr, int divisor) {
      int[] answer = {};
      return answer;
  }
}
```

```java
import java.util.*;
 
class Divisible {
    public int[] divisible(int[] array, int divisor) {
        //ret에 array에 포함된 정수중, divisor로 나누어 떨어지는 숫자를 순서대로 넣으세요.
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<array.length; i++){
            if(array[i]%divisor==0){
                list.add(array[i]);
            }
        } 
        int[] ret = new int[list.size()];
        for(int j=0; j<list.size(); j++){
            ret[j] = list.get(j);
        }        
        return ret;
    }
    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        Divisible div = new Divisible();
        int[] array = {5, 9, 7, 10};
        System.out.println( Arrays.toString( div.divisible(array, 5) ));
    }
}

```

# 같은 숫자는 싫어
```java
문제 설명
배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,

arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.

제한사항
배열 arr의 크기 : 1,000,000 이하의 자연수
배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
```

```
import java.util.*;
 
public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int preNum = 10;
        for(int num : arr) {
            if(preNum != num)
                tempList.add(num);
            preNum = num;
        }       
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i).intValue();
        }
        return answer;
    }
}
```

# 체육복
```java
점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

제한사항
전체 학생의 수는 2명 이상 30명 이하입니다.
체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
입출력 예
n	lost	reserve	return
5	[2, 4]	[1, 3, 5]	5
5	[2, 4]	[3]	4
3	[3]	[1]	2
입출력 예 설명
예제 #1
1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다.

예제 #2
3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.
```

# 숫자야구; 완전 탐색
```java
숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다. 게임해보기

각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다. 그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.

* 숫자는 맞지만, 위치가 틀렸을 때는 볼
* 숫자와 위치가 모두 맞을 때는 스트라이크
* 숫자와 위치가 모두 틀렸을 때는 아웃
예를 들어, 아래의 경우가 있으면

A : 123
B : 1스트라이크 1볼.
A : 356
B : 1스트라이크 0볼.
A : 327
B : 2스트라이크 0볼.
A : 489
B : 0스트라이크 1볼.
이때 가능한 답은 324와 328 두 가지입니다.

질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때, 가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.

제한사항
질문의 수는 1 이상 100 이하의 자연수입니다.
baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를 담고 있습니다.
입출력 예
baseball	return
[[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]]	2

class Solution {
    public int solution(int[][] baseball) {
        int answer = 0;
        return answer;
    }
}

```

```java
import java.util.Stack;
public class Solution {
	public static int getStrike(String chk, String num) {
		int cnt = 0;
		for(int i = 0; i < 3; i++)
			cnt += chk.charAt(i) == num.charAt(i) ? 1 : 0;
		
		return cnt;
	}
	public static int getBall(String chk, String num) {
		int cnt = 0;		
		for(int i = 0; i < 3; i++) {
			if(chk.contains(String.valueOf(num.charAt(i))))
				cnt += chk.indexOf(num.charAt(i)) == i? 0 : 1;
		}
		
		return cnt;
	}

	public int solution(int[][] baseball) {
        int answer = 0, cnt;
        
        Stack stack = new Stack<>();
        for(int i = 1; i < 10; i++) {
            for(int j = 1; j < 10; j++) {
                for(int k = 1; k < 10; k++) {
                    if(i != j && j != k && i != k) {
                    	stack.add(String.valueOf(i*100 + j*10 + k));
                    }
                }
            }
        }
        
        while(!stack.isEmpty()) {
        	String chNum = stack.pop();
        	cnt = 0;
        	for(int i = 0; i < baseball.length && cnt < baseball.length; i++) {
            	int strike = getStrike(chNum, String.valueOf(baseball[i][0]));
            	int ball = getBall(chNum, String.valueOf(baseball[i][0])); 
        		
            	if(strike == baseball[i][1] && ball == baseball[i][2])
            		cnt++;
            }
        	if(cnt == baseball.length)  answer++;		
        }
        return answer;
    }
}


```

# 소수 찾기
```java
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
입출력 예
numbers	return
17	3
011	2
입출력 예 설명
예제 #1
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

예제 #2
[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.

11과 011은 같은 숫자로 취급합니다.


* 식
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        return answer;
    }
}
````


## 해답(에라토스테네스의 체)
```java
class Solution {
      public int solution(int n) {
          int answer = 0;
          
          int[] number = new int[n+1];
          
          //2부터 n까지의 수를 배열에 넣는다.
          for(int i=2; i<=n; i++) {
              number[i] = i;
          }
          
          //2부터 시작해서 그의 배수들을 0으로 만든다.
          //후에 0이면 넘어가고 아니면 그의 배수들을 다시 0으로 만든다.
          for(int i=2; i<=n; i++) {
              if(number[i]==0) continue;
              
              for(int j= 2*i; j<=n; j += i) {
                  number[j] = 0;
              }
          }
          
          //배열에서 0이 아닌 것들의 개수를 세준다.
          for(int i=0; i<number.length; i++) {
              if(number[i]!=0) {
                  answer++;
              }
          }
          
          return answer;
      }
    }
```


# 완주하지 못한 선수
[완주하지 못한 선수](https://programmers.co.kr/learn/courses/30/lessons/42576)
```java
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

제한사항
마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
completion의 길이는 participant의 길이보다 1 작습니다.
참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
참가자 중에는 동명이인이 있을 수 있습니다.
```

## 해답
```java
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for ( i=0; i < completion.length; i++){

            if (!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[i];
    }
}

```

# 프린트 문제
[프린트 문제](https://programmers.co.kr/learn/courses/30/lessons/42587)

```java
일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.

1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.
예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.

내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.

현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때, 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
```
```java
import java.util.*;
 
class Solution {
    public int solution(int[] priorities, int location) {
        //answer는 내가 원하는 프린트의 출력 순서
        //index는 우선순위에 맞춰 변하는 배열의 index를 표시하기 위한 변수
        //max_change는 max_change가 0일 때는 우선순위 최대값이 변하지 않고
        //1 일때는 우선순위를 변경시켜야 한다는 것을 표시해야하는 변수
        int answer = 0;
        int index = 0;
        int max_change = 0;
                
        ArrayList<Integer> prior = new ArrayList<Integer>();
        
        for(int i=0; i<priorities.length; i++) {
            prior.add(priorities[i]);
        }
        
        //Collections.max()를 사용하면 변하는 최대값을 찾기가 힘들어서 내림차순으로 만들어 사용하였다.
        Collections.sort(prior);
        Collections.reverse(prior);
        int max = prior.get(0);
        
        while(true){
            //index를 돌면서 max값과 같아지면 프린트하고 그 수를 -1로 만들어준다.
            //하나를 출력하였으므로 answer를 추가시키고 최대 우선순위를 가진 프린트가 출력되었으므로,
            //max_change 스위치를 1로 바꿔준다.
            if(priorities[index]==max) {
                priorities[index] = -1;
                answer++;
                max_change = 1;
            } else {
            //index를 돌게하기 위해서 최대값이 아니라면 1씩 증가시켜주고 끝까지 간다면 0으로 만들어준다.
                if(index==priorities.length-1) {
                    index = 0;
                } else {
                    index++;
                }
            }
            
            //원하는 location의 프린트가 출력되어서 -1이 된다면 break한다.
            if(priorities[location]==-1) {
                break;
            }
            
            //max_change가 1이 되면 현재의 최대 우선순위를 제거해주고 max를 바꿔준다.
            //max_change를 0으로 다시 설정해 스위치를 꺼준다.
            if(max_change==1) {
                prior.remove(0);
                max = prior.get(0);
                max_change = 0;
            }
        }
        
        return answer;
    }
}
```

# K번째 수
```java
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
```

## 풀이
```java
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int [] temp = {};
        
        for(int i =0;i < commands.length;i++) {
            temp = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            Arrays.sort(temp);
            answer[i]=temp[commands[i][2]-1];
        }
        return answer;
    }
}

```
