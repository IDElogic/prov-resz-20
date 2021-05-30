package com.xoxo.logistic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.xoxo.logistic.service.DiscountService;
import com.xoxo.logistic.service.SpecialDiscountService;

@Configuration
@Profile("prod")
public class ProdDiscountConfiguration {
	
	@Bean
	public DiscountService discountService() {
		return new SpecialDiscountService();
	}
}
