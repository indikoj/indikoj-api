package br.com.uaijug.indikoj.web.resources;

import java.util.List;

import javax.validation.Valid;

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
import br.com.uaijug.indikoj.web.dto.JobOpportunityDTO;
import br.com.uaijug.indikoj.web.dto.form.JobOpportunityFormDTO;
import br.com.uaijug.indikoj.web.support.JobOpportunitySupport;

@RestController
@RequestMapping("/job-opportunities")
public class JobOpportunityResource {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JobOpportunitySupport conversionSupport;

	@PreAuthorize("permitAll")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Timed
	public ResponseEntity<List<JobOpportunityDTO>> list() {
		List<JobOpportunityDTO> companyTypes = conversionSupport.list();

		if (companyTypes != null) {
			logger.info("Total Retornado: " + companyTypes.size());
			return ResponseEntity.ok(companyTypes);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PreAuthorize("permitAll")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Timed
	public ResponseEntity<JobOpportunityDTO> get(@PathVariable("id") Long id) {
		JobOpportunityDTO result = conversionSupport.convertToFindById(id);

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
	@CacheEvict(value = "jobOpportunitysInCache", allEntries = true)
	public ResponseEntity<JobOpportunityDTO> add(@Valid @RequestBody JobOpportunityFormDTO jobOpportunity) {
		JobOpportunityDTO result = conversionSupport.convertToCreate(jobOpportunity);

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
	@CacheEvict(value = "jobOpportunitysInCache", allEntries = true)
	public ResponseEntity<JobOpportunityDTO> change(@PathVariable("id") Long id,
			@RequestBody JobOpportunityFormDTO jobOpportunity) {
		JobOpportunityDTO result = conversionSupport.convertToChange(id, jobOpportunity);
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
	@CacheEvict(value = "jobOpportunitysInCache", allEntries = true)
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
	public ResponseEntity<JobOpportunityDTO> findByName(@PathVariable("name") String name) {
		JobOpportunityDTO result = conversionSupport.convertToFindByName(name);

		if (result != null) {
			logger.info("Total Retornado: " + result.toString());
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}
