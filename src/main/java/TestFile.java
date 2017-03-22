import java.io.File;

/**
 * Created by Houfy on 2017/3/20.
 */
public class TestFile {
    public static void main(String[] args) {
        File file = new File("F:\\");
        System.out.println(file.toString());
        System.out.println(file.list());
    }
}
