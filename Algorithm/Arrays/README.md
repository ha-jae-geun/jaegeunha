# [노마드 배열](https://youtu.be/NFETSCJON2M)
* C언어 같은 저수준의 언어에서는 인덱스 0은  배열이 첫 칸부터 몇번째 떨어졌는지 묻는 것부터 시작

## 배열 순서 뒤집기
```java
Collections.reverse(Arrays.asList(array));
```

## 스트링 배열을 스트링으로
```java
String.join("", array);
```

## 배열 동적 선언
```java
- public static void main(String[ ] args) {
- int[ ][ ] num = new int[3][ ];
- num[0] = new int[3];
- num[1] = new int[2];
- num[2] = new int[1];
```

## 동적 2차원 배열 값 반환
```java
- String[ ][ ] name = {{"홍길동", "전우치", "임꺽정"}, {"장길산", "일지매"}, {"조세형"}};
- // 배열의 주소값을 반복한다.
- for (String[ ] strings : name) {
- // 배열의 실제값을 반복한다.
- for (String string : strings) {
- System.out.println(string);
- }
- }
```


<hr/>
