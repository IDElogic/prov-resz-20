package com.xoxo.logistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.xoxo.logistic.service.PriceService;

@SpringBootApplication
public class LogisticApplication implements CommandLineRunner {

	@Autowired
	PriceService priceService;
	
	public static void main(String[] args) {
		SpringApplication.run(LogisticApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(priceService.getFinalPrice(20000));
		System.out.println(priceService.getFinalPrice(25000));
		System.out.println(priceService.getFinalPrice(30000));
		
	}
}
