package com.inditex.consumer.application.configuration.handler.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorResponse {

	private final String code;
	private final String message;

}
