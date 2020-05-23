package com.xianzw.aoao.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Base64.Decoder;

import org.springframework.web.multipart.MultipartFile;

/**
 * BASE64处理MultipartFile
 * @author xianzw
 * @date 2020年5月8日下午3:24:42
 *
 */
public class BASE64DecodedMultipartFileUtil implements MultipartFile  {

	
	private final byte[] imgContent;
    private final String header;
  
    public BASE64DecodedMultipartFileUtil(byte[] imgContent, String header) {
        this.imgContent = imgContent;
        this.header = header.split(";")[0];
    }
  
    @Override
    public String getName() {
        return System.currentTimeMillis() + Math.random() + "." + header.split("/")[1];
    }
  
    @Override
    public String getOriginalFilename() {
        return System.currentTimeMillis() + (int) Math.random() * 10000 + "." + header.split("/")[1];
    }
  
    @Override
    public String getContentType() {
        return header.split(":")[1];
    }
  
    @Override
    public boolean isEmpty() {
        return imgContent == null || imgContent.length == 0;
    }
  
    @Override
    public long getSize() {
        return imgContent.length;
    }
  
    @Override
    public byte[] getBytes() throws IOException {
        return imgContent;
    }
  
    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(imgContent);
    }
  
    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        new FileOutputStream(dest).write(imgContent);
    }
  
    public static MultipartFile base64ToMultipart(String base64) {
            String[] baseStrs = base64.split(",");
  
            Decoder decoder = Base64.getDecoder();
            
            byte[] b = decoder.decode(baseStrs[1]);
  
            return new BASE64DecodedMultipartFileUtil(b, baseStrs[0]);
    }
	
}
