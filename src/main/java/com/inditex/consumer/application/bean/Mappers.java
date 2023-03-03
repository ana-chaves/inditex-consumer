package com.inditex.consumer.application.bean;

import com.inditex.consumer.application.controller.request.PricesFilterCreator;
import com.inditex.consumer.application.controller.response.PricesResponse;
import com.inditex.consumer.application.controller.response.PricesResponseMapper;
import com.inditex.consumer.contract.Mapper;
import com.inditex.consumer.domain.model.Price;
import com.inditex.consumer.infrastructure.repository.h2.PriceMapper;
import com.inditex.consumer.infrastructure.repository.h2.entity.PriceEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class Mappers {
	@Bean
	public Mapper<PriceEntity, Price> priceMapper() {
		return new PriceMapper();
	}
	@Bean
	public Mapper<Price, PricesResponse> pricesResponseMapper() {
		return new PricesResponseMapper();
	}
	@Bean
	public PricesFilterCreator pricesFilterCreator() {
		return new PricesFilterCreator();
	}

}
