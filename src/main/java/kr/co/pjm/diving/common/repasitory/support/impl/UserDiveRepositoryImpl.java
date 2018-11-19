package kr.co.pjm.diving.common.repasitory.support.impl;

import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.core.dml.UpdateClause;
import com.querydsl.jpa.impl.JPAUpdateClause;

import kr.co.pjm.diving.common.domain.dto.UserDiveDto;
import kr.co.pjm.diving.common.domain.entity.QUserDive;
import kr.co.pjm.diving.common.domain.entity.UserDive;
import kr.co.pjm.diving.common.repasitory.support.UserDiveRepositorySupport;

@Repository
public class UserDiveRepositoryImpl extends QueryDslRepositorySupport implements UserDiveRepositorySupport {

  public UserDiveRepositoryImpl() {
    super(UserDive.class);
  }

  @Override
  public long updateUserDive(UserDiveDto userDiveDto) {
    QUserDive qUserDive = QUserDive.userDive;

    UpdateClause<JPAUpdateClause> update = update(qUserDive).where(qUserDive.id.eq(userDiveDto.getId()));

    if (!StringUtils.isEmpty(userDiveDto.getDiveGroup())) {
      update.set(qUserDive.diveGroup, userDiveDto.getDiveGroup());
    }
    if (!StringUtils.isEmpty(userDiveDto.getDiveLevel())) {
      update.set(qUserDive.diveLevel, userDiveDto.getDiveLevel());
    }
    if (!StringUtils.isEmpty(userDiveDto.getTeam())) {
      update.set(qUserDive.team, userDiveDto.getTeam());
    }
    if (!StringUtils.isEmpty(userDiveDto.getSignature())) {
      update.set(qUserDive.signature, userDiveDto.getSignature());
    }
    update.set(qUserDive.updateDate, LocalDateTime.now());

    return update.execute();
  }

}
