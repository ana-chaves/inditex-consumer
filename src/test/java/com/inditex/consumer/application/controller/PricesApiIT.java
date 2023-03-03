package com.inditex.consumer.application.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.consumer.application.controller.response.PricesResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Prices Api IT tests")
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PricesApiIT {

	@Autowired
	protected MockMvc mockMvc;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	@BeforeAll
	void createData() {
		this.givenPrices();
	}

	@Test
	@DisplayName("Fail getting not existing prices")
	void given_wrong_endpoint_then_not_found_returned() throws Exception {
		//WHEN
		MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders
				.get("/pricess")
				.accept(MediaType.APPLICATION_JSON))
			.andReturn().getResponse();

		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
	}


	@Test
	@DisplayName("Get prices test 1")
	void when_getting_request_then_return_price_1() throws Exception {
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders
				.get("/prices")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"date\":\"2020-06-14 21:00\", \"productId\":35455,\"brandId\":1}"))
			.andReturn();

		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

		PricesResponse body = this.objectMapper.readValue(
			result.getResponse().getContentAsString(),
			new TypeReference<>() {
			}
		);

		assertEquals(new Double(35.50), body.getPrice());
	}

	@Test
	@DisplayName("Get prices test 2")
	void when_getting_request_then_return_price_2() throws Exception {
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders
				.get("/prices")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"date\":\"2020-06-14 16:00\", \"productId\":35455,\"brandId\":1}"))
			.andReturn();

		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

		PricesResponse body = this.objectMapper.readValue(
			result.getResponse().getContentAsString(),
			new TypeReference<>() {
			}
		);

		assertEquals(new Double(25.45), body.getPrice());
	}

	@Test
	@DisplayName("Get prices test 3")
	void when_getting_request_then_return_price_3() throws Exception {
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders
				.get("/prices")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"date\":\"2020-06-14 21:00\", \"productId\":35455,\"brandId\":1}"))
			.andReturn();

		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

		PricesResponse body = this.objectMapper.readValue(
			result.getResponse().getContentAsString(),
			new TypeReference<>() {
			}
		);

		assertEquals(new Double(35.50), body.getPrice());
	}

	@Test
	@DisplayName("Get prices test 4")
	void when_getting_request_then_return_price_4() throws Exception {
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders
				.get("/prices")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"date\":\"2020-06-15 10:00\", \"productId\":35455,\"brandId\":1}"))
			.andReturn();

		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

		PricesResponse body = this.objectMapper.readValue(
			result.getResponse().getContentAsString(),
			new TypeReference<>() {
			}
		);

		assertEquals(new Double(30.50), body.getPrice());
	}

	@Test
	@DisplayName("Get prices test 5")
	void when_getting_request_then_return_price_5() throws Exception {
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders
				.get("/prices")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"date\":\"2020-06-16 21:00\", \"productId\":35455,\"brandId\":1}"))
			.andReturn();

		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

		PricesResponse body = this.objectMapper.readValue(
			result.getResponse().getContentAsString(),
			new TypeReference<>() {
			}
		);

		assertEquals(new Double(38.95), body.getPrice());
	}

	private void givenPrices() {

		this.jdbcTemplate.execute(
			"INSERT INTO PRICES (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (1, '2020-06-14T00.00.00', '2020-12-31T23.59.59', 2, 35455, 0, '35.50', 'EUR');");
		this.jdbcTemplate.execute(
			"INSERT INTO PRICES (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (1, '2020-06-14T15.00.00', '2020-06-14T18.30.00', 2, 35455, 1, '25.45', 'EUR');");
		this.jdbcTemplate.execute(
			"INSERT INTO PRICES (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (1, '2020-06-15T00.00.00', '2020-06-15T11.00.00', 3, 35455, 1, '30.50', 'EUR');");
		this.jdbcTemplate.execute(
			"INSERT INTO PRICES (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (1, '2020-06-15T16.00.00', '2020-12-31T23.59.59', 4, 35455, 1, '38.95', 'EUR');");

	}

}
