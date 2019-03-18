package br.com.uaijug.indikoj.web.dto;

import java.io.Serializable;

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
@ToString
@Data
public class AccountDTO implements Serializable {
	private static final long serialVersionUID = -5623786798388768855L;
	
	@Getter @Setter private String email;
	@Getter @Setter private String password;
	@Getter
	@Setter
	private String userType;
}
