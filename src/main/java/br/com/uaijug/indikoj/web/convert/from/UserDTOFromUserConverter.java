package br.com.uaijug.indikoj.web.convert.from;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.User;
import br.com.uaijug.indikoj.web.dto.UserDTO;

@Component
public class UserDTOFromUserConverter implements Converter<User, UserDTO> {

	@Override
	public UserDTO convert(User source) {
		UserDTO target = new UserDTO();

		target.setId(source.getId());
		target.setEmail(source.getEmail());
		target.setPassword(source.getPassword());

		return target;
	}

}
