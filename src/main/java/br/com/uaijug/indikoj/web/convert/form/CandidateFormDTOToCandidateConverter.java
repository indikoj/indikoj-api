package br.com.uaijug.indikoj.web.convert.form;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.exception.ResourceNotFoundException;
import br.com.uaijug.indikoj.model.domain.Candidate;
import br.com.uaijug.indikoj.model.domain.Company;
import br.com.uaijug.indikoj.model.repository.CompanyRepository;
import br.com.uaijug.indikoj.web.dto.form.CandidateFormDTO;

@Component
public class CandidateFormDTOToCandidateConverter implements Converter<CandidateFormDTO, Candidate> {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public Candidate convert(CandidateFormDTO source) {
		Candidate candidate = new Candidate();
		
		candidate.setName(source.getName());
		candidate.setEmail(source.getEmail());
		candidate.setMobile(source.getMobile());
		candidate.setCurriculum(source.getCurriculum());
		candidate.setShortCompetences(source.getShortCompetences());
		
		if (source.getCompanyId() != null && source.getCompanyId().intValue() > 0) {
			Optional<Company> company = companyRepository.findById(source.getCompanyId());
			if (company.isPresent()) {
				candidate.setCompany(company.get());
			} else {
				throw new ResourceNotFoundException("Id náo encontrado");
			}
		}
		
		
		return candidate;
	}

}
