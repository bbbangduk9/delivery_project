package org.delivey.storeadmin.domain.authorization;

import org.delivery.db.store.StoreRepository;
import org.delivery.db.store.enums.StoreStatus;
import org.delivey.storeadmin.domain.authorization.model.UserSession;
import org.delivey.storeadmin.domain.user.service.StoreUserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthorizationService implements UserDetailsService {

	private final StoreUserService storeUserService;
	private final StoreRepository storeRepository;

	//LOGIN 창에 USERNAME 입력시 여기의 username 으로 넘겨줌
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		var storeUserEntity = storeUserService.getRegisterUser(username);

		var storeEntity = storeRepository.findFirstByIdAndStatusOrderByIdDesc(
			storeUserEntity.get().getStoreId(),
			StoreStatus.REGISTERED
		);

		return storeUserEntity.map(it-> {

			var userSession = UserSession.builder()
				.userId(it.getId())
				.email(it.getEmail())
				.password(it.getPassword())
				.status(it.getStatus())
				.role(it.getRole())
				.registeredAt(it.getRegisteredAt())
				.unregisteredAt(it.getUnregisteredAt())
				.lastLoginAt(it.getLastLoginAt())

				.storeId(storeEntity.get().getId())
				.storeName(storeEntity.get().getName())
				.build()
				;

			return userSession;
		})
		.orElseThrow(()-> new UsernameNotFoundException(username)); //
	}
}
