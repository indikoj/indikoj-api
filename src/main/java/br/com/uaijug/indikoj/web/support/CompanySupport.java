package br.com.uaijug.indikoj.web.support;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.Company;
import br.com.uaijug.indikoj.model.service.CompanyService;
import br.com.uaijug.indikoj.web.dto.CompanyDTO;
import br.com.uaijug.indikoj.web.dto.form.CompanyFormDTO;

@Component
public class CompanySupport {

	private static final Logger log = LogManager.getLogger(CompanySupport.class);

	@Autowired
	private CompanyService service;

	@Autowired
	private ConversionService clientConvertDTO;
	
	@Autowired
	private ConversionService clientConvert;
	
	public CompanyDTO convertToFindById(Long id) {
		Optional<Company> companyType = service.findById(id);
		CompanyDTO founded = clientConvert.convert(companyType.get(), CompanyDTO.class);
		log.info("Company: " + founded.toString());
		return founded;
	}

	public CompanyDTO convertToFindByName(String name) {
		Optional<Company> client = service.findByName(name);
		CompanyDTO founded = clientConvertDTO.convert(client.get(), CompanyDTO.class);
		log.info("Company: " + founded.toString());
		return founded;
	}

	public List<CompanyDTO> list() {
		List<CompanyDTO> clients = new ArrayList<>();
		service.listAll().forEach(client -> {
			CompanyDTO saved = clientConvertDTO.convert(client, CompanyDTO.class);
			clients.add(saved);
		});
		return clients;
	}

	public CompanyDTO convertToCreate(CompanyFormDTO clientDTO) {
		Company client = clientConvert.convert(clientDTO, Company.class);
		Company saved = service.save(client);
		CompanyDTO result = getConverter(saved);
		return result;
	}

	private CompanyDTO getConverter(Company client) {
		return clientConvertDTO.convert(client, CompanyDTO.class);
	}

	public CompanyDTO convertToChange(Long id, CompanyFormDTO companyFormDTO) {
		Company client = clientConvertDTO.convert(companyFormDTO, Company.class);
		Company result = service.edit(id, client);
		return clientConvertDTO.convert(result, CompanyDTO.class);
	}

	public boolean remove(Long id) {
		return service.remove(id);
	}
}
