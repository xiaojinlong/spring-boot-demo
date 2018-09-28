package net.azalea.springbootclassloader;

import net.azalea.springbootclassloader.classloader.SimpleClassLoader;

public class Application {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		SimpleClassLoader scl = new SimpleClassLoader();
		Class<?> c = scl.loadClass("abc.jied");
		System.out.println(c);
	}

}
