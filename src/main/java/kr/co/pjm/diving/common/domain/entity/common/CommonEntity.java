package kr.co.pjm.diving.common.domain.entity.common;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@MappedSuperclass
public abstract class CommonEntity implements Serializable {

  private static final long serialVersionUID = -8554163589797728671L;

  @Column(name = "reg_date", nullable = false, insertable = true, updatable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+9")
  private LocalDateTime regDate;

  @Column(name = "update_date", nullable = true, insertable = false, updatable = true)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+9")
  private LocalDateTime updateDate;

  @PrePersist
  public void prePersist() {
    this.regDate = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    this.updateDate = LocalDateTime.now();
  }
  
  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }
}
