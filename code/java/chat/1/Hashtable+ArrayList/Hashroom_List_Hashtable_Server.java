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
        DataInputStream in;
        DataOutputStream out;
        ServerProtocol serverProtocol = new ServerProtocol();
        Hashtable<Integer, RoomList> roomHash = new Hashtable<Integer, RoomList>();
        String name = null;

        public ServerReceiver(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException ie) {
            }
        }

        public String getReceiverProtocol(String name, String roomName, Socket socket, RoomManager roomManager) throws IOException {
            Boolean resultBoolean = false;
            int resultInt = 0;
            String result = null;

            String protocol = in.readUTF();
            if(protocol.equals("1")){
                int size = in.readInt();
                int msgSize = in.readInt();
                byte[] byteArray = new byte[size];
                byte[] byteArray2 = null;

                in.readFully(byteArray, 0, size);
                result = serverProtocol.receiveServer(byteArray, size, 0, 1);
                roomManager.setName(socket, result);
                resultBoolean = roomManager.createName(result);
                byteArray2 = serverProtocol.transferServer(resultBoolean, 0, 1);
                out.write(1);
                out.write(byteArray2);
            }
            if(protocol.equals("2")){
                int size = in.readInt();
                int msgSize = in.readInt();
                byte[] byteArray = new byte[size];
                byte[] byteArray2 = null;

                in.readFully(byteArray, 0, size);
                result = serverProtocol.receiveServer(byteArray, size, 0, 2);
                resultInt = roomManager.createRoom(result, socket);
                byteArray2 = serverProtocol.transferServer(false, resultInt, 2);
                out.write(2);
                out.write(byteArray2);
            }
            if(protocol.equals("3")){
                int size = in.readInt();
                int msgSize = in.readInt();
                byte[] byteArray = new byte[size];
                byte[] byteArray2 = null;

                in.readFully(byteArray, 0, size);
                roomName = serverProtocol.receiveServer(byteArray, size, 0, 3);
                resultBoolean = roomManager.exitRoom(roomName, socket);
                byteArray2 = serverProtocol.transferServer(resultBoolean, 0, 3);
                out.writeInt(3);
                out.write(byteArray2);
            }
            if(protocol.equals("4")){
            int nameSize = in.readInt();
            int msgSize = in.readInt();
            byte[] byteArray = new byte[nameSize + msgSize];
            byte[] byteArray2 = null;
            roomHash = roomManager.getRoomHash();

            in.readFully(byteArray, 0, nameSize + msgSize);
            roomName = serverProtocol.receiveServer(byteArray, nameSize, msgSize, 4);
            out.write(4);
            resultBoolean = roomManager.sendMessage(roomName, socket, "test");
            byteArray2 = serverProtocol.transferServer(resultBoolean, 0, 4);
            out.write(byteArray2);
            while (in != null) {
                String chat = in.readUTF();
                if (chat.equals("out")) {
                    out.writeUTF(chat);
                    roomManager.sendToAll(roomName, socket, "#" + name + "님이 퇴장했습니다.");
                    resultBoolean = roomManager.exitRoom(roomName, socket);
                    byteArray2 = serverProtocol.transferServer(resultBoolean, 0, 3);
                    out.write(byteArray2);
                    break;
                }
                roomManager.sendToAll(roomName, socket, "[" + roomManager.getName(socket) + "]" + chat);
            }//while문
        }//if문
            if(protocol.equals("5")){
                out.writeInt(5);
                roomManager.roomList(out);
            }//if문
            return result;
        }

        public void run() {
            RoomManager roomManager = new RoomManager();
            String roomName = null;

            try {
                while (in!=null) {
                    roomName = getReceiverProtocol(name, roomName, socket, roomManager);
                } // while문
            }
            catch (IOException ie) {
            }
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
