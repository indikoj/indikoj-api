package br.com.uaijug.indikoj.web.convert.from;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.Company;
import br.com.uaijug.indikoj.web.dto.CompanyDTO;

@Component
public class CompanyDTOFromCompanyConverter implements Converter<Company, CompanyDTO> {

	//@Autowired
	//private ConversionService service;

	@Override
	public CompanyDTO convert(Company source) {
		CompanyDTO target = new CompanyDTO();

		target.setId(source.getId());
		target.setName(source.getName());
		target.setEmail(source.getEmail());
		target.setAddress(source.getAddress());
		//ClientType clienteType = service.convert(source.getClientType(), ClientType.class);
		//target.setClientType(clienteType);
		target.setPersonType(source.getPersonType());
		target.setPhone(source.getPhone());
		target.setMobile(source.getMobile());
		target.setDocumentRegion(source.getDocumentRegion());
		target.setSocialId(source.getSocialId());
		target.setNationality(source.getNationality());

		return target;
	}

}
