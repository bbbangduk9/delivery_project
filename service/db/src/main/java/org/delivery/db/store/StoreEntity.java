package org.delivery.db.store;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.delivery.db.BaseEntity;
import org.delivery.db.store.enums.StoreCategory;
import org.delivery.db.store.enums.StoreStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@SuperBuilder
@Entity
@Table(name = "store")
public class StoreEntity extends BaseEntity {
	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 150, nullable = false)
	private String address;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private StoreStatus status;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private StoreCategory category;


	private double star; //기본 0 설정해놨음

	@Column(length = 200, nullable = false)
	private String thumbnailUrl;

	@Column(precision = 11, scale = 4, nullable = false)//11자리까지 표현하고 소수점 4자리까지 표현
	private BigDecimal minimumAmount;

	@Column(precision = 11, scale = 4, nullable = false)//11자리까지 표현하고 소수점 4자리까지 표현
	private BigDecimal minimumDeliveryAmount;

	@Column(length = 20)
	private String phoneNumber;
}
