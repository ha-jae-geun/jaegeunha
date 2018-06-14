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
    byte[] byteArr;


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

    public String byteToString(byte bytes[]) throws UnsupportedEncodingException {
        String byteToString = new String(bytes, "UTF-8");
        return byteToString;
    }

    public void transferClient() {
        byte[] nameBuffer;
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

            System.out.println(nameBuffer);
            receiveServer(nameBuffer);
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

            System.out.println(nameBuffer);
            receiveServer(nameBuffer);
        }
    } // run

    public void  receiveServer(byte[] byteArr) {
        if(protocolName == 1) {
            byte protocol[] = new byte[4];
            byte size[] = new byte[4];

            for (int i = 0; i < 4; i = i + 1)
                protocol[i] = byteArr[i];
            int protocolInt = byteArrayToInt(protocol);

            for (int i = 0; i < 4; i = i + 1)
                size[i] = byteArr[i + 4];
            int sizeInt = byteArrayToInt(size);

            byte name[] = new byte[sizeInt];
            for (int i = 0; i < sizeInt; i = i + 1)
                name[i] = byteArr[8 + i];
            try {
                String strName = byteToString(name);
                System.out.println(strName);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println(protocolInt);
            System.out.println(sizeInt);
        }
        else if(protocolName == 2){
            byte protocol[] = new byte[4];
            byte size[] = new byte[4];

            for (int i = 0; i < 4; i = i + 1)
                protocol[i] = byteArr[i];
            int protocolInt = byteArrayToInt(protocol);

            for (int i = 0; i < 4; i = i + 1)
                size[i] = byteArr[i + 4];
            int sizeInt = byteArrayToInt(size);

            byte name[] = new byte[sizeInt];
            for (int i = 0; i < sizeInt; i = i + 1)
                name[i] = byteArr[8 + i];
            try {
                String strName = byteToString(name);
                System.out.println(strName);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println(protocolInt);
            System.out.println(sizeInt);
        }
    } // run
}