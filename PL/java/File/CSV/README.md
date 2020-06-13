# CSV 읽기
```java
Java CSV 파일 입출력

CSV 파일은 Comma Separated Values 이름 그대로 콤마(,)로 구분하는 데이터 저장 형식이다.

개인적으로 엑셀파일에 데이터가 있을 때 엑셀의 다른이름으로 저장에서 파일형식을 .csv 로 바꿔서 입출력했다.

R프로그래밍을 했을 때도 입출력했던 기억이 있다.

1. csv파일 읽기



[csv 파일 샘플]

엑셀에 적고 .csv파일로 저장한 다음에 메모장을 통해 csv파일을 열어보았을 때 화면이다.

그냥 메모장에서 샘플파일을 만들어 저장해도 무관.

* 주의할 점은 UTF-8 형식의 유니코드로 저장해야 에러가 없다. (에러나면 메모장에서 UTF-8로 저장하고하면 됨.)


package com.tistory.jeongpro;
 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class ReadCsv {
    public static void main(String[] args){
        //반환용 리스트
        List<List<String>> ret = new ArrayList<List<String>>();
        BufferedReader br = null;
        
        try{
            br = Files.newBufferedReader(Paths.get("C:\\Users\\world\\Desktop\\employee1.csv"));
            //Charset.forName("UTF-8");
            String line = "";
            
            while((line = br.readLine()) != null){
                //CSV 1행을 저장하는 리스트
                List<String> tmpList = new ArrayList<String>();
                String array[] = line.split(",");
                //배열에서 리스트 반환
                tmpList = Arrays.asList(array);
                System.out.println(tmpList);
                ret.add(tmpList);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
 
Colored by Color Scripter
cs
직접 코딩하면서 UTF-8문제 때문에 employee1.csv 파일로 교체했다.



결과가 깨름칙하다. 사원번호 앞에 '?' 가 붙는다. 왜 붙는지는 아직도 모르겠다.

코드는 bufferedReader로 한 줄씩 읽고 읽은 문자열에서 콤마(,)로 스플릿을 통해 나뉜 요소를 가진 배열을 만든다.

그 배열을 리스트화시켜서 넣는 것을 줄마다 반복.

2. csv 파일 쓰기

이번에는 아까 읽기한 내용 뒤에 하나의 열(주소)을 쓰기해보겠다.


package com.tistory.jeongpro;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class WriteCsv {
    public static void main(String[] args){
        //출력 스트림 생성
        BufferedWriter bufWriter = null;
        try{
            bufWriter = Files.newBufferedWriter(Paths.get("C:\\Users\\world\\Desktop\\employee2.csv"),Charset.forName("UTF-8"));
            
            //csv파일 읽기
            List<List<String>> allData = readCSV();
            
            for(List<String> newLine : allData){
                List<String> list = newLine;
                for(String data : list){
                    bufWriter.write(data);
                    bufWriter.write(",");
                }
                //추가하기
                bufWriter.write("주소");
                //개행코드추가
                bufWriter.newLine();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(bufWriter != null){
                    bufWriter.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    
    public static List<List<String>> readCSV(){
        //반환용 리스트
        List<List<String>> ret = new ArrayList<List<String>>();
        BufferedReader br = null;
        
        try{
            br = Files.newBufferedReader(Paths.get("C:\\Users\\world\\Desktop\\employee1.csv"));
            //Charset.forName("UTF-8");
            String line = "";
            
            while((line = br.readLine()) != null){
                //CSV 1행을 저장하는 리스트
                List<String> tmpList = new ArrayList<String>();
                String array[] = line.split(",");
                //배열에서 리스트 반환
                tmpList = Arrays.asList(array);
                System.out.println(tmpList);
                ret.add(tmpList);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return ret;
    }
}
 
Colored by Color Scripter
cs
코드가 길어보이지만 아래(readCSV)함수는 아까 csv파일 읽기 소스를 그대로 옮겨서 함수로 바꾼 것뿐이다.

1. 쓰기형식(bufferdWriter)으로 파일을 열고

2. 기존 읽기코드로 읽은 내용을 한줄 한줄마다 값 넣고 콤마(,) 넣고 값 넣고 콤마(,)넣고를 반복한다.

3. 한 줄을 다 적었을 때 추가할 값을 넣는다.

4. 잘 생성되었는지 확인한다.



[결과]
```
