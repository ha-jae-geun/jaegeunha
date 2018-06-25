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
        ClientProtocol cp = new ClientProtocol();

        public ClientSender(Socket socket) {
            this.socket = socket;
            try {
                out = new DataOutputStream(socket.getOutputStream());
            } catch (Exception e) {
            }
        }

        public void run() {
            try {
                Scanner input = new Scanner(System.in);
                byte[] byteArr = null;
                int byteLength = 0;

                System.out.println("유저 이름을 입력하세요.");
                String name = input.nextLine();
                byteArr = cp.transferClient(1, name, "");
                out.write(name.length());
                out.write(byteArr);

                while (out !=null) {
                    System.out.println("2. 방생성 3. 나가기 4. 채팅.");
                    String protocol = input.nextLine();

                    if(protocol.equals("1")){
                        System.out.println("유저 이름을 입력하세요.");
                        String userName = input.nextLine();
                        byte[] byteArr2 = cp.transferClient(1, userName, "");
                        out.writeInt(1);
                        out.writeInt(name.length());
                        out.write(0);
                        out.write(byteArr2);
                    }
                    if(protocol.equals("2")){
                        System.out.println("방 이름을 입력하세요.");
                        String roomName = input.nextLine();
                        byte[] byteArr2 = cp.transferClient(2, roomName, "");
                        out.write(2);
                        out.write(roomName.length());
                        out.write(0);
                        out.write(byteArr2);
                    }
                    if(protocol.equals("3")){
                        System.out.println("나갈 방 이름을 입력하세요.");
                        String roomName = input.nextLine();
                        byte[] byteArr2 = cp.transferClient(3, roomName, "");
                        out.writeInt(3);
                        out.writeInt(roomName.length());
                        out.write(0);
                        out.write(byteArr2);
                    }
                    if(protocol.equals("4")){
                        System.out.println("채팅할 방의 이름을 입력하세요.");
                        String roomName = input.nextLine();
                        byte[] byteArr2 = cp.transferClient(4, roomName, "test");
                        out.write(4);
                        System.out.println("프로토콜 번호 4.");
                        out.write(roomName.length());
                        out.write(4);
                        out.write(byteArr2);
                        while(out!=null){
                            String chat = input.nextLine();
                            if(chat.equals("out")){
                                out.writeUTF(chat);
                                break;
                            }
                            out.writeUTF(chat);
                        }
                    }
                }
            } catch (IOException e) {
            }
        }//run

    }
    static class ClientReceiver extends Thread {
        Socket socket;
        DataInputStream in;
        ClientProtocol tcpClient = new ClientProtocol();

        public ClientReceiver(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
            } catch (IOException io) {
            }
        }
        public void run() {
            try {
                byte[] byteArray = new byte[1];
                in.readFully(byteArray, 0, 1);
                tcpClient.receiveClient(byteArray, 1);

                while(in!=null){
                    int protocol = in.read();
                    if(protocol == 1){
                        byte[] byteArray2 = new byte[1];
                        in.readFully(byteArray2, 0, 1);
                        tcpClient.receiveClient(byteArray2, protocol);
                    }
                    else if(protocol == 2){
                        byte[] byteArray2 = new byte[4];
                        in.readFully(byteArray2, 0, 4);
                        tcpClient.receiveClient(byteArray2, protocol);
                    }
                    else if(protocol == 3){
                        byte[] byteArray2 = new byte[1];
                        in.readFully(byteArray2, 0, 1);
                        tcpClient.receiveClient(byteArray2, protocol);
                    }
                    else if(protocol == 4){
                        byte[] byteArray2 = new byte[1];
                        String test = in.readUTF();
                        in.readFully(byteArray2, 0, 1);
                        tcpClient.receiveClient(byteArray2, protocol);
                        while(in!=null){
                            String chat = in.readUTF();
                            if(chat.equals("out")){
                                byte[] byteArray3 = new byte[1];
                                in.readFully(byteArray3, 0, 1);
                                tcpClient.receiveClient(byteArray3, 3);
                                break;
                            }
                            System.out.println(chat);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//run
    }

    public static void main(String[] args) {
        try {
            Socket socket = null;
            socket = new Socket();
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 9898));
            System.out.println("서버에 연결되었습니다.");
            ClientProtocol cp = new ClientProtocol();
            ClientSender sender = new ClientSender(socket);
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


