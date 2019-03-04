package br.com.uaijug.indikoj.web.convert.from;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.CompanyType;
import br.com.uaijug.indikoj.web.dto.CompanyTypeDTO;

@Component
public class CompanyTypeDTOFromCompanyTypeConverter implements Converter<CompanyType, CompanyTypeDTO> {

	@Override
	public CompanyTypeDTO convert(CompanyType source) {
		CompanyTypeDTO target = new CompanyTypeDTO();

		target.setId(source.getId());
		target.setName(source.getName());

		return target;

	}

}
