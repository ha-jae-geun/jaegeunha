import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UserInfo {
    Socket serverSocket;

    UserInfo(Socket serverSocket) {
        this.serverSocket = serverSocket;
    }
}

class UserThread extends Thread {
    Socket serverSocket;
    List<UserInfo> li = new ArrayList<UserInfo>();

    UserThread(Socket serverSocket, List li) {
        this.serverSocket = serverSocket;
        this.li = li;
    }

    @Override
    public void run() {
        try {
            while (true) {
                //
                InputStream inputStream = serverSocket.getInputStream();
                byte[] byteArray = new byte[256];
                int size = inputStream.read(byteArray);

                if (size == -1) {
                    break;
                }

                String sendMessage = new String(byteArray, 0, size, "UTF-8");
                System.out.println(sendMessage);

                //
                for (int i = 0; i < li.size(); i++) {
                    if (li.get(i).serverSocket != serverSocket) {
                        OutputStream outputStream = li.get(i).serverSocket.getOutputStream();
                        outputStream.write(byteArray);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Client 접속종료");
            for (int i = 0; i < li.size();   ) {
                if(serverSocket == li.get(i).serverSocket) {
                    li.remove(i);
                } else {
                    i++;
                }
            }
        }
    }
}//


class ConnectThread extends Thread {
    ServerSocket mainServerSocket = null;
    List<UserInfo> li = new ArrayList<UserInfo>();

    ConnectThread(ServerSocket mainServerSocket) {
        this.mainServerSocket = mainServerSocket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket serverSocket = mainServerSocket.accept();
                System.out.println("-Client 접속");

                li.add(new UserInfo(serverSocket));
                UserThread userThread = new UserThread(serverSocket, li);
                userThread.start();

            }
        } catch (Exception e) {}
    }
}//

public class SERVER {
    public static void main(String[] args) {
        System.out.println("-SERVER 시작");

        try {
            ServerSocket mainServerSocket = null;
            mainServerSocket = new ServerSocket();
            mainServerSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(), 4040));

            ConnectThread connectThread = new ConnectThread(mainServerSocket);
            connectThread.start();

            Scanner input = new Scanner(System.in);
            int temp = input.nextInt();
        } catch (Exception e) {}

        System.out.println("-SERVER 종료");
    }
}//

