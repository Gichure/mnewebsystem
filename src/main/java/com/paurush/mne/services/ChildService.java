/**
 * 
 */
package com.paurush.mne.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paurush.mne.models.Child;
import com.paurush.mne.repositories.ChildRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 *
 */
@Service
@RequiredArgsConstructor
public class ChildService implements ChildServiceI{
	
	@Autowired
	private ChildRepository repository;

	@Override
	public Child save(Child child) {
		return repository.save(child);
	}

	@Override
	public List<Child> list() {
		return repository.findAll();
	}

}
