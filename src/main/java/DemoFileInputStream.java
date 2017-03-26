import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Houfy on 2017/3/25.
 */
public class DemoFileInputStream {
    /*
    *FileInputSteam 是一个从文件读取字节的流
    *常用构造函数
    * FileInputStream(String filePath)
    * FileInputStream(File fileObj)
    *
    *FileInputStream重载了InputStream的六个方法，mark和reset方法不被重载
    * */

    public static void main(String[] args) throws IOException {
        int size;
        InputStream f = new FileInputStream("D:\\IdeaProjects\\Collection_java\\src\\main\\java\\DemoFileInputStream.java");
        System.out.println("Total Availablel Bytes: " + (size = f.available()));

        int n = size / 40;
        System.out.println("First " + n + " bytes of the file one read() at a time.");
        //从文件中读取n个字节
        for (int i=0; i<n; i++){
            System.out.print((char) f.read());
        }
        System.out.println("\nStill Available: " + f.available());

        System.out.println("Reading the next " + n + " with one read(b[])");
        byte[] b = new byte[n];
        if (f.read(b) != n ){
            System.out.println("Could not read " + n + "bytes");
        }
        System.out.println(new String(b,0,n));

        System.out.println("\nStill Available: " + (size = f.available()));
        System.out.println("Skipping half of remaining bytes with skip()");
        f.skip(size/2);
        System.out.println("Still Available: " + f.available());

        System.out.println("Reading " + n/2 + " into the end of array");
        if (f.read(b,n/2,n/2) != n/2){
            System.out.println("Couldn't read " + n/2 + "bytes");
        }
        System.out.println(new String(b,n/2,n/2));

        System.out.println("\nStill Available: " + f.available());
        f.close();






    }

}
