package org.delivey.storeadmin.domain.user.controller;

import javax.validation.Valid;

import org.delivey.storeadmin.domain.user.business.StoreUserBusiness;
import org.delivey.storeadmin.domain.user.controller.model.StoreUserRegisterRequest;
import org.delivey.storeadmin.domain.user.controller.model.StoreUserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/open-api/store-user")
public class StoreUserOpenApiController {

	private final StoreUserBusiness storeUserBusiness;

	// api꺼 가져오는건 exceptionhandler등 같이 가져와져서 가져오는거 비추
	@PostMapping("")
	public StoreUserResponse register(
		@Valid
		@RequestBody StoreUserRegisterRequest request
	){
	    var response = storeUserBusiness.register(request);
		return response;
	}
}
