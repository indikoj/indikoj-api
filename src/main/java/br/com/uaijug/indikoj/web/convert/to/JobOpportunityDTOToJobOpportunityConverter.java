package br.com.uaijug.indikoj.web.convert.to;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.JobOpportunity;
import br.com.uaijug.indikoj.web.dto.JobOpportunityDTO;

@Component
public class JobOpportunityDTOToJobOpportunityConverter implements Converter<JobOpportunityDTO, JobOpportunity> {

	@Override
	public JobOpportunity convert(JobOpportunityDTO source) {
		JobOpportunity jobOpportunity = new JobOpportunity();
		
		jobOpportunity.setId(source.getId());
		jobOpportunity.setName(source.getName());
		jobOpportunity.setCode(source.getCode());
		jobOpportunity.setShortDescription(source.getShortDescription());
		jobOpportunity.setCompany(source.getCompany());
		
		return jobOpportunity;
	}

}
