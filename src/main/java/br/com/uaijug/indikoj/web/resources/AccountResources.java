package br.com.uaijug.indikoj.web.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import br.com.uaijug.indikoj.model.service.AccountService;
import br.com.uaijug.indikoj.web.dto.AccountDTO;

@RestController
@RequestMapping("/register")
public class AccountResources {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Timed
	public ResponseEntity<Boolean> register(@RequestBody AccountDTO accountDTO) {
    	boolean registered = accountService.register(accountDTO);
    	return new ResponseEntity<>(registered, HttpStatus.CREATED);
	}
}