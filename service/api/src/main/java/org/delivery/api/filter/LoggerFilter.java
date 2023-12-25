package org.delivery.api.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoggerFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
		IOException,
		ServletException {

		var req = new ContentCachingRequestWrapper((HttpServletRequest) request); //형변환 => 객체 만들어서 req,res 객체 얻어냄
		var res = new ContentCachingResponseWrapper((HttpServletResponse) response); //
		log.info("INIT URI : {}", req.getRequestURI());

		//실행전
		chain.doFilter(req, res);
		//실행후
		var headerNames = req.getHeaderNames();
		var headerValues = new StringBuilder();

		headerNames.asIterator().forEachRemaining(headerKey ->{
			var headerValue = req.getHeader(headerKey);

			// authorization-token : ???, user-agent : ??? 이런식으로 찍히게
			headerValues
				.append("[")
				.append(headerKey)
				.append(" : ")
				.append(headerValue)
				.append("] ");
		});

		var requestBody = new String(req.getContentAsByteArray()); //byte배열로 받아서 String으로 변환
		var uri = req.getRequestURI();//요청한 uri
		var method = req.getMethod();//요청한 메소드
		log.info(">>>>uri : {} , method : {} , header : {} , body : {}", uri, method, headerValues, requestBody);

		//response에 대한 정보
		var responseHeaderValues = new StringBuilder();

		res.getHeaderNames().forEach(headerKey ->{
			var headerValue = res.getHeader(headerKey);

			responseHeaderValues
				.append("[")
				.append(headerKey)
				.append(" : ")
				.append(headerValue)
				.append("] ");

		});

		var responseBody = new String(res.getContentAsByteArray());
		log.info("<<<< uri : {} , method : {} , header : {} , body : {}", uri, method, responseHeaderValues, responseBody);

		res.copyBodyToResponse(); // 초기화해줌 => 다시 읽을 수 있게 안해주면 responsebody 비어있음
	}
}
