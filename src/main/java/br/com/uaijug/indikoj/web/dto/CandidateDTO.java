package br.com.uaijug.indikoj.web.dto;

import br.com.uaijug.indikoj.model.domain.Company;
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
@Data public class CandidateDTO {

	@Getter @Setter private Long id;
	@Getter @Setter private String name;
	@Getter @Setter private String email;
	@Getter @Setter private String mobile;
	@Getter @Setter private String shortCompetences;
	@Getter @Setter private String curriculum;
	@Getter
	@Setter
	private Company company;

}
