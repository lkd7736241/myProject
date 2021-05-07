package com.sun.数据结构与算法.assignment;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 实现文件筛选器，在指定位置查询所有符合条件的文件，并输出文件名
 * 输入：
 * 1.文件大小，包括最大值和最小值，单位为KB
 * 2.扩展名
 * 3.文件名
 * 4.最后修改时间，包括搜索起始时间和结束时间
 * 5.文件夹目录
 * 输出：
 * 所有符合条件的文件名称
 * 要求：
 * 筛选器用继承的方式实现
 * create by qiulisun on 2018/12/25.<br>
 */
public class FileFilter {
    public static final String PATH = "E:" + File.separator + "修真院" + File.separator + "日报" + File.separator;

    public static void main(String[] args){

//        boolean flag = existsFile(PATH);
//        if (flag) {
//        	System.out.println("文件存在");
//        } else {
//            System.out.println("文件不存在");
//        }
//
//        File[] files = listFiles(PATH);
//        for (int i = 0; i < files.length; i++) {
//
//            System.out.println(files[i]);
//        }

//        File file = new File(PATH);
//        List<File> files = listDir(file);
//        for (int i = 0; i < files.size(); i++) {
//            System.out.println("文件名 : " + files.get(i).getName() + "; 扩展名 ：" + ext(files.get(i).getName()) +
//                    "; 大小 ：" + files.get(i).length() + "; 最后修改时间 ：" + files.get(i).lastModified());
////            System.out.println(files.get(i).getName());
////            System.out.println(files.get(i).length());
////            System.out.println(files.get(i).lastModified());
//        }

        int maxFileSize = 20;
        int minFileSize = 10;
        String extensionName = "docx";
        String fileName = "20181130";
        Date start = new Date("2018\u200E年\u200E11\u200E月\u200E30\u200E日，\u200F\u200E0:53:03");
        Date end = new Date();
        String folderDirectory = PATH;

        List<String> result = doExists(maxFileSize, minFileSize, extensionName, fileName, start, end, folderDirectory);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    /**
     * 获取文件扩展名
     * @param fileName
     * @return
     */
    public static String ext(String fileName) {

        int index = fileName.lastIndexOf(".");

        if (index == -1) {
            return null;
        }
        String result = fileName.substring(index + 1);
        return result;
    }

    /**
     * 判断某文件是否存在于路径中
     * @return
     */
    public static boolean existsFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 遍历某文件夹中的文件
     * @return
     */
    public static File[] listFiles(String filePath) {
        File file = new File(filePath);
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();

            return files;
        }
        return null;
    }

    /**
     * 遍历某文件夹及其子文件夹中的文件
     * @param file
     * @return
     */
    public static List<File> listDir(File file) {
        List<File> result = new ArrayList<File>();
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) {
                        List<File> subdirectoryFiles = listDir(files[i]);
                        result.addAll(subdirectoryFiles);
                    } else if (files[i].isFile()) {
                    	result.add(files[i]);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 实现文件筛选器，在指定位置查询所有符合条件的文件，并输出文件名
     * @param maxFileSize 文件最大值 单位为KB
     * @param minFileSize 文件最小值 单位为KB
     * @param extension 扩展名
     * @param fileName 文件名
     * @param start 起始时间
     * @param end   结束时间
     * @param folderDirectory 文件夹目录
     * 注：文件最后修改时间在起始时间和结束时间范围内，则符合条件
     * @return
     */
    public static List<String> doExists(int maxFileSize, int minFileSize, String extension,
                             String fileName, Date start, Date end, String folderDirectory) {

        if (fileName == null || folderDirectory == null || extension == null || start == null || end == null) {
            return null;
        }

        //根据路径创建目录
        File file = new File(folderDirectory);
        //遍历得到所有文件
        List<File> files = listDir(file);
        //设置结果集
        List<String> result = new ArrayList<String>();

        if (files == null) {
        	return null;
        }

        //文件名
        String fileNameTemp;
        //扩展名
        String extensionTemp;
        //文件大小
        long fileSizeTemp;
        //最后修改时间
        long lastModifiedTemp;

        for (int i = 0; i < files.size(); i++) {
            fileNameTemp = files.get(i).getName();
            extensionTemp = ext(files.get(i).getName());
            fileSizeTemp = files.get(i).length() / 1024;
            lastModifiedTemp = files.get(i).lastModified();

            if (fileNameTemp.equals(fileName)) {
                if (extensionTemp.equals(extension)) {
                	if (fileSizeTemp >= minFileSize && fileSizeTemp < maxFileSize) {
                		if (lastModifiedTemp >= start.getTime() && lastModifiedTemp < end.getTime()) {
                            result.add(files.get(i).getName());
                		}
                	}
                }
            }
        }

        return result;
    }


}
