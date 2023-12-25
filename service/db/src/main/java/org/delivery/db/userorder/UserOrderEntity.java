package org.delivery.db.userorder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.delivery.db.BaseEntity;
import org.delivery.db.userorder.enums.UserOrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true) //BaseEntity 상속받은 필드까지 equals, hashcode에 포함
@SuperBuilder
@Entity
@Table(name="user_order")
public class UserOrderEntity extends BaseEntity {

	@Column(nullable = false)
	private Long userId; // user table i:n

	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private UserOrderStatus status;

	@Column(precision = 11, scale = 4, nullable = false)
	private BigDecimal amount;

	private LocalDateTime orderedAt;

	private LocalDateTime acceptedAt;

	private LocalDateTime cookingStartedAt; //조리시작시간

	private LocalDateTime deliveryStartedAt; //배달시작시간

	private LocalDateTime receivedAt; //배달받은시간

}
