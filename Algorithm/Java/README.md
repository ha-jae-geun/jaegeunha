# 자바


## 배열 동적 선언
- public static void main(String[ ] args) {
- int[ ][ ] num = new int[3][ ];
- num[0] = new int[3];
- num[1] = new int[2];
- num[2] = new int[1];


## 동적 2차원 배열 값 반환
- String[ ][ ] name = {{"홍길동", "전우치", "임꺽정"}, {"장길산", "일지매"}, {"조세형"}};
- // 배열의 주소값을 반복한다.
- for (String[ ] strings : name) {
- // 배열의 실제값을 반복한다.
- for (String string : strings) {
- System.out.println(string);
- }
- }


## BufferedReader로 입력 받기
- InputStreamReader inputStreamReader = new InputStreamReader(System.in);
- BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
- int[ ] num = new int[3];
- int tot = 0;
- int ave;
- System.out.println("점수를 입력하세요.");
- for (int i = 0; i < num.length; i++) {
- System.out.print((i + 1) + "번째 점수: ");
- num[i] = Integer.parseInt(bufferedReader.readLine( ));
- // 배열의 크기만큼 총점을 누적한다.
- tot = tot + num[i];
- }


