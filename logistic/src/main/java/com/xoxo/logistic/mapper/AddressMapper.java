package com.xoxo.logistic.mapper;

import java.util.List;

import javax.validation.Valid;

import org.mapstruct.Mapper;

import com.xoxo.logistic.dto.AddressDto;
import com.xoxo.logistic.model.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {
	
	List<AddressDto>addressesToDtos(List<Address>addresses);

	AddressDto addressToDto(Address address);

	Address dtoToAddress(@Valid AddressDto addressDto);
}
