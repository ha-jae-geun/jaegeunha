# Two Sum
```java
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
    }
}
```

```
public int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
        if (map.containsKey(target - numbers[i])) {
            result[1] = i;
            result[0] = map.get(target - numbers[i]);
            return result;
        }
        map.put(numbers[i], i + 1);
    }
    return result;
}
```


#  Middle of the Linked List
```java
Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        
    }
}

```

## 풀이 1번
```java
public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

Each time, slow go 1 steps while fast go 2 steps.
When fast arrives at the end, slow will arrive right in the middle.
```

## 풀이 2번
```java
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null) return head;

        int len = 0;
        ListNode current = head;
        while(current != null) {
            len++;
            current = current.next;
        }
        
        len /= 2;
        current = head;
        while(len > 0) {
            current = current.next;
            len--;
        }
        
        return current;
    }
}
```

#  N-ary Tree Preorder Traversal
```java
Given an n-ary tree, return the preorder traversal of its nodes' values.

For example, given a 3-ary tree:

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        
    }
}
```

```java
class Solution {
    public List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null)
            return list;
        
        list.add(root.val);
        for(Node node: root.children)
            preorder(node);
                
        return list;
    }
}
```

# 삼각형 출력하기
```java
printTriangle 메소드는 양의 정수 num을 매개변수로 입력받습니다. 
다음을 참고해 *(별)로 높이가 num인 삼각형을 문자열로 리턴하는 printTriangle 메소드를 완성하세요 
printTriangle이 return하는 String은 개행문자(‘\n’)로 끝나야 합니다.
```

```java
public class PrintTriangle {
    public String printTriangle(int num){
      String result = "";
      String stars = "*";
      for(int i=0; i<num; ++i){
          result += stars+"\n";
          stars += "*";
      }
      return result;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        PrintTriangle pt = new PrintTriangle();
        System.out.println( pt.printTriangle(3) );
    }
}
```

# [기술면접 라이브코딩] 다이나믹 프로그래밍, LC#70 Climbing Stairs
```java
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```

```java
public int climbStairs(int n) {
    // base cases
    if(n <= 0) return 0;
    if(n == 1) return 1;
    if(n == 2) return 2;
    
    int one_step_before = 2;
    int two_steps_before = 1;
    int all_ways = 0;
    
    for(int i=2; i<n; i++){
    	all_ways = one_step_before + two_steps_before;
    	two_steps_before = one_step_before;
        one_step_before = all_ways;
    }
    return all_ways;
}
```

## 풀이 2
```java
if(n==0) return 0;
if(n==1) return 1;
ind[] d = new int[n-1];
d[1] = 1;
d[2] = 2;

for(int i = 3; i<=n; i++) {
	d[i] = d[i-1] + d[i-2]
}
return d[n]
```

# 스택, LC #20 Valid Parentheses
```java
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true

* 초기식
class Solution {
    public boolean isValid(String s) {
        
    }
}
```

```java
public boolean isValid(String s) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}
```


# 21. Merge Two Sorted Lists

```java
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```

## 풀이
```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
}
```



## 풀이2
```java
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        
        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }
}
```

<hr/>




# Binary Tree Level Order Traversal
```java
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
```

```java
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) return wrapList;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}
```



<hr/>



