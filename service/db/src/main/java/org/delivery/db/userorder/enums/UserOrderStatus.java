package org.delivery.db.userorder.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserOrderStatus {

	REGISTERED("등록"),
	UNREGISTERED("해지"),

	ORDER("주문"),
	ACCEPT("확인"),
	COOKING("요리중"),
	DELIVERY("배달중"),
	RECEIVE("완료"),
	;
	/* 어노테이션 달거나 생성자 만들어주거나
	UserOrderStatus(String description){
		this.description = description;
	}*/
	private String description;
}
