package kr.co.pjm.diving.common.repasitory.support.impl;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import kr.co.pjm.diving.common.domain.entity.QUserConnection;
import kr.co.pjm.diving.common.domain.entity.UserConnection;
import kr.co.pjm.diving.common.repasitory.support.UserConnectionRepasitorySupport;

@Repository
public class UserConnectionRepasitoryImpl extends QueryDslRepositorySupport implements UserConnectionRepasitorySupport {

  public UserConnectionRepasitoryImpl() {
    super(UserConnection.class);
  }

  @Override
  public long deleteUserConnection(String userId) {
    QUserConnection qUserConnection = QUserConnection.userConnection;

    Long result = delete(qUserConnection).where(qUserConnection.userId.eq(userId)).execute();

    return result;
  }

}
