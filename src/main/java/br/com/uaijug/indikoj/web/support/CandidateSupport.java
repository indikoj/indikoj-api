package br.com.uaijug.indikoj.web.support;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.Candidate;
import br.com.uaijug.indikoj.model.service.CandidateService;
import br.com.uaijug.indikoj.web.dto.CandidateDTO;
import br.com.uaijug.indikoj.web.dto.form.CandidateFormDTO;

@Component
public class CandidateSupport {

	private static final Logger log = LogManager.getLogger(CandidateSupport.class);

	@Autowired
	private CandidateService service;

	@Autowired
	private ConversionService candidateConvertDTO;
	
	@Autowired
	private ConversionService candidateConvert;
	
	public CandidateDTO convertToFindById(Long id) {
		Optional<Candidate> companyType = service.findById(id);
		CandidateDTO founded = candidateConvert.convert(companyType.get(), CandidateDTO.class);
		log.info("Candidate" + founded.toString());
		return founded;
	}

	public CandidateDTO convertToFindByName(String name) {
		Optional<Candidate> candidate = service.findByName(name);
		CandidateDTO founded = candidateConvertDTO.convert(candidate.get(), CandidateDTO.class);
		log.info("Candidate: " + founded.toString());
		return founded;
	}

	public List<CandidateDTO> list() {
		List<CandidateDTO> candidates = new ArrayList<>();
		service.listAll().forEach(candidate -> {
			CandidateDTO saved = candidateConvertDTO.convert(candidate, CandidateDTO.class);
			candidates.add(saved);
		});
		return candidates;
	}

	public CandidateDTO convertToCreate(CandidateFormDTO candidateDTO) {
		Candidate candidate = candidateConvert.convert(candidateDTO, Candidate.class);
		Candidate saved = service.save(candidate);
		CandidateDTO result = getConverter(saved);
		return result;
	}

	private CandidateDTO getConverter(Candidate candidate) {
		return candidateConvertDTO.convert(candidate, CandidateDTO.class);
	}

	public CandidateDTO convertToChange(Long id, CandidateFormDTO candidateDTO) {
		Candidate candidate = candidateConvert.convert(candidateDTO, Candidate.class);
		Candidate updated = service.edit(id, candidate);
		CandidateDTO result = getConverter(updated);
		return candidateConvertDTO.convert(result, CandidateDTO.class);
	}

	public boolean remove(Long id) {
		return service.remove(id);
	}
}
