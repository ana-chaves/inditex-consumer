package com.inditex.consumer.domain.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class Price {

	private Long productId;
	private Long brandId;
	private Long priceList;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Long priority;
	private Double priceValue;
	private String curr;
}
