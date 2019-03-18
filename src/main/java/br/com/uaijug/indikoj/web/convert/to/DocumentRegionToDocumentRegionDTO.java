package br.com.uaijug.indikoj.web.convert.to;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.DocumentRegion;
import br.com.uaijug.indikoj.web.dto.DocumentRegionDTO;

@Component
public class DocumentRegionToDocumentRegionDTO implements Converter<DocumentRegion, DocumentRegionDTO> {

	@Override
	public DocumentRegionDTO convert(DocumentRegion source) {
		DocumentRegionDTO target = new DocumentRegionDTO();
		target.setCode(source.name());
		target.setName(source.getState());
		target.setSigla(source.getAcronym());
		return target;
	}

}
