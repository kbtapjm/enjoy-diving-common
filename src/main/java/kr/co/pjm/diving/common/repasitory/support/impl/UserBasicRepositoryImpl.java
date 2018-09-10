package kr.co.pjm.diving.common.repasitory.support.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.core.dml.UpdateClause;
import com.querydsl.jpa.impl.JPAUpdateClause;

import kr.co.pjm.diving.common.domain.dto.UserBasicDto;
import kr.co.pjm.diving.common.domain.entity.QUserBasic;
import kr.co.pjm.diving.common.domain.entity.UserBasic;
import kr.co.pjm.diving.common.repasitory.support.UserBasicRepositorySupport;

/**
 * <pre>
 * @Package Name : kr.co.pjm.diving.web.repasitory.support.impl
 * @Class Name : UserBasicRepositoryImpl.java
 * </pre>
 * 
 * @author : jmpark
 * @Date : 2017. 5. 9.
 * @Version : 1.0
 * @Description : 유저 기본 레파지토리 확장 구현 클래스
 *
 */
@Repository
public class UserBasicRepositoryImpl extends QueryDslRepositorySupport implements UserBasicRepositorySupport {
  
  public UserBasicRepositoryImpl() {
    super(UserBasic.class);
  }

  @Override
  public long updateUserBasic(UserBasicDto userBasicDto) {
    QUserBasic qUserBasic = QUserBasic.userBasic;
    
    UpdateClause<JPAUpdateClause> update = update(qUserBasic).where(qUserBasic.id.eq(userBasicDto.getId()));
    
    if (!StringUtils.isEmpty(userBasicDto.getName())) {
      update.set(qUserBasic.name, userBasicDto.getName());
    }
    if (!StringUtils.isEmpty(userBasicDto.getNickname())) {
      update.set(qUserBasic.nickname, userBasicDto.getNickname());
    }
    if (!StringUtils.isEmpty(userBasicDto.getCountry())) {
      update.set(qUserBasic.country, userBasicDto.getCountry());
    }
    if (userBasicDto.getGender() != null) {
      update.set(qUserBasic.gender, userBasicDto.getGender());
    }
    if (!StringUtils.isEmpty(userBasicDto.getIntroduce())) {
      update.set(qUserBasic.introduce, userBasicDto.getIntroduce());
    }
    update.set(qUserBasic.updateDate, new Date());
    
    return update.execute();
  }

  @Override
  public long updateLoginDate(UserBasicDto userBasicDto) {
    QUserBasic qUserBasic = QUserBasic.userBasic;
    
    Long result = update(qUserBasic)
        .where(qUserBasic.id.eq(userBasicDto.getId()))
        .set(qUserBasic.loginDate, new Date())
        .execute();
    
    return result;
  }
  
}
