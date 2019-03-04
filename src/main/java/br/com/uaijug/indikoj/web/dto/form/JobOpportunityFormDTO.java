package br.com.uaijug.indikoj.web.dto.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true, of = { "name", "code", "shortDescription", "companyId"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobOpportunityFormDTO {

	@Getter @Setter private String name;
	@Getter @Setter private String code;
	@Getter @Setter private String shortDescription;
	@Getter @Setter private Long companyId;
}
