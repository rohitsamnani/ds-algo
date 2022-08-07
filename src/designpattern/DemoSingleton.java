package designpattern;

import java.io.Serializable;

public class DemoSingleton implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//in case any one try to coming via Reflection
	private DemoSingleton() {
		getInstance();
	}
	
	private static final class InnerDemoInstance{
		private static final DemoSingleton INSTANCE = new DemoSingleton(); 
	}
	
	public static DemoSingleton getInstance() {
		return InnerDemoInstance.INSTANCE;
	}
	
	//during deserilizable , a new instance is always gets create, to stop that we need to override readResolve Method and return same object only
	
	protected Object readResolve() {
		return getInstance();
	}
	
	//stop cloning as if someone try to clone, override clone method and thrwo exception.
	@Override
	protected Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
	
}