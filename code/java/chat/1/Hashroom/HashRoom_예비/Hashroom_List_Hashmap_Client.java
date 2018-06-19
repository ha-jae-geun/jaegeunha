import java.io.ByteArrayOutputStream;
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
                if (out != null) {
                    byte[] byteArr;
                    byteArr = cp.transferClient(1);
                    out.writeInt(byteArr.length);
                    out.write(byteArr);
                }
                while (out !=null) {
                    System.out.println("2. 방생성 3. 나가기 4. 채팅.");
                    byte[] byteArr;
                    int protocol = input.nextInt();
                    byteArr = cp.transferClient(protocol);
                    out.writeInt(protocol);
                    out.writeInt(byteArr.length);
                    out.write(byteArr);
                    if(protocol == 4){
                        Scanner scanner = new Scanner(System.in);
                        while(out!=null){
                            String chat = scanner.nextLine();
                            if(chat.equals("out")){
                                out.writeUTF(chat);
                                break;
                            }
                            else{
                                out.writeUTF(chat);
                            }
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
            int size = 0;
            int protocol = 0;
            try {
                while(in!=null){
                    protocol = in.readInt();
                    if(protocol == 1){
                        int sizes = in.readInt();
                        byte[] byteArray = new byte[sizes];
                        byte[] byteArray2 = null;
                        in.readFully(byteArray, 0, sizes);
                        tcpClient.receiveClient(byteArray);
                    }
                    else if(protocol == 2){
                        int sizes = in.readInt();
                        byte[] byteArray = new byte[sizes];
                        byte[] byteArray2 = null;
                        in.readFully(byteArray, 0, sizes);
                        tcpClient.receiveClient(byteArray);
                    }
                    else if(protocol == 3){
                        int sizes = in.readInt();
                        byte[] byteArray = new byte[sizes];
                        byte[] byteArray2 = null;
                        in.readFully(byteArray, 0, sizes);
                        tcpClient.receiveClient(byteArray);
                    }
                    else if(protocol == 4){
                        int sizes = in.readInt();
                        byte[] byteArray = new byte[sizes];
                        in.readFully(byteArray, 0, sizes);
                        tcpClient.receiveClient(byteArray);
                        while(in!=null){
                            String chat = in.readUTF();
                            if(chat.equals("out")){
                                int roomSize = in.readInt();
                                byte[] byteArray2 = new byte[roomSize];
                                in.readFully(byteArray2, 0, roomSize);
                                tcpClient.receiveClient(byteArray2);
                                break;
                            }
                            else{
                                System.out.println(chat);
                            }
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


