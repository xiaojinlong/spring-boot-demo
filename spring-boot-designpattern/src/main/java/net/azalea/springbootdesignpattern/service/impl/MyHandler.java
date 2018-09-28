package net.azalea.springbootdesignpattern.service.impl;

import net.azalea.springbootdesignpattern.pattern.AbstractHandler;
import net.azalea.springbootdesignpattern.service.Handler;

public class MyHandler extends AbstractHandler<MyHandler> implements Handler {

	private String name;

    private int money;
    
    public MyHandler(String name, int money) {
        super();
        this.name = name;
        this.money = money;
    }
	
	@Override
	public void operator(int receive) {
		// TODO Auto-generated method stub
		if(money >= receive){
            System.out.println(name+"处理了此审批");
        }else{
            if(super.getHandler()!=null){
                getHandler().operator(receive);
            }else{
                System.out.println("没有人有权利审批");
            }
        }
	}

}
