package org.delivery.db.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.delivery.db.BaseEntity;
import org.delivery.db.user.enums.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity // entity에 value =user라 쓰면 value에 있는 이름을 가지고 entity 이름을 쓰겠다.
@Table(name = "user") // userentity에 다른 이름 적혀있더라도 테이블 이름 가지고 가서 db와 매칭
@Data
@EqualsAndHashCode(callSuper = true) //의미 => 상속받은 필드까지 비교
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder // builder랑 차이점 = builder는 생성자를 만들어줘야하지만, SuperBuilder는 생성자를 만들어주지 않아도 된다.
public class UserEntity extends BaseEntity {

	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 100, nullable = false)
	private String email;

	@Column(length = 100, nullable = false)
	private String password;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING) // enum 타입을 string으로 바꿔서 db에 저장
	private UserStatus status; // 지정된 데이터만 들어가게 하기위해 enum타입 userstatus 사용

	@Column(length = 150, nullable = false)
	private String address;

	private LocalDateTime registeredAt;
	private LocalDateTime unregisteredAt;
	private LocalDateTime lastLoginAt;

}
