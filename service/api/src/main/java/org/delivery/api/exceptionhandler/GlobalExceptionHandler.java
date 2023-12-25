package org.delivery.api.exceptionhandler;

import org.delivery.api.common.api.Api;
import org.delivery.api.common.error.ErrorCode;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@Order(value = Integer.MAX_VALUE) //우선순위, 가장 마지막에 실행 적용
public class GlobalExceptionHandler{

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Api<Object>> exception(
		Exception exception
	){
		log.error("",exception);

		return ResponseEntity //클라이언트한테 알려줄 필요 없으니까
			.status(500)
			.body(Api.ERROR(ErrorCode.SERVER_ERROR));
	}
}
