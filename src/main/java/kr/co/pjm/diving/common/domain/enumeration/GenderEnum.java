package kr.co.pjm.diving.common.domain.enumeration;

/**
 * <pre>
 * @Package Name : kr.co.pjm.diving.common.domain.enumeration
 * @Class Name : GenderEnum.java
 * </pre>
 * 
 * @author : jmpark
 * @Date : 2017. 5. 9.
 * @Version : 1.0
 * @Description : 성별 
 *
 */
public enum GenderEnum {

  MALE(0, "MALE"), FEMALE(1, "FEMALE");
  
  private int code;
  private String description;
  
  private GenderEnum(int code, String description) {
    this.code = code;
    this.description = description;
  }

  public int getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }
}
