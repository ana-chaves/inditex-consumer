package com.inditex.consumer.application.bean;

import com.inditex.consumer.domain.repository.PricesRepository;
import com.inditex.consumer.domain.use_case.RetrievePricesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCase {
	@Bean
	public RetrievePricesUseCase retrievePricesUseCase(final PricesRepository pricesRepository) {
		return new RetrievePricesUseCase(pricesRepository);
	}

}