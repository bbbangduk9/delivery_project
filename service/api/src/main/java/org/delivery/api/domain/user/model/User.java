package org.delivery.api.domain.user.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.delivery.db.user.enums.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	private Long id;

	private String name;

	private String email;

	private String password;

	private UserStatus status; // 지정된 데이터만 들어가게 하기위해 enum타입 userstatus 사용

	private String address;

	private LocalDateTime registeredAt;

	private LocalDateTime unregisteredAt;

	private LocalDateTime lastLoginAt;

}
