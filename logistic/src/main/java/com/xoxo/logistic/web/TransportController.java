package com.xoxo.logistic.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoxo.logistic.dto.AddressDto;

@RestController
@RequestMapping("/api/addresses")
public class TransportController {
	
	private Map<Long, AddressDto> addresses = new HashMap<>();
	
	{
		addresses.put(1L, new AddressDto(1,"SE","Malmö","Nordenskiöldsgatan", 20506L,1L, 0.0, 0.0));
		addresses.put(2L, new AddressDto(2,"SE","Borås","Sturegatan", 40301L,1L, 0.0, 0.0));
	}
	
	@GetMapping 
	public List<AddressDto> getAll(){
		return new ArrayList<>(addresses.values());
	}
	
	/*egy address-t ad vissza id-alapjan*/
	
	@GetMapping("/{id}")
	public ResponseEntity<AddressDto> getById(@PathVariable long id) {
		AddressDto addressDto = addresses.get(id);
		if(addressDto != null)
			return ResponseEntity.ok(addressDto);
		else
			return ResponseEntity.notFound().build();	
	}	
	
	@PostMapping
	public AddressDto createAddress(@RequestBody AddressDto addressDto) {
		addresses.put(addressDto.getId(),addressDto);
		return addressDto;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AddressDto> modifyAddress(@PathVariable long id, @RequestBody AddressDto addressDto) {
		if(!addresses.containsKey(id)) {
			return ResponseEntity.notFound().build();
		}
		addressDto.setId(id);
		addresses.put(id, addressDto);
		return ResponseEntity.ok(addressDto);				
	}
	
	@DeleteMapping("/{id}")
	public void deleteAddress(@PathVariable long id) {
		addresses.remove(id);
	}	
}











