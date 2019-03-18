package br.com.uaijug.indikoj.web.convert.to;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.Company;
import br.com.uaijug.indikoj.model.domain.CompanyType;
import br.com.uaijug.indikoj.web.dto.CompanyDTO;
import br.com.uaijug.indikoj.web.dto.CompanyTypeDTO;

@Component
public class ClientDTOToClientConverter implements Converter<CompanyDTO, Company> {

	@Override
	public Company convert(CompanyDTO source) {
		Company target = new Company();

		target.setId(source.getId());
		target.setName(source.getName());
		target.setEmail(source.getEmail());
		target.setAddress(source.getAddress());

		if (source.getCompanyTypeId() != null) {
		//	CompanyTypeDTO dto = new CompanyTypeDTO();
		//	dto.setId(source.getCompanyType().getId());
		//	dto.setName(source.getCompanyType().getName());
		//	target.setCompanyType(convert(dto));
		}

		target.setPersonType(source.getPersonType());
		target.setPhone(source.getPhone());
		target.setMobile(source.getMobile());
		target.setDocumentRegion(source.getDocumentRegion());
		target.setSocialId(source.getSocialId());
		target.setNationality(source.getNationality());

		return target;
	}

	@SuppressWarnings("unused")
	private CompanyType convert(CompanyTypeDTO dto) {
		CompanyType companyType = new CompanyType();
		companyType.setId(dto.getId());
		companyType.setName(dto.getName());
		return companyType;
	}
}
