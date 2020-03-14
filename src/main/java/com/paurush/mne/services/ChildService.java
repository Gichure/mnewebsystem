/**
 * 
 */
package com.paurush.mne.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paurush.mne.models.Barrack;
import com.paurush.mne.models.Child;
import com.paurush.mne.models.StreetFamily;
import com.paurush.mne.repositories.BarrackRepository;
import com.paurush.mne.repositories.ChildRepository;
import com.paurush.mne.repositories.StreetFamilyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Paul
 *
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ChildService implements ChildServiceI{
	
	@Autowired
	private ChildRepository repository;
	
	@Autowired
	private BarrackRepository barrackRepository;
	
	@Autowired
	private StreetFamilyRepository streetFamilyRepository;

	@Override
	public Child save(Child child) {
		log.info("Saving...");
		log.info("Saving..."+child.getBarrackId());
		log.info("Saving..."+child.getFamilyId());
		log.info("Saving..."+child.getGender());
		log.info("Saving..."+child.getStatus());
		log.info("Saving..."+child.getProgramType());
		log.info("Saving..."+child.getFirstName());
		log.info("Saving..."+child.getOtherNames());
		log.info("Saving..."+child.getSurname());
		try {
			if(child.getBarrackId() != null && child.getFamilyId() != null) {
				StreetFamily family = streetFamilyRepository.getOne(child.getFamilyId());
				Barrack barrack = barrackRepository.getOne(child.getBarrackId());
				child.setFamily(family);
				child.setBarrack(barrack);
				return repository.save(child);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Child> list() {
		return repository.findAll();
	}

	@Override
	public Child findById(Long id) {
		return repository.getOne(id);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
