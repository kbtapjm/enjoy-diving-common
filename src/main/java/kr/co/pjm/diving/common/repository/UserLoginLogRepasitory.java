package kr.co.pjm.diving.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import kr.co.pjm.diving.common.domain.entity.UserLoginLog;
import kr.co.pjm.diving.common.repasitory.support.UserLoginLogRepasitorySupport;

@Repository
public interface UserLoginLogRepasitory extends JpaRepository<UserLoginLog, Long>,
    QueryDslPredicateExecutor<UserLoginLog>, UserLoginLogRepasitorySupport {

}
