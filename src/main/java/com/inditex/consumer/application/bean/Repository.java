package com.inditex.consumer.application.bean;

import com.inditex.consumer.contract.Mapper;
import com.inditex.consumer.domain.model.Price;
import com.inditex.consumer.domain.repository.PricesRepository;
import com.inditex.consumer.infrastructure.repository.h2.IPriceDao;
import com.inditex.consumer.infrastructure.repository.h2.PriceH2Repository;
import com.inditex.consumer.infrastructure.repository.h2.entity.PriceEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class Repository {
	@Bean
	public PricesRepository pricesRepository(IPriceDao priceDao, Mapper<PriceEntity, Price> priceMapper) {
		return new PriceH2Repository(priceDao, priceMapper);
	}
}
