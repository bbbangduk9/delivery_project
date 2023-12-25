package org.delivery.api.domain.token.ifs;

import java.util.Map;

import org.delivery.api.domain.token.model.TokenDto;

public interface TokenHelperIfs {

	TokenDto issueAccessToken(Map<String, Object> data); //accessToken이란 사용자가 로그인을 하면 발급되는 토큰
	TokenDto issueRefreshToken(Map<String, Object> data); //refreshToken이란 accessToken을 재발급 받을 수 있는 토큰

	Map<String, Object> validationTokenWithThrow(String token); //토큰이 유효한지 검증하는 메소드
}
