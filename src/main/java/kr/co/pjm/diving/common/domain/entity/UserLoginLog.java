package kr.co.pjm.diving.common.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "user_login_log")
public class UserLoginLog {
  
  @Id
  @GeneratedValue
  private Long id;
  
  /* 이메일 */
  @Column(name = "email", nullable = false, length = 200)
  private String email;
  
  /* 로그인 날짜 */
  @Column(name = "login_date_time", nullable = false, insertable = true)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+9")
  private LocalDateTime loginDateTime;
  
  /* 유저 */
  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  private User user;

  @Builder
  public UserLoginLog(String email, User user) {
    super();
    this.email = email;
    this.user = user;
  }
  
  @PrePersist
  public void prePersist() {
    this.loginDateTime = LocalDateTime.now();
  }

}
