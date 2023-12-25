package org.delivey.storeadmin.domain.user.business;

import org.delivery.db.store.StoreEntity;
import org.delivery.db.store.StoreRepository;
import org.delivery.db.store.enums.StoreStatus;
import org.delivery.db.storeuser.StoreUserEntity;
import org.delivey.storeadmin.domain.user.controller.model.StoreUserRegisterRequest;
import org.delivey.storeadmin.domain.user.controller.model.StoreUserResponse;
import org.delivey.storeadmin.domain.user.converter.StoreUserConverter;
import org.delivey.storeadmin.domain.user.service.StoreUserService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StoreUserBusiness {

	private final StoreUserConverter storeUserConverter;
	private final StoreUserService storeUserService;
	private final StoreRepository storeRepository; // TODO SERVICE로 변경하기
	public StoreUserResponse register(
		StoreUserRegisterRequest request
	){
		var storeEntity = storeRepository.findFirstByNameAndStatusOrderByIdDesc(request.getStoreName(), StoreStatus.REGISTERED);

		var entity = storeUserConverter.toEntity(request, storeEntity.get());

		var newEntity = storeUserService.register(entity);

		var response = storeUserConverter.toResponse(newEntity, storeEntity.get());

		return response;
	}
}
