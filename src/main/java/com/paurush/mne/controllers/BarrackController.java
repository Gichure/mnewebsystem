/**
 * 
 */
package com.paurush.mne.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.paurush.mne.models.Barrack;
import com.paurush.mne.services.BarrackServiceI;

/**
 * @author Paul
 *
 */
@Controller
public class BarrackController {

	@Autowired
	private BarrackServiceI barrackService;
	
	@PostMapping(value = "/barrack")
	public String save(@ModelAttribute Barrack barrack, Model model) {
		barrackService.save(barrack);
		model.addAttribute("barracks", barrackService.list());
		return "barracks";
	}
	
	
}
