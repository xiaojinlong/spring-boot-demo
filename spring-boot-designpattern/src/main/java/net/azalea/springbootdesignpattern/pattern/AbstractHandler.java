package net.azalea.springbootdesignpattern.pattern;

public abstract class AbstractHandler<T> {

	private T t;
		
	public T getHandler(){
		return t;
	}
	
	public void setHandler(T t){
		this.t = t;
	}
}
