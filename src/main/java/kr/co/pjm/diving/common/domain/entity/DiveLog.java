package kr.co.pjm.diving.common.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import kr.co.pjm.diving.common.domain.entity.common.CommonSysEntity;
import kr.co.pjm.diving.common.domain.enumeration.DiveCurrentEnum;
import kr.co.pjm.diving.common.domain.enumeration.DivePlanExrPtnEnum;
import kr.co.pjm.diving.common.domain.enumeration.DivePlanToolEnum;
import kr.co.pjm.diving.common.domain.enumeration.DiveTypeEnum;
import kr.co.pjm.diving.common.domain.enumeration.DiveWaterEnum;
import kr.co.pjm.diving.common.domain.enumeration.DiveWaveEnum;
import kr.co.pjm.diving.common.domain.enumeration.YnEnum;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity(name = "dive_log")
public class DiveLog extends CommonSysEntity {

  private static final long serialVersionUID = -1844091074179029622L;

  @Id
  @GeneratedValue
  private Long id;

  /* 번호 */
  @Column(name = "dive_no", nullable = false)
  private Long diveNo;

  /* 다이브 날짜 */
  @Column(name = "dive_date", nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate diveDate;

  /* 다이브 장소 */
  @Column(name = "dive_place", nullable = false, length = 200)
  private String divePlace;

  /* 다이브 포인트 */
  @Column(name = "dive_point", nullable = false, length = 200)
  private String divePoint;

  /* 다이브 입수 시간(시) */
  @Column(name = "dive_in_hour", nullable = false, length = 2)
  private String diveInHour;

  /* 다이브 입수 시간(분) */
  @Column(name = "dive_in_minute", nullable = false, length = 2)
  private String diveInMinute;

  /* 다이브 출수 시간(시) */
  @Column(name = "dive_out_hour", nullable = false, length = 2)
  private String diveOutHour;

  /* 다이브 출수 시간(분) */
  @Column(name = "dive_out_minute", nullable = false, length = 2)
  private String diveOutMinute;

  /* 탱크 압력 시작(bar) */
  @Column(name = "dive_tank_start", nullable = false, length = 3)
  private String diveTankStart;

  /* 탱크 압력 종료(bar) */
  @Column(name = "dive_tank_end", nullable = false, length = 3)
  private String diveTankEnd;

  /* 수면 휴식 시간(시) */
  @Column(name = "ground_rest_hour", nullable = true, length = 2)
  private String groundRestHour;

  /* 수면 휴식 시간(분) */
  @Column(name = "ground_rest_minute", nullable = true, length = 2)
  private String groundRestMinute;

  /* 최대 수심 */
  @Column(name = "max_depth", nullable = false, length = 10)
  private String maxDepth;

  /* 평균 수심 */
  @Column(name = "avg_depth", nullable = false, length = 10)
  private String avgDepth;

  /* 다이브 시간(min) */
  @Column(name = "dive_time", nullable = false, length = 2)
  private String diveTime;

  /* 안전정지 시간 */
  @Column(name = "dive_safety_time", nullable = false, length = 3)
  private String diveSafetyTime;

  /* 다이빙 계획 도구 */
  @Column(name = "dive_plan_tool", nullable = false, length = 50)
  @Enumerated(EnumType.STRING)
  private DivePlanToolEnum divePlanTool;

  /* 웨이트(Kg) */
  @Column(name = "dive_plan_weight", nullable = true, length = 10)
  private String divePlanWeight;

  /* Eanx(나이트록스) */
  @Column(name = "dive_plan_eanx", nullable = true, length = 10)
  private String divePlanEanx;

  /* 노출 보호 */
  @Column(name = "dive_plan_exr_ptn", nullable = false, length = 50)
  @Enumerated(EnumType.STRING)
  private DivePlanExrPtnEnum divePlanExrPtn;

  /* 다이브 후드 여부 */
  @Column(name = "dive_plan_hood_yn", nullable = true, length = 1)
  @Enumerated(EnumType.STRING)
  private YnEnum divePlanHoodYn;

  /* 다이브 장갑 여부 */
  @Column(name = "dive_plan_gloves_yn", nullable = true, length = 1)
  @Enumerated(EnumType.STRING)
  private YnEnum divePlanGlovesYn;

  /* 다이브 부츠 여부 */
  @Column(name = "dive_plan_boots_yn", nullable = true, length = 1)
  @Enumerated(EnumType.STRING)
  private YnEnum divePlanBootsYn;

  /* 다이브 라이트 여부 */
  @Column(name = "dive_plan_light_yn", nullable = true, length = 1)
  @Enumerated(EnumType.STRING)
  private YnEnum divePlanLightYn;

  /* 다이브 SMB 여부 */
  @Column(name = "dive_plan_smb_yn", nullable = true, length = 1)
  @Enumerated(EnumType.STRING)
  private YnEnum divePlanSmbYn;

  /* 다이브 나이프 여부 */
  @Column(name = "dive_plan_knife_yn", nullable = true, length = 1)
  @Enumerated(EnumType.STRING)
  private YnEnum divePlanKnifeYn;

  /* 다이브 카메라 여부 */
  @Column(name = "dive_plan_camera_yn", nullable = true, length = 1)
  @Enumerated(EnumType.STRING)
  private YnEnum divePlanCameraYn;

  /* 시야 */
  @Column(name = "visibility", nullable = false, length = 10)
  private String visibility;

  /* 수온 */
  @Column(name = "temperature", nullable = false, length = 10)
  private String temperature;

  /* 다이브 유형 */
  @Column(name = "dive_type", nullable = true, length = 50)
  @Enumerated(EnumType.STRING)
  private DiveTypeEnum diveType;

  /* 다이브 워터 */
  @Column(name = "dive_water", nullable = true, length = 50)
  @Enumerated(EnumType.STRING)
  private DiveWaterEnum diveWater;

  /* 다이브 파도 */
  @Column(name = "dive_wave", nullable = true, length = 50)
  @Enumerated(EnumType.STRING)
  private DiveWaveEnum diveWave;

  /* 다이브 조류 */
  @Column(name = "dive_current", nullable = true, length = 50)
  @Enumerated(EnumType.STRING)
  private DiveCurrentEnum diveCurrent;

  /* 다이브 활동 */
  @Column(name = "dive_activity", nullable = true, length = 500)
  private String diveActivity;

  /* 다이브 노트 */
  @Lob
  @Column(name = "dive_note", nullable = true)
  private String diveNote;

  @PrePersist
  public void prePersist() {
    this.divePlanHoodYn = this.divePlanHoodYn != null ? this.divePlanHoodYn : YnEnum.N;
    this.divePlanGlovesYn = this.divePlanGlovesYn != null ? this.divePlanGlovesYn : YnEnum.N;
    this.divePlanBootsYn = this.divePlanBootsYn != null ? this.divePlanBootsYn : YnEnum.N;
    this.divePlanLightYn = this.divePlanLightYn != null ? this.divePlanLightYn : YnEnum.N;
    this.divePlanSmbYn = this.divePlanSmbYn != null ? this.divePlanSmbYn : YnEnum.N;
    this.divePlanKnifeYn = this.divePlanKnifeYn != null ? this.divePlanKnifeYn : YnEnum.N;
    this.divePlanCameraYn = this.divePlanCameraYn != null ? this.divePlanCameraYn : YnEnum.N;
  }
  
  @PreUpdate
  public void preUpdate() {
    this.divePlanHoodYn = this.divePlanHoodYn != null ? this.divePlanHoodYn : YnEnum.N;
    this.divePlanGlovesYn = this.divePlanGlovesYn != null ? this.divePlanGlovesYn : YnEnum.N;
    this.divePlanBootsYn = this.divePlanBootsYn != null ? this.divePlanBootsYn : YnEnum.N;
    this.divePlanLightYn = this.divePlanLightYn != null ? this.divePlanLightYn : YnEnum.N;
    this.divePlanSmbYn = this.divePlanSmbYn != null ? this.divePlanSmbYn : YnEnum.N;
    this.divePlanKnifeYn = this.divePlanKnifeYn != null ? this.divePlanKnifeYn : YnEnum.N;
    this.divePlanCameraYn = this.divePlanCameraYn != null ? this.divePlanCameraYn : YnEnum.N;
  }

  @Builder
  public DiveLog(Long id, Long diveNo, LocalDate diveDate, String divePlace, String divePoint, String diveInHour,
      String diveInMinute, String diveOutHour, String diveOutMinute, String diveTankStart, String diveTankEnd,
      String groundRestHour, String groundRestMinute, String maxDepth, String avgDepth, String diveTime,
      String diveSafetyTime, DivePlanToolEnum divePlanTool, String divePlanWeight, String divePlanEanx,
      DivePlanExrPtnEnum divePlanExrPtn, YnEnum divePlanHoodYn, YnEnum divePlanGlovesYn, YnEnum divePlanBootsYn,
      YnEnum divePlanLightYn, YnEnum divePlanSmbYn, YnEnum divePlanKnifeYn, YnEnum divePlanCameraYn, String visibility,
      String temperature, DiveTypeEnum diveType, DiveWaterEnum diveWater, DiveWaveEnum diveWave,
      DiveCurrentEnum diveCurrent, String diveActivity, String diveNote, String regId, String updateId,
      LocalDateTime regDate, LocalDateTime updateDate) {
    this.id = id;
    this.diveNo = diveNo;
    this.diveDate = diveDate;
    this.divePlace = divePlace;
    this.divePoint = divePoint;
    this.diveInHour = diveInHour;
    this.diveInMinute = diveInMinute;
    this.diveOutHour = diveOutHour;
    this.diveOutMinute = diveOutMinute;
    this.diveTankStart = diveTankStart;
    this.diveTankEnd = diveTankEnd;
    this.groundRestHour = groundRestHour;
    this.groundRestMinute = groundRestMinute;
    this.maxDepth = maxDepth;
    this.avgDepth = avgDepth;
    this.diveTime = diveTime;
    this.diveSafetyTime = diveSafetyTime;
    this.divePlanTool = divePlanTool;
    this.divePlanWeight = divePlanWeight;
    this.divePlanEanx = divePlanEanx;
    this.divePlanExrPtn = divePlanExrPtn;
    this.divePlanHoodYn = divePlanHoodYn;
    this.divePlanGlovesYn = divePlanGlovesYn;
    this.divePlanBootsYn = divePlanBootsYn;
    this.divePlanLightYn = divePlanLightYn;
    this.divePlanSmbYn = divePlanSmbYn;
    this.divePlanKnifeYn = divePlanKnifeYn;
    this.divePlanCameraYn = divePlanCameraYn;
    this.visibility = visibility;
    this.temperature = temperature;
    this.diveType = diveType;
    this.diveWater = diveWater;
    this.diveWave = diveWave;
    this.diveCurrent = diveCurrent;
    this.diveActivity = diveActivity;
    this.diveNote = diveNote;
    
    if (StringUtils.isEmpty(regId)) {
      this.setRegId(regId);  
    }
    if (StringUtils.isEmpty(updateId)) {
      this.setRegId(updateId);  
    }
    if (regDate != null) {
      this.setRegDate(regDate);  
    }
    if (updateDate != null) {
      this.setUpdateDate(updateDate);  
    }
  }

}
