package br.com.uaijug.indikoj.model.service;

import br.com.uaijug.indikoj.model.domain.User;
import br.com.uaijug.indikoj.model.dto.UserTO;
import br.com.uaijug.indikoj.web.dto.UserDTO;

public interface UserService {
	User createUser(UserDTO dto);

	String validatePasswordResetToken(User user, String token);

	String changeUserPassword(User user, String token);

	boolean register(UserTO userTO);

	User findByUsernameAndPassword(String username, String password);
	
	User findByUsername(String username);
}
