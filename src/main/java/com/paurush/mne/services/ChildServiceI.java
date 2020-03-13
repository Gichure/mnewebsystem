/**
 * 
 */
package com.paurush.mne.services;

import java.util.List;

import com.paurush.mne.models.Child;

/**
 * @author Paul
 *
 */
public interface ChildServiceI {
	
	public Child save(Child child);
	
	public List<Child> list();

}
