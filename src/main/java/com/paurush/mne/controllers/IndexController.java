/**
 * 
 */
package com.paurush.mne.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paurush.mne.models.Barrack;
import com.paurush.mne.models.Child;
import com.paurush.mne.models.StreetFamily;
import com.paurush.mne.services.BarrackServiceI;
import com.paurush.mne.services.ChildServiceI;

/**
 * @author Paul
 *
 */
@Controller
public class IndexController {
	
	@Autowired
	private ChildServiceI service;
	
	@Autowired
	private BarrackServiceI barrackService;

	@GetMapping("/")
    public String index(Model model) {
        return "index";
    }
	
	@GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "dashboard";
    }
	
	@GetMapping("/alleviation")
    public String alleviation(Model model) {
		model.addAttribute("children", service.list());
        return "alleviation";
    }
	
	@GetMapping("/performance")
    public String performance(Model model) {
		model.addAttribute("children", service.list());
        return "performance";
    }
	
	@GetMapping("/monitoring")
    public String monitoring(Model model) {
		model.addAttribute("children", service.list());
        return "monitoring";
    }
	
	@GetMapping("/assessment")
    public String assessment(Model model, @RequestParam(value = "barrackId", required = false) Long barrackId, @RequestParam(value = "year", required = false) Integer year) {
		model.addAttribute("barracks", barrackService.list());
		model.addAttribute("children", service.findByYearEnrolled(year,barrackId));
        return "assessment";
    }
	
	@GetMapping("/siting")
    public String siting(Model model) {
		model.addAttribute("children", service.list());
        return "siting";
    }
}
