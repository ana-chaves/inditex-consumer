package com.inditex.consumer.infrastructure.repository.h2.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "prices")
public class PriceEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "brand_id")
	private Long brandId;
	@Column(name = "start_date")
	private LocalDateTime startDate;
	@Column(name = "end_date")
	private LocalDateTime endDate;
	@Column(name = "price_list")
	private Long priceList;
	@Column(name = "product_id")
	private Long productId;
	@Column(name = "priority")
	private Long priority;
	@Column(name = "price")
	private Double price;
	@Column(name = "curr")
	private String currency;

}
