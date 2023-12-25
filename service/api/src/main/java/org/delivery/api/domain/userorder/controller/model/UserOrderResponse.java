package org.delivery.api.domain.userorder.controller.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.delivery.db.userorder.enums.UserOrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOrderResponse {

	private Long id;

	private UserOrderStatus status;

	private BigDecimal amount;

	private LocalDateTime orderedAt;

	private LocalDateTime acceptedAt;

	private LocalDateTime cookingStartedAt; //조리시작시간

	private LocalDateTime deliveryStartedAt; //배달시작시간
}
