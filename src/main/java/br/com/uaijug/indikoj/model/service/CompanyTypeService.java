package br.com.uaijug.indikoj.model.service;

import java.util.Optional;

import br.com.uaijug.indikoj.model.domain.CompanyType;

public interface CompanyTypeService extends CrudService<CompanyType, Long> {
	Optional<CompanyType> findByName(String name);
}