package org.delivery.api.config.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration //jpa로 등록하기 위해 설정들을 달아줭되는데 이런 설정들을 담고 있는 클래스라는 것을 알려주는 어노테이션
@EntityScan(basePackages = "org.delivery.db") //db에 있는 entity 어노테이션 붙은애들 다 스캔하겠다.
@EnableJpaRepositories(basePackages = "org.delivery.db") //db에 있는 repository 어노테이션 붙은애들 다 스캔하겠다.
//원래 패키지하위에 어노테이션 달린거 찾아서 빈으로 등록 => 멀티모듈 사용해서 불가해서 이런 어노테이션 추가해줌
public class JpaConfig {
}
