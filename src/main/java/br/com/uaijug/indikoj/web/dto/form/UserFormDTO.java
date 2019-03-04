package br.com.uaijug.indikoj.web.dto.form;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(callSuper = true, of = { "email", "password" })
@Data
public class UserFormDTO implements Serializable {

	private static final long serialVersionUID = 6280539273496622196L;

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private String password;

}