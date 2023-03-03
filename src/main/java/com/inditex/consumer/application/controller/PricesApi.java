package com.inditex.consumer.application.controller;

import com.inditex.consumer.application.controller.request.PricesRequest;
import com.inditex.consumer.application.controller.response.PricesResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


public interface PricesApi {

	@Operation(
		description = "Get prices info", operationId = "getPrices"
	)
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Prices"),
		@ApiResponse(responseCode = "404", description = "Price not found")
	})
	ResponseEntity<PricesResponse> getPrices(@Valid @RequestBody PricesRequest request);
}
