package net.azalea.springbootaoplog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.azalea.springbootaoplog.service.Person;

@Slf4j
@RestController
public class IndexController {
	
	@Autowired
	private Person person;

	@GetMapping({"", ""})
	public String index() {
		return "index";
	}
	
	@GetMapping("/doPeople")
	public String doPeople(@RequestParam("name") String name){
		log.info("Person class:" + person.getClass());
		return person.sayHello(name);
	}
	
	@GetMapping("/doError")
	public int doError(){
		return 1/0;
	}

}
