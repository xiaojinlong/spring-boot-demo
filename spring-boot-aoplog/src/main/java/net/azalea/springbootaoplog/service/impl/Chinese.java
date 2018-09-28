package net.azalea.springbootaoplog.service.impl;

import org.springframework.stereotype.Service;

import net.azalea.springbootaoplog.annotation.Timer;
import net.azalea.springbootaoplog.service.Person;

@Service
public class Chinese implements Person {

	@Timer
	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return name + "你好";
	}

}
