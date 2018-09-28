package net.azalea.springbootaoplog.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Configuration
@Slf4j
public class AdviceTest {
	
	@Pointcut("@annotation(net.azalea.springbootaoplog.annotation.Timer) && args(name)")
	public void webLog2(String name){}
	
	@Before("webLog2(name)")
	public void before(String name){
		log.info("entring before ..."+name);
	}
}
