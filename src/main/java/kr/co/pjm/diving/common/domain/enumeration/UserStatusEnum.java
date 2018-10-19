package kr.co.pjm.diving.common.domain.enumeration;

public enum UserStatusEnum {
  NORMAL(0, "정상 회원"), WITHDRAWAL(1, "탈퇴 회원");

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
