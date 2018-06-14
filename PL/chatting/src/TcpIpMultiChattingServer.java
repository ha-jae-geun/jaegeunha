import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class TcpIpMultiChattingServer {
    final static int SERVER_PORT = 9898;
    Map<Socket, String> roomNumber = Collections.synchronizedMap(new HashMap<Socket, String>());

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
                roomNumber.put(socket, "감자");
                ServerReceiver thread = new ServerReceiver(socket, roomNumber);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void sendToAll(Map<Socket, String> roomNumber, Socket socket, String msg) {
        DataOutputStream out;
        try {
            for (Socket key : roomNumber.keySet()) {
                if (roomNumber.get(socket) == roomNumber.get(key))
                {
                    out = new DataOutputStream(key.getOutputStream());
                    out.writeUTF(msg);
                }
            }
        }
        catch (Exception e) { }

    }
    class ServerReceiver extends Thread {
        Socket socket;
        DataInputStream in;
        Map<Socket, String> roomNumber = Collections.synchronizedMap(new HashMap<Socket, String>());
        int select;
        ByteArrayOutputStream byteOut;

        public ServerReceiver(Socket socket, Map<Socket, String> roomNumber) {
            this.socket = socket;
            this.roomNumber = roomNumber;
            try {
                in = new DataInputStream(socket.getInputStream());
            } catch (IOException ie) {
            }
        }
        public void run() {
            try {
                select = in.readInt();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ClientProtocol cp = new ClientProtocol(select);
            cp.transferClient();
            try {
                while (in!=null) {
                    sendToAll(roomNumber, socket, in.readUTF());
                }
            }
            catch (IOException ie) {
            }
            finally {
                try {
                    socket.close();
                }
                catch (IOException ie){}
//                socketList.remove(socket);
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
