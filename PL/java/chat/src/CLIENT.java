import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;


public class CLIENT {
    public static void main(String[] args) {
        Socket socket;
        System.out.println("-Client2 시작");

        try {

                Scanner input = new Scanner(System.in);
                int temp= input.nextInt();
                socket = new Socket("127.0.0.1", 7777);
                System.out.println("서벼 연결됨");


            while (true) {
                String sendMessage = input.nextLine();
                byte[] byteArray = sendMessage.getBytes("UTF-8");
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(byteArray);

           }
        } catch (Exception e) {
        }
        System.out.println("-Client2 종료");
    }//
}


