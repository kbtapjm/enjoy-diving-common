package kr.co.pjm.diving.common.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonBackReference;

import kr.co.pjm.diving.common.domain.entity.common.CommonEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "user_role")
public class UserRole extends CommonEntity {

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

  @PrePersist
  public void prePersist() {
    this.setRegDate(LocalDateTime.now());
  }

}
