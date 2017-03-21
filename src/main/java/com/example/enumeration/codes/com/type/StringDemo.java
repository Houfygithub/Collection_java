package example.enumeration.codes.com.type;

/**
 * Created by root on 17-1-22.
 */
public class StringDemo {
    public static void main(String[] args) {
        // public String():创建String对象
        String s1 = new String();
        System.out.println("s1:" + s1);
        System.out.println("s1.length():" + s1.length());
        System.out.println("--------------------------");

        // public String(byte[] bytes):把字节数组转成字符串。
        byte[] bytes = { 97, 98, 99, 100, 101 };
        String s2 = new String(bytes); // 把数值转成对应的字符值
        System.out.println("s2:" + s2);
        System.out.println("s2.length():" + s2.length());
        System.out.println("--------------------------");

        // public String(byte[] bytes,int index,int length):把字节数组中的一部分转成字符串
        // String s3 = new String(bytes, 1, 2);
        String s3 = new String(bytes, 0, bytes.length);
        System.out.println("s3:" + s3);
        System.out.println("s3.length():" + s3.length());
        System.out.println("--------------------------");

        // public String(char[] value):把字符数组转成字符串
        char[] chs = { 'a', 'b', 'c', 'd', 'e', '林', '青', '霞' };
        String s4 = new String(chs);
        System.out.println("s4:" + s4);
        System.out.println("s4.length():" + s4.length());
        System.out.println("--------------------------");

        // public String(char[] value,int index,int count):把字符数组的一部分转成字符串
        // 需求：我要输出的字符串是:de林青
        String s5 = new String(chs, 3, 4);
        System.out.println("s5:" + s5);
        System.out.println("s5.length():" + s5.length());
        System.out.println("--------------------------");

        // public String(String original):把字符串转成字符串
        String s6 = new String("helloworld");
        System.out.println("s6:" + s6);
        System.out.println("s6.length():" + s6.length());
        System.out.println("--------------------------");

        // Java 程序中的所有字符串字面值（如 "abc" ）都作为此类的实例实现。
        String s7 = "helloworld";
        System.out.println("s7:" + s7);
        System.out.println("s7.length():" + s7.length());




        String s = "helloworld";

        // boolean equals(Object obj):比较字符串的内容是否相同，严格区分大小写
        System.out.println("equals():" + s.equals("helloworld"));
        System.out.println("equals():" + s.equals("HelloWorld"));
        System.out.println("----------------------------------");

        // boolean equalsIgnoreCase(String str):比较字符串的内容是否相同，不考虑大小写
        System.out.println("equalsIgnoreCase():"
                + s.equalsIgnoreCase("helloworld"));
        System.out.println("equalsIgnoreCase():"
                + s.equalsIgnoreCase("HelloWorld"));
        System.out.println("----------------------------------");

        // boolean contains(String str):判断是否包含指定的小串
        System.out.println("contains():" + s.contains("owo"));
        System.out.println("contains():" + s.contains("hw"));
        System.out.println("----------------------------------");

        // boolean startsWith(String str):判断是否以指定的字符串开头
        System.out.println("startsWith():" + s.startsWith("hw"));
        System.out.println("startsWith():" + s.startsWith("owo"));
        System.out.println("startsWith():" + s.startsWith("h"));
        System.out.println("----------------------------------");

        // boolean endsWith(String str):判断是否以指定的字符串结尾:自己练习

        // boolean isEmpty():判断字符串的内容是否为空
        System.out.println("isEmpty():" + s.isEmpty());
        // System.out.println("isEmpty():"+null.isEmpty());
        // //错误，对象为null，说明对象不存在，对象不存在，就不能调用方法
        System.out.println("isEmpty():" + "".isEmpty());
    }
}