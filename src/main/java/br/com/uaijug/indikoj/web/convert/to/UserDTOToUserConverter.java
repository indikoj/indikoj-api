package br.com.uaijug.indikoj.web.convert.to;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.User;
import br.com.uaijug.indikoj.web.dto.UserDTO;

@Component
public class UserDTOToUserConverter implements Converter<UserDTO, User> {

	@Override
	public User convert(UserDTO source) {
		User target = new User();

		target.setId(source.getId());
		target.setEmail(source.getEmail());
		target.setPassword(source.getPassword());

		return target;
	}

}
