package br.com.uaijug.indikoj.web.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.codahale.metrics.annotation.Timed;

import br.com.uaijug.indikoj.constants.AppConstants;
import br.com.uaijug.indikoj.web.dto.CompanyTypeDTO;
import br.com.uaijug.indikoj.web.dto.form.CompanyTypeFormDTO;
import br.com.uaijug.indikoj.web.support.CompanyTypeSupport;

@RestController
@RequestMapping(path = "/company-types")
public class CompanyTypeResources {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CompanyTypeSupport conversionSupport;

	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@Timed
	public ResponseEntity<List<CompanyTypeDTO>> getAll() {
		List<CompanyTypeDTO> result = conversionSupport.list();

		if (result != null) {
			logger.info("Total Retornado: " + result.size());
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PreAuthorize("permitAll")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Timed
	public ResponseEntity<CompanyTypeDTO> get(@PathVariable("id") Long id) {
		CompanyTypeDTO result = conversionSupport.convertToFindById(id);
		
		if (result != null) {
			logger.info("Total Retornado: " + result.toString());
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Timed
	@CacheEvict(value = "companysTypesInCache", allEntries = true)
	public ResponseEntity<CompanyTypeDTO> add(@Valid @RequestBody CompanyTypeFormDTO companyTypeDTO) {
		CompanyTypeDTO result = conversionSupport.convertToCreate(companyTypeDTO);

		if (result != null) {
			logger.info("Total Retornado: " + result.toString());
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
					.toUri();
			return ResponseEntity.created(location).body(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Timed
	@CacheEvict(value = "companysTypesInCache", allEntries = true)
	public ResponseEntity<CompanyTypeDTO> change(@PathVariable Long id, @RequestBody CompanyTypeDTO companyTypeDTO) {
		CompanyTypeDTO result = conversionSupport.convertToChange(id, companyTypeDTO);
		
		if (result != null) {
			logger.info("Total Retornado: " + result.toString());
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Timed
	@CacheEvict(value = "companysTypesInCache", allEntries = true)
	public ResponseEntity<?> remove(@PathVariable Long id) {
		boolean result = conversionSupport.remove(id);
		if (result) {
			return ResponseEntity.ok(AppConstants.DADOS_DELETADOS);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping(path = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Timed
	public ResponseEntity<CompanyTypeDTO> findByName(@PathVariable("name") String name) {
		CompanyTypeDTO result = conversionSupport.convertToFindByName(name);
		
		if (result != null) {
			logger.info("Total Retornado: " + result.toString());
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}
