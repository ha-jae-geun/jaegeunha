
import java.io.*;
import java.net.*;


class TestData {
    byte[] bytes = new byte[100] ;
    char c; // assume this char value will not excced one byte (i.e. cannot use Hangul char)
    boolean val;
    String string;

    /*
     * fill with some data
     */
    public TestData() {
        for (int i=0; i<bytes.length; i++)
            bytes[i] = (byte)i;
        c = 'c';
        val = true;
        string = "¾î¶² string";
    }


    public void writeDataExternal(java.io.DataOutputStream stream)
            throws IOException
    {
        stream.write(bytes);
        stream.write(c);
        for (int i=0; i<3; i++)
            stream.write(0); // fill three byte
        stream.writeInt(val?1:0);
        byte[] strBytes = string.getBytes("EUC_KR");
        // first write the byte length of string
        stream.writeInt(strBytes.length);
        stream.write(strBytes);
        // NOTE: never use writeBytes() method. writeBytes() methods write strings
        // converting each chars to byte, so only string.length() byte will be written
        // stream.writeBytes(string);
    }

    public void readDataExternal(java.io.DataInputStream stream)
            throws IOException
    {
        bytes = new byte[100];
        stream.read(bytes, 0, bytes.length);
        c = (char) stream.read();
        for (int i=0; i<3; i++)
            stream.read(); // discard three byte
        val=((stream.readInt()==0)?false:true);

        int len = stream.readInt();
        byte[] strBytes=new byte[len];
        stream.read(strBytes, 0, len);
        string = new String(strBytes, "EUC_KR");
    }

    /*
     * display member fields
     */
    public void print() {
        System.out.println("bytes  :");
        for (int i=0; i<bytes.length; i++) {
            if (i%10 == 0)
                System.out.println();
            System.out.print(bytes[i] + " ");
        }
        System.out.println();
        System.out.println("c      : " + (char) c);
        System.out.println("val    : " + val);
        System.out.println("string : "+string);
    }

}

class TestClient
{
    public static void usage() {
        System.out.println("\nUsage : java TestClient server port");
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            usage();
            System.exit(1);
        }

        Socket socket = null;
        try {
            socket = new Socket(args[0], Integer.parseInt(args[1]));
        } catch (IOException ie) {
            System.out.println("cannot establish socket connection to "
                    + args[0] + ":" + args[1] + " - " + ie);
            System.exit(2);
        }

        TestData td = new TestData();
        TestData td2 = new TestData();

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        try {
            // first write to server socket
            td.print();
            td.writeDataExternal(out);
            out.flush();
            System.out.println("write to socket server ends");

            // later, read from server socket
            td2.readDataExternal(in);
            td2.print();
            System.out.println("read from socket server ends");
        } finally {
            out.close();
            in.close();
        }
    }
}