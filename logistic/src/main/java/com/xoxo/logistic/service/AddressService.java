package com.xoxo.logistic.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.xoxo.logistic.model.Address;

@Service
public class AddressService {

private Map<Long, Address> addresses = new HashMap<>();
	
	{
		addresses.put(1L, new Address(1,"SE","Malmö","Nordenskiöldsgatan", 20506L,1L, 0.0, 0.0));
		addresses.put(2L, new Address(2,"SE","Borås","Sturegatan", 40301L,1L, 0.0, 0.0));
	}	

	
	public Address save(Address address) {
		checkUniqueStreetAddress(address.getStreetAddress());
		addresses.put(address.getId(),address);
		return address;
	}
	
	private void checkUniqueStreetAddress(String streetAddress) {
		Optional<Address> addressWithSameStreetAddress = addresses.values()
			.stream().filter(a -> a
				.getStreetAddress()
					.equals(streetAddress))
						.findAny();
	if(addressWithSameStreetAddress.isPresent())
		throw new NonUniqueStreetAddressException(streetAddress);
}
	
	public List<Address> findAll(){
		return new ArrayList<>(addresses.values());
	}
	
//	public List<Address> findbyId(long id){
//		return addresses.get(id);
//	}
	
	public void delete(long id){
		 addresses.remove(id);
	}

	public Address findById(long id) {	
		return null;
	}

}
