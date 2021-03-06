package kr.co.pjm.diving.common.domain.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum RoleTypeEnum {
  ADMIN(100, "ADMIN"), MANAGER(200, "MANAGER"), USER(300, "USER");

  private int code;
  private String description;

  private RoleTypeEnum(int code, String description) {
    this.code = code;
    this.description = description;
  }

  public int getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }

  public String getName() {
    return name();
  }

  private static final Map<Integer, RoleTypeEnum> valueAndTypeMap = new HashMap<>();
  private static final Map<String, RoleTypeEnum> descriptionAndTypeMap = new HashMap<>();

  static {
    for (RoleTypeEnum type : values()) {
      valueAndTypeMap.put(type.getCode(), type);
    }

    for (RoleTypeEnum type : values()) {
      descriptionAndTypeMap.put(type.getDescription(), type);
    }
  }

  public static RoleTypeEnum findByValue(int value) {
    return valueAndTypeMap.get(value);
  }

  public static RoleTypeEnum findByDescription(String description) {
    return descriptionAndTypeMap.get(description);
  }

  public static RoleTypeEnum valueOf(int value) {
    switch (value) {
    case 100:
      return RoleTypeEnum.ADMIN;
    case 200:
      return RoleTypeEnum.MANAGER;
    case 999:
      return RoleTypeEnum.USER;
    default:
      throw new AssertionError("Unknown RoleType : " + value);
    }
  }

}
