package br.com.uaijug.indikoj.web.dto;

import br.com.uaijug.indikoj.model.domain.User;
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
@ToString(callSuper = true, of = { "id", "roleName", "user" })
@Data
public class UserRoleDTO {

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String roleName;

	@Getter
	@Setter
	private User user;

}
