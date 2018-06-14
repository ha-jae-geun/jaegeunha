import java.io.*;

public class ServerProtocol{
    int protocolName;
    int size;
    String name;
    int roomSize;
    String roomName;
    int msgSize;
    String msgName;
    ByteArrayOutputStream byteOut;

        public ServerProtocol(int protocolName, ByteArrayOutputStream byteOut) {
        this.protocolName = protocolName;
        this.byteOut = byteOut;
    }
//    public ClientProtocol(int protocolName, int roomSize, String roomName, int msgSize, String msgName) {
//        this.protocolName = protocolName;
//        this.roomSize = roomSize;
//        this.roomName = roomName;
//        this.msgSize = msgSize;
//        this.msgName = msgName;
//    }




}