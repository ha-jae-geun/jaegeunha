import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class TcpIpMultiChattingServer {
    final static int SERVER_PORT = 9898;
    HashMap<Socket, String> roomNumber = new HashMap<Socket, String>();


    public TcpIpMultiChattingServer(){}

    void sendToAll(HashMap<Socket, String> roomNumber, String roomName, Socket socket, String msg) {
        DataOutputStream out;
        Iterator<Socket> keys = roomNumber.keySet().iterator();
        try {
            while ( keys.hasNext() ) {
                Socket key = keys.next();
                if (roomName.equals(roomNumber.get(key))) {
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
        HashMap<Socket, String> roomNumber = new HashMap<Socket, String>();
        DataInputStream in;
        DataOutputStream out;
        ServerProtocol sp = new ServerProtocol();
        String roomName;

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
            String name = null;
            try {
                roomNumber.put(null, null);
                int sizes = in.readInt();
                byte[] byteArrays = new byte[sizes];
                byte[] byteArrays2 = null;
                in.readFully(byteArrays, 0, sizes);
                name = sp.receiveServer(byteArrays, roomNumber, socket);
                byteArrays2 = sp.transferServer(roomNumber, roomName, socket, 1);
                out.writeInt(1);
                out.writeInt(byteArrays2.length);
                out.write(byteArrays2);
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
                    System.out.println("name: " + name);
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
                        roomNumber.remove(socket);
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
                            String chat = in.readUTF();
                            if(chat.equals("out")){
                                sendToAll(roomNumber, roomName, socket, "#" + name + "님이 퇴장했습니다.");
                                byteArray2 = sp.transferServer(roomNumber, roomName, socket, 3);
                                out.writeInt(byteArray2.length);
                                out.write(byteArray2);
                                roomNumber.remove(socket);
                                break;
                            }
                            else{
                                sendToAll(roomNumber, roomName, socket, "[" + name + "]" + chat);
                            }
                        }
                    }//if문
                } // while문
            }
            catch (IOException ie) {
            }
            finally {
                roomNumber.remove(socket);
                sendToAll(roomNumber, roomName, socket, "#" + name + "님이 퇴장했습니다.");
                System.out.println(name + "유저 [" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속을 종료하였습니다.");
                System.out.println("현재 서버접속자 수는 " + (roomNumber.size() -1) + "입니다.");
            } // finally
        } // run
    }
    public static void main(String[] args) {
        new TcpIpMultiChattingServer().start();
    }
}
