package kr.co.pjm.diving.common.domain.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum DiveTypeEnum {
  BEACH(0, "비치"), BOAT(1, "보트");
  
  private int code;
  private String description;

  private DiveTypeEnum(int code, String description) {
    this.code = code;
    this.description = description;
  }

  public int getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }
  
  private static final Map<String, DiveTypeEnum> valueAndTypeMap = new HashMap<>();
  private static final Map<String, DiveTypeEnum> descriptionAndTypeMap = new HashMap<>();
  
  static {
    for (DiveTypeEnum type : values()) {
      valueAndTypeMap.put(type.name(), type);
    }
    
    for (DiveTypeEnum type : values()) {
      descriptionAndTypeMap.put(type.getDescription(), type);
    }
  }
  
  public static DiveTypeEnum findByValue(String value) {
    return valueAndTypeMap.get(value);
  }
  
  public static DiveTypeEnum findByDescription(String description) {
    return descriptionAndTypeMap.get(description);
  }
}
