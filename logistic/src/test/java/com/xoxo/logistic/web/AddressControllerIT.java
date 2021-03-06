package com.xoxo.logistic.web;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.xoxo.logistic.dto.AddressDto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AddressControllerIT {
	
	@Autowired
	WebTestClient webTestClient;
	
	private static final String BASE_URI ="/api/addresses";
	
	@Test
	void testThatCreatedAddressesListed()throws Exception {
		List<AddressDto> addressesBefore = getAllAddresses();
		AddressDto newAddress = new AddressDto(5L,"SE","Norrköping","Brahegatan", 11230L, 10L, 0.0, 0.0);
		createAddress(newAddress);
		
		List<AddressDto> addressesAfter = getAllAddresses();
		
		assertThat(addressesAfter.subList(0, addressesBefore.size()))
			.usingFieldByFieldElementComparator()
			.containsExactlyElementsOf(addressesBefore);
		
		assertThat(addressesAfter.get(addressesAfter.size()-1))
			.usingRecursiveComparison()
			.isEqualTo(newAddress);
	}
	/*addresses create-must to send a POST ->need an injected webTestClient*/
	private void createAddress(AddressDto newAddress) {
		webTestClient
			.post()
			.uri(BASE_URI)
			.bodyValue(newAddress)
			.exchange()
			.expectStatus().isOk();
		
		
	}
	/*getBackAll*/
	private List<AddressDto> getAllAddresses() {
		List<AddressDto> responseList = webTestClient
		.get()
		.uri(BASE_URI)
		.exchange()
		.expectStatus().isOk()
		.expectBodyList(AddressDto.class)
		 .returnResult().getResponseBody();
		
		Collections.sort(responseList,
				(a1, a2) -> Long.compare(a1.getId(),a2.getId()));
		return responseList;
		
		
	
	}
	

}
