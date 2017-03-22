import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Houfy on 2017/3/20.
 */
public class Person implements Serializable{

//        成员变量
    private String username;
    private transient String password;  //关键字transient 配合Serializable接口使用，取消指定字段的自动序列化

//        构造函数
    public Person(String username,String password){
        this.username = username;
        this.password = password;
    }

//        手动序列化必要方法
    private void writeObject(ObjectOutputStream out) throws IOException{
        out.defaultWriteObject();  //该方法的第一个操作，序列化所有非transient字段
        out.writeObject(password);  //序列化transient字段
    }
//        手动反序列化必要方法
    private void readObject(ObjectInputStream in )throws IOException,ClassNotFoundException{
        in.defaultReadObject();  //该方法的第一个操作，反序列化所有非transient字段
        password = (String) in.readObject();  //反序列化transient字段
    }

    @Override
    public String toString(){
        return "Person: " + "username=" + username + " password="+password;
//            return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
}
