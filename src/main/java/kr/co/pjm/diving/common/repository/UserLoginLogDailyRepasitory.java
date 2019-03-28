package kr.co.pjm.diving.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import kr.co.pjm.diving.common.domain.entity.UserLoginLogDaily;

@Repository
public interface UserLoginLogDailyRepasitory
    extends JpaRepository<UserLoginLogDaily, Long>, QueryDslPredicateExecutor<UserLoginLogDaily> {

}
