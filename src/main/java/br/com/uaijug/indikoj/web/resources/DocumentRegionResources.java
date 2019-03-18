package br.com.uaijug.indikoj.web.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import br.com.uaijug.indikoj.web.dto.DocumentRegionDTO;
import br.com.uaijug.indikoj.web.support.DocumentRegionSupport;

@RestController
@RequestMapping(path = "/document-regions")
public class DocumentRegionResources {
private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DocumentRegionSupport conversionSupport;

	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@Timed
	public ResponseEntity<List<DocumentRegionDTO>> getAll() {
		List<DocumentRegionDTO> result = conversionSupport.list();

		if (result != null) {
			logger.info("Total Retornado: " + result.size());
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
