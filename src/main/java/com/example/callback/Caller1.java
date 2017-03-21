package example.callback;

/**
 * Created by dianrong on 17-2-4.
 */

/*
* 该类演示了Java的回调机制
*
*/

public class Caller1 {
    public void saveStr(){
        String fileName = "文件名称";
        String content = "文件内容";

        Called1 cled1 = new Called1();
        boolean isSave = cled1.saveStrToFile(fileName,content);
        System.out.println(isSave?"保存成功":"保存失败");
    }
}
