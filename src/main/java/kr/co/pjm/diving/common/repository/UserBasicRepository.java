package kr.co.pjm.diving.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import kr.co.pjm.diving.common.domain.entity.UserBasic;
import kr.co.pjm.diving.common.repasitory.support.UserBasicRepositorySupport;

public interface UserBasicRepository extends JpaRepository<UserBasic, Long>, QueryDslPredicateExecutor<UserBasic>, UserBasicRepositorySupport {

}
