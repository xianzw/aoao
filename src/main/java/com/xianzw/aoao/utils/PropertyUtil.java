package com.xianzw.aoao.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Desc:properties文件获取工具类
 * @description: 
 * @author: xianzw
 * @time: 2019年3月14日上午11:01:42
 */
public class PropertyUtil {
	
    private static final Logger logger = LoggerFactory.getLogger(PropertyUtil.class);
    private static Properties config;//config
    private static Properties resultMessage_en_US;//resultMessage_en_US
    private static Properties resultMessage_zh_CN;//resultMessage_zh_CN
    private static Properties activeMqConfig;//resultMessage_zh_CN
    
    public static final String FILEPATH = "filePath";
    
    static{
//        loadconfig();
//        loadActiveMqConfig();
//        loadresultMessage_en_US();
//        loadresultMessage_zh_CN();
    }

    synchronized static private void loadconfig(){
        logger.info("开始加载properties文件内容.......");
        config = new Properties();
        InputStream in = null;
        try {
            in = PropertyUtil.class.getClassLoader().getResourceAsStream("config.properties");
            config.load(in);
        } catch (FileNotFoundException e) {
            logger.error("jdbc.properties文件未找到");
        } catch (IOException e) {
            logger.error("出现IOException");
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error("jdbc.properties文件流关闭出现异常");
            }
        }
        logger.info("加载properties文件内容完成...........");
        logger.info("properties文件内容：" + config);
    }
    
    synchronized static private void loadActiveMqConfig(){
    	logger.info("开始加载properties文件内容.......");
    	activeMqConfig = new Properties();
    	InputStream in = null;
    	try {
    		in = PropertyUtil.class.getClassLoader().getResourceAsStream("activeMQ.properties");
    		activeMqConfig.load(in);
    	} catch (FileNotFoundException e) {
    		logger.error("jdbc.properties文件未找到");
    	} catch (IOException e) {
    		logger.error("出现IOException");
    	} finally {
    		try {
    			if(null != in) {
    				in.close();
    			}
    		} catch (IOException e) {
    			logger.error("jdbc.properties文件流关闭出现异常");
    		}
    	}
    	logger.info("加载properties文件内容完成...........");
    	logger.info("properties文件内容：" + activeMqConfig);
    }
    
    synchronized static private void loadresultMessage_en_US(){
    	logger.info("开始加载properties文件内容.......");
    	resultMessage_en_US = new Properties();
    	InputStream in = null;
    	try {
    		in = PropertyUtil.class.getClassLoader().getResourceAsStream("message/resultMessage_en_US.properties");
    		resultMessage_en_US.load(in);
    	} catch (FileNotFoundException e) {
    		logger.error("jdbc.properties文件未找到");
    	} catch (IOException e) {
    		logger.error("出现IOException");
    	} finally {
    		try {
    			if(null != in) {
    				in.close();
    			}
    		} catch (IOException e) {
    			logger.error("jdbc.properties文件流关闭出现异常");
    		}
    	}
    	logger.info("加载properties文件内容完成...........");
    	logger.info("properties文件内容：" + resultMessage_en_US);
    }
    synchronized static private void loadresultMessage_zh_CN(){
    	logger.info("开始加载properties文件内容.......");
    	resultMessage_zh_CN = new Properties();
    	InputStream in = null;
    	try {
    		in = PropertyUtil.class.getClassLoader().getResourceAsStream("message/resultMessage_zh_CN.properties");
    		resultMessage_zh_CN.load(in);
    	} catch (FileNotFoundException e) {
    		logger.error("jdbc.properties文件未找到");
    	} catch (IOException e) {
    		logger.error("出现IOException");
    	} finally {
    		try {
    			if(null != in) {
    				in.close();
    			}
    		} catch (IOException e) {
    			logger.error("jdbc.properties文件流关闭出现异常");
    		}
    	}
    	logger.info("加载properties文件内容完成...........");
    	logger.info("properties文件内容：" + resultMessage_zh_CN);
    }

    //根据key获取activeMqConfig值
    public static String getActiveMqConfig(String key){
    	if(null == config) {
    		loadconfig();
    	}
    	return config.getProperty(key);
    }
    //根据key获取config值
    public static String getConfigProperty(String key){
        if(null == config) {
            loadconfig();
        }
        return config.getProperty(key);
    }

    //根据key获取resultMessage_en_US值
    public static String getResultMessage_en_USProperty(String key){
    	 if(null == resultMessage_en_US) {
    		 loadresultMessage_en_US();
         }
         return resultMessage_en_US.getProperty(key);
    	
    }
    //根据key获取resultMessage_zh_CN值
    public static String getResultMessage_zh_CNProperty(String key){
    	if(null == resultMessage_zh_CN) {
    		loadresultMessage_zh_CN();
    	}
    	return resultMessage_zh_CN.getProperty(key);
    	
    }
    
}