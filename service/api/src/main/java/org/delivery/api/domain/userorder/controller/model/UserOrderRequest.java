package org.delivery.api.domain.userorder.controller.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOrderRequest {

	//주문
	//특정 사용자가 특정 메뉴를 주문
	//특정 사용자 = 로그인된 세션에 들어있는 사용자
	//특정 메뉴 id

	//하나만 주문하는게 아니라 아메리카노+카페라떼 ..와 같이 여러개 주문하니까
	@NotNull
	private List<Long> storeMenuIdList; // 사용자는 로그인된 사용자 쓸거라 별도로 필요x
}
