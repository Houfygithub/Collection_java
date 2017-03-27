import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by Houfy on 2017/3/20.
 */
public class DemoFile {
    static void print(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {

/*  四种构造函数
* File(String filePath)
* File(String parent, String child)
* File(File parent, String chile)
* File(URI uri)
* */
        File f1 = new File("F:\\Dropbox\\Daily");
        File f2 = new File("F:\\Dropbox\\Daily","t1.txt");
        File f3 = new File(f1,"t2.txt");

/*方法toString()
* 返回getPath()
* */
        print(f1.toString());


/*方法
* public String[] list()
* public String[] list(FilenameFilter filter)
* public File[] listFiles()
* public File[] listFiles(FilenameFilter filter)
* public File[] listFiles(FileFilter filter)
* */

//使用文件过滤器筛选java文件
        String[] selectedNames = f1.list(new FilenameFilter() {
            //匿名内部类实现了FilenameFilter接口

            //实现接口中的方法
            @Override
            public boolean accept(File dir, String name) {

                if(name.endsWith(".java")){
                    return true;
                }
                return false;
            }
        });




/*获取文件常用属性
* getName()
* getParent()
* getPath()
* getAbsolutePath()
*
* exists()
* isFile()
* isDirectory()
* isAbsolute() 判断文件是否拥有绝对路径
* canRead()
* canWrite()
* canExecute()
*
* length()
* lastModified()
* */
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

/*方法
* boolean renameTo(File newName)
* boolean delete()
* void deleteOnExit()
* boolean isHidden()
* boolean setLastModified(long millisec)
* boolean setReadOnly()
*
* mkdir()
* mkdirs()
* */

}
