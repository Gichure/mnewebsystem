/**
 * 
 */
package com.paurush.mne.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paurush.mne.models.StreetFamily;
import com.paurush.mne.services.BarrackServiceI;
import com.paurush.mne.services.StreetFamilyServiceI;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Paul
 *
 */
@Slf4j
@Controller
public class StreetFamilyController {
	
	@Autowired
	private StreetFamilyServiceI service;
	
	@PostMapping(value = "/family")
	public String save(@ModelAttribute StreetFamily family, Model model) {
		family = service.save(family);
		return "redirect:/families";
	}
	
	@GetMapping(value = "/families")
	public String list(Model model) {
		model.addAttribute("families", service.list());	
		log.info("Families: "+service.list().size());
		return "families";
	}
	
	@GetMapping(value = {"/family","/family/{id}"})
	public String family(Model model,@PathVariable Optional<Long> id) {
		if (id.isPresent()) {
			log.info("Editting "+id.get());
			StreetFamily family = service.findById(id.get());
			if(family == null)
				family = StreetFamily.builder().build();		
			model.addAttribute("family",family);	
        } else {
        	log.info("New record ... ");
        	model.addAttribute("family", StreetFamily.builder().build());
        }
		return "family";
	}
	
	@RequestMapping(value = "/family/delete/{id}")
	public String delete(@PathVariable("id") Long id, Model model){		
		log.info("Deleting ... "+id);
		service.deleteById(id);
		return "redirect:/families";
	}
	
}
