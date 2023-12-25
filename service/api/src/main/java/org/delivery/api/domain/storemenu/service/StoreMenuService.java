package org.delivery.api.domain.storemenu.service;

import java.util.List;
import java.util.Optional;

import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.db.storemenu.StoreMenuEntity;
import org.delivery.db.storemenu.StoreMenuRepository;
import org.delivery.db.storemenu.enums.StoreMenuStatus;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StoreMenuService {

	private final StoreMenuRepository storeMenuRepository;

	//전체
	public StoreMenuEntity getStoreMenuWithThrow(Long id){
		var entity = storeMenuRepository.findFirstByIdAndStatusOrderByIdDesc(id, StoreMenuStatus.REGISTERED);
		return entity.orElseThrow(()->new ApiException(ErrorCode.NULL_POINT));
	}
	//특정
	public List<StoreMenuEntity> getStoreMenuByStoreId(Long storeId){
		return storeMenuRepository.findAllByStoreIdAndStatusOrderBySequenceDesc(storeId, StoreMenuStatus.REGISTERED);
	}
	public StoreMenuEntity register(
		StoreMenuEntity storeMenuEntity
	){
		return Optional.ofNullable(storeMenuEntity)
			.map(it ->{
				it.setStatus(StoreMenuStatus.REGISTERED);
				return storeMenuRepository.save(it);
			})
			.orElseThrow(()->new ApiException(ErrorCode.NULL_POINT));
	}
}
