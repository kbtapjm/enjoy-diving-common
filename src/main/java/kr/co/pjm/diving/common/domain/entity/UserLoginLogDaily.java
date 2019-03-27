package kr.co.pjm.diving.common.domain.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "user_login_log_daily")
public class UserLoginLogDaily {
  
  @Id
  @GeneratedValue
  private Long id;
  
  /* 로그인 일자 */
  @Column(name = "login_date", nullable = false, insertable = true)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate loginDate;
  
  /* 로그인 카운트 */
  @Column(name = "login_count", nullable = false)
  private Long loginCount;
  
  /* 유저 */
  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  private User user;

}
