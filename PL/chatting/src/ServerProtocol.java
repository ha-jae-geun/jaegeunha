import java.io.*;

public class ServerProtocol{
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
        byte [] vOut = new byte[]{(byte) (boo?1:0)};
        return vOut;
    }

    public String byteToString(byte bytes[]) throws UnsupportedEncodingException {
        String byteToString = new String(bytes, "UTF-8");
        return byteToString;
    }

    public String receiveServer(byte[] byteArr, int nameSize, int msgSize, int protocolInt) {
        String returnString = null;

        if(protocolInt == 1) {
            byte name[] = new byte[nameSize];
            for (int i = 0; i < nameSize; i = i + 1)
                name[i] = byteArr[i];
            try {
                returnString = byteToString(name);
                System.out.println("1번 프로토콜 receive server " + protocolInt);
                System.out.println("receive server 유저 이름" + returnString);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        else if(protocolInt == 2){
            byte name[] = new byte[nameSize];
            for (int i = 0; i < nameSize; i = i + 1)
                name[i] = byteArr[i];
            try {
                returnString = byteToString(name);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println("2번 프로토콜 receive server" + protocolInt);
            System.out.println("receive server 방 이름 " + returnString);
        }
        else if(protocolInt == 3) {
            byte name[] = new byte[nameSize];
            for (int i = 0; i < nameSize; i = i + 1)
                name[i] = byteArr[i];
            try {
                returnString = byteToString(name);
                System.out.println(returnString);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println("3번 프로토콜receive server" +protocolInt);
            System.out.println("receive server 나가는 방 이름" +returnString);
        }
        else if(protocolInt == 4) {
            byte roomName[] = new byte[nameSize];
            for (int i = 0; i < nameSize; i = i + 1)
                roomName[i] = byteArr[0 + i];

            byte msgName[] = new byte[msgSize];
            for (int i = 0; i < msgSize; i = i + 1)
                msgName[i] = byteArr[nameSize + i];

            try {
                System.out.println("4번 프로토콜 receive server" + protocolInt);
                System.out.println("receive server 방 이름 크기" +nameSize);
                System.out.println("receive server 메세제 이름 크기" + msgSize);
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
    public byte[] transferServer(Boolean resultBoolean, int resultInt, int protocolName) {
        byte[] resultBuffer = null;

        if(protocolName == 1) {

            byte[] result = booleanToByteArray(resultBoolean);
            resultBuffer = new byte[1];

            System.arraycopy(result, 0, resultBuffer, 0, 1);
            System.out.println("1번 transfer server 바이트 값" +resultBuffer);
        }
        else if(protocolName == 2) {
            byte[] result = intToByteArray(resultInt);
            resultBuffer = new byte[4];

            System.arraycopy(result, 0, resultBuffer, 0, 4);
            System.out.println("2번 transfer server 바이트 값" +resultBuffer);
        }
        else if(protocolName == 3) {
            byte[] result = booleanToByteArray(resultBoolean);
            resultBuffer = new byte[1];

            System.arraycopy(result, 0, resultBuffer, 0, 1);
            System.out.println("3번 transfer server 바이트 값" + resultBuffer);
        }
        else if(protocolName == 4) {
            byte[] result = booleanToByteArray(resultBoolean);
            resultBuffer = new byte[1];

            System.arraycopy(result, 0, resultBuffer, 0, 1);
            System.out.println("4번 transfer server 바이트 값" + resultBuffer);
        }
        return resultBuffer;
    } // transfer
}//Server Protocol