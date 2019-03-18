package br.com.uaijug.indikoj.web.resources;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import br.com.uaijug.indikoj.constants.AppConstants;
import br.com.uaijug.indikoj.web.dto.CompanyDTO;
import br.com.uaijug.indikoj.web.dto.form.CompanyFormDTO;
import br.com.uaijug.indikoj.web.support.CompanySupport;

@RestController
@RequestMapping(path = "/companys")
public class CompanyResources {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CompanySupport conversionSupport;

	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@Timed
	public ResponseEntity<List<CompanyDTO>> getAll() {
		List<CompanyDTO> result = conversionSupport.list();

		if (result != null) {
			logger.info("Total Retornado: " + result.size());
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	//@PreAuthorize("hasRole('ADMIN') AND hasRole('USER')")
	//@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Timed
	public ResponseEntity<CompanyDTO> get(@PathVariable("id") Long id) {
		CompanyDTO result = conversionSupport.convertToFindById(id);

		if (result != null) {
			logger.info("Total Retornado: " + result.toString());
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Timed
	@CacheEvict(value = "companysInCache", allEntries = true)
	public ResponseEntity<CompanyDTO> add(@Valid @RequestBody CompanyFormDTO companyDTO) {
		CompanyDTO result = conversionSupport.convertToCreate(companyDTO);

		if (result != null) {
			logger.info("Total Retornado: " + result.toString());
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Timed
	@CacheEvict(value = "companysInCache", allEntries = true)
	public ResponseEntity<CompanyDTO> change(@PathVariable Long id, @RequestBody CompanyFormDTO companyDTO) {
		CompanyDTO result = conversionSupport.convertToChange(id, companyDTO);

		if (result != null) {
			logger.info("Total Retornado: " + result.toString());
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Timed
	@CacheEvict(value = "companysInCache", allEntries = true)
	public ResponseEntity<?> remove(@PathVariable Long id) {
		boolean result = conversionSupport.remove(id);

		if (result) {
			return ResponseEntity.ok(AppConstants.DADOS_DELETADOS);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	/*@GetMapping(path = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Timed
	public ResponseEntity<CompanyDTO> findByName(@PathVariable("name") String name) {
		CompanyDTO result = conversionSupport.convertToFindByName(name);

		if (result != null) {
			logger.info("Total Retornado: " + result.toString());
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}*/
}
