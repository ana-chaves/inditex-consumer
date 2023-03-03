package com.inditex.consumer.domain.use_case;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class PricesFilter {
	private LocalDateTime date;
	private Long productId;
	private Long brandId;

}
