package org.delivery.api.domain.user.controller.model;

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
public class UserResponse {
	private Long id;

	private String name;

	private String email;
 	//패스워드는 내러주면안되니까지움
	private UserStatus status;

	private String address;

	private LocalDateTime registeredAt;

	private LocalDateTime unregisteredAt;

	private LocalDateTime lastLoginAt;

}
