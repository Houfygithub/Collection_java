package example.callback;

import java.io.File;
import java.io.IOException;

/**
 * Created by dianrong on 17-2-4.
 */

/*
* 该类演示了Java的回调机制
*
*/


public class Called1 {
    public boolean saveStrToFile(String fileName,String content){
        try{
            File file = getExistsFile(fileName);
            writeStrToFile(content,file);
            return true;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }

    private File getExistsFile(String fileName){

        return new File(fileName);
    }

    private void writeStrToFile(String content,File file){

    }
}
