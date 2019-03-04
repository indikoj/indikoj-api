package br.com.uaijug.indikoj.model.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.uaijug.indikoj.model.domain.Candidate;

public interface CandidateRepository extends PagingAndSortingRepository<Candidate, Long> {
	Optional<Candidate> findByName(String name);
}
