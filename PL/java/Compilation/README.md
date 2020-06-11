# 자바 압축 파일 비교(Compilation)
```java
자바에서 압축이 필요할 때?

자바에서 압축이 필요한 경우는 언제일까?

- 사용자가 요청한 데이터를 압축해서 (다운로드 가능하게) 파일로 보내줘야할 때

- 로그를 파일에 쌓고 파일을 압축하거나 로그 파일의 내용(문자열)을 압축해서 DB에 저장할 때

- 압축파일 내부에 .exe파일이 있는지 검사할 때 (조금 다른 예시)

기타 여러 경우가 많이 있으나 생략한다.

사실 리눅스에서는 crontab 과 DBMS에서 제공하는 명령어로 압축하고 저장할 수 있기도 하다. (꼭 자바(프로그래밍 단)에서 할 필요는 없다.)

어떤 경우든 결국은 압축이 필요하고 압축이 필요할 때 적절히 프로그래밍할 줄 알아야 한다.

압축의 용도와 성능 

압축률이 엄청나게 좋아서 1/10로 크기를 줄인게 무조건 성능이 좋다고 말할 수 있을까?

물론 여전히 압축의 용도가 크기를 줄이는 것이 보통이라 압축률이 좋은 라이브러리, 툴, 알고리즘을 쓰는게 고성능, 고효율로 평가받는다.

하지만 압축률이 높을수록 압축하는데 걸리는 시간은 오래걸릴 수 밖에 없다.

속도가 중요한 프로그램에서는 압축률은 조금 감수하더라도 빠르게 압축하기를 원하는 경우가 있다.

따라서 용도에 맞게 적절한 라이브러리를 사용한다면 좋은 프로그램을 만들 수 있을 것이다.

아래부터는 라이브러리들을 간단하게 사용해본다.

Snappy-java

snappy는 원래 C/C++용 라이브러린데 자바에서도 사용할 수 있게 나온 라이브러리다.

구글에서 BSD라이센스로 제공하고 있는 것으로 알고 있다. (정확한 정보 아닐 수 있음) 

용도는 압축보다 속도에 맞춰져있어서 압축률보다 고속의 압축/해제가 필요할 때 사용한다.



3개의 라이브러리(차례대로 zip4j, commons-compress, snappy-java)가 있지만 이번에 필요한 것은 3번째에 있는 snappy-java만 있으면 된다.

maven repository에서 검색해서 받도록 한다.

[예제 소스]


import java.io.IOException;
import java.io.UnsupportedEncodingException;
 
import org.xerial.snappy.Snappy;
 
public class SnappyComp {
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        String input = "Hello snappy-java! Snappy-java is a JNI-based wrapper of Snappy,"
                + " a fast compresser/decompresser."
                + "hello world hello world"
                + "jeong-pro is good programmer";
        byte[] compressed = Snappy.compress(input.getBytes("UTF-8"));
        String result = new String(compressed);
        System.out.println(result);
        System.out.println("============================");
        byte[] uncompressed = Snappy.uncompress(compressed);
        result = new String(uncompressed, "UTF-8");
        System.out.println(result);
    }
}
 
Colored by Color Scripter
cs
[결과]



실제로 엄청나게 압축되지 않고 중간중간 문자열이 그대로 보이는 것을 알 수 있다.

그 이유는 압축률이 높지 않기 때문이다. (압축은 간단히 속도는 빠르게!)

Apache commons-compress

한글로 압축하고 해제하는데 불편함이 없는 것으로 알려진 라이브러리다.

apache에서 제공하고 있어서 안정적인 라이브러리로 사용할만하다.

다른 블로그에서 퍼온 코드로 테스트를 진행했다.


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
 
public class ApacheComp {
    public static final String currPath = System.getProperty("user.dir");//프로젝트(현재) 경로
    
    public static void main(String[] args) throws IOException {
        String path = currPath + File.separator+ "hello";
        File file = new File(path);
        String files[] = null;
 
        //파일이 디렉토리 일경우 리스트를 읽어오고
        //파일이 디렉토리가 아니면 첫번째 배열에 파일이름을 넣는다.
        if( file.isDirectory() ){
            files = file.list();
        }else{
            files = new String[1];
            files[0] = file.getName();
            System.out.println(file.getName().getBytes());
        }
         
        //buffer size
        int size = 1024;
        byte[] buf = new byte[size];
        String outZipNm = path+File.separator + "테스트.zip";
         
        FileInputStream fis = null;
        ZipArchiveOutputStream zos = null;
        BufferedInputStream bis = null;
         
        try {
            // Zip 파일생성
            zos = new ZipArchiveOutputStream(new BufferedOutputStream(new FileOutputStream(outZipNm))); 
            for( int i=0; i < files.length; i++ ){
                //해당 폴더안에 다른 폴더가 있다면 지나간다.
                if( new File(path+"/"+files[i]).isDirectory() ){
                    continue;
                }
                //encoding 설정
                zos.setEncoding("UTF-8");
                 
                //buffer에 해당파일의 stream을 입력한다.
                fis = new FileInputStream(path + "/" + files[i]);
                bis = new BufferedInputStream(fis,size);
                 
                //zip에 넣을 다음 entry 를 가져온다.
                zos.putArchiveEntry(new ZipArchiveEntry(files[i]));
                 
                 
                //준비된 버퍼에서 집출력스트림으로 write 한다.
                int len;
                while((len = bis.read(buf,0,size)) != -1){
                    zos.write(buf,0,len);
                }
                 
                bis.close();
                fis.close();
                zos.closeArchiveEntry();
  
            }
            zos.close();
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
            if( zos != null ){
                zos.close();
            }
            if( fis != null ){
                fis.close();
            }
            if( bis != null ){
                bis.close();
            }
        }
    }
}
Colored by Color Scripter
cs
[결과]



프로젝트 경로 밑에 hello라는 디렉토리를 만들고 안에 jeongpro.txt를 만든 후 파일을 복사해서 여러파일을 가지고 있었는데 압축이 잘되었다.

zip4j

안드로이드에서 주로 사용된다고 하는 라이브러리다.

소스코드가 아주 간단해서 간단하게 이용할 때 좋다.

[압축]


import java.io.File;
 
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
 
public class Zip4jComp {
    public static final String currPath = System.getProperty("user.dir");
    public static void main(String[] args){
        String source = currPath + File.separator + "files.zip";
        String destination = currPath + File.separator + "hello";
        try {
             ZipFile zipfile = new ZipFile(source);
             ZipParameters parameters = new ZipParameters();
             parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
             parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
             zipfile.addFolder(destination, parameters);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }
}
 
Colored by Color Scripter




[압축 해제]


import java.io.File;
 
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
 
public class Zip4jComp {
    public static final String currPath = System.getProperty("user.dir");
    public static void main(String[] args){
        String source = currPath + File.separator + "files.zip";
        String destination = currPath + File.separator + "hello";
        String password = "password";
        try {
             //압축파일 생성
             ZipFile zipFile = new ZipFile(source);
             if (zipFile.isEncrypted()){
                 //비밀번호 해제
                zipFile.setPassword(password);
             }
             //압축 해제
             zipFile.extractAll(destination);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }
}
 
Colored by Color Scripter


자바 내장 패키지(java.util.zip...) 

자바에서 별다른 라이브러리를 가져올 필요없이 쓸 수 있는 내장 라이브러리를 사용한다.


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
 
public class ZipComp {
    public static final int MAX_SIZE = 1024;
    public static final String currPath = System.getProperty("user.dir");
    
    public static void main(String[] args) {
        String path = currPath + File.separator+ "hello";
        File file = new File(path);
        String files[] = null;
 
        if( file.isDirectory() ){
            files = file.list();
        }else{
            files = new String[1];
            files[0] = file.getName();
            System.out.println(file.getName().getBytes());
        }
        byte[] buf = new byte[MAX_SIZE];
 
        ZipOutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        try {
            outputStream = new ZipOutputStream(new FileOutputStream("result.zip"));
 
            for (String fileName : files) {
                fileInputStream = new FileInputStream(path + "\\" +fileName);
                outputStream.putNextEntry(new ZipEntry(fileName));
 
                int length = 0;
                while ( ( length = fileInputStream.read() ) > 0) {
                    outputStream.write(buf, 0, length);
                }
                outputStream.closeEntry();
                fileInputStream.close();
            }
            outputStream.close();
        } catch (IOException e) {
        } finally {
            try {
                outputStream.closeEntry();
                outputStream.close();
            } catch (IOException e) {
            }
        }
    }
}
Colored by Color Scripter


[결과]



사진에 아까 압축한 files.zip(11KB)이 보이는데 압축률만 봤을 때는 자바 내장 라이브러리가 안 좋다. (60KB)

단, 텍스트파일일 때이고 심지어 파일 내용도 비슷한 내용을 반복해서 적어놨으니 명확한 비교는 아닐 수 있다.

이미지파일일 때 또 다르고 텍스트가 많이 중복되냐 중복되지 않냐에 따라도 다르다. (알고리즘이 다르기 때문)



- 결론

직접 압축률도 테스트해보고 속도도 테스트해보며 공부하고 적절한 라이브러리를 사용하는 것이 좋겠다.
```
