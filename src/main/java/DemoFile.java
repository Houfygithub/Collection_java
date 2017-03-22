import java.io.File;

/**
 * Created by Houfy on 2017/3/20.
 */
public class DemoFile {
    static void print(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {

//        Constructor
        File f1 = new File("F:\\");
        File f2 = new File("F:\\","t1.txt");
        File f3 = new File(f1,"t2.txt");

//        File Path
        print(f1.toString());
        print(f2.toString());
        print(f3.toString());

//        File Lists
        for (String s:f1.list()){
            print(s);
        }

//        File Basic Properties
        print("File Name: " + f1.getName());
        print("Path: " + f1.getPath());
        print("Abs Path: " + f1.getAbsolutePath());
        print("Parent: " + f1.getParent());
        print(f1.exists() ? "exists" : "does not exist");
        print(f1.canWrite() ? "is writeable" : "is not writeable");
        print(f1.canRead() ? "is readable" : "is not readable");
        print("is " + (f1.isDirectory() ? "" : "not" + " a directory"));
        print(f1.isFile() ? "is normal file" : "might be a named pipe");
        print(f1.isAbsolute() ? "is absolute" : "is not absolute");
        print("File last modified: " + f1.lastModified());
        print("File size: " + f1.length() + " Bytes");

    }
}
