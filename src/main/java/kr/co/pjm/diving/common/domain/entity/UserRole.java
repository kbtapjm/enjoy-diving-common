package kr.co.pjm.diving.common.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "user_role")
public class UserRole implements Serializable {

  private static final long serialVersionUID = -2217636749873040022L;

  /* 유저 */
  @Id
  @ManyToOne
  @JoinColumn(name = "user_id")
  @JsonBackReference
  private User user;

  /* 롤 */
  @Id
  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;

  /* 등록일 */
  @Column(name = "reg_date", nullable = false, insertable = true, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+9")
  private Date regDate;

  @PrePersist
  public void prePersist() {
    this.regDate = new Date();
  }

}
