import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by dianrong on 17-3-10.
 *
 * 应答行 应答状态码 应答状态行描述信息
 * HTTP/1.1 200 OK
 *
 * 应答消息属性 属性名：属性值
 * Server: Apache-Coyote/1.1
 * Accept-Ranges: bytes
 * ETag: W/"24874-1465990848000"
 * Last-Modified: Wed, 15 Jun 2016 11:40:48 GMT//最后修改时间
 * Content-Type: text/html
 * Content-Length: 24874
 * Date: Mon, 04 Jul 2016 14:54:43 GMT
 * Connection: close
 * //空行
 * 应答体
 * <html>
 * <head>
 * <title>这是我的网页</title>
 * </head>
 * <body>
 * <h1>欢迎光临</h1>
 * <font size='5' color="red">这是一个Tomcat服务器中的资源。这是一个html网页。</font>
 * </body>
 * </html>
 */


public class MockBrowser {
    public static void main(String[] args) throws UnknownHostException,IOException {
        Socket socket = new Socket("127.0.0.1",8080);

        //模拟浏览器发送http请求消息
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.write("GET /myweb/1.html HTTP/1.1");
        out.write("Accept: */*");
        out.write("Host: 192.168.1.127:8080");
        out.write("Connection: close");
        out.println();
        out.println();


        //接收服务器端响应消息
        InputStream in = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String responseData = new String(buf,0,len);

        System.out.println(responseData);

        socket.close();
    }
}
