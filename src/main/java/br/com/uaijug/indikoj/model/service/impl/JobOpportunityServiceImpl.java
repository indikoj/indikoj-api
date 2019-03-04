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
import br.com.uaijug.indikoj.model.domain.JobOpportunity;
import br.com.uaijug.indikoj.model.repository.JobOpportunityRepository;
import br.com.uaijug.indikoj.model.service.JobOpportunityService;

@Service
public class JobOpportunityServiceImpl implements JobOpportunityService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JobOpportunityRepository jobOpportunityRepository;

	@Override
	public JobOpportunity save(JobOpportunity jobOpportunity) {
		logger.info("Saved: " + !StringUtils.isEmpty(jobOpportunity.toString()));
		return jobOpportunityRepository.save(jobOpportunity);
	}

	@Override
	public JobOpportunity edit(Long id, JobOpportunity jobOpportunity) {
		if (id != null && jobOpportunity != null) {
			Optional<JobOpportunity> result = findById(id);
			if (result.isPresent()) {
				jobOpportunity.setId(id);
				return jobOpportunityRepository.save(jobOpportunity);
			} else {
				throw new ResourceNotFoundException("ClientTypee não existe");
			}
		}
		return null;
	}

	@Override
	public Optional<JobOpportunity> findById(Long id) {
		return jobOpportunityRepository.findById(id);
	}

	@Override
	@Cacheable("jobOpportunitysInCache")
	public List<JobOpportunity> listAll() {
		return jobOpportunityRepository.findAll();
	}

	@Override
	@Cacheable("jobOpportunitysInCache")
	public Page<JobOpportunity> findAllPageable(Pageable pageable) {
		return jobOpportunityRepository.findAll(pageable);
	}

	@Override
	public boolean remove(Long id) {
		Optional<JobOpportunity> result = jobOpportunityRepository.findById(id);

		if (result.isPresent()) {
			jobOpportunityRepository.deleteById(id);
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

	@Override
	public Optional<JobOpportunity> findByName(String name) {
		return jobOpportunityRepository.findByName(name);
	}
}
