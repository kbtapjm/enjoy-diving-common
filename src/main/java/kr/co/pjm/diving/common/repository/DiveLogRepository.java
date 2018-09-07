package kr.co.pjm.diving.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import kr.co.pjm.diving.common.domain.entity.DiveLog;

@Repository
public interface DiveLogRepository extends JpaRepository<DiveLog, Long>, QueryDslPredicateExecutor<DiveLog> {

}
