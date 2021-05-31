package com.xoxo.logistic.dto;

import com.fasterxml.jackson.annotation.JsonView;

public class AddressDto {
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@JsonView(Views.BaseData.class)
	private long id;
	@JsonView(Views.BaseData.class)
	private String countryCode;
	@JsonView(Views.BaseData.class)
	private String city;
	@JsonView(Views.BaseData.class)
	private String streetAddress;
	@JsonView(Views.BaseData.class)
	private long postalCode;
	@JsonView(Views.BaseData.class)
	private long houseNumber;
	@JsonView(Views.BaseData.class)
	private double lat;
	@JsonView(Views.BaseData.class)
	private double lng;
	
	public AddressDto(long id, String countryCode, String city, String streetAddress, long postalCode, long houseNumber,
			double lat, double lng) {
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
