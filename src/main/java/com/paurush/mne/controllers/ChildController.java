/**
 * 
 */
package com.paurush.mne.controllers;

import java.util.List;
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
import com.paurush.mne.models.Child;
import com.paurush.mne.models.StreetFamily;
import com.paurush.mne.services.BarrackServiceI;
import com.paurush.mne.services.ChildServiceI;
import com.paurush.mne.services.StreetFamilyServiceI;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Paul
 *
 */
@Slf4j
@Controller
public class ChildController {
	
	@Autowired
	private ChildServiceI service;
	
	@Autowired
	private BarrackServiceI barrackService;
	
	@Autowired
	private StreetFamilyServiceI familiesService;
	
	@PostMapping(value = "/child")
	public String save(@ModelAttribute Child child, Model model) {
		child = service.save(child);
		return "redirect:/children";
	}
	
	@GetMapping(value = "/children")
	public String list(Model model) {
		model.addAttribute("children", service.list());	
		log.info("Children: "+service.list().size());
		return "children";
	}
	
	@GetMapping(value = {"/child","/child/{id}"})
	public String child(Model model,@PathVariable Optional<Long> id) {
		if (id.isPresent()) {
			log.info("Editting "+id.get());
			Child child = service.findById(id.get());
			if(child == null)
				child = Child.builder().build();		
			model.addAttribute("child",child);	
        } else {
        	log.info("New record ... ");
        	List<Barrack> barracks = barrackService.list();
        	List<StreetFamily> families = familiesService.list();
        	model.addAttribute("barracks", barracks);
        	model.addAttribute("families", families);
        	model.addAttribute("child", Child.builder().build());
        }
		return "child";
	}
	
	@RequestMapping(value = "/child/delete/{id}")
	public String delete(@PathVariable("id") Long id, Model model){		
		log.info("Deleting ... "+id);
		service.deleteById(id);
		return "redirect:/children";
	}
	
}
