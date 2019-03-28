package kr.co.pjm.diving.common.repasitory.support.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
public class UserLoginLogRepasitoryImpl extends QueryDslRepositorySupport implements UserLoginLogRepasitorySupport {

  public UserLoginLogRepasitoryImpl() {
    super(UserLoginLog.class);
  }

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Page<UserLoginLog> findByLoginDate(String loginDate, Pageable pageable) {
    List<UserLoginLog> userLoginLogs = new ArrayList<UserLoginLog>();
    
    QUserLoginLog qUserLoginLog = QUserLoginLog.userLoginLog;
    
    JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
    
    LocalDateTime from = DateUtil.getInstance().toLocalDateTime(loginDate.concat(" 00:00:01"), DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
    LocalDateTime to = DateUtil.getInstance().toLocalDateTime(loginDate.concat(" 23:23:59"), DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);

    List<Tuple> list = queryFactory
        .select(qUserLoginLog.email, qUserLoginLog.email.count(), qUserLoginLog.user)
        .from(qUserLoginLog)
        .where(qUserLoginLog.loginDateTime.between(from, to))
        .groupBy(qUserLoginLog.email, qUserLoginLog.user)
        .limit(pageable.getPageSize())
        .offset(pageable.getOffset())
        .fetch();
    
    for (Tuple tuple : list) {
      UserLoginLog userLoginLog = UserLoginLog.builder()
          .email(tuple.get(qUserLoginLog.email).toString())
          .loginDate(DateUtil.getInstance().toLocalDate(loginDate, DateUtil.FORMAT_YYYY_MM_DD))
          .loginCount(tuple.get(qUserLoginLog.email.count()))
          .user(tuple.get(qUserLoginLog.user))
          .build();
      
      userLoginLogs.add(userLoginLog);
    }
    
    return new PageImpl<UserLoginLog>(userLoginLogs, new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort()), userLoginLogs.size());
  }


}
