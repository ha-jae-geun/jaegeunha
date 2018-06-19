import java.io.DataOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class RoomManager{

    static String msgName;
    static Socket socket;
    HashMap<Socket, String> roomNumber = new HashMap<Socket, String>();

    public RoomManager(){}

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

        Iterator<Socket> keys = roomNumber.keySet().iterator();
        try {
            while ( keys.hasNext() ) {
                Socket key = keys.next();
                if (roomName.equals(roomNumber.get(key)) && key.equals(socket)) {
                    roomState = 0;
                }
                else if(!roomName.equals(roomNumber.get(key))){
                    roomState = 0;
                }
                else if(roomName.equals(roomNumber.get(key)) && !key.equals(socket)){
                    roomState = 1;
                    break;
                }
            }
        } //try문
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
