package br.com.uaijug.indikoj.model.service;

import java.util.Optional;

import br.com.uaijug.indikoj.model.domain.Company;

public interface CompanyService extends CrudService<Company, Long> {
	Optional<Company> findByName(String name);
}