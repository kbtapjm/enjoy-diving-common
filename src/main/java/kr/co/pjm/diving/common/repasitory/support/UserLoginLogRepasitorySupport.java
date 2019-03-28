package kr.co.pjm.diving.common.repasitory.support;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.co.pjm.diving.common.domain.entity.UserLoginLog;

public interface UserLoginLogRepasitorySupport {

  Page<UserLoginLog> findByLoginDate(String loginDate, Pageable pageable);
  
}
