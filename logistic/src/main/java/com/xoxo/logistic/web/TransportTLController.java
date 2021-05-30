package com.xoxo.logistic.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.xoxo.logistic.dto.AddressDto;


@Controller
public class TransportTLController {
	
	private List<AddressDto> allAddresses = new ArrayList<>();
	{
		allAddresses.add(new AddressDto(1L,"SE","Malmö","Nordenskiöldsgatan", 20506L,1L, 0.0, 0.0));
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
	
	
	@PostMapping("/addresses")
	public String addAddress(AddressDto address) {
		allAddresses.add(address);
		return "redirect:addresses";
	}
}
