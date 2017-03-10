import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/*
* 请求行： GET /myweb/1.html HTTP/1.1
*
* 请求消息头，属性名：属性值
* Accept: text/html, application/xhtml+xml, image/jxr, *//*
* Accept-Language: zh-Hans-CN,zh-Hans;q=0.8,en-US;q=0.5,en;q=0.3
* User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) 　　Chrome/46.0.2486.0 Safari/537.36 Edge/13.10586
* Accept-Encoding: gzip, deflate
* Host: 127.0.0.1:9090
* Connection: Keep-Alive8
*
* */


public class MockServer{
    public static void main(String[] args) throws IOException{
        //建立服务端的socket链接,监听9090端口
        ServerSocket serverSocket = new ServerSocket(9090);
        //接收客户端请求消息
        Socket socket = serverSocket.accept();

        System.out.println(socket);

        //解析输入流中的数据
        InputStream inputStream = socket.getInputStream();
        byte[] buff = new byte[1024];
        int len = inputStream.read(buff);
        String text = new String(buff,0,len,"utf-8");

        System.out.println(text);

        //向客户端发送数据
        String responseData = "<font color='red' size='7'>欢迎光临<font/>";
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
        printWriter.write(responseData);

        //释放资源
        socket.close();
        serverSocket.close();
    }
}