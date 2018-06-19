import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RoomManager{

    static int protocolName;
    static int size;
    static String name;
    static int roomSize;
    static String roomName;
    static int msgSize;
    static String msgName;
    static Socket socket;
    DataInputStream in;

    HashMap<Socket, String> roomNumber = new HashMap<Socket, String>();

    public RoomManager(){}

    public  RoomManager(Socket socket, HashMap<Socket, String> roomNumber){
        this.socket = socket;
        this.roomNumber = roomNumber;
    }

    void sendToAll(HashMap<Socket, String> roomNumber, Socket socket, String msg) {
        DataOutputStream out;
        try {
            for (Socket key : roomNumber.keySet()) {
                if (roomNumber.get(socket) == roomNumber.get(key))
                {
                    out = new DataOutputStream(key.getOutputStream());
                    out.writeUTF(msg);
                }
            }
        }
        catch (Exception e) {
        }
    }//sent

    boolean createName(HashMap<Socket, String> roomNumber, String roomName, Socket socket){
        boolean trueFalse = false;
            try {
                trueFalse = true;
            }
            catch(NullPointerException e){
                trueFalse = false;
            }
        return trueFalse;
    }

    int createRoom(HashMap<Socket, String> roomNumber, String roomName, Socket socket){
            int roomState = -1;
        try {
            for (Socket key : roomNumber.keySet()) {
                if (roomName != roomNumber.get(key) && key == socket) {
                    roomState = 0;
                }
                else if(roomName != roomNumber.get(key)){
                    roomState = 0;
                }
                else if(roomName == roomNumber.get(key) && key != socket){
                    roomState = 1;
                    break;
                }
            }
        }
        catch(NullPointerException e){
            roomState = 2;
        }
        return roomState;
    }

    boolean exitRoom(HashMap<Socket, String> roomNumber, String roomName, Socket socket){
        boolean trueFalse = false;
           if(roomNumber.containsKey(socket)){
               trueFalse = false;
            }
            else{
               trueFalse = true;
           }
           System.out.println("방 나가는 것을 실패했습니다.");
           return trueFalse;
    }

    boolean sendMessage(HashMap<Socket, String> roomNumber, String roomName, Socket socket){
        boolean trueFalse = false;
        ServerProtocol sp = new ServerProtocol();
            try {
                trueFalse = true;
                sendToAll(roomNumber, socket, msgName);
            }
            catch(NullPointerException e){
                trueFalse = false;
            }
        return trueFalse;
    }
} // public class
