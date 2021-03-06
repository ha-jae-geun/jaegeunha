# 커서 이동
```java
k	커서를 위로 움직임
j	커서를 아래로 움직임
h	커서를 왼쪽으로 움직임
l	커서를 오른쪽으로 움직임
-	커서를 줄의 처음으로 옮김
e, E	다음단어의 끝으로, 문자단위 이동
w, W	다음단어의 처음으로, 문자단위 이동
$	줄의 마지막으로
0	줄의 처음으로
^	줄의 처음으로(공백이 아닌 처음시작되는 문자)
Shift+g	문서의 마지막으로 이동한다.
gg, 1g	문서의 처음으로 이동한다. 1대신 다른 숫자를 입력하면 해당 숫자의 라인으로 이동한다.
), (	다음, 이전 문장의 처음으로
}, {	다음, 이전문단의 처음으로
]], [[	다음, 이전 구절의 처음으로
```

# 마크 이동
```java
일종의 책갈피 기능이라고 보면 된다. 
자주 참조해야할 라인에 마크를 해놓고 필요할때 곧바로 마크된 영역으로 이동하기 위해서 사용한다. 
마크는 mx 형식으로 사용할수 있다. x 는 (a~z)까지의 문자로 마크된 영역의 이름을 지정하기 위해서 사용한다. 
마크된 영역으로 이동하기 위해서는 'x 와 `x 를 사용한다. 
'x 는 마크된 라인의 가장 앞으로 이동하고, `x 는 마크된 라인의 정확한 위치로 이동한다.
```

## 위치 마크하기
```java
위치 마크(mark)하기
일종의 북마크기능으로 자주참조할만한 라인을 마킹해두고 필요할때 간단히 해당 마킹지역으로 이동하기 위해서 사용한다. 
마킹을 위해서는 명령모드에서 m키를 눌러서 마킹모드로 들어가면 된다. 그리고 영문 [a-zA-Z]키중 아무거나 눌러주면 된다. 
만약 a를 눌러주었다면, 현재라인은 a이름으로 마킹된다. 이후 작업을하다가 a마킹라인으로 가고 싶다면 'a 해주면된다. 
이 상태에서 원래 라인으로 되돌아가고 싶다면 ''를 눌려주면 된다.

물론 다중마킹도 허용한다. 마킹할수 있는 문자는 단일영문자이다. 마킹에 사용되는 영문자는 대소문자를 구분함으로 최대마킹가능한 수는 27*2가 될것이다.
```


# 화면 스크롤
```java
^F	한 화면 을 앞으로 스크롤
^B	한 화면 을 뒤로 스크롤
^D	반 화면 을 앞으로 스크롤
^U	반 화면 을 뒤로 스크롤
^E	한줄 앞으로 스크롤
^Y	한줄 뒤로 스크롤
Shift + h	화면의 맨 윗줄로
Shift + m	화면의 중간줄로
Shift + l	화면의 맨 아랫줄로

```

# 입력 명령
```java
i	현재위치에서 삽입
I	현재줄의 처음위치에서 삽입
a	현재위치에서 한칸앞으로 이동해서 삽입
A	현재줄의 마지막위치에서 삽입
o	새로운 줄을 커서 아래에 연다
O	새로운 줄을 커서 위연다
s	현재 위치의 문자를 지우고 입력모드로 들어간다.
S	현재위치의 라인을 지우고 입력모드로 들어간다.

```

# 편집 명령
```java
y	한줄 복사
yn	현재 라인에서부터 n라인만큼을 복사
p	복사된 내용 붙이기
dd	한줄삭제
dw	한단어 삭제
Shift+d, d$	현재커서 위치에서 마지막까지 삭제
Shift+j	현재 행의 개행문자를 제거한다. 즉 아래라인을 현재라인에 덧붙인다.

```

# 되돌리기
```java
. Undo (되돌리기)
vim 은 다중의 undo 기능을 지원한다. 뒤로 되돌리고 싶다면 단지 'u'키만 입력하면 된다.
```

# 블럭지정
```java
이번엔 블럭지정, 그중에서도 vim 에서 지원하는 visual 블럭 지정에 대해서 알아보겠다. 
vim visual 블럭 지정 기능을 사용할경우 지정범위가 반전되면서 눈에 보이기 때문에, 효과적인 블럭지정이 가능하도록 도와준다. 
범위지정을 위해서 'hjkl', 'Shift+g,GG' 과 같은 이동명령 과 화면스크롤 명령을 사용해서 범위지정을 좀더 빠르게 할수 있다.

