package org.delivery.api.domain.store.business;

import java.util.List;
import java.util.stream.Collectors;

import org.delivery.api.common.annotation.Business;
import org.delivery.api.domain.store.controller.model.StoreRegisterRequest;
import org.delivery.api.domain.store.controller.model.StoreResponse;
import org.delivery.api.domain.store.converter.StoreConverter;
import org.delivery.api.domain.store.service.StoreService;
import org.delivery.db.store.enums.StoreCategory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Business
public class StoreBusiness {
	private final StoreService storeService;
	private final StoreConverter storeConverter;

	public StoreResponse register(
		StoreRegisterRequest storeRegisterRequest
	){
		//req -> entity -> 저장된거 response로 바꾸기
		var entity = storeConverter.toEntity(storeRegisterRequest);
		var newEntity = storeService.register(entity);
		var response = storeConverter.toResponse(newEntity);
		return response;
	}

	public List<StoreResponse> searchCategory(
		StoreCategory storeCategory
	){
	    // entity list -> response list
		var storeList = storeService.searchByCategory(storeCategory);
		return storeList.stream()
			.map(storeConverter::toResponse)
			.collect(Collectors.toList());
	}
}
