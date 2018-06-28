import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

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

//    public RoomManager(Socket socket){
//        this.socket = socket;
//    }
    public RoomManager(){
    }

    public Hashtable<Integer, RoomList> getRoomHash(){
        return roomHash;
    }
    public ArrayList<RoomList> getRoomlist(){
        return roomList;
    }

    boolean sendToAll(String roomName, Socket socket, String msg) {
        DataOutputStream out;
        try {
            for(int i=1; i<roomList.size(); i++){
                if(roomName.equals(roomList.get(i).getRoomName()) && (socket != roomList.get(i).getSocket())){
                    out = new DataOutputStream(roomList.get(i).getSocket().getOutputStream());
                    out.writeUTF(msg);
                    return true;
                }
            }
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

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

    int createRoom(String roomName, Socket socket) {
        int roomState = 1;
        int countList = 0;
        try {
            roomList.add(new RoomList(socket, roomName));
            for (int i = 1; i < roomList.size(); i++) {
                if ((roomList.get(i).getSocket().equals(socket)) && (roomList.get(i).getRoomName().equals(roomName)))
                    countList = i;
                break;
            }
            Enumeration keys = roomHash.keys();
            int key = 0;
            while (keys.hasMoreElements()) {
                if(roomHash.size() == 1){
                    countHash = countHash + 1;
                    roomHash.put(countHash, roomList.get(countList));
                    roomState = 0;
                    break;
                }
                if(key != 0 && !roomHash.get(key).getRoomName().equals(roomName)){
                    countHash = countHash + 1;
                    roomHash.put(countHash, roomList.get(countList));
                    roomState = 0;
                    break;
                }
                key = (int) keys.nextElement();
            }
        } //try문
        catch(NullPointerException e){
            roomState = 2;
        }
        return roomState;
    }

    boolean exitRoom(String roomName, Socket socket){
        int countList = 0;
        for (int i = 1; i < roomList.size(); i++) {
            if ((roomList.get(i).getSocket().equals(socket)) && (roomList.get(i).getRoomName().equals(roomName))) {
                countList = i;
                break;
            }
        }
        roomList.remove(countList);
        removeRoom(roomName, socket);
        for (int i = 1; i < roomList.size(); i++) {
            if (roomList.get(i).getRoomName().equals(roomName))
            return true;
        }
        return false;
    }

    void removeRoom(String roomName, Socket socket){
        boolean isValid = false;
        for (int i = 0; i < roomList.size(); i++) {
            if ((roomList.get(i).getRoomName().equals(roomName))){
                isValid = true;
                break;
            }
        }
        if(!isValid){
            Enumeration keys = roomHash.keys();
            int key = 0;
            while (keys.hasMoreElements()) {
                if(key != 0 &&roomHash.get(key).getRoomName().equals(roomName)){
                    roomHash.remove(key);
                }
                key = (int) keys.nextElement();
            }
        }
    }

    boolean sendMessage(String roomName, Socket socket, String msg) {
        if(!sendToAll(roomName, socket, msg)){
            return false;
        }
        return true;
    }

    void roomList(DataOutputStream out){
        try {
            out.writeInt(roomHash.size()-1);
            Enumeration<RoomList> enumerationValue = roomHash.elements();
            while (enumerationValue.hasMoreElements()) {
                RoomList roomList = (RoomList) enumerationValue.nextElement();
                if(roomList.getRoomName() !=null) {
                    out.writeUTF(roomList.getRoomName());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
} // RoomManager
