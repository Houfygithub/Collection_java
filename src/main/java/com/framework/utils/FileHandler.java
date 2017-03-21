import com.csvreader.CsvReader;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by dianrong on 17-3-3.
 */
public class FileHandler {





    /**
     * 线性读取Txt文件.
     * @version = 1.0
     */
    public static void readTxtFile(String filePath) throws FileNotFoundException{

        try {
            String encoding = "GBK";
            File file = new File(filePath);

            if (file.exists() && file.isFile()){//判断文件是否存在
                InputStreamReader   reader = new InputStreamReader(new FileInputStream(file),encoding); //指定编码格式
                BufferedReader bufferedReader = new BufferedReader(reader);
                String lineText = null;
                while ((lineText = bufferedReader.readLine()) != null){
                    System.out.println(lineText);

                }
                bufferedReader.close();

            }else {
                System.out.println("找不到指定文件");
            }

        }catch (Exception e){
            System.out.println("读取文件内容报错");
            e.printStackTrace();
        }
    }

    /**
     * 读取CSV文件
     *  @version =1.0
     *  CSV jar包下载地址: http://sourceforge.net/projects/javacsv/files
    */
    public static void readCsvFile(String filePath){

        try{
            ArrayList<String[]> csvLists = new ArrayList<String[]>();  //保存文件数据

            CsvReader reader = new CsvReader(filePath,',', Charset.forName("SJIS"));
            reader.readHeaders();  //跳过表头

            while (reader.readRecord()){ //逐行读取表头外的数据
                csvLists.add(reader.getValues());
            }
            reader.close();

            for (int row=0; row < csvLists.size(); row++){
                System.out.println(csvLists.get(row)[0]);  //name
                System.out.println(csvLists.get(row)[1]);  //email
                System.out.println(csvLists.get(row)[2]);  //age
                System.out.println(csvLists.get(row)[3]);  //sex
                System.out.println("------------------");  //分割线
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    /*
    * 读取XML文件
    * @version=1.0
    * XML依赖包
    * import org.w3c.dom.Document;
    *import org.w3c.dom.NodeList;
    *import javax.xml.parsers.DocumentBuilder;
    *import javax.xml.parsers.DocumentBuilderFactory;
    */
    public static void readXmlFile(String filePath){
        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory factory = new DocumentBuilderFactory() {
                public DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
                    return null;
                }

                public void setAttribute(String name, Object value) throws IllegalArgumentException {

                }

                public Object getAttribute(String name) throws IllegalArgumentException {
                    return null;
                }

                public void setFeature(String name, boolean value) throws ParserConfigurationException {

                }

                public boolean getFeature(String name) throws ParserConfigurationException {
                    return false;
                }
            };
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            NodeList nodeList = doc.getElementsByTagName("Login");
            System.out.println("结点名称: "+ nodeList.item(0).getNodeName());
            System.out.println("结点类型: "+ nodeList.item(0).getNodeType());
            System.out.println("结点值: "+ nodeList.item(0).getNodeValue());

            System.out.println("元素的属性: "+ nodeList.item(0).getAttributes().getNamedItem("username"));

            System.out.println("标签对间数据: "+ nodeList.item(0).getTextContent());




        }catch (Exception e){
            e.printStackTrace();
        }
    }








}
