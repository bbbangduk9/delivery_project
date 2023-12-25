package org.delivey.storeadmin.domain.user.controller.model;

import javax.validation.constraints.NotBlank;

import org.delivery.db.storeuser.enums.StoreUserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreUserRegisterRequest {

	@NotBlank
	private String storeName;
	@NotBlank
	private String email;
	@NotBlank
	private String password;
	@NotBlank
	private StoreUserRole role;
}
