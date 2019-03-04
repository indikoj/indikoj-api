package br.com.uaijug.indikoj.web.dto;

import br.com.uaijug.indikoj.model.domain.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true, of = { "name", "code" })
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobOpportunityDTO {

	@Getter @Setter private Long id;
	@Getter @Setter private String name;
	@Getter @Setter private String code;
	@Getter @Setter private String shortDescription;
	@Getter @Setter private Company company;
}
