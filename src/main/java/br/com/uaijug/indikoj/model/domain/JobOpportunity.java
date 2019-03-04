package br.com.uaijug.indikoj.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "job_opportunity")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true, of = { "name", "code" })
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobOpportunity extends AudityEntity {

	private static final long serialVersionUID = -7030639047749953619L;

	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String code;
	@Getter
	@Setter
	@Column(name = "short_description")
	private String shortDescription;

	@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id", scope = Company.class)
	@ManyToOne
	@JoinColumn(name = "company_id")
	@Getter
	@Setter
	private Company company;

	public void update(JobOpportunity jobOpportunity) {
		this.name = jobOpportunity.getName();
		this.code = jobOpportunity.getCode();
		this.shortDescription = jobOpportunity.getShortDescription();
		this.company = jobOpportunity.getCompany();
	}

}
