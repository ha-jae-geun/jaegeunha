import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientProtocol{
    int protocolName;
    int size;
    String name;
    int roomSize;
    String roomName;
    int msgSize;
    String msgName;
    Scanner input = new Scanner(System.in);

    public ClientProtocol(){ }

    public ClientProtocol(int protocolName) {
        this.protocolName = protocolName;
    }

    public ClientProtocol(int protocolName, int size, String name) {
        this.protocolName = protocolName;
        this.size = size;
        this.name = name;
    }
    public ClientProtocol(int protocolName, int roomSize, String roomName, int msgSize, String msgName) {
        this.protocolName = protocolName;
        this.roomSize = roomSize;
        this.roomName = roomName;
        this.msgSize = msgSize;
        this.msgName = msgName;
    }

    public static byte[] intToByteArray(int value) {
        byte[] byteArray = new byte[4];
        byteArray[0] = (byte)(value >> 24);
        byteArray[1] = (byte)(value >> 16);
        byteArray[2] = (byte)(value >> 8);
        byteArray[3] = (byte)(value);
        return byteArray;
    }

    public static byte[] stringToByteArray(String name) {
        byte[] byteArr = new byte[0];
        try {
            byteArr = name.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return byteArr;
    }

    public static int byteArrayToInt(byte bytes[]) {
        return ((((int)bytes[0] & 0xff) << 24) |
                (((int)bytes[1] & 0xff) << 16) |
                (((int)bytes[2] & 0xff) << 8) |
                (((int)bytes[3] & 0xff)));
    }

    public static boolean byteArrayToBoolean(byte bytes[]){
        byte[] vIn = new byte[] { 1, 1, 0 };
        boolean vOut = vIn[0]!=0; //convert first Byte
        return vOut;
    }

    public byte[] transferClient(int protocolName) {
        byte[] nameBuffer = null;

        if(protocolName == 1) {
            System.out.println("유저 이름을 입력하세요.");
            name = input.nextLine();
            size = name.length();
            byte[] protocol = intToByteArray(protocolName);
            byte[] nameSize = intToByteArray(size);
            byte[] nameValue = stringToByteArray(name);
            nameBuffer = new byte[protocol.length + nameSize.length + nameValue.length];

            System.arraycopy(protocol, 0, nameBuffer, 0, protocol.length);
            System.arraycopy(nameSize, 0, nameBuffer, protocol.length, nameSize.length);
            System.arraycopy(nameValue, 0, nameBuffer, nameSize.length + protocol.length, nameValue.length);

            System.out.println("transfer client 바이트 값" + nameBuffer);
        }

        else if(protocolName == 2) {
            System.out.println("방의 이름을 입력하세요.");
            name = input.nextLine();
            size = name.length();
            byte[] protocol = intToByteArray(protocolName);
            byte[] roomSize = intToByteArray(size);
            byte[] roomValue = stringToByteArray(name);
            nameBuffer = new byte[protocol.length + roomSize.length + roomValue.length];

            System.arraycopy(protocol, 0, nameBuffer, 0, protocol.length);
            System.arraycopy(roomSize, 0, nameBuffer, protocol.length, roomSize.length);
            System.arraycopy(roomValue, 0, nameBuffer, roomSize.length + protocol.length, roomValue.length);

            System.out.println("transfer client 바이트 값" + nameBuffer);
        }
        else if(protocolName == 3) {
            System.out.println("나갈 방의 이름을 입력하세요");
            name = input.nextLine();
            size = name.length();
            byte[] protocol = intToByteArray(protocolName);
            byte[] roomSize = intToByteArray(size);
            byte[] roomValue = stringToByteArray(name);
            nameBuffer = new byte[protocol.length + roomSize.length + roomValue.length];

            System.arraycopy(protocol, 0, nameBuffer, 0, protocol.length);
            System.arraycopy(roomSize, 0, nameBuffer, protocol.length, roomSize.length);
            System.arraycopy(roomValue, 0, nameBuffer, roomSize.length + protocol.length, roomValue.length);

            System.out.println("transfer client 바이트 값" + nameBuffer);
        }
        else if(protocolName == 4) {
            System.out.println("메세지를 보낼 방의 이름을 입력하세요.");
            name = input.nextLine();
            size = name.length();
            System.out.println("메세지를 입력하세요.");
            msgName = input.nextLine();
            msgSize = msgName.length();

            byte[] protocol = intToByteArray(protocolName);
            byte[] roomSize = intToByteArray(size);
            byte[] roomValue = stringToByteArray(name);
            byte[] msgSizeArray = intToByteArray(msgSize);
            byte[] msgValue = stringToByteArray(msgName);

            nameBuffer = new byte[protocol.length + roomSize.length + roomValue.length + msgSizeArray.length + msgValue.length];

            System.arraycopy(protocol, 0, nameBuffer, 0, protocol.length);
            System.arraycopy(roomSize, 0, nameBuffer, protocol.length, roomSize.length);
            System.arraycopy(roomValue, 0, nameBuffer, roomSize.length + protocol.length, roomValue.length);
            System.arraycopy(msgSizeArray, 0, nameBuffer, roomSize.length + protocol.length + roomValue.length, msgSizeArray.length);
            System.arraycopy(msgValue, 0, nameBuffer, roomSize.length + protocol.length + roomValue.length + msgSizeArray.length, msgValue.length);

            System.out.println("transfer client 바이트 값" + nameBuffer);
        }
        return nameBuffer;
    } // transfer
    public void  receiveClient(byte[] byteArr) {
        byte protocol[] = new byte[4];
        for (int i = 0; i < 4; i = i + 1)
            protocol[i] = byteArr[i];
        int protocolInt = byteArrayToInt(protocol);

        if(protocolInt == 1) {
            byte result[] = new byte[4];
            for (int i = 0; i < 1; i = i + 1)
                result[i] = byteArr[i+4];
            boolean resultToBoolean = byteArrayToBoolean(result);

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
                result[i] = byteArr[i+4];
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
            byte result[] = new byte[4];
            for (int i = 0; i < 1; i = i + 1)
                result[i] = byteArr[i+4];
            boolean resultToBoolean = byteArrayToBoolean(result);

            if(resultToBoolean) {
                System.out.println("방에서 나왔습니다..");
            }
            else{
                System.out.println("방에서 나오기를 실패했습니다.");
            }
            System.out.println("참 거짓  " + resultToBoolean);
        }
        else if(protocolInt == 4) {
            byte result[] = new byte[4];
            for (int i = 0; i < 1; i = i + 1)
                result[i] = byteArr[i+4];
            boolean resultToBoolean = byteArrayToBoolean(result);

            if(resultToBoolean) {
                System.out.println("메세지를 보냇습니다.");
            }
            else{
                System.out.println("메세지를 보내기를 실패했습니다.");
            }
            System.out.println("참 거짓  " + resultToBoolean);
        }
    } // receive
} // clientProtocol
