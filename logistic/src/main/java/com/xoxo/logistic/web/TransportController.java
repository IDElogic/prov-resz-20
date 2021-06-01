package com.xoxo.logistic.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.xoxo.logistic.dto.SectionDto;
import com.xoxo.logistic.dto.TransportDto;

@RestController
@RequestMapping("/api/transports")
public class TransportController {
	
	private Map<Long, TransportDto> transports = new HashMap<>();
	
	{
		transports.put(1L, new TransportDto(1,100.0, null));
		transports.put(2L, new TransportDto(2,200.0, null));
	}
	
	@GetMapping 
	public List<TransportDto> getAll(){
		return new ArrayList<>(transports.values());
	}
	
//	@GetMapping("/{id}")
//	public TransportDto getById(@PathVariable long id) {
//		return FindByIdOrThrow(id);
//	}
	
	@GetMapping("/{id}")
	public TransportDto getById(@PathVariable long id) {
	        TransportDto transportDto = transports.get(id);
	        if(transportDto != null)
	        	return transportDto;
	        else
	        	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	        	}
		
	@PostMapping
	public TransportDto createTransport(@RequestBody TransportDto transportDto) {
		transports.put(transportDto.getId(),transportDto);
		return transportDto;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TransportDto> modifyTransport(@PathVariable long id, @RequestBody TransportDto transportDto) {
		if(!transports.containsKey(id)) {
			return ResponseEntity.notFound().build();
		}
		transportDto.setId(id);
		transports.put(id, transportDto);
		return ResponseEntity.ok(transportDto);				
	}
	
	@DeleteMapping("/{id}")
	public void deleteTransport(@PathVariable long id) {
		transports.remove(id);
	}
	
	@PostMapping("/{id}/sections")
	public TransportDto addNewSection(@PathVariable long id, @RequestBody SectionDto sectionDto) {
		TransportDto transportDto =  findByIdOrThrow(id);
		transportDto.getSections().add(sectionDto);
			return transportDto;		
	}
	
	private TransportDto findByIdOrThrow(long id) {		
			return null;
	}
	
	@DeleteMapping("/{id}/sections/{sectionId}")
	public TransportDto addNewSection(@PathVariable long id,@PathVariable long sectionId) {
		TransportDto transportDto =  findByIdOrThrow(id);
		for(Iterator<SectionDto> iterator = transportDto.getSections().iterator();
				iterator.hasNext();){
			SectionDto section = iterator.next();
			if(section.getId()== sectionId) {
				iterator.remove();
				break;
				}			
		}
		return transportDto;
	}
	
	@PutMapping("/{id}/sections")
	public TransportDto replaceSections(@PathVariable long id, @RequestBody List<SectionDto> sections) {
		TransportDto transportDto =  findByIdOrThrow(id);
		transportDto.setSections(sections);
			return transportDto;		
	}
		
	public TransportDto FindByIdOrThrow(long id) {
		TransportDto transportDto = transports.get(id);
		if(transportDto == null)			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return transportDto;
	}
}




















