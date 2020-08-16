import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class TcpIpMultiChattingServer {
    final static int SERVER_PORT = 9898;
    List<Socket> roomNumber = Collections.synchronizedList(new ArrayList<Socket>());

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
                roomNumber.add(socket);
                ServerReceiver thread = new ServerReceiver(socket, roomNumber);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void sendToAll(List<Socket> socketList, String msg) {
        DataOutputStream out;
            try {
                for (Socket socket : socketList) {
                        out = new DataOutputStream(socket.getOutputStream());
                        out.writeUTF(msg);
                }
            }
            catch (Exception e) { }

    }
    class ServerReceiver extends Thread {
        Socket socket;
        DataInputStream in;
        List <Socket> socketList = Collections.synchronizedList(new ArrayList<Socket>());

        public ServerReceiver(Socket socket, List<Socket> socketList) {
            this.socket = socket;
            this.socketList = socketList;
            try {
                in = new DataInputStream(socket.getInputStream());
            } catch (IOException ie) {
            }
        }
        public void run() {
            String name = "";
            try {
                name = in.readUTF();
                while (in!=null) {
                    sendToAll(socketList, in.readUTF());
                }
            }
            catch (IOException ie) {
            }
            finally {
                try {
                    socket.close();
                }
                catch (IOException ie){}
                socketList.remove(socket);
                System.out.println(socket);
                sendToAll(socketList,"#" + name + "님이 퇴장했습니다.");
                System.out.println(name + "유저 [" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속을 종료하였습니다.");
                System.out.println("현재 서버접속자 수는 " + socketList.size() + "입니다.");
            } // finally
        } // run
    }
    public static void main(String[] args) {
        new TcpIpMultiChattingServer().start();
    }
}
