package br.com.uaijug.indikoj.web.convert.to;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.Company;
import br.com.uaijug.indikoj.model.domain.JobOpportunity;
import br.com.uaijug.indikoj.model.repository.CompanyRepository;
import br.com.uaijug.indikoj.web.dto.JobOpportunityDTO;

@Component
public class JobOpportunityDTOToJobOpportunityConverter implements Converter<JobOpportunityDTO, JobOpportunity> {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public JobOpportunity convert(JobOpportunityDTO source) {
		JobOpportunity jobOpportunity = new JobOpportunity();
		
		jobOpportunity.setId(source.getId());
		jobOpportunity.setName(source.getName());
		jobOpportunity.setCode(source.getCode());
		jobOpportunity.setShortDescription(source.getShortDescription());
		Long companyId = source.getCompanyId();

		Optional<Company> company = companyRepository.findById(companyId);

		if (company.isPresent()) {
			jobOpportunity.setCompany(company.get());
		}
		
		return jobOpportunity;
	}

}