표 6. 블럭지정

v	단어단위로 블럭지정이 가능하다. 블럭범위는 이동명령인 'hjkl' 로 원하는 범위 만큼 지정할수 있다.
Shift+v	라인단위 블럭지정이다. 라인전체가 선택되며, 위아래 이동명령 'hj' 으로 범위 지정이 가능하다.
Ctrl+v	블럭단위 블럭지정이다. 4각형의 블럭지정이 가능하며 이동명령인 'hjkl' 로 원하는 범위를 지정할수 있다.
Shift+v 와 같이 블럭지정을 한후 Shift+G 를 입력하면 현재라인부터 마지막 라인까지가 블럭 지정이 될것이다.
```

# 편집 모드
```java
2.2.5.4. 편집(visual block 모드)
일단 vim 의 visual 블럭 지정 기능을 이용해서 편집하기 원하는 블럭을 지정했다면, 
각종 편집명령을 이용해서 복사, 붙이기, 삭제 작업이 가능하다. 블럭을 지정한 상태에서 아래의 명령을 이용해서 편집을 하면 된다. 
명령어는 기본적으로 none visual block 모드의 편집 명령어과 같다.

표 7. 편집(복사, 삭제, 붙이기)

y	지정된 블럭을 복사한다.
p	복사된 블럭을 현재라인(커서) 아래에 붙인다.
d	지정된 블럭을 삭제한다.
dd	현재라인을 삭제한다.
```

# 치환
```java
먼저 찾기 기능에 대해서 알아보겠다. 찾기기능은 ':/패턴/' 를 이용 하면된다. 찾기 원하는 문자혹은 패턴을 입력하고 엔터키를 누르면 현재 커서위치에서 가장 가까운 곳에 위치한 문자열로 커서를 이동시킨다(문서 아래방향으로). 다음 문자열을 찾기를 원한다면 'n'키를 누르면 된다. 문서에서 가장 마지막에 이르르게 되면, 문서의 가장처음부터 다시 찾기 시작한다. 'Shift+n' 을 이력하면 반대 방향(문서의 위쪽으로)으로 찾기를 시작한다.

치환이야 말로 vim 의 꽃이라고 할수 있다. :[범위]s/[oldpattern]/[newpattern]/ 의 형식으로 사용하면 된다. 범위 지정은 visual block 을 이용할수도 있으며, 직접 범위를 입력할수도 있다. visual block 를 이용한 치환은 visual block 를 지정한다음 ':' 를 입력해서 ex 모드로 넘어가면 된다. 그리고나서 ':'<,'>s/[oldpattern]/[newpattern/' 과 같은 방법으로 치환하면 된다.

visual block 를 사용하지 않고 직접범위를 입력할수도 있다. :[시작],[마지막]s/[old]/[new]/ 식으로 범위를 지정하면 된다. 여기에는 몇가지 지정된 범위를 위한 특수 기호들이 있다. '%' 는 전체문서(처음부터 끝까지), '.' 은 현재, '$' 은 마지막 을 나타낸다. 숫자를 입력할경우 숫자는 라인을 나타낸다. 다음은 간단한 사용예이다.

# 문서 처음부터 마지막까지의 char 를 _char_ 로 치환한다. 
:%s/char/_&_/g

# 현재(커서위치)부터 마지막까지의 char 를 _char_ 로 치환한다.
:.,$s/char/_&_/g

# buf_.*[255], buf_in[255], buf_get[255] 와 같은 문자열을 hello 로 변경한다.  
:1,10s/buf_.*\[255\]/hello/g
```

# 파일 저장, 열기, 종료
```java
2.3.2. 파일 저장, 열기, 종료
파일열기의 경우 vi 를 실행시킬대 명령행 옵션으로 열기가 가능하다. 
또한 vi 를 이미 실행 시킨후에도 명령모드에서 명령을 입력함으로 파일을 열수 있다. 
열고자 하는 파일이 이미 존재할경우에는 존재하는 파일이 열리고, 열고자 하는 파일이 존재하지 않을경우 새로운 파일이 만들어진다.

표 8. 저장,열기,종료

:e [filename]	filename 으로 파일열기
:q, :q!, :wq	종료, 강제종료, 저장후 종료
:w, :w [filename]	현재파일명으로 저장, filename 로 저장
:<범위>w [filename]	지정한 범위만 다른 파일로 저장
:e [filename]	filename 을 편집하기 위해서 연다
ZZ	지금파일을 저장하고 vim 을 종료한다.
:f	현재 작업중인 파일의 이름과, 라인수를 출력한다

```
