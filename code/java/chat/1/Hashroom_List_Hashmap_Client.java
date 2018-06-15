import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.InetSocketAddress;


public class TcpIpMultiChattingClient {
    static int protocolName;
    static int size;
    static String name;
    static int roomSize;
    static String roomName;
    static int msgSize;
    static String msgName;
    static byte[] byteArr;

    public TcpIpMultiChattingClient(int protocolName, int size, String name){
        this.protocolName = protocolName;
        this.size = size;
        this.name = name;
    }

    public TcpIpMultiChattingClient(int protocolName, int roomSize, String roomName, int msgSize, String msgName){
        this.protocolName = protocolName;
        this.roomSize = roomSize;
        this.roomName = roomName;
        this.msgSize = msgSize;
        this.msgName = msgName;
    }

    static class ClientSender extends Thread {
        Socket socket;
        DataOutputStream out;

        public ClientSender(Socket socket, byte[] byteArr) {
            this.socket = socket;
            try {
                out = new DataOutputStream(socket.getOutputStream());
            } catch (Exception e) {
            }
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);
            try {
                while (out != null) {
                    out.write(byteArr, 0, byteArr.length);
                }
            } catch (IOException e) {
            }
        }
    }
    static class ClientReceiver extends Thread {
        Socket socket;
        DataInputStream in;

        public ClientReceiver(Socket socket) {
            this.socket = socket;
            try {
                // DataInputStream(InputStream in)
                in = new DataInputStream(socket.getInputStream());
            } catch (IOException io) {
            }
        }
        public void run() {
            while (in != null) {
                try {
                    System.out.println(in.readUTF());
                } catch (IOException ie) {
                }
            }
        }
    }
    public static void main(String[] args) {
        int select;
        int join;
        int roomNumber;
        try {
            Socket socket = null;
            socket = new Socket();
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 9898));
            System.out.println("서버에 연결되었습니다.");

            Scanner input = new Scanner(System.in);
            System.out.println("이름을 입력하세요.");
            select = input.nextInt();
            ClientProtocol cp = new ClientProtocol(select);
            ClientSender sender = new ClientSender(socket, cp.transferClient());
            ClientReceiver receiver = new ClientReceiver(socket);
            sender.start();
            receiver.start();
        }
        catch (ConnectException ce) {
            ce.printStackTrace();
        }
        catch (Exception e) { }
    }
}


