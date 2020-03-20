/**
 * 
 */
package com.paurush.mne.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Paul
 *
 */
@Getter
@AllArgsConstructor
public enum Gender {
	
	FEMALE("Female"),
	MALE("Male"),
	UNKNOWN("Unknown");
	
	private String name;

}
