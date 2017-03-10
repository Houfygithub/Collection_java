import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @param args
 * @throws IOException
 */



public class URLDemo{
    public static void main(String[] args) throws IOException {

        String strUrl = "http://127.0.0.1:8080/myweb/1.html?name=zhangsan";

        URL url = new URL(strUrl);
        InputStream in = url.openStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String text = new String(buf,0,len);

        System.out.println(text);

        in.close();

    }

}