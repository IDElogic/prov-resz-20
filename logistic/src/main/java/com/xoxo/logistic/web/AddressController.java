package com.xoxo.logistic.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.xoxo.logistic.dto.AddressDto;
import com.xoxo.logistic.mapper.AddressMapper;
import com.xoxo.logistic.model.Address;
import com.xoxo.logistic.service.AddressService;


@RestController
@RequestMapping("/api/addresses")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	AddressMapper addressMapper;
	
	
	@GetMapping 
	public List<AddressDto> getAll(){
		return addressMapper.addressesToDtos(addressService.findAll());	 
	}
	
	@GetMapping("/{id}")
	public AddressDto getById(@PathVariable long id) {
	    Address address = addressService.findById(id);
	        
	        if(address != null)
	        	return addressMapper.addressToDto(address);
	        else
	        	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	        	}
	@PostMapping
	public AddressDto createAddress(@RequestBody @Valid  AddressDto addressDto) {
		Address address = addressService.save(addressMapper.dtoToAddress(addressDto));
		return addressMapper.addressToDto(address);
	}
	
	
/*  ez fut itt lent */	
//		@GetMapping 
//		public List<AddressDto> getAll(){
//			return new ArrayList<>(addresses.values());
//		}
//	
//	@GetMapping (params ="full=true")
//	public List<AddressDto> getAddresses(){
//		return new ArrayList<>(addresses.values());
//	}
//
//				//	@GetMapping 
//				//	@JsonView(Views.BaseData.class)
//				//	public List<AddressDto> getAddressesWithBaseData(@RequestParam(required=false)Boolean full){
//				//		return getAddresses();
//				//	}	
//					
//
//						
//				//	@GetMapping("/{id}")
//				//	public AddressDto getById(@PathVariable long id) {
//				//		return FindByIdOrThrow(id);
//				//	}
//	
//	@GetMapping("/{id}")
//	public AddressDto getById(@PathVariable long id) {
//	        AddressDto addressDto = addresses.get(id);
//	        if(addressDto != null)
//	        	return addressDto;
//	        else
//	        	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//	        	}
//		
//	@PostMapping
//	public AddressDto createAddress(@RequestBody AddressDto addressDto) {
//		checkUniqueStreetAddress(addressDto.getStreetAddress());
//		addresses.put(addressDto.getId(),addressDto);
//		return addressDto;
//	}
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<AddressDto> modifyAddress(@PathVariable long id, @RequestBody AddressDto addressDto) {
//		if(!addresses.containsKey(id)) {
//			return ResponseEntity.notFound().build();
//		}
//		checkUniqueStreetAddress(addressDto.getStreetAddress());
//		addressDto.setId(id);
//		addresses.put(id, addressDto);
//		return ResponseEntity.ok(addressDto);				
//	}
//	
//	private void checkUniqueStreetAddress(String streetAddress) {
//		Optional<AddressDto> addressWithSameStreetAddress = addresses.values()
//				.stream().filter(a -> a
//					.getStreetAddress()
//						.equals(streetAddress))
//							.findAny();
//		if(addressWithSameStreetAddress.isPresent())
//			throw new NonUniqueStreetAddressException(streetAddress);
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
//	
////	@PostMapping("/search")
////	public int getCountryCode(@RequestBody AddressDto address) {
////		return addressService.getCountryCode(address);
////	}
}
















