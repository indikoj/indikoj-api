package br.com.uaijug.indikoj.web.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import br.com.uaijug.indikoj.constants.AppConstants;
import br.com.uaijug.indikoj.web.dto.CandidateDTO;
import br.com.uaijug.indikoj.web.dto.form.CandidateFormDTO;
import br.com.uaijug.indikoj.web.support.CandidateSupport;

@RestController
@RequestMapping("/candidates")
public class CandidateResource {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CandidateSupport conversionSupport;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Timed
	public ResponseEntity<List<CandidateDTO>> list() {
		List<CandidateDTO> result = conversionSupport.list();
		
		if (result != null) {
			logger.info("Total Retornado: " + result.size());
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PreAuthorize("hasRole('ADMIN') AND hasRole('USER')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Timed
	public ResponseEntity<CandidateDTO> get(@PathVariable("id") Long id) {
		CandidateDTO result = conversionSupport.convertToFindById(id);
		
		if (result != null) {
			logger.info("Total Retornado: " + result.toString());
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Timed
	@CacheEvict(value = "candidatesInCache", allEntries = true)
	public ResponseEntity<CandidateDTO> add(@RequestBody CandidateFormDTO candidate) {
		CandidateDTO result = conversionSupport.convertToCreate(candidate);
		
		if (result != null) {
			logger.info("Total Retornado: " + result.toString());
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Timed
	@CacheEvict(value = "candidatesInCache", allEntries = true)
	public ResponseEntity<CandidateDTO> change(@PathVariable("id") Long id, @RequestBody CandidateFormDTO candidate) {
		CandidateDTO result = conversionSupport.convertToChange(id, candidate);
		
		if (result != null) {
			logger.info("Total Retornado: " + result.toString());
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Timed
	@CacheEvict(value = "candidatesInCache", allEntries = true)
	public ResponseEntity<?> remove(@PathVariable("id") Long id) {
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
	public ResponseEntity<CandidateDTO> findByName(@PathVariable("name") String name) {
		CandidateDTO result = conversionSupport.convertToFindByName(name);
		
		if (result != null) {
			logger.info("Total Retornado: " + result.toString());
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}
