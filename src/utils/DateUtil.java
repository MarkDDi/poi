package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;

/**
 * 日期工具类.
 */
public class DateUtil {

	private static final ThreadLocal<Map<String, SimpleDateFormat>> threadLocal = new ThreadLocal<Map<String,SimpleDateFormat>>();
	
	public static SimpleDateFormat getFormat(String pattern) {
		Map<String, SimpleDateFormat> formats = threadLocal.get();
		if (formats == null) {
			formats = new HashMap<String, SimpleDateFormat>();
		}
		SimpleDateFormat sdf = formats.get(pattern);
		if (sdf == null) {
			sdf = new SimpleDateFormat(pattern);
			formats.put(pattern, sdf);
			threadLocal.set(formats);
		}
		
		return sdf;
	}
	
    public static Date getEndOfDay() {
        return getEndOfDay(new Date());
    }

    public static Date getEndOfDay(Date date) {
        if (date == null) {
        	date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }
    
    /**
     * 获得指定日期的最后一天
     *
     * @param date
     * @return
     */
    public static Date endDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, value);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 000);
        return cal.getTime();
    }
  
    public static Date getBeginOfDay(Date date) {
        if (date == null) {
        	date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 000);
        return calendar.getTime();
    }

    public static Date getBeginOfDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 000);
        return calendar.getTime();
    }

    public static Date getBeginOfYear() {
    	return getBeginOfYear(null);
    }
    
    public static Date getBeginOfYear(Date date) {
    	Calendar calendar = Calendar.getInstance();
    	if (date != null) {
    		calendar.setTime(date);
    	}
    	calendar.set(Calendar.MONTH, Calendar.JANUARY);
    	calendar.set(Calendar.DAY_OF_MONTH, 1);
    	calendar.set(Calendar.HOUR_OF_DAY, 0);
    	calendar.set(Calendar.MINUTE, 0);
    	calendar.set(Calendar.SECOND, 0);
    	calendar.set(Calendar.MILLISECOND, 000);
    	return calendar.getTime();
    }

    public static Date getBeginOfYear(int year) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(Calendar.YEAR, year);
    	calendar.set(Calendar.MONTH, Calendar.JANUARY);
    	calendar.set(Calendar.DAY_OF_MONTH, 1);
    	calendar.set(Calendar.HOUR_OF_DAY, 0);
    	calendar.set(Calendar.MINUTE, 0);
    	calendar.set(Calendar.SECOND, 0);
    	calendar.set(Calendar.MILLISECOND, 000);
    	return calendar.getTime();
    }

    public static Date getEndOfYear() {
    	return getEndOfYear(null);
    }
    
    public static Date getEndOfYear(Date date) {
    	Calendar calendar = Calendar.getInstance();
    	if (date != null) {
    		calendar.setTime(date);
    	}
    	calendar.set(Calendar.MONTH, Calendar.DECEMBER);
    	calendar.set(Calendar.DAY_OF_MONTH, 31);
    	calendar.set(Calendar.HOUR_OF_DAY, 23);
    	calendar.set(Calendar.MINUTE, 59);
    	calendar.set(Calendar.SECOND, 59);
    	calendar.set(Calendar.MILLISECOND, 999);
    	return calendar.getTime();
    }

    public static Date getEndOfYear(int year) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(Calendar.YEAR, year);
    	calendar.set(Calendar.MONTH, Calendar.DECEMBER);
    	calendar.set(Calendar.DAY_OF_MONTH, 31);
    	calendar.set(Calendar.HOUR_OF_DAY, 23);
    	calendar.set(Calendar.MINUTE, 59);
    	calendar.set(Calendar.SECOND, 59);
    	calendar.set(Calendar.MILLISECOND, 999);
    	return calendar.getTime();
    }

    /**
     * 
     * 获取当前的日期
     *
     * @return
     * 
     * @author yaoqiang
     * @date 2015年3月9日 下午3:56:19
     */
    public static Date getNowDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 000);
        return calendar.getTime();
    }
    
    
    /*
     *
     * n天后的结束时间
     *
     * @return
     */
    public static Date getEndExpiredDate(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, +n);
        Date date = DateUtil.getEndOfDay(cal.getTime());
        return date;
    }

    /**
     * n天后的开始时间
     *
     * @return
     */
    public static Date getBeginExpiredDate(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, +n);
        Date date = DateUtil.getBeginOfDay(cal.getTime());
        return date;
    }

    public static Date getYesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 得到本月的第一天
     *
     * @return
     */
    public static Date firstDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar
                .getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 000);
        return calendar.getTime();
    }
    
    /**
     * 得到指定日期的第一天
     *
     * @return
     */
    public static Date firstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar
                .getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 000);
        return calendar.getTime();
    }

    /**
     * 获得指定日期的最后一天
     *
     * @param date
     * @return
     */
    public static Date lastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, value);
        return cal.getTime();
    }
    
    /**
     * 根据年月获得月初日期
     */
    public static Date firstDayOfMonth(Integer year,Integer month){
    	Calendar cal = Calendar.getInstance();
    	cal.set(Calendar.YEAR, year);
    	cal.set(Calendar.MONTH, month-1);
    	cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
    	cal.set(Calendar.HOUR_OF_DAY, 0);
    	cal.set(Calendar.MINUTE, 0);
    	cal.set(Calendar.SECOND, 0);
    	cal.set(Calendar.MILLISECOND, 000);
    	return cal.getTime();
    }
    
    /**
     * 根据年月获得月末日期
     */
    public static Date lastDayOfMonth(Integer year,Integer month){
    	Calendar cal = Calendar.getInstance();
    	cal.set(Calendar.YEAR, year);
    	cal.set(Calendar.MONTH, month-1);
    	cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
    	cal.set(Calendar.HOUR_OF_DAY, 0);
    	cal.set(Calendar.MINUTE, 0);
    	cal.set(Calendar.SECOND, 0);
    	cal.set(Calendar.MILLISECOND, 000);
    	return cal.getTime();
    }

    /**
     * 获得某一年某一季度的最后一天日期
     * 
     * @param year 年份
     * @param quarter 季度（1/2/3/4）
     * @return
     *
     * @author Albert
     * @date 2014年1月23日 上午9:30:00
     */
    public static Date lastDayOfQuarter(Integer year, Integer quarter) {
    	if (quarter < 1 || quarter > 4) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        if (year != null && year > 0) {
            cal.set(Calendar.YEAR, year);
        }
        if (quarter == 1) {
            cal.set(Calendar.MONTH, 3);
        } else if (quarter == 2) {
            cal.set(Calendar.MONTH, 6);
        } else if (quarter == 3) {
            cal.set(Calendar.MONTH, 9);
        } else {
            cal.set(Calendar.MONTH, 12);
        } 
//      cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        //这里不再使用cal.getActualMaximum方法，而是采用现获取下个月的第一天，再减一天。
        cal.set(Calendar.DAY_OF_MONTH, 1);//设置该月1号
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 000);
        cal.add(Calendar.DATE, -1);//使用add减一天
        return cal.getTime();
    }
    
    /**
     * 获得某一年某一季度的第一天日期
     */
    public static Date firstDayOfQuarter(Integer year,Integer quarter) {
    	if (quarter < 1 || quarter > 4) {
    		return null;
    	}
    	Calendar cal = Calendar.getInstance();
    	if (year != null && year > 0) {
    		cal.set(Calendar.YEAR, year);
    	}
    	if (quarter == 1) {
    		cal.set(Calendar.MONTH, 0);
    	} else if (quarter == 2) {
    		cal.set(Calendar.MONTH, 3);
    	} else if (quarter == 3) {
    		cal.set(Calendar.MONTH, 6);
    	} else {
    		cal.set(Calendar.MONTH, 9);
    	}
    	cal.set(Calendar.DAY_OF_MONTH, 1);
    	cal.set(Calendar.HOUR_OF_DAY, 0);
    	cal.set(Calendar.MINUTE, 0);
    	cal.set(Calendar.SECOND, 0);
    	cal.set(Calendar.MILLISECOND, 000);
    	return cal.getTime();
    }
    
    /**
     * 判断是否还有7天到期
     *
     * @param date 截止日期
     * @return true false
     * @throws java.text.ParseException
     */

    public static boolean getDiffDate(Date date) {
        long dateRange = diffDay(date);
        if (dateRange == 7) {
            return true;
        }

        return false;
    }

    /**
     * 当前时间
     *
     * @return
     */
    public static String getNowTime() {

        Calendar c = Calendar.getInstance();
        String nowTime = c.get(Calendar.MONTH) + 1 + "月" + c.get(Calendar.DATE) + "日" + c.get(Calendar.HOUR_OF_DAY) + "时" + c
                .get(Calendar.MINUTE) + "分";

        return nowTime;
    }

    public static Long diffDay(Date date) {
        long dateRange = 0l;
        String now = getFormat("yyyy-MM-dd").format(new Date());
        Date sysDate = null;
        try {
            sysDate = getFormat("yyyy-MM-dd").parse(now);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dateRange = date.getTime() - sysDate.getTime();
        long time = 1000 * 3600 * 24; //A day in milliseconds
        return dateRange / time;
    }


    /**
     * 日期转化成字符串
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, days);
        return getFormat("yyyy-MM-dd").format(cal.getTime());
    }

    /**
     * 字符串转化成日期
     *
     * @param sDate         日期字符串
     * @param formatPattern 转化格式
     * @return
     */
    public static Date stringToDate(String sDate, String formatPattern) {
        if (sDate == null || "".equals(sDate.trim())) {
            return null;
        }
        Date date = null;
        try {
            date = getFormat(formatPattern).parse(sDate);
        } catch (Exception e) {
        	return null;
        }
        return date;
    }

    /**
     * 字符串转化成日期
     *
     * @param date          日期字符串
     * @param formatPattern 转化格式
     * @return
     */
    public static String dateToString(Date date, String formatPattern) {
    	if (date == null) {
    		return null;
    	}
        return getFormat(formatPattern).format(date);
    }

    /**
     * 
     * 日期转数字
     *
     * @param date
     * @return
     * 
     * @author yaoqiang
     * @date 2015年1月20日 下午5:08:54
     */
    public static Integer dateToInteger(Date date){
    	String result = dateToString(date,"yyyyMMdd");
    	if(result != null && StringUtils.isNotBlank(result)){
    		return Integer.parseInt(result);
    	}
    	return null;
    }
    
    /**
     * 
     * 日期转数字
     *
     * @param date
     * @param dateFormat
     * @return
     * 
     * @author lisl
     * @date 2016年3月31日 下午2:44:57
     */
    public static Integer dateToInteger(Date date, String dateFormat){
    	String result = dateToString(date, dateFormat);
    	if(result != null && StringUtils.isNotBlank(result)){
    		return Integer.parseInt(result);
    	}
    	return null;
    }
    
    /**
     * 
     * yyyyMMdd格式数字转日期
     *
     * @param date
     * @return
     * 
     * @author yaoqiang
     * @date 2015年1月20日 下午5:27:37
     */
    public static Date integerToDate(Integer date){
    	if(date == null){
    		return null;
    	}
    	return stringToDate(date.toString(), "yyyyMMdd");
    }
    /**
     * 根据给定时间段和间隔天数，返回指定时间字符串列表
     *
     * @param beginAt
     * @param endAt
     * @param dateFormat
     * @return
     */
    public static List<String> getDateList(Date beginAt, Date endAt, int intervalDays, String dateFormat) {
        if (beginAt == null && endAt == null) {
            return new ArrayList<String>();
        }
        Date date = beginAt;
        SimpleDateFormat df = getFormat(dateFormat);
        List<String> dateList = new ArrayList<String>();
        long oneDay = 1000L * 60 * 60 * 24;  // 一天的时间
        do {
            dateList.add(df.format(date));
            date = new Date(date.getTime() + oneDay * intervalDays);
        } while (DateUtil.getBeginOfDay(date).compareTo(DateUtil.getBeginOfDay(endAt)) < 0);
        if (DateUtil.getBeginOfDay(date).compareTo(DateUtil.getBeginOfDay(endAt)) >= 0) {
            dateList.add(df.format(endAt));
        }
        return dateList;
    }

    /**
     * 根据给定时间段和间隔天数，返回指定时间字符串列表
     *
     * @param beginAt
     * @return
     */
    public static Date getDateAfterTimes(Date beginAt, int times) {
        Date date = new Date();
        if (beginAt != null) {
            date = beginAt;
        }
        long timesDay = 1000L * 60 * times;  // 额外增加的时间   1000L * 60 秒 * 当前输入分钟数
        date = new Date(date.getTime() + timesDay);
        return date;
    }

    /**
     * 获取指定日期之前n天的日期.
     *
     * @param day
     * @param intervalDays
     * @return
     */
    public static Date getBeforeDate(Date day, int intervalDays) {
        Calendar beforeDay = Calendar.getInstance();
        beforeDay.setTime(day);
        beforeDay.add(Calendar.DATE, 0 - intervalDays);
        return beforeDay.getTime();
    }

    /**
     * @return Date    返回类型
     * @throws
     * @Title: getAfterDate
     * @Description: 某一天后，指定的几天
     * @author YangShanCHeng
     */
    public static Date getAfterDate(Date day, int afterDays) {
        Calendar afterDay = Calendar.getInstance();
        afterDay.setTime(day);
        afterDay.add(Calendar.DATE, afterDays);
        return afterDay.getTime();
    }
    
    /**
     * 获取指定日期之前n月的日期.
     *
     * @param date
     * @param months
     * @return
     */
    public static Date getDateBeforeMonths(Date date, int months) {
    	Calendar beforeDay = Calendar.getInstance();
    	if (date != null) {
    		beforeDay.setTime(date);
    	}
    	beforeDay.add(Calendar.MONTH, 0 - months);
    	return beforeDay.getTime();
    }
    
    /**
     * @return Date    返回类型
     * @throws
     * @Title: getAfterDate
     * @Description: 某一天后，指定的几月
     * @author YangShanCHeng
     */
    public static Date getDateAfterMonths(Date date, int months) {
    	Calendar afterDay = Calendar.getInstance();
    	if (date != null) {
    		afterDay.setTime(date);
    	}
    	afterDay.add(Calendar.MONTH, months);
    	return afterDay.getTime();
    }

    /**
     * 获取前n年的日期
     *
     * @param currentDate
     * @param years 年数
     * @return
     * 
     * @author Albert
     * @date 2014年3月7日 下午12:34:57
     */
    public static Date beforeYears(Date currentDate, int years) {
    	Calendar cal = Calendar.getInstance();
    	if (currentDate != null) {
    		cal.setTime(currentDate);
    	}
    	cal.add(Calendar.YEAR, -years);
    	return cal.getTime();
    }
    
    /**
     * 获取后n年的日期
     *
     * @param currentDate
     * @param years 年数
     * @return
     * 
     * @author Albert
     * @date 2014年3月7日 下午12:34:57
     */
    public static Date afterYears(Date currentDate, int years) {
    	Calendar cal = Calendar.getInstance();
    	if (currentDate != null) {
    		cal.setTime(currentDate);
    	}
    	cal.add(Calendar.YEAR, years);
    	return cal.getTime();
    }
    
    //获取下一年的日期
    public static Date nextYear(Date currentDate) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.YEAR, 1);//在年上加1
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    //获取前月的第一天/
    public static Date lastMonthOfFirstDay() {
        Calendar cal = Calendar.getInstance();//获取当前日期
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    //获取前月的最后一天
    public static Date lastMonthOfEndDay() {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);
        cale.set(Calendar.HOUR_OF_DAY, 23);
        cale.set(Calendar.MINUTE, 59);
        cale.set(Calendar.SECOND, 59);
        return cale.getTime();

    }

    /**
     * 获取明天的0点的时间.
     *
     * @return
     */
    public static Date getTomorrow() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取n个小时前的时间
     *
     * @param i 小时数
     * @return
     */
    public static Date getBeforeHour(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, 0 - i);
        return calendar.getTime();
    }

    /**
     * 获取n个小时前的时间
     *
     * @param i 小时数
     * @return
     */
    public static Date getBeforeMinutes(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, 0 - i);
        return calendar.getTime();
    }

    /**
     * 得到指定日期的星期数，周一为1，周日为7
     *
     * @param date
     * @return
     */
    public static Integer getIntegerWeek(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        int week = cd.get(Calendar.DAY_OF_WEEK);
        if (week == 1) {
            week = 7;
        } else {
            week = week - 1;
        }
        return week;
    }

    /**
     * 根据传入日期查询是周几 已经转换成中国地区的周
     *
     * @param date
     * @return
     */
    public static String getWeek(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        int week = cd.get(Calendar.DAY_OF_WEEK);
        if (week == 1)
            return "周日";
        else if (week == 2) {
            return "周一";
        } else if (week == 3)
            return "周二";
        else if (week == 4)
            return "周三";
        else if (week == 5)
            return "周四";
        else if (week == 6)
            return "周五";
        else
            return "周六";
    }

    /**
     * 获取指定时间与现在时间的对比，显示几秒前/几分钟前/几天前/几周前
     *
     * @return
     */
    public static String getDateDiffCompareNow(Date date) {
        if (date == null) {
            return "";
        }
        Long diff = diffDay(date);
        if (diff < 60 * 3) {      //小于三分钟显示刚刚
            return "刚刚";
        }
        if (diff >= 60 * 3 && diff < 60 * 30) {    //大于三分钟小于半小时显示 分钟数
            return diff / 60 + "分钟前";
        }
        if (diff >= 60 * 30 && diff < 60 * 60) {
            return "半小时前";
        }
        if (diff >= 60 * 60 && diff < 24 * 60 * 60) {
            return diff / 60 / 60 + "小时前";
        }
        if (diff > 24 * 60 * 60 && diff < 24 * 60 * 60 * 7) {
            return diff / 60 / 60 / 24 + "天前";
        }
        return "一周前";
    }


    public static Weeks getWeeks(Date searchDate) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(searchDate);
        int week = cd.get(Calendar.DAY_OF_WEEK);
        if (week == 1)
            return Weeks.SUNDAY;
        else if (week == 2) {
            return Weeks.MONDAY;
        } else if (week == 3)
            return Weeks.THURSDAY;
        else if (week == 4)
            return Weeks.WEDNESDAY;
        else if (week == 5)
            return Weeks.TUESDAY;
        else if (week == 6)
            return Weeks.FRIDAY;
        else
            return Weeks.SATURDAY;
    }

    public static java.sql.Date strToSqldate(String dateStr, String dateFormat){
		Date date = stringToDate(dateStr,dateFormat);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}
    
	public static java.sql.Timestamp strToSqltimestamp(String dateStr, String dateFormat){
		Date date = stringToDate(dateStr,dateFormat);
		java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		return timestamp;
	}
    
	public static int compare(Date date1, Date date2) {
		if (date1 == null) {
			return -1;
		}
		if (date2 == null) {
			return 1;
		}
		if (date1.getTime() == date2.getTime()) {
			return 0;
		} else if (date1.getTime() > date2.getTime()) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public static Date parseUTC(String utc) {
		SimpleDateFormat sdf = getFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
			Date date = sdf.parse(utc);
			return date;
		} catch (ParseException e) {
		}
        return null;
	}
	
	/**
	 * 返回两个日期之间的天数
	 *
	 * @param date1
	 * @param date2
	 * 
	 * @author yaoqiang
	 * @date 2015年1月19日 下午5:26:59
	 */
	public static Long getDaysMinusDate(Date date1, Date date2){
		if(date1 == null || date2 == null){
			return null;
		}
		return (date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000);	
	}
	
	/**
	 * 返回两个日期之间的天数
	 *
	 * @param date1
	 * @param date2
	 * 
	 * @author yaoqiang
	 * @date 2015年1月19日 下午5:26:59
	 */
	public static Long getDaysMinusDate(String date1, String date2, String format){
		if(format == null){
			format = "yyyy-MM-dd";
		}
		Date d1 = stringToDate(date1,format);
		Date d2 = stringToDate(date2,format);
		return getDaysMinusDate(d1,d2);
	}
	
	/**
	 * 
	 * 格林时间格式字符串转时间
	 *
	 * @param strDate
	 * @return
	 * 
	 * @author lisl
	 * @date 2015年9月30日 下午1:51:01
	 */
	public static Date stringToDateGL(String strDate){
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			return stringToDate(strDate, "yyyy-MM-dd HH:mm:ss");
		}
		return date;
	}

	/**
	 * 
	 * 方法描述 获取季报表头
	 *
	 * @param list
	 * @return
	 * 
	 * @author yaomy
	 * @date 2016年10月25日 下午2:08:22
	 */
	public static List<Object> getDateSeason(List<Date> list){
		
		List<Object> list_data = new ArrayList<Object>();
		Calendar cal = Calendar.getInstance();
		for(int i=0;i<list.size();i++){
			if(list_data.size() == 5){
				break;
			}
			Date date = list.get(i);
			
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH)+1;
			int year = cal.get(Calendar.YEAR);
			if(month == 12){
				list_data.add(year+"年报");
			}else if(month == 9){
				list_data.add(year+"三季报");
			}else if(month == 6){
				list_data.add(year+"中报");
			}else if(month == 3){
				list_data.add(year+"一季报");
			}
		}
		return list_data;
	}
	/**
	 * 近n期的报表时间集合
	 * @param maxDate
	 * @param num 
	 * @return
	 * @author yutao
	 * @date 2016年10月24日下午5:24:38
	 */
	public static List<Date> reportDate(Date maxDate, int num){
		Map<String, Object> result = new HashMap<String, Object>();

//		result.put("maxDate", maxDate);
		
		List<Date> list = new ArrayList<Date>();
		list.add(maxDate);
		if(num ==1){
			return null;
		}
		Calendar cal = Calendar.getInstance();
		if(maxDate != null){
			cal.setTime(maxDate);
		}
		cal.add(Calendar.MONTH, 0 - num);
		
		int per = 3;
		for(Integer i=1; i<num;i++){
			cal.setTime(maxDate);
			cal.add(Calendar.MONTH, 0 - per*i);
			Date beforeDate = cal.getTime();//n月前
			cal.setTime(beforeDate);
			int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);//n月前的最后一天
	        cal.set(Calendar.DAY_OF_MONTH, value);
	        cal.set(Calendar.HOUR_OF_DAY, 0);
	        cal.set(Calendar.MINUTE, 0);
	        cal.set(Calendar.SECOND, 0);
	        cal.set(Calendar.MILLISECOND, 000);
			result.put("near_date"+i.toString(), cal.getTime());
			list.add(cal.getTime());
		}
		return list;
	}
}
