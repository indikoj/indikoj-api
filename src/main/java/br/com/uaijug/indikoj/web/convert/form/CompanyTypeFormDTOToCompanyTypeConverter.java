package br.com.uaijug.indikoj.web.convert.form;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.CompanyType;
import br.com.uaijug.indikoj.web.dto.form.CompanyTypeFormDTO;

@Component
public class CompanyTypeFormDTOToCompanyTypeConverter implements Converter<CompanyTypeFormDTO, CompanyType> {

	@Override
	public CompanyType convert(CompanyTypeFormDTO source) {
		CompanyType target = new CompanyType();

		target.setName(source.getName());

		return target;

	}

}
