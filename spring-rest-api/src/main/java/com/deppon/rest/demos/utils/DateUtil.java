package com.deppon.rest.demos.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static final String dayChnNames[] = { "星期日", "星期一", "星期二", "星期三",
			"星期四", "星期五", "星期六" };

	public static final String C_PATTON_DATETIME = "yyyy-MM-dd HH:mm:ss";
	public static final String C_PATTON_DATE = "yyyy-MM-dd";
	public static final String C_PATTON_TIME = "HH:mm:ss";

	public static SimpleDateFormat getSimpleDateFormat() {
		return getSimpleDateFormat(null);
	}

	/**
	 * 拿到指定输出格式的SimpleDateFormat
	 * 
	 * @param format
	 * @return
	 */
	public static SimpleDateFormat getSimpleDateFormat(String format) {
		SimpleDateFormat sdf;
		if (format == null) {
			sdf = new SimpleDateFormat(C_PATTON_TIME);
		} else {
			sdf = new SimpleDateFormat(format);
		}
		return sdf;
	}

	public static String formatDate2Str(Date date, String format) {
		if (date == null) {
			return null;
		}
		if (format == null || format.equals("")) {
			format = C_PATTON_DATETIME;
		}
		SimpleDateFormat sdf = getSimpleDateFormat(format);
		return sdf.format(date);
	}

	public static String formatCalendar2Str(Calendar calendar, String format) {
		if (calendar == null) {
			return null;
		}
		return formatDate2Str(calendar.getTime(), format);
	}

	/**
	 * 转换指定格式的时间为Date
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date formatStr2Date(String dateStr, String format) {
		if (dateStr == null) {
			return null;
		}

		if (format == null || format.equals("")) {
			format = C_PATTON_DATETIME;
		}
		SimpleDateFormat sdf = getSimpleDateFormat(format);
		return sdf.parse(dateStr, new ParsePosition(0));
	}

	/**
	 * 转换指定格式的时间为Calendar
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Calendar formatStr2Calendar(String dateStr, String format) {
		if (dateStr == null) {
			return null;
		}
		Date d = formatStr2Date(dateStr, format);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c;
	}

	public static Date calendar2Date(Calendar calendar) {
		if (calendar == null) {
			return null;
		}
		return calendar.getTime();
	}

	public static Calendar date2Calendar(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	
	public static Long getMillisecondsFromTonight(Date now) {
		String date = formatDate2Str(now, C_PATTON_DATE);
		Date noNight = formatStr2Date(date+" "+"23:59:59", C_PATTON_DATETIME);
		return noNight.getTime()-now.getTime();
	}
	
	

	public static String getNowStr() {
		return formatDate2Str(getNowDate(), null);
	}

	public static Calendar getNowCalendar() {
		return Calendar.getInstance();
	}

	public static Date getNowDate() {
		return new Date();
	}

	public static Date addYears(Date date, int amount) {
		return add(date, 1, amount);
	}

	public static Date addMonths(Date date, int amount) {
		return add(date, 2, amount);
	}

	public static Date addWeeks(Date date, int amount) {
		return add(date, 3, amount);
	}

	public static Date addDays(Date date, int amount) {
		return add(date, 5, amount);
	}

	public static Date addHours(Date date, int amount) {
		return add(date, 11, amount);
	}

	public static Date addMinutes(Date date, int amount) {
		return add(date, 12, amount);
	}

	public static Date addSeconds(Date date, int amount) {
		return add(date, 13, amount);
	}

	public static Date addMilliseconds(Date date, int amount) {
		return add(date, 14, amount);
	}

	private static Date add(Date date, int calendarField, int amount) {
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		} else {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(calendarField, amount);
			return c.getTime();
		}
	}

	public static Calendar addYears(Calendar calendar, int amount) {
		return add(calendar, 1, amount);
	}

	public static Calendar addMonths(Calendar calendar, int amount) {
		return add(calendar, 2, amount);
	}

	public static Calendar addWeeks(Calendar calendar, int amount) {
		return add(calendar, 3, amount);
	}

	public static Calendar addDays(Calendar calendar, int amount) {
		return add(calendar, 5, amount);
	}

	public static Calendar addHours(Calendar calendar, int amount) {
		return add(calendar, 11, amount);
	}

	public static Calendar addMinutes(Calendar calendar, int amount) {
		return add(calendar, 12, amount);
	}

	public static Calendar addSeconds(Calendar calendar, int amount) {
		return add(calendar, 13, amount);
	}

	public static Calendar addMilliseconds(Calendar calendar, int amount) {
		return add(calendar, 14, amount);
	}

	private static Calendar add(Calendar calendar, int calendarField, int amount) {
		if (calendar == null) {
			throw new IllegalArgumentException("The Calendar must not be null");
		} else {
			calendar.add(calendarField, amount);
			return calendar;
		}
	}

	/**
	 * 返回一个Calendar日期的星期计数
	 * 
	 * @param date
	 * @return
	 */
	public static long getWeekDay(Calendar date) {
		return getWeekDay(date.getTime());
	}

	/**
	 * 返回一个Date日期的星期计数
	 * 
	 * @param date
	 * @return
	 */
	public static long getWeekDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 返回一个Calendar日期的中文星期几
	 * 
	 * @param calendar
	 * @return
	 */
	public static String getWeekDayString(Calendar calendar) {
		String weekString = "";
		int dayOfWeek = (int) getWeekDay(calendar);
		weekString = dayChnNames[dayOfWeek - 1];
		return weekString + "";
	}

	/**
	 * 返回一个Date日期的中文星期几
	 * 
	 * @param calendar
	 * @return
	 */
	public static String getWeekDayString(Date date) {
		String weekString = "";
		long dayOfWeek = getWeekDay(date);
		weekString = dayChnNames[(int) (dayOfWeek - 1)];
		return weekString + "";
	}
	
}
