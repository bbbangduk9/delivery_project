package org.delivey.storeadmin.domain.authorization.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.delivery.db.storeuser.enums.StoreUserRole;
import org.delivery.db.storeuser.enums.StoreUserStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSession implements UserDetails {
	//user
	private Long userId;

	@Column(length = 100, nullable = false)
	private String email;

	@Column(length = 100, nullable = false)
	private String password;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private StoreUserStatus status;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private StoreUserRole role;

	private LocalDateTime registeredAt;

	private LocalDateTime unregisteredAt;

	private LocalDateTime lastLoginAt;

	//store
	private Long storeId;

	private String storeName;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { //
		return List.of(new SimpleGrantedAuthority(this.role.toString())); //TODO role 이 null 일때 에러 체크 필요
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() { //만료유무
		return this.status == StoreUserStatus.REGISTERED;
	}

	@Override
	public boolean isAccountNonLocked() { //잠금유무
		return this.status == StoreUserStatus.REGISTERED;
	}

	@Override
	public boolean isCredentialsNonExpired() { //비밀번호 만료유무
		return this.status == StoreUserStatus.REGISTERED;
	}

	@Override
	public boolean isEnabled() { //계정 활성화 유무
		return true;
	}
}
