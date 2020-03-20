/**
 * 
 */
package com.paurush.mne.services;

import java.util.List;

import com.paurush.mne.models.Child;
import com.paurush.mne.models.StreetFamily;

/**
 * @author Paul
 *
 */
public interface ChildServiceI {
	
	public Child save(Child child);
	
	public List<Child> list();
	
	public Child findById(Long id);
	
	public void deleteById(Long id);
	
	public List<Child> findByYearEnrolled(Integer year, Long barrackId);
	
	

}
