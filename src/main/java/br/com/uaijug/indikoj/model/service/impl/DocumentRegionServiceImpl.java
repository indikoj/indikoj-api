package br.com.uaijug.indikoj.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.uaijug.indikoj.model.domain.DocumentRegion;
import br.com.uaijug.indikoj.model.service.DocumentRegionService;

@Service
public class DocumentRegionServiceImpl implements DocumentRegionService {

	@Override
	public Optional<List<DocumentRegion>> all() {
		List<DocumentRegion> regions= DocumentRegion.getDocumentRegions();
		return Optional.of(regions);
	}

}
