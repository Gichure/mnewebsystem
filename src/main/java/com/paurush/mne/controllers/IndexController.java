/**
 * 
 */
package com.paurush.mne.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	 
}
