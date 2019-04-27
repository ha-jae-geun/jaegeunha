import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class TcpIpMultiChattingServer {
    final static int SERVER_PORT = 9898;

    public TcpIpMultiChattingServer(){}


    public void start() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("서버가 시작되었습니다.");
            while (true) {
                socket = serverSocket.accept();
                System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속하였습니다.");
                ServerReceiver thread = new ServerReceiver(socket);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    class ServerReceiver extends Thread {
        Socket socket;
        BufferedInputStream in;
        BufferedOutputStream out;
        Hashtable<Integer, RoomList> roomHash = new Hashtable<Integer, RoomList>();
        String name = null;
        ServerProtocol serverProtocol = new ServerProtocol();

        public ServerReceiver(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedInputStream(socket.getInputStream());
                out = new BufferedOutputStream(socket.getOutputStream());
            } catch (IOException ie) {
            }
        }

        public String getReceiverProtocol(String name, String roomName, Socket socket, RoomManager roomManager){
            Boolean isTrue = false;
            int resultInt = 0;
            int inputBuffer;
            String result = "";
            int protocolInt = 0;
            byte[] bytes = new byte[100];

            try {
                in.read(bytes, 0, bytes.length);
                byte protocol[] = new byte[4];
                for (int i = 0; i < 4; i = i + 1)
                    protocol[i] = bytes[i];
                protocolInt = serverProtocol.byteArrayToInt(protocol);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(protocolInt == 1){
                result = serverProtocol.receiveServer(protocolInt, bytes);
                isTrue = roomManager.createRoom(result, socket);
                serverProtocol.transferServer(isTrue, protocolInt);

            }
            if(protocolInt == 2){
                roomHash = roomManager.getRoomHash();

                roomName = serverProtocol.receiveServer(protocolInt, bytes);
                isTrue = roomManager.sendMessage(roomName, socket, "test");
                serverProtocol.transferServer(isTrue, protocolInt);
                while (in != null) {
                    String chat = serverProtocol.receiveChat(in);
                    if (chat.equals("out")) {
                        out.writeUTF(chat);
                        roomManager.sendToAll(roomName, socket, "#" + name + "님이 퇴장했습니다.");
                        isTrue = roomManager.exitRoom(roomName, socket);
                        ServerProtocol.TransferClass transferClass2 = new ServerProtocol().new TransferClass(1, isTrue);
                        out.writeObject(transferClass);
                        break;
                    }
                    roomManager.sendToAll(roomName, socket, "[" + roomManager.getName(socket) + "]" + chat);
                }//while문
            }//if문
            if(protocolInt == 3){
                isTrue = roomManager.exitRoom(roomName, socket);
                ServerProtocol.TransferClass transferClass = new ServerProtocol().new TransferClass(1, isTrue);
            }
            if(protocolInt == 4){
                ServerProtocol.TransferClass transferClass = new ServerProtocol().new TransferClass(1, isTrue);
            }//if문
            if(protocolInt == 5){
                ServerProtocol.TransferRoomlist transferClass = new ServerProtocol().new TransferRoomlist(1, isTrue);
            }
            return result;
        }

        public void run() {
            RoomManager roomManager = new RoomManager();
            String roomName = null;

            try {
                while (in != null) {
                    roomName = getReceiverProtocol(name, roomName, socket, roomManager);
                }
            } catch(SecurityException e){}
            finally {
                roomManager.exitRoom(roomName, socket);
                roomManager.sendToAll(roomName, socket, "#" + roomManager.getName(socket) + "님이 퇴장했습니다.");
                System.out.println(name + "유저 [" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속을 종료하였습니다.");
                System.out.println("현재 서버접속자 수는 " + (roomHash.size() -1) + "입니다.");
            } // finally
        } // run
    }
    public static void main(String[] args) {
        new TcpIpMultiChattingServer().start();
    }
} // TCP Server
