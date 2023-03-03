package com.inditex.consumer.infrastructure.repository.h2;

import com.inditex.consumer.infrastructure.repository.h2.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface IPriceDao extends JpaRepository<PriceEntity, Long> {

	@Query(value = "from PriceEntity p where start_date <= :date AND end_date >= :date AND product_id= :productId AND brand_id= :brandId order by priority desc")
	List<PriceEntity> findAllByStartDateGreaterThanEqualAndEndDateLessThanEqualAndProductIdAndBrandId(
		LocalDateTime date,
		Long productId,
		Long brandId
	);
}
