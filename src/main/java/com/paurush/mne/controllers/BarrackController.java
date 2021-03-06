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

import com.paurush.mne.models.Barrack;
import com.paurush.mne.services.BarrackServiceI;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Paul
 *
 */
@Slf4j
@Controller
public class BarrackController {
	
	@Autowired
	private BarrackServiceI service;
	
	@PostMapping(value = "/barrack")
	public String save(@ModelAttribute Barrack barrack, Model model) {
		barrack = service.save(barrack);
		return "redirect:/barracks";
	}
	
	@GetMapping(value = "/barracks")
	public String list(Model model) {
		model.addAttribute("barracks", service.list());	
		log.info("Barracks: "+service.list().size());
		return "barracks";
	}
	
	@GetMapping(value = {"/barrack","/barrack/{id}"})
	public String barrack(Model model,@PathVariable Optional<Long> id) {
		if (id.isPresent()) {
			log.info("Editting "+id.get());
			Barrack barrack = service.findById(id.get());
			if(barrack == null)
				barrack = Barrack.builder().build();		
			model.addAttribute("barrack",barrack);	
        } else {
        	log.info("New record ... ");
        	model.addAttribute("barrack", Barrack.builder().build());
        }
		return "barrack";
	}
	
	@RequestMapping(value = "/barrack/delete/{id}")
	public String delete(@PathVariable("id") Long id, Model model){		
		log.info("Deleting ... "+id);
		service.deleteById(id);
		return "redirect:/barracks";
	}
	
}
