package br.com.uaijug.indikoj.web.convert.to;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.CompanyType;
import br.com.uaijug.indikoj.web.dto.CompanyTypeDTO;

@Component
public class ClientTypeDTOToClientTypeConverter implements Converter<CompanyTypeDTO, CompanyType> {

	@Override
	public CompanyType convert(CompanyTypeDTO source) {
		CompanyType target = new CompanyType();

		target.setId(source.getId());
		target.setName(source.getName());

		return target;
	}

}
