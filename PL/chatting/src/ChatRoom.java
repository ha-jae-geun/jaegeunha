import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ChatRoom extends Thread{
    Map<Socket, String> roomNumber = Collections.synchronizedMap(new HashMap<Socket, String>());
    String name;
    Socket socket;

    public ChatRoom(Map<Socket, String> roomNumber, String name, Socket socket){
        this.roomNumber = roomNumber;
        this.name = name;
        this.socket = socket;
    }

    public void run(){

    }
}
