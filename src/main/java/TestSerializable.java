import java.io.*;

/**
 * Created by Houfy on 2017/3/20.
 */
public class TestSerializable {
    public static void main(String[] args) throws IOException,ClassNotFoundException{

        //序列化Person对象到一个文件中
        ObjectOutputStream oosf = new ObjectOutputStream(new FileOutputStream("Person.out"));
        oosf.writeObject("Save an Object:\n");
        oosf.writeObject(new Person("elliot","123456aa"));
        oosf.close();

        //序列化Person对象到字节数组中
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oosb = new ObjectOutputStream(baos);
        oosb.writeObject("Save Another Object:\n");
        oosb.writeObject(new Person("Jason","qq123456"));
        oosb.close();


        //从一个文件中反序列化Person对象
        ObjectInputStream oisf = new ObjectInputStream(new FileInputStream("Person.out"));
        String fs  =(String) oisf.readObject();
        Person pf = (Person) oisf.readObject();


        //从一个字节数组中反序列化Person对象
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream oisb = new ObjectInputStream(bais);
        String sb =(String) oisb.readObject();
        Person pb = (Person) oisb.readObject();

        //打印反序列化结果
        System.out.println( fs + pf);
        System.out.println("---------分隔符-----------");
        System.out.println(sb + pb);
        System.out.println("---------分隔符-----------");
        System.out.println(new Person("houfy","1111"));
    }

}


