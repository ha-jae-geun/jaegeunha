import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.InetSocketAddress;


public class TcpIpMultiChattingClient {
    static class ClientSender extends Thread {
        Socket socket;
        DataOutputStream out;
        String name;
        int protocol;
        String roomName;
        String msg;
        int join;
        int roomNumber;

        public ClientSender(Socket socket) {
            this.socket = socket;
            this.protocol = protocol;
            this.roomName = roomName;
            this.msg = msg;
            try {
                out = new DataOutputStream(socket.getOutputStream());
            } catch (Exception e) {
            }
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);
            try {
                if (out != null) {
                    out.writeInt(protocol);
                    out.writeUTF(roomName);
                    out.writeUTF(msg);
                }

                while (out != null) {
                    out.writeUTF("[" + name + "]: " + scanner.nextLine());
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
            cp.transferClient();

            if(cp.protocolName == 4) {
                ClientSender sender = new ClientSender(socket);
                ClientReceiver receiver = new ClientReceiver(socket);
                sender.start();
                receiver.start();
            }
        }
        catch (ConnectException ce) {
            ce.printStackTrace();
        }
        catch (Exception e) { }
    }
}


