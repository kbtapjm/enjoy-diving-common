package kr.co.pjm.diving.common.domain.enumeration;

public enum YnEnum {
  Y(0, "YES"), N(1, "NO");
  
  private int code;
  private String description;
  
  private YnEnum(int code, String description) {
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
