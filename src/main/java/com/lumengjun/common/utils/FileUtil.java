package com.lumengjun.common.utils;
/**
 * 进行file操作的类
 * @author ASUS
 *
 */
public class FileUtil {

	/*
	* 方法1：给定一个文件名，返回该文件名的扩展名，例如“aaa.jpg”，返回“.jpg”(10分)
	*/
	public static String getExtendName(String fileName){
		int lastIndexOf = fileName.lastIndexOf(".");
		String substring = fileName.substring(lastIndexOf);
		return substring;
	//TODO 实现代码
	}
	
	/*public static void main(String[] args) {
		String msg ="aa.sss.jsp";
		String extendName = getExtendName(msg);
		System.out.println(extendName);
	}*/
	
}
