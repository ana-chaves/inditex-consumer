package com.inditex.consumer.application.controller.request;

import com.inditex.consumer.domain.use_case.PricesFilter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PricesFilterCreatorTest {

	@InjectMocks
	private PricesFilterCreator creator;

	@Test
	void when_creator_is_used_then_response_is_mapped() {
		PricesFilter pricesFilter = this.creator.create(new PricesRequest("2020-02-12 10:00", 1L, 1L));

		assertEquals(new Long(1), pricesFilter.getProductId());
		assertEquals(new Long(1), pricesFilter.getBrandId());
		assertEquals(
			LocalDateTime.parse("2020-02-12 10:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
			pricesFilter.getDate()
		);
	}

}