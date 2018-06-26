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
                while (out !=null) {
                    getSendProtocol(out);
                    }
            } catch (IOException e) {
            }
        }//run

        public String getSendProtocol(DataOutputStream out) throws IOException {
            UserManager userManager  = new UserManager(socket);
            Scanner getProtocol= new Scanner(System.in);
            System.out.println("1. 이름 생성 2. 방생성 3. 나가기 4. 채팅. 5. 방 목록");
            String protocol = getProtocol.nextLine();

            Scanner input = new Scanner(System.in);
            String result = null;
            if (protocol.equals("1")) {
                System.out.println("유저 이름을 입력하세요.");
                result = input.nextLine();
                byte[] byteArr2 = cp.transferClient(1, result, "");
                out.writeUTF("1");
                out.writeInt(result.length());
                out.writeInt(0);
                out.write(byteArr2);
            }
            if (protocol.equals("2")) {
                System.out.println("방 이름을 입력하세요.");
                result = input.nextLine();
                if(!userManager.createRoom(result, socket)){
                    System.out.println("이미 참여한 방입니다.");
                }
                else {
                    byte[] byteArr2 = cp.transferClient(2, result, "");
                    out.writeUTF("2");
                    out.writeInt(result.length());
                    out.writeInt(0);
                    out.write(byteArr2);
                }
            }
            if (protocol.equals("3")) {
                System.out.println("나갈 방 이름을 입력하세요.");
                result = input.nextLine();
                userManager.exitRoom(result, socket);
                byte[] byteArr2 = cp.transferClient(3, result, "");
                out.writeUTF("3");
                out.writeInt(result.length());
                out.writeInt(0);
                out.write(byteArr2);
            }
            if (protocol.equals("4")) {
                System.out.println("채팅할 방의 이름을 입력하세요.");
                result = input.nextLine();
                if(!userManager.sendMessage(result, socket)) {
                  System.out.println("해당 채팅방에 먼저 입장하여야 합니다.");
                }
                else {
                    byte[] byteArr2 = cp.transferClient(4, result, "test");
                    out.writeUTF("4");
                    System.out.println("프로토콜 번호 4.");
                    out.writeInt(result.length());
                    out.writeInt(4);
                    out.write(byteArr2);
                    while (out != null) {
                        String chat = input.nextLine();
                        if (chat.equals("out")) {
                            out.writeUTF(chat);
                            break;
                        }
                        out.writeUTF(chat);
                    }//while
                } // else
            } // if문
            if (protocol.equals("5")) {
                out.writeUTF("5");
            }
            return result;
        } // getSendProtocol
    }
    static class ClientReceiver extends Thread {
        Socket socket;
        DataInputStream in;

        public ClientReceiver(Socket socket) {
            this.socket = socket;

        }

        public void run() {
            try {
                ClientProtocol clientProtocol = new ClientProtocol();
                getReceiveProtocol(socket, clientProtocol);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//run

        public void getReceiveProtocol(Socket socket, ClientProtocol clientProtocol) throws IOException {
            try {
                in = new DataInputStream(socket.getInputStream());
            }
            catch (IOException io) { }
            while(in!=null){
                int protocol = in.read();
                if(protocol == 1){
                    byte[] byteArray2 = new byte[1];
                    in.readFully(byteArray2, 0, 1);
                    clientProtocol.receiveClient(byteArray2, protocol);
                }
                else if(protocol == 2){
                    byte[] byteArray2 = new byte[4];
                    in.readFully(byteArray2, 0, 4);
                    clientProtocol.receiveClient(byteArray2, protocol);
                }
                else if(protocol == 3){
                    byte[] byteArray2 = new byte[1];
                    in.readFully(byteArray2, 0, 1);
                    clientProtocol.receiveClient(byteArray2, protocol);
                }
                else if(protocol == 4){
                    byte[] byteArray2 = new byte[1];
                    String test = in.readUTF();
                    in.readFully(byteArray2, 0, 1);
                    clientProtocol.receiveClient(byteArray2, protocol);
                    while (in != null) {
                        String chat = in.readUTF();
                        if (chat.equals("out")) {
                            byte[] byteArray3 = new byte[1];
                            in.readFully(byteArray3, 0, 1);
                            clientProtocol.receiveClient(byteArray3, 3);
                            break;
                        } // if
                         System.out.println(chat);
                    } // while
                } // else if
                else if(protocol == 5){
                    int hashSize = in.readInt();
                    for(int size = 0 ; size< hashSize; ++size){
                        System.out.println(in.readUTF());
                    }
                }
            }//while문
        }

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
} // Client


