import java.io.*;
import java.net.Socket;

public class ClientProtocol{

    public ClientProtocol(){ }

    public byte[] intToByteArray(int value) {
        byte[] byteArray = new byte[4];
        byteArray[0] = (byte)(value >> 24);
        byteArray[1] = (byte)(value >> 16);
        byteArray[2] = (byte)(value >> 8);
        byteArray[3] = (byte)(value);
        return byteArray;
    }

    public byte[] stringToByteArray(String name) {
        byte[] byteArr = new byte[0];
        try {
            byteArr = name.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return byteArr;
    }

    public int byteArrayToInt(byte bytes[]) {
        return ((((int)bytes[0] & 0xff) << 24) |
                (((int)bytes[1] & 0xff) << 16) |
                (((int)bytes[2] & 0xff) << 8) |
                (((int)bytes[3] & 0xff)));
    }

    public boolean byteArrayToBoolean(byte bytes[]){
//        return bytes[0] > 0 ? true : false;
//        return bytes[0]!= (byte) 0;
          return bytes[0]!=0;
    }

    public byte[] transferChat(String userName, String chat) {
        byte[] nameBuffer = null;
        byte[] usernameValue = stringToByteArray(userName);
        byte[] chatValue = stringToByteArray(chat);

        nameBuffer = new byte[ userName.length() + chat.length()];
        System.arraycopy(usernameValue, 0, nameBuffer, 0, userName.length());
        System.arraycopy(chatValue, 0, nameBuffer, userName.length(), chat.length());
        System.out.println("transfer client 바이트 값" + nameBuffer);

        return nameBuffer;
    }

    public byte[] transferClient(int protocolName, int size, String name) {
        byte[] nameBuffer = null;
        byte[] protocolValue = intToByteArray(protocolName);
        byte[] sizeValue = intToByteArray(size);
        byte[] nameValue = stringToByteArray(name);

        nameBuffer = new byte[8 + name.length()];
        System.arraycopy(protocolValue, 0, nameBuffer, 0, 4);
        System.arraycopy(sizeValue, 0, nameBuffer, 4, 4);
        System.arraycopy(nameValue, 0, nameBuffer, 8, name.length());
        System.out.println("transfer client 바이트 값" + nameBuffer);


//        else if(protocolName == 2) {
//            byte[] roomValue = stringToByteArray(name);
//            System.out.println("namer값 " + name);
//            nameBuffer = new byte[name.length()];
//
//            System.arraycopy(roomValue, 0, nameBuffer, 0, name.length());
//            System.out.println("transfer client 바이트 값" + nameBuffer);
//        }
//        else if(protocolName == 3) {
//            byte[] roomValue = stringToByteArray(name);
//            nameBuffer = new byte[name.length()];
//
//            System.arraycopy(roomValue, 0, nameBuffer, 0, name.length());
//            System.out.println("transfer client 바이트 값" + nameBuffer);
//        }
//        else if(protocolName == 4) {
//            byte[] roomValue = stringToByteArray(name);
//            byte[] msgValue = stringToByteArray("test");
//
//            nameBuffer = new byte[name.length() + 4];
//
//            System.arraycopy(roomValue, 0, nameBuffer, 0, name.length());
//            System.arraycopy(msgValue, 0, nameBuffer, name.length(), 4);
//
//            System.out.println("transfer client 바이트 값" + nameBuffer);
//        }
        return nameBuffer;
    } // transfer
    public boolean  receiveClient(byte[] byteArr, int protocolInt) {
        boolean resultToBoolean = true;
        if(protocolInt == 1) {
            byte result[] = new byte[1];
            for (int i = 0; i < 1; i = i + 1)
                result[i] = byteArr[i];
            resultToBoolean = byteArrayToBoolean(result);

            if(resultToBoolean) {
                System.out.println("이름이 등록되었습니다.");
            }
            else{
                System.out.println("이름이 등록에 실패하였습니다.");
            }
            System.out.println("생성 상태  " + resultToBoolean);
        }
        else if(protocolInt == 2){
            byte result[] = new byte[4];
            for (int i = 0; i < 4; i = i + 1)
                result[i] = byteArr[i];
            int resultToInt = byteArrayToInt(result);


            if(resultToInt == 0) {
                System.out.println("방을 생성했습니다..");
            }
            else if(resultToInt == 1){
                System.out.println("이미 존재하는 방입니다. 방에 입장하였습니다.");
            }
            else{
                System.out.println("방 생성에 실패했습니다..");
            }
            System.out.println("생성 상태  " + resultToInt);
        }
        else if(protocolInt == 3) {
            byte result[] = new byte[1];
            for (int i = 0; i < 1; i = i + 1)
                result[i] = byteArr[i];
            resultToBoolean = byteArrayToBoolean(result);

            if(resultToBoolean) {
                System.out.println("방에서 나왔습니다..");
            }
            else{
                System.out.println("방에서 나오기를 실패했습니다.");
            }
            System.out.println("참 거짓  " + resultToBoolean);
        }
        else if(protocolInt == 4) {
            byte result[] = new byte[1];
            for (int i = 0; i < 1; i = i + 1)
                result[i] = byteArr[i];
            resultToBoolean = byteArrayToBoolean(result);

            if(resultToBoolean) {
                System.out.println("채팅방에 접속했습니다..");
            }
            else{
                System.out.println("채팅방에 접속을 실패했습니다.");
            }
            System.out.println("참 거짓  " + resultToBoolean);
        }
        return resultToBoolean;
    } // receive
    class TransferClass{
        int protocolName = 0;
        int nameSize = 0;
        String userName = null;

        public TransferClass(int protocolName, int nameSize, String userName){
            this.protocolName = protocolName;
            this.nameSize = nameSize;
            this.userName = userName;

        }
        public int getProtocolname(){
            return protocolName;
        }
        public int getNamesize(){
            return nameSize;
        }
        public String getUsername(){
            return userName;
        }
    }
} // clientProtocol
