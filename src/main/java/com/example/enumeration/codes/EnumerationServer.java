package example.enumeration.codes;

import example.enumeration.codes.WeekDayEnum;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by root on 17-1-10.
 */
public class EnumerationServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        //Establish net listen.
        ServerSocket server = new ServerSocket(8999);
        Socket socket = server.accept();
        //Got the InputStream
        InputStream in = socket.getInputStream();
        ObjectInputStream oin = new ObjectInputStream(in);
        //Read the value.
        WeekDayEnum day = (WeekDayEnum) oin.readObject();
        switch (day){
            case Mon:System.out.println("Do Monday work."); break;
            case Tue:System.out.println("Do Tuesday work."); break;
            case Wed:System.out.println("Do Wednesday work."); break;
            case Thu:System.out.println("Do Thursday work."); break;
            case Fri:System.out.println("Do Friday work."); break;
            case Sat:System.out.println("Do Saturday work."); break;
            case Sun:System.out.println("Do Sunday work."); break;
        }
        oin.close();
        in.close();
        socket.close();

    }
}
