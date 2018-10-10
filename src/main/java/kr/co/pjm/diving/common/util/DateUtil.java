package kr.co.pjm.diving.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
  public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
  
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
}
