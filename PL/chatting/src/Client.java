import java.io.*;
import java.util.Scanner;

public class Client{
    int protocolName;
    int size;
    String name;
    int roomSize;
    String roomName;
    int msgSize;
    String msgName;
    transient Scanner input = new Scanner(System.in);


    public Client(int protocolName) {
        this.protocolName = protocolName;
    }
    public Client(int protocolName, int size, String name) {
        this.protocolName = protocolName;
        this.size = size;
        this.name = name;
    }
    public Client(int protocolName, int roomSize, String roomName, int msgSize, String msgName) {
        this.protocolName = protocolName;
        this.roomSize = roomSize;
        this.roomName = roomName;
        this.msgSize = msgSize;
        this.msgName = msgName;
    }

    public void  serialization() {
        switch (protocolName) {
            case 1:
                System.out.println("유저 이름을 입력하세요.");
                name = input.nextLine();
                size = name.length();

                ClientProtocol nameProtocol = new ClientProtocol(protocolName, size, name);
                FileOutputStream nameFileout = null;
                ObjectOutputStream nameObjectout = null;
                try{
                    nameFileout = new FileOutputStream("nameProtocol.ser");
                    nameObjectout = new ObjectOutputStream(nameFileout);
                    nameObjectout.writeObject(nameProtocol);
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    if(nameFileout != null) try{nameFileout.close();}catch(IOException e){e.printStackTrace();}
                    if(nameFileout != null) try{nameFileout.close();}catch(IOException e){e.printStackTrace();}
                }
                break;
            case 2:
                System.out.println("만들 방의 이름을 입력하세요.");
                name = input.nextLine();
                size = name.length();

                ClientProtocol roomProtocol = new ClientProtocol(protocolName, size, name);
                FileOutputStream roomFileout = null;
                ObjectOutputStream roomObjectout = null;
                try{
                    roomFileout = new FileOutputStream("roomProtocol.ser");
                    roomObjectout = new ObjectOutputStream(roomFileout);
                    roomObjectout.writeObject(roomProtocol);
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    if(roomFileout != null) try{roomFileout.close();}catch(IOException e){e.printStackTrace();}
                    if(roomFileout != null) try{roomFileout.close();}catch(IOException e){e.printStackTrace();}
                }
                break;
            case 3:
                System.out.println("나갈 방의 이름을 입력하세요.");
                name = input.nextLine();
                size = name.length();

                ClientProtocol exitProtocol = new ClientProtocol(protocolName, size, name);
                FileOutputStream exitFileout = null;
                ObjectOutputStream exitObjectout = null;
                try{
                    exitFileout = new FileOutputStream("exitProtocol.ser");
                    exitObjectout = new ObjectOutputStream(exitFileout);
                    exitObjectout.writeObject(exitProtocol);
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    if(exitFileout != null) try{exitFileout.close();}catch(IOException e){e.printStackTrace();}
                    if(exitFileout != null) try{exitFileout.close();}catch(IOException e){e.printStackTrace();}
                }
                break;
            case 4:
                System.out.println("방 이름을 입력하세요.");
                roomName = input.nextLine();
                roomSize = roomName.length();
                System.out.println("메세지를 입력하세요.");
                msgName = input.nextLine();
                msgSize = msgName.length();

                ClientProtocol msgProtocol = new ClientProtocol(protocolName, roomSize, roomName, msgSize, msgName);
                FileOutputStream msgFileout = null;
                ObjectOutputStream msgObjectout = null;
                try{
                    msgFileout = new FileOutputStream("msgProtocol.ser");
                    msgObjectout = new ObjectOutputStream(msgFileout);
                    msgObjectout.writeObject(msgProtocol);
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    if(msgFileout != null) try{msgFileout.close();}catch(IOException e){e.printStackTrace();}
                    if(msgFileout != null) try{msgFileout.close();}catch(IOException e){e.printStackTrace();}
                }
                break;
            default:

        } // switch
    } // run
}