package br.com.uaijug.indikoj.model.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.uaijug.indikoj.constants.AppConstants;
import br.com.uaijug.indikoj.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Data
public abstract class AudityEntity implements Serializable {

	private static final long serialVersionUID = -8812000052333532897L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;

	@NotNull
	@Column(name = "created_date", nullable = false)
	@JsonIgnore
	@CreatedDate
	@Getter
	@Setter
	private LocalDateTime createdDate = DateUtil.dataToLocalDateTime(new Date());

	@NotNull
	@Column(name = "create_by")
	@JsonIgnore
	@CreatedBy
	@Getter
	@Setter
	private String createBy = AppConstants.CURRENT_USER;

	@Column(name = "last_modified_date")
	@JsonIgnore
	@LastModifiedDate
	@Getter
	@Setter
	private LocalDateTime lastModifiedDate;

	@Column(name = "last_modified_by")
	@JsonIgnore
	@LastModifiedBy
	@Getter
	@Setter
	private String lastModifiedBy;

}
