package br.com.uaijug.indikoj.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.uaijug.indikoj.model.domain.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	Optional<Company> findByName(String name);
}
