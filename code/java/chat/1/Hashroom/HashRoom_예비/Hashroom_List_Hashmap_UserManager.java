import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class UserManager {
    static HashMap<String, Socket> userHash = new HashMap<String, Socket>();
    static Socket socket;

    public UserManager(Socket socket){
        this.socket = socket;
    }

    boolean createRoom(String roomName, Socket socket){
        boolean isValid = false;
        try {
            if(userHash.containsKey(roomName))
                isValid = false;
            else {
                userHash.put(roomName, socket);
                isValid = true;
            }
        } //try문
        catch(NullPointerException e){
            isValid = false;
        }
        return isValid;
    }  //createroom

    boolean exitRoom(String roomName, Socket socket){
        boolean isValid = false;

        if(userHash.containsKey(roomName)){
            isValid = true;
            userHash.remove(roomName);
        }
        else{
            isValid = false;
        }
        return isValid;
    } //exitroom

    boolean sendMessage(String roomName, Socket socket){
        boolean isValid = false;
        try {
            if(userHash.containsKey(roomName))
                isValid = true;
            else
                isValid = false;
        }
        catch(NullPointerException e){
            isValid = false;
        }
        return isValid;
    } // sendMessage
}//UserManager