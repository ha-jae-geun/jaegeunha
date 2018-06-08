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
    List<List> listManager = Collections.synchronizedList(new ArrayList<List>());

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
                ServerReceiver thread = new ServerReceiver(listManager, roomNumber, socket);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void sendToAll(List<List> listManager, List<Socket> socketList, int roomNumber, String msg) {
        DataOutputStream out;
        List<Socket> room =  Collections.synchronizedList(new ArrayList<Socket>());
            try {
                for (Socket roomSave : room)) {
                        out = new DataOutputStream(roomSave.getOutputStream());
                        out.writeUTF(msg);
                }
            }
            catch (Exception e) { }
    }
    class ServerReceiver extends Thread {
        Socket socket;
        DataInputStream in;
        List <Socket> socketList = Collections.synchronizedList(new ArrayList<Socket>());
        List<List> listManager = Collections.synchronizedList(new ArrayList<List>());

        public ServerReceiver(List<List> listManager, List<Socket> socketList, Socket socket) {
            this.listManager = listManager;
            this.socket = socket;
            this.socketList = socketList;
            try {
                in = new DataInputStream(socket.getInputStream());
            } catch (IOException ie) {
            }
        }
        public void run() {
            String name = "";
            int join;
            int roomNumber;
            try {
                name = in.readUTF();
                join =  in.readInt();
                roomNumber = in.readInt();

                System.out.println(join);
                System.out.println(roomNumber);

                CreateRoom createRoom = new CreateRoom(listManager, socketList, socket, join, roomNumber);
                EnterRoom enterRoom = new EnterRoom(listManager, socketList, socket, join, roomNumber);

                if(join == 1)
                    createRoom.start();
                else if (join == 2)
                    enterRoom.start();

                while (in!=null) {
                    sendToAll(listManager, socketList, roomNumber, in.readUTF());
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
                sendToAll(listManager,socketList, "#" + name + "님이 퇴장했습니다.");
                System.out.println(name + "유저 [" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속을 종료하였습니다.");
                System.out.println("현재 서버접속자 수는 " + socketList.size() + "입니다.");
            } // finally
        } // run
    }

    class CreateRoom extends Thread {
        List <Socket> socketList = Collections.synchronizedList(new ArrayList<Socket>());
        List <List> listManager = Collections.synchronizedList(new ArrayList<List>());
        Socket socket;
        int  i;
        int  j;

        public CreateRoom(List<List> listManager, List<Socket> socketList, Socket socket, int i, int j){
                this.listManager = listManager;
                this.socketList = socketList;
                this.socket = socket;
                this.i = i;
                this.j = j;
            }
            public void run(){
            while(socket!=null) {
                listManager.get(j).add(socketList);
            }
        }
    }
    class EnterRoom extends Thread {
        List <Socket> socketList = Collections.synchronizedList(new ArrayList<Socket>());
        List <List> listManager = Collections.synchronizedList(new ArrayList<List>());
        Socket socket;
        int  i;
        int  j;

        public EnterRoom(List<List> listManager, List<Socket> socketList, Socket socket, int  i, int  j){
            this.listManager = listManager;
            this.socketList = socketList;
            this.socket = socket;
            this.i = i;
            this.j = j;
        }
        public void run(){
            while(socket!=null) {
                if (socketList == null) {
                    listManager.remove(socketList);
                } else
                    listManager.get(j).add(socketList);
            }
        }
    }
    public static void main(String[] args) {
        new TcpIpMultiChattingServer().start();
    }
}
