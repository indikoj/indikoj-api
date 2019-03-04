package br.com.uaijug.indikoj.web.support;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.JobOpportunity;
import br.com.uaijug.indikoj.model.service.JobOpportunityService;
import br.com.uaijug.indikoj.web.dto.JobOpportunityDTO;
import br.com.uaijug.indikoj.web.dto.form.JobOpportunityFormDTO;

@Component
public class JobOpportunitySupport {

	private static final Logger log = LogManager.getLogger(JobOpportunitySupport.class);

	@Autowired
	private JobOpportunityService service;

	@Autowired
	private ConversionService jobOpportunityConvert;
	
	public JobOpportunityDTO convertToFindById(Long id) {
		Optional<JobOpportunity> companyType = service.findById(id);
		JobOpportunityDTO founded = jobOpportunityConvert.convert(companyType.get(), JobOpportunityDTO.class);
		log.info("JobOpportunity: " + founded.toString());
		return founded;
	}

	public JobOpportunityDTO convertToFindByName(String name) {
		Optional<JobOpportunity> jobOpportunity = service.findByName(name);
		JobOpportunityDTO founded = jobOpportunityConvert.convert(jobOpportunity.get(), JobOpportunityDTO.class);
		log.info("JobOpportunity: " + founded.toString());
		return founded;
	}

	public List<JobOpportunityDTO> list() {
		List<JobOpportunityDTO> jobOpportunitys = new ArrayList<>();
		service.listAll().forEach(jobOpportunity -> {
			JobOpportunityDTO saved = jobOpportunityConvert.convert(jobOpportunity, JobOpportunityDTO.class);
			jobOpportunitys.add(saved);
		});
		return jobOpportunitys;
	}

	public JobOpportunityDTO convertToCreate(JobOpportunityFormDTO jobOpportunityDTO) {
		JobOpportunity jobOpportunity = jobOpportunityConvert.convert(jobOpportunityDTO, JobOpportunity.class);
		JobOpportunity result = service.save(jobOpportunity);
		return jobOpportunityConvert.convert(result, JobOpportunityDTO.class);
	}

	public JobOpportunityDTO convertToChange(Long id, JobOpportunityFormDTO jobOpportunityDTO) {
		JobOpportunity jobOpportunity = jobOpportunityConvert.convert(jobOpportunityDTO, JobOpportunity.class);
		JobOpportunity result = service.edit(id, jobOpportunity);
		return jobOpportunityConvert.convert(result, JobOpportunityDTO.class);
	}

	public boolean remove(Long id) {
		return service.remove(id);	
	}
}
