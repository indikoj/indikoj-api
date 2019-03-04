package br.com.uaijug.indikoj.web.dto.form;

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
@Data public class CandidateFormDTO {

	@Getter @Setter private String name;
	@Getter @Setter private String email;
	@Getter @Setter private String mobile;
	@Getter @Setter private String shortCompetences;
	@Getter @Setter private String curriculum;
	@Getter @Setter private Long companyId;

}
