package kr.co.pjm.diving.common.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ErrorDto {
  private String message;
  private int status;
  private String path;
  //private Date timestamp;

  @Builder
  public ErrorDto(String message, int status, String path) {
    this.message = message;
    this.status = status;
    this.path = path;
  }
  
}
