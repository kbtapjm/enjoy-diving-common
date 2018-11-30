package kr.co.pjm.diving.common.util;

import kr.co.pjm.diving.common.exception.InvalidRequestException;

public class StringUtil {

  private StringUtil() {}
  
  private static class StringUtilHolder {
    static final StringUtil single = new StringUtil();
  }
  
  public static StringUtil getInstance() {
    return StringUtilHolder.single;
  }
  
  public String isString(Long userId) {
    try {
      return String.valueOf(userId);
    } catch (Exception e) {
      throw new InvalidRequestException("잘못된 요청 입니다.");
    }
  }
  
}
