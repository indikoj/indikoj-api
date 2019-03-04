package br.com.uaijug.indikoj.web.convert.form;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.exception.ResourceNotFoundException;
import br.com.uaijug.indikoj.model.domain.Company;
import br.com.uaijug.indikoj.model.domain.JobOpportunity;
import br.com.uaijug.indikoj.model.repository.CompanyRepository;
import br.com.uaijug.indikoj.web.dto.form.JobOpportunityFormDTO;

@Component
public class JobOpportunityFormDTOToJobOpportunityConverter
		implements Converter<JobOpportunityFormDTO, JobOpportunity> {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public JobOpportunity convert(JobOpportunityFormDTO source) {
		JobOpportunity jobOpportunity = new JobOpportunity();

		jobOpportunity.setName(source.getName());
		jobOpportunity.setCode(source.getCode());
		jobOpportunity.setShortDescription(source.getShortDescription());

		if (source.getCompanyId() != null && source.getCompanyId().intValue() > 0) {
			Optional<Company> company = companyRepository.findById(source.getCompanyId());
			if (company.isPresent()) {
				jobOpportunity.setCompany(company.get());
			} else {
				throw new ResourceNotFoundException("Empresa nao encontrada");
			}
		}

		return jobOpportunity;
	}

}
