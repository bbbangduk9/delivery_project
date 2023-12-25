package org.delivery.db.storemenu;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.delivery.db.BaseEntity;
import org.delivery.db.storemenu.enums.StoreMenuStatus;

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
@Table(name="store_menu")
public class StoreMenuEntity extends BaseEntity {

	@Column(nullable = false)
	private Long storeId;

	@Column(length = 100, nullable = false)
	private String name;

	@Column(precision = 11, scale = 4, nullable = false)
	private BigDecimal amount;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private StoreMenuStatus status;

	@Column(length = 200, nullable = false)
	private String thumbnailUrl;


	private int likeCount;

	private int sequence;


}
