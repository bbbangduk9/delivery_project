package org.delivery.db.userordermenu.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserOrderMenuStatus {

	REGISTERED("등록"),
	UNREGISTERED("해지"),
	;
	/* 어노테이션 달거나 생성자 만들어주거나
	UserOrderStatus(String description){
		this.description = description;
	}*/
	private String description;
}
