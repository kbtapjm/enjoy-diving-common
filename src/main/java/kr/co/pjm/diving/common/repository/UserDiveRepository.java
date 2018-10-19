package kr.co.pjm.diving.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import kr.co.pjm.diving.common.domain.entity.UserDive;
import kr.co.pjm.diving.common.repasitory.support.UserDiveRepositorySupport;

@Repository
public interface UserDiveRepository extends JpaRepository<UserDive, Long>, QueryDslPredicateExecutor<UserDive>, UserDiveRepositorySupport {

}
