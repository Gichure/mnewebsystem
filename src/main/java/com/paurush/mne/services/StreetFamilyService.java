/**
 * 
 */
package com.paurush.mne.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paurush.mne.models.StreetFamily;
import com.paurush.mne.repositories.StreetFamilyRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 *
 */
@Service
@RequiredArgsConstructor
public class StreetFamilyService implements StreetFamilyServiceI{
	
	@Autowired
	private StreetFamilyRepository repository;

	@Override
	public StreetFamily save(StreetFamily family) {
		return repository.save(family);
	}

	@Override
	public List<StreetFamily> list() {
		return repository.findAll();
	}

	@Override
	public StreetFamily findById(Long id) {
		return repository.getOne(id);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
