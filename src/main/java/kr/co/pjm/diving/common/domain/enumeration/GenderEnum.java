package kr.co.pjm.diving.common.domain.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum GenderEnum {
  MALE(0, "남성"), FEMALE(1, "여성");
  
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
  
  private static final Map<Integer, GenderEnum> valueAndGenderMap = new HashMap<>();
  
  static {
    for (GenderEnum genderEnum : values()) {
      valueAndGenderMap.put(genderEnum.code, genderEnum);
    }
  }
  
  public static GenderEnum findByValue(Integer value) {
    return valueAndGenderMap.get(value);
  }
}
