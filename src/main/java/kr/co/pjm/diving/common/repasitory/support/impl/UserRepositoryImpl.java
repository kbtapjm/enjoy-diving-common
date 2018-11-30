package kr.co.pjm.diving.common.repasitory.support.impl;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import kr.co.pjm.diving.common.domain.entity.QUser;
import kr.co.pjm.diving.common.domain.entity.User;
import kr.co.pjm.diving.common.repasitory.support.UserRepositorySupport;

@Repository
public class UserRepositoryImpl extends QueryDslRepositorySupport implements UserRepositorySupport {
  
  public UserRepositoryImpl() {
    super(User.class);
  }

  @Override
  public long updatePassword(User user) {
    QUser qUser = QUser.user;
    
    Long result = update(qUser)
        .where(qUser.id.eq(user.getId()))
        .set(qUser.password, user.getPassword())
        .set(qUser.updateDate, LocalDateTime.now())
        .execute();
    
    return result;
  }

}