# 이진검색트리의 기본 성질, LC 530. Minimum Absolute Difference in BST
```java
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
```
* [홈페이지](https://leetcode.com/problems/minimum-absolute-difference-in-bst/)

## 풀이
```java
public class Solution {
    
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev;
    
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }
    
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null) minDiff = Math.min(minDiff, root.val - prev.val);
        prev = root;
        inorder(root.right);
    }

}
```

## 팁
* 이진트리는 inorder 정리하면 오름차순 정리가 된다.





<hr/>




# 문자열 내림차순으로 배치하기 (java)
```java
reverseStr 메소드는 String형 변수 str을 매개변수로 입력받습니다. 
str에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 String을 리턴해주세요. 
str는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다. 
예를들어 str이 “Zbcdefg”면 “gfedcbZ”을 리턴하면 됩니다.
```

```java
import java.util.Arrays;
import java.util.Collections;

public class ReverseStr {
    public String reverseStr(String str){
        String[] array = str.split("");
        Arrays.sort(array,  Collections.reverseOrder());

        return String.join("", array);
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        ReverseStr rs = new ReverseStr();
        System.out.println( rs.reverseStr("Zbcdefg") );
    }
}
```

```java
import java.util.Arrays;
import java.util.Collections;

public class ReverseStr {
  public String reverseStr(String str){
    String[] array = str.split("");
    Arrays.sort(array);
    Collections.reverse(Arrays.asList(array));
    return  String.join("",array);
  }

// 아래는 테스트로 출력해 보기 위한 코드입니다.
  public static void main(String[] args) {
    ReverseStr rs = new ReverseStr();
    System.out.println( rs.reverseStr("Zbcdefg") );
  }
```

```java
1. Collections.sort(temp, Collections.reverseOrder());
2. 스트링 배열을 스트링으로: String.join("", array);
3. Collections.reverse(Arrays.asList(array));
```

## String형 뒤집기
```java
 public static String reverseString(String s){
        return (new StringBuffer(s)).reverse().toString();
    }
```





<hr/>




# 나누어 떨어지는 숫자 배열
```java
divisible 메소드는 int형 배열 array와 int divisor를 매개변수로 받습니다. 
array의 각 element 중 divisor로 나누어 떨어지는 값만 포함하는 새로운 배열을 만들어서 반환하도록 divisible에 코드를 작성해 보세요.
예를들어 array가 {5, 9, 7, 10}이고 divisor가 5이면 {5, 10}을 리턴해야 합니다.
```

```java
import java.util.Arrays;
import java.util.ArrayList;

class Divisible {
    public int[] divisible(int[] array, int divisor) {
      ArrayList<Integer> divArray = new ArrayList<Integer>();
      for(int i : array){
          if(i % divisor == 0){
          divArray.add(i);
        }
      }

      int[] ret = new int[divArray.size()];
      for(int i=0; i<ret.length; i++){
        ret[i] = divArray.get(i).intValue();      
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

```java
1. ArrayList 값 가져오기 divArray.get(i).intValue();
```




<hr/>




# 가운데 글자 가져오기
```java
getMiddle메소드는 하나의 단어를 입력 받습니다.
단어를 입력 받아서 가운데 글자를 반환하도록 getMiddle메소드를 만들어 보세요. 단어의 길이가 짝수일경우 가운데 두글자를 반환하면 됩니다.
예를들어 입력받은 단어가 power이라면 w를 반환하면 되고, 입력받은 단어가 test라면 es를 반환하면 됩니다.

```java
class StringExercise{
    String getMiddle(String word){
      int length = word.length();
      int index = length / 2;
      return (length%2==0) ? word.substring(index-1, index+1) : word.substring(index, index+1);
    }
    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void  main(String[] args){
      StringExercise se = new StringExercise();
      System.out.println(se.getMiddle("power"));
  }
}
```
## 팁
```java
1. substring(앞, 뒤) 는 뒤에 있는 숫자의 위치를 포함하지 않는다.
```





<hr/>



# 최대값과 최소값
```java
getMinMaxString 메소드는 String형 변수 str을 매개변수로 입력받습니다. 
str에는 공백으로 구분된 숫자들이 저장되어 있습니다. 
str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 “(최소값) (최대값)”형태의 String을 반환하는 메소드를 완성하세요. 
예를들어 str이 “1 2 3 4”라면 “1 4”를 리턴하고, “-1 -2 -3 -4”라면 “-4 -1”을 리턴하면 됩니다.
```

```java
import java.util.Arrays;

public class GetMinMaxString2 {
	public String getMinMaxString(String str) {
		String[] array = str.split(" ");
		int[] arrayInt = new int[array.length];

		for (int i = 0; i < arrayInt.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]); // 배열의 각 요소를 정수로 변경
		}

		Arrays.sort(arrayInt); // 최소 O(N LogN)의 시간복잡도
		String result = arrayInt[0] + " " + arrayInt[arrayInt.length - 1];

		return result;

	}

	public static void main(String[] args) {
		String str = "1 2 3 4";
		GetMinMaxString2 minMax = new GetMinMaxString2();
		System.out.println("최소값과 최대값은?" + minMax.getMinMaxString(str));
	}
}
```

## 팁
```java
1. 문자열 + 숫자: 문자열
String result = arrayInt[0] + " " + arrayInt[arrayInt.length - 1];
```





<hr/>




# Longest Substring
```java
"abcabcbb" 의 부분 문자열은 "abc" 이며, 그 길이는 3이다.
"bbbbb" 의 부분 문자열은 "b" 이며, 그 길이는 1이다.
"pwwkew" 의 부분 문자열은 "wke" 이며, 그 길이는 3이다. "pwke” 는 부분문자열이 아니다.
```

```java
public int lengthOfLongestSubstring(String s) {
    int i = 0, j = 0, max = 0;
    Set<Character> set = new HashSet<>();
    
    while (j < s.length()) {
        if (!set.contains(s.charAt(j))) {
            set.add(s.charAt(j++));
            max = Math.max(max, set.size());
        } else {
            set.remove(s.charAt(i++));
        }
    }
    
    return max;
}
```
