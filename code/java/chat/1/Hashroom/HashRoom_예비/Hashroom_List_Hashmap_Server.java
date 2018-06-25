import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class TcpIpMultiChattingServer {
    final static int SERVER_PORT = 9898;
    HashMap<Socket, String> roomHash = new HashMap<Socket, String>();

    public TcpIpMultiChattingServer(){}

    void sendToAll(HashMap<Socket, String> roomHash, String roomName, Socket socket, String msg) {
        DataOutputStream out;
        Iterator<Socket> keys = roomHash.keySet().iterator();
        try {
            while ( keys.hasNext() ) {
                Socket key = keys.next();
                if (roomName.equals(roomHash.get(key)) && socket != key) {
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
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("서버가 시작되었습니다.");
            while (true) {
                socket = serverSocket.accept();
                System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속하였습니다.");
                ServerReceiver thread = new ServerReceiver(socket, roomHash);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    class ServerReceiver extends Thread {
        Socket socket;
        DataInputStream in;
        DataOutputStream out;
        ServerProtocol serverProtocol = new ServerProtocol();
        HashMap<Socket, String> roomHash = new HashMap<Socket, String>();

        public ServerReceiver(Socket socket, HashMap<Socket, String> roomHash) {
            this.socket = socket;
            this.roomHash = roomHash;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException ie) {
            }
        }

        public void run() {
            String roomName = null;
            String name = null;
            RoomManager roomManager = new RoomManager(socket, roomHash);

            try {
                int sizes = in.read();
                byte[] byteArrays = new byte[sizes];
                byte[] byteArrays2 = null;
                Boolean resultBoolean;
                int resultInt;
                int byteLength = 0;

                roomHash.put(null, null);
                in.readFully(byteArrays, 0, sizes);
                name = serverProtocol.receiveServer(byteArrays, roomHash, socket, sizes, 0, 1);
                resultBoolean = roomManager.createName(roomHash, roomName, socket);
                byteArrays2 = serverProtocol.transferServer(roomHash, name, socket, resultBoolean, 0, 1);
                out.write(byteArrays2);
                while (in!=null) {
                    int protocol = in.read();
                    if(protocol == 1){
                        int size = in.read();
                        int msgSize = in.read();
                        byte[] byteArray = new byte[size];
                        byte[] byteArray2 = null;
                        resultBoolean = roomManager.createName(roomHash, roomName, socket);

                        in.readFully(byteArray, 0, size);
                        name = serverProtocol.receiveServer(byteArray, roomHash, socket, size, 0, protocol);
                        byteArray2 = serverProtocol.transferServer(roomHash, name, socket, resultBoolean, 0, protocol);
                        out.write(1);
                        out.write(byteArray2);
                    }
                    System.out.println("name: " + name);
                    if(protocol == 2){
                        int size = in.read();
                        int msgSize = in.read();
                        byte[] byteArray = new byte[size];
                        byte[] byteArray2 = null;

                        in.readFully(byteArray, 0, size);
                        roomName = serverProtocol.receiveServer(byteArray, roomHash, socket, size, 0, protocol);
                        roomHash.put(socket, roomName);
                        resultInt = roomManager.createRoom(roomHash, roomName, socket);
                        byteArray2 = serverProtocol.transferServer(roomHash, roomName, socket, false, resultInt, protocol);
                        out.write(2);
                        out.write(byteArray2);
                    }
                    if(protocol == 3){
                        int size = in.readInt();
                        byte[] byteArray = new byte[size];
                        byte[] byteArray2 = null;
                        resultBoolean = roomManager.exitRoom(roomHash, roomName, socket);

                        in.readFully(byteArray, 0, size);
                        roomName = serverProtocol.receiveServer(byteArray, roomHash, socket, size, 0, protocol);
                        byteArray2 = serverProtocol.transferServer(roomHash, roomName, socket, resultBoolean, 0, protocol);
                        out.writeInt(3);
                        out.write(byteArray2);
                        roomHash.remove(socket);
                    }
                    if(protocol == 4){
                        int nameSize = in.read();
                        int msgSize = in.read();
                        byte[] byteArray = new byte[nameSize + msgSize];
                        byte[] byteArray2 = null;

                        in.readFully(byteArray, 0, nameSize + msgSize);
                        roomName = serverProtocol.receiveServer(byteArray, roomHash, socket, nameSize, msgSize, protocol);
                        out.write(4);
                        resultBoolean = roomManager.sendMessage(roomHash, roomName, socket, "test");
                        byteArray2 = serverProtocol.transferServer(roomHash, roomName, socket, resultBoolean, 0, protocol);
                        out.write(byteArray2);
                        while(in!=null) {
                            String chat = in.readUTF();
                            if(chat.equals("out")){
                                out.writeUTF(chat);
                                roomHash.remove(socket);
                                resultBoolean = roomManager.exitRoom(roomHash, roomName, socket);
                                byteArray2 = serverProtocol.transferServer(roomHash, roomName, socket, resultBoolean, 0, 3);
                                out.write(byteArray2);
                                break;
                            }
                            for(Socket key : roomHash.keySet()) {
                                String value = roomHash.get(key);
                                System.out.println(key + " : " + value);
                            }
                                sendToAll(roomHash, roomName, socket, "[" + name + "]" + chat);
                        }
                    }//if문
                } // while문
            }
            catch (IOException ie) {
            }
            finally {
                roomHash.remove(socket);
                sendToAll(roomHash, roomName, socket, "#" + name + "님이 퇴장했습니다.");
                System.out.println(name + "유저 [" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속을 종료하였습니다.");
                System.out.println("현재 서버접속자 수는 " + (roomHash.size() -1) + "입니다.");
            } // finally
        } // run
    }
    public static void main(String[] args) {
        new TcpIpMultiChattingServer().start();
    }
}
