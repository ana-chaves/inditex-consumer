package com.inditex.consumer.application.controller.response;

import com.inditex.consumer.contract.Mapper;
import com.inditex.consumer.domain.model.Price;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PricesResponseMapper implements Mapper<Price, PricesResponse> {

	@Override
	public PricesResponse map(Price price) {

		return new PricesResponse(
			price.getProductId(),
			price.getBrandId(),
			price.getPriceList(),
			price.getStartDate(),
			price.getEndDate(),
			price.getPriceValue(),
			price.getCurr()
		);

	}

}