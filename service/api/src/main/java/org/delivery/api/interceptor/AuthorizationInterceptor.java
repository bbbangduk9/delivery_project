package org.delivery.api.interceptor;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.error.TokenErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.api.domain.token.business.TokenBusiness;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

	private final TokenBusiness tokenBusiness;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("Authorization Interceptor url : {}", request.getRequestURI());

		//WEB, 특히 크롬의 경우 API 요청전에 Get, Post Options 요청을 보내는데 이때는 인증을 하지 않아도 되기 때문에 통과시킴
		if(HttpMethod.OPTIONS.matches(request.getMethod())){
			return true;
		}
		//js,html,png resource를 요청하는 경우 통과시킴
		if (handler instanceof ResourceHttpRequestHandler){
			return true;
		}
		//TODO header 검증
		var accessToken = request.getHeader("authorization-token");
		if (accessToken == null){
			throw new ApiException(TokenErrorCode.AUTHORIZATION_TOKEN_NOT_FOUND);
		}

		var userId = tokenBusiness.validationAccessToken(accessToken);

		//localthread로 한가지 리퀘스트에 대해 유효,글로벌하게 쓰레드 로컬에 저장
		if(userId != null){
			var requestContext = Objects.requireNonNull(RequestContextHolder.getRequestAttributes());//
			requestContext.setAttribute("userId", userId, RequestAttributes.SCOPE_REQUEST); //scope_request는 한번만 요청
			return true; //일단 통과 처리
	}
		throw new ApiException(ErrorCode.BAD_REQUEST, "인증실패");
	}
}
