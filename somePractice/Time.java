package testingJavaEight;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Locale;
/**
 * Time class contain practice on Local date and time classes
 * 
 * @author David Sajdl
 * @version 1.8.0_60
 *
 */
public class Time {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
	    
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		LocalDateTime timePoint = LocalDateTime.now();  // The current date and time
		
		System.out.println(timePoint);  //prints: →  2015-11-08T12:10:34.194
		System.out.println("Today is:");
		DayOfWeek dayOfweek = timePoint.getDayOfWeek();
		System.out.println(dayOfweek); //prints → SUNDAY
		System.out.println("\n----------\nDay:");
		int day = timePoint.getDayOfMonth();
		System.out.println(day);  	//prints → 8

		System.out.println("\nYear:");
		int year = timePoint.getYear();
		System.out.println(year); //prints → 2015

		System.out.println("\nMonth:");
		Month month = timePoint.getMonth();
		int m = timePoint.getMonthValue();
		int dy = timePoint.getDayOfYear();
		System.out.println(month);	// → NOVEMBER
		System.out.println(m);		// → 11
		System.out.println(dy);		// → 312
		System.out.println("\n----------\nHours, minutes, seconds and nanoseconds");
		int hr = timePoint.getHour();
		int min = timePoint.getMinute();
		int sec = timePoint.getSecond();
		int nanosec = timePoint.getNano();
		System.out.println(hr); 		//prints → 12
		System.out.println(min);		//prints → 10 
		System.out.println(sec);		//prints → 34
		System.out.println(nanosec);		//prints → 795000000 (run later in same day)
		
	
		System.out.println("\n----------");
		System.out.println("Current day and time in London: "+timePoint);
		LocalDateTime currentTimeInPrague = LocalDateTime.now(ZoneId.of("Europe/Prague"));
		System.out.println("Current day and time in Prague: "+ currentTimeInPrague);
		LocalDateTime currentTimeInLA = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println("Current day and time in LA:     "+ currentTimeInLA);
		
		System.out.println("\n----------");
 		System.out.println("Fomating Date and Time: ");
		SimpleDateFormat msdf = new SimpleDateFormat("yyyy-M-d'T'H:m:s");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d H:m:s");
		java.util.Date curdate = msdf.parse(timePoint + " UTC");
		System.out.println(curdate);
		String timePointWithoutT = timePoint.toString().replace("T", " ");
		java.util.Date curDateT = sdf.parse(timePointWithoutT + " UTC");
		System.out.println(curDateT);
		
		SimpleDateFormat formatDay = new SimpleDateFormat("yyyy-M-d");
		java.util.Date forCurDate = formatDay.parse(timePoint + "UTC");
		System.out.println(forCurDate);
		
		System.out.println("\n----------\nTime:");
		LocalTime time = LocalTime.now();
		System.out.println(time);
	
		 
		System.out.println("\n----------\nDay: ");
		LocalDate now = LocalDate.now();
		System.out.println(now);
		System.out.println("\n----------");
		
		TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
		System.out.println(timePoint.with(fieldISO, 7));
		
		
		System.out.println(fieldISO + " <ISO");
		System.out.println(now.with(fieldISO, 1));
		System.out.println(now.with(DayOfWeek.MONDAY) + " Monday");
		System.out.println("----------");
		
		System.out.println(now.getDayOfWeek());
		System.out.println(LocalDate.of(2012, Month.DECEMBER, 12)); // from values
		System.out.println(LocalDate.ofEpochDay(150));  // middle of 1970
		System.out.println(LocalTime.of(17, 18)); // the train I took home today
		System.out.println(LocalTime.parse("10:15:30")); // From a String
		System.out.println(ZonedDateTime.parse("2007-12-03T10:15:30+01:00[Europe/Paris]"));//"text"+"[Europe/Paris]"));
		System.out.println();
	
		
		String text = 		"2014-11-30T12:00:00";
		String dateString = "2012-11-13 14:00:00:000";
		
		String t = text.replace("T", " ");
		System.out.println("\n"+t+"-----------\n");
		java.util.Date theDate = sdf.parse(dateString + " UTC");
		java.util.Date date = msdf.parse(text + " UTC");
		System.out.println(theDate.toString());
		System.out.println(date.toString());
		
	    Calendar cal = Calendar.getInstance();
	    System.out.println("Calendar date:"+ dateFormat.format(cal.getTime()));

	}

}
