/**
 * 
 */
package com.paurush.mne.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Paul
 *
 */
@Entity
@Table(name = "barracks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Barrack implements Serializable{
	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "code", unique = true, nullable = false)
	private String code;
	
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	@Column(name = "coordinates")
	private String coordinates;

}
