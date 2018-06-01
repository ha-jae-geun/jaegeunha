import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SERVER {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;

        System.out.println("-SERVER 시작");
        try {
                serverSocket = new ServerSocket(7777);
                System.out.println("대기중");
                socket = serverSocket.accept();
                System.out.println(socket.getInetAddress() + "이 연결되었습니다.");

                System.out.println("중간");

            while (true) {
                InputStream inputStream = socket.getInputStream();
                byte[] byteArray = new byte[256];
                int size = inputStream.read(byteArray);
                String sendMessage = new String(byteArray, 0, size, "UTF-8");
                System.out.println(sendMessage);
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(byteArray);
            }

        } catch (Exception e) {}

        System.out.println("-SERVER 종료");
    }
}//


//파일의 내용을 읽거나, 네트워크를 통해 받은 데이터는 보통 byte[] 배열이므로 이것을 문자열로 변환하기 위해 사용됩니다.
//int read() : 한 바이트씩 읽는다 (리턴형 int 는 데이터다..).. 느리지.. 느려..
//int read(byte[] b) : 한번에 왕창 읽는다 (데이터가 byte[] 배열에 저장. 리턴형 int 는 카운터다..)



