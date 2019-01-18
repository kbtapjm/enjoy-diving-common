package kr.co.pjm.diving.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
      result = URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'")
          .replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();

      result = s;
    }

    return result;
  }

  public String getRemoteIp() {
    HttpServletRequest request = ((ServletRequestAttributes )RequestContextHolder.currentRequestAttributes()).getRequest();
    
    String ip = request.getHeader("X-Forwarded-For");
    if (ip == null) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if (ip == null) {
      ip = request.getHeader("WL-Proxy-Client-IP"); // weblogic
    }
    if (ip == null) {
      ip = request.getHeader("HTTP_CLIENT_IP");
    }
    if (ip == null) {
      ip = request.getHeader("HTTP_X_FORWARDED_FOR");
    }
    if (ip == null) {
      ip = request.getRemoteAddr();
    }

    return StringUtils.EMPTY;
  }

}
