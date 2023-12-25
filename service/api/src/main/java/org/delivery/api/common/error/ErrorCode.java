package org.delivery.api.common.error;

//에러코드 관리시 enum 쓰는 이유 => 찾아보기

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode implements ErrorCodeIfs{
	//httpstatus랑 차이점 = 여긴 우리 서버 기준이라 반드시 일치는 x
	OK(200, 200, "성공"),
	BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), 400, "잘못된 요청"), //

	SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), 500, "서버 오류"), //

	NULL_POINT(HttpStatus.INTERNAL_SERVER_ERROR.value(), 512, "Null point"), //
	;
	//enum 클래스에 들어가는 값  => 변경 되지 않아야 하기 때문에 final 사용
	private final Integer httpStatusCode;
	private final Integer errorCode;
	private final String description;


/* 사실 @Getter로 하면됨
	@Override
	public Integer getHttpStatusCode() {
		return this.httpStatusCode;
	}

	@Override
	public Integer getErrorCode() {
		return this.errorCode;
	}

	@Override
	public String getDescription() {
		return this.description;
	}*/
}
