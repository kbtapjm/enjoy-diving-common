package kr.co.pjm.diving.common.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import kr.co.pjm.diving.common.domain.entity.common.CommonEntity;
import kr.co.pjm.diving.common.domain.enumeration.RoleTypeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "role")
public class Role extends CommonEntity {

  private static final long serialVersionUID = 8699993725039806034L;

  @Id
  @GeneratedValue
  private Long id;

  /* 롤 */
  @Column(name = "role", nullable = false)
  @Enumerated(EnumType.STRING)
  private RoleTypeEnum role;

  /* 롤이름 */
  @Column(name = "role_name", nullable = false)
  private String roleName;

  /* 유저 롤 엔티티 */
  @JsonBackReference
  @OneToMany(mappedBy = "role")
  private Set<UserRole> userRoles;

}
