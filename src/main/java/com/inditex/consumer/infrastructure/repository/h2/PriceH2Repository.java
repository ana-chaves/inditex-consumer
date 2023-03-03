package com.inditex.consumer.infrastructure.repository.h2;

import com.inditex.consumer.contract.Mapper;
import com.inditex.consumer.domain.model.Price;
import com.inditex.consumer.domain.repository.PricesRepository;
import com.inditex.consumer.domain.use_case.PricesFilter;
import com.inditex.consumer.infrastructure.repository.h2.entity.PriceEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class PriceH2Repository implements PricesRepository {

	private final IPriceDao pricesDao;

	private final Mapper<PriceEntity, Price> priceMapper;

	@Override
	public Optional<Price> findAllByStartDateEndDateProductIdBrandId(PricesFilter filter) {
		List<PriceEntity> prices = this.pricesDao.findAllByStartDateGreaterThanEqualAndEndDateLessThanEqualAndProductIdAndBrandId(
			filter.getDate(),
			filter.getProductId(),
			filter.getBrandId()
		);

		return !prices.isEmpty() ? Optional.of(this.priceMapper.map(prices.get(0))) : Optional.empty();

	}

}
