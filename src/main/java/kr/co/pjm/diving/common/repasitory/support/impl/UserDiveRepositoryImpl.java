package kr.co.pjm.diving.common.repasitory.support.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.core.dml.UpdateClause;
import com.querydsl.jpa.impl.JPAUpdateClause;

import kr.co.pjm.diving.common.domain.dto.UserDiveDto;
import kr.co.pjm.diving.common.domain.entity.QUserDive;
import kr.co.pjm.diving.common.domain.entity.UserDive;
import kr.co.pjm.diving.common.repasitory.support.UserDiveRepositorySupport;

/**
 * <pre>
 * @Package Name : kr.co.pjm.diving.web.repasitory.support.impl
 * @Class Name : UserDiveRepositoryImpl.java
 * </pre>
 * 
 * @author : jmpark
 * @Date : 2018. 5. 2.
 * @Version : 1.0
 * @Description : 유저 다이브 레파지토리 확장 구현 클래스
 *
 */
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
    update.set(qUserDive.updateDate, new Date());
    
    return update.execute();
  }

}
