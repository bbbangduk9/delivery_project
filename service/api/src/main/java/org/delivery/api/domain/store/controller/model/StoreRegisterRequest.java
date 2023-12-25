package org.delivery.api.domain.store.controller.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.delivery.db.store.enums.StoreCategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StoreRegisterRequest {
	//엔티티와 같은거 아님
	@NotBlank
	private String name;

	@NotBlank //"", " " , null
	private String address;

	@NotNull
	private StoreCategory storeCategory;

	@NotBlank
	private String thumbnailUrl;

	@NotNull
	private BigDecimal minimumAmount;

	@NotNull
	private BigDecimal minimumDeliveryAmount;

	@NotBlank
	private String phoneNumber;
}
