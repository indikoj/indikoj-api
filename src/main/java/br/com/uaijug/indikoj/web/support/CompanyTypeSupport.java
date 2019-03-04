package br.com.uaijug.indikoj.web.support;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.CompanyType;
import br.com.uaijug.indikoj.model.service.CompanyTypeService;
import br.com.uaijug.indikoj.web.dto.CompanyTypeDTO;
import br.com.uaijug.indikoj.web.dto.form.CompanyTypeFormDTO;

@Component
public class CompanyTypeSupport {

	private static final Logger log = LogManager.getLogger(CompanyTypeSupport.class);

	@Autowired
	private CompanyTypeService service;

	@Autowired
	private ConversionService companyTypeConvert;

	public CompanyTypeDTO convertToFindById(Long id) {
		Optional<CompanyType> companyType = service.findById(id);
		CompanyTypeDTO founded = companyTypeConvert.convert(companyType.get(), CompanyTypeDTO.class);
		log.info("CompanyType: " + founded.toString());
		return founded;
	}
	
	public CompanyTypeDTO convertToFindByName(String name) {
		Optional<CompanyType> companyType = service.findByName(name);
		CompanyTypeDTO founded = companyTypeConvert.convert(companyType.get(), CompanyTypeDTO.class);
		log.info("CompanyType: " + founded.toString());
		return founded;
	}

	public List<CompanyTypeDTO> list() {
		List<CompanyTypeDTO> companyTypes = new ArrayList<>();
		service.listAll().forEach(companyType -> {
			CompanyTypeDTO saved = companyTypeConvert.convert(companyType, CompanyTypeDTO.class);
			companyTypes.add(saved);
		});
		return companyTypes;
	}

	public CompanyTypeDTO convertToCreate(CompanyTypeFormDTO clientTypeDTO) {
		CompanyType clientType = companyTypeConvert.convert(clientTypeDTO, CompanyType.class);
		CompanyType result = service.save(clientType);
		return companyTypeConvert.convert(result, CompanyTypeDTO.class);
	}

	public CompanyTypeDTO convertToChange(Long id, CompanyTypeDTO clientTypeDTO) {
		CompanyType clientType = companyTypeConvert.convert(clientTypeDTO, CompanyType.class);
		CompanyType result = service.edit(id, clientType);
		return companyTypeConvert.convert(result, CompanyTypeDTO.class);
	}

	public boolean remove(Long id) {
		return service.remove(id);	
	}
}
