package kr.co.pjm.diving.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CommonUtil {
  private CommonUtil() {
  }

  private static class CommonUtilHolder {
    static final CommonUtil single = new CommonUtil();
  }

  public static CommonUtil getInstance() {
    return CommonUtilHolder.single;
  }

  public String encodeURIComponent(String s) {
    String result = null;

    try {
      result = URLEncoder.encode(s, "UTF-8")
          .replaceAll("\\+", "%20")
          .replaceAll("\\%21", "!")
          .replaceAll("\\%27", "'")
          .replaceAll("\\%28", "(")
          .replaceAll("\\%29", ")")
          .replaceAll("\\%7E", "~");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      
      result = s;
    }

    return result;
  }

}
