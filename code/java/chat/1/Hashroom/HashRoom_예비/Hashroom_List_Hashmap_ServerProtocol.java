import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerProtocol{

    byte[] resultBuffer;

    public ServerProtocol(){}

    public byte[] intToByteArray(int value) {
        byte[] byteArray = new byte[4];
        byteArray[0] = (byte)(value >> 24);
        byteArray[1] = (byte)(value >> 16);
        byteArray[2] = (byte)(value >> 8);
        byteArray[3] = (byte)(value);
        return byteArray;
    }

    public byte[] booleanToByteArray(boolean boo){
        boolean vIn = true;
        byte [] vOut = new byte[]{(byte) (vIn?1:0)};
        return vOut;
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

    public String receiveServer(byte[] byteArr, HashMap<Socket, String> roomNumber, Socket socket) {
        byte resultArray [] = null;
        byte protocol[] = new byte[4];
        String returnString = null;

        for (int i = 0; i < 4; i = i + 1)
            protocol[i] = byteArr[i];
        int protocolInt = byteArrayToInt(protocol);
        if(protocolInt == 1) {
            byte size[] = new byte[4];

            for (int i = 0; i < 4; i = i + 1)
                size[i] = byteArr[i + 4];
            int sizeInt = byteArrayToInt(size);

            byte name[] = new byte[sizeInt];
            for (int i = 0; i < sizeInt; i = i + 1)
                name[i] = byteArr[8 + i];
            try {
                returnString = byteToString(name);
                System.out.println("receive server 프로토콜" + protocolInt);
                System.out.println("receive server 유저 이름 크기" + sizeInt);
                System.out.println("receive server 유저 이름" + returnString);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        else if(protocolInt == 2){
            byte size[] = new byte[4];

            for (int i = 0; i < 4; i = i + 1)
                size[i] = byteArr[i + 4];
            int sizeInt = byteArrayToInt(size);

            byte name[] = new byte[sizeInt];
            for (int i = 0; i < sizeInt; i = i + 1)
                name[i] = byteArr[8 + i];
            try {
                returnString = byteToString(name);
                System.out.println(returnString);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println("receive server 프로토콜 " + protocolInt);
            System.out.println("receive server 방 이름 크기 " + sizeInt);
            System.out.println("receive server 방 이름 " + returnString);
        }
        else if(protocolInt == 3) {
            byte size[] = new byte[4];

            for (int i = 0; i < 4; i = i + 1)
                size[i] = byteArr[i + 4];
            int sizeInt = byteArrayToInt(size);

            byte name[] = new byte[sizeInt];
            for (int i = 0; i < sizeInt; i = i + 1)
                name[i] = byteArr[8 + i];
            try {
                returnString = byteToString(name);
                System.out.println(returnString);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println("receive server 프로토콜" +protocolInt);
            System.out.println("receive server 방 크기" +sizeInt);
        }
        else if(protocolInt == 4) {
            byte roomSize[] = new byte[4];
            byte msgSize[] = new byte[4];

            for (int i = 0; i < 4; i = i + 1)
                roomSize[i] = byteArr[i + 4];
            int roomSizeInt = byteArrayToInt(roomSize);

            byte roomName[] = new byte[roomSizeInt];
            for (int i = 0; i < roomSizeInt; i = i + 1)
                roomName[i] = byteArr[8 + i];

            for (int i = 0; i < 4; i = i + 1)
                msgSize[i] = byteArr[i + 8 + roomSizeInt];
            int msgSizeInt = byteArrayToInt(msgSize);

            byte msgName[] = new byte[msgSizeInt];
            for (int i = 0; i < msgSizeInt; i = i + 1)
                msgName[i] = byteArr[i + 12 + roomSizeInt];

            try {
                System.out.println("receive server 프로토콜" + protocolInt);
                System.out.println("receive server 방 이름 크기" +roomSizeInt);
                System.out.println("receive server 메세제 이름 크기" + msgSizeInt);
                returnString= byteToString(roomName);
                String msg = byteToString(msgName);
                System.out.println("receive server 방 이름" + returnString);
                System.out.println("receive server 메세지 이름" +msg);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        System.out.println("return 값 " + returnString);
        return returnString;
    } // receive
    public byte[] transferServer(HashMap<Socket, String> roomNumber, String roomName, Socket socket, int protocolName) {
        if(protocolName == 1) {
            System.out.println("유저 이름을 입력하세요.");
            RoomManager rm = new RoomManager();
            boolean trueFalse = rm.createName(roomNumber, roomName, socket);

            byte[] protocol = intToByteArray(protocolName);
            byte[] result = booleanToByteArray(trueFalse);
            resultBuffer = new byte[protocol.length + result.length];

            System.arraycopy(protocol, 0, resultBuffer, 0, protocol.length);
            System.arraycopy(result, 0, resultBuffer, protocol.length, result.length);

            System.out.println("transfer server 바이트 값" +resultBuffer);
        }
        else if(protocolName == 2) {
            byte[] protocol = intToByteArray(protocolName);
            RoomManager rm = new RoomManager();
            byte[] result = intToByteArray(rm.createRoom(roomNumber, roomName, socket));
            resultBuffer = new byte[protocol.length + result.length];

            System.arraycopy(protocol, 0, resultBuffer, 0, protocol.length);
            System.arraycopy(result, 0, resultBuffer, protocol.length, result.length);

            System.out.println("transfer server 바이트 값" +resultBuffer);
        }
        else if(protocolName == 3) {
            byte[] protocol = intToByteArray(protocolName);
            RoomManager rm = new RoomManager();
            byte[] result = booleanToByteArray(rm.exitRoom(roomNumber, roomName, socket));
            resultBuffer = new byte[protocol.length + result.length];

            System.arraycopy(protocol, 0, resultBuffer, 0, protocol.length);
            System.arraycopy(result, 0, resultBuffer, protocol.length, result.length);

            System.out.println("transfer server 바이트 값" + resultBuffer);
        }
        else if(protocolName == 4) {
            byte[] protocol = intToByteArray(protocolName);
            RoomManager rm = new RoomManager();
            byte[] result = booleanToByteArray(rm.sendMessage(roomNumber, roomName, socket));
            resultBuffer = new byte[protocol.length + result.length];

            System.arraycopy(protocol, 0, resultBuffer, 0, protocol.length);
            System.arraycopy(result, 0, resultBuffer, protocol.length, result.length);

            System.out.println("transfer server 바이트 값" + resultBuffer);
        }
        return resultBuffer;
    } // transfer
}