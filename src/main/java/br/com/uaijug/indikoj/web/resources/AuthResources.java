package br.com.uaijug.indikoj.web.resources;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.uaijug.indikoj.model.dto.TokenResult;
import br.com.uaijug.indikoj.model.dto.UserTO;
import br.com.uaijug.indikoj.web.support.AuthSupport;

@RestController
@RequestMapping("/auth")
public class AuthResources {

	@Autowired
	private AuthSupport authSupport;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public TokenResult login(@RequestBody UserTO userAuthentication) throws ServletException {
		return authSupport.validate(userAuthentication);
	}

}
