//import java.io.*;
//
//public class ServerSerial implements Serializable {
//    private int protocolName;
//    private int size;
//    private String name;
//    private int roomSize;
//    private String roomName;
//    private int msgSize;
//    private String msgName;
//
//    public ServerSerial(int protocolName, int size, String name) {
//        this.protocolName = protocolName;
//        this.size = size;
//        this.name = name;
//    }
//
//    public ServerSerial(int protocolName, int roomSize, String roomName, int msgSize, String msgName) {
//        this.protocolName = protocolName;
//        this.roomSize = roomSize;
//        this.roomName = roomName;
//        this.msgSize = msgSize;
//        this.msgName = msgName;
//
//    }
//
//
//    public void serialization(){
////        NameProtocol user = new NameProtocol("me3602","friday",); //User [id=me3602, nick=friday, age=29]
//
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//
//        try{
//            fos = new FileOutputStream("user.ser");
//            oos = new ObjectOutputStream(fos);
////            oos.writeObject(user);
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            if(fos != null) try{fos.close();}catch(IOException e){e.printStackTrace();}
//            if(fos != null) try{fos.close();}catch(IOException e){e.printStackTrace();}
//        }
//    }
//    public void deserialization(){
//        FileInputStream fis= null;
//        ObjectInputStream ois = null;
//        try {
//            fis = new FileInputStream("user.ser");
//            ois = new ObjectInputStream(fis);
//
//            // 스트림으로 부터 객체를 읽어온다
//            // 이때 리턴 값은 Object 이므로 형변환을 통해 필요한 객체로 캐스팅 해준다
//            NameProtocol user = (NameProtocol)ois.readObject();
//            System.out.println(user.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            if(fis != null) try{fis.close();}catch(IOException e){e.printStackTrace();}
//            if(ois != null) try{ois.close();}catch(IOException e){e.printStackTrace();}
//        }
//    }
//}
