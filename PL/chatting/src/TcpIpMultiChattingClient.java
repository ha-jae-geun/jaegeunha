import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.InetSocketAddress;


public class TcpIpMultiChattingClient {

    static class ClientSender extends Thread {
        Socket socket;
        BufferedOutputStream out;
        String userName;

        public ClientSender(Socket socket) {
            this.socket = socket;
            try {
                out = new BufferedOutputStream(socket.getOutputStream());
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

        public String getSendProtocol(BufferedOutputStream out) throws IOException {
            ClientProtocol clientProtocol = new ClientProtocol();
            UserManager userManager  = new UserManager(socket);
            Scanner input = new Scanner(System.in);
            System.out.println("유저 이름을 입력하세요");
            userName = input.nextLine();
            System.out.println("1. 방생성 2. 방 접속 3. 방 나가기. 4. 방 옮기기 5. 방 리스트");
            int protocol = input.nextInt();

            String result = null;
            if (protocol == 3 | protocol == 4) {
                System.out.println("유저 이름을 입력하세요.");
                result = input.nextLine();
                out.write(clientProtocol.transferClient(protocol, result.length(), result));
            }
            if (protocol == 1) {
                System.out.println("방 이름을 입력하세요.");
                result = input.nextLine();
                if(!userManager.createRoom(result, socket)){
                    System.out.println("이미 참여한 방입니다.");
                }
                else {
                    out.write(clientProtocol.transferClient(protocol, result.length(), result));
                }
            }
            if (protocol == 2) {
                System.out.println("채팅할 방의 이름을 입력하세요.");
                result = input.nextLine();

                if(!userManager.sendMessage(result, socket)) {
                  System.out.println("해당 채팅방에 먼저 입장하여야 합니다.");
                } else {
                    out.write(clientProtocol.transferClient(protocol, result.length(), result));
                    while (true) {
                        String chat = input.nextLine();
                        if (chat.equals("exit")) {
                            out.write(clientProtocol.transferChat('[' + userName + ']', chat));
                            userManager.exitRoom(result, socket);
                            break;
                        }
                        out.write(clientProtocol.transferChat(userName, chat));
                    }//while
                } // else
            } // if문
            if (protocol == 5 ) {
                out.write(clientProtocol.intToByteArray(6));
            }
            return result;
        } // getSendProtocol
    }
    static class ClientReceiver extends Thread {
        Socket socket;
        ObjectInputStream in;

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
                in = new ObjectInputStream(socket.getInputStream());
            }
            catch (IOException io) {
            }

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
                    in.readFully(byteArray2, 0, 1);
                    clientProtocol.receiveClient(byteArray2, protocol);
                    while (true) {
                        String chat = in.readUTF();
                        if (chat.equals("exit")) {
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
            ClientSender sender = new ClientSender(socket);
            ClientReceiver receiver = new ClientReceiver(socket);
            sender.start();
            receiver.start();
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (Exception e) {

        }
    }
} // Client


