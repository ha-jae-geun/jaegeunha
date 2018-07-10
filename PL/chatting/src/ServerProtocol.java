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

    public int byteArrayToInt(byte bytes[]) {
        return ((((int)bytes[0] & 0xff) << 24) |
                (((int)bytes[1] & 0xff) << 16) |
                (((int)bytes[2] & 0xff) << 8) |
                (((int)bytes[3] & 0xff)));
    }

    public String receiveServer(int protocolInt, byte[] bytes) {
        String returnString = null;

        byte size[] = new byte[4];
        for (int i = 0; i < 4; i = i + 1)
            size[i] = bytes[i+4];
            int sizeInt = byteArrayToInt(size);
            byte[] nameValue = new byte[sizeInt];
            for (int i = 0; i < sizeInt; i = i + 1)
                nameValue[i] = bytes[i+8];
            try {
                returnString = byteToString(nameValue);
                System.out.println("1번 프로토콜 receive server " + protocolInt);
                System.out.println("receive server 유저 이름" + returnString);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        return returnString;
    } // receive

    public String receiveChat(BufferedInputStream in) {
        byte[] bytes = new byte[100];
        byte[] chatBytearray = new byte[100];
        String chat = null;

        try {
            in.read(bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i = i + 1)
            chatBytearray[i] = bytes[i];

        byte[] nameBuffer = null;
        byte[] usernameValue = stringToByteArray(userName);
        byte[] chatValue = stringToByteArray(chat);

        nameBuffer = new byte[ userName.length() + chat.length()];
        System.arraycopy(usernameValue, 0, nameBuffer, 0, userName.length());
        System.arraycopy(chatValue, 0, nameBuffer, userName.length(), chat.length());
        System.out.println("transfer client 바이트 값" + nameBuffer);

        return chat.'';
    }

    public byte[] transferServer(Boolean resultBoolean, int protocolName) {
        byte[] resultBuffer = null;

        if(protocolName == 5) {
            byte[] result = booleanToByteArray(resultBoolean);
            resultBuffer = new byte[1];

            System.arraycopy(result, 0, resultBuffer, 0, 1);
            System.out.println("4번 transfer server 바이트 값" + resultBuffer);
        }
        else{
=           byte[] protocolValue = intToByteArray(protocolName);
            byte[] result = booleanToByteArray(resultBoolean);
            resultBuffer = new byte[5];

            System.arraycopy(protocolValue, 0, resultBuffer, 0, 4);
            System.arraycopy(result, 0, resultBuffer, 4, 1);
            System.out.println("1번 transfer server 바이트 값" +resultBuffer);
        }
        return resultBuffer;
    } // transfer
    class ReceiveClass{
        int protocolName = 0;
        int nameSize = 0;
        String userName = null;

        public ReceiveClass(int protocolName, int nameSize, String userName){
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
    class TransferClass{
        int protocolName = 0;
        boolean isTrue = false;

        public TransferClass(int protocolName, boolean isTrue){
            this.protocolName = protocolName;
            this.isTrue = isTrue;

        }
        public int getProtocolname(){
            return protocolName;
        }
        public boolean getistrue(){
            return isTrue;
        }
    }
    class TransferRoom{
        int protocolName = 0;
        int roomSize =0;
        String roomName = null;
        boolean isTrue = false;

        public TransferRoom(int protocolName, int roomSize, String roomName, boolean isTrue){
            this.protocolName = protocolName;
            this.roomSize = roomSize;
            this.roomName = roomName;
            this.isTrue = isTrue;
        }
    }
    class TransferRoomlist{
        int protocolName = 0;
        int dataSize;
        String Data;

        public TransferRoomlist(int protocolName, int dataSize, String Data){
            this.protocolName = protocolName;
            this.dataSize = dataSize;
            this.Data = Data;
        }
        public int getProtocolname(){
            return protocolName;
        }
        public int getistrue(){
            return dataSize;
        }
        public String getData(){
            return Data;
        }
    }
}//Server Protocol