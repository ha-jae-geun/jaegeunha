import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RoomManager extends Thread{

    static int protocolName;
    static int size;
    static String name;
    static int roomSize;
    static String roomName;
    static int msgSize;
    static String msgName;
    static Socket socket;
    DataInputStream in;

    Map<Socket, String> roomNumber = Collections.synchronizedMap(new HashMap<Socket, String>());

    public RoomManager(){}

    public RoomManager(Socket socket, int protocolName, String name, String roomName, String msgName){
        this.protocolName = protocolName;
        this.roomName = roomName;
        this.msgName = msgName;
    }

    void sendToAll(Map<Socket, String> roomNumber, Socket socket, String msg) {
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
            TcpIpMultiChattingServer trueFalse = new TcpIpMultiChattingServer(false);
        }
    }//sent

    public void run(){
        try {
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (protocolName == 2) {
            try {
                for (Socket key : roomNumber.keySet()) {
                    if (roomName != roomNumber.get(key)) {
                        roomNumber.put(socket, roomName);
                        TcpIpMultiChattingServer roomStates = new TcpIpMultiChattingServer(0);
                    } else if (roomName == roomNumber.get(key)) {
                        TcpIpMultiChattingServer roomStates = new TcpIpMultiChattingServer(1);
                    }
                }
            }
            catch(NullPointerException e){
                TcpIpMultiChattingServer roomStates = new TcpIpMultiChattingServer(2);
            }
        }
        else if(protocolName == 3){
            try{
                roomNumber.remove(socket, roomName);
                TcpIpMultiChattingServer trueFalse = new TcpIpMultiChattingServer(true);
            }
            catch(NullPointerException e){
                System.out.println("방 나가는 것을 실패했습니다.");
                TcpIpMultiChattingServer trueFalse = new TcpIpMultiChattingServer(false);
            }
        }
        else if(protocolName == 4){
                while (in != null) {
                    TcpIpMultiChattingServer trueFalse = new TcpIpMultiChattingServer(true);
                    sendToAll(roomNumber, socket, msgName);
                }
        }
    } // run
} // public class
