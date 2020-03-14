/**
 * 
 */
package com.paurush.mne.services;

import java.util.List;

import com.paurush.mne.models.Barrack;

/**
 * @author Paul
 *
 */
public interface BarrackServiceI {
	
	public Barrack save(Barrack barrack);
	
	public List<Barrack> list();
	
	public Barrack findById(Long id);
	
	public void deleteById(Long id);

}
