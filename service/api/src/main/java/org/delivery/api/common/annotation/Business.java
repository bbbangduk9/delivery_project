package org.delivery.api.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

@Target(ElementType.TYPE)  //어노테이션이 적용할 위치를 지정
@Retention(RetentionPolicy.RUNTIME) //어노테이션 정보를 언제까지 유지할 것인가
@Service //스프링에서 감지
public @interface Business {
	@AliasFor(annotation = Service.class) //스프링에서 감지
	String value() default "";
}
