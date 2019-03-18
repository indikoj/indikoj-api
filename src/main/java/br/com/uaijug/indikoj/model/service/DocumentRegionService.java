package br.com.uaijug.indikoj.model.service;

import java.util.List;
import java.util.Optional;

import br.com.uaijug.indikoj.model.domain.DocumentRegion;

public interface DocumentRegionService {
	Optional<List<DocumentRegion>> all();
}
