import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class TcpIpMultiChattingServer {
    final static int SERVER_PORT = 9898;
    HashMap<Socket, String> roomNumber = new HashMap<Socket, String>();
    String roomName;


    public TcpIpMultiChattingServer(){}

    public Map<Socket, String> getRoomnumber () {
        return roomNumber;
    }

    public void setRoomnumber (HashMap<Socket, String> roomNumber){
        this.roomNumber = roomNumber;
    }


    public byte[] intToByteArray(int value) {
        byte[] byteArray = new byte[4];
        byteArray[0] = (byte)(value >> 24);
        byteArray[1] = (byte)(value >> 16);
        byteArray[2] = (byte)(value >> 8);
        byteArray[3] = (byte)(value);
        return byteArray;
    }

    void sendToAll(HashMap<Socket, String> roomNumber, String roomName, Socket socket, String msg) {
        DataOutputStream out;
        Iterator<Socket> keys = roomNumber.keySet().iterator();
        try {
            while ( keys.hasNext() ) {
                Socket key = keys.next();
                if (roomName.equals(roomNumber.get(key))) {
                    System.out.println("sentAll");
                    out = new DataOutputStream(key.getOutputStream());
                    out.writeUTF(msg);
                }
            }
        }
        catch (Exception e) { }
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
        HashMap<Socket, String> roomNumber =new HashMap<Socket, String>();
        String name;
        DataInputStream in;
        DataOutputStream out;
        ServerProtocol sp = new ServerProtocol();
        String msg;

        public ServerReceiver(Socket socket, HashMap<Socket, String> roomNumber) {
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
                roomNumber.put(null, null);
                while (in!=null) {
                    int protocol = in.readInt();
                    if(protocol == 1){
                        int size = in.readInt();
                        byte[] byteArray = new byte[size];
                        byte[] byteArray2 = null;
                        in.readFully(byteArray, 0, size);
                        name = sp.receiveServer(byteArray, roomNumber, socket);
                        byteArray2 = sp.transferServer(roomNumber, roomName, socket, protocol);
                        out.writeInt(protocol);
                        out.writeInt(byteArray2.length);
                        out.write(byteArray2);
                    }
                    if(protocol == 2){
                        int size = in.readInt();
                        byte[] byteArray = new byte[size];
                        byte[] byteArray2 = null;
                        in.readFully(byteArray, 0, size);
                        roomName = sp.receiveServer(byteArray, roomNumber, socket);
                        roomNumber.put(socket, roomName);
                        byteArray2 = sp.transferServer(roomNumber, roomName, socket, protocol);
                        out.writeInt(protocol);
                        out.writeInt(byteArray2.length);
                        out.write(byteArray2);
                    }
                    if(protocol == 3){
                        int size = in.readInt();
                        byte[] byteArray = new byte[size];
                        byte[] byteArray2 = null;
                        in.readFully(byteArray, 0, size);
                        roomName = sp.receiveServer(byteArray, roomNumber, socket);
                        roomNumber.remove(socket, roomName);
                        byteArray2 = sp.transferServer(roomNumber, roomName, socket, protocol);
                        out.writeInt(protocol);
                        out.writeInt(byteArray2.length);
                        out.write(byteArray2);
                    }
                    if(protocol == 4){
                        int size = in.readInt();
                        byte[] byteArray = new byte[size];
                        byte[] byteArray2 = null;
                        in.readFully(byteArray, 0, size);
                        roomName = sp.receiveServer(byteArray, roomNumber, socket);
                        byteArray2 = sp.transferServer(roomNumber, roomName, socket, protocol);
                        out.writeInt(protocol);
                        out.writeInt(byteArray2.length);
                        out.write(byteArray2);
                        while(in!=null) {
                            sendToAll(roomNumber, roomName, socket, in.readUTF());
                        }
                    }//if문
                }
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
