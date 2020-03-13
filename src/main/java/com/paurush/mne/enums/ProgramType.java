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
public enum ProgramType {
	
	BOARDING("Boarding school"),
	DAY("Primary school"),
	LUNCH("Lunch program");
	
	private String name;

}
