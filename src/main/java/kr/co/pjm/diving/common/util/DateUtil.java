package kr.co.pjm.diving.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DateUtil {
  public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
  public static final String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

  private DateUtil() {}

  private static class DateUtilHolder {
    static final DateUtil single = new DateUtil();
  }

  public static DateUtil getInstance() {
    return DateUtilHolder.single;
  }

  public Date toDate(String dateStr, String format) {
    Date dt = null;
    try {
      SimpleDateFormat sdf = new SimpleDateFormat(format);

      dt = sdf.parse(dateStr);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    return dt;
  }
  
  public LocalDateTime toLocalDateTime(String dateStr, String format) {
    DateTimeFormatter DATEFORMATTER1 = DateTimeFormatter.ofPattern(format);

    DateTimeFormatter DATEFORMATTER = new DateTimeFormatterBuilder().append(DATEFORMATTER1)
        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
        .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
        .toFormatter();

    return LocalDateTime.parse(dateStr, DATEFORMATTER);
  }

  public String getTimestampToDateString(long time, String format) {
    SimpleDateFormat formatter = new SimpleDateFormat(format);

    Timestamp currentTime = new Timestamp(time);
    String dateStr = formatter.format(currentTime);

    return dateStr;

  }

  public String getDateToString(Date date, String format) {
    if (date == null)
      return StringUtils.EMPTY;

    SimpleDateFormat formatter = new SimpleDateFormat(format);
    String dateStr = formatter.format(date);

    return dateStr;
  }

  public String getLocalDateToString(long daysToSubtract, String format) {
    return LocalDate.now().minusDays(daysToSubtract).format(DateTimeFormatter.ofPattern(format));
  }
}
