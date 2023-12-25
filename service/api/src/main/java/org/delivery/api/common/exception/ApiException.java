package org.delivery.api.common.exception;

import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.error.ErrorCodeIfs;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException implements ApiExceptionIfs{

	private final ErrorCodeIfs errorCodeIfs;
	private final String errorDescription; //상세 에러 메세지

	public  ApiException(ErrorCodeIfs errorCodeIfs) {
		super(errorCodeIfs.getDescription()); //super 쓰는 이유 => 부모의 생성자를 호출하기 위해서
		this.errorCodeIfs = errorCodeIfs;
		this.errorDescription = errorCodeIfs.getDescription();
	}

	public  ApiException(ErrorCodeIfs errorCodeIfs, String errorDescription) {
		super(errorDescription); //super 쓰는 이유 => 부모의 생성자를 호출하기 위해서
		this.errorCodeIfs = errorCodeIfs;
		this.errorDescription = errorCodeIfs.getDescription();
	}
	public  ApiException(ErrorCodeIfs errorCodeIfs, Throwable tx) {
		super(tx); //super 쓰는 이유 => 부모의 생성자를 호출하기 위해서
		this.errorCodeIfs = errorCodeIfs;
		this.errorDescription = errorCodeIfs.getDescription();
	}
	public  ApiException(ErrorCodeIfs errorCodeIfs, Throwable tx, String errorDescription){ //모든 걸 다 받음
		super(tx); //super 쓰는 이유 => 부모의 생성자를 호출하기 위해서
		this.errorCodeIfs = errorCodeIfs;
		this.errorDescription = errorDescription;
	}

}
