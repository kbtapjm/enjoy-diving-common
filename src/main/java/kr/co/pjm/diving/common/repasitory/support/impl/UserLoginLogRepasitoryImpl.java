package kr.co.pjm.diving.common.repasitory.support.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.pjm.diving.common.domain.entity.QUserLoginLog;
import kr.co.pjm.diving.common.domain.entity.UserLoginLog;
import kr.co.pjm.diving.common.repasitory.support.UserLoginLogRepasitorySupport;
import kr.co.pjm.diving.common.util.DateUtil;

@Repository
public class UserLoginLogRepasitoryImpl extends QueryDslRepositorySupport
    implements UserLoginLogRepasitorySupport {

  public UserLoginLogRepasitoryImpl() {
    super(UserLoginLog.class);
  }

  @PersistenceContext
  EntityManager entityManager;

  @Override
  public List<UserLoginLog> findByLoginDate(String loginDate, Pageable pageable) {
    QUserLoginLog qUserLoginLog = QUserLoginLog.userLoginLog;

    JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);

    List<Tuple> list = queryFactory
        .select(qUserLoginLog.email, qUserLoginLog.email.count())
        .from(qUserLoginLog)
        .where(qUserLoginLog.loginDateTime.eq(DateUtil.getInstance().toLocalDateTime(loginDate, DateUtil.FORMAT_YYYY_MM_DD)))   // BETWEEN 으로 변경
        .groupBy(qUserLoginLog.email, qUserLoginLog.loginDateTime)
        .fetch();
    
    // TODO : 일자별 그룹바이 쿼리 조회
    System.out.println("list111 : " + list.size());
    for (Tuple tuple : list ) {
      System.out.println("tuple : " + tuple);
    }

    return null;
  }



}
