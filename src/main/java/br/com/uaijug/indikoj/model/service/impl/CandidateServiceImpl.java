package br.com.uaijug.indikoj.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.uaijug.indikoj.exception.ResourceNotFoundException;
import br.com.uaijug.indikoj.model.domain.Candidate;
import br.com.uaijug.indikoj.model.repository.CandidateRepository;
import br.com.uaijug.indikoj.model.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CandidateRepository candidateRepository;

	@Override
	public boolean sendInformation(Candidate candidate) {
		logger.info("Saved: " + !StringUtils.isEmpty(candidate.toString()));
		return false;
	}

	@Override
	public Candidate save(Candidate e) {
		return candidateRepository.save(e);
	}

	@Override
	public Candidate edit(Long id, Candidate candidate) {
		if (id != null && candidate != null) {
			Optional<Candidate> result = findById(id);

			if (result.isPresent()) {
				candidate.setId(id);
				return candidateRepository.save(candidate);
			} else {
				throw new ResourceNotFoundException("ClientTypee não existe");
			}
		}
		return null;
	}

	@Override
	public Optional<Candidate> findById(Long id) {
		return candidateRepository.findById(id);
	}

	@Override
	@Cacheable("candidatesInCache")
	public List<Candidate> listAll() {
		Iterable<Candidate> itr = candidateRepository.findAll();
		return (List<Candidate>) itr;
	}

	@Override
	@Cacheable("candidatesInCache")
	public Page<Candidate> findAllPageable(Pageable pageable) {
		return candidateRepository.findAll(pageable);
	}

	@Override
	public boolean remove(Long id) {
		Optional<Candidate> result = findById(id);

		if (result != null) {
			candidateRepository.existsById(id);
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

	@Override
	public Optional<Candidate> findByName(String name) {
		return candidateRepository.findByName(name);
	}

}
