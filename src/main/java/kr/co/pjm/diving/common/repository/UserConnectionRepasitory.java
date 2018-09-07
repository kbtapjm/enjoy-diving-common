package kr.co.pjm.diving.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import kr.co.pjm.diving.common.domain.entity.UserConnection;
import kr.co.pjm.diving.common.repasitory.support.UserConnectionRepasitorySupport;

@Repository
public interface UserConnectionRepasitory extends JpaRepository<UserConnection, Long>, QueryDslPredicateExecutor<UserConnection>, UserConnectionRepasitorySupport {

}
