package utech.potato_server;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class MyApplicationBinder extends AbstractBinder {

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(HelloService.class).to(IHelloService.class);
		
	}

}
