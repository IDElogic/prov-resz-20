package com.xoxo.logistic.service;

public class NonUniqueStreetAddressException  extends RuntimeException {
	
	public NonUniqueStreetAddressException(String streetAddress ) {
		super("Exsisting streetAddress:" + streetAddress);
	}

}
