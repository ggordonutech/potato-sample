package utech.potato_server;

public class HelloService implements IHelloService{

	@Override
	public String sayHello(String name) {
		return String.format("Hello %s",name);
	}

}
