package net.azalea.springbootdesignpattern;

import net.azalea.springbootdesignpattern.service.impl.MyHandler;

/**
 * 责任链模式
 * @author user
 *
 */
public class Application {
	public static void main(String[] args) {
		MyHandler h1 = new MyHandler("张一",100);
		MyHandler h2 = new MyHandler("张二",200);
		MyHandler h3 = new MyHandler("张三",300);
		h1.setHandler(h2);
		h2.setHandler(h3);
		h1.operator(129);
	}
}
