import java.io.*;
import java.util.Scanner;

public class ClientProtocol {
    int protocolName;
    int size;
    String name;
    int roomSize;
    String roomName;
    int msgSize;
    String msgName;
    Scanner input = new Scanner(System.in);

//    public ClientProtocol(int protocolName, int size, String name) {
//        this.protocolName = protocolName;
//        this.size = size;
//        this.name = name;
//    }
//    public ClientProtocol(int protocolName, int roomSize, String roomName, int msgSize, String msgName) {
//        this.protocolName = protocolName;
//        this.roomSize = roomSize;
//        this.roomName = roomName;
//        this.msgSize = msgSize;
//        this.msgName = msgName;
//    }
    public void  deserialization() {
        switch (protocolName) {
            case 1:
                    FileInputStream nameFileinput= null;
                    ObjectInputStream nameObjectinput = null;
                    try {
                        nameFileinput = new FileInputStream("nameProtocol.ser");
                        nameObjectinput = new ObjectInputStream(nameFileinput);

                        // 스트림으로 부터 객체를 읽어온다
                        // 이때 리턴 값은 Object 이므로 형변환을 통해 필요한 객체로 캐스팅 해준다
                        ClientProtocol nameProtocol = (ClientProtocol)nameObjectinput.readObject();
                        System.out.println(nameProtocol.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally{
                        if(nameFileinput != null) try{nameFileinput.close();}catch(IOException e){e.printStackTrace();}
                        if(nameObjectinput != null) try{nameObjectinput.close();}catch(IOException e){e.printStackTrace();}
                    }
                break;
            case 2:
                    FileInputStream roomFileinput= null;
                    ObjectInputStream roomObjectinput = null;
                    try {
                        roomFileinput = new FileInputStream("roomProtocol.ser");
                        roomObjectinput = new ObjectInputStream(roomFileinput);

                        // 스트림으로 부터 객체를 읽어온다
                        // 이때 리턴 값은 Object 이므로 형변환을 통해 필요한 객체로 캐스팅 해준다
                        ClientProtocol roomProtocol = (ClientProtocol)roomObjectinput.readObject();
                        System.out.println(roomProtocol.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally{
                        if(roomFileinput != null) try{roomFileinput.close();}catch(IOException e){e.printStackTrace();}
                        if(roomObjectinput != null) try{roomObjectinput.close();}catch(IOException e){e.printStackTrace();}
                    }
                break;
            case 3:
                    FileInputStream exitFileinput= null;
                    ObjectInputStream exitObjectinput = null;
                    try {
                        exitFileinput = new FileInputStream("exitProtocol.ser");
                        exitObjectinput = new ObjectInputStream(exitFileinput);

                        // 스트림으로 부터 객체를 읽어온다
                        // 이때 리턴 값은 Object 이므로 형변환을 통해 필요한 객체로 캐스팅 해준다
                        ClientProtocol exitProtocol = (ClientProtocol)exitObjectinput.readObject();
                        System.out.println(exitProtocol.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally{
                        if(exitFileinput != null) try{exitFileinput.close();}catch(IOException e){e.printStackTrace();}
                        if(exitObjectinput != null) try{exitObjectinput.close();}catch(IOException e){e.printStackTrace();}
                    }
                break;
            case 4:
                    FileInputStream msgFileinput= null;
                    ObjectInputStream msgObjectinput = null;
                    try {
                        msgFileinput = new FileInputStream("msgProtocol.ser");
                        msgObjectinput = new ObjectInputStream(msgFileinput);

                        // 스트림으로 부터 객체를 읽어온다
                        // 이때 리턴 값은 Object 이므로 형변환을 통해 필요한 객체로 캐스팅 해준다
                        ClientProtocol msgProtocol = (ClientProtocol)msgObjectinput.readObject();
                        System.out.println(msgProtocol.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally{
                        if(msgFileinput != null) try{msgFileinput.close();}catch(IOException e){e.printStackTrace();}
                        if(msgObjectinput != null) try{msgObjectinput.close();}catch(IOException e){e.printStackTrace();}
                    }
                break;
            default:

        } // switch
    } // run
}