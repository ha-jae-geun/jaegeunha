import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class RoomManager{
    static HashMap<Socket, String> roomHash = new HashMap<Socket, String>();
    static Socket socket;

    public RoomManager(Socket socket, HashMap<Socket, String> roomHash){
        this.socket = socket;
        this.roomHash = roomHash;
    }

    public void setHash(HashMap<Socket, String> roomHash){
        this.roomHash = roomHash;
    }

    public HashMap<Socket, String> getHash(){
        return roomHash;
    }

    void sendToAll(HashMap<Socket, String> roomHash, Socket socket, String msg) {
        DataOutputStream out;
        try {
            for (Socket key : roomHash.keySet()) {
                if (roomHash.get(socket) == roomHash.get(key))
                {
                    out = new DataOutputStream(key.getOutputStream());
                    out.writeUTF(msg);
                }
            }
        }
        catch (Exception e) {
        }
    }//sent

    boolean createName(HashMap<Socket, String> roomHash, String roomName, Socket socket){
        boolean trueFalse = false;
        try {
            trueFalse = true;
        }
        catch(NullPointerException e){
            trueFalse = false;
        }
        return trueFalse;
    }//createname

    int createRoom(HashMap<Socket, String> roomHash, String roomName, Socket socket){
        int roomState = -1;
        try {
            Iterator<Socket> keys = roomHash.keySet().iterator();
            while ( keys.hasNext() ) {
                Socket key = keys.next();
                if(roomName.equals(roomHash.get(key)) && !key.equals(socket)){
                    roomState = 1;
                    break;
                }
                roomState = 0;
            }
        } //try문
        catch(NullPointerException e){
            roomState = 2;
        }
        return roomState;
    }  //createroom

    boolean exitRoom(HashMap<Socket, String> roomHash, String roomName, Socket socket){
        boolean trueFalse = false;

        if(roomHash.containsKey(socket)){
            trueFalse = false;
        }
        else{
            trueFalse = true;
        }
        return trueFalse;
    } //exitroom

    boolean sendMessage(HashMap<Socket, String> roomHash, String roomName, Socket socket, String msg){
        boolean trueFalse = false;
        try {
            trueFalse = true;
            sendToAll(roomHash, socket, msg);
        }
        catch(NullPointerException e){
            trueFalse = false;
        }
        return trueFalse;
    } // sendMessage

    public static void main(String[] args) {
    }
} // public class
