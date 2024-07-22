package com.innoventes.test.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "company")
@Entity
public class Company extends BaseEntity {

	@Id
	@SequenceGenerator(sequenceName = "company_seq", allocationSize = 1, name = "company_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	private Long id;

	@NotBlank(message = "Can not be an empty string")
	@Size(min=5, message = "Should be at least 5 characters of length")
	@Column(name = "company_name")
	private String companyName;

	@NotBlank(message = "Mandatory")
	@Email(message="Should be a valid email Id")
	@Column(name = "email")
	private String email;

	@PositiveOrZero
	@Column(name = "strength")
	private Integer strength;
	
	@Column(name = "website_url")
	private String webSiteURL;

	@Pattern(regexp = "^[a-zA-Z]}{2}[0-9]{2}[EN]?$", message = "Invalid company code format")
	@Column(name = "company_code")
	String companyCode;
}
