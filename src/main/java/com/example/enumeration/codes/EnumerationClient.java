package example.enumeration.codes;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import static example.enumeration.codes.EnumExample.*;

/**
 * Created by root on 17-1-10.
 */
public class EnumerationClient {

    //Client Application
    public static void main(String... args) throws UnknownHostException,IOException {
        //establish the connection.
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1",899));
        //Get the OutputStream.
        OutputStream out = socket.getOutputStream();
        ObjectOutputStream oout = new ObjectOutputStream(out);
        //Transition the value.
        oout.writeObject(WeekDayEnum.Fri);
        oout.close();
        out.close();
        socket.close();
    }
}
