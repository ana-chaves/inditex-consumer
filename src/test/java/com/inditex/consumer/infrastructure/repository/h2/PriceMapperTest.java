package com.inditex.consumer.infrastructure.repository.h2;

import com.inditex.consumer.builder.FakeClock;
import com.inditex.consumer.domain.model.Price;
import com.inditex.consumer.infrastructure.repository.h2.entity.PriceEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PriceMapperTest {

	@InjectMocks
	private PriceMapper mapper;

	@Test
	void when_mapper_is_used_then_entity_is_mapped() {
		Price price = this.mapper.map(new PriceEntity().setProductId(1L)
			.setBrandId(3L)
			.setPriceList(4L)
			.setStartDate(FakeClock.now())
			.setEndDate(FakeClock.future())
			.setPrice(3.5)
			.setCurrency("::currency::"));

		assertEquals(new Long(1), price.getProductId());
		assertEquals(new Long(3), price.getBrandId());
		assertEquals(new Long(4), price.getPriceList());
		assertEquals(new Double(3.5), price.getPriceValue());
		assertEquals("::currency::", price.getCurr());
	}

}