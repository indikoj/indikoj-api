package br.com.uaijug.indikoj.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.uaijug.indikoj.model.domain.PersonType;
import br.com.uaijug.indikoj.model.service.PersonTypeService;

@Service
public class PersonTypeServiceImpl implements PersonTypeService {

	@Override
	public Optional<List<PersonType>> all() {
		List<PersonType> types = PersonType.getPersonTypes();
		return Optional.of(types);
	}

}
