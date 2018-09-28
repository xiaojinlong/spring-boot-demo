package net.azalea.springbootclassloader.classloader;

import java.io.IOException;
import java.io.InputStream;

import net.azalea.springbootclassloader.shared.Test;

public class SimpleClassLoader extends ClassLoader {


	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
//      bootstrap ext app 三个类加载器都找不到，最后还要我自己来找，那我也找不到，我就随意直接返回Test类吧
        InputStream map = Test.class.getResourceAsStream("Test.class");
        try {
            byte[] bytes = new byte[map.available()];
            map.read(bytes);
            return super.defineClass(Test.class.getName(), bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return super.loadClass(name);
	}
	
	

}
