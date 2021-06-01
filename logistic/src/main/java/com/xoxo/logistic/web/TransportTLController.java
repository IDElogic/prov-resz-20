package com.xoxo.logistic.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.xoxo.logistic.dto.TransportDto;

@Controller
public class TransportTLController {
	
	private List<TransportDto> allTransportes = new ArrayList<>();
	{
		allTransportes.add(new TransportDto(1L, 0, null));
	}
			
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/transports")
	public String listTransport(Map<String, Object> model) {
		model.put("transports", allTransportes);
		model.put("newTransport",new TransportDto(1L, 0, null));
		return "transports";
	}
	
	
	@PostMapping("/transports")
	public String addTransport(TransportDto address) {
		allTransportes.add(address);
		return "redirect:transports";
	}
}
