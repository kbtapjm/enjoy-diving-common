package kr.co.pjm.diving.common.enumertion;

public enum EnviromentEnum {
  LOCAL("로컬"), DEV("개발"), STG("스테이징"), PROD("운영");
  
  private String description;

  private EnviromentEnum(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
