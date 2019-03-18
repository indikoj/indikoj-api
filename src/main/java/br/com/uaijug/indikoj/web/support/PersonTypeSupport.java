package br.com.uaijug.indikoj.web.support;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.PersonType;
import br.com.uaijug.indikoj.model.service.PersonTypeService;
import br.com.uaijug.indikoj.web.dto.PersonTypeDTO;

@Component
public class PersonTypeSupport {

	private static final Logger log = LogManager.getLogger(CompanyTypeSupport.class);

	@Autowired
	private PersonTypeService service;

	@Autowired
	private ConversionService documentRegionConvert;

	public List<PersonTypeDTO> list() {
		List<PersonTypeDTO> documentRegions = new ArrayList<>();
		Optional<List<PersonType>> list = service.all();
		
		if (list.isPresent()) {
			list.get().forEach(documentRegion -> {
				PersonTypeDTO saved = documentRegionConvert.convert(documentRegion, PersonTypeDTO.class);
				documentRegions.add(saved);
			});
			
			log.info(documentRegions.size());
			return documentRegions;
		}
		
		return Collections.emptyList();
	}
}
