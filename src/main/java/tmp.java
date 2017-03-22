import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class tmp{


    /**
     * @Description:发送get请求保存下载文件
     * @author:houfy
     * @time:2017年03月12日 下午3:27:29
     */
    public static void sendGetAndSaveFile(String urlParam, Map<String,Object> params, String fileSavePath){



        //构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params !=null && params.size() > 0){
            for (Map.Entry<String,Object> e:params.entrySet()){
                sbParams.append(e.getKey());
                sbParams.append("=");
                sbParams.append(e.getValue());
                sbParams.append("&");
            }
        }

        HttpURLConnection con = null;
        BufferedReader br = null;
        FileOutputStream fos = null;

        try {
            URL url = null;
            if (sbParams !=null && sbParams.length() > 0){
                url = new URL(urlParam + "?" + sbParams.substring(0,sbParams.length()-1));
            }else{
                url = new URL(urlParam);
            }
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            con.connect();
            InputStream in = con.getInputStream();
            fos = new FileOutputStream(fileSavePath);
            byte[] buf =new byte[1024];
            int len = 0;
            while ((len = in.read(buf)) != -1){
                fos.write(buf,0,len);
            }
            fos.flush();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if (fos != null){
                try{
                    fos.close();
                }catch (IOException e){
                    fos = null;
                    throw new RuntimeException(e);
                }finally {
                    if (con !=null){
                        con.disconnect();
                        con = null;
                    }
                }
            }
        }
    }

    public static String sendGet(String urlParam, Map<String,Object> params,String charset){
        StringBuffer resultBuffer = null;

        //构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params !=null && params.size() > 0){
            for (Map.Entry<String,Object> e : params.entrySet()){
                sbParams.append(e.getKey());
                sbParams.append("=");
                sbParams.append(e.getValue());
                sbParams.append("&");
            }
       }

       HttpURLConnection con = null;
       BufferedReader br = null;

       try {
           //构建URL
           URL url = null;
           if (sbParams !=null && sbParams.length() > 0){
               url = new URL(urlParam + "?" + sbParams.substring(0,sbParams.length()-1));
           }else{
               url = new URL(urlParam);
           }

            //构建请求，发送请求
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type","x-www-form-urlencoded");
            con.connect();
            //接收响应
            resultBuffer = new StringBuffer();
            br = new BufferedReader(new InputStreamReader(con.getInputStream(),charset));
            String temp;

            while ((temp = br.readLine()) !=null){
                resultBuffer.append(temp);
            }
       }catch (Exception e){
           throw new RuntimeException(e);
       }finally {
            if(br !=null){
                try {
                    br.close();
                }catch (IOException e){
                    br = null;
                    throw new RuntimeException(e);
                }finally {
                    if (con != null){
                        con.disconnect();
                        con = null;
                    }
                }
            }
       }
       return resultBuffer.toString();
    }


/**
 * @Description: 使用URLConnection发送GET请求
 * @author houfy
 * @time: 2017年03月12日 下午3:27:58
 */
    public static String sendGet2(String urlParam,Map<String,Object> params,String charset){
        StringBuffer resultBuffer = null;
        //构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if(params !=null && params.size() > 0){
            for (Map.Entry<String,Object> e: params.entrySet()){
                sbParams.append(e.getKey());
                sbParams.append("=");
                sbParams.append(e.getValue());
                sbParams.append("&");
            }
        }

        URLConnection con = null;
        BufferedReader br = null;

        try {
            //构建URL地址
            URL url = null;
            if (sbParams != null & sbParams.length() > 0){
                url = new URL(urlParam + "?" + sbParams.substring(0,sbParams.length() -1));
            }else {
                url = new URL(urlParam);
            }

            con = url.openConnection();
            //设置请求属性
            con.setRequestProperty("Content-Type","x-www-form-urlencoded");
            con.setRequestProperty("accept","*/*");
            con.setRequestProperty("connection","Keep-Alive");
            con.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            //建立连接
            con.connect();
            //读取响应
            resultBuffer = new StringBuffer();
            br = new BufferedReader(new InputStreamReader(con.getInputStream(),charset));
            String temp;
            while ((temp = br.readLine()) != null){
                resultBuffer.append(temp);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if (br != null){
                try{
                    br.close();
                }catch (IOException e){
                    br = null;
                    throw new RuntimeException(e);
                }
            }
        }
        return resultBuffer.toString();
    }

    /**
     * @Description:使用HttpClient发送post请求
     * @author:houfy
     * @time:2017年03月12日 下午3:28:23
     */













}