package net.azalea.springbootdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.azalea.springbootdynamic.dynamic.DynamicProxy;
import net.azalea.springbootdynamic.service.Subject;
import net.azalea.springbootdynamic.service.impl.RealSubject;


@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		Subject realSubject = new RealSubject();
		InvocationHandler handler = new DynamicProxy(realSubject);
		Subject subject = 
				(Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
						realSubject.getClass().getInterfaces(), handler);
		System.out.println("class name:"+ subject.getClass().getName());
		subject.rent();
		subject.hello("world");
	}
}
