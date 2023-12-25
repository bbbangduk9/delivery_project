package org.delivery.api.exceptionhandler;

import org.delivery.api.common.api.Api;
import org.delivery.api.common.exception.ApiException;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice //모든 컨트롤러에 적용
@Order(value = Integer.MIN_VALUE) //최우선처리
public class ApiExceptionHandler {

	@ExceptionHandler(value = ApiException.class)
	public ResponseEntity<Api<Object>> apiException( //발생하는 모든 예외 캐치
		ApiException apiException
	){
		log.error("", apiException);

		var errorCode = apiException.getErrorCodeIfs();

		return ResponseEntity
			.status(errorCode.getHttpStatusCode())
			.body(
				Api.ERROR(errorCode, apiException.getErrorDescription())
			);
	}
}
