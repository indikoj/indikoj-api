package br.com.uaijug.indikoj.web.convert.to;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.uaijug.indikoj.model.domain.PersonType;
import br.com.uaijug.indikoj.web.dto.PersonTypeDTO;

@Component
public class PersonTypeToPersonTypeDTO implements Converter<PersonType, PersonTypeDTO> {

	@Override
	public PersonTypeDTO convert(PersonType source) {
		
		PersonTypeDTO target = new PersonTypeDTO();
		target.setId(Long.valueOf(source.getOrdinal()));
		target.setName(source.getName());
		target.setCode(source.name());
		
		return target;
	}

}
