package org.delivery.db.store.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StoreStatus {
	//실제로는 등록 전 대기 등록 해지 사이에 해지신청 등 들어갈 수 있음 => 고민해보자
	REGISTERED("등록"),
	UNREGISTERED("해지"),
	;
	private String description;
}
