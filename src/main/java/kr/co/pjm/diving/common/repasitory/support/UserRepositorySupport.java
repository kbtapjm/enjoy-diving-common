package kr.co.pjm.diving.common.repasitory.support;

import kr.co.pjm.diving.common.domain.entity.User;

public interface UserRepositorySupport {
  
  long updatePassword(User user);

}
