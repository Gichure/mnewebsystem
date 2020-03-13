/**
 * 
 */
package com.paurush.mne.services;

import java.util.List;

import com.paurush.mne.models.StreetFamily;

/**
 * @author Paul
 *
 */
public interface StreetFamilyServiceI {
	
	public StreetFamily save(StreetFamily family);
	
	public List<StreetFamily> list();

}
