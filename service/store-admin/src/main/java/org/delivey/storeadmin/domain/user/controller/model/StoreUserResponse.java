package org.delivey.storeadmin.domain.user.controller.model;

import java.time.LocalDateTime;

import org.delivery.db.storeuser.enums.StoreUserRole;
import org.delivery.db.storeuser.enums.StoreUserStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreUserResponse {

	//클래스 2개 만들고 변수에 inner class로 넣어줌 => storeResponse.~ 이런식으로 접근 가능
	private UserResponse user;
	private StoreResponse store;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class UserResponse{

		private Long id;

		private String email;

		private StoreUserStatus status;

		private StoreUserRole role;

		private LocalDateTime registeredAt;

		private LocalDateTime unregisteredAt;

		private LocalDateTime lastLoginAt;
	}
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class StoreResponse{

		private Long id;

		private String name;
	}
}
