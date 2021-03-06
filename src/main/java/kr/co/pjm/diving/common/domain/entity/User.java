package kr.co.pjm.diving.common.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import kr.co.pjm.diving.common.domain.entity.common.CommonEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity(name = "user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@ToString(exclude = {"userBasic", "userDive"})  
public class User extends CommonEntity {

  private static final long serialVersionUID = 3131289288410385391L;

  @Id
  @GeneratedValue
  private Long id;

  /* 이메일 */
  @Column(name = "email", nullable = false, length = 200, unique = true)
  private String email;

  /* 비밀번호 */
  @Column(name = "password", nullable = false, length = 100)
  @JsonIgnore
  private String password;

  /* 비밀번호 확인 */
  @Transient
  @JsonIgnore
  private String confirmPassword;

  /* 소셜 공급자 */
  @Column(name = "provider", nullable = false, length = 20)
  private String provider;

  /* 유저 롤 */
  @JsonManagedReference
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<UserRole> userRoles = new HashSet<UserRole>();

  /* 유저 기본 */
  @OneToOne
  @JoinColumn(name = "user_basic_id")
  private UserBasic userBasic;

  /* 유저 다이브 */
  @OneToOne
  @JoinColumn(name = "user_dive_id")
  private UserDive userDive;
  
  /* 유저 로그인 이력 */
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
  @JsonIgnore
  private Set<UserLoginLog> logHistory = new HashSet<UserLoginLog>();

  @Builder
  public User(Long id, String email, String password, Set<UserRole> userRoles, UserBasic userBasic,
      UserDive userDive, String provider) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.userRoles = userRoles;
    this.userBasic = userBasic;
    this.userDive = userDive;
    this.provider = provider;
  }

}
