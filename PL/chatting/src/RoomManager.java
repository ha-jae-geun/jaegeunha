import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class RoomManager{
    static HashMap<Socket, String> roomHash = new HashMap<Socket, String>();
    static HashMap<Socket, String> nameHash = new HashMap<Socket, String>();
    static Socket socket;

    static
    {
        roomHash = new HashMap<Socket, String>();
        roomHash.put(null, "접속 할 수 있는 방 목록");
    }

    public RoomManager(Socket socket){
        this.socket = socket;
    }

    public HashMap<Socket, String> getRoomHash(){
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

    void setName(Socket socket, String name) {
        nameHash.put(socket, name);
    }

    String getName(Socket sockets){
        return nameHash.get(sockets);
    }

    boolean createName(String name){
        boolean isValid = false;

        if(nameHash.containsValue(name)){
            isValid = true;
        }
        else{
            isValid = false;
        }
        return isValid;
    }//createname

    int createRoom(String roomName, Socket socket){
        int roomState = -1;
        try {
            roomHash.put(socket, roomName);
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

    boolean exitRoom(Socket socket){
        boolean isValid = false;
        roomHash.remove(socket);

        if(roomHash.containsKey(socket)){
            isValid = false;
        }
        else{
            isValid = true;
        }
        return isValid;
    } //exitroom

    boolean sendMessage(String roomName, Socket socket, String msg){
        boolean isValid = false;
        try {
            if(!roomName.equals(roomHash.get(socket)))
                isValid = false;
            else {
                isValid = true;
                sendToAll(roomHash, socket, msg);
            }
        }
        catch(NullPointerException e){
            isValid = false;
        }
        return isValid;
    } // sendMessage

    void roomList(DataOutputStream out){
        try {
            HashMap<Socket, String> listHash = new HashMap<Socket, String>();
            int roomSize = roomHash.size();

            listHash.put(null, null);
            for(Socket key : roomHash.keySet()) {
                int count = 0;
                listHash.put(key, roomHash.get(key));
                for(Socket keys : listHash.keySet()) {
                    if(roomHash.get(key).equals(listHash.get(keys))){
                        count = count + 1;
                    }
                    if(roomHash.get(key).equals(listHash.get(key)) && count == 2){
                        listHash.remove(keys);
                    }
                }
            }
            listHash.remove(null);
            out.writeInt(listHash.size());
            for(Socket key : listHash.keySet()) {
                String value = listHash.get(key);
                System.out.println(key + " : " + value);
                out.writeUTF(" 방 목록: " + value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
} // RoomManager
