package kr.co.pjm.diving.common.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import kr.co.pjm.diving.common.domain.entity.common.CommonEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
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

  @Builder
  public UserRole(User user, Role role) {
    this.user = user;
    this.role = role;
  }

}
