import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class TcpIpMultiChattingServer {
    final static int SERVER_PORT = 9898;
    Map<Socket, String> roomNumber = Collections.synchronizedMap(new HashMap<Socket, String>());
    static int protocolName;
    static int size;
    static String name;
    static int roomSize;
    static String roomName;
    static int msgSize;
    static String msgName;
    static boolean trueFalse;
    static int roomState;
    static byte[] resultArray;

    public TcpIpMultiChattingServer(){}

    public TcpIpMultiChattingServer(boolean trueFalse){
        this.trueFalse = trueFalse;
    }

    public TcpIpMultiChattingServer(int roomState){
        this.roomState = roomState;
    }

    public TcpIpMultiChattingServer(int protocolName, int size, String name){
        this.protocolName = protocolName;
        this.size = size;
        this.name = name;
    }

    public TcpIpMultiChattingServer(int protocolName, int roomSize, String roomName, int msgSize, String msgName){
        this.protocolName = protocolName;
        this.roomSize = roomSize;
        this.roomName = roomName;
        this.msgSize = msgSize;
        this.msgName = msgName;
    }

    public void start() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        Socket socket2;
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("서버가 시작되었습니다.");
            while (true) {
                socket = serverSocket.accept();
                System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속하였습니다.");
                ServerReceiver thread = new ServerReceiver(socket, roomNumber);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    class ServerReceiver extends Thread {
        Socket socket;
        Map<Socket, String> roomNumber = Collections.synchronizedMap(new HashMap<Socket, String>());
        String name;
        DataInputStream in;
        DataOutputStream out;

        public ServerReceiver(Socket socket, Map<Socket, String> roomNumber) {
            this.socket = socket;
            this.roomNumber = roomNumber;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException ie) {
            }
        }
        public void run() {
            try {
                ServerProtocol sp = new ServerProtocol();
                sp.receiveServer(in.readAllBytes());
                RoomManager roomManagers = new RoomManager(socket, protocolName, name, roomName, msgName);
                resultArray = sp.transferServer(protocolName, trueFalse, roomState);
                out.write(resultArray, 0, resultArray.length);
//                while (in!=null) {
//                    sendToAll(roomNumber, socket, msgName);
//                }
            }
            catch (IOException ie) {
            }
            finally {
                roomNumber.remove(socket, name);
                System.out.println(socket);
//                sendToAll(socketList,"#" + name + "님이 퇴장했습니다.");
//                System.out.println(name + "유저 [" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속을 종료하였습니다.");
//                System.out.println("현재 서버접속자 수는 " + socketList.size() + "입니다.");
            } // finally
        } // run
    }
    public static void main(String[] args) {
        new TcpIpMultiChattingServer().start();
    }
}
