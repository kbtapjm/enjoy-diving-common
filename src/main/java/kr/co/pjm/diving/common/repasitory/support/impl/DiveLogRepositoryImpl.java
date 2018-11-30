package kr.co.pjm.diving.common.repasitory.support.impl;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import kr.co.pjm.diving.common.domain.entity.DiveLog;
import kr.co.pjm.diving.common.domain.entity.QDiveLog;
import kr.co.pjm.diving.common.repasitory.support.DiveLogRepositorySupport;

@Repository
public class DiveLogRepositoryImpl extends QueryDslRepositorySupport implements DiveLogRepositorySupport {

  public DiveLogRepositoryImpl() {
    super(DiveLog.class);
  }

  @Override
  public Long deleteByUser(String userId) {
    QDiveLog qDiveLog = QDiveLog.diveLog;
    
    Long result = delete(qDiveLog)
        .where(qDiveLog.regId.eq(userId))
        .execute();
    
    return result;
  }
  
}
