# char
## String을 char 배열로 변환
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

# ID 중복
```java
package Hyundai;

import java.util.HashSet;

public class CreateID {
	static HashSet<String> hashSet = new HashSet<>();
	public static String solution(String[] registered_list, String new_id) {
		String answer = "";
		

		for (int i = 0; i < registered_list.length; i++) {
			hashSet.add(registered_list[i]);
		}

		if (!hashSet.contains(new_id))
			return new_id;
		else
			answer = makeId(new_id);

		return answer;
	}

	public static String makeId(String id) {
		String a = "";
		String num = "";
		int index = 0;
		for (int i = 0; i < id.length(); i++) {
			if (id.charAt(i) >= 'a' && id.charAt(i) < 'z') {
				a = a + id.charAt(i);
			} else
				num = num + id.charAt(i);
		}
		if (num == "") {
			int start = 1;
			
			while (true) {
				a = id + String.valueOf(start);
				if(!hashSet.contains(a))
					return a;
				start = start + 1;
			}
		}
		int num2 = Integer.parseInt(num);
		String c = "";
		while (true) {
			c = a + String.valueOf(num2);
			if(!hashSet.contains(c))
				return c;
			num2 = num2+ 1;
		}
	}

	public static void main(String[] args) {
		String[] registered_list = { "bird99", "bird98", "bird101", "gotoxy" };
		System.out.println(solution(registered_list, "bird98"));
	}
}

```
