package kr.co.pjm.diving.common.repasitory.support;

import kr.co.pjm.diving.common.domain.entity.UserBasic;

public interface UserBasicRepositorySupport {

  long updateUserBasic(UserBasic userBasic);

  long updateLoginDate(UserBasic userBasic);

}
