package org.delivery.api.common.error;


import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserErrorCode implements ErrorCodeIfs {

	USER_NOT_FOUND(400, 1404, "사용자를 찾을 수 없음."),

	;
	//enum 클래스에 들어가는 값  => 변경 되지 않아야 하기 때문에 final 사용 , 상속 받을 수 없음 => interface사용해줌
	private final Integer httpStatusCode;
	private final Integer errorCode;
	private final String description;
}
