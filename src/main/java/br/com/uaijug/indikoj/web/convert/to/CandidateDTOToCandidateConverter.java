package br.com.uaijug.indikoj.web.convert.to;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.Candidate;
import br.com.uaijug.indikoj.web.dto.CandidateDTO;

@Component
public class CandidateDTOToCandidateConverter implements Converter<CandidateDTO, Candidate> {

	@Override
	public Candidate convert(CandidateDTO source) {
		Candidate candidate = new Candidate();
		
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
