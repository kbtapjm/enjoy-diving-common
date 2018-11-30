package kr.co.pjm.diving.common.util;

import kr.co.pjm.diving.common.exception.InvalidRequestException;

public class NumberUtil {

  private NumberUtil() {
  }

  private static class NumberUtilHolder {
    static final NumberUtil single = new NumberUtil();
  }

  public static NumberUtil getInstance() {
    return NumberUtilHolder.single;
  }

  public Integer isNumber(String str) {
    try {
      return Integer.parseInt(str);
    } catch (NumberFormatException e) {
      throw new InvalidRequestException("잘못된 요청 입니다.");
    }
  }

  public Long isLong(String str) {
    try {
      return Long.parseLong(str);
    } catch (NumberFormatException e) {
      throw new InvalidRequestException("잘못된 요청 입니다.");
    }
  }

  public Integer nvlInt(Integer objData, int nTrans) {
    return (objData == null) ? nTrans : objData;
  }

  public Long nvlLong(Long objData, int nTrans) {
    return (objData == null) ? nTrans : objData;
  }
}
