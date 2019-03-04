package br.com.uaijug.indikoj.web.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import br.com.uaijug.indikoj.web.dto.UserDTO;
import br.com.uaijug.indikoj.web.support.UserSupport;

@RestController
@RequestMapping("/users")
public class UserResource {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserSupport userSupport;

	@RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Timed
	public ResponseEntity<UserDTO> getUserByUsername(@PathVariable("username") String username) {
		UserDTO user = userSupport.findUserByUsername(username);

		if (user != null) {
			logger.info("Total Retornado: " + user.toString());
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Timed
	public ResponseEntity<List<UserDTO>> list() {
		List<UserDTO> users = userSupport.list();

		if (users != null) {
			logger.info("Total Retornado: " + users.size());
			return ResponseEntity.ok(users);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}
