package kr.co.pjm.diving.common.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.co.pjm.diving.common.domain.entity.common.CommonEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "user_dive")
public class UserDive extends CommonEntity {

  private static final long serialVersionUID = 6655212651722136646L;

  @Id
  @GeneratedValue
  private Long id;

  /* 다이브 단체 */
  @Column(name = "dive_group", nullable = true, length = 200)
  private String diveGroup;

  /* 다이브 레벨 */
  @Column(name = "dive_level", nullable = true, length = 100)
  private String diveLevel;

  /* 다이브 소속 */
  @Column(name = "team", nullable = true, length = 150)
  private String team;

  /* 서명 */
  @Column(name = "signature", nullable = true, length = 300)
  private String signature;

  /* 유저 */
  @OneToOne(mappedBy = "userDive")
  @JoinColumn(name = "user_id")
  @JsonIgnore
  private User user;

  @Builder
  public UserDive(Long id, String diveGroup, String diveLevel, String team, String signature, User user) {
    this.id = id;
    this.diveGroup = diveGroup;
    this.diveLevel = diveLevel;
    this.team = team;
    this.signature = signature;
    this.user = user;
  }

}
