package org.delivery.api.domain.storemenu.controller;

import java.util.List;

import org.delivery.api.common.api.Api;
import org.delivery.api.domain.storemenu.business.StoreMenuBusiness;
import org.delivery.api.domain.storemenu.controller.model.StoreMenuResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/store-menu")
public class StoreMenuApiController {
	//배달앱에서 클릭시에 가게 메뉴 정보
	//로그인 상태에서 메뉴 가져옴 -> 등록된 메뉴만 출현 -> store menu로 response converting해서 컬렉션으로 리스트 만들어서 던져줌
	private final StoreMenuBusiness storeMenuBusiness;

	@GetMapping("/search")
	public Api<List<StoreMenuResponse>> search( //
		@RequestParam Long storeId
	){
		var response = storeMenuBusiness.search(storeId);
		return Api.OK(response);
	}

}
