package com.xoxo.logistic.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.xoxo.logistic.dto.AddressDto;


@RestController
@RequestMapping("/api/addresses")
public class AddressController {
	
	private Map<Long, AddressDto> addresses = new HashMap<>();
	
	{
		addresses.put(1L, new AddressDto(1,"SE","Malmö","Nordenskiöldsgatan", 20506L,1L, 0.0, 0.0));
		addresses.put(2L, new AddressDto(2,"SE","Borås","Sturegatan", 40301L,1L, 0.0, 0.0));
	}

//	@GetMapping 
//	public List<AddressDto> getAddresses(@RequestParam(required = false)Boolean full){
//		if(full != null && full) {
//			return new ArrayList<>(addresses.values());	
//		} else {
//			return addresses.values().stream()
//					.map(a -> new AddressDto(
//					a.getId(),
//					a.getCountryCode(),
//					a.getCity(),
//					a.getStreetAddress(),
//					a.getPostalCode(),null))
//					.collect(Collectors.toList());O
//		}		
//	}
	
//	@GetMapping
//	public List<AddressDto> getAddresses(@RequestParam(required = false) Boolean full) {
//		return full == null || full == false ? 
//				addressMapper.adressSummariesToDtos(addressService.findAll()) 
//				: addressMapper.addressesToDtos(addressRepository.findAllWithCountryCodes());
//	}
	
	@GetMapping("/{id}")
	public AddressDto getById(@PathVariable long id) {
		return FindByIdOrThrow(id);
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
		
	public AddressDto FindByIdOrThrow(long id) {
		AddressDto addressDto = addresses.get(id);
		if(addressDto == null)			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return addressDto;
	}
}

//@RestController
//@RequestMapping("/api/addresses")
//public class AddressController {
//	
//	private Map<Long, AddressDto> addresses = new HashMap<>();
//	
//	{
//		addresses.put(1L, new AddressDto(1,"SE","Malmö","Nordenskiöldsgatan", 20506L,1L, 0.0, 0.0));
//		addresses.put(2L, new AddressDto(2,"SE","Borås","Sturegatan", 40301L,1L, 0.0, 0.0));
//	}
//
//	@GetMapping 
//	public List<AddressDto> getAll(){
//		return new ArrayList<>(addresses.values());
//	}
//	
//	@GetMapping("/{id}")
//	public AddressDto getById(@PathVariable long id) {
//		return FindByIdOrThrow(id);
//	}	
//		
//	@PostMapping
//	public AddressDto createAddress(@RequestBody AddressDto addressDto) {
//		addresses.put(addressDto.getId(),addressDto);
//		return addressDto;
//	}
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<AddressDto> modifyAddress(@PathVariable long id, @RequestBody AddressDto addressDto) {
//		if(!addresses.containsKey(id)) {
//			return ResponseEntity.notFound().build();
//		}
//		addressDto.setId(id);
//		addresses.put(id, addressDto);
//		return ResponseEntity.ok(addressDto);				
//	}
//	
//	@DeleteMapping("/{id}")
//	public void deleteAddress(@PathVariable long id) {
//		addresses.remove(id);
//	}
//		
//	public AddressDto FindByIdOrThrow(long id) {
//		AddressDto addressDto = addresses.get(id);
//		if(addressDto == null)			
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//		return addressDto;
//	}
//}














