package kr.co.pjm.diving.common.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.co.pjm.diving.common.domain.entity.common.CommonEntity;
import kr.co.pjm.diving.common.domain.enumeration.GenderEnum;
import kr.co.pjm.diving.common.domain.enumeration.UserStatusEnum;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "user_basic")
public class UserBasic extends CommonEntity {

  private static final long serialVersionUID = 7251053506978592166L;

  @Id
  @GeneratedValue
  private Long id;

  /* 이름 */
  @Column(name = "name", nullable = false, length = 100)
  private String name;

  /* 닉네임 */
  @Column(name = "nickname", nullable = true, unique = true, length = 100)
  private String nickname;

  /* 성별 */
  @Column(name = "gender", nullable = false)
  @Enumerated(EnumType.ORDINAL)
  private GenderEnum gender;

  /* 국가 */
  @Column(name = "country", nullable = false, length = 50)
  private String country;

  /* 유저 상태 */
  @Column(name = "status", nullable = false)
  @Enumerated(EnumType.ORDINAL)
  private UserStatusEnum status;

  /* 프로필 URL */
  @Column(name = "profile", nullable = true, length = 200)
  private String profile;

  /* 소개 */
  @Column(name = "introduce", nullable = true, columnDefinition = "TEXT")
  private String introduce;

  /* 로그인 일자 */
  @Column(name = "login_date", nullable = true)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime loginDate;

  /* 유저 */
  @OneToOne(mappedBy = "userBasic")
  @JoinColumn(name = "user_id")
  @JsonIgnore
  private User user;

  @Builder
  public UserBasic(Long id, String name, String nickname, GenderEnum gender, String country, UserStatusEnum status,
      String profile, String introduce, LocalDateTime loginDate, User user) {
    this.id = id;
    this.name = name;
    this.nickname = nickname;
    this.gender = gender;
    this.country = country;
    this.status = status;
    this.profile = profile;
    this.introduce = introduce;
    this.loginDate = loginDate;
    this.user = user;
  }

}
