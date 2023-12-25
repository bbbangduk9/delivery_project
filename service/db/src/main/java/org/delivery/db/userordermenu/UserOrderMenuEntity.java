package org.delivery.db.userordermenu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.delivery.db.BaseEntity;
import org.delivery.db.userordermenu.enums.UserOrderMenuStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@SuperBuilder
@Entity
@Table(name="user_order_menu")
public class UserOrderMenuEntity extends BaseEntity {

	@Column(nullable = false) //테이블에 써져있지만 테스트 떄 사용하기 위해
	private Long userOrderId; //1 : n 입장에서

	@Column(nullable = false)
	private Long storeMenuId; //1 : n 입장에서

	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private UserOrderMenuStatus status;


}
