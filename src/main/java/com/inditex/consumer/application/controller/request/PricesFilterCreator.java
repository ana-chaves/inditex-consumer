package com.inditex.consumer.application.controller.request;

import com.inditex.consumer.domain.use_case.PricesFilter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PricesFilterCreator {

	public PricesFilter create(PricesRequest request) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(request.getDate(), formatter);

		return new PricesFilter(dateTime, request.getProductId(), request.getBrandId());
	}
}
