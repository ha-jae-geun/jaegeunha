# Hashset
## replace
```java
        for (int i = 0; i < clothes.length; i++) {
            if (hm.containsKey(clothes[i][1]))
                hm.replace(clothes[i][1], hm.get(clothes[i][1])+1);
            else
                hm.put(clothes[i][1], 1);
        }
```

## key값 반복
```java
		for (String s : hashMap.keySet()) {
			for (String s2 : hashMap.keySet()) {
				if (!s.equals(s2) && hashMap.get(s) > hashMap.get(s2)) {
					hashMap2.replace(s, hashMap2.get(s), hashMap2.get(s)+1);
				}
			}
		}
```

## value 반복
* values라는 것이 있음
```java
        for(int value : map.values()){
            //이 문제의 공식은 (n+1)* (k+1) ... -1
            answer = answer * (value+1);
        }
```

## charat
```java
Set<Character> set = new HashSet<>();
if (!set.contains(s.charAt(j))) {
      set.add(s.charAt(j++));
```



<hr/>



# HashMap
```java
ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();


이렇게 하면 ArrayList안에 String(key), String(value) 쌍인 HashMap을 집어 넣을 수 있다
이제 HashMap을 두개 생성하고 데이터를 넣어보자.


HashMap<String, String> personMap1 = new HashMap<String, String>();
map.put("이름", "김경태");
map.put("나이", "28");
map.put("직업","게이머");

HashMap<String, String> personMap2 = new HashMap<String, String>();
map.put("이름", "이아영");
map.put("나이", "28");
map.put("직업","디자이너");

//이렇게 두개의 HashMap객체를 먼저 만들어 놓았던 ArrayList에 넣어보자.

list.add(personMap1);
list.add(personMap2);

이렇게 하면 ArrayList의 객체 list에 두개의 HashMap이 들어가 있게 된다.
이제 빼서 사용해보자..

HashMap<String, String> takeMap1 = (HashMap<String,String>)list.get(0);
String name1 = takeMap1.get("이름");
String age1 = takeMap1.get("나이");
String job1 = takeMap1.get("직업"); 


```




<hr/>

