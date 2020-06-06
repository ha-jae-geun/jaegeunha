# this
```java
this. 키워드입니다.

여기서 this.는 생성자 바깥의 인스턴스 변수인 name을 가리키는 것입니다.

 

근데 왜 this. 를 사용할까요?

this를 사용하는 이유는 인스턴스 변수와 생성자의 매개변수가 이름이 같을 때 사용합니다.

만약에 생성자와 this를 사용하지 않는다면?
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "홍길동";
        s.ban = 1;
        s.no = 1;
        s.kor = 100;
        s.eng = 60;
        s.math = 76;

        String str = s.info();
        System.out.println(str);
    }

    static class Student { // Student Class
        String name; // instance variable
        int ban;
        int no;
        int kor;
        int eng;
        int math;

        public String info() {
            return name + ban + no + kor + eng + math + (kor+eng+math) + ((int)((kor+eng+math)/3f*10+0.5f)/10f);
        }
    }
 

생성자를 제거한 상태입니다.

 

Student 클래스의 인스턴스 변수들을 main 메서드에서 일일이 인스턴스화 합니다.

이렇게 되면 코드도 길어지고, 중복도 심하고, 헷갈립니다.

 

그렇기 때문에 생성자와 this를 만들어서 인스턴스 변수와 매개변수(argument)를 연결해줍니다.
```
