package kr.co.pjm.diving.common.repasitory.support;

import kr.co.pjm.diving.common.domain.dto.UserBasicDto;

public interface UserBasicRepositorySupport {

  long updateUserBasic(UserBasicDto userBasicDto);

  long updateLoginDate(UserBasicDto userBasicDto);

}
