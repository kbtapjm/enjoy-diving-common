package kr.co.pjm.diving.common.util;

public class CommonUtil {
  private CommonUtil() {}

  private static class CommonUtilHolder {
    static final CommonUtil single = new CommonUtil();
  }

  public static CommonUtil getInstance() {
    return CommonUtilHolder.single;
  }
  
  
}
