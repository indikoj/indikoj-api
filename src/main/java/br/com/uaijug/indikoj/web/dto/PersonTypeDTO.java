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
@ToString(callSuper = true, of = { "id", "name", "code" })
@Data
public class PersonTypeDTO implements Serializable {
	private static final long serialVersionUID = 5661601145709869372L;
	
	@Getter
	@Setter
	private Long id;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private String code;

}
