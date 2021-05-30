package com.xoxo.logistic.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.xoxo.logistic.dto.AddressDto;
import com.xoxo.logistic.dto.TransportDto;


@Controller
public class TransportTLController {
	
	private List<AddressDto> allAddresses = new ArrayList<>();
	{
		allAddresses.add(new AddressDto(1L,"SE","Malmö","Nordenskiöldsgatan", 20506L,1L, 0.0, 0.0));
	}
	
	private List<TransportDto> allTransports = new ArrayList<>();
	{
		allTransports.add(new TransportDto(1L,"frånMalmötillBorås", 220000.0));
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/addresses")
	public String listAddress(Map<String, Object> model) {
		model.put("addresses", allAddresses);
		model.put("newAddress",new AddressDto());
		return "addresses";
	}
	
	@GetMapping("/transports")
	public String listTransport(Map<String, Object> model) {
		model.put("transports", allTransports);
		model.put("newTransport",new TransportDto());
		return "transports";
	}
	
	
	@PostMapping("/addresses")
	public String addAddress(AddressDto address) {
		allAddresses.add(address);
		return "redirect:addresses";
	}
}
