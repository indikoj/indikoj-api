package br.com.uaijug.indikoj.web.convert.from;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.Candidate;
import br.com.uaijug.indikoj.web.dto.CandidateDTO;

@Component
public class CandidateDTOFromCandidateConverter implements Converter<Candidate, CandidateDTO> {

	@Override
	public CandidateDTO convert(Candidate source) {
		CandidateDTO candidate = new CandidateDTO();
		
		candidate.setId(source.getId());
		candidate.setName(source.getName());
		candidate.setEmail(source.getEmail());
		candidate.setMobile(source.getMobile());
		candidate.setCurriculum(source.getCurriculum());
		candidate.setShortCompetences(source.getShortCompetences());
		candidate.setCompany(source.getCompany());
		
		return candidate;
	}

}
