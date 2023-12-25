package org.delivey.storeadmin.domain.user.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.delivery.db.storeuser.StoreUserEntity;
import org.delivery.db.storeuser.StoreUserRepository;
import org.delivery.db.storeuser.enums.StoreUserStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StoreUserService {

	private final StoreUserRepository storeUserRepository;

	private final PasswordEncoder passwordEncoder;
	public StoreUserEntity register(
		StoreUserEntity storeUserEntity
	){
		storeUserEntity.setStatus(StoreUserStatus.REGISTERED);
		storeUserEntity.setPassword(passwordEncoder.encode(storeUserEntity.getPassword())); //외부에서 넘겨준 엔티티 값을 인코딩해서 값을 세팅
		storeUserEntity.setRegisteredAt(LocalDateTime.now());
		return storeUserRepository.save(storeUserEntity);
	}

	public Optional<StoreUserEntity> getRegisterUser(String email){
		return storeUserRepository.findFirstByEmailAndStatusOrderByIdDesc(email, StoreUserStatus.REGISTERED);
	}


}
