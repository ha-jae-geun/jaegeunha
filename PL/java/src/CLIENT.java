import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

class ClientReader extends Thread {
    Socket clientSocket;

    ClientReader(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = clientSocket.getInputStream();
            byte[] byteArray = new byte[256];
            while (true) {
                int size = inputStream.read(byteArray);
                String readMessage = new String(byteArray, 0, size, "UTF-8");
                System.out.println(" > " + readMessage);
            }
        } catch (Exception e) {}
    }
}//

public class CLIENT {
    public static void main(String[] args) {
        System.out.println("-Client2 시작");

        try {
            Socket clientSocket = null;
            Scanner input = new Scanner(System.in);
            System.out.print("-접속 하시겠습니까? : ");
            int temp= input.nextInt();

            clientSocket = new Socket();
            clientSocket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 4040));
            System.out.print("-접속 성공");


            while (true) {
                ClientReader clientReader = new ClientReader(clientSocket);
                clientReader.start();

                String sendMessage = input.nextLine();
                byte[] byteArray = sendMessage.getBytes("UTF-8");
                OutputStream outputStream = clientSocket.getOutputStream();
                outputStream.write(byteArray);
            }
        } catch (Exception e) {
        }
        System.out.println("-Client2 종료");
    }//
}


