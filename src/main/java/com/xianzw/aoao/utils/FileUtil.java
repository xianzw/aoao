package com.xianzw.aoao.utils;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 文件操作工具
 * @description: 
 * @author: xianzw
 * @time: 2019年5月14日上午10:52:14
 */
public class FileUtil {
	
	private static final int  BUFFER_SIZE = 2 * 1024;


	/**
	* @Description:  复制文件
	* @Param: [source, dest]
	* @return: void
	* @Author: glenn
	* @Date: 2019/6/13
	*/
    public static void copyFileUsingFileChannels(File source, File dest) throws IOException {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } finally {
            inputChannel.close();
            outputChannel.close();
        }

    }

	 /**
     * 将文件压缩为zip
     * @Description:   
     * @param: @param srcFiles 压缩的文件列表
     * @param: @param out zip文件输出流
     * @param: @throws RuntimeException      
     * @return: void      
     * @throws
     */
    public static void toZip(List<File> srcFiles , OutputStream out)throws RuntimeException {
   
        long start = System.currentTimeMillis();
   
        ZipOutputStream zos = null ;
   
        try {
   
            zos = new ZipOutputStream(out);
   
            for (File srcFile : srcFiles) {
   
                byte[] buf = new byte[BUFFER_SIZE];
   
                zos.putNextEntry(new ZipEntry(srcFile.getName()));
   
                int len;
   
                FileInputStream in = new FileInputStream(srcFile);
   
                while ((len = in.read(buf)) != -1){
   
                    zos.write(buf, 0, len);
   
                }
   
                zos.closeEntry();
   
                in.close();
   
            }
   
            long end = System.currentTimeMillis();
   
            System.out.println("压缩完成，耗时：" + (end - start) +" ms");
   
        } catch (Exception e) {
   
            throw new RuntimeException("zip error from ZipUtils",e);
   
        }finally{
   
            if(zos != null){
   
                try {
   
                    zos.close();
   
                } catch (IOException e) {
   
                    e.printStackTrace();
   
                }
   
            }
   
        }
   
    }



    public static void toZip(String srcDir, OutputStream out, boolean KeepDirStructure)
            throws RuntimeException {


        long start = System.currentTimeMillis();

        ZipOutputStream zos = null;

        try {

            zos = new ZipOutputStream(out);

            File sourceFile = new File(srcDir);

            compress(sourceFile, zos, sourceFile.getName(), KeepDirStructure);

            long end = System.currentTimeMillis();

            System.out.println("压缩完成，耗时：" + (end - start) + " ms");

        } catch (Exception e) {

            throw new RuntimeException("zip error from ZipUtils", e);

        } finally {

            if (zos != null) {

                try {

                    zos.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

        }

    }


    /**
     * 递归压缩方法
     *
     * @param sourceFile       源文件
     * @param zos              zip输出流
     * @param name             压缩后的名称
     * @param KeepDirStructure 是否保留原来的目录结构,true:保留目录结构;
     *                         <p>
     *                         false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
     * @throws Exception
     */

    private static void compress(File sourceFile, ZipOutputStream zos, String name,

                                 boolean KeepDirStructure) throws Exception {

        byte[] buf = new byte[BUFFER_SIZE];

        if (sourceFile.isFile()) {

            // 向zip输出流中添加一个zip实体，构造器中name为zip实体的文件的名字

            zos.putNextEntry(new ZipEntry(name));

            // copy文件到zip输出流中

            int len;

            FileInputStream in = new FileInputStream(sourceFile);

            while ((len = in.read(buf)) != -1) {

                zos.write(buf, 0, len);

            }

            // Complete the entry

            zos.closeEntry();
            in.close();

        } else {

            File[] listFiles = sourceFile.listFiles();

            if (listFiles == null || listFiles.length == 0) {

                // 需要保留原来的文件结构时,需要对空文件夹进行处理

                if (KeepDirStructure) {

                    // 空文件夹的处理

                    zos.putNextEntry(new ZipEntry(name + "/"));

                    // 没有文件，不需要文件的copy

                    zos.closeEntry();

                }

            } else {

                for (File file : listFiles) {
                    // 判断是否需要保留原来的文件结构

                    if (KeepDirStructure) {

                        // 注意：file.getName()前面需要带上父文件夹的名字加一斜杠,

                        // 不然最后压缩包中就不能保留原来的文件结构,即：所有文件都跑到压缩包根目录下了

                        compress(file, zos, name + "/" + file.getName(), KeepDirStructure);

                    } else {

                        compress(file, zos, file.getName(), KeepDirStructure);

                    }

                }

            }

        }

    }

    /**
     * 复制整个文件夹内容
     *
     * @param oldPath String 原文件路径 如：c:/fqf
     * @param newPath String 复制后路径 如：f:/fqf/ff
     * @return boolean
     */
    public static void copyFolder(String oldPath, String newPath) {

        try {
            (new File(newPath)).mkdirs(); //如果文件夹不存在 则建立新文件夹
            File a = new File(oldPath);
            String[] file = a.list();
            File temp = null;
            for (int i = 0; i < file.length; i++) {
                if (oldPath.endsWith(File.separator)) {
                    temp = new File(oldPath + file[i]);
                } else {
                    temp = new File(oldPath + File.separator + file[i]);
                }

                if (temp.isFile()) {
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath + "/" +
                            (temp.getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                if (temp.isDirectory()) {//如果是子文件夹
                    copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("复制整个文件夹内容操作出错");
            e.printStackTrace();

        }

    }
}
