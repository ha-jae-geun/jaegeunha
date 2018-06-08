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
        int join;
        int roomNumber;

        public ClientSender(Socket socket, String name, int join, int roomNumber) {
            this.socket = socket;
            this.name = name;
            this.join = join;
            this.roomNumber= roomNumber;
            try {
                out = new DataOutputStream(socket.getOutputStream());
            } catch (Exception e) {
            }
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);
            try {
                if (out != null) {
                    out.writeUTF(name);
                    out.writeInt(join);
                    out.writeInt(roomNumber);
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
        String name;
        int join;
        int roomNumber;
        try {
            Socket socket = null;
            socket = new Socket();
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 9898));
            System.out.println("서버에 연결되었습니다.");

            Scanner input = new Scanner(System.in);
            System.out.println("이름을 입력하세요.");
            name = input.nextLine();
            System.out.println("방을 생성할 거면 1번, 들어갈 거면 2번을 입력하세요.");
            join = input.nextInt();
            System.out.println("생성하거나 들어갈 방 번호를 입력하세요");
            roomNumber = input.nextInt();

            ClientSender sender = new ClientSender(socket, name, join, roomNumber);
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


