package org.delivery.db.store;

import java.util.List;
import java.util.Optional;

import org.delivery.db.store.enums.StoreCategory;
import org.delivery.db.store.enums.StoreStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<StoreEntity, Long> {

	//특정 우효한 스토어(id+status)
	//select * from store where id = ? and status = ? order by id desc limit 1;
	Optional<StoreEntity>findFirstByIdAndStatusOrderByIdDesc(Long id, StoreStatus status);
	//유효한 스토어 리스트
	//select * from store where status = ? order by id desc;
	List<StoreEntity> findAllByStatusOrderByIdDesc(StoreStatus status);
	//유효한 특정 카테고리의 스토어 리스트 , 시퀀스 등 이용해 다른 것도 가능 ex)주문많은순,최신순 ..
	List<StoreEntity> findAllByStatusAndCategoryOrderByStarDesc(StoreStatus status, StoreCategory storeCategory);

	//select * from store where name = ? and status = ? order by id desc limit 1;
	Optional<StoreEntity> findFirstByNameAndStatusOrderByIdDesc(String name, StoreStatus status);  //의미 => 이름이 같은 스토어가 여러개 있을 수 있으니까 최신것만
}
