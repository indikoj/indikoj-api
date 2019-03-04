package br.com.uaijug.indikoj.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "candidate")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true, of = { "name", "email" })
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data public class Candidate extends AudityEntity {

	private static final long serialVersionUID = 225176755550680077L;

	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String email;
	@Getter
	@Setter
	private String mobile;
	@Getter
	@Setter
	@Column(name = "short_competences")
	private String shortCompetences;
	@NotNull
	@Getter
	@Setter
	private String curriculum;
	@Getter
	@Setter
	@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id", scope = Company.class)
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	public void update(Candidate candidate) {
		this.name = candidate.getName();
		this.email = candidate.getEmail();
		this.mobile = candidate.getMobile();
		this.shortCompetences = candidate.getShortCompetences();
		this.curriculum = candidate.getCurriculum();
		this.company = candidate.getCompany();
	}

}
