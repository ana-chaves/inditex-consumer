package com.inditex.consumer.infrastructure.repository.h2;

import com.inditex.consumer.contract.Mapper;
import com.inditex.consumer.domain.model.Price;
import com.inditex.consumer.infrastructure.repository.h2.entity.PriceEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PriceMapper implements Mapper<PriceEntity, Price> {

	@Override
	public Price map(PriceEntity priceEntity) {

		return new Price().setBrandId(priceEntity.getBrandId())
			.setStartDate(priceEntity.getStartDate())
			.setEndDate(priceEntity.getEndDate())
			.setProductId(priceEntity.getProductId())
			.setPriceList(priceEntity.getPriceList())
			.setPriority(priceEntity.getPriority())
			.setPriceValue(priceEntity.getPrice())
			.setCurr(priceEntity.getCurrency());

	}

}