package com.xoxo.logistic.model;

import java.util.ArrayList;
import java.util.List;

import com.xoxo.logistic.dto.MilestoneDto;

public class Section {
	
	public Section(long id, long sectionNumber, String fromMilestone, String toMilestone,
			List<MilestoneDto> milestones) {
		super();
		this.id = id;
		this.sectionNumber = sectionNumber;
		this.fromMilestone = fromMilestone;
		this.toMilestone = toMilestone;
		this.milestones = milestones;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSectionNumber() {
		return sectionNumber;
	}

	public void setSectionNumber(long sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public String getFromMilestone() {
		return fromMilestone;
	}

	public void setFromMilestone(String fromMilestone) {
		this.fromMilestone = fromMilestone;
	}

	public String getToMilestone() {
		return toMilestone;
	}

	public void setToMilestone(String toMilestone) {
		this.toMilestone = toMilestone;
	}

	public List<MilestoneDto> getMilestones() {
		return milestones;
	}

	public void setMilestones(List<MilestoneDto> milestones) {
		this.milestones = milestones;
	}

	private long id;
	private long sectionNumber;
	private String fromMilestone;
	private String toMilestone;
	List<MilestoneDto> milestones = new ArrayList<>();

	public Section() {
			
		}
}
