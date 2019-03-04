package br.com.uaijug.indikoj.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.uaijug.indikoj.model.domain.CompanyType;

public interface CompanyTypeRepository extends JpaRepository<CompanyType, Long> {
	Optional<CompanyType> findByName(String name);
}

