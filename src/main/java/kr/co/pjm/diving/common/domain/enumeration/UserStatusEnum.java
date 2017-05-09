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
 * @Description : 유저 상태(NORMAL : 정상 회원, WITHDRAWAL : 탈퇴 회원) 
 *
 */
public enum UserStatusEnum {
  
  NORMAL(0, "NORMAL"), WITHDRAWAL(1, "WITHDRAWAL");
  
  private int code;
  private String description;
  
  private UserStatusEnum(int code, String description) {
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
