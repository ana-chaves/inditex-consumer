package com.inditex.consumer.domain.repository;

import com.inditex.consumer.domain.model.Price;
import com.inditex.consumer.domain.use_case.PricesFilter;

import java.util.Optional;

public interface PricesRepository {
	Optional<Price> findAllByStartDateEndDateProductIdBrandId(PricesFilter filter);
}
