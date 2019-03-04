package br.com.uaijug.indikoj.model.service;

import java.util.Optional;

import br.com.uaijug.indikoj.model.domain.JobOpportunity;

public interface JobOpportunityService extends CrudService<JobOpportunity, Long>{

	Optional<JobOpportunity> findByName(String name);

}
