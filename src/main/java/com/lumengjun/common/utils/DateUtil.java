package com.lumengjun.common.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * 进行日期操作的类
 * @author ASUS
 *
 */
public class DateUtil{
	
	/*
	* 方法1：
	* 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
	* 则返回的结果为2019-05-01 00:00:00
	*/
	public static Date getDateByInitMonth(Date src){
		GregorianCalendar gc = new GregorianCalendar();
		src.setHours(0);
		gc.set(Calendar.YEAR,1900+src.getYear());//设置年
	    gc.set(Calendar.MONTH, src.getMonth());//这里0是1月..以此向后推
        gc.set(Calendar.DAY_OF_MONTH, 1);//设置天
        gc.set(Calendar.HOUR_OF_DAY,src.getHours());//设置小时
        gc.set(Calendar.MINUTE, 0);//设置分
        gc.set(Calendar.SECOND, 0);//设置秒
		return src=gc.getTime();
	}
	
	public static void main(String[] args) throws ParseException {
			Date date = new Date();
	        GregorianCalendar gc = new GregorianCalendar();
	        gc.set(Calendar.YEAR,2019);//设置年
	        gc.set(Calendar.MONTH, 03);//这里0是1月..以此向后推
	        gc.set(Calendar.DAY_OF_MONTH, 18);//设置天
	        gc.set(Calendar.HOUR_OF_DAY,11);//设置小时
	        gc.set(Calendar.MINUTE, 37);//设置分
	        gc.set(Calendar.SECOND, 22);//设置秒
	        date = gc.getTime();
	        
			Date dateByInitMonth = getDateByFullMonth(date);
			Date dateByInitMonth2 = getDateByInitMonth(date);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String format3 = simpleDateFormat.format(date);
			String format2 = simpleDateFormat.format(dateByInitMonth2);
			String format = simpleDateFormat.format(dateByInitMonth);
			
			System.out.println("未改变的日期"+format3);
			String sql = "select * from t_order where create_time>='"+format2+"' and create_time<='"+format+"' ";
			System.err.println(sql);
	}
	
	/*
	* 方法2：
	* 给任意一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	* 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
	* 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	*/
	public static Date getDateByFullMonth(Date src){
		Calendar cal = Calendar.getInstance();
	    cal.setTime(src);
	    int last = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	    cal.set(Calendar.DAY_OF_MONTH, last);
	    cal.set(Calendar.HOUR_OF_DAY,23);//设置小时
	    cal.set(Calendar.MINUTE, 59);//设置分
	    cal.set(Calendar.SECOND, 59);//设置秒
		return cal.getTime();
	}

}
