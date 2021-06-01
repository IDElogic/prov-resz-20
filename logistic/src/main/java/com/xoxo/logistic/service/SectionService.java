package com.xoxo.logistic.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xoxo.logistic.model.Section;

@Service
public class SectionService {

private Map<Long, Section> sections = new HashMap<>();
	
	{
		sections.put(1L, new Section());
		sections.put(2L, new Section());
	}	

	
	public Section save(Section address) {
//		checkUniqueStreetSection(address.getStreetSection());
		sections.put(address.getId(),address);
		return address;
	}
	
//	private void checkUniqueStreetSection(String streetSection) {
//		Optional<Section> addressWithSameStreetSection = sections.values()
//			.stream().filter(a -> a
//				.getStreetSection()
//					.equals(streetSection))
//						.findAny();
//	if(addressWithSameStreetSection.isPresent())
//		throw new NonUniqueStreetSectionException(streetSection);
//}
	
	public List<Section> findAll(){
		return new ArrayList<>(sections.values());
	}
	
//	public List<Section> findbyId(long id){
//		return sections.get(id);
//	}
	
	public void delete(long id){
		 sections.remove(id);
	}

	public Section findById(long id) {	
		return null;
	}

}
