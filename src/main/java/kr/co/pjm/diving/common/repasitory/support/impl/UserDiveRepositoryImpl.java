package kr.co.pjm.diving.common.repasitory.support.impl;

import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.core.dml.UpdateClause;
import com.querydsl.jpa.impl.JPAUpdateClause;

import kr.co.pjm.diving.common.domain.entity.QUserDive;
import kr.co.pjm.diving.common.domain.entity.UserDive;
import kr.co.pjm.diving.common.repasitory.support.UserDiveRepositorySupport;

@Repository
public class UserDiveRepositoryImpl extends QueryDslRepositorySupport implements UserDiveRepositorySupport {

  public UserDiveRepositoryImpl() {
    super(UserDive.class);
  }

  @Override
  public long updateUserDive(UserDive userDive) {
    QUserDive qUserDive = QUserDive.userDive;

    UpdateClause<JPAUpdateClause> update = update(qUserDive).where(qUserDive.id.eq(userDive.getId()));

    if (!StringUtils.isEmpty(userDive.getDiveGroup())) {
      update.set(qUserDive.diveGroup, userDive.getDiveGroup());
    }
    if (!StringUtils.isEmpty(userDive.getDiveLevel())) {
      update.set(qUserDive.diveLevel, userDive.getDiveLevel());
    }
    if (!StringUtils.isEmpty(userDive.getTeam())) {
      update.set(qUserDive.team, userDive.getTeam());
    }
    if (!StringUtils.isEmpty(userDive.getSignature())) {
      update.set(qUserDive.signature, userDive.getSignature());
    }
    update.set(qUserDive.updateDate, LocalDateTime.now());

    return update.execute();
  }

}
