package org.delivery.api.common.exception;

import org.delivery.api.common.error.ErrorCodeIfs;

public interface ApiExceptionIfs {
	//우리가 커스텀한 인터페이스에선 반드시 정의되어야함
	ErrorCodeIfs getErrorCodeIfs();
	String getErrorDescription();
}
