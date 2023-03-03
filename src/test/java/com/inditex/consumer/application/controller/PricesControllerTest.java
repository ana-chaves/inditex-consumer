package com.inditex.consumer.application.controller;

import com.inditex.consumer.application.controller.request.PricesFilterCreator;
import com.inditex.consumer.application.controller.request.PricesRequest;
import com.inditex.consumer.application.controller.response.PricesResponse;
import com.inditex.consumer.builder.FakeClock;
import com.inditex.consumer.contract.Mapper;
import com.inditex.consumer.domain.model.Price;
import com.inditex.consumer.domain.use_case.PricesFilter;
import com.inditex.consumer.domain.use_case.RetrievePricesUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PricesControllerTest {

	@InjectMocks
	private PricesController controller;
	@Mock
	private RetrievePricesUseCase retrievePricesUseCase;
	@Mock
	private PricesFilterCreator pricesFilterCreator;
	@Mock
	private Mapper<Price, PricesResponse> priceMapper;

	@Test
	void when_get_price_is_invoked_then_filter_creator_is_used() {
		this.controller.getPrices(new PricesRequest(FakeClock.now().toString(), 3L, 1L));

		verify(this.pricesFilterCreator).create(new PricesRequest(FakeClock.now().toString(), 3L, 1L));
	}

	@Test
	void when_filter_created_then_use_case_is_used() {
		when(this.pricesFilterCreator.create(any())).thenReturn(new PricesFilter(FakeClock.now(), 3L, 1L));

		this.controller.getPrices(new PricesRequest(FakeClock.now().toString(), 3L, 1L));

		verify(this.retrievePricesUseCase).execute(new PricesFilter(FakeClock.now(), 3L, 1L));
	}

	@Test
	void when_get_price_is_invoked_then_retrieve_response() {
		when(this.pricesFilterCreator.create(any())).thenReturn(new PricesFilter(FakeClock.now(), 35455L, 1L));
		when(this.retrievePricesUseCase.execute(any())).thenReturn(Optional.of(new Price().setBrandId(1L)
			.setProductId(1L)
			.setStartDate(FakeClock.pastDateTime())
			.setEndDate(FakeClock.future())
			.setCurr("::currency::")));
		when(this.priceMapper.map(any())).thenReturn(new PricesResponse(
			35455L,
			1L,
			1L,
			FakeClock.pastDateTime(),
			FakeClock.future(),
			35.50,
			"::currency::"
		));

		ResponseEntity<PricesResponse> response = this.controller.getPrices(new PricesRequest(FakeClock.now()
			.toString(), 35455L, 1L));

		assertEquals(
			new PricesResponse(35455L, 1L, 1L, FakeClock.pastDateTime(), FakeClock.future(), 35.50, "::currency::"),
			response.getBody()
		);
	}

}