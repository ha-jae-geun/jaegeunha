# 클라이언트
* "1. 이름 생성 2. 방생성 3. 나가기 4. 채팅. 5. 방 목록")

# 룸 매니저
```java
class RoomList{
    Socket socket;
    String roomName;

    public RoomList(Socket socket, String roomName){
        this.socket = socket;
        this.roomName = roomName;
    }
    public Socket getSocket(){
        return socket;
    }

    public String getRoomName(){
        return roomName;
    }
}

public class RoomManager{
    static Hashtable<Integer, RoomList> roomHash = new Hashtable<Integer, RoomList>();
    static HashMap<Socket, String> nameHash = new HashMap<Socket, String>();
    static Socket socket;
    static ArrayList<RoomList> roomList = new ArrayList<RoomList>();
    static int countHash = 0;

    static
    {
        roomList.add(new RoomList(null, "방이름을 입력하세요"));
        roomHash.put(0, new RoomList(null, null));
    }

```
