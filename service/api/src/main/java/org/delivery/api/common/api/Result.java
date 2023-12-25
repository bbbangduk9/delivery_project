package org.delivery.api.common.api;

import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.error.ErrorCodeIfs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {

	private Integer resultCode;
	private String resultMessage;
	private String resultDescription;

	public static Result OK() {
		return Result.builder()
				.resultCode(ErrorCode.OK.getErrorCode())
				.resultMessage(ErrorCode.OK.getDescription())
				.resultDescription("성공")
				.build();
	}
	public static Result ERROR(ErrorCodeIfs errorCodeIfs){
		return Result.builder()
			.resultCode(errorCodeIfs.getErrorCode())
			.resultMessage(errorCodeIfs.getDescription())
			.resultDescription("에러발생") //getLocalizedMessage() => 에러 메세지를 가져옴
			.build();
	}

	public static Result ERROR(ErrorCodeIfs errorCodeIfs, Throwable tx){
		return Result.builder()
			.resultCode(errorCodeIfs.getErrorCode())
			.resultMessage(errorCodeIfs.getDescription())
			.resultDescription(tx.getLocalizedMessage()) //server의 stacktrace 내림
			.build();
	}

	public static Result ERROR(ErrorCodeIfs errorCodeIfs, String description){ //에러코드,메세지(어떤상황이다~가 담긴)
		return Result.builder()
			.resultCode(errorCodeIfs.getErrorCode())
			.resultMessage(errorCodeIfs.getDescription())
			.resultDescription(description)
			.build();
	}
}
