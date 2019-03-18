package br.com.uaijug.indikoj.web.convert.form;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.Company;
import br.com.uaijug.indikoj.model.domain.CompanyType;
import br.com.uaijug.indikoj.model.domain.DocumentRegion;
import br.com.uaijug.indikoj.model.domain.PersonType;
import br.com.uaijug.indikoj.model.service.CompanyTypeService;
import br.com.uaijug.indikoj.web.dto.form.CompanyFormDTO;

@Component
public class CompanyFormDTOToCompanyConverter implements Converter<CompanyFormDTO, Company> {

	@Autowired
	private CompanyTypeService service;

	@Override
	public Company convert(CompanyFormDTO source) {
		Company target = new Company();

		target.setName(source.getName());
		target.setEmail(source.getEmail());
		target.setAddress(source.getAddress());

		if (source.getCompanyTypeId() != null && source.getCompanyTypeId().intValue() > 0) {
			Optional<CompanyType> companyType = service.findById(source.getCompanyTypeId());
			if (companyType.isPresent()) {
				target.setCompanyType(companyType.get());
			}
		}
		
		target.setPersonType(PersonType.get(source.getPersonType()));
		target.setPhone(source.getPhone());
		target.setMobile(source.getMobile());
		target.setDocumentRegion(DocumentRegion.get(source.getDocumentRegion()));
		target.setSocialId(source.getSocialId());
		target.setNationality(source.getNationality());

		return target;
	}

}
