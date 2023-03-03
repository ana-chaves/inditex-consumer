package com.inditex.consumer.application.controller.response;

import com.inditex.consumer.builder.FakeClock;
import com.inditex.consumer.domain.model.Price;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PricesResponseMapperTest {

	@InjectMocks
	private PricesResponseMapper mapper;

	@Test
	void when_mapper_is_used_then_response_is_mapped() {
		PricesResponse pricesResponse = this.mapper.map(new Price().setProductId(1L)
			.setBrandId(3L)
			.setPriceList(4L)
			.setStartDate(FakeClock.now())
			.setEndDate(FakeClock.future())
			.setPriceValue(3.5)
			.setCurr("::currency::"));

		assertEquals(new Long(1), pricesResponse.getProductId());
		assertEquals(new Long(3), pricesResponse.getBrandId());
		assertEquals(new Long(4), pricesResponse.getPriceList());
		assertEquals(new Double(3.5), pricesResponse.getPrice());
		assertEquals("::currency::", pricesResponse.getCurr());
	}

}