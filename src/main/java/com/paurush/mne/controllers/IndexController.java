/**
 * 
 */
package com.paurush.mne.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.paurush.mne.models.Barrack;
import com.paurush.mne.models.Child;
import com.paurush.mne.models.StreetFamily;

/**
 * @author Paul
 *
 */
@Controller
public class IndexController {

	@GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Thank you for visiting.");
        return "index";
    }
	
	@GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("message", "Thank you for visiting.");
        return "dashboard";
    }
	
	@GetMapping("/alleviation")
    public String alleviation(Model model) {
        model.addAttribute("message", "Thank you for visiting.");
        return "alleviation";
    }
	
	@GetMapping("/performance")
    public String performance(Model model) {
        model.addAttribute("message", "Thank you for visiting.");
        return "performance";
    }
	
	@GetMapping("/monitoring")
    public String monitoring(Model model) {
        model.addAttribute("message", "Thank you for visiting.");
        return "monitoring";
    }
	
	@GetMapping("/assessment")
    public String assessment(Model model) {
        model.addAttribute("message", "Thank you for visiting.");
        return "assessment";
    }
	 
	@GetMapping("/sitting")
    public String sitting(Model model) {
        model.addAttribute("message", "Thank you for visiting.");
        return "sitting";
    }
	
	@GetMapping(value = "/child")
	public String child(Model model) {
		model.addAttribute("child", Child.builder().build());
		return "barrack";
	}
	
	@GetMapping(value = "/barrack")
	public String barrack(Model model) {
		model.addAttribute("barrack", Barrack.builder().build());
		return "barrack";
	}
	
	@GetMapping(value = "/family")
	public String family(Model model) {
		model.addAttribute("family", StreetFamily.builder().build());
		return "family";
	}
}
