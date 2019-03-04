package br.com.uaijug.indikoj.model.service;

import java.util.Optional;

import br.com.uaijug.indikoj.model.domain.Candidate;

public interface CandidateService extends CrudService<Candidate, Long> {

	boolean sendInformation(Candidate candidate);

	Optional<Candidate> findByName(String name);
}
