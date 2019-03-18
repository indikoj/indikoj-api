package br.com.uaijug.indikoj.web.convert.to;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.Candidate;
import br.com.uaijug.indikoj.model.domain.Company;
import br.com.uaijug.indikoj.model.repository.CompanyRepository;
import br.com.uaijug.indikoj.web.dto.CandidateDTO;

@Component
public class CandidateDTOToCandidateConverter implements Converter<CandidateDTO, Candidate> {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Candidate convert(CandidateDTO source) {
		Candidate candidate = new Candidate();

		candidate.setId(source.getId());
		candidate.setName(source.getName());
		candidate.setEmail(source.getEmail());
		candidate.setMobile(source.getMobile());
		candidate.setCurriculum(source.getCurriculum());
		candidate.setShortCompetences(source.getShortCompetences());
		Long companyId = source.getCompanyId();

		Optional<Company> company = companyRepository.findById(companyId);

		if (company.isPresent()) {
			candidate.setCompany(company.get());
		}
		
		return candidate;
	}

}
