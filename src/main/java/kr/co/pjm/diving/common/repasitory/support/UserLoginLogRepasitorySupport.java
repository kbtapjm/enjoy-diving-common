package kr.co.pjm.diving.common.repasitory.support;

import java.util.List;

import org.springframework.data.domain.Pageable;

import kr.co.pjm.diving.common.domain.entity.UserLoginLog;

public interface UserLoginLogRepasitorySupport {

  List<UserLoginLog> findByLoginDate(String loginDate, Pageable pageable);
}
