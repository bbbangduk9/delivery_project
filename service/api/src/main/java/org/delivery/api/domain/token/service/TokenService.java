package org.delivery.api.domain.token.service;

import java.util.HashMap;
import java.util.Objects;

import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.api.domain.token.ifs.TokenHelperIfs;
import org.delivery.api.domain.token.model.TokenDto;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TokenService {

	private final TokenHelperIfs tokenHelperIfs; //jwt,uuid등 토큰 헬퍼

	public TokenDto issueAccessToken(Long userId){// id를 넘길때만 데이터 넘김
		var data =new HashMap<String, Object>();
		data.put("userId", userId);
		return tokenHelperIfs.issueAccessToken(data);
	}

	public TokenDto issueRefreshToken(Long userId){
		var data =new HashMap<String, Object>();
		data.put("userId", userId);
		return tokenHelperIfs.issueAccessToken(data);
	}

	public Long  validationToken(String token){ //검증
		//validation해서 로직에 사용할 값을 꺼내 해당 값을 리턴
		var map = tokenHelperIfs.validationTokenWithThrow(token);
		var userId = map.get("userId");

		Objects.requireNonNull(userId, ()->{ //유저아이디 없으면 널포인트 , 아니면 Long 타입 id 내려감
			throw new ApiException(ErrorCode.NULL_POINT);
		});

		return Long.parseLong(userId.toString());
	}
}
