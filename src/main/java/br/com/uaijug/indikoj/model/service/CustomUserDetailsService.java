package br.com.uaijug.indikoj.model.service;

import br.com.uaijug.indikoj.model.domain.User;

public interface CustomUserDetailsService {

	User loadCurrentUser();

}
