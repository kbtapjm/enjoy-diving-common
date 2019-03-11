package kr.co.pjm.diving.common.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.co.pjm.diving.common.domain.entity.common.CommonEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "user_login_log")
public class UserLoginLog extends CommonEntity {
  
  private static final long serialVersionUID = 4163480951601382132L;
  
  @Id
  @GeneratedValue
  private Long id;
  
  /* 이메일 */
  @Column(name = "email", nullable = false, length = 200, unique = true)
  private String email;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  private User user;

  @Builder
  public UserLoginLog(String email, User user) {
    super();
    this.email = email;
    this.user = user;
  }

}
