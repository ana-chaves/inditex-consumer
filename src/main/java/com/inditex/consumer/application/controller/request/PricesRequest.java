package com.inditex.consumer.application.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class PricesRequest {
	@JsonProperty("date")
	@NotBlank(message = "Date is mandatory")
	private String date;
	@JsonProperty("productId")
	private Long productId;
	@JsonProperty("brandId")
	private Long brandId;

}
