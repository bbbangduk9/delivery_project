package org.delivery.api.common.api;

import javax.validation.Valid;

import org.delivery.api.common.error.ErrorCodeIfs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Api<T> {

	private Result result;

	@Valid
	private T body;

	public static <T> Api<T> OK(T data) {
		var api = new Api<T>();
		api.result = Result.OK(); //
		api.body = data;
		return api;
	}

	public static Api<Object> ERROR(Result result) { //body에 셋팅할게 없어서 제네릭 대신 오브젝트로 셋팅
		var api = new Api<Object>();
		api.result = result; // result 밖에서 셋팅해서 넘겨줌
		return api;
	}

	public static Api<Object> ERROR(ErrorCodeIfs errorCodeIfs) { //에러코드 직접 받음
		var api = new Api<Object>();
		api.result = Result.ERROR(errorCodeIfs);
		return api;
	}

	public static Api<Object> ERROR(ErrorCodeIfs errorCodeIfs, Throwable tx) {
		var api = new Api<Object>();
		api.result = Result.ERROR(errorCodeIfs, tx);
		return api;
	}

	public static Api<Object> ERROR(ErrorCodeIfs errorCodeIfs, String description) {
		var api = new Api<Object>();
		api.result = Result.ERROR(errorCodeIfs, description);
		return api;
	}
}
