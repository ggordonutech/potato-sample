package utech.potato_server;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("hello")
public class HelloResource {
	
	@Inject
	private IHelloService helloService;
	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	public class Result {
		private String name;
		private boolean success=true;
		public Result(String name) {
			this.name = name;
		}
	}
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get( @QueryParam("name") String name) {
    	Gson gson = new Gson();
        return gson.toJson(new Result(helloService.sayHello(name)));
    }

}
