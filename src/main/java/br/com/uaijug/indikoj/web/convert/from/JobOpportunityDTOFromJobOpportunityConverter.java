package br.com.uaijug.indikoj.web.convert.from;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.JobOpportunity;
import br.com.uaijug.indikoj.web.dto.JobOpportunityDTO;

@Component
public class JobOpportunityDTOFromJobOpportunityConverter implements Converter<JobOpportunity, JobOpportunityDTO> {

	@Override
	public JobOpportunityDTO convert(JobOpportunity source) {
		JobOpportunityDTO jobOpportunity = new JobOpportunityDTO();
		
		jobOpportunity.setId(source.getId());
		jobOpportunity.setName(source.getName());
		jobOpportunity.setCode(source.getCode());
		jobOpportunity.setShortDescription(source.getShortDescription());
		jobOpportunity.setCompanyId(source.getCompany().getId());
		
		return jobOpportunity;
	}

}
