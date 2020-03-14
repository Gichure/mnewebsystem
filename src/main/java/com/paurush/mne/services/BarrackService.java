/**
 * 
 */
package com.paurush.mne.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paurush.mne.models.Barrack;
import com.paurush.mne.repositories.BarrackRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Paul
 *
 */
@Service
@RequiredArgsConstructor
public class BarrackService implements BarrackServiceI{
	
	@Autowired
	private BarrackRepository repository;

	@Override
	public Barrack save(Barrack barrack) {
		return repository.save(barrack);
	}

	@Override
	public List<Barrack> list() {
		return repository.findAll();
	}

	@Override
	public Barrack findById(Long id) {
		return repository.getOne(id);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	

}
