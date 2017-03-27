import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Houfy on 2017/3/25.
 */
public class DemoFileOutputStream {

    /*
    * */

    public static void main(String[] args) throws IOException {

/* 构造函数, 他们可能引发IOException和SecurityException异常
* FileOutputStream(String filePath)
* FileOutputStream(File fileObj)
* FileOutputStream(String filePath, boolean append)
*
* */

    String source = "Now is the time for all good men\n" +
            "to come to the aid of their country\n" +
            "and pay their due taxes.";
    byte[] buf = source.getBytes();
    //第一个文件，写入所有偶数索引的字节
    OutputStream f1 = new FileOutputStream("file1.txt");
    for (int i=0; i<buf.length; i +=2){
        f1.write(buf[i]);
    }
    f1.close();

    //第二个文件：将字节数组全部写入文件
    OutputStream f2 =new FileOutputStream("file2.txt");
    f2.write(buf);
    f2.close();

    //第三个文件：将字节数组后四分之一写入文件
    OutputStream f3 = new FileOutputStream("file3.txt");
    f3.write(buf,buf.length -buf.length/4,buf.length/4);
    f3.close();




    }
}
