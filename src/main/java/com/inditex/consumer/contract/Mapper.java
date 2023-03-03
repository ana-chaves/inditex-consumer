package com.inditex.consumer.contract;

public interface Mapper<From, To> {
	To map(From from);
}
