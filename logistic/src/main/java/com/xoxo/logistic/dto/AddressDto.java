package com.xoxo.logistic.dto;

public class AddressDto {
	

	private long id;
	private String countryCode;
	private String city;
	private String streetAddress;
	private long postalCode;
	private long houseNumber;
	private double lat;
	private double lng;
	
	public AddressDto(long id, String countryCode, String city, String streetAddress, long postalCode, long houseNumber,
			double lat, double lng) {
		super();
		this.id = id;
		this.countryCode = countryCode;
		this.city = city;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.houseNumber = houseNumber;
		this.lat = lat;
		this.lng = lng;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public long getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(long postalCode) {
		this.postalCode = postalCode;
	}
	public long getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(long houseNumber) {
		this.houseNumber = houseNumber;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	

}
