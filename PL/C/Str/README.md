# str 관련 함수
```java

[strcpy()]

문자열 복사하는 함수
strcpy(char *dst, const char *src)
dst(destination), src(source)
src 문자열의 길이를 체크하지 않으므로 dst 버퍼를 초과하는 오버플로우가 발생할 수 있음
버퍼플로우 공격 : 공격자가 명령을 수행하기 위한 실행 바이너리 코드로서 악의적인 코드를 만들어 
이를 다양한 방법으로 메모리에 업로드 시킨 후 버퍼 오버플로우에 취약한 프로그램을 이용해 수행


[strncpy()]
strncpy(char *dst, const char *src, stze_t num)
문자열을 일정 길이만큼 복사하는 함수
num(복사할 문자열의 길이)
문자열의 길이가 제한되므로 버퍼 오버플로우에 있어서 안전
버퍼의 크기와 동일한 입력 문자열의 경우 문자열의 끝을 의미하는 null가 포함될 수 있기 때문에 버퍼의 크기와 문자열의 크기 체크 필요


[strcat]
strcat(char dst, const char origin)
origin에 있는 문자열을 dst 뒤쪽에 이어 붙이는 함수
dst 문자열 끝에 있는 '\0' 이것은 사라지고 그 위치에 origin이 바로 붙어버리는게 특징
[strncat]

strncat(char dst, const char* origin, size_t n)
origin에 있는 문자열 n개를 문자열 dst 뒤쪽에 이어 붙이는 함수
dst 문자열 끝을 가리키는 '\0' 기호를 없애고 origin의 문자 n번째까지 붙여버리는 함수
```
