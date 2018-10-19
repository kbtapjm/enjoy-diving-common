package kr.co.pjm.diving.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import kr.co.pjm.diving.common.domain.entity.Role;
import kr.co.pjm.diving.common.domain.enumeration.RoleTypeEnum;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>, QueryDslPredicateExecutor<Role> {

  Role findByRole(RoleTypeEnum roleTypeEnum);

}
