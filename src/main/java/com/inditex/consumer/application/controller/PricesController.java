package com.inditex.consumer.application.controller;

import com.inditex.consumer.application.controller.request.PricesFilterCreator;
import com.inditex.consumer.application.controller.request.PricesRequest;
import com.inditex.consumer.application.controller.response.PricesResponse;
import com.inditex.consumer.contract.Mapper;
import com.inditex.consumer.domain.model.Price;
import com.inditex.consumer.domain.use_case.RetrievePricesUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/prices")
public class PricesController implements PricesApi {
	private final RetrievePricesUseCase retrievePricesUseCase;
	private final PricesFilterCreator pricesFilterCreator;
	private final Mapper<Price, PricesResponse> priceMapper;

	@Override
	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PricesResponse> getPrices(@Valid @RequestBody PricesRequest request) {

		Optional<Price> price = this.retrievePricesUseCase.execute(this.pricesFilterCreator.create(request));

		return price.map(value -> ResponseEntity.ok(this.priceMapper.map(value)))
			.orElseGet(() -> ResponseEntity.noContent()
				.build());
	}

}
