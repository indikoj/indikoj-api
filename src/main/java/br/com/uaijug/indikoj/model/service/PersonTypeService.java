package br.com.uaijug.indikoj.model.service;

import java.util.List;
import java.util.Optional;

import br.com.uaijug.indikoj.model.domain.PersonType;

public interface PersonTypeService {
	Optional<List<PersonType>> all();
}
