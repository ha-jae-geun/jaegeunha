import java.io.*;

public class ServerProtocol{
    int protocolName;
    int size;
    String name;
    int roomSize;
    String roomName;
    int msgSize;
    String msgName;
    byte[] resultBuffer;

    public ServerProtocol(){}

    public ServerProtocol(byte[] resultBuffer) {
        this.resultBuffer = resultBuffer;
    }


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

    public int  receiveServer(byte[] byteArr) {
        byte protocol[] = new byte[4];
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
                String strName = byteToString(name);
                System.out.println(strName);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println(protocolInt);
            System.out.println(sizeInt);
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
                String strName = byteToString(name);
                System.out.println(strName);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println(protocolInt);
            System.out.println(sizeInt);
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
                String strName = byteToString(name);
                System.out.println(strName);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println(protocolInt);
            System.out.println(sizeInt);
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
                System.out.println(protocolInt);
                System.out.println(roomSizeInt);
                System.out.println(msgSizeInt);
                String roomStr = byteToString(roomName);
                String msgStr = byteToString(msgName);
                System.out.println(roomStr);
                System.out.println(msgStr);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return protocolInt;
    } // receive
    public byte[] transferClient(int protocolName) {
        if(protocolName == 1) {
            System.out.println("유저 이름을 입력하세요.");

            byte[] protocol = intToByteArray(protocolName);
            byte[] result = booleanToByteArray();
            resultBuffer = new byte[protocol.length + result.length];

            System.arraycopy(protocol, 0, resultBuffer, 0, protocol.length);
            System.arraycopy(result, 0, resultBuffer, protocol.length, result.length);

            System.out.println(resultBuffer);
        }
        else if(protocolName == 2) {
            byte[] protocol = intToByteArray(protocolName);
            byte[] result = intToByteArray();
            resultBuffer = new byte[protocol.length + result.length];

            System.arraycopy(protocol, 0, resultBuffer, 0, protocol.length);
            System.arraycopy(result, 0, resultBuffer, protocol.length, result.length);

            System.out.println(resultBuffer);
        }
        else if(protocolName == 3) {
            byte[] protocol = intToByteArray(protocolName);
            byte[] result = booleanToByteArray();
            resultBuffer = new byte[protocol.length + result.length];

            System.arraycopy(protocol, 0, resultBuffer, 0, protocol.length);
            System.arraycopy(result, 0, resultBuffer, protocol.length, result.length);

            System.out.println(resultBuffer);
        }
        else if(protocolName == 4) {
            byte[] protocol = intToByteArray(protocolName);
            byte[] result = booleanToByteArray();
            resultBuffer = new byte[protocol.length + result.length];

            System.arraycopy(protocol, 0, resultBuffer, 0, protocol.length);
            System.arraycopy(result, 0, resultBuffer, protocol.length, result.length);

            System.out.println(resultBuffer);
        }
        return resultBuffer;
    } // transfer
}