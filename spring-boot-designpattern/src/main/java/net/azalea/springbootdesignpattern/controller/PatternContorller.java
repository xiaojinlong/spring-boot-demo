package net.azalea.springbootdesignpattern.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatternContorller {

	@GetMapping("/chain")
	public String chain(){
		return "";
	}
}
