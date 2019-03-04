package br.com.uaijug.indikoj.web.convert.form;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.User;
import br.com.uaijug.indikoj.web.dto.form.UserFormDTO;

@Component
public class UserFormDTOToUserConverter implements Converter<UserFormDTO, User> {

	@Override
	public User convert(UserFormDTO source) {
		User target = new User();

		target.setEmail(source.getEmail());
		target.setPassword(source.getPassword());

		return target;
	}

}
