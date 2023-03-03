package com.inditex.consumer.domain.use_case;

import com.inditex.consumer.builder.FakeClock;
import com.inditex.consumer.domain.repository.PricesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RetrievePricesUseCaseTest {

	@InjectMocks
	private RetrievePricesUseCase useCase;
	@Mock
	private PricesRepository repository;

	@Test
	void when_execute_then_prices_are_retrieved() {
		this.useCase.execute(new PricesFilter(FakeClock.now(), 2L, 1L));

		verify(this.repository).findAllByStartDateEndDateProductIdBrandId(new PricesFilter(FakeClock.now(), 2L, 1L));
	}

}