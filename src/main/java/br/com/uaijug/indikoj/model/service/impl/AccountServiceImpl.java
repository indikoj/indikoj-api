package br.com.uaijug.indikoj.model.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uaijug.indikoj.model.domain.User;
import br.com.uaijug.indikoj.model.domain.UserRole;
import br.com.uaijug.indikoj.model.repository.UserRepository;
import br.com.uaijug.indikoj.model.repository.UserRoleRepository;
import br.com.uaijug.indikoj.model.service.AccountService;
import br.com.uaijug.indikoj.model.service.PasswordCrypto;
import br.com.uaijug.indikoj.web.dto.AccountDTO;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private PasswordCrypto passwordCrypto;

	@Override
	public boolean register(AccountDTO accountDTO) {

		User userSaved = registerUser(accountDTO);
		UserRole roleSaved = setRoleByUser(accountDTO, userSaved);

		return ((roleSaved != null) && (userSaved != null));
	}

	private UserRole setRoleByUser(AccountDTO accountDTO, User userSaved) {
		UserRole role = new UserRole();

		role.setRoleName(accountDTO.getUserType());
		role.setUser(userSaved);

		return userRoleRepository.save(role);
	}

	private User registerUser(AccountDTO accountDTO) {
		User user = new User();

		user.setEmail(accountDTO.getEmail());
		String cryptoPassword = passwordCrypto.encrypt(accountDTO.getPassword());
		user.setPassword(cryptoPassword);

		return userRepository.save(user);
	}
}
