package utech.potato_server;

import org.glassfish.jersey.server.ResourceConfig;

public class MyResourceConfig extends ResourceConfig{
	public MyResourceConfig() {
        register(new MyApplicationBinder());
        packages(true, "utech.potato_server");
    }

}
