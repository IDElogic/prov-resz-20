package com.xoxo.logistic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoxo.logistic.config.TransportConfigProperties;

@Service
public class DefaultDiscountService implements DiscountService {

	@Autowired
	TransportConfigProperties config;
	
	@Override
	public int getDiscountPercent(int totalPrice) {
		
		return config.getDiscount().getDef().getPercent();
	}

}
