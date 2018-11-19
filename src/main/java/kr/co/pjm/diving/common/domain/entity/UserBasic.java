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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "user_basic")
public class UserBasic extends CommonEntity {

  private static final long serialVersionUID = 7251053506978592166L;

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "name", nullable = false, length = 100)
  private String name;

  @Column(name = "nickname", nullable = true, unique = true, length = 100)
  private String nickname;

  @Column(name = "gender", nullable = false)
  @Enumerated(EnumType.ORDINAL)
  private GenderEnum gender;

  @Column(name = "country", nullable = false, length = 50)
  private String country;

  @Column(name = "status", nullable = false)
  @Enumerated(EnumType.ORDINAL)
  private UserStatusEnum status;

  @Column(name = "profile", nullable = true, length = 200)
  private String profile;

  @Column(name = "introduce", nullable = true, columnDefinition = "TEXT")
  private String introduce;

  @Column(name = "login_date", nullable = true)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime loginDate;

  @OneToOne(mappedBy = "userBasic")
  @JoinColumn(name = "user_id")
  @JsonIgnore
  private User user;

}
