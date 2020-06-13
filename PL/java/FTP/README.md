# FTP
```java
파일질라, 알FTP(?) 같은 훌륭한 FTP프로그램들이 이미 있지만 자바로 간단하게 파일을 전송하는 프로그램을 찾아보았다.

(사실 텔넷으로 명령어 쓸 일이 있어서 telnet 라이브러리를 찾다가 ftp도 흥미가 생겨 한번 사용해보는 것...)

* 참고로 apache에서 commons-net 이라고 라이브러리를 제공하는데 여기에 telnet도 있고 NTP, FTP등 다양한 일반적인 

프로토콜이 있어서 일반적인 프로토콜 통신 기능을 쉽게 사용할 수 있다.

ftp로 통신을 하려면 먼저 ftp서버가 돌고 있어야 파일 전송을 받아준다.

virtual machine 을 사용해서 리눅스(우분투)를 설치한 후에 ftp서버를 사용할 수 있게 바꿔줘야 한다. (마지막에 설명함)


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
 
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
 
public class FTPUploader {
    
    FTPClient ftp = null;
    
    //param( host server ip, username, password )
    public FTPUploader(String host, String user, String pwd) throws Exception{
        ftp = new FTPClient();
        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        int reply;
        ftp.connect(host);//호스트 연결
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new Exception("Exception in connecting to FTP Server");
        }
        ftp.login(user, pwd);//로그인
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        ftp.enterLocalPassiveMode();
    }
    //param( 보낼파일경로+파일명, 호스트에서 받을 파일 이름, 호스트 디렉토리 )
    public void uploadFile(String localFileFullName, String fileName, String hostDir)
            throws Exception {
        try(InputStream input = new FileInputStream(new File(localFileFullName))){
        this.ftp.storeFile(hostDir + fileName, input);
        //storeFile() 메소드가 전송하는 메소드
        }
    }
 
    public void disconnect(){
        if (this.ftp.isConnected()) {
            try {
                this.ftp.logout();
                this.ftp.disconnect();
            } catch (IOException f) {
                f.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Start");
        FTPUploader ftpUploader = new FTPUploader("192.168.0.153", "jdk", "1234");
        ftpUploader.uploadFile("C:\\Users\\jdg\\Desktop\\jeongpro\\hello.txt", "hello.txt", "/home/jdk/");
        ftpUploader.disconnect();
        System.out.println("Done");
    }
 
}
Colored by Color Scripter
cs
간단한 소스코드를 보면서 설명을 하면, 먼저 FTPClient 객체를 만들고 connect() 메소드로 해당 ftp서버 즉, 보낼 곳에 연결을 한다.

그 뒤 login() 메소드로 ftp서버에 로그인을 한다. (물론 FileType이나 Mode등 설정 필요)

끝으로 storeFile() 메소드로 전송하면 끝!





[linux 우분투 가상머신에서 전송 완료된 화면]



[linux 우분투 가상머신에서 전송 완료된 화면 terminal버전]



[원본파일 경로 및 내용]

FTP로 파일이 안보내질 때

모든 오류에 대응하는 것은 아니고 그냥 단순히 생각해봐야할 부분에 대해 설명한다.

먼저 linux를 그냥 설치하면 telnet client는 자동으로 설치되어있을 수 있는데 telnet server는 설치되어있지 않다.

따라서 "vsftpd"를 설치해줘야한다. (d가 붙은걸 보니 데몬임을 알 수 있다.)

어떤 패키지 매니저(apt-get, yum등)를 사용해도 좋다.

"sudo apt-get install vsftpd" 라고 입력하면 설치 완료.

그 다음에 /etc/vsftpd.conf 파일을 에디터(vi, vim, gedit등)로 열어서 "write_enable=yes"라고 되어있는 부분을 찾는다.





그럼 그 부분이 #으로 주석처리 되어있을 텐데 앞에 #을 지워주면 주석이 풀리면서 원격에서 리눅스로 파일 전송이 가능해진다.

그리고 리눅스에서 네트워크를 NAT로 잡으면 가상환경이기때문에 ip를 찾지 못하는 경우가 생길 수 있다.

따라서 네트워크설정에서 "어댑터에 브리지"로 연결해주고 DHCP로 ip를 받지말고 static으로 ip, subnet, dns등을 잡아주면 된다.

* 추가적으로 정확한 것은 아닌데 가상머신이라 포트를 따로 열지 않아도 되었으나 실제 원격에서는 포트(ftp는 보통 21번)를 

열어야 할 경우도 있다.

잘 되지 않으면 찾아보도록 한다.


```
