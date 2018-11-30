package kr.co.pjm.diving.common.repasitory.support.impl;

import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.core.dml.UpdateClause;
import com.querydsl.jpa.impl.JPAUpdateClause;

import kr.co.pjm.diving.common.domain.entity.QUserBasic;
import kr.co.pjm.diving.common.domain.entity.UserBasic;
import kr.co.pjm.diving.common.repasitory.support.UserBasicRepositorySupport;

@Repository
public class UserBasicRepositoryImpl extends QueryDslRepositorySupport implements UserBasicRepositorySupport {

  public UserBasicRepositoryImpl() {
    super(UserBasic.class);
  }

  @Override
  public long updateUserBasic(UserBasic userBasic) {
    QUserBasic qUserBasic = QUserBasic.userBasic;

    UpdateClause<JPAUpdateClause> update = update(qUserBasic).where(qUserBasic.id.eq(userBasic.getId()));

    if (!StringUtils.isEmpty(userBasic.getName())) {
      update.set(qUserBasic.name, userBasic.getName());
    }
    if (!StringUtils.isEmpty(userBasic.getNickname())) {
      update.set(qUserBasic.nickname, userBasic.getNickname());
    }
    if (!StringUtils.isEmpty(userBasic.getCountry())) {
      update.set(qUserBasic.country, userBasic.getCountry());
    }
    if (userBasic.getGender() != null) {
      update.set(qUserBasic.gender, userBasic.getGender());
    }
    if (!StringUtils.isEmpty(userBasic.getIntroduce())) {
      update.set(qUserBasic.introduce, userBasic.getIntroduce());
    }
    if (userBasic.getStatus() != null) {
      update.set(qUserBasic.status, userBasic.getStatus());
    }
    
    update.set(qUserBasic.updateDate, LocalDateTime.now());

    return update.execute();
  }

  @Override
  public long updateLoginDate(UserBasic userBasic) {
    QUserBasic qUserBasic = QUserBasic.userBasic;

    Long result = update(qUserBasic)
        .where(qUserBasic.id.eq(userBasic.getId()))
        .set(qUserBasic.loginDate, LocalDateTime.now())
        .execute();

    return result;
  }

}
