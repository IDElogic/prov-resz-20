package com.xoxo.logistic.model;

import java.util.ArrayList;
import java.util.List;

import com.xoxo.logistic.dto.SectionDto;

public class Transport {
	
	public Transport(long id, double price, List<SectionDto> sections) {
		super();
		this.id = id;
		this.price = price;
		this.sections = sections;
	}
	private long id;
	private double price;
	List<SectionDto> sections = new ArrayList<>();
	
	public Transport() {
		
	}
	
	public List<SectionDto> getSections() {
		return sections;
	}
	public void setSections(List<SectionDto> sections) {
		this.sections = sections;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

	

}
