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


## 해답
```java
import java.util.HashSet;
import java.util.Set;

public class FindSosu {
    public int solution(String numbers) {
        char[] list = numbers.toCharArray();
        int[] combArr = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            combArr[i] = Integer.parseInt(String.valueOf(list[i]));
        }
        Set<Integer> sosuList = new HashSet<>();
        for (int i = 1; i <= list.length; i++) {
            perm(list, 0, i, sosuList);
        }

        System.out.println("소수 리스트입니다.");
        System.out.println(sosuList);

        return sosuList.size();
    }
    
   public void perm(char[] arr, int depth, int k, Set sosuList) {
        if (depth == k) { 
            // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.
            print(arr, k, sosuList);
            return;
        } else {
            for (int i = depth; i < arr.length; i++) {
                swap(arr, i, depth);
                perm(arr, depth + 1, k, sosuList);
                swap(arr, i, depth);
            }
        }
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void print(char[] arr, int k, Set sosuList) {
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i]);
            a.append(arr[i]);
        }
        System.out.println();
        isSosu(sosuList, a);
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
