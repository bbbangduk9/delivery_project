package org.delivery.api.domain.userordermenu.service;

import java.util.List;
import java.util.Optional;

import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.db.userordermenu.UserOrderMenuEntity;
import org.delivery.db.userordermenu.UserOrderMenuRepository;
import org.delivery.db.userordermenu.enums.UserOrderMenuStatus;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserOrderMenuService {

	private final UserOrderMenuRepository userOrderMenuRepository;

	//특정 사용자 주문 ID기반으로 주문내역 조회 , 상태 REGISTERED만 가져옴
	//null없으면 어짜피 셀렉 안될거라서 요구값 안나옴
	public List<UserOrderMenuEntity> getUserOrderMenu(Long userOrderId){
		return userOrderMenuRepository.findAllByUserOrderIdAndStatus(userOrderId, UserOrderMenuStatus.REGISTERED);
	}

	//새로운 주문내역
	public UserOrderMenuEntity order(
		UserOrderMenuEntity userOrderMenuEntity
	){
		return Optional.ofNullable(userOrderMenuEntity)
			.map(it ->{
				it.setStatus(UserOrderMenuStatus.REGISTERED);
				return userOrderMenuRepository.save(it);
			})
			.orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));

	}

}
