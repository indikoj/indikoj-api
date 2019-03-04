package br.com.uaijug.indikoj.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.uaijug.indikoj.model.domain.JobOpportunity;

public interface JobOpportunityRepository extends JpaRepository<JobOpportunity, Long> {
	Optional<JobOpportunity> findByName(String name);
}
