package yyf256.top.blog.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	private static SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
	/*
	 * 获取2017-01-02 12:00:00这样的字符串时间
	 */
	public static String getNowTime()
	{
		return sdf1.format(new Date());
	}
	/**
	 * 获取系统当前timestamp时间戳
	 * 
	 * @return
	 */
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 获取系统当前date时间戳
	 * 
	 * @return
	 */
	public static Date getCurrentDate() {
		return new Date(System.currentTimeMillis());
	}

	/**
	 * 获取当前月日格式 03-09
	 * 
	 * @return
	 */
	public static String getCurrentMonthDay() {
		Calendar now = Calendar.getInstance();
//		int year = now.get(Calendar.YEAR);
		int month = (now.get(Calendar.MONTH) + 1);
		int day = now.get(Calendar.DAY_OF_MONTH);
		return String.format("%02d", month) + "-" + String.format("%02d", day);
	}

	/**
	 * 字符串转日期
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date strToDate(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(str);
		return date;
	}
	
	
	/**
	 * 字符串转日期
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date strToDate(String str,String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = sdf.parse(str);
		return date;
	}

	/**
	 * 获取昨天年-月-日yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getYesterday() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		// cal.add(5, -1);
		String yesterday = new SimpleDateFormat("yyyy-MM-dd").format(cal
				.getTime());
		return yesterday;
	}

	/**
	 * 获取当前时间对应的昨天时间
	 * 
	 * @return
	 */
	public static Date getYesterDay() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();

	}

	/**
	 * 获取当天日期年-月-日yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getToday() {
		Calendar cal = Calendar.getInstance();
		String today = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		return today;
	}

	/**
	 * 获取昨天年-月-日yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getYesterdayMMdd() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String yesterday = new SimpleDateFormat("MM-dd").format(cal.getTime());
		return yesterday;
	}

	/**
	 * 字符串转日期
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date strToDateTime(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(str);
		return date;
	}

	/**
	 * 获取格式化的当前时间字符串
	 * 
	 * @return
	 */
	public static String getCurrentDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date(System.currentTimeMillis());
		String date = sdf.format(currentTime);
		return date;
	}

	/**
	 * 获取格式化的当前时间字符串
	 * 
	 * @return
	 */
	public static String getCurrentDateStryyyyMMddHHmmss() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date currentTime = new Date(System.currentTimeMillis());
		String date = sdf.format(currentTime);
		return date;
	}

	/**
	 * 日期转字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String DateToStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		String str = sdf.format(date);
		return str;
	}

	public static String DateToStr(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String str = sdf.format(date);
		return str;
	}

	public static String DateToStrCommonFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(date);
		return str;
	}

	public static String DateToStrYMRHMS(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String str = sdf.format(date);
		return str;
	}

	
	/**
	 * 指定字符串日期转换成指定字符串日期
	 * 
	 * @param str
	 * @throws ParseException
	 */
	public static String getFormatDate(String str) throws ParseException {
		Date date = strToDate(str);
		return DateToStr(date);
	}

	/**
	 * 获取当前时间是周几
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekFromDate(Date date) {
		// SimpleDateFormat sdf = new SimpleDateFormat("星期F");
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		String week = sdf.format(date);
		return week;
	}

	/**
	 * 字符串日期中获取周几
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static String getWeekFromStr(String str) throws ParseException {
		Date date = strToDate(str);
		return getWeekFromDate(date);
	}

	/**
	 * 获取时分字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getHourMinute(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String str = sdf.format(date);
		return str;
	}

	/**
	 * 获取时分字符串
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String getHourMinute(String str) throws ParseException {
		Date date = strToDate(str);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String result = sdf.format(date);
		return result;
	}

	/**
	 * 获取当天零时时间
	 * 
	 * @return
	 */
	public static Date getTodayZero() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		//calendar.set(Calendar.HOUR,12);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	/**
	 * 获取明天零点时间
	 * @return
	 */
	public static Date getTomZero() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}
	
	/**
	 * 获取明天零点时间
	 * @return
	 */
	public static Date getTomZero(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}

	/**
	 * 获取当前小时数，24
	 * 
	 * @return
	 */
	public static int getHour24() {

		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		return hour;
	}

	// public static void main(String[] args) {
	//
	// }
	/*
	 * 获取两个时间的时间差，数组一次为，天，小时，分钟，秒
	 */
	public static Long[] getTimeDEC(Date d1,Date d2)
	{
		long l=d1.getTime()-d2.getTime();
		long day=l/(24*60*60*1000);
		long hour=(l/(60*60*1000)-day*24);
		long min=((l/(60*1000))-day*24*60-hour*60);
		long s=(l/1000-day*24*60*60-hour*60*60-min*60);
		System.out.println(""+day+"天"+hour+"小时"+min+"分"+s+"秒");
		return new Long[]{day,hour,min,s};
	}
	
		/**
	 * 时间加减计算+1-1
	 * @param date 当前时间
	 * @param i   变量 +1加一天 -1减一天
	 * @return
	 */
    public static Date getNextDay(Date date,int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, i);
		date = calendar.getTime();
		return date;
	}
    
	/**
	 * 时间加减计算+1-1
	 * @param date 当前时间
	 * @param i   变量 +1加一小时 -1减一小时
	 * @return
	 */
    public static Date getNextHour(Date date,int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, i);
		date = calendar.getTime();
		return date;
	}
	
	    /**
     * 计算时间差
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 天数
     */
    public static long getbetweenDays(Date startDate,Date endDate){
    	long beginTime = startDate.getTime();
    	long endTime = endDate.getTime();
    	long betweenDays = (long)(((endTime - beginTime) % (1000 * 60 * 60 *24)==0)?
    			(endTime - beginTime) / (1000 * 60 * 60 *24):((endTime - beginTime) / (1000 * 60 * 60 *24)+1));
		return betweenDays; 
    }
    
    /**
     * 计算时间差
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 小时
     */
    public static long getbetweenHHs(Date startDate,Date endDate){
    	long beginTime = startDate.getTime();
    	long endTime = endDate.getTime();
    	long betweenDays = (long)((endTime - beginTime) / (1000 * 60 * 60));
		return betweenDays; 
    }
    
    /**
     * 计算时间差
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 秒数
     */
    public static long getbetweentimes(Date startDate,Date endDate){
    	long beginTime = startDate.getTime();
    	long endTime = endDate.getTime();
    	long betweenDays = (long)((endTime - beginTime) / 1000);
		return betweenDays; 
    }
	
		/**
	 * 判断两个日期是否同一天
	 * 
	 * @param oneDate
	 * @param twoDate
	 * @return
	 */
	public static boolean isSameDay(Date oneDate, Date twoDate) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(oneDate);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(twoDate);

		return isSameDay(c1, c2);
	}
	
		/**
	 * 判断两个日期是否同一天
	 * 
	 * @param one
	 * @param two
	 * @return
	 */
	public static boolean isSameDay(Calendar one, Calendar two) {
		return ((one.get(Calendar.YEAR) == two.get(Calendar.YEAR))
				&& (one.get(Calendar.DAY_OF_YEAR) == two.get(Calendar.DAY_OF_YEAR)));
	}
	
	@SuppressWarnings("static-access")
	public static Date getthisMonday(Date cur){
		Calendar cal=Calendar.getInstance();
		cal.setTime(cur);
		cal.set(cal.DAY_OF_WEEK, cal.MONDAY);
		cal.set(cal.SECOND, 0);
		cal.set(cal.HOUR_OF_DAY, 0);
		cal.set(cal.MINUTE, 0);
		return cal.getTime();
	}
	
	@SuppressWarnings("static-access")
	public static Date getthisSunday(Date cur){
		Calendar cal=Calendar.getInstance();
		cal.setTime(cur);
		cal.set(cal.DAY_OF_WEEK,cal.SUNDAY);
		cal.set(cal.SECOND, 0);
		cal.set(cal.HOUR_OF_DAY, 0);
		cal.set(cal.MINUTE, 0);
		cal.add(cal.DAY_OF_YEAR, 8);//外国人认为周日为一周的开始，所以我们的本周末其实是外国人的下周末，所有要加8
		return cal.getTime();
	}
	
	public static Date getMonthFirstDay(Date cur){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		String monthfirst=sdf.format(cur);
		try {
			return sdf.parse(monthfirst);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getCurrentTime() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	
//
//	public static void main(String[] args) throws ParseException {
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////		System.out.println(sdf.format(getthisMonday(sdf.parse("2018-02-01 00:00:00"))));
////		System.out.println(sdf.format(getthisSunday(sdf.parse("2018-02-01 00:00:00"))));
////		System.out.println(getbetweenDays(sdf.parse("2018-01-31 00:00:00"),sdf.parse("2018-02-01 06:00:00")));
////		System.out.println(getNextDay(sdf.parse("2017-12-31 06:00:00"), 2));
////		System.out.println(sdf.format(getMonthFirstDay(sdf.parse("2017-12-31 06:00:00"))));
//		System.out.println(getbetweenDays(getTodayZero(), new Date()));
//	}
	
}