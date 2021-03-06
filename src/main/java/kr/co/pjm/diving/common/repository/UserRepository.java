package kr.co.pjm.diving.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import kr.co.pjm.diving.common.domain.entity.User;
import kr.co.pjm.diving.common.repasitory.support.UserRepositorySupport;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, QueryDslPredicateExecutor<User>, UserRepositorySupport {

  User findByEmail(String email);

}
