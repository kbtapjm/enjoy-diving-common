package kr.co.pjm.diving.common.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
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
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+9")
  private LocalDateTime regDate;

  @PrePersist
  public void prePersist() {
    this.regDate = LocalDateTime.now();
  }

}
