package br.com.uaijug.indikoj.web.dto.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import br.com.uaijug.indikoj.model.domain.DocumentRegion;
import br.com.uaijug.indikoj.model.domain.PersonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(callSuper = true, of = { "name", "email", "address", "companyTypeId", "personType", "phone",
		"mobile", "documentRegion", "socialId", "nationality" })
@Data
public class CompanyFormDTO implements Serializable {
	private static final long serialVersionUID = 3406784206187867167L;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private String address;

	@Getter
	@Setter
	private Long companyTypeId;

	@Getter
	@Setter
	private PersonType personType;

	@Getter
	@Setter
	private String phone;

	@NotNull
	@Getter
	@Setter
	private String mobile;

	@Getter
	@Setter
	private DocumentRegion documentRegion;

	@Getter
	@Setter
	private Long socialId;

	@Getter
	@Setter
	private String nationality;
}
