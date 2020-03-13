/**
 * 
 */
package com.paurush.mne.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.paurush.mne.enums.Gender;
import com.paurush.mne.enums.ProgramType;
import com.paurush.mne.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Paul
 *
 */
@Entity
@Table(name = "children")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Child implements Serializable{
	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "othernames")
	private String otherNames;
		
	@Column(name = "year_enrolled", nullable = false)
	private Integer yearEnrolled;
	
	@ManyToOne(optional = false)
	private Barrack barrack;
	
	@Column(name = "gender", nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "program_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private ProgramType programType;
	
	@Column(name = "reason")
	private String reason;
	
	@ManyToOne
	private StreetFamily family;

}
