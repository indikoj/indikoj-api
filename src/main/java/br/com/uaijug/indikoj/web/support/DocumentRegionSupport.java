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

import br.com.uaijug.indikoj.model.domain.DocumentRegion;
import br.com.uaijug.indikoj.model.service.DocumentRegionService;
import br.com.uaijug.indikoj.web.dto.DocumentRegionDTO;

@Component
public class DocumentRegionSupport {

	private static final Logger log = LogManager.getLogger(CompanyTypeSupport.class);

	@Autowired
	private DocumentRegionService service;

	@Autowired
	private ConversionService documentRegionConvert;

	public List<DocumentRegionDTO> list() {
		List<DocumentRegionDTO> documentRegions = new ArrayList<>();
		Optional<List<DocumentRegion>> list = service.all();
		
		if (list.isPresent()) {
			list.get().forEach(documentRegion -> {
				DocumentRegionDTO saved = documentRegionConvert.convert(documentRegion, DocumentRegionDTO.class);
				documentRegions.add(saved);
			});
			
			log.info(documentRegions.size());
			return documentRegions;
		}
		
		return Collections.emptyList();
	}
}
