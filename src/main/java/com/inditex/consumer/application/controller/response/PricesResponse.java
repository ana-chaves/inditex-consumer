package com.inditex.consumer.application.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class PricesResponse {
	@JsonProperty("product_id")
	private Long productId;
	@JsonProperty("brand_id")
	private Long brandId;
	@JsonProperty("price_list")
	private Long priceList;
	@JsonProperty("start_date")
	private LocalDateTime startDate;
	@JsonProperty("end_date")
	private LocalDateTime endDate;
	@JsonProperty("price")
	private Double price;
	@JsonProperty("currency")
	private String curr;
}
