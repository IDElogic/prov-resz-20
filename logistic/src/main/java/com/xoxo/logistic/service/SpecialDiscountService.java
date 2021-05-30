package com.xoxo.logistic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoxo.logistic.config.TransportConfigProperties;

@Service
public class SpecialDiscountService implements DiscountService{

//	@Value("${logistic.discount.special.limit}")
//	private int limit;
//	
//	@Value("${logistic.discount.default.percent}")
//	private int defPercent;
//	
//	@Value("${logistic.discount.special.percent}")
//	private int specialPercent;
	
	@Autowired
	TransportConfigProperties config;
	
	@Override
	public int getDiscountPercent(int totalPrice) {
//		return totalPrice > limit ? specialPercent : defaultPercent;
		
		return totalPrice > config.getDiscount().getSpecial().getLimit()
				? config.getDiscount().getSpecial().getPercent()
						:config.getDiscount().getDef().getPercent();
	}

	
}
