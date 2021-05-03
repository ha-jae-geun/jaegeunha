# 구조체에 포인터변수
```java
참고로 구조체에 포인터변수가 있을경우 전송시 포인터변수 값을 복사해서 보내지지 않으므로 
(String 형태의 변수도 마찬가지) 하나의 구조체에 몰아서 전송하든가
아니면 따로 데이터를 복사해서 전송을 해야 할 것이다
```

```c
struct SEND_INFO{
    int Size_data; //4byte 
    char Name[50]; //50byte
};

struct SEND_INFO info

info.Size_data = sizeof(int)+strlen(nickname)+1;

scanf("%s",p_name);
strcpy(info.Name,p_name);

send(c_socket,(struct SEND_INFO*)&info,sizeof(int) +strlen(p_name),0) > 0 )
```
