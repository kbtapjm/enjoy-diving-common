package kr.co.pjm.diving.common.domain.enumeration;

/**
 * <pre>
 * @Package Name : kr.co.pjm.diving.web.domain.entity
 * @Class Name : UserStatusEnum.java
 * </pre>
 * 
 * @author : jmpark
 * @Date : 2017. 5. 5.
 * @Version : 1.0
 * @Description : 유저 상태
 *
 */
public enum UserStatusEnum {
  
  ACTIVE("A", "ACTIVE"), INACTIVE("I", "INACTIVE");
  
  private String code;
  private String description;
  
  private UserStatusEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }

  public String getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }

}
