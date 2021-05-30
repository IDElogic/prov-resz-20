package com.xoxo.logistic.dto;

public class TransportDto {
	
	public TransportDto(long id, String section, double price) {
		super();
		this.id = id;
		this.section = section;
		this.price = price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public TransportDto() {
		
	}

	private long id;
	private String section;
	private double price;

}
