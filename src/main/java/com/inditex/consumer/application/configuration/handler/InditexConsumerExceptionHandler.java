package com.inditex.consumer.application.configuration.handler;

import com.inditex.consumer.application.configuration.handler.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class InditexConsumerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception ex) {
		ErrorResponse errorResponse =
			new ErrorResponse(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), ex.getMessage());
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
