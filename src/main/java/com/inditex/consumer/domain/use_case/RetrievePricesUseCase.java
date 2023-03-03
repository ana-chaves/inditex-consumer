package com.inditex.consumer.domain.use_case;

import com.inditex.consumer.domain.model.Price;
import com.inditex.consumer.domain.repository.PricesRepository;
import lombok.AllArgsConstructor;
import org.aspectj.apache.bcel.classfile.Module;

import java.util.Optional;

@AllArgsConstructor
public class RetrievePricesUseCase {
	private final PricesRepository pricesRepository;

	public Optional<Price> execute(PricesFilter filter) {
		return pricesRepository.findAllByStartDateEndDateProductIdBrandId(filter);
	}
}
