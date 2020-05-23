package com.xianzw.aoao.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.xianzw.aoao.common.BusinessException;

/**
 * @version V1.0
 * @className: HttpUtil
 * @description: http请求工具
 * @author: glenn
 * @create: 2019-08-02 13:42
 **/
public class HttpUtil {

    public static final String LEI_URL = "https://leilookup.gleif.org/api/v2/leirecords?lei=";

    //lei例子
    public static final String LEI_CODE="529900UDELW6LZZHUI29";

    // HTTP post请求
    public static String post(String URL, String parm) {

        HttpURLConnection conn = null;
        // 数据输出流，输出参数信息
        DataOutputStream dataOut = null;
        // 数据输入流，处理服务器响应数据
        BufferedReader dataIn = null;

        try {
            java.net.URL url = new java.net.URL(URL);

            // 将url以open方法返回的urlConnection连接强转为HttpURLConnection连接(标识一个url所引用的远程对象连接)
            // 此时cnnection只是为一个连接对象,待连接中
            conn = (HttpURLConnection) url.openConnection();

            // 设置连接输出流为true,默认false (post请求是以流的方式隐式的传递参数)
            conn.setDoOutput(true);
            // 设置连接输入流为true
            conn.setDoInput(true);
            // 设置请求方式为post
            conn.setRequestMethod("GET");
            // post请求缓存设为false
            conn.setUseCaches(false);
            // 设置该HttpURLConnection实例是否自动执行重定向
            conn.setInstanceFollowRedirects(true);

            // 设置内容的类型,设置为经过urlEncoded编码过的from参数
            conn.setRequestProperty("Content-Type", "application/xml");
            conn.setRequestProperty("accept", "application/xml");
            // conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;
            // MSIE 6.0; Windows NT 5.1;SV1)");

            // 建立连接
            // (请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行)
            conn.connect();

            // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)
            dataOut = new DataOutputStream(conn.getOutputStream());
            // 将参数输出到连接
            dataOut.writeBytes(parm != null ? parm : "");
            // 输出完成后刷新并关闭流
            dataOut.flush();

            // 连接发起请求,处理服务器响应 (从连接获取到输入流并包装为bufferedReader)
            dataIn = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            // 用来存储响应数据
            StringBuilder sb = new StringBuilder();
            // 循环读取流
            while ((line = dataIn.readLine()) != null) {
                sb.append(line).append(System.getProperty("line.separator"));
            }
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 重要且易忽略步骤 (关闭流,切记!)
                if (dataOut != null) {
                    dataOut.close();
                }
                if (dataIn != null) {
                    dataIn.close();
                }
                // 销毁连接
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    // HTTP GET请求
    public static String sendGet(String url) throws IOException, BusinessException {


        URL obj = new URL(url);
        HttpURLConnection con = null;
        con = (HttpURLConnection) obj.openConnection();


        //默认值我GET
        con.setRequestMethod("GET");

        //添加请求头
        // 设置内容的类型,设置为经过urlEncoded编码过的from参数
        con.setRequestProperty("Content-Type", "application/xml");
        con.setRequestProperty("accept", "application/xml");

        if (con.getResponseCode() == 400) {
            throw new BusinessException("700002","LEI验证失败");//LEI验证失败
        }

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //打印结果
        return response.toString();

    }

}
