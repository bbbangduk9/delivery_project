package org.delivery.db.user.enums;

import java.net.Proxy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserStatus {
	//지정된 데이터가 들어가게 하기 위해
	REGISTERED("등록"),
	UNREGISTERED("해지"),
	;

	private final String description;

}


